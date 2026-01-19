package dsl;

import core.utils.logging.CustomLogLevel;
import dsl.parser.*;
import dsl.runtime.ExpressionVisitor;
import dsl.runtime.StatementVisitor;
import dsl.runtime.ast.EventHandler;
import dsl.runtime.ast.Expression;
import java.util.*;
import java.util.logging.Logger;

/**
 * Visitor-based interpreter for the Escape Room DSL. This approach is cleaner
 * and more maintainable
 * than the listener pattern.
 */
public class EscapeRoomVisitor extends EscapeRoomDSLBaseVisitor<Void> {

  private static final Logger LOGGER = Logger.getLogger(EscapeRoomVisitor.class.getSimpleName());

  private final EscapeRoomDefinition definition;
  private final ExpressionVisitor expressionVisitor;
  private final StatementVisitor statementVisitor;

  public EscapeRoomVisitor() {
    this.definition = new EscapeRoomDefinition();
    this.expressionVisitor = new ExpressionVisitor();
    this.statementVisitor = new StatementVisitor();
  }

  public EscapeRoomDefinition getDefinition() {
    return definition;
  }

  @Override
  public Void visitEscape_room(EscapeRoomDSLParser.Escape_roomContext ctx) {
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Visiting escape_room");
    return visitChildren(ctx);
  }

  @Override
  public Void visitVariables_block(EscapeRoomDSLParser.Variables_blockContext ctx) {
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Visiting variables block");

    for (var varDef : ctx.variable_def()) {
      String name = varDef.ID().getText();
      Expression value = expressionVisitor.visit(varDef.expression());
      definition.variables.put(name, value);
      LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Variable defined: " + name + " = " + value);
    }

    return null;
  }

  @Override
  public Void visitTriggers_block(EscapeRoomDSLParser.Triggers_blockContext ctx) {
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Visiting triggers block");
    definition.triggers = statementVisitor.parseTriggers(ctx);
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found " + definition.triggers.size() + " triggers");
    return null;
  }

  @Override
  public Void visitMetadata(EscapeRoomDSLParser.MetadataContext ctx) {
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Visiting metadata");
    definition.metadata = new Metadata();

    // Visit each property using the explicit grammar rules
    for (EscapeRoomDSLParser.Metadata_propertyContext propCtx : ctx.metadata_property()) {
      if (propCtx.title_property() != null) {
        definition.metadata.title = unquote(propCtx.title_property().STRING().getText());
      } else if (propCtx.description_property() != null) {
        definition.metadata.description = unquote(propCtx.description_property().STRING().getText());
      } else if (propCtx.difficulty_property() != null) {
        definition.metadata.difficulty = unquote(propCtx.difficulty_property().STRING().getText());
      } else if (propCtx.max_time_property() != null) {
        definition.metadata.maxTime = parseIntOrDefault(propCtx.max_time_property().INT().getText(), 0);
      } else if (propCtx.fog_of_war_property() != null) {
        definition.metadata.fogOfWar = Boolean.parseBoolean(propCtx.fog_of_war_property().BOOLEAN().getText());
      } else if (propCtx.view_distance_property() != null) {
        definition.metadata.viewDistance = parseIntOrDefault(propCtx.view_distance_property().INT().getText(), 7);
      } else if (propCtx.camera_zoom_property() != null) {
        definition.metadata.cameraZoom = parseFloatOrDefault(propCtx.camera_zoom_property().FLOAT().getText(), 1.0f);
      }
    }

    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found title: " + definition.metadata.title);
    LOGGER.log(
        CustomLogLevel.DEBUG, "DEBUG: Found description: " + definition.metadata.description);
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found difficulty: " + definition.metadata.difficulty);
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found max_time: " + definition.metadata.maxTime);
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found fog_of_war: " + definition.metadata.fogOfWar);
    LOGGER.log(
        CustomLogLevel.DEBUG, "DEBUG: Found view_distance: " + definition.metadata.viewDistance);

    return null;
  }

  @Override
  public Void visitRooms(EscapeRoomDSLParser.RoomsContext ctx) {
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Visiting rooms section");
    if (definition.rooms == null) {
      definition.rooms = new HashMap<>();
    }
    return visitChildren(ctx);
  }

