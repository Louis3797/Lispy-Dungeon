package dsl;

import contrib.components.InteractionComponent;
import contrib.entities.AIFactory;
import contrib.entities.MonsterBuilder;
import contrib.entities.WorldItemBuilder;
import contrib.utils.components.ai.transition.RangeTransition;
import core.Entity;
import core.Game;
import core.components.DrawComponent;
import core.components.PositionComponent;
import core.components.VelocityComponent;
import core.utils.Point;
import core.utils.components.draw.animation.Animation;
import core.utils.logging.CustomLogLevel;
import dsl.runtime.DSLRuntime;
import dsl.runtime.ast.EventType;
import dsl.utils.AnimationFactory;
import dsl.utils.EntityUtils;
import dsl.utils.PositionUtils;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.logging.Logger;

/**
 * Spawns entities from parsed DSL definitions into the game world.
 *
 * <p>
 * Creates and places: - Items from item definitions - NPCs (hostile and
 * friendly) from NPC
 * definitions - Quiz entities (chests and interactive NPCs) from quiz
 * definitions
 */
public class DSLEntitySpawner {

  private static final Logger LOGGER = Logger.getLogger(DSLEntitySpawner.class.getSimpleName());

  // Configuration constants
  private static final int DEFAULT_NPC_HEALTH = 10;
  private static final int DEFAULT_NPC_DAMAGE = 1;
  private static final String DEFAULT_HOSTILE_NPC_TEXTURE = "character/monster/chort";
  private static final String DEFAULT_FRIENDLY_NPC_TEXTURE = "character/monster/pumpkin_dude";
  private static final String DEFAULT_ITEM_TYPE = "tool";

  // Difficulty modifier instance
  private static DifficultyModifier difficultyModifier = null;

  // DSL Runtime for event firing
  private static DSLRuntime dslRuntime = null;

  /** Set the DSL Runtime instance for event firing. */
  public static void setRuntime(DSLRuntime runtime) {
    dslRuntime = runtime;
  }

  /** Fire a DSL event for an entity. */
  public static void fireEvent(EventType eventType, String entityId) {
    if (dslRuntime != null) {
      LOGGER.info("[DSL Event] " + eventType + " -> " + entityId);
      dslRuntime.fireEvent(eventType, entityId);
    }
  }

  /**
   * Spawns all entities from the DSL definition.
   *
   * @param definition The escape room definition containing entity specifications
   * @throws NullPointerException if definition is null
   */
  public static void spawnEntities(EscapeRoomDefinition definition) {
    Objects.requireNonNull(definition, "definition cannot be null");

    LOGGER.info("=== Spawning Entities ===");

    // Initialize difficulty modifier from metadata
    if (definition.metadata != null && definition.metadata.difficulty != null) {
      difficultyModifier = new DifficultyModifier(definition.metadata.difficulty);
    } else {
      difficultyModifier = new DifficultyModifier("normal");
    }

    // Spawn items
    if (definition.items != null && !definition.items.isEmpty()) {
      spawnItems(definition);
    }

    // Spawn NPCs
    if (definition.npcs != null && !definition.npcs.isEmpty()) {
      spawnNPCs(definition);
    }

    // Spawn quiz entities
    if (definition.quizzes != null && !definition.quizzes.isEmpty()) {
      spawnQuizEntities(definition);
    }

    LOGGER.info("Entity spawning complete!");
  }

