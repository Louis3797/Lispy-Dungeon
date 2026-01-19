# Escape Room DSL - Technical Documentation

**Complete Developer Guide for the Lispy-Dungeon Escape Room System**

Version: 1.0  
Last Updated: October 25, 2025

---

## Welcome

This technical documentation provides a comprehensive, under-the-hood explanation of how the Escape Room DSL works, from parsing text files to generating playable dungeons. Whether you're looking to understand the system, extend it, or debug issues, you'll find detailed technical information here.

## Documentation Structure

This documentation is organized into 11 modules, each covering a specific aspect of the system:

### **Core System**

1. **[00-overview.md](00-overview.md)** - System Architecture & Overview

    - High-level architecture diagrams
    - Component responsibilities
    - Data flow and execution sequence
    - Technology stack overview

2. **[01-dsl-grammar.md](01-dsl-grammar.md)** - ANTLR4 Grammar Definition

    - Complete grammar rules
    - Token types and lexer rules
    - Syntax examples for each section
    - Grammar extension guide

3. **[02-parsing-pipeline.md](02-parsing-pipeline.md)** - Parsing Process

    - Lexical analysis (tokenization)
    - Syntax analysis (parse tree generation)
    - Semantic analysis (interpretation)
    - Error handling at each stage

4. **[03-data-structures.md](03-data-structures.md)** - Internal Data Models

    - EscapeRoomDefinition structure
    - Room, Item, NPC, Quiz classes
    - Data relationships and validation
    - Memory footprint analysis

5. **[04-level-generation.md](04-level-generation.md)** - Level Creation Algorithm
    - Grid calculation and initialization
    - Room placement (rectangular & custom patterns)
    - Corridor generation (L-shaped, 3-tile wide)
    - Door detection and placement

### **Gameplay Systems**

6. **[05-entity-system.md](05-entity-system.md)** - Entity Component System

    - ECS architecture principles
    - Entity spawning pipeline
    - Component types and systems
    - Entity lifecycle management

7. **[06-combat-system.md](06-combat-system.md)** - Combat Mechanics

    - Player classes (Wizard, Hunter)
    - Hostile NPC AI behaviors
    - Damage calculation and health system
    - Resource management (mana/stamina)

8. **[07-quiz-system.md](07-quiz-system.md)** - Quiz Implementation

    - Quiz types (single/multiple choice, free text)
    - Quiz attachment mechanisms
    - Reward system integration
    - UI interaction flow

9. **[08-door-lock-system.md](08-door-lock-system.md)** - Door & Key Mechanics
    - Door entity creation
    - Lock/unlock system
    - Key item integration
    - Visual feedback system

### **Integration & Extension**

10. **[09-game-integration.md](09-game-integration.md)** - Game Engine Integration

    -   Initialization sequence
    -   Game loop integration
    -   System registration
    -   Runtime behavior

11. **[10-extending-system.md](10-extending-system.md)** - Extension Guide
    -   Adding new DSL features
    -   Creating custom components
    -   Implementing new quiz types
    -   Best practices and patterns

## Quick Navigation

### By Role

**For New Developers:**
Start here → [00-overview.md](00-overview.md) → [01-dsl-grammar.md](01-dsl-grammar.md) → [02-parsing-pipeline.md](02-parsing-pipeline.md)

**For System Architects:**
Read → [00-overview.md](00-overview.md) → [03-data-structures.md](03-data-structures.md) → [04-level-generation.md](04-level-generation.md)

**For Feature Developers:**
See → [10-extending-system.md](10-extending-system.md) → [05-entity-system.md](05-entity-system.md) → [06-combat-system.md](06-combat-system.md)

**For Bug Fixers:**
Check → [02-parsing-pipeline.md](02-parsing-pipeline.md) → [04-level-generation.md](04-level-generation.md) → Relevant system docs

### By Topic

**Understanding Parsing:**

-   [01-dsl-grammar.md](01-dsl-grammar.md) - Grammar rules
-   [02-parsing-pipeline.md](02-parsing-pipeline.md) - Parse process
-   [03-data-structures.md](03-data-structures.md) - Output structures

