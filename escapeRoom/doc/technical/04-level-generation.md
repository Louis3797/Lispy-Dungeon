# Level Generation

**From Data Structures to Playable Levels**

[← Back: Data Structures](03-data-structures.md) | [Next: Entity System →](05-entity-system.md)

---

## Introduction

Level generation is the process of converting the parsed `EscapeRoomDefinition` into a playable `DungeonLevel`. This is one of the most complex parts of the system, involving layout calculation, room placement, corridor generation, and door positioning.

## Overview

**Location**: `dsl/DSLLevelLoader.java`

**Purpose**: Convert abstract room definitions into a 2D tile grid

**Process**:

```
EscapeRoomDefinition → Calculate Bounds → Create Grid → Place Rooms → Generate Corridors → Place Doors → DungeonLevel
```

## Core Algorithm

### Main Entry Point

```java
public static DungeonLevel createLevel(EscapeRoomDefinition definition) {
    // Clear previous state
    doorPositions.clear();
    DoorManager.clear();

    // Generate layout grid
    LevelElement[][] layout = generateLayout(definition);

    // Create game level
    DungeonLevel level = new DungeonLevel(layout, DesignLabel.DEFAULT);

    return level;
}
```

### Level Elements

```java
public enum LevelElement {
    WALL,   // Impassable barrier
    FLOOR,  // Walkable surface
    DOOR,   // Passable doorway
    SKIP,   // Undefined (stays as is)
    // ... other types
}
```

## Step 1: Calculate Bounds

### Grid Size Calculation

```java
private static LevelElement[][] generateLayout(EscapeRoomDefinition definition) {
    // Find maximum extent of all rooms
    int maxX = 0, maxY = 0;

    for (Room room : definition.rooms.values()) {
        int roomEndX = room.x + (room.width > 0 ? room.width : 10);
        int roomEndY = room.y + (room.height > 0 ? room.height : 10);
        maxX = Math.max(maxX, roomEndX);
        maxY = Math.max(maxY, roomEndY);
    }

    // Add padding for corridors and safety
    maxX += 2;
    maxY += 2;

    // Initialize grid with walls
    LevelElement[][] layout = new LevelElement[maxY][maxX];
    for (int y = 0; y < maxY; y++) {
        for (int x = 0; x < maxX; x++) {
            layout[y][x] = LevelElement.WALL;
        }
    }

    return layout;
}
```

**Example**:

```
Room 1: (0,0) size 10x8  → end at (10,8)
Room 2: (15,0) size 8x6  → end at (23,6)
Max: (23,8) + padding (2,2) = Grid size: 25x10
```

## Step 2: Place Rooms

### Rectangular Rooms

```java
private static void placeRoom(LevelElement[][] layout, Room room) {
    int startX = room.x > 0 ? room.x : 1;
    int startY = room.y > 0 ? room.y : 1;

    // Use pattern if available
    if (room.pattern != null && !room.pattern.trim().isEmpty()) {
        placeRoomWithPattern(layout, room, startX, startY);
        return;
    }

    // Default rectangular room
    int width = room.width > 0 ? room.width : 10;
    int height = room.height > 0 ? room.height : 10;

    // Create walls and floor
    for (int y = startY; y < startY + height && y < layout.length; y++) {
        for (int x = startX; x < startX + width && x < layout[0].length; x++) {
            if (x == startX || x == startX + width - 1 ||
                y == startY || y == startY + height - 1) {
                layout[y][x] = LevelElement.WALL;  // Perimeter
            } else {
                layout[y][x] = LevelElement.FLOOR; // Interior
            }
        }
    }
}
```

**Visual**:

```
##########    (10x8 room)
#........#
#........#
#........#
#........#
#........#
#........#
##########
```

### Custom Pattern Rooms

```java
private static void placeRoomWithPattern(LevelElement[][] layout, Room room, int startX, int startY) {
    String pattern = room.pattern.trim();
    String[] lines = pattern.split("\n");

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
                case '#' -> layout[layoutY][layoutX] = LevelElement.WALL;
                case '.' -> layout[layoutY][layoutX] = LevelElement.FLOOR;
                case ' ' -> {}  // Skip - leave as is
                case 'D' -> layout[layoutY][layoutX] = LevelElement.FLOOR; // Placeholder
                default -> layout[layoutY][layoutX] = LevelElement.FLOOR;
            }
        }
    }
}
```

**Pattern Symbols**:

-   `#` = Wall tile
-   `.` = Floor tile
-   ` ` (space) = Skip (leave unchanged)
-   `D` = Door placeholder (becomes floor)

**Example** - L-shaped room:

```
##########
#........#
#........#
#####....#
    #....#
    #....#
    ######
```

## Step 3: Generate Corridors

### Corridor Algorithm

Corridors are **L-shaped**, **3 tiles wide**, connecting room centers.

