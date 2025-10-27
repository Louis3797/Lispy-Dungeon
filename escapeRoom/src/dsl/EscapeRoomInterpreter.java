package dsl;

import dsl.parser.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import core.utils.logging.CustomLogLevel;

import java.util.*;
import java.util.logging.Logger;

/**
 * Interprets the parsed escape room DSL and builds the game structure.
 */
public class EscapeRoomInterpreter extends EscapeRoomDSLBaseListener {

    private static final Logger LOGGER = Logger.getLogger(EscapeRoomInterpreter.class.getSimpleName());

    private EscapeRoomDefinition definition;
    private String currentId;
    private Room currentRoom;
    private Quiz currentQuiz;
    private Item currentItem;
    private NPC currentNPC;

    public EscapeRoomInterpreter() {
        this.definition = new EscapeRoomDefinition();
    }

    public EscapeRoomDefinition getDefinition() {
        return definition;
    }

    @Override
    public void enterEscape_room(EscapeRoomDSLParser.Escape_roomContext ctx) {
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Entering escape_room");
    }

    @Override
    public void enterMetadata(EscapeRoomDSLParser.MetadataContext ctx) {
        definition.metadata = new Metadata();

        // Get the full text to properly identify which field each string belongs to
        String fullText = ctx.getText();

        // Extract metadata fields by checking which field each string corresponds to
        if (ctx.STRING() != null && !ctx.STRING().isEmpty()) {
            for (TerminalNode strNode : ctx.STRING()) {
                String text = strNode.getText();
                // Remove quotes
                text = text.substring(1, text.length() - 1);

                // Find which field this string belongs to by checking the text before it
                int stringPos = ctx.getText().indexOf(strNode.getText());
                String textBefore = stringPos > 0 ? fullText.substring(0, stringPos) : "";

                if (textBefore.contains("title:") && definition.metadata.title == null) {
                    definition.metadata.title = text;
                } else if (textBefore.contains("description:") && definition.metadata.description == null) {
                    definition.metadata.description = text;
                } else if (textBefore.contains("difficulty:") && definition.metadata.difficulty == null) {
                    definition.metadata.difficulty = text;
                }
            }
        }

        // Extract max_time
        if (ctx.INT() != null && fullText.contains("max_time:")) {
            definition.metadata.maxTime = Integer.parseInt(ctx.INT().get(0).getText());
        }

        // Extract fog_of_war (parse from text)
        if (fullText.contains("fog_of_war:")) {
            String[] parts = fullText.split("fog_of_war:");
            if (parts.length > 1) {
                String value = parts[1].trim().split("\\s")[0];
                definition.metadata.fogOfWar = value.equals("true");
            }
        }

        // Extract view_distance (parse from text)
        if (fullText.contains("view_distance:")) {
            String[] parts = fullText.split("view_distance:");
            if (parts.length > 1) {
                try {
                    String value = parts[1].trim().split("\\s")[0];
                    definition.metadata.viewDistance = Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    // Use default
                }
            }
        }

        // Extract camera_zoom (parse from text)
        if (fullText.contains("camera_zoom:")) {
            String[] parts = fullText.split("camera_zoom:");
            if (parts.length > 1) {
                try {
                    String value = parts[1].trim().split("\\s")[0];
                    definition.metadata.cameraZoom = Float.parseFloat(value);
                } catch (NumberFormatException e) {
                    // Use default
                }
            }
        }

        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found title: " + definition.metadata.title);
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found description: " + definition.metadata.description);
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found difficulty: " + definition.metadata.difficulty);
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found max_time: " + definition.metadata.maxTime);
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found fog_of_war: " + definition.metadata.fogOfWar);
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found view_distance: " + definition.metadata.viewDistance);
    }

    @Override
    public void enterRooms(EscapeRoomDSLParser.RoomsContext ctx) {
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Entering rooms section");
        if (definition.rooms == null) {
            definition.rooms = new HashMap<>();
        }
    }