  @Override
  public Void visitRoom(EscapeRoomDSLParser.RoomContext ctx) {
    Room room = new Room();

    // Get room ID from the first ID token
    String roomId = ctx.ID().getText();
    definition.rooms.put(roomId, room);
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found room: " + roomId);

    // Visit each property using the explicit grammar rules
    for (EscapeRoomDSLParser.Room_propertyContext propCtx : ctx.room_property()) {
      if (propCtx.room_description_property() != null) {
        room.description = unquote(propCtx.room_description_property().STRING().getText());
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Room description set");
      } else if (propCtx.room_x_property() != null) {
        room.x = parseIntOrDefault(propCtx.room_x_property().INT().getText(), 0);
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Room x=" + room.x);
      } else if (propCtx.room_y_property() != null) {
        room.y = parseIntOrDefault(propCtx.room_y_property().INT().getText(), 0);
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Room y=" + room.y);
      } else if (propCtx.room_width_property() != null) {
        room.width = parseIntOrDefault(propCtx.room_width_property().INT().getText(), 0);
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Room width=" + room.width);
      } else if (propCtx.room_height_property() != null) {
        room.height = parseIntOrDefault(propCtx.room_height_property().INT().getText(), 0);
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Room height=" + room.height);
      } else if (propCtx.room_pattern_property() != null) {
        String pattern = propCtx.room_pattern_property().multiline_string().getText();
        if (pattern.startsWith("\"\"\"") && pattern.endsWith("\"\"\"")) {
          pattern = pattern.substring(3, pattern.length() - 3);
        }
        room.pattern = pattern;
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Room has custom pattern (ASCII art)");
      } else if (propCtx.room_items_property() != null) {
        room.items = parseArray(propCtx.room_items_property().array());
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Room items=" + room.items);
      } else if (propCtx.room_connections_property() != null) {
        room.connections = parseArray(propCtx.room_connections_property().array());
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Room connections=" + room.connections);
      } else if (propCtx.room_locked_by_property() != null) {
        room.lockedBy = propCtx.room_locked_by_property().ID().getText();
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Room locked_by=" + room.lockedBy);
      } else if (propCtx.event_handler() != null) {
        // Parse event handler
        EventHandler handler = statementVisitor.parseEventHandler(propCtx.event_handler());
        room.eventHandlers.add(handler);
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Room event handler: " + handler.getEventType());
      }
    }

    LOGGER.info(
        "Room '"
            + roomId
            + "' parsed: "
            + "position=("
            + room.x
            + ","
            + room.y
            + "), "
            + "size="
            + room.width
            + "x"
            + room.height
            + ", "
            + "connections="
            + room.connections
            + ", "
            + "lockedBy="
            + room.lockedBy
            + ", "
            + "hasPattern="
            + (room.pattern != null)
            + ", "
            + "eventHandlers="
            + room.eventHandlers.size());

    return null;
  }

  @Override
  public Void visitItems(EscapeRoomDSLParser.ItemsContext ctx) {
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Visiting items section");
    if (definition.items == null) {
      definition.items = new HashMap<>();
    }
    return visitChildren(ctx);
  }

  @Override
  public Void visitItem(EscapeRoomDSLParser.ItemContext ctx) {
    Item item = new Item();

    if (ctx.ID() != null) {
      String itemId = ctx.ID().getText();
      definition.items.put(itemId, item);
      LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found item: " + itemId);

      // Visit all item properties
      for (var propCtx : ctx.item_property()) {
        visitItem_property_internal(propCtx, item);
      }
    }

    return null;
  }

  private void visitItem_property_internal(
      EscapeRoomDSLParser.Item_propertyContext ctx, Item item) {
    if (ctx.item_description_property() != null) {
      item.description = unquote(ctx.item_description_property().STRING().getText());
    } else if (ctx.item_type_property() != null) {
      item.type = unquote(ctx.item_type_property().STRING().getText());
    } else if (ctx.item_texture_property() != null) {
      item.texture = unquote(ctx.item_texture_property().STRING().getText());
    } else if (ctx.item_visible_property() != null) {
      item.visible = Boolean.parseBoolean(ctx.item_visible_property().BOOLEAN().getText());
    } else if (ctx.item_readable_property() != null) {
      item.readable = Boolean.parseBoolean(ctx.item_readable_property().BOOLEAN().getText());
    } else if (ctx.item_content_property() != null) {
      item.content = unquote(ctx.item_content_property().STRING().getText());
    } else if (ctx.event_handler() != null) {
      // Parse event handler
      EventHandler handler = statementVisitor.parseEventHandler(ctx.event_handler());
      item.eventHandlers.add(handler);
      LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Item event handler: " + handler.getEventType());
    }
  }

