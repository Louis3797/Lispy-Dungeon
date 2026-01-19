package dsl.validation;

import static org.junit.jupiter.api.Assertions.*;

import dsl.EscapeRoomDefinition;
import dsl.Item;
import dsl.Metadata;
import dsl.NPC;
import dsl.Quiz;
import dsl.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Tests for DSL Validation - ensures DSL definitions are valid and consistent.
 */
public class DSLValidationTest {

    private EscapeRoomValidator validator;
    private EscapeRoomDefinition definition;

    @BeforeEach
    void setUp() {
        validator = new EscapeRoomValidator();
        definition = new EscapeRoomDefinition();
        definition.metadata = new Metadata();
        definition.metadata.title = "Test Room";
        definition.rooms = new HashMap<>();
        definition.items = new HashMap<>();
        definition.npcs = new HashMap<>();
        definition.quizzes = new HashMap<>();
    }

    // =============================================================================
    // METADATA VALIDATION TESTS
    // =============================================================================

    @Test
    void testValidMetadata() {
        ValidationResult result = validator.validate(definition);
        assertTrue(result.isValid(), "Valid definition should not have errors");
    }

    @Test
    void testMissingTitle() {
        definition.metadata.title = null;
        ValidationResult result = validator.validate(definition);
        assertFalse(result.isValid(), "Missing title should cause error");
    }

    @Test
    void testEmptyTitle() {
        definition.metadata.title = "";
        ValidationResult result = validator.validate(definition);
        assertTrue(!result.isValid() || result.hasWarnings(),
                "Empty title should cause error or warning");
    }

    // =============================================================================
    // ROOM VALIDATION TESTS
    // =============================================================================

    @Test
    void testValidRoom() {
        Room room = new Room();
        room.description = "Test room";
        room.x = 0;
        room.y = 0;
        room.width = 10;
        room.height = 10;
        definition.rooms.put("test_room", room);

        ValidationResult result = validator.validate(definition);
        assertTrue(result.isValid(), "Valid room should not cause errors");
    }

    @Test
    void testRoomWithInvalidDimensions() {
        Room room = new Room();
        room.description = "Test room";
        room.x = 0;
        room.y = 0;
        room.width = 0; // Invalid
        room.height = 0; // Invalid
        definition.rooms.put("invalid_room", room);

        ValidationResult result = validator.validate(definition);
        assertTrue(!result.isValid() || result.hasWarnings(),
                "Room with zero dimensions should cause error/warning");
    }

    @Test
    void testRoomWithNegativeDimensions() {
        Room room = new Room();
        room.description = "Test room";
        room.x = 0;
        room.y = 0;
        room.width = -10; // Invalid
        room.height = -5; // Invalid
        definition.rooms.put("negative_room", room);

        ValidationResult result = validator.validate(definition);
        assertTrue(!result.isValid() || result.hasWarnings(),
                "Negative dimensions should cause error/warning");
    }

    @Test
    void testRoomConnectionsToNonExistentRooms() {
        Room room1 = createValidRoom();
        room1.connections = new ArrayList<>();
        room1.connections.add("nonexistent_room");
        definition.rooms.put("room1", room1);

        ValidationResult result = validator.validate(definition);
        assertTrue(!result.isValid() || result.hasWarnings(),
                "Connection to nonexistent room should cause error/warning");
    }

    @Test
    void testRoomReferencingNonExistentItems() {
        Room room = createValidRoom();
        room.items = new ArrayList<>();
        room.items.add("nonexistent_item");
        definition.rooms.put("test_room", room);

        ValidationResult result = validator.validate(definition);
        assertTrue(result.hasWarnings() || !result.isValid(),
                "Reference to nonexistent item should cause warning/error");
    }

    @Test
    void testRoomLockedByNonExistentKey() {
        Room room = createValidRoom();
        room.lockedBy = "nonexistent_key";
        definition.rooms.put("test_room", room);

        ValidationResult result = validator.validate(definition);
        assertTrue(!result.isValid() || result.hasWarnings(),
                "Locked by nonexistent key should cause error/warning");
    }

    // =============================================================================
    // ITEM VALIDATION TESTS
    // =============================================================================