**Understanding Level Generation:**

-   [04-level-generation.md](04-level-generation.md) - Main algorithm
-   [08-door-lock-system.md](08-door-lock-system.md) - Door mechanics
-   [05-entity-system.md](05-entity-system.md) - Entity placement

**Understanding Gameplay:**

-   [06-combat-system.md](06-combat-system.md) - Combat
-   [07-quiz-system.md](07-quiz-system.md) - Puzzles
-   [05-entity-system.md](05-entity-system.md) - Entities
-   [09-game-integration.md](09-game-integration.md) - Game loop

## Key Concepts

### 1. Domain Specific Language (DSL)

A custom language designed specifically for creating escape rooms. Written in YAML-like syntax, parsed by ANTLR4.

### 2. Entity Component System (ECS)

Architecture pattern where entities are composed of components (data) and processed by systems (logic).

### 3. Level Generation

Algorithm that converts abstract room definitions into a 2D grid of tiles, with automatic corridor and door generation.

### 4. Parse-Time vs Runtime

-   **Parse-time**: DSL file is read and converted to data structures (happens once at startup)
-   **Runtime**: Game loop processes entities and updates game state (happens every frame)

## Code Locations

```
escapeRoom/
├── src/
│   ├── dsl/                          # Core DSL implementation
│   │   ├── parser/                   # Generated ANTLR code
│   │   ├── EscapeRoomInterpreter.java    # [02-parsing-pipeline.md]
│   │   ├── EscapeRoomDefinition.java     # [03-data-structures.md]
│   │   ├── DSLLevelLoader.java           # [04-level-generation.md]
│   │   ├── DSLEntitySpawner.java         # [05-entity-system.md]
│   │   ├── QuizBuilder.java              # [07-quiz-system.md]
│   │   ├── QuizComponent.java            # [07-quiz-system.md]
│   │   ├── DoorEntityFactory.java        # [08-door-lock-system.md]
│   │   └── DoorManager.java              # [08-door-lock-system.md]
│   └── starter/
│       └── DSLEscapeRoom.java        # [09-game-integration.md]
│
├── doc/
│   └── technical/                    # This documentation
│
└── assets/                           # Game resources

escape_room_dsl/
└── EscapeRoomDSL.g4                  # [01-dsl-grammar.md]
```

## System Flow Diagram

```
┌─────────────┐
│ User writes │
│  .esc file  │
└──────┬──────┘
       │
       ▼
┌─────────────┐  [01-dsl-grammar.md]
│   ANTLR4    │  Grammar defines syntax
│   Parser    │
└──────┬──────┘
       │
       ▼
┌─────────────┐  [02-parsing-pipeline.md]
│ Interpreter │  Traverse parse tree
│   Walks     │
│  Parse Tree │
└──────┬──────┘
       │
       ▼
┌─────────────┐  [03-data-structures.md]
│   Escape    │  Internal data model
│    Room     │
│ Definition  │
└──────┬──────┘
       │
       ├─────────────────────────────────┐
       │                                 │
       ▼                                 ▼
┌─────────────┐                   ┌─────────────┐
│    Level    │ [04]              │   Entity    │ [05]
│  Generator  │ Create grid       │   Spawner   │ Create entities
│             │ Place rooms       │             │ Spawn items/NPCs
└──────┬──────┘                   └──────┬──────┘
       │                                 │
       └─────────────┬───────────────────┘
                     │
                     ▼
              ┌─────────────┐  [09-game-integration.md]
              │    Game     │  Start game loop
              │   Engine    │  Process systems
              └─────────────┘  Render frames
```

## Technologies Used

| Technology      | Purpose                 | Documentation                                    |
| --------------- | ----------------------- | ------------------------------------------------ |
| **ANTLR4**      | Parser generator        | [01-dsl-grammar.md](01-dsl-grammar.md)           |
| **Java 21**     | Implementation language | All docs                                         |
| **libGDX**      | Game framework          | [09-game-integration.md](09-game-integration.md) |
| **ECS Pattern** | Architecture            | [05-entity-system.md](05-entity-system.md)       |
| **Gradle**      | Build system            | Build files                                      |