  /**
   * Spawns items from the DSL definition. Items that are quiz rewards will NOT be
   * spawned on the
   * map.
   *
   * @param definition The escape room definition
   */
  private static void spawnItems(EscapeRoomDefinition definition) {
    LOGGER.info("Spawning items...");

    // Collect all items that are quiz rewards (shouldn't spawn on map)
    java.util.Set<String> quizRewardItems = new java.util.HashSet<>();
    for (Quiz quiz : definition.quizzes.values()) {
      if (quiz.reward != null && !quiz.reward.isEmpty()) {
        quizRewardItems.add(quiz.reward);
      }
    }

    for (var entry : definition.items.entrySet()) {
      String itemId = entry.getKey();
      Item itemDef = entry.getValue();

      // Skip items that are quiz rewards - they'll be given as rewards instead
      if (quizRewardItems.contains(itemId)) {
        LOGGER.log(
            CustomLogLevel.DEBUG,
            "Skipping item '" + itemId + "' (quiz reward, not spawning on map)");
        continue;
      }

      try {
        Entity itemEntity = createItemEntity(itemId, itemDef);
        if (itemEntity != null) {
          Game.add(itemEntity);
          LOGGER.info("Spawned item: " + itemId);
        }
      } catch (Exception e) {
        LOGGER.warning("Failed to spawn item " + itemId + ": " + e.getMessage());
        LOGGER.log(CustomLogLevel.DEBUG, "Item spawn error details", e);
      }
    }
  }

  /**
   * Creates an item entity from DSL definition. Wraps item collection to fire DSL
   * ON_PICKUP events.
   *
   * @param itemId  The unique identifier for the item
   * @param itemDef The item definition from DSL
   * @return The created entity, or null if creation failed
   */
  private static Entity createItemEntity(String itemId, Item itemDef) {
    // Get a random floor tile to place the item
    Point position = getRandomFloorPosition();
    if (position == null) {
      LOGGER.warning("No floor tile found for item: " + itemId);
      return null;
    }

    // Create the appropriate item based on the DSL type field
    contrib.item.Item item = createItemFromDefinition(itemId, itemDef, dslRuntime);
    if (item == null) {
      LOGGER.warning("Could not create item: " + itemId);
      return null;
    }

    // Build the world item
    Entity itemEntity = WorldItemBuilder.buildWorldItem(item, position);

    // Handle visibility
    if (!itemDef.visible) {
      itemEntity.remove(DrawComponent.class);
    }

    // Set the entity name to the item ID so it can be found by quizzes
    itemEntity.name(itemId);

    // Add interaction component to allow picking up by pressing E
    // (WorldItemBuilder adds CollideComponent for walking over)
    itemEntity.remove(InteractionComponent.class);
    itemEntity.add(
        new InteractionComponent(
            InteractionComponent.DEFAULT_INTERACTION_RADIUS,
            true,
            (entity, who) -> {
              // Fire the DSL ON_PICKUP event first
              fireEvent(EventType.ON_PICKUP, itemId);
              // Then do the normal collect behavior
              item.collect(entity, who);
            }));

    return itemEntity;
  }

  /**
   * Spawns NPCs from the DSL definition.
   *
   * @param definition The escape room definition
   */
  private static void spawnNPCs(EscapeRoomDefinition definition) {
    LOGGER.info("Spawning NPCs...");

    for (var entry : definition.npcs.entrySet()) {
      String npcId = entry.getKey();
      NPC npcDef = entry.getValue();

      // Skip NPCs without location - they are templates for dynamic spawning
      if (npcDef.location == null || npcDef.location.isEmpty()) {
        LOGGER.info("Skipping NPC " + npcId + " - no location (dynamic spawn template)");
        continue;
      }

      try {
        Entity npcEntity = createNPCEntity(npcId, npcDef);
        if (npcEntity != null) {
          Game.add(npcEntity);
          LOGGER.info("Spawned NPC: " + npcId);
        }
      } catch (Exception e) {
        LOGGER.warning("Failed to spawn NPC " + npcId + ": " + e.getMessage());
        LOGGER.log(CustomLogLevel.DEBUG, "NPC spawn error details", e);
      }
    }
  }

  /**
   * Creates an NPC entity from DSL definition.
   *
   * @param npcId  The unique identifier for the NPC
   * @param npcDef The NPC definition from DSL
   * @return The created entity, or null if creation failed
   * @throws IOException If texture loading fails
   */
  private static Entity createNPCEntity(String npcId, NPC npcDef) throws IOException {
    // Get position
    Point position = getRandomFloorPosition();
    if (position == null) {
      LOGGER.warning("No floor tile found for NPC: " + npcId);
      return null;
    }

    // Skip player NPC (hero is created separately)
    if ("player".equals(npcId)) {
      return null;
    }

    Entity npcEntity;

    if (npcDef.hostile) {
      npcEntity = createHostileNPC(npcId, npcDef, position);
    } else {
      npcEntity = createFriendlyNPC(npcId, npcDef, position);
    }

    return npcEntity;
  }

