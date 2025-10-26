# DSL Grammar Definition

**Understanding the ANTLR4 Grammar**

[← Back to Overview](00-overview.md) | [Next: Parsing Pipeline →](02-parsing-pipeline.md)

---

## Introduction

The Escape Room DSL grammar is defined using ANTLR4 (ANother Tool for Language Recognition), a powerful parser generator. This document explains how the grammar is structured and how it defines the syntax of `.esc` files.

## Grammar File Location

```
escape_room_dsl/EscapeRoomDSL.g4
```

## Grammar Structure

### Grammar Declaration

```antlr
grammar EscapeRoomDSL;
```

This declares the grammar name, which must match the filename (without `.g4` extension).

### Start Rule

```antlr
start
    : escape_room EOF
    ;
```

Every DSL file must:

1. Start with an `escape_room` declaration
2. End with EOF (End of File)

### Top-Level Structure

```antlr
escape_room
    : 'escape_room:' metadata rooms? quizzes? items? npcs? player? logic? events?
    ;
```

**Breakdown:**

-   `'escape_room:'` - Literal keyword (required)
-   `metadata` - Room metadata (required)
-   `rooms?` - Room definitions (optional, `?` means 0 or 1)
-   `quizzes?` - Quiz definitions (optional)
-   `items?` - Item definitions (optional)
-   `npcs?` - NPC definitions (optional)
-   `player?` - Player configuration (optional)
-   `logic?` - Custom logic (optional, not yet implemented)
-   `events?` - Event triggers (optional, not yet implemented)

## Section Grammar Rules

### Metadata

```antlr
metadata
    : 'metadata:'
      ('title:' STRING)?
      ('description:' STRING)?
      ('difficulty:' STRING)?
      ('max_time:' INT)?
    ;
```

**Key Points:**

-   All fields are optional (`?`)
-   `STRING` tokens are quoted text
-   `INT` tokens are integers

**Example:**

```yaml
metadata:
    title: "My Escape Room"
    description: "A challenging puzzle adventure"
    difficulty: "hard"
    max_time: 3600
```

### Rooms

```antlr
rooms
    : 'rooms:' room+
    ;

room
    : ID ':'
      ('description:' STRING)?
      ('x:' INT)?
      ('y:' INT)?
      ('width:' INT)?
      ('height:' INT)?
      ('pattern:' multiline_string)?
      ('items:' array)?
      ('npcs:' array)?
      ('connections:' array)?
      ('locked_by:' ID)?
      ('atmosphere:' STRING)?
    ;
```

**Key Points:**

-   `room+` means one or more rooms required
-   `ID` is an identifier (room name)
-   `multiline_string` for ASCII patterns
-   `array` for lists of references

**Example:**

```yaml
rooms:
    entrance:
        description: "The main hall"
        x: 2
        y: 2
        width: 10
        height: 8
        items: [key1, scroll1]
        connections: [treasure_room]
```

### Items

```antlr
items
    : 'items:' item+
    ;

item
    : ID ':'
      item_property*
    ;

item_property
    : 'description:' STRING
    | 'type:' (ITEM_TYPE | STRING)
    | 'texture:' STRING
    | 'properties:' object
    | 'location:' ID
    | 'visible:' BOOLEAN
    | 'readable:' BOOLEAN
    | 'content:' STRING
    ;
```

**Key Points:**

-   `item+` requires at least one item
-   `item_property*` means zero or more properties
-   `|` means OR (alternatives)
-   `ITEM_TYPE` is a predefined token (key, scroll, etc.)

**Example:**

```yaml
items:
    golden_key:
        type: key
        description: "A golden key"
        texture: "items/key_gold"
        location: entrance

    scroll1:
        type: scroll
        readable: true
        content: "Ancient wisdom here..."
```

### NPCs