    @Override
    public void exitRooms(EscapeRoomDSLParser.RoomsContext ctx) {
        LOGGER.info("Total rooms parsed: " + (definition.rooms != null ? definition.rooms.size() : 0));
        if (definition.rooms != null) {
            LOGGER.info("Room IDs: " + definition.rooms.keySet());
        }
    }

    @Override
    public void enterRoom(EscapeRoomDSLParser.RoomContext ctx) {
        currentRoom = new Room();
        if (ctx.ID() != null && !ctx.ID().isEmpty()) {
            currentId = ctx.ID(0).getText();
            definition.rooms.put(currentId, currentRoom);
            LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found room: " + currentId);

            // Parse room properties
            if (ctx.STRING() != null) {
                // STRING is description
                String desc = ctx.STRING().getText();
                currentRoom.description = desc.substring(1, desc.length() - 1);
            }

            // Parse pattern (multiline string for ASCII art)
            if (ctx.multiline_string() != null) {
                String pattern = ctx.multiline_string().getText();
                // Remove the """ delimiters
                if (pattern.startsWith("\"\"\"") && pattern.endsWith("\"\"\"")) {
                    pattern = pattern.substring(3, pattern.length() - 3);
                }
                currentRoom.pattern = pattern;
                LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Room has custom pattern (ASCII art)");
            }

            // Parse integers (x, y, width, height)
            if (ctx.INT() != null && !ctx.INT().isEmpty()) {
                int intIndex = 0;
                String text = ctx.getText();

                if (text.contains("x:") && ctx.INT().size() > intIndex) {
                    currentRoom.x = Integer.parseInt(ctx.INT(intIndex++).getText());
                }
                if (text.contains("y:") && ctx.INT().size() > intIndex) {
                    currentRoom.y = Integer.parseInt(ctx.INT(intIndex++).getText());
                }
                if (text.contains("width:") && ctx.INT().size() > intIndex) {
                    currentRoom.width = Integer.parseInt(ctx.INT(intIndex++).getText());
                }
                if (text.contains("height:") && ctx.INT().size() > intIndex) {
                    currentRoom.height = Integer.parseInt(ctx.INT(intIndex++).getText());
                }
            }

            // Parse arrays (items, connections)
            if (ctx.array() != null && !ctx.array().isEmpty()) {
                for (var arrayCtx : ctx.array()) {
                    String parentText = ctx.getText();
                    List<String> values = parseArray(arrayCtx);

                    if (parentText.contains("items:")) {
                        currentRoom.items = values;
                    } else if (parentText.contains("connections:")) {
                        currentRoom.connections = values;
                    }
                }
            }

            // Parse locked_by
            if (ctx.ID().size() > 1) {
                String text = ctx.getText();
                if (text.contains("locked_by:")) {
                    currentRoom.lockedBy = ctx.ID(ctx.ID().size() - 1).getText();
                }
            }
        }
    }

    @Override
    public void exitRoom(EscapeRoomDSLParser.RoomContext ctx) {
        if (currentRoom != null && currentId != null) {
            LOGGER.info("Room '" + currentId + "' parsed: connections=" + currentRoom.connections +
                    ", lockedBy=" + currentRoom.lockedBy + ", size=" + currentRoom.width + "x" + currentRoom.height);
        }
        currentRoom = null;
        currentId = null;
    }

    @Override
    public void enterItems(EscapeRoomDSLParser.ItemsContext ctx) {
        LOGGER.log(CustomLogLevel.DEBUG, "Entering items section");
        if (definition.items == null) {
            definition.items = new HashMap<>();
        }
    }

    @Override
    public void enterItem(EscapeRoomDSLParser.ItemContext ctx) {
        currentItem = new Item();
        if (ctx.ID() != null) {
            currentId = ctx.ID().getText();
            definition.items.put(currentId, currentItem);
            LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found item: " + currentId);
        }
    }