  /**
   * Creates a hostile NPC with combat capabilities. Adds onDeath callback that
   * fires DSL ON_DEATH
   * events.
   *
   * @param npcId    The NPC identifier
   * @param npcDef   The NPC definition
   * @param position The spawn position
   * @return The created hostile NPC entity
   */
  private static Entity createHostileNPC(String npcId, NPC npcDef, Point position) {
    LOGGER.log(CustomLogLevel.DEBUG, "Creating hostile mob: " + npcId);

    // Get texture path
    String texturePath = npcDef.texture != null ? npcDef.texture : DEFAULT_HOSTILE_NPC_TEXTURE;

    // Configure health and damage
    int baseHealth = npcDef.health > 0 ? npcDef.health : DEFAULT_NPC_HEALTH;
    int baseDamage = npcDef.damage > 0 ? npcDef.damage : DEFAULT_NPC_DAMAGE;

    // Apply difficulty scaling
    int health = difficultyModifier != null ? difficultyModifier.scaleMonsterHealth(baseHealth) : baseHealth;
    int damage = difficultyModifier != null ? difficultyModifier.scaleMonsterDamage(baseDamage) : baseDamage;

    // Use MonsterBuilder to create the entity with proper configuration
    // Use RangeTransition for aggressive behavior - attacks when player comes close
    Entity npcEntity = new MonsterBuilder<>()
        .name(npcId)
        .texturePath(texturePath)
        .health(health)
        .collideDamage(damage)
        .fightAI(() -> AIFactory.randomFightAI())
        .idleAI(() -> AIFactory.randomIdleAI())
        .transitionAI(
            () -> new RangeTransition(6f)) // Aggressive: attacks when player within 6 tiles
        .onDeath(
            entity -> {
              // Fire the DSL ON_DEATH event
              fireEvent(EventType.ON_DEATH, npcId);
            })
        .build(position);

    LOGGER.log(
        CustomLogLevel.DEBUG,
        String.format(
            "Hostile NPC %s: Health=%d, Damage=%d, Texture=%s",
            npcId, health, damage, texturePath));

    return npcEntity;
  }

