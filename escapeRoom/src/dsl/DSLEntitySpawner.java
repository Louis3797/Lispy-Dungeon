package dsl;

import contrib.entities.WorldItemBuilder;
import contrib.entities.MonsterBuilder;
import contrib.entities.AIFactory;
import contrib.components.InteractionComponent;
import core.Entity;
import core.Game;
import core.level.DungeonLevel;
import core.level.Tile;
import core.utils.Point;
import core.components.PositionComponent;
import core.components.DrawComponent;
import core.components.VelocityComponent;
import core.utils.components.draw.animation.Animation;
import core.utils.components.path.SimpleIPath;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

/**
 * Spawns entities (items, NPCs, monsters) from the DSL definition into the
 * game.
 */
public class DSLEntitySpawner {

    // Configuration constants
    private static final int DEFAULT_NPC_HEALTH = 10;
    private static final int DEFAULT_NPC_DAMAGE = 1;
    private static final String DEFAULT_HOSTILE_NPC_TEXTURE = "character/monster/chort";
    private static final String DEFAULT_FRIENDLY_NPC_TEXTURE = "character/monster/pumpkin_dude";
    private static final String DEFAULT_ITEM_TYPE = "tool";

    private static final Random random = new Random();

    /**
     * Spawns all entities from the DSL definition.
     */
    public static void spawnEntities(EscapeRoomDefinition definition) {
        System.out.println("=== Spawning Entities ===");

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

        System.out.println("[OK] Entity spawning complete!");
    }

    /**
     * Spawns items from the DSL definition.
     * Items that are quiz rewards will NOT be spawned on the map.
     */
    private static void spawnItems(EscapeRoomDefinition definition) {
        System.out.println("  Spawning items...");

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
                System.out.println("    [SKIP] Item '" + itemId + "' is a quiz reward, not spawning on map");
                continue;
            }