```antlr
npcs
    : 'npcs:' npc+
    ;

npc
    : ID ':'
      npc_property*
    ;

npc_property
    : 'description:' STRING
    | 'texture:' STRING
    | 'location:' ID
    | 'dialogue:' dialogue
    | 'gives_items:' array
    | 'requires_items:' array
    | 'start_x:' INT
    | 'start_y:' INT
    | 'hostile:' BOOLEAN
    | 'health:' INT
    | 'damage:' INT
    ;
```

**Key Points:**

-   `hostile: true` creates combat NPCs
-   `health` and `damage` for combat stats
-   `dialogue` for interactive NPCs

**Example:**

```yaml
npcs:
    skeleton:
        texture: "character/monster/skeleton"
        hostile: true
        health: 15
        damage: 2
        location: treasure_room
```

### Quizzes

```antlr
quizzes
    : 'quizzes:' quiz+
    ;

quiz
    : ID ':'
      quiz_property+
    ;

quiz_property
    : 'type:' QUIZ_TYPE
    | 'question:' STRING
    | 'answers:' array
    | 'correct:' (INT | array)
    | 'reward:' ID
    | 'attached_to:' ID
    | 'location:' ID
    | 'explanation:' STRING
    ;
```

**Key Points:**

-   `QUIZ_TYPE`: single_choice, multiple_choice, free_text
-   `correct`: Single index or array of indices
-   `attached_to`: Links quiz to chest/NPC
-   `reward`: Item given on completion

**Example:**

```yaml
quizzes:
    math_quiz:
        type: single_choice
        question: "What is 2 + 2?"
        answers: ["3", "4", "5"]
        correct: 1
        reward: golden_key
        attached_to: chest1
```

### Player

```antlr
player
    : 'player:'
      ('class:' PLAYER_CLASS)?
      ('start_room:' ID)?
      ('start_x:' INT)?
      ('start_y:' INT)?
    ;

PLAYER_CLASS
    : 'wizard'
    | 'hunter'
    ;
```

**Key Points:**

-   `wizard`: 15 HP, mana-based, fireball/heal
-   `hunter`: 35 HP, stamina-based, bow/dash
-   Optional spawn position

**Example:**

```yaml
player:
    class: wizard
    start_room: entrance
```

## Lexer Rules (Tokens)

### Keywords

Keywords are literal strings in single quotes:

```antlr
'escape_room:' 'metadata:' 'rooms:' 'items:' 'npcs:' 'quizzes:' 'player:'
```

### Token Types

```antlr
ITEM_TYPE
    : 'key' | 'scroll' | 'book' | 'potion' | 'artifact'
    ;

QUIZ_TYPE
    : 'single_choice' | 'multiple_choice' | 'free_text'
    ;

PLAYER_CLASS
    : 'wizard' | 'hunter'
    ;

BOOLEAN
    : 'true' | 'false'
    ;

INT
    : [0-9]+
    ;

STRING
    : '"' (~["\r\n])* '"'
    ;

ID
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

MULTILINE_STRING
    : '"""' .*? '"""'
    ;
```

**Explanation:**

-   `INT`: One or more digits
-   `STRING`: Quoted text (no newlines)
-   `ID`: Identifier (starts with letter/underscore)
-   `MULTILINE_STRING`: Triple-quoted text (for ASCII patterns)

### Arrays

```antlr
array
    : '[' (ID (',' ID)*)? ']'
    ;
```

**Format:** `[item1, item2, item3]`

### Objects

```antlr
object
    : '{' (object_pair (',' object_pair)*)? '}'
    ;

object_pair
    : ID ':' (STRING | INT | BOOLEAN)
    ;
```

**Format:** `{key1: "value", key2: 123}`

### Whitespace and Comments

```antlr
WS
    : [ \t\r\n]+ -> skip
    ;

COMMENT
    : '#' ~[\r\n]* -> skip
    ;
```

**Key Points:**

-   Whitespace is ignored
-   `#` starts a comment (rest of line ignored)

## Grammar Hierarchy

