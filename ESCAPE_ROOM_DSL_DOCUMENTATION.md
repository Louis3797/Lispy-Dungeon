# Escape Room DSL Documentation

**Version:** 1.0  
**Last Updated:** October 25, 2025

## Table of Contents

1. [Overview](#overview)
2. [Getting Started](#getting-started)
3. [Basic Syntax](#basic-syntax)
4. [Complete DSL Structure](#complete-dsl-structure)
5. [Section Reference](#section-reference)
6. [Examples](#examples)
7. [Best Practices](#best-practices)
8. [Troubleshooting](#troubleshooting)

---

## Overview

The Escape Room DSL (Domain Specific Language) is a human-readable, YAML-like language for creating educational escape room experiences in the Lispy-Dungeon framework. Create multi-room puzzle adventures with locked doors, interactive items, NPCs, and quizzes without writing any Java code.

### Current Features

- ✅ **Multi-room layouts** with automatic sizing and positioning
- ✅ **Room connections** with auto-generated 3-tile wide corridors
- ✅ **Locked doors** requiring specific keys to unlock
- ✅ **Interactive items** (keys, scrolls, readable objects)
- ✅ **NPCs** with dialogue systems
- ✅ **Quizzes** (single-choice and multiple-choice) with rewards
- ✅ **Inventory system** for collecting and using items

---

## Getting Started

### File Structure

1. Create a `.esc` file in your project (e.g., `my_escape_room.esc`)
2. Place it in: `escapeRoom/assets/levels/` or `escapeRoom/src/demoDungeon/level/`
3. Start with the root element: `escape_room:`

### Minimal Example

```dsl
escape_room:
    metadata:
        title: "My First Escape Room"
        description: "A simple room"
        difficulty: "easy"
        max_time: 10

    rooms:
        start_room:
            description: "The starting room"
            x: 2
            y: 2
            width: 10
            height: 10
```

---

## Basic Syntax

### Structure

The DSL uses **2-space indentation** (like YAML):

```dsl
escape_room:
    section_name:
        item_id:
            property: value
            nested_property:
                sub_property: value
```

### Data Types

| Type | Example | Usage |
|------|---------|-------|
| **String** | `"Hello World"` or `'text'` | Descriptions, names, textures |
| **Integer** | `42`, `100` | Positions, dimensions, time |
| **Boolean** | `true`, `false` | Visibility flags |
| **Array** | `[item1, item2, item3]` | Lists of items, connections |
| **Identifier** | `room_name`, `golden_key` | IDs (alphanumeric + underscore) |

### Comments

Use `#` for single-line comments:

```dsl
rooms:
    entrance:
        x: 2  # X coordinate on grid
        # This is a comment line
```

---

## Complete DSL Structure

```dsl
escape_room:
    metadata:        # Game information (required)
    rooms:           # Physical spaces (required - at least 1 room)
    items:           # Collectible objects (optional)
    quizzes:         # Interactive puzzles (optional)
    npcs:            # Non-player characters (optional)
```

---

## Section Reference

### 1. Metadata (Required)

Defines basic information about your escape room.

**Properties:**

```dsl
metadata:
    title: "String"           # Display name (required)
    description: "String"     # Brief description (required)
    difficulty: "easy"        # Difficulty: "easy", "medium", "hard" (required)
    max_time: 30              # Time limit in minutes (required)
```

**Example:**

```dsl
metadata:
    title: "The Ancient Temple"
    description: "Uncover the secrets hidden within"
    difficulty: "medium"
    max_time: 30
```

---

### 2. Rooms (Required)

Define physical spaces that make up your escape room. **At least one room is required.**

**Properties:**

```dsl
rooms:
    room_id:                          # Unique identifier
        description: "String"         # Room description (required)
        x: 2                          # Grid X position (required)
        y: 2                          # Grid Y position (required)
        width: 10                     # Room width in tiles (required)
        height: 8                     # Room height in tiles (required)
        items: [item1, item2]         # Items spawned in room (optional)
        npcs: [npc1]                  # NPCs spawned in room (optional)
        connections: [other_room]     # Connected rooms (optional)
        locked_by: key_id             # Key required to enter (optional)
```

**Key Features:**

- **Automatic Corridors**: Rooms listed in `connections` are automatically connected with 3-tile wide L-shaped corridors
- **Locked Doors**: Use `locked_by` to require a specific key item to access the room
- **Door Placement**: Doors are automatically placed at corridor entrances with walls on both sides
- **Positioning**: Use grid coordinates (`x`, `y`) to position rooms - the system handles overlap detection

**Example:**

```dsl
rooms:
    entrance:
        description: "The grand entrance hall"
        x: 2
        y: 2
        width: 12
        height: 10
        items: [golden_key, scroll]
        connections: [treasure_room, secret_chamber]
    
    treasure_room:
        description: "A room filled with ancient treasures"
        x: 18
        y: 2
        width: 10
        height: 8
        connections: [entrance]
    
    secret_chamber:
        description: "A hidden chamber"
        x: 2
        y: 16
        width: 8
        height: 8
        connections: [entrance]
        locked_by: golden_key  # Player needs golden_key to enter
```

---

### 3. Items (Optional)

Define collectible objects that players can pick up and use.

**Properties:**

```dsl
items:
    item_id:                          # Unique identifier
        description: "String"         # Item description (required)
        type: "key"                   # Item type (required)
        texture: "items/key/big_key.png"  # Texture path (required)
        visible: true                 # Show in world (optional, default: true)
        readable: false               # Can be read (optional, for books/scrolls)
        content: "Text content"       # Text shown when read (if readable: true)
```

**Item Types:**

- **`"key"`**: Used to unlock doors (checks inventory when interacting with locked doors)
- **`"readable"`**: Books, scrolls, notes that can be read
- **`"consumable"`**: Items that can be used/consumed
- **`"tool"`**: General tools and objects

**Key Items:** Any item with `type: "key"` becomes an `EscapeRoomKey` that can unlock doors specified in `locked_by` fields.

**Example:**

```dsl
items:
    golden_key:
        description: "A shiny golden key"
        type: "key"
        texture: "items/key/big_key.png"
        visible: true
    
    ancient_scroll:
        description: "An old scroll with cryptic writing"
        type: "readable"
        texture: "items/book/book"
        readable: true
        content: "The key lies where the sun sets..."
    
    rusty_key:
        description: "A rusty old key"
        type: "key"
        texture: "items/key/small_key.png"
        visible: true
```

---

### 4. Quizzes (Optional)

Interactive quizzes that reward players with items or unlock areas.

**Properties:**

```dsl
quizzes:
    quiz_id:                              # Unique identifier
        type: "single_choice"             # Quiz type (required)
        question: "String"                # Question text (required)
        answers: [ans1, ans2, ans3]       # Answer options (required)
        correct_answers: [0, 2]           # Indices of correct answers (required)
        reward: item_id                   # Item given on success (optional)
        attached_to: entity_id            # Entity that triggers quiz (required)
```

**Quiz Types:**

- **`single_choice`**: Player selects one answer from multiple options
- **`multiple_choice`**: Player can select multiple correct answers

**Answer Indexing:** Answers are 0-indexed (first answer = 0, second = 1, etc.)

**Example:**

```dsl
quizzes:
    treasure_quiz:
        type: single_choice
        question: "What is the capital of Germany?"
        answers: [Berlin, Munich, Hamburg, Cologne]
        correct_answers: [0]
        reward: golden_key
        attached_to: chest
    
    guardian_quiz:
        type: multiple_choice
        question: "Which are programming languages?"
        answers: [Python, HTML, Java, CSS, JavaScript]
        correct_answers: [0, 2, 4]  # Python, Java, JavaScript
        reward: wisdom_scroll
        attached_to: guardian
```

---

### 5. NPCs (Optional)

Non-player characters that can have dialogue and quizzes.

**Properties:**

```dsl
npcs:
    npc_id:                               # Unique identifier
        description: "String"             # NPC description (required)
        texture: "character/monster/chort"  # Texture path (required)
        location: room_id                 # Room where NPC spawns (required)
        dialogue:                         # Dialogue tree (optional)
            default_text: "String"        # Default dialogue text
```

**Example:**

```dsl
npcs:
    guardian:
        description: "A stone guardian statue"
        texture: "character/monster/chort"
        location: entrance
        dialogue:
            default_text: "Solve my riddle to pass..."
    
    old_wizard:
        description: "A mysterious old wizard"
        texture: "character/wizard/wizard"
        location: secret_chamber
        dialogue:
            default_text: "Welcome, traveler..."
```

**Note:** NPCs can be referenced in quizzes using the `attached_to` field.

---

## Examples

### Complete Example: Multi-Room Escape Room

```dsl
escape_room:

    metadata:
        title: "The Forgotten Temple"
        description: "Explore ancient ruins and solve mysteries"
        difficulty: "medium"
        max_time: 30

    rooms:
        entrance:
            description: "The temple entrance with crumbling pillars"
            x: 2
            y: 2
            width: 12
            height: 10
            items: [torch, map]
            npcs: [guardian]
            connections: [main_hall, library]
        
        main_hall:
            description: "A vast hall with ancient murals"
            x: 18
            y: 2
            width: 14
            height: 12
            items: [silver_key]
            connections: [entrance, treasure_vault]
        
        library:
            description: "A dusty library filled with scrolls"
            x: 2
            y: 16
            width: 10
            height: 10
            items: [ancient_scroll, wisdom_book]
            connections: [entrance]
        
        treasure_vault:
            description: "The legendary treasure vault"
            x: 18
            y: 18
            width: 10
            height: 10
            connections: [main_hall]
            locked_by: silver_key

    quizzes:
        temple_riddle:
            type: single_choice
            question: "What walks on four legs in morning, two at noon, three at night?"
            answers: [Human, Dog, Spider, Table]
            correct_answers: [0]
            reward: silver_key
            attached_to: guardian

    items:
        silver_key:
            description: "A tarnished silver key"
            type: "key"
            texture: "items/key/big_key.png"
            visible: true
        
        torch:
            description: "A flickering torch"
            type: "tool"
            texture: "items/torch"
            visible: true
        
        map:
            description: "A worn temple map"
            type: "readable"
            texture: "items/book/book"
            readable: true
            content: "The vault lies beyond the main hall..."
        
        ancient_scroll:
            description: "An ancient scroll with riddles"
            type: "readable"
            texture: "items/book/book"
            readable: true
            content: "Seek wisdom from the guardian..."
        
        wisdom_book:
            description: "A book of ancient wisdom"
            type: "readable"
            texture: "items/book/book"
            readable: true
            content: "Knowledge is the key to all doors..."

    npcs:
        guardian:
            description: "The temple guardian spirit"
            texture: "character/monster/chort"
            location: entrance
            dialogue:
                default_text: "Answer my riddle to prove your worth..."
```

---

## Best Practices

### Room Design

1. **Start Small**: Begin with 2-3 rooms and expand
2. **Logical Flow**: Place the starting room (where player spawns) first
3. **Spacing**: Leave gaps between rooms for corridors (minimum 2-3 tiles)
4. **Size**: Typical room dimensions: 8x8 to 15x15 tiles
5. **Key Placement**: Always put required keys in accessible rooms (not behind locked doors)

### Item Placement

1. **Accessibility**: Place critical items (like keys) in rooms the player can reach immediately
2. **Visibility**: Set `visible: true` for items that should appear in the world
3. **Naming**: Use descriptive IDs like `golden_key`, not `key1`
4. **Avoid Duplicates**: Don't place the same item in multiple locations AND as quiz rewards

### Door Locks

1. **Key Before Door**: Ensure the key spawns in a room accessible BEFORE the locked room
2. **Matching IDs**: The `locked_by` value must exactly match an item's ID (case-sensitive)
3. **Key Type**: Only items with `type: "key"` can unlock doors

### Quizzes

1. **Clarity**: Write clear, unambiguous questions
2. **Fair Difficulty**: Match quiz difficulty to metadata difficulty setting
3. **Reward Placement**: Quiz rewards should be placed as quiz rewards, NOT as room items
4. **Entity Attachment**: The `attached_to` entity must exist (either NPC or object)

---

## Troubleshooting

### Common Issues

**Problem:** Doors don't appear or can't be interacted with  
**Solution:** 
- Check that rooms are connected via `connections: [room_id]`
- Ensure rooms aren't overlapping
- Verify room positions have enough space for corridors

**Problem:** Key doesn't unlock door  
**Solution:**
- Check `locked_by` value matches the key's item ID exactly
- Verify key has `type: "key"`
- Ensure key is in player's inventory before interacting with door

**Problem:** Items spawn in unreachable rooms  
**Solution:**
- Place essential items (keys) only in accessible rooms
- Check room connections - ensure a path exists from start to item
- Don't place quest items in locked rooms

**Problem:** Quiz doesn't give reward  
**Solution:**
- Verify `reward` item ID exists in `items` section
- Check that `attached_to` references an existing entity
- Ensure `correct_answers` indices match answer array

---

## Advanced Features

### Multi-Key Systems

You can create complex unlock sequences:

```dsl
rooms:
    area1:
        connections: [area2]
    
    area2:
        connections: [area1, area3]
        locked_by: bronze_key
    
    area3:
        connections: [area2, area4]
        locked_by: silver_key
    
    area4:
        connections: [area3]
        locked_by: golden_key

items:
    bronze_key:
        description: "Opens area 2"
        type: "key"
        texture: "items/key/small_key.png"
        visible: true
    
    silver_key:
        description: "Opens area 3"
        type: "key"
        texture: "items/key/big_key.png"
        visible: true
    
    golden_key:
        description: "Opens area 4"
        type: "key"
        texture: "items/key/big_key.png"
        visible: true
```

### Progressive Difficulty

Design rooms that gradually increase in complexity:

```dsl
rooms:
    tutorial_room:
        description: "Learn the basics"
        width: 8
        height: 8
        items: [hint_scroll]
    
    easy_puzzle_room:
        locked_by: tutorial_key
    
    medium_puzzle_room:
        locked_by: easy_key
    
    hard_boss_room:
        locked_by: medium_key
```

---

## File Organization

### Recommended Structure

```
escapeRoom/
├── assets/
│   └── levels/
│       ├── tutorial.esc
│       ├── level_01.esc
│       └── level_02.esc
└── src/
    └── demoDungeon/
        └── level/
            └── demo_room.esc
```

### Naming Conventions

- **Room IDs**: `entrance`, `treasure_room`, `secret_chamber`
- **Item IDs**: `golden_key`, `ancient_scroll`, `health_potion`
- **NPC IDs**: `old_wizard`, `guardian_statue`, `mysterious_figure`
- **Quiz IDs**: `riddle_1`, `math_puzzle`, `history_quiz`

Use lowercase with underscores for all identifiers.

---

## Technical Details

### Coordinate System

- **Origin**: Top-left corner (0, 0)
- **X-axis**: Increases to the right
- **Y-axis**: Increases downward
- **Tile Size**: 1 unit = 1 tile

### Corridor Generation

- **Width**: All corridors are 3 tiles wide
- **Shape**: L-shaped paths between rooms
- **Doors**: Automatically placed at corridor entrances
- **Walls**: Generated beside doors to block corridor (2 walls per door)

### Door System

- **Locked Doors**: Red closed texture, blocks player movement
- **Unlocked Doors**: Green open texture, player can pass through
- **Direction**: Automatically calculated based on corridor approach
- **Interaction**: Click/press E to interact with doors

### Inventory System

- **Capacity**: Unlimited
- **Key Matching**: Checks for exact item ID match
- **Visibility**: Items appear in inventory UI after pickup
- **Usage**: Automatic when interacting with matching locked door

---

## Quick Reference

### Required Sections

```dsl
escape_room:
    metadata:      # REQUIRED
    rooms:         # REQUIRED (minimum 1 room)
```

### Optional Sections

```dsl
    items:         # Optional
    quizzes:       # Optional
    npcs:          # Optional
```

### Minimum Room Definition

```dsl
room_id:
    description: "Text"
    x: 0
    y: 0
    width: 10
    height: 10
```

### Minimum Item Definition (Key)

```dsl
item_id:
    description: "Text"
    type: "key"
    texture: "path/to/texture.png"
    visible: true
```

### Minimum Quiz Definition

```dsl
quiz_id:
    type: "single_choice"
    question: "Question text?"
    answers: [option1, option2, option3]
    correct_answers: [0]
    attached_to: entity_id
```

---

## Version History

### Version 1.0 (October 2025)

**Features:**
- Multi-room layouts with automatic corridors
- Locked doors with key-based unlocking
- Inventory system for item collection
- Single-choice and multiple-choice quizzes
- NPC dialogue system
- Readable items (scrolls, books)
- Player customization
- Automatic door placement with walls

**Known Limitations:**
- No custom room shapes (all rectangular)
- No animation sequences for doors
- No conditional logic or variables
- No timer-based events
- No save/load system

---

## Support & Resources

### Example Files

See `escapeRoom/src/demoDungeon/level/demo_room.esc` for a complete working example.

### Texture Paths

Common texture locations:
- **Characters**: `character/knight`, `character/wizard/wizard`
- **Monsters**: `character/monster/chort`
- **Keys**: `items/key/small_key.png`, `items/key/big_key.png`
- **Books**: `items/book/book`
- **Doors**: `dungeon/default/door/[direction].png`
- **Walls**: `dungeon/default/wall/side.png`

### Getting Help

1. Check this documentation
2. Review `demo_room.esc` example
3. Check console output for parsing errors
4. Verify all IDs are unique and referenced correctly

---

**End of Documentation**### Items

Interactive objects players can collect and use:

```dsl
items:
    ancient_scroll:
        description: "An old scroll with mysterious writing"
        type: "key" | "tool" | "document" | "decoration"
        texture: "items/book/book"           # Asset path
        location: entrance_hall              # Starting room
        visible: true                        # Can be seen/found
        readable: true                       # Can be read
        content: "Text content if readable"  # Text shown when read
        properties:                          # Custom properties
---

## Version History

### Version 1.0 (October 2025)

**Features:**

- Multi-room layouts with automatic corridors
- Locked doors with key-based unlocking
- Inventory system for item collection
- Single-choice and multiple-choice quizzes
- NPC dialogue system
- Readable items (scrolls, books)
- Automatic door placement with walls

**Known Limitations:**

- No custom room shapes (all rectangular)
- No animation sequences for doors
- No conditional logic or variables
- No timer-based events
- No save/load system
- No player spawn customization
- No win condition system
- No event triggers

---

## Support & Resources

### Example Files

See `escapeRoom/src/demoDungeon/level/demo_room.esc` for a complete working example.

### Texture Paths

Common texture locations:

- **Characters**: `character/knight`, `character/wizard/wizard`
- **Monsters**: `character/monster/chort`
- **Keys**: `items/key/small_key.png`, `items/key/big_key.png`
- **Books**: `items/book/book`
- **Doors**: `dungeon/default/door/[direction].png`
- **Walls**: `dungeon/default/wall/side.png`

### Getting Help

1. Check this documentation
2. Review `demo_room.esc` example
3. Check console output for parsing errors
4. Verify all IDs are unique and referenced correctly

---

**End of Documentation**