  @Override
  public Void visitNpcs(EscapeRoomDSLParser.NpcsContext ctx) {
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Visiting npcs section");
    if (definition.npcs == null) {
      definition.npcs = new HashMap<>();
    }
    return visitChildren(ctx);
  }

  @Override
  public Void visitNpc(EscapeRoomDSLParser.NpcContext ctx) {
    NPC npc = new NPC();

    if (ctx.ID() != null) {
      String npcId = ctx.ID().getText();
      definition.npcs.put(npcId, npc);
      LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found npc: " + npcId);

      // Visit all npc properties
      for (var propCtx : ctx.npc_property()) {
        visitNpc_property_internal(propCtx, npc);
      }
    }

    return null;
  }

  private void visitNpc_property_internal(EscapeRoomDSLParser.Npc_propertyContext ctx, NPC npc) {
    if (ctx.npc_description_property() != null) {
      npc.description = unquote(ctx.npc_description_property().STRING().getText());
    } else if (ctx.npc_texture_property() != null) {
      npc.texture = unquote(ctx.npc_texture_property().STRING().getText());
    } else if (ctx.npc_location_property() != null) {
      npc.location = ctx.npc_location_property().ID().getText();
    } else if (ctx.npc_hostile_property() != null) {
      npc.hostile = Boolean.parseBoolean(ctx.npc_hostile_property().BOOLEAN().getText());
    } else if (ctx.npc_health_property() != null) {
      npc.health = parseIntOrDefault(ctx.npc_health_property().INT().getText(), 0);
    } else if (ctx.npc_damage_property() != null) {
      npc.damage = parseIntOrDefault(ctx.npc_damage_property().INT().getText(), 0);
    } else if (ctx.npc_dialogue_property() != null) {
      npc.dialogue = parseDialogue(ctx.npc_dialogue_property().dialogue());
    } else if (ctx.npc_gives_items_property() != null) {
      npc.givesItems = parseArray(ctx.npc_gives_items_property().array());
    } else if (ctx.npc_requires_items_property() != null) {
      npc.requiresItems = parseArray(ctx.npc_requires_items_property().array());
    } else if (ctx.event_handler() != null) {
      // parse event handler
      EventHandler handler = statementVisitor.parseEventHandler(ctx.event_handler());
      npc.eventHandlers.add(handler);
      LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: NPC event handler: " + handler.getEventType());
    }
  }

  @Override
  public Void visitPlayer(EscapeRoomDSLParser.PlayerContext ctx) {
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Visiting player section");
    definition.player = new Player();

    // Visit each property using the explicit grammar rules
    for (EscapeRoomDSLParser.Player_propertyContext propCtx : ctx.player_property()) {
      if (propCtx.player_class_property() != null) {
        definition.player.playerClass = propCtx.player_class_property().PLAYER_CLASS().getText();
      } else if (propCtx.player_start_x_property() != null) {
        definition.player.startX = parseIntOrDefault(propCtx.player_start_x_property().INT().getText(), 0);
      } else if (propCtx.player_start_y_property() != null) {
        definition.player.startY = parseIntOrDefault(propCtx.player_start_y_property().INT().getText(), 0);
      } else if (propCtx.player_health_property() != null) {
        definition.player.health = parseIntOrDefault(propCtx.player_health_property().INT().getText(), 100);
      } else if (propCtx.player_mana_property() != null) {
        definition.player.mana = parseIntOrDefault(propCtx.player_mana_property().INT().getText(), 100);
      } else if (propCtx.player_stamina_property() != null) {
        definition.player.stamina = parseIntOrDefault(propCtx.player_stamina_property().INT().getText(), 100);
      } else if (propCtx.player_speed_property() != null) {
        var speedCtx = propCtx.player_speed_property();
        String text = speedCtx.FLOAT() != null ? speedCtx.FLOAT().getText() : speedCtx.INT().getText();
        definition.player.speed = parseFloatOrDefault(text, 1.0f);
      } else if (propCtx.player_mana_restore_property() != null) {
        var manaCtx = propCtx.player_mana_restore_property();
        String text = manaCtx.FLOAT() != null ? manaCtx.FLOAT().getText() : manaCtx.INT().getText();
        definition.player.manaRestore = parseFloatOrDefault(text, 0.1f);
      } else if (propCtx.player_stamina_restore_property() != null) {
        var staminaCtx = propCtx.player_stamina_restore_property();
        String text = staminaCtx.FLOAT() != null
            ? staminaCtx.FLOAT().getText()
            : staminaCtx.INT().getText();
        definition.player.staminaRestore = parseFloatOrDefault(text, 0.1f);
      }
    }

    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Player class: " + definition.player.playerClass);

    return null;
  }

