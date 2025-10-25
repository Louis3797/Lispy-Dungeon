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

#### 🏗️ **Level Design**

-   ✅ **Multi-room layouts** with automatic sizing and positioning
-   ✅ **Custom room shapes** with ASCII art patterns (L-shapes, circles, T-shapes, mazes)
-   ✅ **Room connections** with auto-generated 3-tile wide corridors
-   ✅ **Smart door placement** at corridor-room intersections with surrounding walls
-   ✅ **Locked doors** requiring specific keys to unlock with visual feedback
-   ✅ **Dynamic level generation** with ASCII console map display

#### ⚔️ **Combat System**

-   ✅ **Hostile mobs** with health, damage, and AI behavior
-   ✅ **Player combat** - Attack with skills (fireball, bow)
-   ✅ **AI behaviors** - Fight AI (chase/melee/ranged), Idle AI (patrol), Transition AI (attack when damaged)
-   ✅ **Health system** - Both player and mobs can take damage and die
-   ✅ **Resource management** - Mana regeneration (wizard) and stamina regeneration (hunter)

#### 👤 **Player System**

-   ✅ **Character classes** - Wizard (15 HP, 100 mana, fireball/heal) or Hunter (35 HP, 120 stamina, bow/dash)
-   ✅ **Skill casting** - Q key or mouse click to use active skills
-   ✅ **Custom spawn points** - Optional starting positions or random placement
-   ✅ **Controls** - WASD/arrows for movement, E for interaction, Q for skills

#### 🎒 **Items & Inventory**

-   ✅ **Item types** - Keys, scrolls, readable objects
-   ✅ **Inventory system** - Collect and carry unlimited items
-   ✅ **Interactive items** - Pick up from ground, use keys to unlock doors
-   ✅ **Readable content** - Scrolls and books with text content

#### 🧩 **Quiz & Reward System**

-   ✅ **Quiz types** - Single-choice, multiple-choice, free-text input
-   ✅ **Quiz attachments** - Attach to chests, NPCs, or create standalone quiz entities
-   ✅ **Reward system** - Items automatically added to inventory on quiz completion
-   ✅ **Smart spawning** - Reward items don't spawn on map, only given via quizzes
-   ✅ **Validation** - Quiz rewards must reference defined items
-   ✅ **Completion tracking** - Quizzes can only be completed once

#### 🤖 **NPC System**

-   ✅ **Hostile NPCs** - Combat-ready mobs that attack the player
-   ✅ **Friendly NPCs** - Non-hostile characters with dialogue
-   ✅ **Proper animations** - NPCs display correct idle animations (not stretched sprites)
-   ✅ **Room-based spawning** - NPCs spawn in designated rooms
-   ✅ **Configurable stats** - Custom health and damage per mob

---

## Gameplay Controls

Once your escape room is loaded, use these controls:

### Movement

-   **WASD** or **Arrow Keys** - Move player character
-   **Mouse** - Point direction for ranged attacks

### Combat

-   **Q Key** - Cast primary skill (Wizard: fireball, Hunter: arrow)
-   **Left Mouse Click** - Alternative skill casting
-   Skills consume resources: Mana (Wizard) or Stamina (Hunter)
-   Resources regenerate automatically over time

### Interaction

-   **E Key** - Interact with objects (read items, talk to NPCs, open doors)
-   **Inventory** - Automatically managed, use keys from inventory to unlock doors

### Quizzes

-   **Mouse Click** - Select answer in quiz interface
-   **Success** - Receive reward item directly to inventory
-   **Failure** - Quiz remains available to retry

### Tips

-   Hostile mobs attack when damaged - be ready to defend yourself
-   Keys and scrolls go directly to inventory when earned from quizzes
-   Different character classes have different strengths (Wizard: magic, Hunter: agility)
-   Explore all rooms to find items and complete challenges

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

| Type           | Example                     | Usage                           |
| -------------- | --------------------------- | ------------------------------- |
| **String**     | `"Hello World"` or `'text'` | Descriptions, names, textures   |
| **Integer**    | `42`, `100`                 | Positions, dimensions, time     |
| **Boolean**    | `true`, `false`             | Visibility flags                |
| **Array**      | `[item1, item2, item3]`     | Lists of items, connections     |
| **Identifier** | `room_name`, `golden_key`   | IDs (alphanumeric + underscore) |

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
    player:          # Player character configuration (optional)
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