  /**
   * Creates a friendly (non-hostile) NPC. Adds interaction component that fires
   * DSL ON_INTERACT
   * events.
   *
   * @param npcId    The NPC identifier
   * @param npcDef   The NPC definition
   * @param position The spawn position
   * @return The created friendly NPC entity
   */
  private static Entity createFriendlyNPC(String npcId, NPC npcDef, Point position) {
    String texturePath = npcDef.texture != null ? npcDef.texture : DEFAULT_FRIENDLY_NPC_TEXTURE;

    // Use AnimationFactory to load NPC spritesheet with fallback
    java.util.Map<String, Animation> animationMap = AnimationFactory.loadNPCSpritesheet(texturePath);

    // Get default idle animation using AnimationFactory
    Animation idleAnimation = AnimationFactory.getDefaultIdleAnimation(animationMap);

    Entity npcEntity = new Entity(npcId);
    npcEntity.add(new PositionComponent(position));
    npcEntity.add(new DrawComponent(idleAnimation));
    npcEntity.add(new VelocityComponent(0f));

    // Add interaction component that fires DSL events and shows dialogue
    npcEntity.add(
        new InteractionComponent(
            InteractionComponent.DEFAULT_INTERACTION_RADIUS,
            true,
            (entity, who) -> {
              // Fire the DSL ON_INTERACT event
              fireEvent(EventType.ON_INTERACT, npcId);

              // Handle item trading
              boolean tradeSuccessful = true;
              if (npcDef.requiresItems != null && !npcDef.requiresItems.isEmpty()) {
                for (String reqItem : npcDef.requiresItems) {
                  if (dslRuntime != null && !dslRuntime.getGameBridge().hasItem(reqItem)) {
                    if (dslRuntime != null) {
                      dslRuntime.getGameBridge().showMessage("I need " + reqItem + ".");
                    }
                    tradeSuccessful = false;
                    break;
                  }
                }

                if (tradeSuccessful && dslRuntime != null) {
                  // Remove required items
                  for (String reqItem : npcDef.requiresItems) {
                    dslRuntime.getGameBridge().removeItem(reqItem);
                  }
                }
              }

              if (tradeSuccessful && npcDef.givesItems != null && !npcDef.givesItems.isEmpty()) {
                if (dslRuntime != null) {
                  for (String giveItem : npcDef.givesItems) {
                    dslRuntime.getGameBridge().giveItem(giveItem);
                    dslRuntime.getGameBridge().showMessage("Received " + giveItem + "!");
                  }
                  // Clear givesItems to prevent infinite giving
                  npcDef.givesItems.clear();
                }
              }

              // Show NPC dialogue if available
              if (npcDef.dialogue != null && !npcDef.dialogue.isEmpty()) {
                if (dslRuntime != null) {
                  // Get default dialogue or first available dialogue line
                  String dialogueText = npcDef.dialogue.getOrDefault(
                      "default", npcDef.dialogue.values().iterator().next());
                  dslRuntime.getGameBridge().showMessage(dialogueText);
                }
              }
            }));

    LOGGER.log(CustomLogLevel.DEBUG, "Created friendly NPC with texture: " + texturePath);
    return npcEntity;
  }

  /**
   * Gets a random floor tile position in the current level.
   *
   * @return A random floor position, or null if no floor tiles available
   */
  public static Point getRandomFloorPosition() {
    return PositionUtils.getRandomFloorPosition();
  }

  /**
   * Spawns quiz entities (chests and NPCs with quizzes) from DSL definition.
   *
   * @param definition The escape room definition containing quiz definitions
   */
  private static void spawnQuizEntities(EscapeRoomDefinition definition) {
    LOGGER.info("Spawning quiz entities...");

    for (var entry : definition.quizzes.entrySet()) {
      String quizId = entry.getKey();
      Quiz quizDef = entry.getValue();

      try {
        // Validate that reward item is defined in DSL (if reward is specified)
        if (quizDef.reward != null && !quizDef.reward.isEmpty()) {
          if (!definition.items.containsKey(quizDef.reward)) {
            throw new IllegalArgumentException(
                "Quiz '"
                    + quizId
                    + "' has reward '"
                    + quizDef.reward
                    + "' which is not defined in the items section. "
                    + "Please define this item first or remove the reward.");
          }
        }

        // Build the quiz from DSL definition
        task.tasktype.Quiz quiz = buildQuizFromDefinition(quizDef);

        // Try to attach to existing entity if specified
        if (quizDef.attachedTo != null && !quizDef.attachedTo.equals("chest")) {
          // First, validate that the entity is defined in the DSL
          boolean entityDefinedInDSL = definition.npcs.containsKey(quizDef.attachedTo)
              || definition.items.containsKey(quizDef.attachedTo);

          if (!entityDefinedInDSL) {
            throw new IllegalArgumentException(
                "Quiz '"
                    + quizId
                    + "' tries to attach to entity '"
                    + quizDef.attachedTo
                    + "' which is not defined in the DSL. Please define this NPC or item first, "
                    + "or use 'attached_to: chest' to create a standalone quiz chest.");
          }

          // Try to find and attach to existing NPC/item entity in the game
          boolean attached = attachQuizToExistingEntity(quizDef.attachedTo, quiz, quizDef.reward, definition);
          if (attached) {
            LOGGER.info("Attached quiz '" + quizId + "' to entity: " + quizDef.attachedTo);
            continue;
          } else {
            // Entity is defined in DSL but hasn't been spawned yet - this shouldn't happen
            throw new IllegalStateException(
                "Quiz '"
                    + quizId
                    + "' could not attach to '"
                    + quizDef.attachedTo
                    + "'. The entity is defined but not found in the game. "
                    + "This may be a timing issue - NPCs should be spawned before quizzes.");
          }
        }

        // If attached_to is "chest" or not specified, create new entity
        Entity quizEntity = createQuizEntity(quizId, quizDef, definition);
        if (quizEntity != null) {
          Game.add(quizEntity);
          LOGGER.info("Spawned quiz entity: " + quizId);
        }
      } catch (Exception e) {
        LOGGER.warning("Failed to spawn quiz " + quizId + ": " + e.getMessage());
        LOGGER.log(CustomLogLevel.ERROR, "Quiz spawn error details", e);
      }
    }
  }

