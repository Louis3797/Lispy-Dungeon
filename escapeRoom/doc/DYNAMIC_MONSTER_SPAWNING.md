# Dynamic Monster Spawning Feature

**Status:** ✅ Fully Implemented  
**Date:** January 10, 2026  
**Version:** 1.2

## Overview

The `spawn_monster()` function allows you to dynamically spawn monsters at runtime using loops in event handlers. This enables creating waves of enemies, arena battles, and dynamic difficulty scaling without pre-defining individual NPC instances.

## Syntax

```dsl
spawn_monster(npcId: string)
```

**Parameters:**

-   `npcId`: The ID of an NPC defined in the `npcs` section

**Returns:** None

## Basic Example

```dsl
escape_room:
    npcs:
        skeleton_warrior:
            description: "A skeletal warrior"
            texture: "character/monster/skelet"
            hostile: true
            health: 50
            damage: 10

    rooms:
        arena:
            description: "An arena filled with enemies"
            x: 0
            y: 0
            width: 14
            height: 14

            on_first_enter {
                # Spawn 3 skeletons
                repeat 3 {
                    spawn_monster("skeleton_warrior")
                }
                show_message("3 skeleton warriors appear!")
            }
```

## Advanced Examples

### Wave-Based Spawning with Counter

```dsl
room "boss_chamber" {
    on_enter {
        # Spawn 5 zombies in sequence
        repeat i from 1 to 5 {
            spawn_monster("zombie")
            print("Spawning zombie wave ", i, " of 5")
        }
    }
}
```

### Conditional Spawning Based on Variables

```dsl
variables:
    difficulty: 1
    enemiesPerWave: 3

room "dynamic_arena" {
    on_first_enter {
        # Spawn more enemies on higher difficulty
        repeat (enemiesPerWave * difficulty) {
            spawn_monster("goblin")
        }
    }
}
```

### Mixed Enemy Types

```dsl
room "mixed_battle" {
    on_enter {
        # Spawn 3 skeletons
        repeat 3 {
            spawn_monster("skeleton_warrior")
        }

        # Spawn 2 zombies
        repeat 2 {
            spawn_monster("zombie")
        }

        show_message("A mixed horde appears!")
    }
}
```

## Key Features

✅ **Dynamic Runtime Spawning**: Monsters are created when the event fires, not at level load  
✅ **Loop Integration**: Works seamlessly with `repeat N` and `repeat i from X to Y` loops  
✅ **Event Handler Preservation**: Spawned monsters retain their `on_death` and `on_interact` handlers  
✅ **Random Positioning**: Automatically spawns at random valid floor tiles  
✅ **Full Combat Support**: Spawned monsters have full AI, health, damage, and combat capabilities  
✅ **No Location Required**: Unlike static NPCs, no `location` property needed in NPC definition

## Comparison: Static vs Dynamic Spawning

### Static Spawning (Old Method)

**Pros:**

-   Simple and straightforward
-   Guaranteed placement

**Cons:**

-   Requires creating multiple NPC definitions (skeleton_1, skeleton_2, etc.)
-   No dynamic behavior
-   Verbose for large numbers of enemies

```dsl
# Old method - requires defining each instance
npcs:
    skeleton_1:
        description: "Skeleton warrior"
        texture: "character/monster/skelet"
        location: arena
        hostile: true
        health: 50

    skeleton_2:
        description: "Skeleton warrior"
        texture: "character/monster/skelet"
        location: arena
        hostile: true
        health: 50

    skeleton_3:
        description: "Skeleton warrior"
        texture: "character/monster/skelet"
        location: arena
        hostile: true
        health: 50

rooms:
    arena:
        npcs: ["skeleton_1", "skeleton_2", "skeleton_3"]
```

### Dynamic Spawning (New Method)

**Pros:**

-   Concise and maintainable
-   Easy to adjust enemy counts
-   Supports loops and conditional logic
-   One NPC definition for multiple spawns

**Cons:**

-   Spawns at random positions (less control)
-   Requires understanding of event handlers