    @Test
    void testValidItem() {
        Item item = new Item();
        item.description = "A golden key";
        item.type = "tool";
        item.texture = "items/key/gold.png";
        item.visible = true;
        definition.items.put("golden_key", item);

        ValidationResult result = validator.validate(definition);
        assertTrue(result.isValid(), "Valid item should not cause errors");
    }

    @Test
    void testItemWithMissingTexture() {
        Item item = new Item();
        item.description = "Test item";
        item.type = "tool";
        item.texture = null;
        definition.items.put("test_item", item);

        ValidationResult result = validator.validate(definition);
        // Missing texture might be a warning depending on implementation
        assertTrue(result.hasWarnings() || !result.isValid());
    }

    @Test
    void testReadableItemWithoutContent() {
        Item item = new Item();
        item.description = "A scroll";
        item.type = "document";
        item.texture = "items/scroll.png";
        item.readable = true;
        item.content = null; // Should have content if readable
        definition.items.put("scroll", item);

        ValidationResult result = validator.validate(definition);
        assertTrue(result.hasWarnings() || !result.isValid(),
                "Readable item without content should cause warning/error");
    }

    // =============================================================================
    // NPC VALIDATION TESTS
    // =============================================================================

    @Test
    void testValidFriendlyNPC() {
        NPC npc = new NPC();
        npc.description = "A friendly merchant";
        npc.texture = "character/merchant";
        npc.hostile = false;
        npc.dialogue = new HashMap<>();
        npc.dialogue.put("default", "Welcome!");
        definition.npcs.put("merchant", npc);

        ValidationResult result = validator.validate(definition);
        assertTrue(result.isValid(), "Valid friendly NPC should not cause errors");
    }

    @Test
    void testValidHostileNPC() {
        NPC npc = new NPC();
        npc.description = "A skeleton warrior";
        npc.texture = "character/skeleton";
        npc.hostile = true;
        npc.health = 50;
        npc.damage = 10;
        definition.npcs.put("skeleton", npc);

        ValidationResult result = validator.validate(definition);
        assertTrue(result.isValid(), "Valid hostile NPC should not cause errors");
    }

    @Test
    void testHostileNPCWithoutHealth() {
        NPC npc = new NPC();
        npc.description = "A monster";
        npc.texture = "character/monster";
        npc.hostile = true;
        npc.health = 0; // Should have health if hostile
        npc.damage = 10;
        definition.npcs.put("monster", npc);

        ValidationResult result = validator.validate(definition);
        assertTrue(result.hasWarnings() || !result.isValid(),
                "Hostile NPC without health should cause warning/error");
    }

    @Test
    void testNPCWithInvalidLocation() {
        NPC npc = new NPC();
        npc.description = "A merchant";
        npc.texture = "character/merchant";
        npc.hostile = false;
        npc.location = "nonexistent_room";
        definition.npcs.put("merchant", npc);

        ValidationResult result = validator.validate(definition);
        assertTrue(result.hasWarnings() || !result.isValid(),
                "NPC in nonexistent location should cause warning/error");
    }

    @Test
    void testNPCGivingNonExistentItems() {
        NPC npc = new NPC();
        npc.description = "A treasure giver";
        npc.texture = "character/wizard";
        npc.hostile = false;
        npc.givesItems = new ArrayList<>();
        npc.givesItems.add("nonexistent_item");
        definition.npcs.put("wizard", npc);

        ValidationResult result = validator.validate(definition);
        assertTrue(result.hasWarnings() || !result.isValid(),
                "NPC giving nonexistent items should cause warning/error");
    }

    // =============================================================================
    // QUIZ VALIDATION TESTS
    // =============================================================================

    @Test
    void testValidSingleChoiceQuiz() {
        Quiz quiz = new Quiz();
        quiz.type = "single_choice";
        quiz.question = "What is 2+2?";
        quiz.answers = List.of("3", "4", "5");
        quiz.correctAnswers = List.of(1);
        quiz.explanation = "2+2=4";
        quiz.reward = "golden_key";
        definition.quizzes.put("math_quiz", quiz);

        // Add the reward item
        Item key = new Item();
        key.description = "A golden key";
        key.type = "tool";
        key.texture = "items/key.png";
        definition.items.put("golden_key", key);

        ValidationResult result = validator.validate(definition);
        assertTrue(result.isValid(), "Valid quiz should not cause errors");
    }

