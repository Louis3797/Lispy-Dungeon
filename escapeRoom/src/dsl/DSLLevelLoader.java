package dsl;

import core.level.DungeonLevel;
import core.level.utils.DesignLabel;
import core.level.utils.LevelElement;
import java.util.*;

/**
 * Converts a parsed EscapeRoomDefinition into a playable DungeonLevel.
 */
public class DSLLevelLoader {

    /**
     * Creates a DungeonLevel from the parsed DSL definition.
     * 
     * @param definition The parsed escape room definition
     * @return A playable dungeon level
     */
    public static DungeonLevel createLevel(EscapeRoomDefinition definition) {
        // Generate the level layout from room definitions
        LevelElement[][] layout = generateLayout(definition);

        // Create the level with the layout
        DungeonLevel level = new DungeonLevel(layout, DesignLabel.DEFAULT);

        System.out.println("✓ Level created: " + definition.getTitle());

        return level;
    }

    /**
     * Generates a 2D level layout from room definitions.
     */
    private static LevelElement[][] generateLayout(EscapeRoomDefinition definition) {
        if (definition.rooms == null || definition.rooms.isEmpty()) {
            return createDefaultLayout();
        }

        // Calculate required grid size based on room positions
        int maxX = 0, maxY = 0;
        for (Room room : definition.rooms.values()) {
            int roomEndX = room.x + (room.width > 0 ? room.width : 10);
            int roomEndY = room.y + (room.height > 0 ? room.height : 10);
            maxX = Math.max(maxX, roomEndX);
            maxY = Math.max(maxY, roomEndY);
        }

        // Add padding
        maxX += 2;
        maxY += 2;

        // Initialize layout with walls
        LevelElement[][] layout = new LevelElement[maxY][maxX];
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                layout[y][x] = LevelElement.WALL;
            }
        }

        // Place rooms
        for (Room room : definition.rooms.values()) {
            placeRoom(layout, room);
        }

        System.out.println("✓ Generated level layout: " + maxX + "x" + maxY +
                " with " + definition.rooms.size() + " room(s)");

        return layout;
    }

    /**
     * Places a single room in the layout.
     */
    private static void placeRoom(LevelElement[][] layout, Room room) {
        int startX = room.x > 0 ? room.x : 1;
        int startY = room.y > 0 ? room.y : 1;
        int width = room.width > 0 ? room.width : 10;
        int height = room.height > 0 ? room.height : 10;

        // Create room interior (floor)
        for (int y = startY; y < startY + height && y < layout.length; y++) {
            for (int x = startX; x < startX + width && x < layout[0].length; x++) {
                // Leave walls at edges, floor in middle
                if (x == startX || x == startX + width - 1 ||
                        y == startY || y == startY + height - 1) {
                    layout[y][x] = LevelElement.WALL;
                } else {
                    layout[y][x] = LevelElement.FLOOR;
                }
            }
        }

        // Add a door/opening in one wall (for entrance)
        int doorX = startX + width / 2;
        int doorY = startY + height / 2;
        if (doorY >= 0 && doorY < layout.length && startX >= 0 && startX < layout[0].length) {
            layout[doorY][startX] = LevelElement.FLOOR; // Left wall opening
        }

        System.out.println("  ✓ Placed room at (" + startX + "," + startY +
                ") size " + width + "x" + height);
    }

    /**
     * Creates a default fallback layout if no rooms are defined.
     */
    private static LevelElement[][] createDefaultLayout() {
        LevelElement[][] layout = new LevelElement[15][15];
        for (int y = 0; y < 15; y++) {
            for (int x = 0; x < 15; x++) {
                if (x == 0 || x == 14 || y == 0 || y == 14) {
                    layout[y][x] = LevelElement.WALL;
                } else {
                    layout[y][x] = LevelElement.FLOOR;
                }
            }
        }
        System.out.println("⚠ Using default 15x15 layout (no rooms defined)");
        return layout;
    }
}
