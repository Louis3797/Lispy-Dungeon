package starter;

import contrib.entities.HeroFactory;
import contrib.systems.*;
import core.Entity;
import core.Game;
import core.level.DungeonLevel;
import core.systems.InputSystem;
import core.utils.Point;
import dsl.EscapeRoomDefinition;
import dsl.EscapeRoomInterpreter;
import dsl.DSLLevelLoader;
import dsl.DSLEntitySpawner;
import dsl.parser.EscapeRoomDSLLexer;
import dsl.parser.EscapeRoomDSLParser;
import org.antlr.v4.runtime.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Starter for running a DSL-defined escape room.
 * Loads and parses the DSL file, generates the level, and starts the game.
 */
public class DSLEscapeRoom {

    private static final Logger LOGGER = Logger.getLogger(DSLEscapeRoom.class.getSimpleName());

    private static final String DSL_FILE = "escapeRoom/src/demoDungeon/level/demo_room.esc";

    public static void main(String[] args) throws IOException {
        // Initialize game
        Game.initBaseLogger(Level.WARNING);

        // Parse the DSL file
        LOGGER.info("=== Loading Escape Room DSL ===");
        EscapeRoomDefinition definition = parseDSL(DSL_FILE);

        // Configure game setup
        configureGame(definition);

        // Start the game
        Game.windowTitle(definition.getTitle());
        Game.run();
    }

    /**
     * Parses the DSL file and returns the definition.
     */
    private static EscapeRoomDefinition parseDSL(String filePath) throws IOException {
        String input = Files.readString(Paths.get(filePath));

        // Create lexer and parser
        CharStream inputStream = CharStreams.fromString(input);
        EscapeRoomDSLLexer lexer = new EscapeRoomDSLLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EscapeRoomDSLParser parser = new EscapeRoomDSLParser(tokens);

        // Parse
        EscapeRoomDSLParser.StartContext tree = parser.start();

        // Interpret
        EscapeRoomDefinition definition = EscapeRoomInterpreter.interpret(tree);

        LOGGER.info("Parsed: " + definition);
        return definition;
    }

    /**
     * Configures the game with the pDSL definition.
     */
    private static void configureGame(EscapeRoomDefinition definition) {
        Game.userOnSetup(() -> {
            LOGGER.info("\n=== Setting up Escape Room ===");

            // Add game systems for movement and controls
            LOGGER.info("Adding game systems...");
            InputSystem inputSystem = new InputSystem();
            inputSystem.stop(); // Activate the input system (confusing naming: stop() actually enables input)
            Game.add(inputSystem);
            Game.add(new AISystem());
            Game.add(new PathSystem());
            Game.add(new CollisionSystem());
            Game.add(new HealthSystem());
            Game.add(new ProjectileSystem());
            Game.add(new HudSystem());
            Game.add(new HealthBarSystem());
            Game.add(new ManaRestoreSystem());
            Game.add(new StaminaRestoreSystem());
            Game.add(new ManaBarSystem());
            Game.add(new StaminaBarSystem());

            // Create and load the level from DSL
            DungeonLevel level = DSLLevelLoader.createLevel(definition);
            Game.currentLevel(level);

            // Spawn door entities now that level is loaded
            DSLLevelLoader.spawnDoorEntities(definition);

            // Create and add hero at a safe floor position
            LOGGER.info(" Creating hero...");
            try {
                // Determine character class from DSL or use default (WIZARD)
                contrib.entities.CharacterClass characterClass = contrib.entities.CharacterClass.WIZARD;
                if (definition.player != null && definition.player.characterClass != null) {
                    String classStr = definition.player.characterClass.toLowerCase();
                    if ("hunter".equals(classStr)) {
                        characterClass = contrib.entities.CharacterClass.HUNTER;
                    } else if ("wizard".equals(classStr)) {
                        characterClass = contrib.entities.CharacterClass.WIZARD;
                    }
                    LOGGER.info("Player class: " + characterClass);
                }

                Entity hero = HeroFactory.newHero(characterClass);

                // Set hero position from DSL or use random floor position
                boolean useDSLPosition = definition.player != null && definition.player.startX != null
                        && definition.player.startY != null;
                Point heroPosition = useDSLPosition ? new Point(definition.player.startX, definition.player.startY)
                        : DSLEntitySpawner.getRandomFloorPosition();
                if (useDSLPosition) {
                    LOGGER.info("Starting position from DSL: (" + definition.player.startX + ", "
                            + definition.player.startY + ")");
                } else {
                    LOGGER.info("Using random starting position");
                }

                if (heroPosition != null) {
                    hero.fetch(core.components.PositionComponent.class).ifPresent(pc -> pc.position(heroPosition));
                }
                Game.add(hero);
            } catch (IOException e) {
                LOGGER.severe("Failed to create hero: " + e.getMessage());
            }

            // Spawn items, NPCs, and monsters from DSL
            DSLEntitySpawner.spawnEntities(definition);

            LOGGER.info("Escape room setup complete!");
            LOGGER.info("Use WASD or arrow keys to move");
            LOGGER.info("Press E to interact with chests and NPCs");

        });

        // Basic game configuration
        Game.frameRate(30);
        Game.disableAudio(true); // No audio for now
    }
}
