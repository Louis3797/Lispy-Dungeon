package dsl;

import core.Entity;
import core.Game;
import core.level.DungeonLevel;
import core.level.Tile;
import core.level.elements.tile.DoorTile;
import core.level.utils.DesignLabel;
import core.level.utils.LevelElement;
import core.utils.Point;
import core.components.PositionComponent;
import core.components.DrawComponent;
import contrib.components.CollideComponent;
import core.utils.logging.CustomLogLevel;

import dsl.utils.AnimationFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

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

    private static final Logger LOGGER = Logger.getLogger(DSLLevelLoader.class.getSimpleName());

    // Configuration constants for level generation
    private static final int CORRIDOR_WIDTH = 3;
    private static final int CORRIDOR_WALL_COUNT = 2; // Walls on each side of door (-2 to +2)
    private static final int DEFAULT_ROOM_SIZE = 10;
    private static final int LAYOUT_PADDING = 2;
    private static final int DEFAULT_LAYOUT_SIZE = 15;
    private static final int DEBUG_PRINT_MAX_HEIGHT = 25;
    private static final int DEBUG_PRINT_MAX_WIDTH = 40;

    // Store door positions for entity spawning
    private static final List<DoorInfo> doorPositions = new ArrayList<>();

    /**
     * Helper class to store door information.
     */
    private static class DoorInfo {
        Point position;
        @SuppressWarnings("unused") // Kept for debugging purposes
        String roomId;
        String requiredItemId; // null if unlocked
        String direction; // "top", "bottom", "left", "right"

        DoorInfo(Point position, String roomId, String requiredItemId, String direction) {
            this.position = position;
            this.roomId = roomId;
            this.requiredItemId = requiredItemId;
            this.direction = direction;
        }
    }

    /**
     * Creates a DungeonLevel from the parsed DSL definition.
     * 
     * @param definition The parsed escape room definition
     * @return A playable dungeon level
     * @throws NullPointerException if definition is null
     */
    public static DungeonLevel createLevel(EscapeRoomDefinition definition) {
        Objects.requireNonNull(definition, "definition cannot be null");

        // Clear previous door data
        doorPositions.clear();
        DoorManager.clear();

        // Generate the level layout from room definitions
        LevelElement[][] layout = generateLayout(definition);

        // Create the level with the layout
        DungeonLevel level = new DungeonLevel(layout, DesignLabel.DEFAULT);

        LOGGER.info("Level created: " + definition.getTitle());

        return level;
    }

    /**
     * Spawns door entities in the game world after the level is loaded.
     * Must be called after Game.currentLevel() is set.
     * 
     * @param definition The escape room definition with room/door data
     * @throws NullPointerException if definition is null
     */
    public static void spawnDoorEntities(EscapeRoomDefinition definition) {
        Objects.requireNonNull(definition, "definition cannot be null");
        LOGGER.info("=== Spawning Door Entities ===");

        var levelOpt = Game.currentLevel();
        if (levelOpt.isEmpty()) {
            LOGGER.warning("No level loaded, cannot spawn doors");
            return;
        }

        DungeonLevel level = (DungeonLevel) levelOpt.get();

        // Build a map of rooms that require keys
        Map<String, String> roomLocks = new HashMap<>();
        if (definition.rooms != null) {
            for (var entry : definition.rooms.entrySet()) {
                String roomId = entry.getKey();
                Room room = entry.getValue();
                if (room.lockedBy != null && !room.lockedBy.isEmpty()) {
                    roomLocks.put(roomId, room.lockedBy);
                    LOGGER.info("Room '" + roomId + "' requires: " + room.lockedBy);
                }
            }
        }

        // Spawn door entities at marked positions
        int doorsSpawned = 0;
        for (DoorInfo doorInfo : doorPositions) {
            // Get the actual door tile from the level
            Tile tile = level.tileAt(doorInfo.position).orElse(null);
            if (tile instanceof DoorTile doorTile) {
                // Create list to track wall entities for this door
                List<Entity> wallEntities = new ArrayList<>();

                // Spawn wall entities on both sides to block the corridor
                // Spawn walls to fully block corridor (extend based on CORRIDOR_WALL_COUNT)
                for (int i = -CORRIDOR_WALL_COUNT; i <= CORRIDOR_WALL_COUNT; i++) {
                    if (i == 0)
                        continue; // Skip center (that's where the door is)

                    Point wallPos;
                    // Calculate wall position based on door direction
                    if (doorInfo.direction.equals("left") || doorInfo.direction.equals("right")) {
                        // Horizontal door - walls go vertically (above and below)
                        wallPos = doorInfo.position.translate(0, i);
                    } else {
                        // Vertical door - walls go horizontally (left and right)
                        wallPos = doorInfo.position.translate(i, 0);
                    }

                    // Create wall entity to block the corridor with visible texture
                    Entity wallEntity = new Entity("DoorWall");
                    wallEntity.add(new PositionComponent(wallPos));
                    wallEntity.add(new CollideComponent());
                    wallEntity.add(new DrawComponent(AnimationFactory.createSingleFrameAnimation(
                            "dungeon/default/wall/side.png")));

                    Game.add(wallEntity);
                    wallEntities.add(wallEntity);
                }

                // Spawn the door entity at the center position
                Entity doorEntity;
                if (doorInfo.requiredItemId != null) {
                    // Locked door
                    DoorManager.lockDoor(doorTile, doorInfo.requiredItemId);
                    doorEntity = DoorEntityFactory.createLockedDoorIndicator(
                            doorTile,
                            doorInfo.requiredItemId,
                            doorInfo.position,
                            doorInfo.direction,
                            wallEntities);
                } else {
                    // Unlocked door - keep walls
                    doorEntity = DoorEntityFactory.createUnlockedDoorIndicator(
                            doorTile,
                            doorInfo.position,
                            doorInfo.direction);
                }
                Game.add(doorEntity);

                doorsSpawned++;
            }
        }

        LOGGER.info("Spawned " + doorsSpawned + " door entities with corridor walls");
    }

    /**
     * Generates a 2D level layout from room definitions.
     * 
     * @param definition The escape room definition containing room layouts
     * @return A 2D array representing the level layout
     */
    private static LevelElement[][] generateLayout(EscapeRoomDefinition definition) {
        if (definition.rooms == null || definition.rooms.isEmpty()) {
            return createDefaultLayout();
        }

        // Calculate required grid size based on room positions
        int maxX = 0, maxY = 0;
        for (Room room : definition.rooms.values()) {
            int roomEndX = room.x + (room.width > 0 ? room.width : DEFAULT_ROOM_SIZE);
            int roomEndY = room.y + (room.height > 0 ? room.height : DEFAULT_ROOM_SIZE);
            maxX = Math.max(maxX, roomEndX);
            maxY = Math.max(maxY, roomEndY);
        }

        // Add padding
        maxX += LAYOUT_PADDING;
        maxY += LAYOUT_PADDING;

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

        LOGGER.info("Generated level layout: " + maxX + "x" + maxY + " with " + definition.rooms.size() + " room(s)");

        // Debug: print layout
        printLayout(layout);

        return layout;
    }

    /**
     * Prints the layout for debugging.
     * 
     * @param layout The level layout to print
     */
    private static void printLayout(LevelElement[][] layout) {
        LOGGER.log(CustomLogLevel.DEBUG, "\n=== Level Layout ===");
        for (int y = 0; y < layout.length && y < DEBUG_PRINT_MAX_HEIGHT; y++) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < layout[0].length && x < DEBUG_PRINT_MAX_WIDTH; x++) {
                switch (layout[y][x]) {
                    case WALL -> line.append("█");
                    case FLOOR -> line.append("·");
                    case DOOR -> line.append("D");
                    default -> line.append("?");
                }
            }
            LOGGER.log(CustomLogLevel.DEBUG, line.toString());
        }
        LOGGER.log(CustomLogLevel.DEBUG, "===================\n");
    }

    /**
     * Generates corridors between connected rooms.
     * 
     * @param layout     The level layout to modify
     * @param definition The escape room definition containing room connections
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
                    createCorridor(layout, roomId, room, targetRoomId, targetRoom);
                    LOGGER.info("Connected '" + roomId + "' to '" + targetRoomId + "'");
                }
            }
        }
    }

    /**
     * Creates a corridor between two rooms.
     */
    private static void createCorridor(LevelElement[][] layout, String room1Id, Room room1, String room2Id,
            Room room2) {
        // Calculate center points of each room
        int x1 = room1.x + room1.width / 2;
        int y1 = room1.y + room1.height / 2;
        int x2 = room2.x + room2.width / 2;
        int y2 = room2.y + room2.height / 2;

        // Create L-shaped corridor (horizontal then vertical) with CORRIDOR_WIDTH
        // Horizontal segment
        int startX = Math.min(x1, x2);
        int endX = Math.max(x1, x2);
        for (int x = startX; x <= endX && x < layout[0].length; x++) {
            for (int offset = -(CORRIDOR_WIDTH / 2); offset <= (CORRIDOR_WIDTH / 2); offset++) {
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
            for (int offset = -(CORRIDOR_WIDTH / 2); offset <= (CORRIDOR_WIDTH / 2); offset++) {
                int x = x2 + offset;
                if (y >= 0 && y < layout.length && x >= 0 && x < layout[0].length) {
                    layout[y][x] = LevelElement.FLOOR;
                }
            }
        }

        // Mark door positions where corridors meet room walls
        // For room1: check horizontal corridor approaching from the direction of room2
        if (x2 < x1) {
            // Corridor comes from the left
            markDoorInWall(layout, room1Id, room1, room1.x - 1, y1);
        } else {
            // Corridor comes from the right
            markDoorInWall(layout, room1Id, room1, room1.x + room1.width, y1);
        }

        // For room2: check vertical corridor approaching from the direction of room1
        if (y1 < y2) {
            // Corridor comes from above
            markDoorInWall(layout, room2Id, room2, x2, room2.y - 1);
        } else {
            // Corridor comes from below
            markDoorInWall(layout, room2Id, room2, x2, room2.y + room2.height);
        }
    }

    /**
     * Marks a door position in the wall of a room and tracks it for entity
     * spawning.
     * 
     * @param layout    The level layout to modify
     * @param roomId    The ID of the room
     * @param room      The room definition
     * @param corridorX The X coordinate where corridor connects
     * @param corridorY The Y coordinate where corridor connects
     */
    private static void markDoorInWall(LevelElement[][] layout, String roomId, Room room, int corridorX,
            int corridorY) {
        // Find where the corridor intersects the room's wall
        int roomLeft = room.x;
        int roomRight = room.x + room.width - 1;
        int roomTop = room.y;
        int roomBottom = room.y + room.height - 1;

        Point doorPos = null;
        String direction = null;

        // Check each wall and place door where corridor connects
        // Left wall (corridor approaching from the west)
        if (corridorX < roomLeft && corridorY >= roomTop && corridorY <= roomBottom) {
            if (roomLeft < layout[0].length && corridorY < layout.length) {
                layout[corridorY][roomLeft] = LevelElement.DOOR;
                doorPos = new Point(roomLeft, corridorY);
                direction = "left"; // Door faces left (player comes from left/west)
                LOGGER.log(CustomLogLevel.DEBUG,
                        "Marked door at LEFT wall of '" + roomId + "' at (" + roomLeft + "," + corridorY + ")");
            }
        }
        // Right wall (corridor approaching from the east)
        else if (corridorX > roomRight && corridorY >= roomTop && corridorY <= roomBottom) {
            if (roomRight < layout[0].length && corridorY < layout.length) {
                layout[corridorY][roomRight] = LevelElement.DOOR;
                doorPos = new Point(roomRight, corridorY);
                direction = "right"; // Door faces right (player comes from right/east)
                LOGGER.log(CustomLogLevel.DEBUG,
                        "Marked door at RIGHT wall of '" + roomId + "' at (" + roomRight + "," + corridorY + ")");
            }
        }
        // Top wall (corridor approaching from the north)
        else if (corridorY < roomTop && corridorX >= roomLeft && corridorX <= roomRight) {
            if (corridorX < layout[0].length && roomTop < layout.length) {
                layout[roomTop][corridorX] = LevelElement.DOOR;
                doorPos = new Point(corridorX, roomTop);
                direction = "top"; // Door faces top (player comes from top/north)
                LOGGER.log(CustomLogLevel.DEBUG,
                        "Marked door at TOP wall of '" + roomId + "' at (" + corridorX + "," + roomTop + ")");
            }
        }
        // Bottom wall (corridor approaching from the south)
        else if (corridorY > roomBottom && corridorX >= roomLeft && corridorX <= roomRight) {
            if (corridorX < layout[0].length && roomBottom < layout.length) {
                layout[roomBottom][corridorX] = LevelElement.DOOR;
                doorPos = new Point(corridorX, roomBottom);
                direction = "bottom"; // Door faces bottom (player comes from bottom/south)
                LOGGER.log(CustomLogLevel.DEBUG,
                        "Marked door at BOTTOM wall of '" + roomId + "' at (" + corridorX + "," + roomBottom + ")");
            }
        }

        // Track door position for entity spawning
        if (doorPos != null && direction != null) {
            // Check if this room requires a key
            String requiredItem = room.lockedBy;
            doorPositions.add(new DoorInfo(doorPos, roomId, requiredItem, direction));
        } else {
            LOGGER.warning(
                    "Could not mark door for room '" + roomId + "' at corridor (" + corridorX + "," + corridorY + ")");
        }
    }

    /**
     * Places a single room in the layout.
     * 
     * @param layout The level layout to modify
     * @param room   The room to place
     */
    private static void placeRoom(LevelElement[][] layout, Room room) {
        int startX = room.x > 0 ? room.x : 1;
        int startY = room.y > 0 ? room.y : 1;

        // Check if room has a custom ASCII pattern
        if (room.pattern != null && !room.pattern.trim().isEmpty()) {
            placeRoomWithPattern(layout, room, startX, startY);
            return;
        }

        // Default rectangular room generation
        int width = room.width > 0 ? room.width : DEFAULT_ROOM_SIZE;
        int height = room.height > 0 ? room.height : DEFAULT_ROOM_SIZE;

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

        LOGGER.log(CustomLogLevel.DEBUG, "Placed room at (" + startX + "," + startY + ") size " + width + "x" + height);
    }

    /**
     * Places a room using an ASCII art pattern.
     * Pattern symbols:
     * '#' = wall
     * '.' = floor
     * ' ' = skip (leave as is)
     * 'D' = door placeholder
     * 
     * @param layout The level layout to modify
     * @param room   The room with pattern to place
     * @param startX The starting X coordinate
     * @param startY The starting Y coordinate
     */
    private static void placeRoomWithPattern(LevelElement[][] layout, Room room, int startX, int startY) {
        String pattern = room.pattern.trim();
        String[] lines = pattern.split("\n");

        int maxWidth = 0;
        for (String line : lines) {
            maxWidth = Math.max(maxWidth, line.length());
        }

        LOGGER.log(CustomLogLevel.DEBUG,
                "Placed custom room at (" + startX + "," + startY + ") size " + maxWidth + "x" + lines.length
                        + " (ASCII pattern)");

        // Place tiles according to pattern
        for (int patternY = 0; patternY < lines.length; patternY++) {
            String line = lines[patternY];
            for (int patternX = 0; patternX < line.length(); patternX++) {
                int layoutX = startX + patternX;
                int layoutY = startY + patternY;

                // Check bounds
                if (layoutY >= layout.length || layoutX >= layout[0].length) {
                    continue;
                }

                char c = line.charAt(patternX);
                switch (c) {
                    case '#':
                        layout[layoutY][layoutX] = LevelElement.WALL;
                        break;
                    case '.':
                        layout[layoutY][layoutX] = LevelElement.FLOOR;
                        break;
                    case 'D':
                        // Door placeholder - will be handled by corridor generation
                        layout[layoutY][layoutX] = LevelElement.FLOOR;
                        break;
                    case ' ':
                        // Skip - leave whatever was there
                        break;
                    default:
                        // Unknown character - treat as floor
                        layout[layoutY][layoutX] = LevelElement.FLOOR;
                        break;
                }
            }
        }
    }

    /**
     * Creates a default fallback layout if no rooms are defined.
     * 
     * @return A default level layout
     */
    private static LevelElement[][] createDefaultLayout() {
        LevelElement[][] layout = new LevelElement[DEFAULT_LAYOUT_SIZE][DEFAULT_LAYOUT_SIZE];
        for (int y = 0; y < DEFAULT_LAYOUT_SIZE; y++) {
            for (int x = 0; x < DEFAULT_LAYOUT_SIZE; x++) {
                if (x == 0 || x == DEFAULT_LAYOUT_SIZE - 1 || y == 0 || y == DEFAULT_LAYOUT_SIZE - 1) {
                    layout[y][x] = LevelElement.WALL;
                } else {
                    layout[y][x] = LevelElement.FLOOR;
                }
            }
        }
        LOGGER.warning(
                "Using default " + DEFAULT_LAYOUT_SIZE + "x" + DEFAULT_LAYOUT_SIZE + " layout (no rooms defined)");
        return layout;
    }
}