Rooms can be created in two ways:

1. **Rectangular rooms** - Use `width` and `height` for standard rectangular shapes
2. **Custom ASCII patterns** - Use `pattern` for complex shapes like L-shapes, circles, or mazes

**Properties:**

```dsl
rooms:
    room_id:                          # Unique identifier
        description: "String"         # Room description (required)
        x: 2                          # Grid X position (required)
        y: 2                          # Grid Y position (required)

        # Option 1: Rectangular room
        width: 10                     # Room width in tiles (for rectangular rooms)
        height: 8                     # Room height in tiles (for rectangular rooms)

        # Option 2: Custom shape with ASCII art
        pattern: """                  # ASCII pattern (use instead of width/height)
        ##########
        #........#
        #........#
        ##########
        """

        items: [item1, item2]         # Items spawned in room (optional)
        npcs: [npc1]                  # NPCs spawned in room (optional)
        connections: [other_room]     # Connected rooms (optional)
        locked_by: key_id             # Key required to enter (optional)
```

**ASCII Pattern Symbols:**

Use triple quotes `"""` to define multiline ASCII patterns:

| Symbol | Meaning          | Description                                           |
| ------ | ---------------- | ----------------------------------------------------- |
| `#`    | Wall             | Creates a wall tile (blocks movement)                 |
| `.`    | Floor            | Creates a walkable floor tile                         |
| ` `    | Skip             | Leaves tile unchanged (for irregular shapes)          |
| `D`    | Door Placeholder | Reserved for future door placement (treated as floor) |

**Key Features:**

-   **Automatic Corridors**: Rooms listed in `connections` are automatically connected with 3-tile wide L-shaped corridors
-   **Locked Doors**: Use `locked_by` to require a specific key item to access the room
-   **Door Placement**: Doors are automatically placed at corridor entrances with walls on both sides
-   **Positioning**: Use grid coordinates (`x`, `y`) to position rooms - the system handles overlap detection
-   **Custom Shapes**: Create L-shapes, T-shapes, circles, or any custom room layout using ASCII art

**Example - Rectangular Rooms:**

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

**Example - Custom ASCII Patterns:**

```dsl
rooms:
    # L-shaped room
    storage_room:
        description: "An L-shaped storage area"
        x: 20
        y: 5
        pattern: """
##########
#........#
#........#
#........#
#####....#
    #....#
    #....#
    ######
"""
        connections: [entrance]

    # Circular chamber
    ritual_chamber:
        description: "A circular ritual chamber"
        x: 35
        y: 8
        pattern: """
  ######
 #......#
#........#
#........#
#........#
 #......#
  ######
"""
        connections: [storage_room]

    # T-shaped hallway
    grand_hall:
        description: "A grand T-shaped hall"
        x: 50
        y: 2
        pattern: """
    ####
    #..#
    #..#
############
#..........#
#..........#
############
"""
        connections: [ritual_chamber]
```

**Tips for Custom Patterns:**

-   Start and end the pattern with `"""` (triple quotes)
-   Each line represents one row of tiles
-   Walls (`#`) form the boundaries of your room
-   Interior floor (`.`) is where players can walk
-   Use spaces for irregular shapes (leaves background unchanged)
-   Patterns are placed starting at (`x`, `y`) position
-   No need to specify `width` or `height` when using `pattern`

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

-   **`"key"`**: Used to unlock doors (checks inventory when interacting with locked doors)
-   **`"readable"`**: Books, scrolls, notes that can be read
-   **`"consumable"`**: Items that can be used/consumed
-   **`"tool"`**: General tools and objects

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

-   **`single_choice`**: Player selects one answer from multiple options
-   **`multiple_choice`**: Player can select multiple correct answers

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
        hostile: false                    # Is this NPC hostile? (optional, default: false)
        health: 10                        # Health points for hostile mobs (optional, default: 10)
        damage: 1                         # Damage dealt by hostile mobs (optional, default: 1)
        dialogue:                         # Dialogue tree (optional, only for non-hostile NPCs)
            default_text: "String"        # Default dialogue text
