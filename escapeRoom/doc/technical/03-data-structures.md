# Data Structures

**Internal Data Models**

[← Back: Parsing Pipeline](02-parsing-pipeline.md) | [Next: Level Generation →](04-level-generation.md)

---

## Introduction

This document describes the Java data structures used internally to represent parsed escape room definitions. These structures bridge the gap between the DSL text and the game engine.

## Core Data Structure

### EscapeRoomDefinition

**Location**: `dsl/EscapeRoomDefinition.java`

**Purpose**: Root container for all escape room data

```java
public class EscapeRoomDefinition {
    public Metadata metadata;                    // Room metadata
    public Map<String, Room> rooms;              // Room definitions
    public Map<String, Item> items;              // Item definitions
    public Map<String, NPC> npcs;                // NPC definitions
    public Map<String, Quiz> quizzes;            // Quiz definitions
    public Player player;                        // Player configuration

    public String getTitle() {
        return metadata != null ? metadata.title : "Untitled Escape Room";
    }
}
```

**Usage**:

```java
EscapeRoomDefinition def = parseDSL("room.esc");
System.out.println("Title: " + def.getTitle());
System.out.println("Room count: " + def.rooms.size());
```

## Nested Data Classes

### Metadata

```java
class Metadata {
    public String title;           // Room title
    public String description;     // Room description
    public String difficulty;      // Difficulty level (easy/medium/hard)
    public int maxTime;            // Time limit in seconds (0 = unlimited)

    @Override
    public String toString() {
        return "Metadata{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", maxTime=" + maxTime +
                '}';
    }
}
```

**Example**:

```java
Metadata meta = new Metadata();
meta.title = "Ancient Temple";
meta.difficulty = "hard";
meta.maxTime = 1800; // 30 minutes
```

### Room

```java
class Room {
    // Position and size (for rectangular rooms)
    public int x;                      // Grid X coordinate
    public int y;                      // Grid Y coordinate
    public int width;                  // Room width in tiles
    public int height;                 // Room height in tiles

    // Custom shape (alternative to width/height)
    public String pattern;             // ASCII art pattern

    // Content
    public String description;         // Room description
    public List<String> items;         // Item IDs in this room
    public List<String> npcs;          // NPC IDs in this room
    public List<String> connections;   // Connected room IDs

    // Security
    public String lockedBy;            // Item ID required to unlock

    // Atmosphere (future feature)
    public String atmosphere;          // Lighting/mood

    public Room() {
        this.items = new ArrayList<>();
        this.npcs = new ArrayList<>();
        this.connections = new ArrayList<>();
    }
}
```

**Examples**:

Rectangular room:

```java
Room hall = new Room();
hall.x = 5;
hall.y = 10;
hall.width = 12;
hall.height = 10;
hall.description = "A grand hall";
hall.connections.add("treasury");
```

Custom-shaped room:

```java
Room lshape = new Room();
lshape.x = 20;
lshape.y = 5;
lshape.pattern = """
    ##########
    #........#
    #........#
    #####....#
        #....#
        ######
    """;
```

### Item

```java
class Item {
    public String type;              // Item type: key, scroll, book, etc.
    public String description;       // Item description
    public String texture;           // Texture path
    public String location;          // Room ID where item spawns
    public boolean visible;          // Is item visible?
    public boolean readable;         // Can player read it?
    public String content;           // Text content (for scrolls/books)
    public Map<String, Object> properties; // Custom properties

    public Item() {
        this.visible = true;
        this.readable = false;
        this.properties = new HashMap<>();
    }
}
```

**Example**:

```java
Item key = new Item();
key.type = "key";
key.description = "A golden key";
key.texture = "items/key_gold";
key.location = "entrance";

Item scroll = new Item();
scroll.type = "scroll";
scroll.readable = true;
scroll.content = "The password is 'DRAGON'";
scroll.location = "library";
```

### NPC

```java
class NPC {
    // Basic info
    public String description;         // NPC description
    public String texture;             // Character sprite path
    public String location;            // Room ID for spawning

    // Position (optional, within room)
    public Integer startX;             // Tile X position
    public Integer startY;             // Tile Y position

    // Interaction
    public Dialogue dialogue;          // Dialogue tree
    public List<String> givesItems;    // Items given to player
    public List<String> requiresItems; // Items required for interaction

    // Combat (for hostile NPCs)
    public boolean hostile;            // Is this NPC hostile?
    public int health;                 // HP (0 = default)
    public int damage;                 // Damage dealt (0 = default)

    public NPC() {
        this.hostile = false;
        this.health = 0;
        this.damage = 0;
        this.givesItems = new ArrayList<>();
        this.requiresItems = new ArrayList<>();
    }
}
```

