package dsl.runtime;

import dsl.runtime.ast.*;
import java.util.*;
import java.util.logging.Logger;

/**
 * Runtime environment for executing DSL code. Manages variables, scopes,
 * built-in functions, and
 * event dispatch.
 */
public class DSLRuntime {
  private static final Logger LOGGER = Logger.getLogger(DSLRuntime.class.getSimpleName());

  // Variable scopes (stack for nested scopes)
  private final Deque<Map<String, Object>> scopes;

  // Built-in functions
  private final Map<String, BuiltinFunction> builtinFunctions;

  // Event handlers indexed by type and entity ID
  private final Map<EventType, Map<String, List<EventHandler>>> eventHandlers;

  // Global triggers
  private final List<Trigger> triggers;

  // Game state references (set by the game integration)
  private GameBridge gameBridge;

  // Track visited rooms for on_first_enter
  private final Set<String> visitedRooms;

  /** Functional interface for built-in functions. */
  @FunctionalInterface
  public interface BuiltinFunction {
    Object call(List<Object> args);
  }

  /** Interface for bridging DSL runtime to actual game functionality. */
  public interface GameBridge {
    // Player properties
    int getPlayerHealth();

    void setPlayerHealth(int health);

    int getPlayerMaxHealth();

    int getPlayerMana();

    void setPlayerMana(int mana);

    int getPlayerGold();

    void setPlayerGold(int gold);

    // Inventory
    boolean hasItem(String itemName);

    void giveItem(String itemName);

    void removeItem(String itemName);

    // Room/Door management
    void unlockDoor(String doorId);

    void lockDoor(String doorId);

    String getCurrentRoom();

    // UI/Effects
    void showMessage(String message);

    void playSound(String soundName);

    // Entity spawning
    void spawnEntity(String entityType, float x, float y);

    void spawnMonster(String npcId);

    void destroyEntity(String entityId);

    // Game state
    void victory(String message);

    void gameOver(String message);
  }

  public DSLRuntime() {
    this.scopes = new ArrayDeque<>();
    this.scopes.push(new HashMap<>()); // Global scope

    this.builtinFunctions = new HashMap<>();
    this.eventHandlers = new EnumMap<>(EventType.class);
    this.triggers = new ArrayList<>();
    this.visitedRooms = new HashSet<>();

    registerBuiltinFunctions();
  }

  // ========================================================================
  // Variable Management
  // ========================================================================

  /** Get a variable value, searching from innermost to outermost scope. */
  public Object getVariable(String name) {
    for (Map<String, Object> scope : scopes) {
      if (scope.containsKey(name)) {
        return scope.get(name);
      }
    }

    // Check for special runtime variables
    if (gameBridge != null) {
      switch (name) {
        case "player":
          return new PlayerProxy(this);
        case "room":
          return gameBridge.getCurrentRoom();
      }
    }

    LOGGER.warning("Undefined variable: " + name);
    return null;
  }

  /** Set a variable in the current scope. */
  public void setVariable(String name, Object value) {
    // Check if variable exists in any scope, update it there
    for (Map<String, Object> scope : scopes) {
      if (scope.containsKey(name)) {
        scope.put(name, value);
        return;
      }
    }
    // Otherwise, create in current (innermost) scope
    scopes.peek().put(name, value);
  }

  /** Define a variable in the global scope. */
  public void defineGlobalVariable(String name, Object value) {
    // Get the global scope (last in deque)
    Map<String, Object> globalScope = null;
    for (Map<String, Object> scope : scopes) {
      globalScope = scope;
    }
    if (globalScope != null) {
      globalScope.put(name, value);
    }
  }

  /** Push a new scope onto the stack. */
  public void pushScope() {
    scopes.push(new HashMap<>());
  }

  /** Pop the current scope from the stack. */
  public void popScope() {
    if (scopes.size() > 1) {
      scopes.pop();
    }
  }

  // ========================================================================
  // Property Access
  // ========================================================================