```dsl
# New method - single definition, spawn in loops
npcs:
    skeleton_warrior:
        description: "Skeleton warrior"
        texture: "character/monster/skelet"
        hostile: true
        health: 50

rooms:
    arena:
        on_first_enter {
            repeat 3 {
                spawn_monster("skeleton_warrior")
            }
        }
```

## Technical Details

### Implementation Components

1. **Grammar**: Added `SPAWN_MONSTER` keyword to `EscapeRoomDSL.g4`
2. **Runtime**: Added `spawn_monster` built-in function to `DSLRuntime.java`
3. **GameBridge**: Added `spawnMonster(String npcId)` interface method
4. **Entity Spawner**: Made `createNPCEntity()` public with DSLRuntime parameter
5. **Integration**: Implemented in `DSLEscapeRoom.java` GameBridge

### Spawn Process Flow

1. `spawn_monster("npcId")` called in event handler
2. DSL Runtime invokes `gameBridge.spawnMonster("npcId")`
3. GameBridge retrieves NPC definition from parsed escape room
4. `DSLEntitySpawner.createNPCEntity()` creates the entity
5. Random floor position assigned
6. Event handlers registered (on_death, on_interact)
7. Entity added to game world via `Game.add(entity)`

### Event Handler Support

Dynamically spawned NPCs support these event handlers:

-   `on_death`: Triggered when monster is killed
-   `on_interact`: Triggered when player interacts (non-hostile only)

```dsl
npcs:
    arena_boss:
        description: "Arena boss"
        texture: "character/monster/big_demon"
        hostile: true
        health: 500
        damage: 50

        on_death {
            show_message("The boss has been defeated!")
            score += 1000
            unlock("treasure_vault")
        }

rooms:
    boss_arena:
        on_enter {
            spawn_monster("arena_boss")
        }
```

## Best Practices

### ✅ Do

-   Define reusable NPC templates for spawning
-   Use loops to spawn multiple copies
-   Combine with variables for dynamic difficulty
-   Use `on_clear` to reward completing rooms
-   Add feedback messages when spawning

### ❌ Don't

-   Don't set `location` property on NPCs meant for dynamic spawning
-   Don't spawn too many monsters at once (performance)
-   Don't forget to define the NPC in the `npcs` section first

## Performance Considerations

-   Each spawned monster creates a full Entity with components
-   Spawning 50+ monsters at once may impact performance
-   Consider staggered spawning for large battles:

```dsl
variables:
    waveNumber: 0

triggers:
    when (waveNumber == 1) {
        repeat 5 { spawn_monster("zombie") }
    }

    when (waveNumber == 2) {
        repeat 7 { spawn_monster("zombie") }
    }

    when (waveNumber == 3) {
        repeat 10 { spawn_monster("zombie") }
    }
```

## Complete Example

See [`complete_showcase.esc`](../demoDungeon/level/complete_showcase.esc) lines 294-350 for a working example featuring:

-   Monster arena with 3 skeleton warriors
-   Horde chamber with 5 zombies
-   Event handlers for tracking progress
-   Score and variable integration

## Future Enhancements

Potential improvements for future versions:

-   [ ] Specify spawn positions: `spawn_monster("npc", x, y)`
-   [ ] Spawn delays: `spawn_monster_delayed("npc", seconds)`
-   [ ] Spawn patterns: `spawn_circle("npc", count, radius)`
-   [ ] Conditional spawning helpers: `spawn_if(condition, "npc")`
-   [ ] Boss minion spawning during combat
-   [ ] Wave-based difficulty scaling

## Related Documentation

-   [DSL Programming Features](./DSL_PROGRAMMING_FEATURES.md) - Full programming guide
-   [Escape Room DSL Documentation](../../ESCAPE_ROOM_DSL_DOCUMENTATION.md) - Complete DSL reference
-   [Complete Showcase Example](../demoDungeon/level/complete_showcase.esc) - Working examples

---

**Author:** GitHub Copilot  
**Contributors:** louis  
**Last Updated:** January 10, 2026
