# Escape Room DSL Documentation

**Version:** 2.0  
**Last Updated:** January 20, 2026

## Changelog

### Version 2.0 (January 2026)

**Major Update - Full Programming Language Features:**

-   🔢 **Variables** - Define and manipulate variables with expressions
    -   Initial values with math expressions: `score: 50 + 25`
    -   Variable types: numbers, strings, booleans
-   📝 **Event Handlers** - React to game events with custom logic
    -   Room events: `on_enter`, `on_exit`, `on_first_enter`, `on_clear`
    -   Item events: `on_pickup`, `on_use`, `on_drop`
    -   NPC events: `on_interact`, `on_death`
    -   Quiz events: `on_correct`, `on_wrong`
-   🎯 **Triggers** - Global conditions that fire when met
    -   Syntax: `when (condition) { actions }`
    -   Automatic checking after every event
-   🔄 **Control Flow** - Programming constructs
    -   If/else statements with full conditional logic
    -   Repeat loops: `repeat 3 { ... }` and `repeat i from 1 to 5 { ... }`
    -   Chained conditions with `&&` and `||`
-   ⚙️ **Expressions & Operations** - Full expression system
    -   Math: `+`, `-`, `*`, `/`, `%`
    -   Comparisons: `<`, `>`, `<=`, `>=`, `==`, `!=`
    -   Logic: `&&`, `||`, `!`
    -   String concatenation and property access: `player.health`
-   🛠️ **Built-in Functions** - 30+ functions for game control
    -   UI: `show_message()`, `print()`
    -   Game state: `victory()`, `game_over()`, `unlock()`, `lock()`
    -   Items: `give_item()`, `has_item()`
    -   Spawning: `spawn()`, `spawn_monster()`
    -   Math: `min()`, `max()`, `abs()`, `random()`
    -   Player: `get_health()`, `set_health()`, `damage_player()`

### Version 1.1 (October 26, 2025)

**New Features:**

-   🌫️ **Fog of War System** - Limited vision gameplay with configurable view distance
    -   Global fog settings in metadata: `fog_of_war`, `view_distance`
    -   Room-specific overrides: `fog_enabled`, `fog_view_distance`
-   📷 **Camera & Zoom Controls** - Customizable camera settings
    -   Global zoom level in metadata: `camera_zoom`
    -   Room-specific settings: `camera_zoom`, `camera_focus`
-   ⚡ **Custom Player Stats** - Override character class defaults
    -   Configure: `health`, `mana`, `stamina`, `speed`, `mana_restore`, `stamina_restore`
    -   All stats optional - use class defaults if not specified

### Version 1.0 (October 25, 2025)

**Initial Release:**

-   Multi-room level design with custom shapes
-   Combat system with hostile mobs
-   Quiz & reward system
-   Player character classes (Wizard & Hunter)
-   Item & inventory management
-   NPC system

---

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

The Escape Room DSL (Domain Specific Language) is a **full-featured programming language** designed for creating educational escape room experiences in the Lispy-Dungeon framework. What started as a simple configuration format has evolved into a complete scripting language with variables, expressions, conditionals, loops, event handlers, and triggers.

Create multi-room puzzle adventures with complex interactive logic, dynamic scoring systems, conditional item spawning, and rich narrative experiences - all without writing any Java code.

### Current Features

#### 🔢 **Programming Language Features (TIER 1-3)**

-   ✅ **Variables** - Define and manipulate game state
    -   Global variables with initial expressions
    -   Runtime variable modification with `+=`, `-=`, `*=`, `/=`
    -   Scoped variables in loops
-   ✅ **Expressions** - Full expression evaluation system
    -   Arithmetic: `score + 100`, `health * 1.5`
    -   Comparisons: `keysCollected >= 3`, `health > 50`
    -   Logical operators: `hasKey && doorLocked`, `dead || won`
    -   String concatenation: `"You have " + score + " points"`
    -   Property access: `player.health`, `enemy.damage`
-   ✅ **Conditionals** - If/else statements with full logic
    -   Simple: `if (condition) { ... }`
    -   With else: `if (condition) { ... } else { ... }`
    -   Chained: `if (cond1) { ... } else if (cond2) { ... } else { ... }`
    -   Nested conditions supported
-   ✅ **Loops** - Two forms of repetition
    -   Simple repeat: `repeat 3 { ... }` - Execute N times
    -   Range repeat: `repeat i from 1 to 5 { ... }` - Loop variable
-   ✅ **Event Handlers** - React to game events
    -   Room events: `on_enter`, `on_exit`, `on_first_enter`, `on_clear`
    -   Item events: `on_pickup`, `on_use`, `on_drop`
    -   NPC events: `on_interact`, `on_death`
    -   Quiz events: `on_correct`, `on_wrong`
-   ✅ **Triggers** - Global condition monitoring
    -   Syntax: `when (condition) { statements }`
    -   Checked automatically after every event
    -   Multiple triggers supported
-   ✅ **Built-in Functions** - 30+ game control functions
    -   UI: `show_message()`, `print()`
    -   Doors: `unlock()`, `lock()`
    -   Game state: `victory()`, `game_over()`
    -   Items: `give_item()`, `has_item()`, `remove_item()`
    -   Spawning: `spawn()`, `spawn_monster()`
    -   Player: `get_health()`, `set_health()`, `damage_player()`, `heal_player()`
    -   Math: `min()`, `max()`, `abs()`, `random()`, `floor()`, `ceil()`

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
-   ✅ **Custom player stats** - Override default health, mana, stamina, speed, and restoration rates
-   ✅ **Skill casting** - Q key or mouse click to use active skills
-   ✅ **Custom spawn points** - Optional starting positions or random placement
-   ✅ **Controls** - WASD/arrows for movement, E for interaction, Q for skills

