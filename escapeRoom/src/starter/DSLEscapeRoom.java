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
import dsl.DSLEntitySpawner;
import dsl.DSLLevelLoader;
import dsl.EscapeRoomDefinition;
import dsl.EscapeRoomVisitor;
import dsl.Item;
import dsl.NPC;
import dsl.Quiz;
import dsl.Room;
import dsl.parser.EscapeRoomDSLLexer;
import dsl.parser.EscapeRoomDSLParser;
import dsl.runtime.DSLRuntime;
import dsl.runtime.ast.EventHandler;
import dsl.runtime.ast.EventType;
import dsl.runtime.ast.Expression;
import dsl.runtime.ast.FunctionCallStatement;
import dsl.runtime.ast.StatementBlock;
import dsl.runtime.ast.StringLiteralExpr;
import dsl.runtime.ast.Trigger;
import dsl.validation.EscapeRoomValidator;
import dsl.validation.ValidationError;
import dsl.validation.ValidationResult;
import dsl.validation.ValidationWarning;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.antlr.v4.runtime.*;

/**
 * Starter for running a DSL-defined escape room. Loads and parses the DSL file,
 * generates the
 * level, and starts the game.
 */
public class DSLEscapeRoom {

  private static final Logger LOGGER = Logger.getLogger(DSLEscapeRoom.class.getSimpleName());

  // Change this to use the dynamic test file
  private static final String DSL_FILE = "escapeRoom/src/demoDungeon/level/complete_showcase.esc";

  private static EscapeRoomDefinition parsedDefinition = null;

  // Tier 1-3: DSL Runtime for dynamic features
  private static DSLRuntime dslRuntime = null;

  // Counter for generating unique IDs for dynamically spawned monsters
  private static int spawnCounter = 0;

  public static void main(String[] args) throws IOException {
    // Initialize game with INFO level to see parsing details
    Game.initBaseLogger(CustomLogLevel.DEBUG);

    // Parse the DSL file
    LOGGER.info("=== Loading Escape Room DSL ===");
    EscapeRoomDefinition definition = parseDSL(DSL_FILE);
    parsedDefinition = definition; // Store for difficulty system

    // Initialize DSL Runtime with dynamic features
    initializeDSLRuntime(definition);

    // Configure game setup
    configureGame(definition);

    // Start the game
    Game.windowTitle(definition.getTitle());
    Game.run();
  }

  /** Get the DSL Runtime instance (for event firing from other classes). */
  public static DSLRuntime getRuntime() {
    return dslRuntime;
  }

