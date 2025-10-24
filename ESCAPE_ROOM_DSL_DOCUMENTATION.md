# Escape Room DSL Documentation

## Overview

The Escape Room DSL (Domain Specific Language) is a human-readable, YAML-like language designed specifically for creating educational escape room experiences within the Lispy-Dungeon framework. It provides a simple yet powerful way for educators and game designers to create interactive puzzle-based adventures without complex programming.

## Design Philosophy

The DSL follows these core principles:

-   **Simplicity**: YAML-like syntax that's accessible to non-programmers
-   **Puzzle-Centric**: Riddles and interactions as first-class citizens
-   **Educational Focus**: Clear cause-and-effect relationships for learning
-   **Extensible**: Modular design supporting custom puzzle types and logic

## Basic Syntax

The DSL uses a hierarchical structure with 2-space indentation (similar to YAML):

```dsl
escape_room:
    metadata:
        title: "My Escape Room"
        description: "An exciting adventure"

    rooms:
        room_name:
            description: "Room description"
            # ... room properties
```

### Data Types

-   **Strings**: Enclosed in double or single quotes: `"text"` or `'text'`
-   **Integers**: Whole numbers: `42`
-   **Booleans**: `true` or `false`
-   **Arrays**: `[item1, item2, item3]`
-   **Objects**: Key-value pairs with indentation
-   **Identifiers**: Alphanumeric names starting with letter or underscore: `room_name`, `item_1`

## DSL Structure

### Root Element

Every DSL file starts with `escape_room:` and contains the following optional sections:

```dsl
escape_room:
    metadata:     # Game information
    rooms:        # Physical spaces
    puzzles:      # Interactive challenges
    items:        # Collectible objects
    npcs:         # Non-player characters
    logic:        # Game rules and dependencies
    events:       # Reactive behaviors
```

## Section Reference

### Metadata

Defines basic information about the escape room:

```dsl
metadata:
    title: "Ancient Temple Mystery"
    description: "Solve the riddles of the ancient temple"
    difficulty: "easy" | "medium" | "hard"
    max_time: 45  # minutes (optional)
```

### Rooms

Define physical spaces that players can explore:

```dsl
rooms:
    entrance_hall:
        description: "A grand entrance with mysterious symbols"
        x: 1          # Grid position (optional, for layout)
        y: 1
        width: 8      # Room dimensions (optional)
        height: 8
        items: [ancient_scroll, bronze_key]     # Items in room
        npcs: [guardian_statue]                 # NPCs in room
        connections: [treasure_chamber]         # Connected rooms
        locked_by: temple_lock                  # Puzzle that locks room
        atmosphere: "dark"                      # Visual/audio hints
```

### Puzzles

The core interactive elements. Each puzzle has a type and type-specific configuration:

```dsl
puzzles:
    symbol_riddle:
        type: combination    # See puzzle types below
        description: "Arrange the symbols in the correct order"
        difficulty: "easy" | "medium" | "hard"
        reward: bronze_key   # Item given when solved
        hint: "Optional hint text"
        time_limit: 300      # seconds (optional)
        alternatives: [pick_lock]  # Alternative solutions
        # Type-specific config below...
```

#### Puzzle Types

##### Combination Puzzles

Players arrange elements in the correct order:

```dsl
symbol_riddle:
    type: combination
    elements: [sun, moon, star, earth]     # Available elements
    solution: [moon, earth, sun, star]     # Correct arrangement
```

##### Sequence Puzzles

Players perform steps in the correct order:

```dsl
ritual_steps:
    type: sequence
    steps: [light_candle, chant_incantation, place_crystal]
```

##### Logic Puzzles

Players solve logical conditions:

```dsl
gate_logic:
    type: logic
    conditions: [input_a: true, input_b: false, gate_type: "AND"]
    solution: false  # Result of the logic operation
```

##### Dialogue Puzzles

Players interact with NPCs to gather information:

```dsl
npc_interrogation:
    type: dialogue
    npc: shady_figure
    required_information: ["secret_code", "meeting_place"]
    success_condition: "all_information_obtained"
```

##### Custom Puzzles

Reference external implementations:

```dsl
custom_puzzle:
    type: custom
    implementation: "my_custom_puzzle.lua"
    parameters:
        difficulty: 3
        theme: "mathematical"
```

### Items

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
            usable_on: [temple_lock]         # What it unlocks
            combinable_with: [crystal]       # Items it combines with
```

### NPCs (Non-Player Characters)

Interactive characters that provide dialogue and items:

```dsl
npcs:
    guardian_statue:
        description: "A stone statue that seems to watch you"
        texture: "character/monster/chort"
        location: entrance_hall
        dialogue:
            default_text: "The statue remains silent..."
            conditions:
                after_symbol_riddle: "The statue comes to life! 'You have proven wise.'"
        gives_items: [magic_crystal]         # Items NPC can give
        requires_items: [sacred_amulet]      # Items needed to interact
```

### Logic

Defines game rules, win conditions, and dependencies:

```dsl
logic:
    win_condition: treasure_found AND temple_lock_opened

    dependencies:
        temple_lock_opened: has_key OR lock_picked
        treasure_found: temple_lock_opened AND ritual_completed
        ritual_completed: all_candles_lit AND incantation_spoken

    state_variables:
        candles_lit: 0
        magic_activated: false

    timers:
        global_timer: 3600    # Total time in seconds
        puzzle_timer: 300     # Per-puzzle time limit
```

#### Logic Expressions

Dependencies use logical expressions with:

-   **AND**: All conditions must be true
-   **OR**: At least one condition must be true
-   **Parentheses**: Group expressions: `(A OR B) AND C`

### Events

Define reactive behaviors triggered by player actions:

```dsl
events:
    on_puzzle_solved: symbol_riddle
        actions:
            - unlock_door: temple_entrance
            - play_sound: "success_chime.wav"
            - show_message: "The door creaks open!"
            - update_state: puzzle_completed = true

    on_item_collected: ancient_artifact
        actions:
            - trigger_puzzle: artifact_analysis
            - show_message: "You feel a strange energy..."

    on_time_warning: 300  # seconds remaining
        actions:
            - show_message: "Time is running out!"
            - play_sound: "urgent_beep.wav"
```

#### Available Actions

-   `unlock_door: room_name` - Unlock a room
-   `play_sound: sound_file` - Play audio
-   `show_message: text` - Display text to player
-   `trigger_puzzle: puzzle_name` - Activate a puzzle
-   `update_state: variable = value` - Change game state

## Complete Example

```dsl
escape_room:
    metadata:
        title: "The Alchemist's Laboratory"
        description: "Help the alchemist recover his stolen formula"
        difficulty: "medium"
        max_time: 30

    rooms:
        laboratory:
            description: "A cluttered laboratory filled with strange equipment"
            x: 1
            y: 1
            width: 10
            height: 8
            items: [broken_vial, chemistry_book, locked_drawer]
            npcs: [alchemist]

        storage_room:
            description: "Dark storage room with shelves of ingredients"
            x: 12
            y: 1
            width: 6
            height: 6
            locked_by: laboratory_door
            items: [rare_herb, crystal_phial]

    puzzles:
        formula_reconstruction:
            type: combination
            description: "Mix the correct ingredients in the right order"
            elements: [herb, crystal, water, fire]
            solution: [herb, water, crystal, fire]
            reward: completed_formula
            hint: "Follow the alchemical principles"

        drawer_lock:
            type: sequence
            description: "Find the combination for the drawer"
            steps: [find_clue_in_book, decode_numbers, enter_combination]
            alternatives: [pick_lock, break_drawer]
            reward: laboratory_key

    items:
        chemistry_book:
            description: "A book of alchemical formulas"
            type: "document"
            texture: "items/book/book"
            location: laboratory
            readable: true
            content: "The combination is hidden in the margins: 3-7-2"

        rare_herb:
            description: "A rare herb needed for the formula"
            type: "tool"
            texture: "items/herb/herb_green"
            location: storage_room
            visible: false

        laboratory_key:
            description: "Key to the laboratory drawer"
            type: "key"
            texture: "items/key/small_key"

    npcs:
        alchemist:
            description: "A frantic alchemist pacing nervously"
            texture: "character/npc/alchemist"
            location: laboratory
            dialogue:
                default_text: "My formula! It's been stolen! Please help me recover it."
                conditions:
                    after_formula_completed: "You've done it! The formula is complete!"

    logic:
        win_condition: formula_reconstructed AND alchemist_thanked

        dependencies:
            storage_room_accessible: laboratory_key_found
            formula_reconstructed: all_ingredients_collected AND correct_combination
            alchemist_thanked: formula_reconstructed

        state_variables:
            ingredients_collected: 0

    events:
        on_puzzle_solved: formula_reconstruction
            actions:
                - show_message: "The formula glows with magical energy!"
                - play_sound: "success_chime.wav"

        on_item_collected: laboratory_key
            actions:
                - unlock_door: storage_room
                - show_message: "You hear a click as the storage room unlocks"