#### 🎮 **Advanced Gameplay**

-   ✅ **Fog of War** - Limited vision system with configurable view distance
-   ✅ **Room-specific fog** - Enable/disable fog per room with custom view distances
-   ✅ **Camera zoom** - Customize zoom level globally or per room
-   ✅ **Camera focus** - Control camera targeting (hero or specific entities)

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
-   **G Key** - Drop item from inventory (item appears on ground where you're standing)
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
    variables:       # Global variables (optional - TIER 1)
    rooms:           # Physical spaces (required - at least 1 room)
    items:           # Collectible objects (optional)
    quizzes:         # Interactive puzzles (optional)
    npcs:            # Non-player characters (optional)
    player:          # Player character configuration (optional)
    triggers:        # Global condition watchers (optional - TIER 3)
```

---

## Section Reference

### 0. Variables (Optional - TIER 1)

Define global variables that persist across the entire game session. Variables can store numbers, strings, booleans, and be used in expressions throughout your escape room.

**Properties:**

```dsl
variables:
    variable_name: expression    # Any valid expression as initial value
```

**Supported Types:**

-   **Numbers**: Integers (`42`, `-10`) or floats (`3.14`, `-2.5`)
-   **Strings**: Text in quotes (`"Hello"`, `'World'`)
-   **Booleans**: `true` or `false`
-   **Expressions**: Any valid math expression (`50 + 25`, `10 * 3`)

**Variable Names:**

-   Must start with a letter or underscore
-   Can contain letters, numbers, and underscores
-   Case-sensitive (`score` ≠ `Score`)

**Example:**

```dsl
variables:
    score: 0
    keysCollected: 0
    totalKeys: 3
    playerName: "Hero"
    secretFound: false
    damageMultiplier: 1.5

    # Expression-based initial values
    startingGold: 50 + 25          # 75
    maxScore: 100 * 10             # 1000
    isReady: true && false         # false
```

**Modifying Variables:**

Variables can be modified in event handlers, triggers, and statements using assignment operators:

```dsl
score = 100              # Set to exact value
score += 50              # Add to current value
score -= 25              # Subtract from current value
score *= 2               # Multiply current value
score /= 4               # Divide current value
```

**Usage in Conditions:**

```dsl
if (score >= 100) {
    show_message("High score achieved!")
}

when (keysCollected >= totalKeys) {
    unlock("treasure_vault")
    victory("You win!")
}
```

---

### 0.1 Expressions (TIER 2)

The DSL supports full expression evaluation with proper operator precedence.

**Arithmetic Operators:**

```dsl
score + 100              # Addition
health - 25              # Subtraction
damage * 1.5             # Multiplication
gold / 2                 # Division
level % 3                # Modulo (remainder)
```

**Comparison Operators:**

```dsl
health > 50              # Greater than
level >= 5               # Greater than or equal
score < 100              # Less than
keys <= 3                # Less than or equal
name == "Hero"           # Equal to
difficulty != "easy"     # Not equal to
```

**Logical Operators:**

```dsl
hasKey && doorLocked     # AND (both must be true)
won || lost              # OR (either can be true)
!gameOver                # NOT (inverts boolean)
```

**String Operations:**

```dsl
"Score: " + score                    # Concatenation
"You have " + keys + " keys"         # Multiple concatenation
```

**Property Access:**

```dsl
player.health            # Access player health
player.mana              # Access player mana
enemy.damage             # Access NPC/enemy properties
```

**Function Calls:**

```dsl
min(10, 20)              # Returns 10
max(score, 100)          # Returns higher value
random(1, 6)             # Random number 1-6 (dice roll)
abs(-15)                 # Returns 15
```

**Operator Precedence** (highest to lowest):

1. Property access: `.`
2. Function calls: `func()`
3. Unary operators: `-`, `!`
4. Multiplication/Division: `*`, `/`, `%`
5. Addition/Subtraction: `+`, `-`
6. Comparisons: `<`, `>`, `<=`, `>=`
7. Equality: `==`, `!=`
8. Logical AND: `&&`
9. Logical OR: `||`

**Example:**

```dsl
# Complex expression evaluation
result: 3 + 4 * 5               # Result: 23 (not 35)
condition: health > 50 && mana >= 25    # Both must be true
message: "Level " + (currentLevel + 1)  # String concatenation
```

---

### 0.2 Statements & Control Flow (TIER 2)

**Assignment Statements:**

```dsl
score = 100              # Direct assignment
score += 50              # Add and assign
health -= damage         # Subtract and assign
gold *= 2                # Multiply and assign
points /= 10             # Divide and assign
```

**If/Else Statements:**

```dsl
# Simple if
if (condition) {
    statements
}

# If with else
if (condition) {
    statements
} else {
    statements
}

# Chained if/else
if (score >= 1000) {
    show_message("Legendary!")
} else if (score >= 500) {
    show_message("Expert!")
} else if (score >= 100) {
    show_message("Good job!")
} else {
    show_message("Keep trying!")
}
```

**Repeat Loops:**

```dsl
# Simple repeat - execute N times
repeat 3 {
    print("Spawning treasure...")
    score += 100
}

# Range repeat - loop with variable
repeat i from 1 to 5 {
    print("Iteration: " + i)
    spawn_monster("goblin_" + i)
}

# Countdown example
repeat i from 5 to 1 {
    show_message("Countdown: " + i)
}
```

**Important Notes:**

-   Loop variables (`i` in examples) are scoped to the loop only
-   `repeat 3 { ... }` uses a literal number, not a variable
-   For dynamic repetition, use `repeat i from 1 to count { ... }`
-   Loops can be nested

---

### 0.3 Event Handlers (TIER 3)

Event handlers allow you to execute custom logic when specific game events occur. All event handlers use statement blocks with curly braces `{ }`.

**Room Events:**

```dsl
rooms:
    entrance:
        # ...room properties...

        on_enter {
            # Executed every time player enters room
            show_message("Welcome!")
            score += 10
        }

        on_exit {
            # Executed when player leaves room
            print("Player left entrance")
        }

        on_first_enter {
            # Only executed on FIRST entry
            give_item("starter_torch")
            show_message("First time here!")
        }

        on_clear {
            # Executed when all enemies in room defeated
            show_message("Room cleared!")
            unlock("next_room")
        }
```

**Item Events:**

```dsl
items:
    golden_key:
        # ...item properties...

        on_pickup {
            # Executed when player picks up item
            score += 50
            keysCollected += 1
            show_message("Key collected!")

            if (keysCollected >= totalKeys) {
                show_message("All keys found!")
            }
        }

        on_use {
            # Executed when player uses item
            print("Used golden key")
        }

        on_drop {
            # Executed when player drops item
            keysCollected -= 1
        }
```

**NPC Events:**

```dsl
npcs:
    guardian:
        # ...NPC properties...

        on_interact {
            # Executed when player interacts (E key)
            show_message("I guard this temple...")
            questStarted = true
        }

    boss_monster:
        hostile: true

        on_death {
            # Executed when NPC/monster dies
            score += 500
            give_item("boss_key")
            show_message("Boss defeated!")
        }
```

**Quiz Events:**

```dsl
quizzes:
    riddle_1:
        # ...quiz properties...

        on_correct {
            # Executed when quiz answered correctly
            score += 100
            print("Correct answer!")
        }

        on_wrong {
            # Executed when quiz answered wrong
            print("Wrong answer, try again")
        }
```

**Event Handler Features:**

-   Full access to all variables
-   Can use if/else, loops, function calls
-   Can modify variables with `+=`, `-=`, etc.
-   Can call built-in functions
-   Can be nested (if statements in event handlers)
-   Executed in the order defined

---

### 0.4 Triggers (TIER 3)

Triggers are global conditions that are checked automatically after every game event. When a trigger's condition becomes true, its statements execute.

**Syntax:**

```dsl
triggers:
    when (condition) {
        statements
    }

    when (another_condition) {
        more_statements
    }
```

**Example:**

```dsl
triggers:
    # Victory condition
    when (keysCollected >= 3 && score >= 500) {
        unlock("exit_room")
        victory("You win! All keys collected with high score!")
    }

    # Secret unlock
    when (secretFound && hasItem("ancient_scroll")) {
        unlock("secret_chamber")
        show_message("Secret chamber unlocked!")
    }

    # Low health warning
    when (player.health < 20) {
        show_message("Warning: Low health!")
        play_sound("warning")
    }

    # Quest progression
    when (monstersKilled >= 10) {
        give_item("warrior_badge")
        show_message("Warrior badge earned!")
    }
```

**Trigger Behavior:**

-   Checked after **every event** (room entry, item pickup, etc.)
-   Execute **once** when condition becomes true
-   Won't re-execute unless condition becomes false then true again
-   Multiple triggers can fire from the same event
-   Useful for win conditions, quest progression, achievement systems

**Common Patterns:**

```dsl
# Boss fight trigger
when (bossDefeated && keysCollected >= 3) {
    unlock("final_door")
    show_message("The path is clear!")
}

# Time-based (if you track a timer variable)
when (gameTime >= 300) {
    show_message("5 minutes elapsed!")
}

# Combo system
when (enemiesKilledInRow >= 5) {
    score += 200
    show_message("Combo bonus!")
}
```

---

### 0.5 Built-in Functions (TIER 2-3)

The DSL provides 30+ built-in functions for controlling game behavior.

**UI Functions:**

```dsl
show_message("Text")              # Display message to player
print("Debug text")               # Print to console (debugging)
print("Score: ", score)           # Print with variables
```

**Door Functions:**

```dsl
unlock("room_id")                 # Unlock a locked room
lock("room_id")                   # Lock a room
```

**Game State Functions:**

```dsl
victory("Win message")            # End game in victory
game_over("Lose message")         # End game in defeat
```

**Item Functions:**

```dsl
give_item("item_id")              # Add item to player inventory
has_item("item_id")               # Returns true if player has item
remove_item("item_id")            # Remove item from inventory
```

**Spawning Functions:**

```dsl
spawn("entity_id")                # Spawn an entity in current room
spawn_monster("monster_id")       # Spawn a hostile monster
```

**Player Functions:**

```dsl
get_health()                      # Get current player health
set_health(50)                    # Set player health to value
damage_player(10)                 # Damage player by amount
heal_player(25)                   # Heal player by amount
```

**Math Functions:**

```dsl
min(a, b)                         # Returns smaller value
max(a, b)                         # Returns larger value
abs(x)                            # Absolute value
random(min, max)                  # Random integer between min and max (inclusive)
floor(x)                          # Round down to integer
ceil(x)                           # Round up to integer
round(x)                          # Round to nearest integer
sqrt(x)                           # Square root
```

**String Functions:**

```dsl
len("text")                       # Length of string
substring("hello", 0, 3)          # Extract substring ("hel")
to_upper("text")                  # Convert to uppercase
to_lower("TEXT")                  # Convert to lowercase
```

**Sound Functions:**

```dsl
play_sound("sound_name")          # Play a sound effect
```

**Example Usage:**

```dsl
on_pickup {
    score += random(10, 50)       # Random score bonus
    newHealth: min(player.health + 25, 100)  # Cap health at 100
    set_health(newHealth)

    if (has_item("key1") && has_item("key2")) {
        unlock("treasure_vault")
    }
}
```

---

### 1. Metadata (Required)

Defines basic information about your escape room.

**Properties:**

```dsl
metadata:
    title: "String"           # Display name (required)
    description: "String"     # Brief description (required)
    difficulty: "easy"        # Difficulty: "easy", "normal", "hard", "extreme" (required)
    max_time: 30              # Time limit in minutes (required)
    fog_of_war: false         # Enable fog of war (optional, default: false)
    view_distance: 7          # Tiles visible around player with fog (optional, default: 7)
    camera_zoom: 1.0          # Camera zoom level (optional, default: 1.0, range: 0.5-2.0)
```

**Example:**

```dsl
metadata:
    title: "The Ancient Temple"
    description: "Uncover the secrets hidden within"
    difficulty: "easy"
    max_time: 30
    fog_of_war: true
    view_distance: 5
    camera_zoom: 0.8
```

Easy: Monsters have 70% health/damage, player has 130% stats
Normal: Standard 100% for both
Hard: Monsters have 150% health/damage, player has 80% stats
Extreme: Monsters have 200% health/damage, player has 60% stats

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

        # Advanced visual settings (optional - override global metadata settings)
        fog_enabled: true             # Enable fog in this room (optional, overrides metadata)
        fog_view_distance: 5          # Custom view distance for this room (optional)
        camera_zoom: 1.2              # Custom camera zoom for this room (optional)
        camera_focus: hero            # Camera focus: "hero" or entity name (optional)

        # Event Handlers (TIER 3 - optional)
        on_enter {                    # Executed when player enters room
            # statements
        }
        on_exit {                     # Executed when player leaves room
            # statements
        }
        on_first_enter {              # Only executed on first entry
            # statements
        }
        on_clear {                    # Executed when all enemies defeated
            # statements
        }
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

        # Event Handlers (TIER 3 - optional)
        on_pickup {                   # Executed when player picks up item
            # statements
        }
        on_use {                      # Executed when player uses item
            # statements
        }
        on_drop {                     # Executed when player drops item
            # statements
        }
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

        on_pickup {
            score += 50
            keysCollected += 1
            show_message("Golden key acquired!")

            if (keysCollected >= totalKeys) {
                show_message("All keys collected!")
            }
        }

    ancient_scroll:
        description: "An old scroll with cryptic writing"
        type: "readable"
        texture: "items/book/book"
        readable: true
        content: "The key lies where the sun sets..."

        on_pickup {
            secretFound = true
            print("Secret lore discovered")
        }

    health_potion:
        description: "A healing potion"
        type: "consumable"
        texture: "items/potion"

        on_use {
            heal_player(50)
            remove_item("health_potion")
            show_message("Restored 50 health!")
        }
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

        # Event Handlers (TIER 3 - optional)
        on_correct {                      # Executed when answered correctly
            # statements
        }
        on_wrong {                        # Executed when answered incorrectly
            # statements
        }
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

        on_correct {
            score += 100
            print("Correct! Treasure unlocked")
        }

        on_wrong {
            print("Incorrect answer, try again")
        }

    guardian_quiz:
        type: multiple_choice
        question: "Which are programming languages?"
        answers: [Python, HTML, Java, CSS, JavaScript]
        correct_answers: [0, 2, 4]  # Python, Java, JavaScript
        reward: wisdom_scroll
        attached_to: guardian

        on_correct {
            score += 200
            show_message("Wisdom granted!")
        }
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

        # Event Handlers (TIER 3 - optional)
        on_interact {                     # Executed when player interacts with NPC
            # statements
        }
        on_death {                        # Executed when NPC/monster dies
            # statements
        }
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

        on_interact {
            show_message("I have stood guard for centuries...")
            questStarted = true
        }

    skeleton_warrior:
        description: "A hostile skeleton"
        texture: "character/monster/skeleton"
        location: dungeon
        hostile: true
        health: 15
        damage: 2

        on_death {
            score += 150
            monstersKilled += 1
            show_message("Skeleton defeated!")

            if (monstersKilled >= 5) {
                give_item("warrior_badge")
            }
        }

    boss_dragon:
        description: "The final boss dragon"
        texture: "character/monster/dragon"
        location: boss_room
        hostile: true
        health: 100
        damage: 10

        on_death {
            score += 1000
            bossDefeated = true
            unlock("exit_room")
            victory("Dragon slain! You win!")
        }
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

    # Custom stats (optional - override class defaults)
    health: 50                # Maximum health points (optional)
    mana: 150                 # Maximum mana points (optional)
    stamina: 80               # Maximum stamina points (optional)
    speed: 6.0                # Movement speed (optional)
    mana_restore: 3.0         # Mana restoration per second (optional)
    stamina_restore: 2.5      # Stamina restoration per second (optional)
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
# Option 1: Specify only class (position will be random, use class defaults)
player:
    class: hunter

# Option 2: Specify class and starting position
player:
    class: wizard
    start_x: 5
    start_y: 5

# Option 3: Custom stats (override defaults)
player:
    class: wizard
    start_x: 5
    start_y: 5
    health: 50
    mana: 150
    speed: 6.0
    mana_restore: 3.0

# Option 4: Omit player section entirely (defaults to wizard, random position)
# No player section needed - uses defaults
```

**Notes:**

-   If `player` section is omitted, defaults to `wizard` class with random starting position
-   Starting position (`start_x`, `start_y`) is optional - will use random floor tile if not specified
-   Character class determines combat style, starting skills, and stats
-   Both classes have full combat capabilities to fight hostile mobs
-   Custom stats override class defaults - useful for difficulty balancing
-   If a custom stat is not specified, the class default value is used
-   Custom stats allow creating glass cannon builds (high offense, low defense) or tank builds (high defense)

---

## Examples

### Complete Example with Full Programming Features (TIER 1-3)

This example showcases all the advanced programming features including variables, expressions, event handlers, triggers, conditionals, and loops:

```dsl
escape_room:

    metadata:
        title: "The Dynamic Dungeon"
        description: "A fully dynamic escape room with complex logic"
        difficulty: "normal"
        max_time: 60
        fog_of_war: false

    # =============================================================================
    # TIER 1: Variables - Global state management
    # =============================================================================
    variables:
        score: 0
        keysCollected: 0
        totalKeys: 3
        monstersKilled: 0
        bossDefeated: false
        secretFound: false

        # Expression-based initialization
        maxHealth: 100
        startingGold: 50 + 25          # 75

    # =============================================================================
    # TIER 3: Triggers - Global win/lose conditions
    # =============================================================================
    triggers:
        # Victory condition
        when (keysCollected >= totalKeys && bossDefeated) {
            unlock("exit_room")
            victory("You collected all keys and defeated the boss!")
        }

        # Secret achievement
        when (secretFound && score >= 1000) {
            give_item("legendary_sword")
            show_message("Legendary sword unlocked!")
        }

        # Combat milestone
        when (monstersKilled >= 10) {
            show_message("Warrior badge earned!")
            score += 500
        }

    # =============================================================================
    # Rooms with Event Handlers
    # =============================================================================
    rooms:
        entrance:
            description: "The dungeon entrance"
            x: 0
            y: 0
            width: 10
            height: 8
            items: [bronze_key]
            connections: [main_hall]

            # TIER 3: Event handlers
            on_first_enter {
                show_message("Welcome to the Dynamic Dungeon!")
                score += 10
            }

            on_enter {
                # TIER 2: Conditional logic
                if (keysCollected > 0) {
                    show_message("Keys collected: " + keysCollected + "/" + totalKeys)
                } else {
                    show_message("Find keys to unlock the treasure room!")
                }
            }

        main_hall:
            description: "The main hall with enemies"
            x: 12
            y: 0
            width: 15
            height: 12
            npcs: [skeleton1, skeleton2, skeleton3]
            items: [silver_key]
            connections: [entrance, treasure_room, boss_room]

            on_enter {
                print("Entered main hall. Score: ", score)
            }

            on_clear {
                show_message("Main hall cleared! Bonus score!")
                score += 200
                unlock("treasure_room")
            }

        treasure_room:
            description: "A room filled with gold"
            x: 29
            y: 0
            width: 10
            height: 10
            connections: [main_hall]
            locked_by: bronze_key

            on_first_enter {
                # TIER 2: Loop - spawn multiple treasures
                repeat 5 {
                    print("Spawning treasure pile...")
                }
                score += 500
                show_message("Treasure room bonus: +500 points!")
            }

            on_enter {
                if (score < 1000) {
                    show_message("Current score: " + score)
                } else {
                    show_message("High score achieved!")
                    secretFound = true
                }
            }

        boss_room:
            description: "The final boss arena"
            x: 12
            y: 14
            width: 12
            height: 12
            npcs: [boss_dragon]
            connections: [main_hall]
            locked_by: silver_key

            on_enter {
                show_message("Prepare for battle!")
            }

        exit_room:
            description: "The exit"
            x: 42
            y: 0
            width: 8
            height: 8
            connections: [treasure_room]

            on_enter {
                victory("You escaped! Final score: " + score)
            }

    # =============================================================================
    # Items with Event Handlers
    # =============================================================================
    items:
        bronze_key:
            description: "A bronze key"
            type: "key"
            texture: "items/key/small_key.png"

            on_pickup {
                keysCollected += 1
                score += 50
                show_message("Bronze key acquired! (" + keysCollected + "/" + totalKeys + ")")
            }

        silver_key:
            description: "A silver key"
            type: "key"
            texture: "items/key/big_key.png"

            on_pickup {
                keysCollected += 1
                score += 100

                if (keysCollected >= 2) {
                    show_message("Almost there! Find one more key")
                } else {
                    show_message("Silver key found!")
                }
            }

        golden_key:
            description: "A golden key"
            type: "key"
            texture: "items/key/big_key.png"

            on_pickup {
                keysCollected += 1
                score += 150
                show_message("All keys collected!")
            }

        health_potion:
            description: "Restores health"
            type: "consumable"
            texture: "items/potion"

            on_use {
                heal_player(50)
                remove_item("health_potion")
                show_message("Healed 50 HP!")
            }

    # =============================================================================
    # NPCs with Combat and Event Handlers
    # =============================================================================
    npcs:
        skeleton1:
            description: "A skeleton warrior"
            texture: "character/monster/skeleton"
            location: main_hall
            hostile: true
            health: 15
            damage: 2

            on_death {
                monstersKilled += 1
                score += 50
                print("Skeleton defeated! Total: ", monstersKilled)

                # TIER 2: Conditional item drop
                if (monstersKilled >= 5) {
                    give_item("health_potion")
                    show_message("Health potion dropped!")
                }
            }

        skeleton2:
            description: "A skeleton warrior"
            texture: "character/monster/skeleton"
            location: main_hall
            hostile: true
            health: 15
            damage: 2

            on_death {
                monstersKilled += 1
                score += 50
            }

        skeleton3:
            description: "A skeleton warrior"
            texture: "character/monster/skeleton"
            location: main_hall
            hostile: true
            health: 15
            damage: 2

            on_death {
                monstersKilled += 1
                score += 50
            }

        boss_dragon:
            description: "The mighty dragon boss"
            texture: "character/monster/dragon"
            location: boss_room
            hostile: true
            health: 100
            damage: 10

            on_death {
                bossDefeated = true
                score += 1000
                give_item("golden_key")
                show_message("Dragon defeated! Golden key obtained!")
            }

    # =============================================================================
    # Player Configuration
    # =============================================================================
    player:
        class: wizard
        start_x: 5
        start_y: 4
        health: 50
        mana: 150
```

---

### Multi-Room Example (Classic Style)

This example demonstrates a classic multi-room escape room without advanced programming features:

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

### Advanced Features Example: Fog of War & Custom Settings

This example demonstrates the new advanced features added in version 1.1:

```dsl
escape_room:

    metadata:
        title: "The Shadow Dungeon"
        description: "Navigate through darkness with limited vision"
        difficulty: "hard"
        max_time: 45
        fog_of_war: true          # Enable fog of war globally
        view_distance: 5          # Player can see 5 tiles around them
        camera_zoom: 0.8          # Zoomed out for wider view

    player:
        class: wizard
        start_x: 5
        start_y: 5
        # Custom stats - balanced for fog gameplay
        health: 50                # More health than default
        mana: 150                 # Extra mana for abilities
        stamina: 80
        speed: 6.0                # Faster movement
        mana_restore: 3.0         # Faster mana regeneration
        stamina_restore: 2.5

    rooms:
        dark_entrance:
            description: "A pitch-black entrance hall"
            x: 0
            y: 0
            width: 10
            height: 10
            items: [torch]
            connections: [bright_room]

        bright_room:
            description: "A magically lit chamber"
            x: 15
            y: 0
            width: 12
            height: 12
            items: [golden_key]
            connections: [dark_entrance, treasure_vault]

        treasure_vault:
            description: "The final vault"
            x: 15
            y: 15
            width: 8
            height: 8
            connections: [bright_room]
            locked_by: golden_key

    items:
        torch:
            description: "A bright torch"
            type: "tool"
            texture: "items/torch"
            visible: true

        golden_key:
            description: "A shimmering golden key"
            type: "key"
            texture: "items/key/big_key.png"
            visible: true
```

---

## Best Practices

### Variables & State Management (TIER 1)

1. **Initialize Clearly**: Always initialize variables with meaningful values
2. **Descriptive Names**: Use names like `keysCollected`, not `kc` or `x`
3. **Type Consistency**: Don't mix types (e.g., don't assign string to a number variable)
4. **Track Progress**: Use variables for scoring, quest progress, achievements
5. **Boolean Flags**: Use boolean variables for binary states (`secretFound`, `bossDefeated`)