  /**
   * Tries to attach a quiz to an existing entity (NPC or item).
   *
   * @param entityName The name/ID of the entity to attach to
   * @param quiz       The quiz to attach
   * @param reward     The reward for completing the quiz
   * @param definition The DSL definition for creating reward items
   * @return true if successfully attached, false otherwise
   */
  private static boolean attachQuizToExistingEntity(
      String entityName, task.tasktype.Quiz quiz, String reward, EscapeRoomDefinition definition) {
    // Use EntityUtils to find the entity by name (case-insensitive)
    var entityOpt = EntityUtils.findEntityByNameIgnoreCase(entityName);

    if (entityOpt.isEmpty()) {
      return false;
    }

    Entity entity = entityOpt.get();

    // Add quiz component
    QuizComponent quizComponent = new QuizComponent(quiz, reward);
    entity.add(quizComponent);

    // Remove old interaction if any and add quiz interaction with reward callback
    entity.remove(InteractionComponent.class);

    // Get the entity name for event firing (use entityName parameter as fallback)
    String actualEntityName = entity.name() != null ? entity.name() : entityName;

    // Create a success callback that fires DSL event and gives the reward item
    Runnable onSuccess = () -> {
      // Fire DSL ON_CORRECT event (for on_correct handlers in quiz definition)
      fireEvent(EventType.ON_CORRECT, actualEntityName);
      // Fire DSL ON_PUZZLE_SOLVED event (for legacy events: section)
      fireEvent(EventType.ON_PUZZLE_SOLVED, actualEntityName);
      // Give reward if specified
      if (reward != null && !reward.isEmpty()) {
        giveRewardToPlayer(reward, definition);
      }
    };

    // Create a failure callback that fires DSL event for wrong answers
    Runnable onFailure = () -> {
      // Fire DSL ON_INCORRECT event (for on_wrong handlers in quiz definition)
      fireEvent(EventType.ON_INCORRECT, actualEntityName);
    };

    BiConsumer<Entity, Entity> quizInteraction = QuizInteractionHandler.createQuizInteraction(quizComponent, onSuccess,
        onFailure);

    entity.add(
        new InteractionComponent(
            InteractionComponent.DEFAULT_INTERACTION_RADIUS, true, quizInteraction));

    return true;
  }

