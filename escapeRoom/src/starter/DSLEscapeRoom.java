package starter;

import contrib.entities.HeroFactory;
import contrib.systems.*;
import core.Entity;
import core.Game;
import core.level.DungeonLevel;
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

/**
 * Starter for running a DSL-defined escape room.
 * Loads and parses the DSL file, generates the level, and starts the game.
 */
public class DSLEscapeRoom {

    private static final String DSL_FILE = "escapeRoom/src/demoDungeon/level/demo_room.esc";

    public static void main(String[] args) throws IOException {
        // Initialize game
        Game.initBaseLogger(Level.WARNING);

        // Parse the DSL file
        System.out.println("=== Loading Escape Room DSL ===");
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

        System.out.println("✓ Parsed: " + definition);
        return definition;
    }

    /**
     * Configures the game with the DSL definition.
     */
    private static void configureGame(EscapeRoomDefinition definition) {
        Game.userOnSetup(() -> {
            System.out.println("\n=== Setting up Escape Room ===");

            // Add game systems for movement and controls
            System.out.println("✓ Adding game systems...");
            Game.add(new AISystem());
            Game.add(new PathSystem());
            Game.add(new CollisionSystem());
            Game.add(new HealthSystem());
            Game.add(new ProjectileSystem());
            Game.add(new HudSystem());
            Game.add(new HealthBarSystem());

            // Create and load the level from DSL
            DungeonLevel level = DSLLevelLoader.createLevel(definition);
            Game.currentLevel(level);

            // Spawn door entities now that level is loaded
            DSLLevelLoader.spawnDoorEntities(definition);

            // Create and add hero at a safe floor position
            System.out.println("✓ Creating hero...");
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
                    System.out.println("  Player class: " + characterClass);
                }

                Entity hero = HeroFactory.newHero(characterClass);

                // Set hero position from DSL or use random floor position
                boolean useDSLPosition = definition.player != null && definition.player.startX != null
                        && definition.player.startY != null;
                Point heroPosition = useDSLPosition ? new Point(definition.player.startX, definition.player.startY)
                        : DSLEntitySpawner.getRandomFloorPosition();
                if (useDSLPosition) {
                    System.out.println("  Starting position from DSL: (" + definition.player.startX + ", "
                            + definition.player.startY + ")");
                } else {
                    System.out.println("  Using random starting position");
                }

                if (heroPosition != null) {
                    hero.fetch(core.components.PositionComponent.class).ifPresent(pc -> pc.position(heroPosition));
                }
                Game.add(hero);
            } catch (IOException e) {
                System.err.println("Failed to create hero: " + e.getMessage());
            }

            // Spawn items, NPCs, and monsters from DSL
            DSLEntitySpawner.spawnEntities(definition);

            System.out.println("✓ Escape room setup complete!");
            System.out.println("  Use WASD or arrow keys to move");
            System.out.println("  Press E to interact with chests and NPCs");
            System.out.println();
        });

        // Basic game configuration
        Game.frameRate(30);
        Game.disableAudio(true); // No audio for now
    }
}