    @Override
    public void enterItem_property(EscapeRoomDSLParser.Item_propertyContext ctx) {
        if (currentItem == null)
            return;

        String text = ctx.getText();
        if (text.startsWith("description:") && ctx.STRING() != null) {
            currentItem.description = ctx.STRING().getText().replaceAll("^\"|\"$", "");
        } else if (text.startsWith("type:") && ctx.STRING() != null) {
            currentItem.type = ctx.STRING().getText().replaceAll("^\"|\"$", "");
        } else if (text.startsWith("texture:") && ctx.STRING() != null) {
            currentItem.texture = ctx.STRING().getText().replaceAll("^\"|\"$", "");
        } else if (text.startsWith("visible:") && ctx.BOOLEAN() != null) {
            currentItem.visible = Boolean.parseBoolean(ctx.BOOLEAN().getText());
        } else if (text.startsWith("readable:") && ctx.BOOLEAN() != null) {
            currentItem.readable = Boolean.parseBoolean(ctx.BOOLEAN().getText());
        } else if (text.startsWith("content:") && ctx.STRING() != null) {
            currentItem.content = ctx.STRING().getText().replaceAll("^\"|\"$", "");
        }
    }

    @Override
    public void exitItem(EscapeRoomDSLParser.ItemContext ctx) {
        currentItem = null;
        currentId = null;
    }

    @Override
    public void enterNpcs(EscapeRoomDSLParser.NpcsContext ctx) {
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Entering npcs section");
        if (definition.npcs == null) {
            definition.npcs = new HashMap<>();
        }
    }

    @Override
    public void enterNpc(EscapeRoomDSLParser.NpcContext ctx) {
        currentNPC = new NPC();
        if (ctx.ID() != null) {
            currentId = ctx.ID().getText();
            definition.npcs.put(currentId, currentNPC);
            LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found npc: " + currentId);
        }
    }

    @Override
    public void enterNpc_property(EscapeRoomDSLParser.Npc_propertyContext ctx) {
        if (currentNPC == null)
            return;

        String text = ctx.getText();
        if (text.startsWith("description:") && ctx.STRING() != null) {
            currentNPC.description = ctx.STRING().getText().replaceAll("^\"|\"$", "");
        } else if (text.startsWith("texture:") && ctx.STRING() != null) {
            currentNPC.texture = ctx.STRING().getText().replaceAll("^\"|\"$", "");
        } else if (text.startsWith("location:") && ctx.ID() != null) {
            currentNPC.location = ctx.ID().getText();
        } else if (text.startsWith("hostile:")) {
            // Parse boolean value from text
            String boolText = text.substring("hostile:".length());
            currentNPC.hostile = Boolean.parseBoolean(boolText);
        } else if (text.startsWith("health:") && ctx.INT() != null) {
            currentNPC.health = Integer.parseInt(ctx.INT().getText());
        } else if (text.startsWith("damage:") && ctx.INT() != null) {
            currentNPC.damage = Integer.parseInt(ctx.INT().getText());
        }
    }

    @Override
    public void exitNpc(EscapeRoomDSLParser.NpcContext ctx) {
        currentNPC = null;
        currentId = null;
    }

