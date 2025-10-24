package dsl;

import core.level.DungeonLevel;
import core.level.utils.DesignLabel;
import core.level.utils.LevelElement;

/**
 * Converts a parsed EscapeRoomDefinition into a playable DungeonLevel.
 * 
 * <p>
 * Supports:
 * - Multiple rooms with automatic sizing
 * - Room connections with corridor generation
 * - Locked doors requiring items
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

        // Generate corridors between connected rooms
        generateCorridors(layout, definition);

        System.out.println("✓ Generated level layout: " + maxX + "x" + maxY +
                " with " + definition.rooms.size() + " room(s)");

        // Debug: print layout
        printLayout(layout);

        return layout;
    }

    /**
     * Prints the layout for debugging.
     */
    private static void printLayout(LevelElement[][] layout) {
        System.out.println("\n=== Level Layout ===");
        for (int y = 0; y < layout.length && y < 25; y++) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < layout[0].length && x < 40; x++) {
                switch (layout[y][x]) {
                    case WALL -> line.append("█");
                    case FLOOR -> line.append("·");
                    case DOOR -> line.append("D");
                    default -> line.append("?");
                }
            }
            System.out.println(line);
        }
        System.out.println("===================\n");
    }

    /**
     * Generates corridors between connected rooms.
     */
    private static void generateCorridors(LevelElement[][] layout, EscapeRoomDefinition definition) {
        if (definition.rooms == null)
            return;

        for (var entry : definition.rooms.entrySet()) {
            String roomId = entry.getKey();
            Room room = entry.getValue();

            if (room.connections == null || room.connections.isEmpty()) {
                continue;
            }

            // Connect this room to each of its connections
            for (String targetRoomId : room.connections) {
                Room targetRoom = definition.rooms.get(targetRoomId);
                if (targetRoom != null) {
                    createCorridor(layout, room, targetRoom);
                    System.out.println("  ✓ Connected '" + roomId + "' to '" + targetRoomId + "'");
                }
            }
        }
    }

    /**
     * Creates a corridor between two rooms.
     */
    private static void createCorridor(LevelElement[][] layout, Room room1, Room room2) {
        // Calculate center points of each room
        int x1 = room1.x + room1.width / 2;
        int y1 = room1.y + room1.height / 2;
        int x2 = room2.x + room2.width / 2;
        int y2 = room2.y + room2.height / 2;

        // Corridor width (2-3 tiles)
        int corridorWidth = 3;

        // Mark door position at room1's edge
        markDoorInWall(layout, room1, x1, y1);

        // Create L-shaped corridor (horizontal then vertical) with width
        // Horizontal segment
        int startX = Math.min(x1, x2);
        int endX = Math.max(x1, x2);
        for (int x = startX; x <= endX && x < layout[0].length; x++) {
            for (int offset = -(corridorWidth / 2); offset <= (corridorWidth / 2); offset++) {
                int y = y1 + offset;
                if (y >= 0 && y < layout.length && x >= 0) {
                    layout[y][x] = LevelElement.FLOOR;
                }
            }
        }

        // Vertical segment
        int startY = Math.min(y1, y2);
        int endY = Math.max(y1, y2);
        for (int y = startY; y <= endY; y++) {
            for (int offset = -(corridorWidth / 2); offset <= (corridorWidth / 2); offset++) {
                int x = x2 + offset;
                if (y >= 0 && y < layout.length && x >= 0 && x < layout[0].length) {
                    layout[y][x] = LevelElement.FLOOR;
                }
            }
        }

        // Mark door position at room2's edge
        markDoorInWall(layout, room2, x2, y2);
    }

    /**
     * Marks a door position in the wall of a room.
     */
    private static void markDoorInWall(LevelElement[][] layout, Room room, int corridorX, int corridorY) {
        // Find where the corridor intersects the room's wall
        int roomLeft = room.x;
        int roomRight = room.x + room.width - 1;
        int roomTop = room.y;
        int roomBottom = room.y + room.height - 1;

        // Check each wall and place door where corridor connects
        // Left wall
        if (corridorX < roomLeft && corridorY >= roomTop && corridorY <= roomBottom) {
            if (roomLeft < layout[0].length && corridorY < layout.length) {
                layout[corridorY][roomLeft] = LevelElement.DOOR;
            }
        }
        // Right wall
        else if (corridorX > roomRight && corridorY >= roomTop && corridorY <= roomBottom) {
            if (roomRight < layout[0].length && corridorY < layout.length) {
                layout[corridorY][roomRight] = LevelElement.DOOR;
            }
        }
        // Top wall
        else if (corridorY < roomTop && corridorX >= roomLeft && corridorX <= roomRight) {
            if (corridorX < layout[0].length && roomTop < layout.length) {
                layout[roomTop][corridorX] = LevelElement.DOOR;
            }
        }
        // Bottom wall
        else if (corridorY > roomBottom && corridorX >= roomLeft && corridorX <= roomRight) {
            if (corridorX < layout[0].length && roomBottom < layout.length) {
                layout[roomBottom][corridorX] = LevelElement.DOOR;
            }
        }
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

        // Add openings in walls where corridors should connect
        // (openings are created automatically by corridor generation now)

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