  @Override
  public Void visitQuizzes(EscapeRoomDSLParser.QuizzesContext ctx) {
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Visiting quizzes section");
    if (definition.quizzes == null) {
      definition.quizzes = new HashMap<>();
    }
    return visitChildren(ctx);
  }

  @Override
  public Void visitQuiz(EscapeRoomDSLParser.QuizContext ctx) {
    Quiz quiz = new Quiz();

    if (ctx.ID() != null) {
      String quizId = ctx.ID().getText();
      definition.quizzes.put(quizId, quiz);
      LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found quiz: " + quizId);

      // Visit all quiz properties
      for (var propCtx : ctx.quiz_property()) {
        visitQuiz_property_internal(propCtx, quiz);
      }
    }

    return null;
  }

  private void visitQuiz_property_internal(
      EscapeRoomDSLParser.Quiz_propertyContext ctx, Quiz quiz) {
    if (ctx.quiz_type_property() != null) {
      quiz.type = ctx.quiz_type_property().QUIZ_TYPE().getText();
    } else if (ctx.quiz_question_property() != null) {
      quiz.question = unquote(ctx.quiz_question_property().STRING().getText());
    } else if (ctx.quiz_answers_property() != null) {
      quiz.answers = parseArray(ctx.quiz_answers_property().array());
    } else if (ctx.quiz_correct_answers_property() != null) {
      quiz.correctAnswers = parseIntArray(ctx.quiz_correct_answers_property().array());
    } else if (ctx.quiz_explanation_property() != null) {
      quiz.explanation = unquote(ctx.quiz_explanation_property().STRING().getText());
    } else if (ctx.quiz_reward_property() != null) {
      quiz.reward = ctx.quiz_reward_property().ID().getText();
    } else if (ctx.quiz_attached_to_property() != null) {
      quiz.attachedTo = ctx.quiz_attached_to_property().ID().getText();
    } else if (ctx.event_handler() != null) {
      // Parse event handler
      EventHandler handler = statementVisitor.parseEventHandler(ctx.event_handler());
      quiz.eventHandlers.add(handler);
      LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Quiz event handler: " + handler.getEventType());
    }
  }

  @Override
  public Void visitLogic(EscapeRoomDSLParser.LogicContext ctx) {
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Visiting logic section");
    definition.logic = new Logic();

    if (ctx.logic_expr() != null) {
      definition.logic.winCondition = ctx.logic_expr().getText();
      definition.logic.winConditionExpression = parseLogicExpr(ctx.logic_expr());
    }

    // Parse dependencies if present
    if (ctx.dependencies() != null) {
      for (var dep : ctx.dependencies().dependency()) {
        String key = dep.ID(0).getText();
        String value = dep.ID(1).getText();
        // Logic class doesn't have a dependencies map yet, but we can add it if needed.
        // For now, we just log it.
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Dependency: " + key + " -> " + value);
      }
    }

    return null;
  }

  private Expression parseLogicExpr(EscapeRoomDSLParser.Logic_exprContext ctx) {
    Expression left = parseLogicTerm(ctx.logic_term(0));

    for (int i = 1; i < ctx.logic_term().size(); i++) {
      Expression right = parseLogicTerm(ctx.logic_term(i));
      String op = ctx.getChild(2 * i - 1).getText(); // AND or OR

      if ("AND".equals(op)) {
        left = new dsl.runtime.ast.BinaryExpr(left, "&&", right);
      } else if ("OR".equals(op)) {
        left = new dsl.runtime.ast.BinaryExpr(left, "||", right);
      }
    }

    return left;
  }

  private Expression parseLogicTerm(EscapeRoomDSLParser.Logic_termContext ctx) {
    if (ctx.ID() != null) {
      return new dsl.runtime.ast.IdentifierExpr(ctx.ID().getText());
    } else if (ctx.logic_expr() != null) {
      return parseLogicExpr(ctx.logic_expr());
    }
    return null;
  }

  @Override
  public Void visitEvents(EscapeRoomDSLParser.EventsContext ctx) {
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Visiting events section");
    definition.events = new ArrayList<>();
    return visitChildren(ctx);
  }

