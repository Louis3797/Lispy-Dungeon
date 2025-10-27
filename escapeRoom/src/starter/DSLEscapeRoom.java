package starter;

import contrib.entities.HeroFactory;
import contrib.systems.*;
import contrib.utils.components.Debugger;
import core.Entity;
import core.Game;
import core.level.DungeonLevel;
import core.systems.InputSystem;
import core.utils.Point;
import core.utils.logging.CustomLogLevel;
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
        // Initialize game with INFO level to see parsing details
        Game.initBaseLogger(CustomLogLevel.DEBUG);

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

            // Configure Fog of War if enabled
            if (definition.isFogOfWarEnabled()) {
                LOGGER.info("Enabling Fog of War with view distance: " + definition.getFogViewDistance());
                Game.add(new FogSystem());
                FogSystem.currentViewDistance(definition.getFogViewDistance());
            }

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
                if (definition.player != null && definition.player.playerClass != null) {
                    String classStr = definition.player.playerClass.toLowerCase();
                    if ("hunter".equals(classStr)) {
                        characterClass = contrib.entities.CharacterClass.HUNTER;
                    } else if ("wizard".equals(classStr)) {
                        characterClass = contrib.entities.CharacterClass.WIZARD;
                    }
                    LOGGER.info("Player class: " + characterClass);
                }

                Entity hero = HeroFactory.newHero(characterClass);

                // Apply custom player stats if specified
                if (definition.player != null) {
                    applyCustomPlayerStats(hero, definition.player);
                }

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

            // Apply camera zoom if specified
            if (definition.getCameraZoom() != 1.0f) {
                LOGGER.info("Setting camera zoom to: " + definition.getCameraZoom());
                Debugger.ZOOM_CAMERA(definition.getCameraZoom() - 1.0f);
            }

            LOGGER.info("Escape room setup complete!");
            LOGGER.info("Use WASD or arrow keys to move");
            LOGGER.info("Press E to interact with chests and NPCs");

        });

        // Basic game configuration
        Game.frameRate(30);
        Game.disableAudio(true); // No audio for now
    }

    /**
     * Applies custom player stats from DSL to the hero entity.
     */
    private static void applyCustomPlayerStats(Entity hero, dsl.Player player) {
        // Apply custom health
        if (player.health != null) {
            hero.fetch(contrib.components.HealthComponent.class).ifPresent(hc -> {
                hc.maximalHealthpoints(player.health);
                hc.currentHealthpoints(player.health);
                LOGGER.info("Custom health: " + player.health);
            });
        }

        // Apply custom mana
        if (player.mana != null) {
            hero.fetch(contrib.components.ManaComponent.class).ifPresent(mc -> {
                mc.maxAmount(player.mana.floatValue());
                mc.currentAmount(player.mana.floatValue());
                LOGGER.info("Custom mana: " + player.mana);
            });
        }

        // Apply custom stamina
        if (player.stamina != null) {
            hero.fetch(contrib.components.StaminaComponent.class).ifPresent(sc -> {
                sc.maxAmount(player.stamina.floatValue());
                sc.currentAmount(player.stamina.floatValue());
                LOGGER.info("Custom stamina: " + player.stamina);
            });
        }

        // Apply custom speed
        if (player.speed != null) {
            hero.fetch(core.components.VelocityComponent.class).ifPresent(vc -> {
                // VelocityComponent doesn't have a direct speed setter,
                // but maxSpeed is set in constructor. We'll leave this for now
                // as changing speed requires more complex velocity manipulation
                LOGGER.info("Custom speed configured: " + player.speed + " (velocity system will use this)");
            });
        }

        // Apply custom mana restore rate
        if (player.manaRestore != null) {
            hero.fetch(contrib.components.ManaComponent.class).ifPresent(mc -> {
                mc.restorePerSecond(player.manaRestore);
                LOGGER.info("Custom mana restore: " + player.manaRestore);
            });
        }

        // Apply custom stamina restore rate
        if (player.staminaRestore != null) {
            hero.fetch(contrib.components.StaminaComponent.class).ifPresent(sc -> {
                sc.restorePerSecond(player.staminaRestore);
                LOGGER.info("Custom stamina restore: " + player.staminaRestore);
            });
        }
    }
}