  /** Initialize the DSL runtime with variables, triggers, and event handlers. */
  private static void initializeDSLRuntime(EscapeRoomDefinition definition) {
    LOGGER.info("\n=== Initializing DSL Runtime ===");

    dslRuntime = new DSLRuntime();

    // 1. Materialize variables (evaluate initial expressions)
    if (definition.variables != null && !definition.variables.isEmpty()) {
      LOGGER.info("Materializing " + definition.variables.size() + " variables...");
      for (Map.Entry<String, Expression> entry : definition.variables.entrySet()) {
        String name = entry.getKey();
        Expression expr = entry.getValue();
        Object value = expr.evaluate(dslRuntime);
        dslRuntime.defineGlobalVariable(name, value);
        LOGGER.info("  Variable: " + name + " = " + value);
      }
    }

    // 2. Register global triggers
    if (definition.triggers != null && !definition.triggers.isEmpty()) {
      LOGGER.info("Registering " + definition.triggers.size() + " triggers...");
      for (Trigger trigger : definition.triggers) {
        dslRuntime.registerTrigger(trigger);
      }
    }

    // 3. Register room event handlers
    if (definition.rooms != null) {
      for (Map.Entry<String, Room> entry : definition.rooms.entrySet()) {
        String roomId = entry.getKey();
        Room room = entry.getValue();
        if (room.eventHandlers != null) {
          for (EventHandler handler : room.eventHandlers) {
            // Create new handler with attached ID set
            EventHandler boundHandler = new EventHandler(handler.getEventType(), handler.getBody(), roomId, "room");
            dslRuntime.registerEventHandler(boundHandler);
            LOGGER.info("  Room handler: " + roomId + " -> " + handler.getEventType());
          }
        }
      }
    }

    // 4. Register item event handlers
    if (definition.items != null) {
      for (Map.Entry<String, Item> entry : definition.items.entrySet()) {
        String itemId = entry.getKey();
        Item item = entry.getValue();
        if (item.eventHandlers != null) {
          for (EventHandler handler : item.eventHandlers) {
            // Create new handler with attached ID set
            EventHandler boundHandler = new EventHandler(handler.getEventType(), handler.getBody(), itemId, "item");
            dslRuntime.registerEventHandler(boundHandler);
            LOGGER.info("  Item handler: " + itemId + " -> " + handler.getEventType());
          }
        }
      }
    }

    // 5. Register NPC event handlers
    if (definition.npcs != null) {
      for (Map.Entry<String, NPC> entry : definition.npcs.entrySet()) {
        String npcId = entry.getKey();
        NPC npc = entry.getValue();
        if (npc.eventHandlers != null) {
          for (EventHandler handler : npc.eventHandlers) {
            // Create new handler with attached ID set
            EventHandler boundHandler = new EventHandler(handler.getEventType(), handler.getBody(), npcId, "npc");
            dslRuntime.registerEventHandler(boundHandler);
            LOGGER.info("  NPC handler: " + npcId + " -> " + handler.getEventType());
          }
        }
      }
    }

    // 6. Register quiz event handlers
    if (definition.quizzes != null) {
      for (Map.Entry<String, Quiz> entry : definition.quizzes.entrySet()) {
        String quizId = entry.getKey();
        Quiz quiz = entry.getValue();
        if (quiz.eventHandlers != null) {
          for (EventHandler handler : quiz.eventHandlers) {
            // Create new handler with attached ID set
            EventHandler boundHandler = new EventHandler(handler.getEventType(), handler.getBody(), quizId, "quiz");
            dslRuntime.registerEventHandler(boundHandler);
            LOGGER.info("  Quiz handler: " + quizId + " -> " + handler.getEventType());
          }
        }
      }
    }

    // 7. Register global events
    if (definition.events != null) {
      for (dsl.Event event : definition.events) {
        EventType type = null;
        String targetId = null;

        if ("on_puzzle_solved".equals(event.triggerType)) {
          type = EventType.ON_PUZZLE_SOLVED;
          targetId = event.triggerValue;
        } else if ("on_item_collected".equals(event.triggerType)) {
          type = EventType.ON_PICKUP;
          targetId = event.triggerValue;
        } else if ("on_time_warning".equals(event.triggerType)) {
          type = EventType.ON_TIME_WARNING;
          targetId = event.triggerValue; // This is the time value
        }

        if (type != null) {
          List<dsl.runtime.ast.Statement> statements = new java.util.ArrayList<>();
          for (dsl.Event.Action action : event.actions) {
            String funcName = action.type;
            List<Expression> args = new java.util.ArrayList<>();
            args.add(new StringLiteralExpr((String) action.value));

            FunctionCallStatement stmt = new FunctionCallStatement(funcName, args);
            statements.add(stmt);
          }

          StatementBlock body = new StatementBlock(statements);
          EventHandler handler = new EventHandler(type, body, targetId, "global");
          dslRuntime.registerEventHandler(handler);
          LOGGER.info("  Global event: " + type + " -> " + targetId);
        }
      }
    }

    // 8. Register win condition
    if (definition.logic != null && definition.logic.winConditionExpression != null) {
      LOGGER.info("Registering win condition: " + definition.logic.winCondition);

      // Create a trigger that checks the win condition
      // when(winCondition) { victory("You escaped!"); }

      List<dsl.runtime.ast.Statement> statements = new java.util.ArrayList<>();
      List<Expression> args = new java.util.ArrayList<>();
      args.add(new StringLiteralExpr("You escaped!"));
      statements.add(new FunctionCallStatement("victory", args));

      StatementBlock body = new StatementBlock(statements);
      Trigger trigger = new Trigger(definition.logic.winConditionExpression, body);
      dslRuntime.registerTrigger(trigger);
    }

    LOGGER.info("DSL Runtime initialized successfully!");
  }