```
start
└── escape_room
    ├── metadata
    ├── rooms
    │   └── room+
    │       ├── ID
    │       └── properties...
    ├── quizzes
    │   └── quiz+
    ├── items
    │   └── item+
    ├── npcs
    │   └── npc+
    └── player
```

## Parse Tree Example

For this DSL:

```yaml
escape_room:
metadata:
    title: "Test Room"

rooms:
    hall:
        x: 0
        y: 0
        width: 10
        height: 10
```

Parse tree structure:

```
start
└── escape_room
    ├── 'escape_room:'
    ├── metadata
    │   ├── 'metadata:'
    │   ├── 'title:'
    │   └── STRING["Test Room"]
    └── rooms
        ├── 'rooms:'
        └── room
            ├── ID[hall]
            ├── ':'
            ├── 'x:'
            ├── INT[0]
            ├── 'y:'
            ├── INT[0]
            ├── 'width:'
            ├── INT[10]
            ├── 'height:'
            └── INT[10]
```

## Error Detection

ANTLR automatically detects:

1. **Syntax errors**: Invalid token sequences
2. **Lexical errors**: Invalid characters
3. **Missing tokens**: Required elements omitted

Example error:

```
line 5:4 mismatched input 'widht' expecting {'description:', 'x:', 'y:', 'width:', ...}
```

## Grammar Best Practices

### 1. Order Independence

Most properties can be specified in any order:

```yaml
# Both valid
room1:
    x: 5
    y: 10

room2:
    y: 10
    x: 5
```

### 2. Optional vs Required

-   Metadata is required
-   At least one room is required
-   Items, NPCs, quizzes are optional

### 3. Forward References

References are resolved after full parsing:

```yaml
rooms:
    entrance:
        connections: [treasury] # Forward reference

    treasury: # Defined later - OK!
        x: 20
        y: 20
```

### 4. Case Sensitivity

-   Keywords: Case-sensitive (`rooms:` not `Rooms:`)
-   IDs: Case-sensitive (`golden_key` ≠ `Golden_Key`)
-   Types: Case-sensitive (`wizard` not `Wizard`)

## Grammar Extension Points

To add new features, modify:

1. **New section**: Add to `escape_room` rule
2. **New property**: Add to relevant `*_property` rule
3. **New token**: Add to lexer rules
4. **New type**: Create new token rule

Example - Adding a `music` property to rooms:

```antlr
room
    : ID ':'
      ('description:' STRING)?
      ...
      ('music:' STRING)?     // Add this line
    ;
```

## ANTLR4 Generation

To regenerate parser from grammar:

```bash
# Navigate to grammar directory
cd escape_room_dsl

# Generate Java parser code
antlr4 -Dlanguage=Java -package dsl.parser -o ../escapeRoom/src/dsl/parser EscapeRoomDSL.g4

# Generated files:
# - EscapeRoomDSLLexer.java
# - EscapeRoomDSLParser.java
# - EscapeRoomDSLBaseListener.java
# - EscapeRoomDSLListener.java
```

## Complete Grammar File

The complete grammar can be found at:

```
escape_room_dsl/EscapeRoomDSL.g4
```

It defines approximately:

-   20+ parser rules
-   10+ lexer rules
-   50+ property types

## Summary

| Concept          | Description                                        |
| ---------------- | -------------------------------------------------- | ---------------- |
| **Grammar**      | Defines DSL syntax using ANTLR4 notation           |
| **Parser Rules** | Lowercase, define structure (e.g., `room`, `item`) |
| **Lexer Rules**  | Uppercase, define tokens (e.g., `INT`, `STRING`)   |
| **Alternatives** | Use `                                              | ` for OR choices |
| **Optionals**    | Use `?` for 0-or-1 occurrences                     |
| **Repetition**   | Use `+` for 1-or-more, `*` for 0-or-more           |
| **Comments**     | Start with `#`, ignored by parser                  |

---

**Next**: [Parsing Pipeline →](02-parsing-pipeline.md)

Learn how the grammar is used to parse `.esc` files into data structures.