  /** Get a property from an object. */
  public Object getProperty(Object target, String property) {
    if (target instanceof PlayerProxy) {
      return ((PlayerProxy) target).getProperty(property);
    }
    if (target instanceof Map) {
      return ((Map<?, ?>) target).get(property);
    }
    if (target instanceof String && property.equals("length")) {
      return ((String) target).length();
    }
    if (target instanceof List && property.equals("size")) {
      return ((List<?>) target).size();
    }
    return null;
  }

  /** Get a property by full path (e.g., "player.health"). */
  public Object getPropertyByPath(String path) {
    String[] parts = path.split("\\.");
    Object current = getVariable(parts[0]);

    for (int i = 1; i < parts.length; i++) {
      if (current == null)
        return null;
      current = getProperty(current, parts[i]);
    }

    return current;
  }

  /** Set a property by full path (e.g., "player.health"). */
  public void setPropertyByPath(String path, Object value) {
    String[] parts = path.split("\\.");

    if (parts.length == 1) {
      setVariable(parts[0], value);
      return;
    }

    // Navigate to the parent object
    Object current = getVariable(parts[0]);
    for (int i = 1; i < parts.length - 1; i++) {
      if (current == null) {
        throw new RuntimeException("Cannot set property on null: " + path);
      }
      current = getProperty(current, parts[i]);
    }

    String lastProperty = parts[parts.length - 1];

    if (current instanceof PlayerProxy) {
      ((PlayerProxy) current).setProperty(lastProperty, value);
    } else if (current instanceof Map) {
      ((Map<String, Object>) current).put(lastProperty, value);
    } else {
      throw new RuntimeException(
          "Cannot set property '"
              + lastProperty
              + "' on "
              + (current != null ? current.getClass().getSimpleName() : "null"));
    }
  }

  // ========================================================================
  // Function Calls
  // ========================================================================

  /** Call a function by name with the given arguments. */
  public Object callFunction(String name, List<Object> args) {
    BuiltinFunction func = builtinFunctions.get(name);
    if (func != null) {
      return func.call(args);
    }
    throw new RuntimeException("Unknown function: " + name);
  }