### Event Handlers (TIER 3)

1. **Keep Logic Simple**: Event handlers should be focused and concise
2. **Use Comments**: Explain complex logic within handlers
3. **Avoid Recursion**: Don't call events that trigger themselves
4. **Test Incrementally**: Add one handler at a time and test
5. **Print Debug Info**: Use `print()` statements to track execution flow

### Triggers (TIER 3)

1. **Clear Conditions**: Make trigger conditions easy to understand
2. **Avoid Overlapping**: Don't create triggers with conflicting conditions
3. **One-Shot Logic**: Remember triggers fire once when condition becomes true
4. **Victory Conditions**: Use triggers for win/lose conditions
5. **Milestone Tracking**: Track achievements and quest progression

### Control Flow (TIER 2)

1. **Indent Properly**: Use consistent 2-space or 4-space indentation
2. **Braces Required**: Always use `{ }` for if/else/repeat blocks
3. **Test Conditions**: Verify conditions work before adding complex logic
4. **Loop Bounds**: Be careful with loop counts to avoid performance issues
5. **Nested Loops**: Limit nesting depth for readability (max 2-3 levels)

### Expressions

1. **Use Parentheses**: Make complex expressions clear with `(a + b) * c`
2. **Test Math**: Verify arithmetic operations work as expected
3. **String Concatenation**: Test message formatting before deployment
4. **Property Access**: Ensure properties exist before accessing them
5. **Function Calls**: Check function return types match expectations