  /**
   * Creates a quiz entity (chest or NPC) from DSL definition.
   *
   * @param quizId     The unique identifier for the quiz
   * @param quizDef    The quiz definition from DSL
   * @param definition The escape room definition for creating rewards
   * @return The created quiz entity, or null if creation failed
   */
  private static Entity createQuizEntity(
      String quizId, Quiz quizDef, EscapeRoomDefinition definition) {
    // Get position
    Point position = getRandomFloorPosition();
    if (position == null) {
      LOGGER.warning("No floor tile found for quiz: " + quizId);
      return null;
    }

    // Build the quiz from DSL definition
    task.tasktype.Quiz quiz = buildQuizFromDefinition(quizDef);

    // Create success callback that fires DSL event and gives the reward
    final String eventQuizId = quizId;
    Runnable onSuccess = () -> {
      // Fire DSL ON_CORRECT event (for on_correct handlers in quiz definition)
      fireEvent(EventType.ON_CORRECT, eventQuizId);
      // Fire DSL ON_PUZZLE_SOLVED event (for legacy events: section)
      fireEvent(EventType.ON_PUZZLE_SOLVED, eventQuizId);
      // Give reward if specified
      if (quizDef.reward != null && !quizDef.reward.isEmpty()) {
        giveRewardToPlayer(quizDef.reward, definition);
      }
    };

    // Create failure callback that fires DSL event for wrong answers
    Runnable onFailure = () -> {
      // Fire DSL ON_INCORRECT event (for on_wrong handlers in quiz definition)
      fireEvent(EventType.ON_INCORRECT, eventQuizId);
    };

    // Determine entity type based on attached_to field
    if (quizDef.attachedTo != null) {
      if (quizDef.attachedTo.equals("chest")) {
        return QuizEntityFactory.createQuizChest(position, quiz, quizDef.reward, onSuccess, onFailure);
      } else {
        // Assume it's an NPC name/type
        return QuizEntityFactory.createQuizNPC(position, quiz, quizDef.reward);
      }
    } else {
      // Default to chest if not specified
      return QuizEntityFactory.createQuizChest(position, quiz, quizDef.reward, onSuccess, onFailure);
    }
  }

  /** Builds a Quiz instance from DSL Quiz definition. */
  private static task.tasktype.Quiz buildQuizFromDefinition(Quiz quizDef) {
    QuizBuilder.QuizType type = switch (quizDef.type != null ? quizDef.type : "single_choice") {
      case "multiple_choice" -> QuizBuilder.QuizType.MULTIPLE_CHOICE;
      case "free_text" -> QuizBuilder.QuizType.FREE_TEXT;
      default -> QuizBuilder.QuizType.SINGLE_CHOICE;
    };

    return new QuizBuilder()
        .question(quizDef.question != null ? quizDef.question : "Quiz Question")
        .type(type)
        .answers(quizDef.answers != null ? quizDef.answers : List.of())
        .correctIndices(quizDef.correctAnswers != null ? quizDef.correctAnswers : List.of())
        .build();
  }

  /**
   * Gives a reward item to the player by adding it to their inventory.
   *
   * @param rewardId   The ID of the reward item
   * @param definition The DSL definition containing item definitions
   */
  private static void giveRewardToPlayer(String rewardId, EscapeRoomDefinition definition) {
    try {
      // Get the hero entity
      var heroOpt = Game.hero();
      if (heroOpt.isEmpty()) {
        LOGGER.warning("Cannot give reward: No hero found");
        return;
      }

      Entity hero = heroOpt.get();

      // Get the hero's inventory
      var inventoryOpt = hero.fetch(contrib.components.InventoryComponent.class);
      if (inventoryOpt.isEmpty()) {
        LOGGER.warning("Cannot give reward: Hero has no inventory");
        return;
      }

      contrib.components.InventoryComponent inventory = inventoryOpt.get();

      // Get the item definition
      Item itemDef = definition.items.get(rewardId);
      if (itemDef == null) {
        LOGGER.warning("Cannot give reward: Item '" + rewardId + "' not found in definitions");
        return;
      }

      // Create the item
      contrib.item.Item item = createItemFromDefinition(rewardId, itemDef, dslRuntime);
      if (item == null) {
        LOGGER.warning("Cannot give reward: Failed to create item '" + rewardId + "'");
        return;
      }

      // Add to inventory
      inventory.add(item);

      // Fire ON_PICKUP event for rewards too
      fireEvent(EventType.ON_PICKUP, rewardId);

      LOGGER.info("Gave reward '" + rewardId + "' to player");

    } catch (Exception e) {
      LOGGER.warning("Error giving reward: " + e.getMessage());
      LOGGER.log(CustomLogLevel.ERROR, "Reward error details", e);
    }
  }