  /** Register the built-in functions. */
  private void registerBuiltinFunctions() {
    // Math functions
    builtinFunctions.put(
        "min",
        args -> {
          checkArgs("min", args, 2);
          double a = toDouble(args.get(0));
          double b = toDouble(args.get(1));
          return simplify(Math.min(a, b), args.get(0), args.get(1));
        });

    builtinFunctions.put(
        "max",
        args -> {
          checkArgs("max", args, 2);
          double a = toDouble(args.get(0));
          double b = toDouble(args.get(1));
          return simplify(Math.max(a, b), args.get(0), args.get(1));
        });

    builtinFunctions.put(
        "abs",
        args -> {
          checkArgs("abs", args, 1);
          double val = toDouble(args.get(0));
          return args.get(0) instanceof Integer ? (int) Math.abs(val) : Math.abs(val);
        });

    builtinFunctions.put(
        "floor",
        args -> {
          checkArgs("floor", args, 1);
          return (int) Math.floor(toDouble(args.get(0)));
        });

    builtinFunctions.put(
        "ceil",
        args -> {
          checkArgs("ceil", args, 1);
          return (int) Math.ceil(toDouble(args.get(0)));
        });

    builtinFunctions.put(
        "round",
        args -> {
          checkArgs("round", args, 1);
          return (int) Math.round(toDouble(args.get(0)));
        });

    builtinFunctions.put(
        "sqrt",
        args -> {
          checkArgs("sqrt", args, 1);
          return Math.sqrt(toDouble(args.get(0)));
        });

    builtinFunctions.put(
        "random",
        args -> {
          if (args.isEmpty()) {
            return Math.random();
          } else if (args.size() == 1) {
            int max = toInt(args.get(0));
            return (int) (Math.random() * max);
          } else {
            int min = toInt(args.get(0));
            int max = toInt(args.get(1));
            return min + (int) (Math.random() * (max - min + 1));
          }
        });

    // String functions
    builtinFunctions.put(
        "length",
        args -> {
          checkArgs("length", args, 1);
          Object arg = args.get(0);
          if (arg instanceof String)
            return ((String) arg).length();
          if (arg instanceof List)
            return ((List<?>) arg).size();
          throw new RuntimeException("length() requires string or list");
        });

    builtinFunctions.put(
        "concat",
        args -> {
          StringBuilder sb = new StringBuilder();
          for (Object arg : args) {
            sb.append(arg != null ? arg.toString() : "null");
          }
          return sb.toString();
        });

    builtinFunctions.put(
        "uppercase",
        args -> {
          checkArgs("uppercase", args, 1);
          return args.get(0).toString().toUpperCase();
        });

    builtinFunctions.put(
        "lowercase",
        args -> {
          checkArgs("lowercase", args, 1);
          return args.get(0).toString().toLowerCase();
        });

    // List functions
    builtinFunctions.put(
        "size",
        args -> {
          checkArgs("size", args, 1);
          Object arg = args.get(0);
          if (arg instanceof List)
            return ((List<?>) arg).size();
          if (arg instanceof String)
            return ((String) arg).length();
          throw new RuntimeException("size() requires list or string");
        });

    builtinFunctions.put(
        "contains",
        args -> {
          checkArgs("contains", args, 2);
          Object container = args.get(0);
          Object element = args.get(1);
          if (container instanceof List)
            return ((List<?>) container).contains(element);
          if (container instanceof String)
            return ((String) container).contains(element.toString());
          return false;
        });

    // Game functions (delegate to game bridge)
    builtinFunctions.put(
        "hasItem",
        args -> {
          checkArgs("hasItem", args, 1);
          if (gameBridge == null)
            return false;
          return gameBridge.hasItem(args.get(0).toString());
        });

    builtinFunctions.put(
        "give_item",
        args -> {
          checkArgs("give_item", args, 1);
          if (gameBridge != null) {
            gameBridge.giveItem(args.get(0).toString());
          }
          return null;
        });

    builtinFunctions.put(
        "remove_item",
        args -> {
          checkArgs("remove_item", args, 1);
          if (gameBridge != null) {
            gameBridge.removeItem(args.get(0).toString());
          }
          return null;
        });

    builtinFunctions.put(
        "show_message",
        args -> {
          checkArgs("show_message", args, 1);
          String message = args.get(0).toString();
          LOGGER.info("[DSL MESSAGE] " + message);
          if (gameBridge != null) {
            gameBridge.showMessage(message);
          }
          return null;
        });

    builtinFunctions.put(
        "play_sound",
        args -> {
          checkArgs("play_sound", args, 1);
          if (gameBridge != null) {
            gameBridge.playSound(args.get(0).toString());
          }
          return null;
        });

    builtinFunctions.put(
        "unlock",
        args -> {
          checkArgs("unlock", args, 1);
          if (gameBridge != null) {
            gameBridge.unlockDoor(args.get(0).toString());
          }
          return null;
        });

    builtinFunctions.put(
        "lock",
        args -> {
          checkArgs("lock", args, 1);
          if (gameBridge != null) {
            gameBridge.lockDoor(args.get(0).toString());
          }
          return null;
        });

    builtinFunctions.put(
        "victory",
        args -> {
          checkArgs("victory", args, 1);
          if (gameBridge != null) {
            gameBridge.victory(args.get(0).toString());
          }
          return null;
        });

    builtinFunctions.put(
        "game_over",
        args -> {
          checkArgs("game_over", args, 1);
          if (gameBridge != null) {
            gameBridge.gameOver(args.get(0).toString());
          }
          return null;
        });

    builtinFunctions.put(
        "spawn",
        args -> {
          if (args.size() < 1) {
            throw new RuntimeException("spawn() requires at least 1 argument");
          }
          if (gameBridge != null) {
            String entityType = args.get(0).toString();
            float x = args.size() > 1 ? (float) toDouble(args.get(1)) : 0;
            float y = args.size() > 2 ? (float) toDouble(args.get(2)) : 0;
            gameBridge.spawnEntity(entityType, x, y);
          }
          return null;
        });

    builtinFunctions.put(
        "spawn_monster",
        args -> {
          checkArgs("spawn_monster", args, 1);
          if (gameBridge != null) {
            String npcId = args.get(0).toString();
            gameBridge.spawnMonster(npcId);
          }
          return null;
        });

    // Utility functions
    builtinFunctions.put(
        "print",
        args -> {
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < args.size(); i++) {
            if (i > 0)
              sb.append(" ");
            sb.append(args.get(i));
          }
          LOGGER.info("[DSL PRINT] " + sb);
          return null;
        });
  }

  private void checkArgs(String funcName, List<Object> args, int expected) {
    if (args.size() != expected) {
      throw new RuntimeException(
          funcName + "() expects " + expected + " arguments, got " + args.size());
    }
  }

  private double toDouble(Object value) {
    if (value instanceof Number)
      return ((Number) value).doubleValue();
    throw new RuntimeException("Expected number, got: " + value);
  }

  private int toInt(Object value) {
    if (value instanceof Number)
      return ((Number) value).intValue();
    throw new RuntimeException("Expected number, got: " + value);
  }

  private Object simplify(double result, Object a, Object b) {
    if (a instanceof Integer && b instanceof Integer && result == Math.floor(result)) {
      return (int) result;
    }
    return result;
  }

  // ========================================================================
  // Event Handling
  // ========================================================================

  /** Register an event handler. */
  public void registerEventHandler(EventHandler handler) {
    eventHandlers
        .computeIfAbsent(handler.getEventType(), k -> new HashMap<>())
        .computeIfAbsent(handler.getAttachedToId(), k -> new ArrayList<>())
        .add(handler);
  }

  /** Fire an event for a specific entity. */
  public void fireEvent(EventType eventType, String entityId) {
    // Handle first_enter specially
    if (eventType == EventType.ON_ENTER) {
      if (!visitedRooms.contains(entityId)) {
        visitedRooms.add(entityId);
        fireEvent(EventType.ON_FIRST_ENTER, entityId);
      }
    }

    Map<String, List<EventHandler>> handlersForType = eventHandlers.get(eventType);
    if (handlersForType != null) {
      List<EventHandler> handlers = handlersForType.get(entityId);
      if (handlers != null) {
        for (EventHandler handler : handlers) {
          try {
            handler.execute(this);
          } catch (Exception e) {
            LOGGER.severe("Error executing event handler: " + e.getMessage());
          }
        }
      }
    }

    // Note: Triggers are checked every frame by TriggerCheckSystem
    // No need to check here to avoid redundant evaluation
  }

  // ========================================================================
  // Trigger Management
  // ========================================================================

  /** Register a global trigger. */
  public void registerTrigger(Trigger trigger) {
    triggers.add(trigger);
  }

  /** Check all triggers and fire any that have their conditions met. */
  public void checkTriggers() {
    for (Trigger trigger : triggers) {
      trigger.checkAndFire(this);
    }
  }

  /** Reset all triggers (for restarting the game). */
  public void resetTriggers() {
    for (Trigger trigger : triggers) {
      trigger.reset();
    }
  }

  // ========================================================================
  // Game Bridge
  // ========================================================================

  public void setGameBridge(GameBridge bridge) {
    this.gameBridge = bridge;
  }

  public GameBridge getGameBridge() {
    return gameBridge;
  }

  // ========================================================================
  // Player Proxy (for player.health, player.mana, etc.)
  // ========================================================================

  /** Proxy object for accessing player properties. */
  public static class PlayerProxy {
    private final DSLRuntime runtime;

    PlayerProxy(DSLRuntime runtime) {
      this.runtime = runtime;
    }

    public Object getProperty(String property) {
      GameBridge bridge = runtime.gameBridge;
      if (bridge == null)
        return 0;

      switch (property) {
        case "health":
          return bridge.getPlayerHealth();
        case "maxHealth":
          return bridge.getPlayerMaxHealth();
        case "mana":
          return bridge.getPlayerMana();
        case "gold":
          return bridge.getPlayerGold();
        default:
          return 0;
      }
    }

    public void setProperty(String property, Object value) {
      GameBridge bridge = runtime.gameBridge;
      if (bridge == null)
        return;

      int intValue = value instanceof Number ? ((Number) value).intValue() : 0;

      switch (property) {
        case "health":
          bridge.setPlayerHealth(intValue);
          break;
        case "mana":
          bridge.setPlayerMana(intValue);
          break;
        case "gold":
          bridge.setPlayerGold(intValue);
          break;
      }
    }
  }
}