### Room Design

1. **Start Small**: Begin with 2-3 rooms and expand
2. **Logical Flow**: Place the starting room (where player spawns) first
3. **Spacing**: Leave gaps between rooms for corridors (minimum 2-3 tiles)
4. **Size**: Typical room dimensions: 8x8 to 15x15 tiles
5. **Key Placement**: Always put required keys in accessible rooms (not behind locked doors)
6. **Event Testing**: Test room events (on_enter, on_exit) thoroughly

### Camera Settings

1. **Default Zoom**: Keep `camera_zoom: 1.0` for normal gameplay
2. **Zoom Out** (`0.7-0.9`): For large rooms or tactical overview
3. **Zoom In** (`1.1-1.5`): For small rooms or to create claustrophobia
4. **Room Transitions**: Use different zoom levels to emphasize room changes
5. **Camera Focus**: Use `camera_focus: hero` to keep player centered

### Custom Player Stats

1. **Class Identity**: Keep some class characteristics (wizards = mana, hunters = stamina)
2. **Difficulty Tuning**: Adjust health for easier/harder gameplay
3. **Speed Balance**: Higher speed (5.0-7.0) makes combat easier
4. **Resource Rates**: Higher restore rates (2.0-4.0) = more ability spam
5. **Glass Cannon**: High damage stats, low health for challenge
6. **Tank Build**: High health/stamina, lower speed for survival

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