```

## Grammar Reference

The DSL is parsed using ANTLR with the following formal grammar:

### Core Structure

```antlr
start: escape_room EOF
escape_room: 'escape_room:' NEWLINE INDENT sections DEDENT
sections: metadata? rooms? puzzles? items? npcs? logic? events?
```

### Identifiers and Literals

-   **ID**: `[a-zA-Z_][a-zA-Z0-9_]*` (alphanumeric with underscores)
-   **STRING**: `"text"` or `'text'` (supports escaped quotes)
-   **INT**: `[0-9]+` (whole numbers)
-   **BOOLEAN**: `true | false`
-   **ARRAY**: `[value1, value2, ...]`
-   **OBJECT**: Key-value pairs with indentation

### Keywords

-   Section headers: `metadata`, `rooms`, `puzzles`, `items`, `npcs`, `logic`, `events`
-   Puzzle types: `combination`, `sequence`, `logic`, `dialogue`, `custom`
-   Item types: `key`, `tool`, `document`, `decoration`
-   Difficulty levels: `easy`, `medium`, `hard`
-   Logic operators: `AND`, `OR`

## Best Practices

### 1. **Structure Your Content**

-   Use descriptive names for rooms, puzzles, and items
-   Group related elements logically
-   Keep room descriptions concise but evocative

### 2. **Design for Multiple Paths**

-   Use `alternatives` in puzzles for different solving approaches
-   Leverage `OR` logic in dependencies for flexibility
-   Consider different difficulty levels

### 3. **Balance and Pacing**

-   Set appropriate time limits based on complexity
-   Provide helpful hints without giving away solutions
-   Use events to create engaging feedback

### 4. **Testing and Iteration**

-   Start with simple puzzles and build complexity
-   Test win conditions thoroughly
-   Validate that all dependencies are reachable

### 5. **Educational Integration**

-   Align puzzles with learning objectives
-   Include explanatory content in readable items
-   Use NPC dialogue for storytelling and guidance

## File Format and Usage

-   **File Extension**: `.esc` (Escape room Script)
-   **Encoding**: UTF-8
-   **Indentation**: Exactly 2 spaces (no tabs)
-   **Comments**: `# comment text` (ignored by parser)

### Loading DSL Files

```java
// In Java code
Path dslFile = Path.of("my_escape_room.esc");
EscapeRoomParser parser = new EscapeRoomParser(dslFile);
EscapeRoomDefinition definition = parser.parse();

// Build the level
DSLLevelBuilder.buildLevel(definition);
```

## Error Handling

The parser provides detailed error messages for:

-   Syntax errors (missing colons, incorrect indentation)
-   Type mismatches (wrong puzzle configuration)
-   Reference errors (undefined rooms/items)
-   Logic errors (circular dependencies)

## Extensibility

The DSL supports custom puzzle types through external implementations and a plugin architecture for advanced features.

## Integration with Lispy-Dungeon

The DSL integrates with existing Lispy-Dungeon systems:

-   **Entity Component System (ECS)**: DSL entities become game entities
-   **Asset Management**: Uses existing texture and sound loading
-   **UI Systems**: Leverages dialogue and inventory interfaces
-   **Petri Nets**: Complex logic uses the existing Petri net system

---

_DSL Documentation Version 1.0_  
_Generated from EscapeRoomDSL.g4 grammar and design specifications_  
_Lispy-Dungeon Framework Integration_