    @Test
    void testQuizWithNonExistentReward() {
        Quiz quiz = new Quiz();
        quiz.type = "single_choice";
        quiz.question = "Test question?";
        quiz.answers = List.of("A", "B", "C");
        quiz.correctAnswers = List.of(0);
        quiz.reward = "nonexistent_item";
        definition.quizzes.put("test_quiz", quiz);

        ValidationResult result = validator.validate(definition);
        assertTrue(!result.isValid(),
                "Quiz with nonexistent reward should cause error");
    }

    @Test
    void testQuizWithEmptyAnswers() {
        Quiz quiz = new Quiz();
        quiz.type = "single_choice";
        quiz.question = "Test question?";
        quiz.answers = new ArrayList<>();
        quiz.correctAnswers = List.of(0);
        definition.quizzes.put("empty_quiz", quiz);

        ValidationResult result = validator.validate(definition);
        assertTrue(!result.isValid() || result.hasWarnings(),
                "Quiz with no answers should cause error/warning");
    }

    @Test
    void testQuizWithInvalidCorrectAnswer() {
        Quiz quiz = new Quiz();
        quiz.type = "single_choice";
        quiz.question = "Test question?";
        quiz.answers = List.of("A", "B", "C");
        quiz.correctAnswers = List.of(5); // Index out of bounds
        definition.quizzes.put("invalid_quiz", quiz);

        ValidationResult result = validator.validate(definition);
        assertTrue(!result.isValid() || result.hasWarnings(),
                "Quiz with invalid correct answer index should cause error/warning");
    }

    @Test
    void testMultipleChoiceQuizWithMultipleCorrectAnswers() {
        Quiz quiz = new Quiz();
        quiz.type = "multiple_choice";
        quiz.question = "Which are even numbers?";
        quiz.answers = List.of("1", "2", "3", "4");
        quiz.correctAnswers = List.of(1, 3); // 2 and 4
        quiz.explanation = "2 and 4 are even";
        definition.quizzes.put("even_quiz", quiz);

        ValidationResult result = validator.validate(definition);
        assertTrue(result.isValid(),
                "Valid multiple choice quiz should not cause errors");
    }

    // =============================================================================
    // COMPLEX VALIDATION SCENARIOS
    // =============================================================================

    @Test
    void testCircularRoomConnections() {
        Room room1 = createValidRoom();
        room1.connections = new ArrayList<>();
        room1.connections.add("room2");
        definition.rooms.put("room1", room1);

        Room room2 = createValidRoom();
        room2.connections = new ArrayList<>();
        room2.connections.add("room1");
        definition.rooms.put("room2", room2);

        ValidationResult result = validator.validate(definition);
        // Circular connections are valid
        assertTrue(result.isValid());
    }

    @Test
    void testComplexValidDefinition() {
        // Create a complex but valid definition

        // Rooms
        Room entrance = createValidRoom();
        entrance.connections = new ArrayList<>();
        entrance.connections.add("main_hall");
        entrance.items = new ArrayList<>();
        entrance.items.add("bronze_key");
        definition.rooms.put("entrance", entrance);

        Room mainHall = createValidRoom();
        mainHall.connections = new ArrayList<>();
        mainHall.connections.add("entrance");
        mainHall.lockedBy = "bronze_key";
        definition.rooms.put("main_hall", mainHall);

        // Items
        Item key = new Item();
        key.description = "A bronze key";
        key.type = "tool";
        key.texture = "items/key.png";
        definition.items.put("bronze_key", key);

        // NPCs
        NPC merchant = new NPC();
        merchant.description = "A merchant";
        merchant.texture = "character/merchant";
        merchant.location = "entrance";
        merchant.hostile = false;
        merchant.dialogue = new HashMap<>();
        merchant.dialogue.put("default", "Hello!");
        definition.npcs.put("merchant", merchant);

        ValidationResult result = validator.validate(definition);
        assertTrue(result.isValid(),
                "Complex valid definition should not have errors");
    }

    // =============================================================================
    // HELPER METHODS
    // =============================================================================

    private Room createValidRoom() {
        Room room = new Room();
        room.description = "A test room";
        room.x = 0;
        room.y = 0;
        room.width = 10;
        room.height = 10;
        return room;
    }
}
