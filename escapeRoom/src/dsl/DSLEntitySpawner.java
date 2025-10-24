package dsl;

import contrib.entities.EntityFactory;
import contrib.entities.WorldItemBuilder;
import contrib.entities.MonsterBuilder;
import contrib.item.concreteItem.ItemResourceBerry;
import core.Entity;
import core.Game;
import core.level.DungeonLevel;
import core.level.Tile;
import core.utils.Point;

import java.io.IOException;
import java.util.List;
import java.util.Random;

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

        System.out.println("✓ Entity spawning complete!");
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
                    System.out.println("    ✓ Spawned item: " + itemId);
                }
            } catch (Exception e) {
                System.err.println("    ✗ Failed to spawn item " + itemId + ": " + e.getMessage());
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
            System.err.println("    ✗ No floor tile found for item: " + itemId);
            return null;
        }

        // Create item (use berry as placeholder for all items for now)
        return WorldItemBuilder.buildWorldItem(new ItemResourceBerry(), position);
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
                    System.out.println("    ✓ Spawned NPC: " + npcId);
                }
            } catch (Exception e) {
                System.err.println("    ✗ Failed to spawn NPC " + npcId + ": " + e.getMessage());
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
            System.err.println("    ✗ No floor tile found for NPC: " + npcId);
            return null;
        }

        // Skip player NPC (hero is created separately)
        if ("player".equals(npcId)) {
            return null;
        }

        // Determine texture - check if it's a monster or friendly NPC
        String texturePath = npcDef.texture != null ? npcDef.texture : "character/monster/chort";
        boolean isMonster = texturePath.contains("monster");

        // Create entity based on type
        Entity npcEntity;
        if (isMonster) {
            // Create a monster using MonsterBuilder
            npcEntity = new MonsterBuilder<>().build(position);
        } else {
            // For friendly NPCs, use a vase as placeholder
            npcEntity = EntityFactory.newVase(position);
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
                Entity quizEntity = createQuizEntity(quizId, quizDef);
                if (quizEntity != null) {
                    Game.add(quizEntity);
                    System.out.println("    ✓ Spawned quiz entity: " + quizId);
                }
            } catch (Exception e) {
                System.err.println("    ✗ Failed to spawn quiz " + quizId + ": " + e.getMessage());
            }
        }
    }

    /**
     * Creates a quiz entity (chest or NPC) from DSL definition.
     */
    private static Entity createQuizEntity(String quizId, Quiz quizDef) {
        // Get position
        Point position = getRandomFloorPosition();
        if (position == null) {
            System.err.println("    ✗ No floor tile found for quiz: " + quizId);
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