  /**
   * Creates an item instance from DSL item definition (without spawning entity).
   * Uses the DSL
   * 'type' field to determine the correct item class.
   *
   * @param itemId  The ID of the item
   * @param itemDef The item definition
   * @param runtime The DSL runtime for event handling
   * @return The created item, or null if creation failed
   */
  public static contrib.item.Item createItemFromDefinition(
      String itemId, Item itemDef, DSLRuntime runtime) {
    if (itemDef == null) {
      LOGGER.warning("Item definition is null for: " + itemId);
      return null;
    }

    // Get item type from DSL (default to DEFAULT_ITEM_TYPE if not specified)
    String type = itemDef.type != null ? itemDef.type.toLowerCase() : DEFAULT_ITEM_TYPE;

    // Get display name and description
    String displayName = itemId.replace("_", " ").toUpperCase();
    String description = itemDef.description != null ? itemDef.description : "An item.";
    String texturePath = itemDef.texture != null ? itemDef.texture : "items/resource/berry";

    // Use AnimationFactory for consistent texture loading with fallback
    Animation animation = AnimationFactory.createSingleFrameAnimationWithFallback(
        texturePath, "items/resource/berry");

    try {
      // Create item based on DSL type field
      return switch (type) {
        case "key" -> new EscapeRoomKey(itemId, displayName, description, texturePath);

        case "readable" ->
          new DSLItem(
              itemId,
              displayName,
              description
                  + (itemDef.readable && itemDef.content != null ? "\n\n" + itemDef.content : ""),
              animation,
              animation,
              runtime);

        case "consumable" ->
          new DSLItem(itemId, displayName, description, animation, animation, runtime);

        case "tool" -> new DSLItem(itemId, displayName, description, animation, animation, runtime);

        default -> {
          LOGGER.warning(
              "Unknown item type '" + type + "' for item '" + itemId + "', defaulting to tool");
          yield new DSLItem(itemId, displayName, description, animation, animation, runtime);
        }
      };
    } catch (Exception e) {
      LOGGER.warning("Error creating item '" + itemId + "': " + e.getMessage());
      LOGGER.log(CustomLogLevel.ERROR, "Item creation error details", e);
      return null;
    }
  }

  /**
   * Creates an NPC entity from DSL definition for dynamic spawning.
   *
   * @param npcId   The unique identifier for the NPC
   * @param npcDef  The NPC definition from DSL
   * @param runtime The DSL runtime for event handling
   * @return The created entity, or null if creation failed
   */
  public static Entity createNPCEntity(String npcId, NPC npcDef, DSLRuntime runtime) {
    try {
      // Get position - this will be overridden by the caller if needed
      Point position = getRandomFloorPosition();
      if (position == null) {
        LOGGER.warning("No floor tile found for NPC: " + npcId);
        return null;
      }

      // Skip player NPC (hero is created separately)
      if ("player".equals(npcId)) {
        return null;
      }

      Entity npcEntity;

      if (npcDef.hostile) {
        npcEntity = createHostileNPC(npcId, npcDef, position);
      } else {
        npcEntity = createFriendlyNPC(npcId, npcDef, position);
      }

      // Register event handlers if runtime is provided
      if (runtime != null && npcEntity != null) {
        // This allows the dynamically spawned NPC to have event handlers
        registerNPCEventHandlers(npcId, npcDef, npcEntity, runtime);
      }

      return npcEntity;
    } catch (Exception e) {
      LOGGER.warning("Failed to create NPC " + npcId + ": " + e.getMessage());
      LOGGER.log(CustomLogLevel.DEBUG, "NPC creation error details", e);
      return null;
    }
  }

  /**
   * Registers event handlers for a dynamically spawned NPC.
   */
  private static void registerNPCEventHandlers(
      String npcId, NPC npcDef, Entity npcEntity, DSLRuntime runtime) {
    // Event handlers are already registered in createHostileNPC and
    // createFriendlyNPC
    // through the builder callbacks. The DSL runtime handles them via the
    // eventHandlers list.
    // No additional registration needed here since the entity creation already sets
    // up
    // the callbacks that fire DSL events.
  }
}