            try {
                Entity itemEntity = createItemEntity(itemId, itemDef);
                if (itemEntity != null) {
                    Game.add(itemEntity);
                    System.out.println("    [OK] Spawned item: " + itemId);
                }
            } catch (Exception e) {
                System.err.println("    [FAIL] Failed to spawn item " + itemId + ": " + e.getMessage());
            }
        }
    }

    /**
     * Creates an item entity from DSL definition.
     */
    private static Entity createItemEntity(String itemId, Item itemDef) {
        // Get a random floor tile to place the item
        Point position = getRandomFloorPosition();
        if (position == null) {
            System.err.println("    [FAIL] No floor tile found for item: " + itemId);
            return null;
        }

        // Create the appropriate item based on the DSL type field
        contrib.item.Item item = createItemFromDefinition(itemId, itemDef);
        if (item == null) {
            System.err.println("    [FAIL] Could not create item: " + itemId);
            return null;
        }

        return WorldItemBuilder.buildWorldItem(item, position);
    }

    /**
     * Spawns NPCs from the DSL definition.
     */
    private static void spawnNPCs(EscapeRoomDefinition definition) {
        System.out.println("  Spawning NPCs...");

        for (var entry : definition.npcs.entrySet()) {
            String npcId = entry.getKey();
            NPC npcDef = entry.getValue();

            try {
                Entity npcEntity = createNPCEntity(npcId, npcDef);
                if (npcEntity != null) {
                    Game.add(npcEntity);
                    System.out.println("    [OK] Spawned NPC: " + npcId);
                }
            } catch (Exception e) {
                System.err.println("    [FAIL] Failed to spawn NPC " + npcId + ": " + e.getMessage());
            }
        }
    }

    /**
     * Creates an NPC entity from DSL definition.
     */
    private static Entity createNPCEntity(String npcId, NPC npcDef) throws IOException {
        // Get position
        Point position = getRandomFloorPosition();
        if (position == null) {
            System.err.println("    [FAIL] No floor tile found for NPC: " + npcId);
            return null;
        }

        // Skip player NPC (hero is created separately)
        if ("player".equals(npcId)) {
            return null;
        }

        Entity npcEntity;

        if (npcDef.hostile) {
            // Create hostile mob with combat capabilities
            System.out.println("    [OK] Creating hostile mob: " + npcId);

            // Get texture path
            String texturePath = npcDef.texture != null ? npcDef.texture : DEFAULT_HOSTILE_NPC_TEXTURE;

            // Configure health and damage
            int health = npcDef.health > 0 ? npcDef.health : DEFAULT_NPC_HEALTH;
            int damage = npcDef.damage > 0 ? npcDef.damage : DEFAULT_NPC_DAMAGE;

            // Use MonsterBuilder to create the entity with proper configuration
            // Use SelfDefendTransition - mobs will attack when they take damage or player
            // is in range
            npcEntity = new MonsterBuilder<>()
                    .name(npcId)
                    .texturePath(texturePath)
                    .health(health)
                    .collideDamage(damage)
                    .fightAI(() -> AIFactory.randomFightAI())
                    .idleAI(() -> AIFactory.randomIdleAI())
                    .transitionAI(() -> new contrib.utils.components.ai.transition.SelfDefendTransition())
                    .build(position);

            System.out.println("      Health: " + health + ", Damage: " + damage + ", Texture: " + texturePath);
        } else {
            // Create friendly NPC (non-hostile)
            // Use a simple entity with proper animations but no AI or combat capabilities
            String texturePath = npcDef.texture != null ? npcDef.texture : DEFAULT_FRIENDLY_NPC_TEXTURE;

            try {
                // Load animation spritesheet properly (like MonsterBuilder does)
                java.util.Map<String, Animation> animationMap = Animation.loadAnimationSpritesheet(
                        new SimpleIPath(texturePath));

                // Use idle_down or idle animation as the default
                Animation idleAnimation = animationMap.getOrDefault("idle_down",
                        animationMap.getOrDefault("idle", animationMap.values().iterator().next()));

                npcEntity = new Entity(npcId);
                npcEntity.add(new PositionComponent(position));
                npcEntity.add(new DrawComponent(idleAnimation));
                npcEntity.add(new VelocityComponent(0f));
                System.out.println("      Created friendly NPC with texture: " + texturePath);
            } catch (Exception e) {
                System.err.println("      [FAIL] Failed to load texture for friendly NPC: " + texturePath);
                e.printStackTrace();
                // Fallback to simple entity without texture
                npcEntity = new Entity(npcId);
                npcEntity.add(new PositionComponent(position));
            }
        }

        return npcEntity;
    }

    /**
     * Gets a random floor tile position in the current level.
     */
    public static Point getRandomFloorPosition() {
        var levelOpt = Game.currentLevel();
        if (levelOpt.isEmpty()) {
            return null;
        }

        var level = (DungeonLevel) levelOpt.get();
        List<Tile> floorTiles = level.floorTiles().stream()
                .map(tile -> (Tile) tile)
                .toList();

        if (floorTiles.isEmpty()) {
            return null;
        }

        Tile randomTile = floorTiles.get(random.nextInt(floorTiles.size()));
        return randomTile.position();
    }

    /**
     * Spawns quiz entities (chests and NPCs with quizzes) from DSL definition.
     */
    private static void spawnQuizEntities(EscapeRoomDefinition definition) {
        System.out.println("  Spawning quiz entities...");

        for (var entry : definition.quizzes.entrySet()) {
            String quizId = entry.getKey();
            Quiz quizDef = entry.getValue();

            try {
                // Validate that reward item is defined in DSL (if reward is specified)
                if (quizDef.reward != null && !quizDef.reward.isEmpty()) {
                    if (!definition.items.containsKey(quizDef.reward)) {
                        throw new IllegalArgumentException(
                                "Quiz '" + quizId + "' has reward '" + quizDef.reward
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
                                "Quiz '" + quizId + "' tries to attach to entity '" + quizDef.attachedTo
                                        + "' which is not defined in the DSL. Please define this NPC or item first, "
                                        + "or use 'attached_to: chest' to create a standalone quiz chest.");
                    }

                    // Try to find and attach to existing NPC/item entity in the game
                    boolean attached = attachQuizToExistingEntity(quizDef.attachedTo, quiz, quizDef.reward, definition);
                    if (attached) {
                        System.out.println("    [OK] Attached quiz '" + quizId + "' to entity: " + quizDef.attachedTo);
                        continue;
                    } else {
                        // Entity is defined in DSL but hasn't been spawned yet - this shouldn't happen
                        throw new IllegalStateException(
                                "Quiz '" + quizId + "' could not attach to '" + quizDef.attachedTo
                                        + "'. The entity is defined but not found in the game. "
                                        + "This may be a timing issue - NPCs should be spawned before quizzes.");
                    }
                }

                // If attached_to is "chest" or not specified, create new entity
                Entity quizEntity = createQuizEntity(quizId, quizDef, definition);
                if (quizEntity != null) {
                    Game.add(quizEntity);
                    System.out.println("    [OK] Spawned quiz entity: " + quizId);
                }
            } catch (Exception e) {
                System.err.println("    [FAIL] Failed to spawn quiz " + quizId + ": " + e.getMessage());
                e.printStackTrace();
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
    private static boolean attachQuizToExistingEntity(String entityName, task.tasktype.Quiz quiz, String reward,
            EscapeRoomDefinition definition) {
        // Search through all entities in the game to find matching one
        var entities = Game.allEntities().toList();

        for (Entity entity : entities) {
            // Check if this is the entity we're looking for by checking its name
            String name = entity.name();
            if (name != null && name.equalsIgnoreCase(entityName)) {
                // Add quiz component
                QuizComponent quizComponent = new QuizComponent(quiz, reward);
                entity.add(quizComponent);

                // Remove old interaction if any and add quiz interaction with reward callback
                entity.remove(InteractionComponent.class);

                // Create a success callback that gives the reward item
                Runnable onSuccess = null;
                if (reward != null && !reward.isEmpty()) {
                    onSuccess = () -> giveRewardToPlayer(reward, definition);
                }

                BiConsumer<Entity, Entity> quizInteraction = QuizInteractionHandler.createQuizInteraction(
                        quizComponent, onSuccess, null);

                entity.add(new InteractionComponent(
                        InteractionComponent.DEFAULT_INTERACTION_RADIUS,
                        true,
                        quizInteraction));

                return true;
            }
        }

        return false;
    }

    /**
     * Creates a quiz entity (chest or NPC) from DSL definition.
     */
    private static Entity createQuizEntity(String quizId, Quiz quizDef, EscapeRoomDefinition definition) {
        // Get position
        Point position = getRandomFloorPosition();
        if (position == null) {
            System.err.println("    [FAIL] No floor tile found for quiz: " + quizId);
            return null;
        }

        // Build the quiz from DSL definition
        task.tasktype.Quiz quiz = buildQuizFromDefinition(quizDef);

        // Create success callback that gives the reward
        Runnable onSuccess = null;
        if (quizDef.reward != null && !quizDef.reward.isEmpty()) {
            onSuccess = () -> giveRewardToPlayer(quizDef.reward, definition);
        }

        // Determine entity type based on attached_to field
        if (quizDef.attachedTo != null) {
            if (quizDef.attachedTo.equals("chest")) {
                return QuizEntityFactory.createQuizChest(position, quiz, quizDef.reward, onSuccess);
            } else {
                // Assume it's an NPC name/type
                return QuizEntityFactory.createQuizNPC(position, quiz, quizDef.reward);
            }
        } else {
            // Default to chest if not specified
            return QuizEntityFactory.createQuizChest(position, quiz, quizDef.reward, onSuccess);
        }
    }

    /**
     * Builds a Quiz instance from DSL Quiz definition.
     */
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
                System.err.println("[FAIL] Cannot give reward: No hero found");
                return;
            }

            Entity hero = heroOpt.get();

            // Get the hero's inventory
            var inventoryOpt = hero.fetch(contrib.components.InventoryComponent.class);
            if (inventoryOpt.isEmpty()) {
                System.err.println("[FAIL] Cannot give reward: Hero has no inventory");
                return;
            }

            contrib.components.InventoryComponent inventory = inventoryOpt.get();

            // Get the item definition
            Item itemDef = definition.items.get(rewardId);
            if (itemDef == null) {
                System.err.println("[FAIL] Cannot give reward: Item '" + rewardId + "' not found in definitions");
                return;
            }

            // Create the item
            contrib.item.Item item = createItemFromDefinition(rewardId, itemDef);
            if (item == null) {
                System.err.println("[FAIL] Cannot give reward: Failed to create item '" + rewardId + "'");
                return;
            }

            // Add to inventory
            inventory.add(item);
            System.out.println("[OK] Gave reward '" + rewardId + "' to player");

        } catch (Exception e) {
            System.err.println("[FAIL] Error giving reward: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Creates an item instance from DSL item definition (without spawning entity).
     * Uses the DSL 'type' field to determine the correct item class.
     * 
     * @param itemId  The ID of the item
     * @param itemDef The item definition
     * @return The created item, or null if creation failed
     */
    private static contrib.item.Item createItemFromDefinition(String itemId, Item itemDef) {
        if (itemDef == null) {
            System.err.println("    [FAIL] Item definition is null for: " + itemId);
            return null;
        }

        // Get item type from DSL (default to DEFAULT_ITEM_TYPE if not specified)
        String type = itemDef.type != null ? itemDef.type.toLowerCase() : DEFAULT_ITEM_TYPE;

        // Get display name and description
        String displayName = itemId.replace("_", " ").toUpperCase();
        String description = itemDef.description != null ? itemDef.description : "An item.";
        String texturePath = itemDef.texture != null ? itemDef.texture : "items/resource/berry";

        try {
            // Create animation for the item
            Animation animation = new Animation(new SimpleIPath(texturePath));

            // Create item based on DSL type field
            return switch (type) {
                case "key" -> new EscapeRoomKey(
                        itemId,
                        displayName,
                        description,
                        texturePath);

                case "readable" -> new contrib.item.concreteItem.ItemDefault(
                        displayName,
                        description + (itemDef.readable && itemDef.content != null
                                ? "\n\n" + itemDef.content
                                : ""),
                        animation,
                        animation);

                case "consumable" -> new contrib.item.concreteItem.ItemDefault(
                        displayName,
                        description,
                        animation,
                        animation);

                case "tool" -> new contrib.item.concreteItem.ItemDefault(
                        displayName,
                        description,
                        animation,
                        animation);

                default -> {
                    System.err.println("    [WARN] Unknown item type '" + type + "' for item '"
                            + itemId + "', defaulting to tool");
                    yield new contrib.item.concreteItem.ItemDefault(
                            displayName,
                            description,
                            animation,
                            animation);
                }
            };
        } catch (Exception e) {
            System.err.println("    [FAIL] Error creating item '" + itemId + "': " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