  /** Parses the DSL file and returns the definition. */
  private static EscapeRoomDefinition parseDSL(String filePath) throws IOException {
    String input = Files.readString(Paths.get(filePath));

    // Create lexer and parser
    CharStream inputStream = CharStreams.fromString(input);
    EscapeRoomDSLLexer lexer = new EscapeRoomDSLLexer(inputStream);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    EscapeRoomDSLParser parser = new EscapeRoomDSLParser(tokens);

    // Parse
    EscapeRoomDSLParser.StartContext tree = parser.start();

    // Interpret using Visitor pattern (cleaner and more maintainable)
    EscapeRoomDefinition definition = EscapeRoomVisitor.interpret(tree);

    // Validate the definition
    LOGGER.info("\n=== Validating DSL Definition ===");
    EscapeRoomValidator validator = new EscapeRoomValidator();
    ValidationResult result = validator.validate(definition);

    // Log errors
    if (!result.getErrors().isEmpty()) {
      System.err.println("\n=== VALIDATION ERRORS ===");
      LOGGER.severe("Found " + result.getErrors().size() + " validation errors:");
      for (ValidationError error : result.getErrors()) {
        String errorMsg = "  [" + error.getType() + "] " + error.getMessage();
        System.err.println(errorMsg);
        LOGGER.severe(errorMsg);
      }
    }

    // Log warnings
    if (!result.getWarnings().isEmpty()) {
      System.err.println("\n=== VALIDATION WARNINGS ===");
      LOGGER.warning("Found " + result.getWarnings().size() + " validation warnings:");
      for (ValidationWarning warning : result.getWarnings()) {
        String warnMsg = "  [" + warning.getType() + "] " + warning.getMessage();
        System.err.println(warnMsg);
        LOGGER.warning(warnMsg);
      }
    }

    // If validation failed, throw exception
    if (!result.isValid()) {
      System.err.println("\n=== VALIDATION FAILED ===");
      throw new RuntimeException(
          "DSL validation failed with " + result.getErrors().size() + " errors. See errors above.");
    }

    LOGGER.info("Validation passed!");
    LOGGER.info("Parsed: " + definition);
    return definition;
  }

