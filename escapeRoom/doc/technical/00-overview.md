# Technical Documentation Overview

**Lispy-Dungeon Escape Room DSL - Complete Developer Guide**

Version: 1.0  
Last Updated: October 25, 2025

---

## Table of Contents

1. [Overview](00-overview.md) _(This Document)_
2. [DSL Grammar](01-dsl-grammar.md)
3. [Parsing Pipeline](02-parsing-pipeline.md)
4. [Data Structures](03-data-structures.md)
5. [Level Generation](04-level-generation.md)
6. [Entity System](05-entity-system.md)
7. [Combat System](06-combat-system.md)
8. [Quiz System](07-quiz-system.md)
9. [Door & Lock System](08-door-lock-system.md)
10. [Game Integration](09-game-integration.md)
11. [Extending the System](10-extending-system.md)

---

## Introduction

The Escape Room DSL is a domain-specific language built on top of the Lispy-Dungeon game engine. It allows game designers and educators to create complex, multi-room puzzle adventures without writing Java code. This documentation provides a complete technical reference for understanding and extending the system.

## System Architecture

### High-Level Overview

```
┌─────────────────┐
│  .esc DSL File  │  User writes escape room definition
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│  ANTLR4 Lexer   │  Tokenization
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│  ANTLR4 Parser  │  Syntax analysis & AST generation
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│  Interpreter    │  AST traversal → EscapeRoomDefinition
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│  Level Loader   │  Generate DungeonLevel layout
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│ Entity Spawner  │  Create game entities (items, NPCs, quizzes)
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│   Game Engine   │  Run the escape room
└─────────────────┘
```

### Component Responsibilities

| Component          | Location                           | Purpose                               |
| ------------------ | ---------------------------------- | ------------------------------------- |
| **DSL Grammar**    | `escape_room_dsl/EscapeRoomDSL.g4` | Defines syntax rules                  |
| **Lexer/Parser**   | `dsl/parser/` (generated)          | Tokenize and parse DSL files          |
| **Interpreter**    | `dsl/EscapeRoomInterpreter.java`   | Convert parse tree to data structures |
| **Data Models**    | `dsl/EscapeRoomDefinition.java`    | Store parsed escape room data         |
| **Level Loader**   | `dsl/DSLLevelLoader.java`          | Generate playable level layouts       |
| **Entity Spawner** | `dsl/DSLEntitySpawner.java`        | Create game entities                  |
| **Quiz System**    | `dsl/Quiz*.java`                   | Handle quiz interactions              |
| **Door System**    | `dsl/Door*.java`                   | Manage locked doors and keys          |
| **Game Starter**   | `starter/DSLEscapeRoom.java`       | Initialize and run the game           |

## Key Technologies

### ANTLR4

-   **Version**: 4.x
-   **Purpose**: Parser generator for the DSL
-   **Grammar File**: `EscapeRoomDSL.g4`
-   **Generated Classes**: Lexer, Parser, Listener (BaseListener)

### Java

-   **Version**: 21
-   **Build System**: Gradle
-   **Core Packages**:
    -   `dsl.*` - DSL-specific code
    -   `core.*` - Game engine (ECS architecture)
    -   `contrib.*` - Reusable game components

### Entity Component System (ECS)

-   **Architecture Pattern**: Data-oriented design
-   **Components**: Data containers (position, velocity, health, etc.)
-   **Systems**: Logic processors (AI, physics, rendering, etc.)
-   **Entities**: Composition of components

## Data Flow

### 1. Parse Time (Startup)

```
DSL File → Lexer → Tokens → Parser → Parse Tree → Interpreter → EscapeRoomDefinition
```

### 2. Level Generation (Startup)

```
EscapeRoomDefinition → DSLLevelLoader → LevelElement[][] → DungeonLevel
```

### 3. Entity Spawning (Startup)

```
EscapeRoomDefinition → DSLEntitySpawner → Entity instances → Game.add()
```

### 4. Runtime (Gameplay)

```
Player Input → Game Systems → Component Updates → Render → Repeat
```

## File Structure

```
escapeRoom/
├── src/
│   ├── dsl/                          # DSL implementation
│   │   ├── parser/                   # Generated ANTLR code
│   │   ├── EscapeRoomInterpreter.java
│   │   ├── EscapeRoomDefinition.java
│   │   ├── DSLLevelLoader.java
│   │   ├── DSLEntitySpawner.java
│   │   ├── QuizBuilder.java
│   │   ├── QuizComponent.java
│   │   ├── QuizEntityFactory.java
│   │   ├── QuizInteractionHandler.java
│   │   ├── DoorEntityFactory.java
│   │   ├── DoorManager.java
│   │   ├── EscapeRoomKey.java
│   │   └── Player.java
│   ├── starter/
│   │   └── DSLEscapeRoom.java        # Main entry point
│   └── demoDungeon/
│       └── level/
│           └── demo_room.esc         # Example DSL file
├── doc/
│   └── technical/                     # This documentation
└── assets/                            # Textures, sounds, etc.

escape_room_dsl/
└── EscapeRoomDSL.g4                   # ANTLR grammar definition
```