**Examples**:

Friendly NPC:

```java
NPC wizard = new NPC();
wizard.description = "An old wizard";
wizard.texture = "character/npc/wizard";
wizard.location = "tower";
wizard.dialogue = new Dialogue();
wizard.dialogue.defaultText = "Hello, traveler!";
wizard.givesItems.add("magic_scroll");
```

Hostile NPC:

```java
NPC skeleton = new NPC();
skeleton.description = "A skeleton warrior";
skeleton.texture = "character/monster/skeleton";
skeleton.location = "crypt";
skeleton.hostile = true;
skeleton.health = 20;
skeleton.damage = 3;
```

### Dialogue

```java
class Dialogue {
    public String defaultText;                        // Default dialogue
    public Map<String, String> conditions;            // Conditional dialogue

    public Dialogue() {
        this.conditions = new HashMap<>();
    }
}
```

**Example**:

```java
Dialogue dlg = new Dialogue();
dlg.defaultText = "I need the ancient key.";
dlg.conditions.put("has_ancient_key", "Thank you! Here's your reward.");
```

### Quiz

```java
class Quiz {
    public String type;                // Quiz type: single_choice, multiple_choice, free_text
    public String question;            // Question text
    public List<String> answers;       // Answer options (not for free_text)
    public List<Integer> correct;      // Correct answer indices
    public String reward;              // Item ID given on success
    public String attachedTo;          // Entity ID (chest/NPC) or null for standalone
    public String location;            // Room ID (if standalone)
    public String explanation;         // Explanation shown on failure

    public Quiz() {
        this.answers = new ArrayList<>();
        this.correct = new ArrayList<>();
    }
}
```

**Examples**:

Single choice:

```java
Quiz quiz = new Quiz();
quiz.type = "single_choice";
quiz.question = "What is 2 + 2?";
quiz.answers = List.of("3", "4", "5");
quiz.correct = List.of(1);  // Index 1 = "4"
quiz.reward = "gold_coin";
quiz.attachedTo = "chest1";
```

Multiple choice:

```java
Quiz quiz = new Quiz();
quiz.type = "multiple_choice";
quiz.question = "Select all prime numbers:";
quiz.answers = List.of("2", "3", "4", "5");
quiz.correct = List.of(0, 1, 3);  // 2, 3, 5
```

Free text:

```java
Quiz quiz = new Quiz();
quiz.type = "free_text";
quiz.question = "What is the capital of France?";
quiz.correct = List.of(0);  // Placeholder
quiz.explanation = "The answer is Paris";
```

### Player

```java
class Player {
    public String characterClass;      // "wizard" or "hunter"
    public String startRoom;           // Room ID for spawn
    public Integer startX;             // Tile X position (optional)
    public Integer startY;             // Tile Y position (optional)
}
```

**Example**:

```java
Player player = new Player();
player.characterClass = "wizard";
player.startRoom = "entrance";
// startX and startY are null = random position in room
```

## Data Relationships

### Entity Relationships

```
EscapeRoomDefinition
    ├── Metadata (1:1)
    ├── Rooms (1:N)
    │   └── References Items, NPCs (by ID)
    ├── Items (1:N)
    │   └── References Room location (by ID)
    ├── NPCs (1:N)
    │   └── References Room location (by ID)
    │   └── References Items (gives/requires) (by ID)
    ├── Quizzes (1:N)
    │   └── References Item reward (by ID)
    │   └── References attachedTo entity (by ID)
    │   └── References Room location (by ID)
    └── Player (1:1)
        └── References startRoom (by ID)
```

### Reference Resolution

All references use string IDs that must be resolved:

```java
// Get item location
String itemId = "golden_key";
Item item = definition.items.get(itemId);
Room itemRoom = definition.rooms.get(item.location);

// Get connected rooms
Room hall = definition.rooms.get("hall");
for (String connectedId : hall.connections) {
    Room connected = definition.rooms.get(connectedId);
    System.out.println("Connected to: " + connectedId);
}
```

## Validation

### Reference Validation

Check that all references are valid:

```java
public void validate(EscapeRoomDefinition def) {
    // Validate room connections
    for (var entry : def.rooms.entrySet()) {
        Room room = entry.getValue();
        for (String connId : room.connections) {
            if (!def.rooms.containsKey(connId)) {
                System.err.println("Room '" + entry.getKey() +
                    "' references undefined room '" + connId + "'");
            }
        }
    }

    // Validate item locations
    for (var entry : def.items.entrySet()) {
        Item item = entry.getValue();
        if (item.location != null && !def.rooms.containsKey(item.location)) {
            System.err.println("Item '" + entry.getKey() +
                "' location '" + item.location + "' doesn't exist");
        }
    }

    // Validate quiz rewards
    for (var entry : def.quizzes.entrySet()) {
        Quiz quiz = entry.getValue();
        if (quiz.reward != null && !def.items.containsKey(quiz.reward)) {
            System.err.println("Quiz '" + entry.getKey() +
                "' rewards undefined item '" + quiz.reward + "'");
        }
    }
}
```