  /** Configures the game with the pDSL definition. */
  private static void configureGame(EscapeRoomDefinition definition) {
    Game.userOnSetup(
        () -> {
          LOGGER.info("\n=== Setting up Escape Room ===");

          // Add game systems for movement and controls
          LOGGER.info("Adding game systems...");
          InputSystem inputSystem = new InputSystem();
          inputSystem
              .stop(); // Activate the input system (confusing naming: stop() actually enables
          // input)
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
            LOGGER.info(
                "Enabling Fog of War with view distance: " + definition.getFogViewDistance());
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
            boolean useDSLPosition = definition.player != null
                && definition.player.startX != null
                && definition.player.startY != null;
            Point heroPosition = useDSLPosition
                ? new Point(definition.player.startX, definition.player.startY)
                : DSLEntitySpawner.getRandomFloorPosition();
            if (useDSLPosition) {
              LOGGER.info(
                  "Starting position from DSL: ("
                      + definition.player.startX
                      + ", "
                      + definition.player.startY
                      + ")");
            } else {
              LOGGER.info("Using random starting position");
            }

            if (heroPosition != null) {
              hero.fetch(core.components.PositionComponent.class)
                  .ifPresent(pc -> pc.position(heroPosition));
            }
            Game.add(hero);

            // Setup GameBridge to connect DSL runtime to actual game
            setupGameBridge(hero);

          } catch (IOException e) {
            LOGGER.severe("Failed to create hero: " + e.getMessage());
          }

          // Spawn items, NPCs, and monsters from DSL (pass runtime for event firing)
          DSLEntitySpawner.setRuntime(dslRuntime);
          DSLEntitySpawner.spawnEntities(definition);

          // Add room tracking system for ON_ENTER/ON_EXIT events
          systems.RoomTrackingSystem roomTracker = new systems.RoomTrackingSystem(dslRuntime, definition);
          Game.add(roomTracker);

          // Add trigger check system to evaluate triggers every frame
          systems.TriggerCheckSystem triggerChecker = new systems.TriggerCheckSystem(dslRuntime);
          Game.add(triggerChecker);

          // Set initial room (fire ON_ENTER for the first room)
          if (definition.rooms != null && !definition.rooms.isEmpty()) {
            // Find the room containing the hero
            String startRoom = null;

            // Get hero position safely
            Point heroPos = Game.hero()
                .flatMap(h -> h.fetch(core.components.PositionComponent.class))
                .map(core.components.PositionComponent::position)
                .orElse(null);

            if (heroPos != null) {
              for (Map.Entry<String, Room> entry : definition.rooms.entrySet()) {
                Room room = entry.getValue();
                int width = room.width > 0 ? room.width : 10;
                int height = room.height > 0 ? room.height : 10;

                if (heroPos.x() >= room.x
                    && heroPos.x() < room.x + width
                    && heroPos.y() >= room.y
                    && heroPos.y() < room.y + height) {
                  startRoom = entry.getKey();
                  break;
                }
              }
            }

            if (startRoom == null) {
              // Fallback to first room if not found
              startRoom = definition.rooms.keySet().iterator().next();
              LOGGER.warning(
                  "Could not determine start room from player position, using: " + startRoom);
            } else {
              LOGGER.info("Player started in room: " + startRoom);
            }

            roomTracker.setCurrentRoom(startRoom);
          }

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
   * Applies custom player stats from DSL to the hero entity. Also applies
   * difficulty scaling.
   */
  private static void applyCustomPlayerStats(Entity hero, dsl.Player player) {
    LOGGER.info("=== Applying custom player stats ===");
    LOGGER.info("  health: " + player.health);
    LOGGER.info("  mana: " + player.mana);
    LOGGER.info("  stamina: " + player.stamina);
    LOGGER.info("  manaRestore: " + player.manaRestore);
    LOGGER.info("  staminaRestore: " + player.staminaRestore);

    // Get difficulty modifier
    dsl.DifficultyModifier difficultyMod = null;
    EscapeRoomDefinition currentDef = parsedDefinition; // Store reference
    if (currentDef != null && currentDef.metadata != null) {
      difficultyMod = new dsl.DifficultyModifier(currentDef.metadata.difficulty);
    }

    // Apply custom health (with difficulty scaling)
    if (player.health != null) {
      int finalHealth = player.health;
      if (difficultyMod != null) {
        finalHealth = difficultyMod.scalePlayerHealth(player.health);
      }
      final int healthToSet = finalHealth;
      hero.fetch(contrib.components.HealthComponent.class)
          .ifPresent(
              hc -> {
                hc.maximalHealthpoints(healthToSet);
                hc.currentHealthpoints(healthToSet);
                LOGGER.info("Custom health (after difficulty): " + healthToSet);
              });
    }

    // Apply custom mana (with difficulty scaling)
    if (player.mana != null) {
      int finalMana = player.mana;
      if (difficultyMod != null) {
        finalMana = difficultyMod.scalePlayerMana(player.mana);
      }
      final float manaToSet = finalMana;
      hero.fetch(contrib.components.ManaComponent.class)
          .ifPresent(
              mc -> {
                mc.maxAmount(manaToSet);
                mc.currentAmount(manaToSet);
                LOGGER.info("Custom mana (after difficulty): " + manaToSet);
              });
    }

    // Apply custom stamina (with difficulty scaling)
    if (player.stamina != null) {
      int finalStamina = player.stamina;
      if (difficultyMod != null) {
        finalStamina = difficultyMod.scalePlayerStamina(player.stamina);
      }
      final float staminaToSet = finalStamina;
      hero.fetch(contrib.components.StaminaComponent.class)
          .ifPresent(
              sc -> {
                sc.maxAmount(staminaToSet);
                sc.currentAmount(staminaToSet);
                LOGGER.info("Custom stamina (after difficulty): " + staminaToSet);
              });
    }

    // Apply custom speed
    if (player.speed != null) {
      hero.fetch(core.components.VelocityComponent.class)
          .ifPresent(
              vc -> {
                // VelocityComponent doesn't have a direct speed setter,
                // but maxSpeed is set in constructor. We'll leave this for now
                // as changing speed requires more complex velocity manipulation
                LOGGER.info(
                    "Custom speed configured: "
                        + player.speed
                        + " (velocity system will use this)");
              });
    }

    // Apply custom mana restore rate
    if (player.manaRestore != null) {
      hero.fetch(contrib.components.ManaComponent.class)
          .ifPresent(
              mc -> {
                mc.restorePerSecond(player.manaRestore);
                LOGGER.info("Custom mana restore: " + player.manaRestore);
              });
    }

    // Apply custom stamina restore rate
    if (player.staminaRestore != null) {
      hero.fetch(contrib.components.StaminaComponent.class)
          .ifPresent(
              sc -> {
                sc.restorePerSecond(player.staminaRestore);
                LOGGER.info("Custom stamina restore: " + player.staminaRestore);
              });
    }
  }

  /** Sets up the GameBridge to connect DSL runtime to actual game systems. */
  private static void setupGameBridge(Entity hero) {
    if (dslRuntime == null)
      return;

    dslRuntime.setGameBridge(
        new DSLRuntime.GameBridge() {
          @Override
          public int getPlayerHealth() {
            return hero.fetch(contrib.components.HealthComponent.class)
                .map(hc -> hc.currentHealthpoints())
                .orElse(0);
          }

          @Override
          public void setPlayerHealth(int health) {
            hero.fetch(contrib.components.HealthComponent.class)
                .ifPresent(
                    hc -> {
                      hc.currentHealthpoints(Math.min(health, hc.maximalHealthpoints()));
                    });
          }

          @Override
          public int getPlayerMaxHealth() {
            return hero.fetch(contrib.components.HealthComponent.class)
                .map(hc -> hc.maximalHealthpoints())
                .orElse(100);
          }

          @Override
          public int getPlayerMana() {
            return hero.fetch(contrib.components.ManaComponent.class)
                .map(mc -> (int) mc.currentAmount())
                .orElse(0);
          }

          @Override
          public void setPlayerMana(int mana) {
            hero.fetch(contrib.components.ManaComponent.class)
                .ifPresent(
                    mc -> {
                      mc.currentAmount(Math.min(mana, mc.maxAmount()));
                    });
          }

          @Override
          public int getPlayerGold() {
            // Gold could be tracked in DSL runtime variables
            Object gold = dslRuntime.getVariable("player_gold");
            return gold instanceof Number ? ((Number) gold).intValue() : 0;
          }

          @Override
          public void setPlayerGold(int gold) {
            dslRuntime.setVariable("player_gold", gold);
          }

          @Override
          public boolean hasItem(String itemName) {
            // Check inventory component or DSL variable
            Object inventory = dslRuntime.getVariable("inventory");
            if (inventory instanceof List) {
              return ((List<?>) inventory).contains(itemName);
            }
            return false;
          }

          @Override
          public void giveItem(String itemName) {
            Object inventory = dslRuntime.getVariable("inventory");
            if (inventory == null) {
              inventory = new java.util.ArrayList<String>();
              dslRuntime.defineGlobalVariable("inventory", inventory);
            }
            if (inventory instanceof List) {
              ((List<String>) inventory).add(itemName);
              LOGGER.info("[DSL] Item added to inventory: " + itemName);
            }

            // Sync with actual player inventory
            if (parsedDefinition != null && parsedDefinition.items != null) {
              dsl.Item itemDef = parsedDefinition.items.get(itemName);
              if (itemDef != null) {
                contrib.item.Item gameItem = DSLEntitySpawner.createItemFromDefinition(itemName, itemDef, dslRuntime);
                if (gameItem != null) {
                  hero.fetch(contrib.components.InventoryComponent.class)
                      .ifPresent(
                          inv -> {
                            inv.add(gameItem);
                            LOGGER.info(
                                "[DSL] Item added to player inventory component: " + itemName);
                          });
                } else {
                  LOGGER.warning("[DSL] Failed to create item entity for: " + itemName);
                }
              } else {
                LOGGER.warning("[DSL] Item definition not found for: " + itemName);
              }
            }
          }

          @Override
          public void removeItem(String itemName) {
            Object inventory = dslRuntime.getVariable("inventory");
            if (inventory instanceof List) {
              ((List<?>) inventory).remove(itemName);
              LOGGER.info("[DSL] Item removed from inventory: " + itemName);
            }
          }

          @Override
          public void unlockDoor(String doorId) {
            LOGGER.info("[DSL] Unlocking door: " + doorId);
            dsl.DoorManager.unlockDoor(doorId);
          }

          @Override
          public void lockDoor(String doorId) {
            LOGGER.info("[DSL] Locking door: " + doorId);
            dsl.DoorManager.lockDoorById(doorId, null);
          }

          @Override
          public String getCurrentRoom() {
            // This would need room tracking - for now return from DSL variable
            Object room = dslRuntime.getVariable("current_room");
            return room != null ? room.toString() : "unknown";
          }

          @Override
          public void showMessage(String message) {
            LOGGER.info("[DSL MESSAGE] " + message);
            contrib.hud.DialogUtils.showTextPopup(message, "Message");
            System.out.println(">>> " + message);
          }

          @Override
          public void playSound(String soundName) {
            LOGGER.info("[DSL] Playing sound: " + soundName);
            // TODO: Implement actual sound playing
          }

          @Override
          public void spawnEntity(String entityType, float x, float y) {
            LOGGER.info("[DSL] Spawning entity: " + entityType + " at (" + x + ", " + y + ")");
            // TODO: Implement entity spawning
          }

          @Override
          public void spawnMonster(String npcId) {
            LOGGER.info("[DSL] Spawning monster: " + npcId);

            if (parsedDefinition == null || parsedDefinition.npcs == null) {
              LOGGER.warning("[DSL] Cannot spawn monster - no NPC definitions loaded");
              return;
            }

            NPC npcDef = parsedDefinition.npcs.get(npcId);
            if (npcDef == null) {
              LOGGER.warning("[DSL] NPC definition not found for: " + npcId);
              return;
            }

            try {
              // Get a random floor position in the current room
              Point spawnPos = DSLEntitySpawner.getRandomFloorPosition();
              if (spawnPos == null) {
                LOGGER.warning("[DSL] No valid spawn position found for: " + npcId);
                return;
              }

              // Generate unique entity ID for this spawn
              String uniqueEntityId = npcId + "_spawn_" + (++spawnCounter);

              // Create and spawn the NPC entity with unique ID
              Entity npcEntity = DSLEntitySpawner.createNPCEntity(uniqueEntityId, npcDef, dslRuntime);
              if (npcEntity != null) {
                // Override position to spawn at current location
                npcEntity.fetch(core.components.PositionComponent.class)
                    .ifPresent(pc -> pc.position(spawnPos));

                Game.add(npcEntity);
                LOGGER.info("[DSL] Successfully spawned monster: " + uniqueEntityId + " at " + spawnPos);
              } else {
                LOGGER.warning("[DSL] Failed to create NPC entity for: " + npcId);
              }
            } catch (Exception e) {
              LOGGER.warning("[DSL] Error spawning monster " + npcId + ": " + e.getMessage());
              LOGGER.log(CustomLogLevel.DEBUG, "Monster spawn error details", e);
            }
          }

          @Override
          public void destroyEntity(String entityId) {
            LOGGER.info("[DSL] Destroying entity: " + entityId);
            // TODO: Implement entity destruction
          }

          @Override
          public void victory(String message) {
            LOGGER.info("[DSL VICTORY] " + message);
            System.out.println("\n=== VICTORY ===");
            System.out.println(message);
            System.out.println("===============\n");
            // TODO: Show victory screen and end game
          }

          @Override
          public void gameOver(String message) {
            LOGGER.info("[DSL GAME OVER] " + message);
            System.out.println("\n=== GAME OVER ===");
            System.out.println(message);
            System.out.println("=================\n");
            // TODO: Show game over screen
          }
        });

    LOGGER.info("GameBridge connected to DSL Runtime");
  }
}