    @Override
    public void enterPlayer(EscapeRoomDSLParser.PlayerContext ctx) {
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Entering player section");
        definition.player = new Player();

        String text = ctx.getText();

        // Parse class
        if (ctx.PLAYER_CLASS() != null) {
            definition.player.playerClass = ctx.PLAYER_CLASS().getText();
            LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Player class: " + definition.player.playerClass);
        }

        // Parse numeric values from text
        if (text.contains("start_x:")) {
            definition.player.startX = parseIntFromText(text, "start_x:");
        }
        if (text.contains("start_y:")) {
            definition.player.startY = parseIntFromText(text, "start_y:");
        }
        if (text.contains("health:")) {
            definition.player.health = parseIntFromText(text, "health:");
        }
        if (text.contains("mana:")) {
            definition.player.mana = parseIntFromText(text, "mana:");
        }
        if (text.contains("stamina:")) {
            definition.player.stamina = parseIntFromText(text, "stamina:");
        }
        if (text.contains("speed:")) {
            definition.player.speed = parseFloatFromText(text, "speed:");
        }
        if (text.contains("mana_restore:")) {
            definition.player.manaRestore = parseFloatFromText(text, "mana_restore:");
        }
        if (text.contains("stamina_restore:")) {
            definition.player.staminaRestore = parseFloatFromText(text, "stamina_restore:");
        }
    }

    private Integer parseIntFromText(String text, String key) {
        try {
            String[] parts = text.split(key);
            if (parts.length > 1) {
                String value = parts[1].split("[^0-9]")[0];
                if (!value.isEmpty()) {
                    return Integer.parseInt(value);
                }
            }
        } catch (Exception e) {
            // Return null if parsing fails
        }
        return null;
    }

    private Float parseFloatFromText(String text, String key) {
        try {
            String[] parts = text.split(key);
            if (parts.length > 1) {
                String value = parts[1].split("\\s")[0];
                if (!value.isEmpty()) {
                    return Float.parseFloat(value);
                }
            }
        } catch (Exception e) {
            // Return null if parsing fails
        }
        return null;
    }

    @Override
    public void enterQuizzes(EscapeRoomDSLParser.QuizzesContext ctx) {
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Entering quizzes section");
        if (definition.quizzes == null) {
            definition.quizzes = new HashMap<>();
        }
    }

    @Override
    public void enterQuiz(EscapeRoomDSLParser.QuizContext ctx) {
        currentQuiz = new Quiz();
        if (ctx.ID() != null) {
            currentId = ctx.ID().getText();
            definition.quizzes.put(currentId, currentQuiz);
            LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found quiz: " + currentId);
        }
    }

    @Override
    public void enterQuiz_property(EscapeRoomDSLParser.Quiz_propertyContext ctx) {
        if (currentQuiz == null)
            return;

        String text = ctx.getText();
        if (text.startsWith("type:") && ctx.QUIZ_TYPE() != null) {
            currentQuiz.type = ctx.QUIZ_TYPE().getText();
        } else if (text.startsWith("question:") && ctx.STRING() != null) {
            currentQuiz.question = ctx.STRING().getText().replaceAll("^\"|\"$", "");
        } else if (text.startsWith("answers:") && ctx.array() != null) {
            currentQuiz.answers = parseArray(ctx.array());
        } else if (text.startsWith("correct_answers:") && ctx.array() != null) {
            currentQuiz.correctAnswers = parseIntArray(ctx.array());
        } else if (text.startsWith("explanation:") && ctx.STRING() != null) {
            currentQuiz.explanation = ctx.STRING().getText().replaceAll("^\"|\"$", "");
        } else if (text.startsWith("reward:") && ctx.ID() != null) {
            currentQuiz.reward = ctx.ID().getText();
        } else if (text.startsWith("attached_to:") && ctx.ID() != null) {
            currentQuiz.attachedTo = ctx.ID().getText();
        }
    }

    @Override
    public void exitQuiz(EscapeRoomDSLParser.QuizContext ctx) {
        currentQuiz = null;
        currentId = null;
    }

    /**
     * Parse an array of strings.
     */
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

    /**
     * Parse an array of integers (e.g., for correct answer indices).
     */
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

    /**
     * Parse the DSL and build the definition.
     */
    public static EscapeRoomDefinition interpret(EscapeRoomDSLParser.StartContext tree) {
        EscapeRoomInterpreter interpreter = new EscapeRoomInterpreter();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(interpreter, tree);
        return interpreter.getDefinition();
    }
}