**Problem:** Variables not updating  
**Solution:**

-   Check variable is defined in `variables:` section
-   Verify assignment operators: `=`, `+=`, `-=`, `*=`, `/=`
-   Ensure variable names match exactly (case-sensitive)
-   Use `print()` to debug variable values

**Problem:** Event handler not executing  
**Solution:**

-   Verify event handler syntax: `on_enter { ... }` with braces
-   Check indentation is consistent (2 spaces)
-   Ensure event type is valid for entity (e.g., rooms don't have `on_pickup`)
-   Use `print()` statements to confirm handler execution

**Problem:** Trigger never fires  
**Solution:**

-   Check condition is written correctly with proper operators
-   Verify variables in condition are initialized
-   Remember triggers only fire once when condition becomes true
-   Test condition manually with if statements first

**Problem:** If/else statement not working  
**Solution:**

-   Ensure condition is in parentheses: `if (condition) { ... }`
-   Check braces `{ }` are used for both blocks
-   Verify comparison operators: `==` not `=` for equality
-   Test condition with `print()` to see actual value

**Problem:** Loop not executing  
**Solution:**

-   For `repeat 3 { ... }`: Use literal number, not variable
-   For `repeat i from 1 to 5 { ... }`: Verify start < end
-   Check loop body is in braces `{ }`
-   Ensure no infinite loops (max iterations capped internally)

**Problem:** Expression evaluation error  
**Solution:**

-   Check operator precedence with parentheses
-   Verify types match (don't add number + boolean)
-   Test sub-expressions separately
-   Use `print()` to see intermediate results

**Problem:** Function call not working  
**Solution:**

-   Check function name is spelled correctly
-   Verify correct number of arguments
-   Ensure arguments are correct types
-   See Built-in Functions section for full list

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

**Problem:** Fog of war not working (v1.1)  
**Solution:**

-   Check `fog_of_war: true` is set in metadata section
-   Verify `view_distance` is a positive integer (recommended: 3-10)
-   Ensure FogSystem is properly initialized in game setup
-   Try setting `fog_enabled: true` explicitly in room definitions

**Problem:** Camera zoom not applying (v1.1)  
**Solution:**

-   Ensure `camera_zoom` is a float value between 0.5 and 2.0
-   Check that value is actually different from default 1.0
-   Verify Debugger.ZOOM_CAMERA() is being called in game setup
-   Note: Camera zoom applies on game start, not dynamically per room yet

**Problem:** Custom player stats not working (v1.1)  
**Solution:**

-   Verify stat names are spelled correctly (health, mana, stamina, speed, mana_restore, stamina_restore)
-   Ensure values are appropriate types (integers for health/mana/stamina, floats for speed/restore rates)
-   Check that `applyCustomPlayerStats()` is being called after hero creation
-   Use positive values - negative stats will cause issues

---

## Advanced Features

### Fog of War Strategies (v1.1)

Create atmospheric gameplay with strategic fog usage:

```dsl
metadata:
    fog_of_war: true
    view_distance: 5

rooms:
    dark_maze:
        description: "Navigate through darkness"
        fog_enabled: true
        fog_view_distance: 3    # Very limited vision

    safe_room:
        description: "A brightly lit sanctuary"
        fog_enabled: false       # Full visibility
        camera_zoom: 1.2

    boss_arena:
        description: "Final confrontation"
        fog_enabled: true
        fog_view_distance: 7     # Better vision for combat
        camera_zoom: 0.8         # Zoom out for tactical view
```

### Character Build Presets (v1.1)

Create specialized character builds:

```dsl
# Glass Cannon Build - High damage, low survivability
player:
    class: wizard
    health: 20              # Lower than default
    mana: 200               # Much higher mana pool
    speed: 7.0              # Fast movement
    mana_restore: 5.0       # Rapid ability spam

# Tank Build - High survivability
player:
    class: hunter
    health: 100             # Very high health
    stamina: 150
    speed: 4.0              # Slower movement
    stamina_restore: 1.5    # Slower regeneration

# Speed Runner Build - Fast exploration
player:
    class: hunter
    health: 50
    stamina: 200
    speed: 8.0              # Very fast
    stamina_restore: 4.0    # Quick stamina recovery
```

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
        fog_enabled: false       # No fog for tutorial

    easy_puzzle_room:
        locked_by: tutorial_key
        fog_view_distance: 7     # Good visibility

    medium_puzzle_room:
        locked_by: easy_key
        fog_view_distance: 5     # Moderate visibility

    hard_boss_room:
        locked_by: medium_key
        fog_view_distance: 4     # Limited visibility
        camera_zoom: 0.7         # Wide view for combat
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
    player:        # Optional (defaults to wizard if omitted)
```

### Metadata with Advanced Features (v1.1)

```dsl
metadata:
    title: "String"
    description: "String"
    difficulty: "easy"
    max_time: 30
    # Advanced features (optional)
    fog_of_war: true         # Enable fog of war
    view_distance: 5         # Tiles visible around player
    camera_zoom: 0.8         # Camera zoom level (0.5-2.0)
```

### Room with Advanced Features (v1.1)

```dsl
room_id:
    description: "Text"
    x: 0
    y: 0
    width: 10
    height: 10
    # Advanced features (optional)
    fog_enabled: false       # Override global fog setting
    fog_view_distance: 7     # Custom view distance for this room
    camera_zoom: 1.2         # Custom zoom for this room
    camera_focus: hero       # Camera focus (hero or entity name)
```

### Player with Custom Stats (v1.1)

```dsl
player:
    class: wizard            # wizard or hunter
    start_x: 5              # Optional spawn position
    start_y: 5
    # Custom stats (optional - override class defaults)
    health: 50
    mana: 150
    stamina: 80
    speed: 6.0
    mana_restore: 3.0
    stamina_restore: 2.5
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
-   `FogSystem` - (v1.1) Manages fog of war rendering and view distance
-   `Debugger.ZOOM_CAMERA()` - (v1.1) Controls camera zoom level

**AI Components:**

-   `RandomFightAI` - Chase, melee, and ranged attack behaviors
-   `RandomIdleAI` - Patrol behavior when not in combat
-   `SelfDefendTransition` - Switches mob to fight mode when damaged
-   `RangeTransition` - Switches based on proximity (less reliable than SelfDefend)

### Player System

**HeroFactory:**

-   Creates wizard or hunter based on DSL `player.class` property
-   **Wizard**: 15 HP, 100 mana, fireball skill (10 mana cost), heal skill (80 mana cost)
-   **Hunter**: 35 HP, 120 stamina, bow skill (15 damage, 10 stamina), dash skill
-   Both have `SkillComponent` for Q key/mouse casting
-   Both have `InputComponent` for keyboard/mouse controls

**Custom Stats (v1.1):**

-   DSL can override default stats via `applyCustomPlayerStats()`
-   Health: Updates `HealthComponent.maximalHealthpoints()`
-   Mana: Updates `ManaComponent.maxAmount()` and `currentAmount()`
-   Stamina: Updates `StaminaComponent.maxAmount()` and `currentAmount()`
-   Speed: Stored in `VelocityComponent` (note: VelocityComponent doesn't have direct speed setter)
-   Restore rates: Updates `ManaComponent.restorePerSecond()` and `StaminaComponent.restorePerSecond()`

**Resource Management:**

-   Mana regenerates automatically based on restore rate (default: 10 per tick)
-   Stamina regenerates automatically based on restore rate
-   Skills can't be cast without sufficient resources

**Advanced Features (v1.1):**

-   **Fog of War**: Enabled via `definition.isFogOfWarEnabled()`, uses `FogSystem.currentViewDistance()`
-   **Camera Zoom**: Applied via `Debugger.ZOOM_CAMERA(zoom - 1.0f)` on game setup
-   Room-specific settings applied when entering rooms (future enhancement)

### Quiz & Reward System

**Quiz Flow:**

1. Parse quiz definition from DSL (type, question, answers, correct_answers, reward)
2. Validate reward item exists in items section
3. Create quiz entity or attach to NPC
4. Display quiz UI when player interacts (E key)
5. Check answer correctness when submitted
6. Execute `onSuccess` callback if correct (TIER 3: also executes on_correct handler)
7. `giveRewardToPlayer()` creates item and adds to inventory
8. Reward items skipped during map item spawning

**QuizInteractionHandler:**

-   Manages quiz UI display and interaction
-   Calls `onSuccess.run()` callback when quiz completed successfully
-   Executes quiz event handlers (`on_correct`, `on_wrong`)
-   Handles both single-choice and multiple-choice quiz types

### DSL Runtime (TIER 1-3)

**Variable System:**

-   Global variables stored in `Map<String, Object>`
-   Supports numbers (Integer, Double), strings, booleans
-   Scope stack for loop variables (`Deque<Map<String, Object>>`)
-   Variable lookup searches from inner to outer scopes

**Expression Evaluation:**

-   AST-based recursive evaluation
-   Operator precedence handled by grammar rule ordering
-   Type checking at runtime
-   Property access via reflection (`player.health`)
-   Function dispatch to 30+ built-in functions

**Statement Execution:**

-   Assignment statements modify variables
-   If/else with nested condition support
-   Repeat loops with optional loop variables
-   Function call statements for built-in functions

**Event System:**

-   Event types: ON_ENTER, ON_EXIT, ON_FIRST_ENTER, ON_CLEAR, ON_PICKUP, ON_USE, ON_DROP, ON_INTERACT, ON_DEATH, ON_CORRECT, ON_WRONG
-   Event handlers registered per entity + event type
-   Fired via `DSLRuntime.fireEvent(EventType, String entityId)`
-   Multiple handlers can be registered for same event

**Trigger System:**

-   Triggers checked after every event
-   Condition evaluated as expression (must return boolean)
-   Trigger fires once when condition becomes true
-   Tracked via `firedTriggers` set to prevent re-firing

---

## Version History

### Version 2.0 (January 2026)

**Revolutionary Update - Full Programming Language:**

**Core Language Features:**

-   Variables with expression-based initialization
-   Full expression system with 30+ operators and functions
-   If/else statements with unlimited chaining
-   Repeat loops (simple and range-based with loop variables)
-   Event handlers for rooms, items, NPCs, quizzes
-   Global triggers with automatic condition checking
-   30+ built-in functions for game control
-   Proper operator precedence and type system
-   Scoped variables in loops

**Technical Implementation:**

-   ANTLR-based parser with TIER 1-3 grammar
-   AST (Abstract Syntax Tree) for expressions and statements
-   Visitor pattern for parse tree → AST conversion
-   Runtime with variable scopes and event dispatch
-   Expression evaluator with recursive evaluation
-   Statement executor for control flow

**Known Limitations:**

-   `repeat N { ... }` requires literal number, not variable (use range repeat for dynamic counts)
-   No user-defined functions (only built-in functions available)
-   No arrays or data structures beyond simple variables
-   Room coordinate overlap not validated (rooms can overwrite each other)
-   Event handlers cannot be defined dynamically at runtime

### Version 1.1 (October 26, 2025)

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
2. Review example files: `escapeRoom/src/demoDungeon/level/dynamic_test.esc` (TIER 1-3 features) or `complete_showcase.esc`
3. Check console output for parsing errors
4. Verify all IDs are unique and referenced correctly
5. Use `print()` statements for debugging variable values and execution flow

---

**End of Documentation**

```

```
