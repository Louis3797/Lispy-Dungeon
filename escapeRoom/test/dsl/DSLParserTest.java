package dsl;

import static org.junit.jupiter.api.Assertions.*;

import dsl.parser.EscapeRoomDSLLexer;
import dsl.parser.EscapeRoomDSLParser;
import org.antlr.v4.runtime.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Tests for DSL Parser - validates grammar, parsing, and AST generation.
 */
public class DSLParserTest {

    private EscapeRoomDSLParser.StartContext parse(String dslCode) {
        CharStream input = CharStreams.fromString(dslCode);
        EscapeRoomDSLLexer lexer = new EscapeRoomDSLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EscapeRoomDSLParser parser = new EscapeRoomDSLParser(tokens);
        return parser.start();
    }

    private EscapeRoomDefinition parseAndInterpret(String dslCode) {
        EscapeRoomDSLParser.StartContext tree = parse(dslCode);
        return EscapeRoomVisitor.interpret(tree);
    }

    // =============================================================================
    // BASIC SYNTAX TESTS
    // =============================================================================

    @Test
    void testMinimalDSL() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test Room"
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        assertNotNull(def);
        assertEquals("Test Room", def.getTitle());
    }

    @Test
    void testMetadataSection() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "The Amazing Escape"
                        description: "Test your wits"
                        difficulty: "hard"
                        fog_of_war: true
                        view_distance: 10
                        camera_zoom: 1.5
                        max_time: 600
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        assertEquals("The Amazing Escape", def.getTitle());
        assertNotNull(def.metadata);
        assertEquals("Test your wits", def.metadata.description);
        assertEquals("hard", def.metadata.difficulty);
        assertTrue(def.metadata.fogOfWar);
        assertEquals(10, def.metadata.viewDistance);
        assertEquals(1.5, def.metadata.cameraZoom, 0.01);
        assertEquals(600, def.metadata.maxTime);
    }

    // =============================================================================
    // VARIABLES TESTS
    // =============================================================================

    @Test
    void testSimpleVariables() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    variables:
                        score: 0
                        name: "Player"
                        active: true
                        ratio: 1.5
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        assertNotNull(def.variables);
        assertEquals(4, def.variables.size());
        assertTrue(def.variables.containsKey("score"));
        assertTrue(def.variables.containsKey("name"));
        assertTrue(def.variables.containsKey("active"));
        assertTrue(def.variables.containsKey("ratio"));
    }

    @Test
    void testComputedVariables() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    variables:
                        base: 10
                        doubled: 10 * 2
                        sum: 5 + 3
                        product: 100 * 1.5
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        assertNotNull(def.variables);
        assertTrue(def.variables.containsKey("doubled"));
        assertTrue(def.variables.containsKey("sum"));
        assertTrue(def.variables.containsKey("product"));
    }

    // =============================================================================
    // ROOMS TESTS
    // =============================================================================

    @Test
    void testSimpleRoom() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    rooms:
                        entrance:
                            description: "The entrance hall"
                            x: 0
                            y: 0
                            width: 10
                            height: 10
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        assertNotNull(def.rooms);
        assertEquals(1, def.rooms.size());

        Room entrance = def.rooms.get("entrance");
        assertNotNull(entrance);
        assertEquals("The entrance hall", entrance.description);
        assertEquals(0, entrance.x);
        assertEquals(0, entrance.y);
        assertEquals(10, entrance.width);
        assertEquals(10, entrance.height);
    }

    @Test
    void testRoomWithConnections() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    rooms:
                        hall:
                            description: "Main hall"
                            x: 0
                            y: 0
                            width: 10
                            height: 10
                            connections: ["room1", "room2", "room3"]
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        Room hall = def.rooms.get("hall");
        assertNotNull(hall.connections);
        assertEquals(3, hall.connections.size());
        assertTrue(hall.connections.contains("room1"));
        assertTrue(hall.connections.contains("room2"));
        assertTrue(hall.connections.contains("room3"));
    }

    @Test
    void testRoomWithItems() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    rooms:
                        treasure:
                            description: "Treasure room"
                            x: 0
                            y: 0
                            width: 8
                            height: 8
                            items: ["gold_key", "silver_key", "health_potion"]
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        Room treasure = def.rooms.get("treasure");
        assertNotNull(treasure.items);
        assertEquals(3, treasure.items.size());
        assertTrue(treasure.items.contains("gold_key"));
    }

    @Test
    void testRoomWithEventHandlers() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    rooms:
                        entrance:
                            description: "Entry"
                            x: 0
                            y: 0
                            width: 10
                            height: 10

                            on_enter {
                                score += 10
                            }

                            on_first_enter {
                                show_message("Welcome!")
                            }
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        Room entrance = def.rooms.get("entrance");
        assertNotNull(entrance.eventHandlers);
        assertFalse(entrance.eventHandlers.isEmpty());
    }

    // =============================================================================
    // ITEMS TESTS
    // =============================================================================

    @Test
    void testSimpleItem() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    items:
                        golden_key:
                            description: "A shining golden key"
                            type: "tool"
                            texture: "items/key/big_key.png"
                            visible: true
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        assertNotNull(def.items);
        assertEquals(1, def.items.size());

        Item key = def.items.get("golden_key");
        assertNotNull(key);
        assertEquals("A shining golden key", key.description);
        assertEquals("tool", key.type);
        assertEquals("items/key/big_key.png", key.texture);
        assertTrue(key.visible);
    }

    @Test
    void testReadableItem() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    items:
                        ancient_scroll:
                            description: "An ancient scroll"
                            type: "document"
                            texture: "items/book/scroll.png"
                            readable: true
                            content: "The secret is hidden in the north tower."
                            visible: true
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        Item scroll = def.items.get("ancient_scroll");
        assertTrue(scroll.readable);
        assertEquals("The secret is hidden in the north tower.", scroll.content);
    }

    @Test
    void testItemWithEventHandlers() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    items:
                        health_potion:
                            description: "A red potion"
                            type: "tool"
                            texture: "items/potion/health.png"
                            visible: true

                            on_pickup {
                                show_message("Health potion acquired!")
                            }

                            on_use {
                                show_message("You feel refreshed!")
                            }
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        Item potion = def.items.get("health_potion");
        assertNotNull(potion.eventHandlers);
        assertFalse(potion.eventHandlers.isEmpty());
    }

    // =============================================================================
    // NPCs TESTS
    // =============================================================================

    @Test
    void testFriendlyNPC() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    npcs:
                        merchant:
                            description: "A friendly merchant"
                            texture: "character/merchant"
                            location: shop
                            hostile: false
                            dialogue:
                                default: "Welcome to my shop!"
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        assertNotNull(def.npcs);

        NPC merchant = def.npcs.get("merchant");
        assertNotNull(merchant);
        assertFalse(merchant.hostile);
        assertEquals("shop", merchant.location);
        assertNotNull(merchant.dialogue);
    }

    @Test
    void testHostileNPC() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    npcs:
                        skeleton:
                            description: "An undead skeleton"
                            texture: "character/skeleton"
                            hostile: true
                            health: 50
                            damage: 10
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        NPC skeleton = def.npcs.get("skeleton");
        assertTrue(skeleton.hostile);
        assertEquals(50, skeleton.health);
        assertEquals(10, skeleton.damage);
    }

    // =============================================================================
    // QUIZZES TESTS
    // =============================================================================

    @Test
    void testSingleChoiceQuiz() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    quizzes:
                        riddle1:
                            type: single_choice
                            question: "What has keys but no locks?"
                            answers: ["A piano", "A door", "A map"]
                            correct_answers: [0]
                            explanation: "A piano has keys!"
                            reward: golden_key
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        assertNotNull(def.quizzes);

        Quiz riddle = def.quizzes.get("riddle1");
        assertNotNull(riddle);
        assertEquals("single_choice", riddle.type);
        assertEquals("What has keys but no locks?", riddle.question);
        assertEquals(3, riddle.answers.size());
        assertEquals(1, riddle.correctAnswers.size());
        assertEquals(0, riddle.correctAnswers.get(0));
        assertEquals("golden_key", riddle.reward);
    }

    @Test
    void testMultipleChoiceQuiz() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    quizzes:
                        metals_quiz:
                            type: multiple_choice
                            question: "Which are precious metals?"
                            answers: ["Gold", "Iron", "Silver", "Wood"]
                            correct_answers: [0, 2]
                            explanation: "Gold and Silver!"
                            reward: treasure
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        Quiz quiz = def.quizzes.get("metals_quiz");
        assertEquals("multiple_choice", quiz.type);
        assertEquals(2, quiz.correctAnswers.size());
        assertTrue(quiz.correctAnswers.contains(0));
        assertTrue(quiz.correctAnswers.contains(2));
    }

    // =============================================================================
    // PLAYER TESTS
    // =============================================================================

    @Test
    void testPlayerConfiguration() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    player:
                        class: wizard
                        start_x: 50
                        start_y: 30
                        health: 100
                        mana: 80
                        stamina: 120
                        speed: 1.2
                        mana_restore: 2.5
                        stamina_restore: 1.5
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        assertNotNull(def.player);
        assertEquals("wizard", def.player.playerClass); // playerClass not characterClass
        assertEquals(50, def.player.startX);
        assertEquals(30, def.player.startY);
        assertEquals(100, def.player.health);
        assertEquals(80, def.player.mana);
        assertEquals(120, def.player.stamina);
        assertEquals(1.2, def.player.speed, 0.01);
        assertEquals(2.5, def.player.manaRestore, 0.01);
        assertEquals(1.5, def.player.staminaRestore, 0.01);
    }

    // =============================================================================
    // TRIGGERS TESTS
    // =============================================================================

    @Test
    void testSimpleTrigger() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    variables:
                        keys: 0

                    triggers:
                        when (keys >= 3) {
                            show_message("All keys collected!")
                        }
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        assertNotNull(def.triggers);
        assertEquals(1, def.triggers.size());
    }

    @Test
    void testMultipleTriggers() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    variables:
                        score: 0

                    triggers:
                        when (score >= 100) {
                            show_message("Bronze!")
                        }

                        when (score >= 500) {
                            show_message("Silver!")
                        }

                        when (score >= 1000) {
                            show_message("Gold!")
                        }
                """;

        EscapeRoomDefinition def = parseAndInterpret(dsl);
        assertEquals(3, def.triggers.size());
    }

    // =============================================================================
    // CONDITIONAL SYNTAX TESTS
    // =============================================================================

    @Test
    void testIfStatement() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    variables:
                        x: 10

                    rooms:
                        test:
                            description: "Test"
                            x: 0
                            y: 0
                            width: 10
                            height: 10

                            on_enter {
                                if (x > 5) {
                                    show_message("x is greater than 5")
                                }
                            }
                """;

        assertDoesNotThrow(() -> parseAndInterpret(dsl));
    }

    @Test
    void testIfElseStatement() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    rooms:
                        test:
                            description: "Test"
                            x: 0
                            y: 0
                            width: 10
                            height: 10

                            on_enter {
                                if (score >= 100) {
                                    show_message("High score!")
                                } else {
                                    show_message("Keep trying!")
                                }
                            }
                """;

        assertDoesNotThrow(() -> parseAndInterpret(dsl));
    }

    @Test
    void testIfElseIfStatement() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    rooms:
                        test:
                            description: "Test"
                            x: 0
                            y: 0
                            width: 10
                            height: 10

                            on_enter {
                                if (score >= 1000) {
                                    show_message("Gold!")
                                } else if (score >= 500) {
                                    show_message("Silver!")
                                } else if (score >= 100) {
                                    show_message("Bronze!")
                                } else {
                                    show_message("Try harder!")
                                }
                            }
                """;

        assertDoesNotThrow(() -> parseAndInterpret(dsl));
    }

    // =============================================================================
    // LOOP SYNTAX TESTS
    // =============================================================================

    @Test
    void testSimpleRepeat() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    rooms:
                        test:
                            description: "Test"
                            x: 0
                            y: 0
                            width: 10
                            height: 10

                            on_enter {
                                repeat 5 {
                                    print("Hello")
                                }
                            }
                """;

        assertDoesNotThrow(() -> parseAndInterpret(dsl));
    }

    @Test
    void testRepeatWithRange() {
        String dsl = """
                escape_room:
                    metadata:
                        title: "Test"

                    rooms:
                        test:
                            description: "Test"
                            x: 0
                            y: 0
                            width: 10
                            height: 10

                            on_enter {
                                repeat i from 1 to 10 {
                                    print("Number: ", i)
                                }
                            }
                """;

        assertDoesNotThrow(() -> parseAndInterpret(dsl));
    }

    // =============================================================================
    // COMPLEX DSL FILE TEST
    // =============================================================================

    @Test
    void testCompleteShowcaseFile() throws IOException {
        String dslPath = "escapeRoom/src/demoDungeon/level/complete_showcase.esc";
        String dslContent = Files.readString(Paths.get(dslPath));

        assertDoesNotThrow(() -> parseAndInterpret(dslContent),
                "Should parse complete_showcase.esc without errors");
    }
}