```java
private static void createCorridor(LevelElement[][] layout,
                                   String room1Id, Room room1,
                                   String room2Id, Room room2) {
    // Calculate center points
    int x1 = room1.x + room1.width / 2;
    int y1 = room1.y + room1.height / 2;
    int x2 = room2.x + room2.width / 2;
    int y2 = room2.y + room2.height / 2;

    int corridorWidth = 3;

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
}
```

**Visual Example**:

Room A at (2,2) size 8x6, Room B at (15,2) size 8x6:

```
  ########          ########
  #......#          #......#
  #......#···········......#
  #......#          #......#
  ########          ########
```

The `···` is a 3-tile wide corridor.

### Corridor Iteration

```java
private static void generateCorridors(LevelElement[][] layout, EscapeRoomDefinition definition) {
    for (var entry : definition.rooms.entrySet()) {
        String roomId = entry.getKey();
        Room room = entry.getValue();

        if (room.connections == null || room.connections.isEmpty()) {
            continue;
        }

        for (String targetRoomId : room.connections) {
            Room targetRoom = definition.rooms.get(targetRoomId);
            if (targetRoom != null) {
                createCorridor(layout, roomId, room, targetRoomId, targetRoom);
            }
        }
    }
}
```

## Step 4: Door Placement

### Door Detection

Doors are placed where corridors intersect room walls.

```java
private static void markDoorInWall(LevelElement[][] layout, String roomId, Room room,
                                    int corridorX, int corridorY) {
    int roomLeft = room.x;
    int roomRight = room.x + room.width - 1;
    int roomTop = room.y;
    int roomBottom = room.y + room.height - 1;

    Point doorPos = null;
    String direction = null;

    // Left wall (corridor from west)
    if (corridorX < roomLeft && corridorY >= roomTop && corridorY <= roomBottom) {
        layout[corridorY][roomLeft] = LevelElement.DOOR;
        doorPos = new Point(roomLeft, corridorY);
        direction = "left";
    }
    // Right wall (corridor from east)
    else if (corridorX > roomRight && corridorY >= roomTop && corridorY <= roomBottom) {
        layout[corridorY][roomRight] = LevelElement.DOOR;
        doorPos = new Point(roomRight, corridorY);
        direction = "right";
    }
    // Top wall (corridor from north)
    else if (corridorY < roomTop && corridorX >= roomLeft && corridorX <= roomRight) {
        layout[roomTop][corridorX] = LevelElement.DOOR;
        doorPos = new Point(corridorX, roomTop);
        direction = "top";
    }
    // Bottom wall (corridor from south)
    else if (corridorY > roomBottom && corridorX >= roomLeft && corridorX <= roomRight) {
        layout[roomBottom][corridorX] = LevelElement.DOOR;
        doorPos = new Point(corridorX, roomBottom);
        direction = "bottom";
    }

    // Track for entity spawning
    if (doorPos != null) {
        String requiredKey = room.lockedBy;
        doorPositions.add(new DoorInfo(doorPos, roomId, requiredKey, direction));
    }
}
```

**Door Directions**:

-   `left`: Player approaches from left (west)
-   `right`: Player approaches from right (east)
-   `top`: Player approaches from top (north)
-   `bottom`: Player approaches from bottom (south)

### Door Data Structure

```java
private static class DoorInfo {
    Point position;          // Tile coordinates
    String roomId;           // Room this door leads to
    String requiredItemId;   // Key required (or null)
    String direction;        // Door orientation

    DoorInfo(Point position, String roomId, String requiredItemId, String direction) {
        this.position = position;
        this.roomId = roomId;
        this.requiredItemId = requiredItemId;
        this.direction = direction;
    }
}
```

## Step 5: Entity Spawning

### Door Entities

After level creation, door entities are spawned:

```java
public static void spawnDoorEntities(EscapeRoomDefinition definition) {
    DungeonLevel level = (DungeonLevel) Game.currentLevel().get();

    for (DoorInfo doorInfo : doorPositions) {
        Tile tile = level.tileAt(doorInfo.position).orElse(null);
        if (tile instanceof DoorTile doorTile) {
            // Create wall entities to block corridor
            List<Entity> wallEntities = new ArrayList<>();
            for (int i = -2; i <= 2; i++) {
                if (i == 0) continue; // Skip door position

                Point wallPos;
                if (doorInfo.direction.equals("left") || doorInfo.direction.equals("right")) {
                    wallPos = doorInfo.position.translate(0, i);
                } else {
                    wallPos = doorInfo.position.translate(i, 0);
                }

                Entity wallEntity = new Entity("DoorWall");
                wallEntity.add(new PositionComponent(wallPos));
                wallEntity.add(new CollideComponent());
                wallEntity.add(new DrawComponent(wallTexture));

                Game.add(wallEntity);
                wallEntities.add(wallEntity);
            }

            // Create door entity
            Entity doorEntity;
            if (doorInfo.requiredItemId != null) {
                DoorManager.lockDoor(doorTile, doorInfo.requiredItemId);
                doorEntity = DoorEntityFactory.createLockedDoorIndicator(
                    doorTile, doorInfo.requiredItemId, doorInfo.position,
                    doorInfo.direction, wallEntities);
            } else {
                doorEntity = DoorEntityFactory.createUnlockedDoorIndicator(
                    doorTile, doorInfo.position, doorInfo.direction);
            }

            Game.add(doorEntity);
        }
    }
}
```

