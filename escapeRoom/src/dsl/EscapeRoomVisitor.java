package dsl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import core.utils.logging.CustomLogLevel;
import dsl.parser.EscapeRoomDSLBaseVisitor;
import dsl.parser.EscapeRoomDSLParser;

/**
 * Visitor-based interpreter for the Escape Room DSL.
 * This approach is cleaner and more maintainable than the listener pattern.
 */
public class EscapeRoomVisitor extends EscapeRoomDSLBaseVisitor<Void> {

    private static final Logger LOGGER = Logger.getLogger(EscapeRoomVisitor.class.getSimpleName());

    private final EscapeRoomDefinition definition;

    public EscapeRoomVisitor() {
        this.definition = new EscapeRoomDefinition();
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
                definition.metadata.viewDistance = parseIntOrDefault(propCtx.view_distance_property().INT().getText(),
                        7);
            } else if (propCtx.camera_zoom_property() != null) {
                definition.metadata.cameraZoom = parseFloatOrDefault(propCtx.camera_zoom_property().FLOAT().getText(),
                        1.0f);
            }
        }

        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found title: " + definition.metadata.title);
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found description: " + definition.metadata.description);
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found difficulty: " + definition.metadata.difficulty);
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found max_time: " + definition.metadata.maxTime);
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found fog_of_war: " + definition.metadata.fogOfWar);
        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Found view_distance: " + definition.metadata.viewDistance);

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
            }  else if (propCtx.room_connections_property() != null) {
                room.connections = parseArray(propCtx.room_connections_property().array());
                LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Room connections=" + room.connections);
            }
        }

        LOGGER.info("Room '" + roomId + "' parsed: " +
                "position=(" + room.x + "," + room.y + "), " +
                "size=" + room.width + "x" + room.height + ", " +
                "connections=" + room.connections + ", " +
                "lockedBy=" + room.lockedBy + ", " +
                "hasPattern=" + (room.pattern != null));

        return null;
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
                definition.player.speed = parseFloatOrDefault(propCtx.player_speed_property().FLOAT().getText(), 1.0f);
            } else if (propCtx.player_mana_restore_property() != null) {
                definition.player.manaRestore = parseFloatOrDefault(
                        propCtx.player_mana_restore_property().FLOAT().getText(), 0.1f);
            } else if (propCtx.player_stamina_restore_property() != null) {
                definition.player.staminaRestore = parseFloatOrDefault(
                        propCtx.player_stamina_restore_property().FLOAT().getText(), 0.1f);
            }
        }

        LOGGER.log(CustomLogLevel.DEBUG, "DEBUG: Player class: " + definition.player.playerClass);

        return null;
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
                }
            }
        }
        return result;
    }




    // Utility methods for cleaner parsing

    /**
     * Removes surrounding quotes from a string literal.
     */
    private String unquote(String text) {
        if (text == null)
            return null;
        if (text.length() >= 2 && text.startsWith("\"") && text.endsWith("\"")) {
            return text.substring(1, text.length() - 1);
        }
        return text;
    }

    /**
     * Parses an integer with a default fallback value.
     */
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

    /**
     * Parses a float with a default fallback value.
     */
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

    /**
     * Static method to parse DSL using the visitor pattern.
     */
    public static EscapeRoomDefinition interpret(EscapeRoomDSLParser.StartContext tree) {
        EscapeRoomVisitor visitor = new EscapeRoomVisitor();
        visitor.visit(tree);
        return visitor.getDefinition();
    }
}