### Constraint Validation

```java
public void validateConstraints(EscapeRoomDefinition def) {
    // At least one room required
    if (def.rooms == null || def.rooms.isEmpty()) {
        throw new IllegalStateException("At least one room required");
    }

    // Room dimensions must be positive
    for (var entry : def.rooms.entrySet()) {
        Room room = entry.getValue();
        if (room.pattern == null) {
            if (room.width <= 0 || room.height <= 0) {
                throw new IllegalArgumentException(
                    "Room '" + entry.getKey() + "' must have positive dimensions");
            }
        }
    }

    // Quiz type must be valid
    for (var entry : def.quizzes.entrySet()) {
        Quiz quiz = entry.getValue();
        if (!List.of("single_choice", "multiple_choice", "free_text")
                .contains(quiz.type)) {
            throw new IllegalArgumentException(
                "Quiz '" + entry.getKey() + "' has invalid type: " + quiz.type);
        }
    }
}
```

## Data Transformation

### Room Layout Calculation

Calculate actual room dimensions:

```java
public static void calculateRoomBounds(Map<String, Room> rooms) {
    for (Room room : rooms.values()) {
        if (room.pattern != null) {
            // Calculate from ASCII pattern
            String[] lines = room.pattern.split("\n");
            room.height = lines.length;
            room.width = 0;
            for (String line : lines) {
                room.width = Math.max(room.width, line.length());
            }
        }
        // Otherwise use explicit width/height
    }
}
```

### Quiz Answer Indexing

Convert 1-based to 0-based indexing:

```java
// DSL uses 1-based: correct: 1 (first answer)
// Java uses 0-based: correct = [0]
public static void normalizeQuizIndices(Quiz quiz) {
    // Already 0-based in our implementation
}
```

## Serialization

### JSON Export (for debugging)

```java
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public String toJson(EscapeRoomDefinition def) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.toJson(def);
}
```

### String Representation

```java
@Override
public String toString() {
    return "EscapeRoomDefinition{" +
            "title='" + getTitle() + '\'' +
            ", rooms=" + rooms.size() +
            ", items=" + items.size() +
            ", npcs=" + npcs.size() +
            ", quizzes=" + quizzes.size() +
            '}';
}
```

## Memory Footprint

Approximate memory usage for typical escape room:

| Component | Count | Size per Item | Total      |
| --------- | ----- | ------------- | ---------- |
| Metadata  | 1     | 200 bytes     | 200 B      |
| Rooms     | 10    | 500 bytes     | 5 KB       |
| Items     | 20    | 300 bytes     | 6 KB       |
| NPCs      | 5     | 400 bytes     | 2 KB       |
| Quizzes   | 8     | 600 bytes     | 4.8 KB     |
| **Total** |       |               | **~18 KB** |

## Best Practices

### 1. Use Defensive Copies

```java
public List<String> getConnections() {
    return new ArrayList<>(connections); // Defensive copy
}
```

### 2. Null Safety

```java
public List<String> getItems() {
    return items != null ? items : Collections.emptyList();
}
```

### 3. Immutability (where possible)

```java
public class Metadata {
    private final String title;
    private final String description;

    public Metadata(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
}
```

### 4. Builder Pattern (for complex objects)

```java
Room room = new RoomBuilder()
    .position(5, 10)
    .size(12, 8)
    .description("A hall")
    .addConnection("treasury")
    .build();
```

## Summary

| Class                  | Purpose         | Key Fields                                |
| ---------------------- | --------------- | ----------------------------------------- |
| `EscapeRoomDefinition` | Root container  | rooms, items, npcs, quizzes, player       |
| `Metadata`             | Room metadata   | title, description, difficulty            |
| `Room`                 | Room definition | x, y, width, height, pattern, connections |
| `Item`                 | Item definition | type, description, location               |
| `NPC`                  | NPC definition  | description, location, hostile, dialogue  |
| `Quiz`                 | Quiz definition | type, question, answers, correct, reward  |
| `Player`               | Player config   | characterClass, startRoom                 |

---

**Next**: [Level Generation →](04-level-generation.md)

Learn how these data structures are converted into playable game levels.