## Coordinate System

```
(0,0) ────────────► X
  │
  │
  │
  ▼
  Y

Origin: Top-left
X-axis: Increases right
Y-axis: Increases downward
```

## Layout Visualization

### Debug Output

```java
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
```

**Example Output**:

```
=== Level Layout ===
█████████████████████████
█········█·····█········█
█········█·····█········█
█········█·····█········█
█████████D·····D········█
        █·····█████████
        █·····█
        ███████
===================
```

## Edge Cases

### 1. Overlapping Rooms

**Problem**: Rooms defined at positions that overlap

**Solution**: Last room written wins (overwrites)

```java
// Room 1 at (5,5) size 10x10
// Room 2 at (10,8) size 10x10
// Overlapping region uses Room 2's tiles
```

### 2. Disconnected Rooms

**Problem**: Room has no connections

**Solution**: Room is isolated (valid, but player may not reach it)

```java
rooms:
    hall:
        x: 0
        y: 0
        connections: [vault]

    vault:
        x: 20
        y: 0
        # Has connection

    secret:
        x: 40
        y: 0
        # No connections - isolated!
```

### 3. Corridor Clipping

**Problem**: Corridor extends beyond grid bounds

**Solution**: Bounds checking prevents array access errors

```java
if (y >= 0 && y < layout.length && x >= 0 && x < layout[0].length) {
    layout[y][x] = LevelElement.FLOOR;
}
```

### 4. Pattern Size Mismatch

**Problem**: ASCII pattern doesn't match declared width/height

**Solution**: Pattern takes precedence, width/height ignored

```java
if (room.pattern != null) {
    // Use pattern dimensions
    placeRoomWithPattern(layout, room, startX, startY);
    return;
}
// Otherwise use width/height
```

## Performance Optimization

### Grid Preallocation

```java
// Preallocate full grid
LevelElement[][] layout = new LevelElement[maxY][maxX];

// Single-pass initialization
for (int y = 0; y < maxY; y++) {
    for (int x = 0; x < maxX; x++) {
        layout[y][x] = LevelElement.WALL;
    }
}
```

### Complexity Analysis

| Operation          | Complexity               | Notes                                |
| ------------------ | ------------------------ | ------------------------------------ |
| Calculate bounds   | O(R)                     | R = number of rooms                  |
| Initialize grid    | O(X × Y)                 | X,Y = grid dimensions                |
| Place rooms        | O(R × W × H)             | W,H = avg room size                  |
| Generate corridors | O(C × L)                 | C = connections, L = corridor length |
| **Total**          | **O(R × W × H + X × Y)** | Typically < 50ms                     |

## Integration with Game Engine

### DungeonLevel Creation

```java
// Our 2D array
LevelElement[][] layout = generateLayout(definition);

// Game engine creates tiles
DungeonLevel level = new DungeonLevel(layout, DesignLabel.DEFAULT);

// Set as active level
Game.setCurrentLevel(level);
```

### Tile System

Each `LevelElement` becomes a `Tile` in the game:

```java
public class DungeonLevel {
    private Tile[][] tiles;

    public DungeonLevel(LevelElement[][] layout, DesignLabel design) {
        this.tiles = new Tile[layout.length][layout[0].length];

        for (int y = 0; y < layout.length; y++) {
            for (int x = 0; x < layout[0].length; x++) {
                this.tiles[y][x] = TileFactory.create(layout[y][x], design);
            }
        }
    }
}
```

## Summary

| Step                      | Input                  | Output            | Purpose              |
| ------------------------- | ---------------------- | ----------------- | -------------------- |
| **1. Calculate Bounds**   | Room definitions       | Grid dimensions   | Determine level size |
| **2. Initialize Grid**    | Dimensions             | 2D array of WALLs | Create empty canvas  |
| **3. Place Rooms**        | Room definitions       | Rooms in grid     | Add room interiors   |
| **4. Generate Corridors** | Connections            | Corridors in grid | Connect rooms        |
| **5. Mark Doors**         | Corridor intersections | Door positions    | Track entrances      |
| **6. Create Level**       | Complete grid          | DungeonLevel      | Game-ready level     |
| **7. Spawn Entities**     | Door positions         | Door entities     | Add gameplay objects |

**Key Concepts**:

-   **L-shaped corridors**: Horizontal then vertical segments
-   **3-tile wide**: Corridors are always 3 tiles wide
-   **Wall perimeter**: Rooms have wall borders
-   **Door detection**: Automatic at corridor-room intersections
-   **ASCII patterns**: Custom room shapes via text art

---

**Next**: [Entity System →](05-entity-system.md)

Learn how entities (items, NPCs, quizzes) are spawned into the generated level.