## Related Documentation

### User Documentation

-   `ESCAPE_ROOM_DSL_DOCUMENTATION.md` - User guide for writing DSL files
-   `escapeRoom/COMBAT_GUIDE.md` - Combat system user guide

### Code Documentation

-   Javadoc comments in source files
-   Inline comments explaining complex algorithms

### Examples

-   `escapeRoom/src/demoDungeon/level/demo_room.esc` - Example DSL file

## Getting Started

### 1. Understand the System

Read [00-overview.md](00-overview.md) to get a high-level understanding of the architecture.

### 2. Follow the Data Flow

Trace how a DSL file becomes a playable level:

-   [01-dsl-grammar.md](01-dsl-grammar.md) - Syntax rules
-   [02-parsing-pipeline.md](02-parsing-pipeline.md) - Parsing process
-   [03-data-structures.md](03-data-structures.md) - Data models
-   [04-level-generation.md](04-level-generation.md) - Level creation

### 3. Explore Gameplay Systems

Learn how gameplay features work:

-   [05-entity-system.md](05-entity-system.md) - Entity architecture
-   [06-combat-system.md](06-combat-system.md) - Combat mechanics
-   [07-quiz-system.md](07-quiz-system.md) - Puzzle system

### 4. Extend the System

Add new features:

-   [10-extending-system.md](10-extending-system.md) - Extension guide

## Contributing

When modifying the system:

1. **Update grammar** if changing DSL syntax → Regenerate parser
2. **Update data structures** if adding new data → Update interpreter
3. **Update documentation** to reflect changes
4. **Test thoroughly** with example DSL files
5. **Follow coding style** established in existing code

## Common Tasks

### Adding a New DSL Property

1. Update `EscapeRoomDSL.g4` grammar file
2. Regenerate parser with ANTLR4
3. Update `EscapeRoomInterpreter.java` to extract new property
4. Update relevant data class in `EscapeRoomDefinition.java`
5. Update level generation or entity spawning logic if needed
6. Document in user and technical documentation

See [10-extending-system.md](10-extending-system.md) for detailed steps.

### Debugging Parse Errors

1. Check ANTLR4 error messages for line/column numbers
2. Verify grammar rules in [01-dsl-grammar.md](01-dsl-grammar.md)
3. Enable parser debug output
4. Use parse tree visualization

See [02-parsing-pipeline.md](02-parsing-pipeline.md) for debugging techniques.

### Troubleshooting Level Generation

1. Enable debug output in `DSLLevelLoader`
2. Check ASCII map visualization
3. Verify room positions don't overlap
4. Confirm corridor connections are valid

See [04-level-generation.md](04-level-generation.md) for details.

## Performance Notes

| Operation         | Time           | When             |
| ----------------- | -------------- | ---------------- |
| Parse DSL         | ~50-200ms      | Startup          |
| Generate Level    | ~10-50ms       | Startup          |
| Spawn Entities    | ~5-20ms        | Startup          |
| **Total Startup** | **~100-300ms** | One-time         |
| Game Loop         | 16.6ms/frame   | Runtime (60 FPS) |

The system is designed for fast startup times and smooth runtime performance.

## Troubleshooting

### Common Issues

1. **Parse errors**: Check DSL syntax against [01-dsl-grammar.md](01-dsl-grammar.md)
2. **Missing rooms**: Verify room connections exist
3. **Items not spawning**: Check location references
4. **Doors not working**: Verify key item IDs match

### Debug Tools

-   Console output during level generation
-   ASCII map visualization
-   Parse tree printing
-   Entity inspection

## Version History

-   **1.0** (Oct 2025) - Initial comprehensive technical documentation

## Feedback

This documentation aims to be complete and accurate. If you find:

-   Missing information
-   Unclear explanations
-   Outdated content
-   Technical errors

Please update the documentation to help future developers!

## License

See project LICENSE files for code and asset licensing information.

---

**Start Reading**: [System Overview →](00-overview.md)

Understand the high-level architecture before diving into specifics.