```

**Combat System:**

-   **Hostile NPCs**: Set `hostile: true` to create combat-enabled mobs
-   **Health**: Hit points - mob dies when health reaches 0
-   **Damage**: Amount of damage dealt to player on attack
-   **AI Behavior**: Hostile mobs automatically attack the player on sight
-   **Player Combat**: Player can attack hostile mobs using combat controls

**Example:**

```dsl
npcs:
    guardian:
        description: "A stone guardian statue"
        texture: "character/monster/chort"
        location: entrance
        hostile: false
        dialogue:
            default_text: "Solve my riddle to pass..."

    skeleton_warrior:
        description: "A hostile skeleton"
        texture: "character/monster/skeleton"
        location: dungeon
        hostile: true
        health: 15
        damage: 2

    goblin:
        description: "A sneaky goblin"
        texture: "character/monster/goblin"
        location: cave
        hostile: true
        health: 10
        damage: 1
```

**Note:**

-   NPCs with `hostile: false` (or no hostile field) can have dialogue and be referenced in quizzes
-   Hostile mobs ignore dialogue settings and automatically engage in combat
-   Both player and hostile mobs can die from combat

---

### 6. Player (Optional)

Configure the player character's class and starting position.

**Properties:**

```dsl
player:
    class: wizard              # Character class: "wizard" or "hunter" (optional, default: wizard)
    start_x: 5                # Starting X position (optional, uses random floor position if not set)
    start_y: 5                # Starting Y position (optional, uses random floor position if not set)
```

**Character Classes:**

| Class    | Health | Resources   | Primary Skill        | Secondary Skill | Description                                        |
| -------- | ------ | ----------- | -------------------- | --------------- | -------------------------------------------------- |
| `wizard` | 15 HP  | 100 Mana    | Fireball (Q key)     | Self Heal       | Magic-focused ranged attacks and healing abilities |
| `hunter` | 35 HP  | 120 Stamina | Bow & Arrows (Q key) | Dash            | Physical ranged attacks with higher durability     |

**Controls:**

-   **Q Key** or **Left Mouse Click**: Use primary skill/attack
-   **WASD/Arrow Keys**: Move character
-   **E Key**: Interact with objects and NPCs

**Example:**

```dsl
# Option 1: Specify only class (position will be random)
player:
    class: hunter

# Option 2: Specify class and starting position
player:
    class: wizard
    start_x: 5
    start_y: 5

# Option 3: Omit player section entirely (defaults to wizard, random position)
# No player section needed - uses defaults
```

**Notes:**

-   If `player` section is omitted, defaults to `wizard` class with random starting position
-   Starting position (`start_x`, `start_y`) is optional - will use random floor tile if not specified
-   Character class determines combat style, starting skills, and stats
-   Both classes have full combat capabilities to fight hostile mobs

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

-   Check that rooms are connected via `connections: [room_id]`
-   Ensure rooms aren't overlapping
-   Verify room positions have enough space for corridors

**Problem:** Key doesn't unlock door  
**Solution:**

-   Check `locked_by` value matches the key's item ID exactly
-   Verify key has `type: "key"`
-   Ensure key is in player's inventory before interacting with door

**Problem:** Items spawn in unreachable rooms  
**Solution:**

-   Place essential items (keys) only in accessible rooms
-   Check room connections - ensure a path exists from start to item
-   Don't place quest items in locked rooms

**Problem:** Quiz doesn't give reward  
**Solution:**

-   Verify `reward` item ID exists in `items` section
-   Check that `attached_to` references an existing entity
-   Ensure `correct_answers` indices match answer array

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

-   **Room IDs**: `entrance`, `treasure_room`, `secret_chamber`
-   **Item IDs**: `golden_key`, `ancient_scroll`, `health_potion`
-   **NPC IDs**: `old_wizard`, `guardian_statue`, `mysterious_figure`
-   **Quiz IDs**: `riddle_1`, `math_puzzle`, `history_quiz`

Use lowercase with underscores for all identifiers.

---

## Technical Details

### Coordinate System

-   **Origin**: Top-left corner (0, 0)
-   **X-axis**: Increases to the right
-   **Y-axis**: Increases downward
-   **Tile Size**: 1 unit = 1 tile

### Corridor Generation

-   **Width**: All corridors are 3 tiles wide
-   **Shape**: L-shaped paths between rooms
-   **Doors**: Automatically placed at corridor entrances
-   **Walls**: Generated beside doors to block corridor (2 walls per door)

### Door System

-   **Locked Doors**: Red closed texture, blocks player movement
-   **Unlocked Doors**: Green open texture, player can pass through
-   **Direction**: Automatically calculated based on corridor approach
-   **Interaction**: Click/press E to interact with doors

### Inventory System

-   **Capacity**: Unlimited
-   **Key Matching**: Checks for exact item ID match
-   **Visibility**: Items appear in inventory UI after pickup
-   **Usage**: Automatic when interacting with matching locked door

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

## Technical Implementation

### Parser & Validation

**ANTLR Grammar:**

-   `EscapeRoomDSL.g4` defines the complete DSL syntax
-   Supports all properties: hostile, health, damage, pattern, player class, quiz rewards
-   Lexer and parser auto-generated from grammar

**Validation System:**

-   **Unique ID Check**: All entities (rooms, items, NPCs, quizzes) must have unique IDs
-   **Reference Validation**: Connections, locked_by, attached_to must reference existing entities
-   **Reward Validation**: Quiz rewards must reference defined items (throws IllegalArgumentException if not)
-   **Texture Path Check**: Warns if texture paths don't exist
-   **Parse-Time Errors**: Syntax errors reported with line numbers via ANTLR

### Level Generation

**DSLLevelLoader:**

-   Reads `.esc` files and converts to game level
-   Creates rectangular rooms from x/y/width/height
-   Creates custom shaped rooms from ASCII art patterns via `placeRoomWithPattern()`
-   Generates 3-tile wide L-shaped corridors between connected rooms
-   Places doors automatically at corridor entrances with wall detection
-   Locks doors based on `locked_by` property

**Pattern System:**

-   `#` = wall tile
-   `.` = floor tile (walkable)
-   ` ` (space) = skip tile (leaves background)
-   Patterns placed starting at (x, y) position
-   No width/height needed when using patterns