  @Override
  public Void visitEvent(EscapeRoomDSLParser.EventContext ctx) {
    Event event = new Event();

    // Parse trigger
    var triggerCtx = ctx.event_trigger();
    if (triggerCtx.getText().startsWith("on_puzzle_solved")) {
      event.triggerType = "on_puzzle_solved";
      event.triggerValue = triggerCtx.ID().getText();
    } else if (triggerCtx.getText().startsWith("on_item_collected")) {
      event.triggerType = "on_item_collected";
      event.triggerValue = triggerCtx.ID().getText();
    } else if (triggerCtx.getText().startsWith("on_time_warning")) {
      event.triggerType = "on_time_warning";
      event.triggerValue = triggerCtx.INT().getText();
    }

    // Parse actions
    for (var actionCtx : ctx.action()) {
      Event.Action action = new Event.Action();
      action.type = actionCtx.action_type().getText();
      action.value = actionCtx.value().getText(); // This might need better parsing depending on value type
      event.actions.add(action);
    }

    definition.events.add(event);
    LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Added event with trigger: " + event.triggerType);

    return null;
  }

  /** Parse an array of strings. */
  private List<String> parseArray(EscapeRoomDSLParser.ArrayContext ctx) {
    List<String> result = new ArrayList<>();
    if (ctx != null && ctx.value() != null) {
      for (EscapeRoomDSLParser.ValueContext valueCtx : ctx.value()) {
        if (valueCtx.STRING() != null) {
          String value = valueCtx.STRING().getText().replaceAll("^\"|\"$", "");
          result.add(value);
        } else if (valueCtx.ID() != null) {
          result.add(valueCtx.ID().getText());
        } else if (valueCtx.ITEM_TYPE() != null) {
          result.add(valueCtx.ITEM_TYPE().getText());
        }
      }
    }
    return result;
  }

  /** Parse an array of integers (e.g., for correct answer indices). */
  private List<Integer> parseIntArray(EscapeRoomDSLParser.ArrayContext ctx) {
    List<Integer> result = new ArrayList<>();
    if (ctx != null && ctx.value() != null) {
      for (EscapeRoomDSLParser.ValueContext valueCtx : ctx.value()) {
        if (valueCtx.INT() != null) {
          result.add(Integer.parseInt(valueCtx.INT().getText()));
        }
      }
    }
    return result;
  }

  /** Parse dialogue map from dialogue context. */
  private Map<String, String> parseDialogue(EscapeRoomDSLParser.DialogueContext ctx) {
    Map<String, String> result = new HashMap<>();
    if (ctx != null && ctx.dialogue_property() != null) {
      for (EscapeRoomDSLParser.Dialogue_propertyContext propCtx : ctx.dialogue_property()) {
        if (propCtx.STRING() != null) {
          String text = propCtx.getText();
          String value = unquote(propCtx.STRING().getText());

          if (text.startsWith("default_text:") || text.startsWith("default:")) {
            result.put("default", value);
          }
        } else if (propCtx.dialogue_conditions() != null) {
          // Parse conditional dialogue
          for (EscapeRoomDSLParser.Dialogue_conditionContext condCtx : propCtx.dialogue_conditions()
              .dialogue_condition()) {
            String key = condCtx.ID().getText();
            String value = unquote(condCtx.STRING().getText());
            result.put(key, value);
          }
        }
      }
    }
    return result;
  }

  // Utility methods for cleaner parsing

  /** Removes surrounding quotes from a string literal. */
  private String unquote(String text) {
    if (text == null)
      return null;
    if (text.length() >= 2 && text.startsWith("\"") && text.endsWith("\"")) {
      return text.substring(1, text.length() - 1);
    }
    return text;
  }

  /** Parses an integer with a default fallback value. */
  private int parseIntOrDefault(String text, int defaultValue) {
    if (text == null)
      return defaultValue;
    try {
      return Integer.parseInt(text);
    } catch (NumberFormatException e) {
      LOGGER.warning("Failed to parse integer '" + text + "', using default: " + defaultValue);
      return defaultValue;
    }
  }

  /** Parses a float with a default fallback value. */
  private float parseFloatOrDefault(String text, float defaultValue) {
    if (text == null)
      return defaultValue;
    try {
      return Float.parseFloat(text);
    } catch (NumberFormatException e) {
      LOGGER.warning("Failed to parse float '" + text + "', using default: " + defaultValue);
      return defaultValue;
    }
  }

  /** Static method to parse DSL using the visitor pattern. */
  public static EscapeRoomDefinition interpret(EscapeRoomDSLParser.StartContext tree) {
    EscapeRoomVisitor visitor = new EscapeRoomVisitor();
    visitor.visit(tree);
    return visitor.getDefinition();
  }
}