## Execution Flow

### Initialization Sequence

1. **`DSLEscapeRoom.main()`** - Entry point
2. **Parse DSL file** - Load and tokenize `.esc` file
3. **Create definition** - Build `EscapeRoomDefinition` via interpreter
4. **Generate level** - Create `DungeonLevel` layout
5. **Spawn player** - Create hero entity with chosen class
6. **Spawn doors** - Create door entities at corridor entrances
7. **Spawn entities** - Create items, NPCs, quizzes
8. **Start game loop** - `Game.run()`

### Game Loop

```java
while (running) {
    // 1. Handle input
    InputSystem.update();

    // 2. Update game logic
    for (System system : systems) {
        system.update();
    }

    // 3. Render frame
    RenderSystem.render();

    // 4. Wait for next frame
    Thread.sleep(frameDelay);
}
```

## Core Concepts

### Component-Based Architecture

Entities are composed of components rather than using inheritance:

```java
Entity hero = new Entity();
hero.add(new PositionComponent());
hero.add(new VelocityComponent());
hero.add(new HealthComponent(100));
hero.add(new InventoryComponent());
```

### Systems Process Components

Systems iterate over entities with specific component combinations:

```java
public class MovementSystem extends System {
    public MovementSystem() {
        super(PositionComponent.class, VelocityComponent.class);
    }

    @Override
    public void execute(Entity entity) {
        var pos = entity.fetch(PositionComponent.class);
        var vel = entity.fetch(VelocityComponent.class);
        // Update position based on velocity
    }
}
```

### DSL as Configuration

The DSL acts as a declarative configuration layer that gets compiled into imperative game code at startup.

## Performance Considerations

-   **Parse time**: ~50-200ms for typical escape room (one-time cost)
-   **Level generation**: ~10-50ms (one-time cost)
-   **Entity spawning**: ~5-20ms per entity (one-time cost)
-   **Runtime**: 60 FPS target (16.6ms per frame budget)

## Error Handling Strategy

1. **Parse errors**: ANTLR reports syntax errors with line/column numbers
2. **Semantic errors**: Interpreter validates references (e.g., room connections exist)
3. **Runtime errors**: Graceful degradation (log error, continue game)
4. **Debug output**: Extensive console logging during startup

## Dependencies

### External Libraries

-   ANTLR4 Runtime
-   libGDX (game framework)
-   Java Standard Library

### Internal Dependencies

-   Core game engine (`core.*`)
-   Contribution packages (`contrib.*`)
-   Task/Quiz system (`task.*`)

## Testing Strategy

-   **Unit tests**: Individual component testing
-   **Integration tests**: Full DSL parsing pipeline
-   **Example files**: `demo_room.esc` serves as integration test
-   **Manual testing**: Play through generated escape rooms

## Common Patterns

### Builder Pattern

Used for constructing complex objects:

```java
Quiz quiz = new QuizBuilder()
    .question("What is 2+2?")
    .type(QuizType.SINGLE_CHOICE)
    .answers(List.of("3", "4", "5"))
    .correctIndices(List.of(1))
    .build();
```

### Factory Pattern

Used for entity creation:

```java
Entity door = DoorEntityFactory.createDoor(position, isLocked, requiredKey);
```

### Observer Pattern

Used for event handling:

```java
entity.add(new InteractionComponent(e -> {
    // Handle interaction
}));
```

## Next Steps

To understand the system in depth, read the documentation in order:

1. Start with [DSL Grammar](01-dsl-grammar.md) to understand the syntax
2. Learn the [Parsing Pipeline](02-parsing-pipeline.md) to see how text becomes data
3. Study [Data Structures](03-data-structures.md) to understand the internal model
4. Follow [Level Generation](04-level-generation.md) to see how levels are created
5. Continue through remaining topics to understand gameplay systems

## Quick Start for Developers

```bash
# 1. Compile the project
./gradlew build

# 2. Run example escape room
./gradlew :escapeRoom:run

# 3. Modify the DSL file
# Edit: escapeRoom/src/demoDungeon/level/demo_room.esc

# 4. Re-run to see changes
./gradlew :escapeRoom:run
```

## Getting Help

-   **User documentation**: `ESCAPE_ROOM_DSL_DOCUMENTATION.md`
-   **Combat guide**: `escapeRoom/COMBAT_GUIDE.md`
-   **Examples**: `escapeRoom/src/demoDungeon/level/`
-   **Source code**: Well-commented Java files in `escapeRoom/src/dsl/`

---

**Next**: [DSL Grammar →](01-dsl-grammar.md)