### Entity Spawning

**DSLEntitySpawner:**

-   **Items**: Creates inventory items with proper classes (EscapeRoomKey for keys/scrolls)
-   **NPCs**: Spawns friendly and hostile NPCs with animations
-   **Hostile Mobs**: Uses MonsterBuilder with RandomFightAI, RandomIdleAI, SelfDefendTransition
-   **Quizzes**: Attaches to NPCs or creates standalone quiz items
-   **Smart Spawning**: Quiz reward items don't spawn on map, only given to inventory

**Item Creation:**

-   Keys and scrolls use `EscapeRoomKey` class
-   Includes: itemId, displayName, description, texturePath
-   Readable items display content when interacted with

### Game Systems

**Core Systems (registered in DSLEscapeRoom):**

-   `InputSystem` - Processes keyboard/mouse input (use `stop()` to enable callbacks)
-   `AISystem` - Manages NPC behaviors and transitions
-   `HealthSystem` - Tracks health and handles death
-   `ProjectileSystem` - Manages fireballs, arrows, and other projectiles
-   `ManaRestoreSystem` - Regenerates mana at 10 per tick
-   `StaminaRestoreSystem` - Regenerates stamina over time
-   `CollisionSystem` - Handles entity collisions
-   `PathSystem` - Manages pathfinding for AI

**AI Components:**

-   `RandomFightAI` - Chase, melee, and ranged attack behaviors
-   `RandomIdleAI` - Patrol behavior when not in combat
-   `SelfDefendTransition` - Switches mob to fight mode when damaged
-   `RangeTransition` - Switches based on proximity (less reliable than SelfDefend)

### Player System

**HeroFactory:**

-   Creates wizard or hunter based on DSL `player.class` property
-   **Wizard**: 15 HP, 100 mana, fireball skill (20 damage, 25 mana), heal skill
-   **Hunter**: 35 HP, 120 stamina, bow skill (15 damage, 10 stamina), dash skill
-   Both have `SkillComponent` for Q key/mouse casting
-   Both have `InputComponent` for keyboard/mouse controls

**Resource Management:**

-   Mana regenerates automatically at 10 per tick
-   Stamina regenerates automatically over time
-   Skills can't be cast without sufficient resources

### Quiz & Reward System

**Quiz Flow:**

