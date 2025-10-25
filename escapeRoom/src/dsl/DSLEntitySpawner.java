package dsl;

import contrib.entities.WorldItemBuilder;
import contrib.entities.MonsterBuilder;
import contrib.entities.AIFactory;
import contrib.item.concreteItem.ItemResourceBerry;
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
     */
    private static void spawnItems(EscapeRoomDefinition definition) {
        System.out.println("  Spawning items...");

        for (var entry : definition.items.entrySet()) {
            String itemId = entry.getKey();
            Item itemDef = entry.getValue();

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

        // Create the appropriate item based on ID or type
        contrib.item.Item item;

        if (itemId.toLowerCase().contains("key")) {
            // Create an EscapeRoomKey for key items
            item = new EscapeRoomKey(
                    itemId,
                    itemId.replace("_", " ").toUpperCase(),
                    itemDef.description != null ? itemDef.description : "A key that unlocks something.",
                    itemDef.texture != null ? itemDef.texture : "items/key/small_key.png");
        } else {
            // Use berry as placeholder for other items
            item = new ItemResourceBerry();
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
            String texturePath = npcDef.texture != null ? npcDef.texture : "character/monster/chort";

            // Configure health and damage
            int health = npcDef.health > 0 ? npcDef.health : 10;
            int damage = npcDef.damage > 0 ? npcDef.damage : 1;

            // Use MonsterBuilder to create the entity with proper configuration
            // Note: Don't use transitionAI with null entity reference to avoid NPE
            npcEntity = new MonsterBuilder<>()
                    .name(npcId)
                    .texturePath(texturePath)
                    .health(health)
                    .collideDamage(damage)
                    .fightAI(() -> AIFactory.randomFightAI())
                    .idleAI(() -> AIFactory.randomIdleAI())
                    .build(position);

            System.out.println("      Health: " + health + ", Damage: " + damage + ", Texture: " + texturePath);
        } else {
            // Create friendly NPC (non-hostile)
            // Use a simple entity with proper animations but no AI or combat capabilities
            String texturePath = npcDef.texture != null ? npcDef.texture : "character/monster/pumpkin_dude";

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
                    boolean attached = attachQuizToExistingEntity(quizDef.attachedTo, quiz, quizDef.reward);
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
                Entity quizEntity = createQuizEntity(quizId, quizDef);
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
     * @param quiz The quiz to attach
     * @param reward The reward for completing the quiz
     * @return true if successfully attached, false otherwise
     */
    private static boolean attachQuizToExistingEntity(String entityName, task.tasktype.Quiz quiz, String reward) {
        // Search through all entities in the game to find matching one
        var entities = Game.allEntities().toList();
        
        for (Entity entity : entities) {
            // Check if this is the entity we're looking for by checking its name
            String name = entity.name();
            if (name != null && name.equalsIgnoreCase(entityName)) {
                // Add quiz component
                QuizComponent quizComponent = new QuizComponent(quiz, reward);
                entity.add(quizComponent);

                // Remove old interaction if any and add quiz interaction
                entity.remove(InteractionComponent.class);
                BiConsumer<Entity, Entity> quizInteraction = QuizInteractionHandler.createQuizInteraction(
                    quizComponent, null, null);

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
    private static Entity createQuizEntity(String quizId, Quiz quizDef) {
        // Get position
        Point position = getRandomFloorPosition();
        if (position == null) {
            System.err.println("    [FAIL] No floor tile found for quiz: " + quizId);
            return null;
        }

        // Build the quiz from DSL definition
        task.tasktype.Quiz quiz = buildQuizFromDefinition(quizDef);

        // Determine entity type based on attached_to field
        if (quizDef.attachedTo != null) {
            if (quizDef.attachedTo.equals("chest")) {
                return QuizEntityFactory.createQuizChest(position, quiz, quizDef.reward);
            } else {
                // Assume it's an NPC name/type
                return QuizEntityFactory.createQuizNPC(position, quiz, quizDef.reward);
            }
        } else {
            // Default to chest if not specified
            return QuizEntityFactory.createQuizChest(position, quiz, quizDef.reward);
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
}