1. Parse quiz definition from DSL (type, question, answers, correct_answers, reward)
2. Validate reward item exists in items section
3. Create quiz entity or attach to NPC
4. Display quiz UI when player interacts (E key)
5. Check answer correctness when submitted
6. Execute `onSuccess` callback if correct
7. `giveRewardToPlayer()` creates item and adds to inventory
8. Reward items skipped during map item spawning

**QuizInteractionHandler:**

-   Manages quiz UI display and interaction
-   Calls `onSuccess.run()` callback when quiz completed successfully
-   Handles both single-choice and multiple-choice quiz types

---

## Version History

### Version 1.0 (October 2025)

**Features:**

-   Multi-room layouts with automatic corridors
-   Locked doors with key-based unlocking
-   Inventory system for item collection
-   Single-choice and multiple-choice quizzes
-   Readable items (scrolls, books)
-   Player customization
-   Automatic door placement with walls

**Known Limitations:**

-   No animation sequences for doors
-   No conditional logic or variables
-   No timer-based events
-   No save/load system
-   No full UI dialog system
-   No free text questions

---

## Support & Resources

### Example Files

See `escapeRoom/src/demoDungeon/level/demo_room.esc` for a complete working example.

### Texture Paths

Common texture locations:

-   **Characters**: `character/knight`, `character/wizard/wizard`
-   **Monsters**: `character/monster/chort`
-   **Keys**: `items/key/small_key.png`, `items/key/big_key.png`
-   **Books**: `items/book/book`
-   **Doors**: `dungeon/default/door/[direction].png`
-   **Walls**: `dungeon/default/wall/side.png`

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

### Version 1.0 (Current - 2025)

**Major Features:**

**Level Design:**
- Multi-room layouts with dynamic corridor generation
- Custom room shapes using ASCII art patterns (#=wall, .=floor)
- Flexible room connections (north, south, east, west)
- Automatic door placement with smart wall detection
- Locked doors with key-based unlocking system

**Combat System:**
- Hostile NPCs with health and damage stats
- Player combat with skill casting (Q key or mouse)
- AI behaviors: RandomFightAI (chase/melee/ranged), RandomIdleAI (patrol)
- SelfDefendTransition AI (mobs attack when damaged)
- Health system with death mechanics for both player and mobs
- Resource management: Mana regeneration (10/tick) and stamina regeneration

**Player System:**
- Character class selection: Wizard (15 HP, 100 mana, fireball/heal) or Hunter (35 HP, 120 stamina, bow/dash)
- Skill casting via Q key or mouse click
- Custom spawn point per room
- Full keyboard + mouse controls (WASD movement, E for interaction)

**Items & Inventory:**
- Multiple item types: keys, scrolls (documents), decorations
- Full inventory system with add/remove/query
- Readable items with custom content display
- Smart item spawning (quiz rewards don't spawn on map)

**Quiz & Reward System:**
- Single-choice and multiple-choice quiz types
- Quiz attachment to NPCs or standalone items
- Reward validation (must reference defined items)
- Direct-to-inventory reward delivery
- Completion tracking and success callbacks

**NPC System:**
- Hostile NPCs with combat capabilities
- Friendly NPCs with dialogue
- Proper animation rendering for both types
- Room-based spawning system
- Configurable stats (health, damage) per NPC

**Technical:**
- ANTLR-based DSL parser with comprehensive error checking
- Validation system: unique IDs, valid references, reward validation
- Dynamic level generation from DSL definitions
- Entity spawning system with texture/animation loading
- Game systems: Input, AI, Health, Projectile, Resource regeneration
- Readable items (scrolls, books)
- Automatic door placement with walls

**Known Limitations:**

The following features are not yet supported but could be added in future versions:

- **Conditional Logic**: No variables or if/else logic in DSL
- **Timer Events**: No time-based triggers or scheduled events
- **Save/Load System**: No persistent game state between sessions
- **Win Conditions**: No built-in victory/objective system (must use quiz completion or item collection)
- **Event Triggers**: No room entry/exit triggers or scripted events
- **Loot Drops**: Hostile mobs don't drop items when defeated
- **Animation Sequences**: Doors don't have opening/closing animations
- **Dialogue Trees**: NPCs support only single default text, no branching conversations
- **Dynamic Difficulty**: No scaling based on player progress
- **Minimap**: No map overview system

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
```
