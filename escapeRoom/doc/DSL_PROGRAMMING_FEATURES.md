# DSL Programming Features Roadmap

---

## Variables & Expressions (Foundation)

### 1. Variables

Define mutable state that can be tracked throughout the game.

```dsl
variables {
    keysCollected: 0
    doorUnlocked: false
    playerName: "Hero"
    visitedRooms: []
}
```

**Use Cases:**

- Track player progress
- Store inventory counts
- Flag completion states

### 2. Expressions & Math

Allow computed values instead of just literals.

```dsl
npc "boss" {
    health: difficulty * 50 + 100
    damage: player.level * 2
    position: (room.width / 2, room.height / 2)
}

item "scaling_sword" {
    damage: 10 + (player.level * 5)
}
```

**Supported Operations:**

- Arithmetic: `+`, `-`, `*`, `/`, `%`
- Comparison: `==`, `!=`, `<`, `>`, `<=`, `>=`
- Logical: `&&`, `||`, `!`
- Property access: `player.health`, `room.width`

---

## TConditionals & Control Flow

### 3. If/Else Conditions

Enable conditional content and behavior.

```dsl
room "treasure_room" {
    visible: if (hasItem("golden_key")) true else false

    door "north" {
        locked: keysCollected < 3
        message: if (locked) "You need 3 keys" else "The door opens!"
    }
}

npc "guard" {
    dialogue: if (player.reputation > 50) {
        "Welcome, friend!"
    } else if (player.reputation > 0) {
        "State your business."
    } else {
        "Get out of here!"
    }
}
```

### 4. Loops for Procedural Generation

Generate repetitive content programmatically.

```dsl
room "dungeon_corridor" {
    // Generate 5 torches along the wall
    repeat i from 0 to 4 {
        item "torch" at (i * 3, 0)
    }

    // Spawn random enemies
    repeat 3 {
        spawn random(["skeleton", "zombie", "ghost"])
    }
}

room "chess_board" {
    repeat x from 0 to 7 {
        repeat y from 0 to 7 {
            tile: if ((x + y) % 2 == 0) "white" else "black" at (x, y)
        }
    }
}
```

### 4.5 Dynamic Monster Spawning

Spawn multiple monsters dynamically using loops with the `spawn_monster()` function.

**Implementation Status:** Fully Implemented (January 2026)

```dsl
npcs:
    skeleton_warrior:
        description: "A skeletal warrior"
        texture: "character/monster/skelet"
        hostile: true
        health: 50
        damage: 10

    zombie:
        description: "A shambling zombie"
        texture: "character/monster/zombie"
        hostile: true
        health: 80
        damage: 15

rooms:
    monster_arena:
        description: "A dark arena filled with enemies"
        x: 0
        y: 0
        width: 14
        height: 14

        on_first_enter {
            show_message("You enter the monster arena!")

            # Spawn multiple skeletons using a loop
            repeat 3 {
                spawn_monster("skeleton_warrior")
            }

            show_message("3 skeleton warriors appear!")
        }

    horde_chamber:
        description: "A chamber with waves of zombies"
        x: 16
        y: 0
        width: 12
        height: 10

        on_first_enter {
            show_message("Warning: Zombie horde detected!")

            # Spawn multiple zombies with a counter
            repeat i from 1 to 5 {
                spawn_monster("zombie")
                print("Spawning zombie ", i, " of 5")
            }

            show_message("5 zombies have appeared!")
        }
```

**Key Features:**

- ✅ **Dynamic spawning**: Monsters are created at runtime, not pre-defined in room
- ✅ **Loop integration**: Works with both `repeat N` and `repeat i from X to Y` loops
- ✅ **NPC definitions**: Spawn from any NPC defined in the `npcs` section
- ✅ **Event handlers**: Dynamically spawned NPCs retain their `on_death` and `on_interact` handlers
- ✅ **Random positioning**: Monsters spawn at random valid floor tiles in the current room
- ✅ **Combat ready**: Spawned monsters are fully functional with AI, health, and damage

**Technical Implementation:**

```java
// DSLRuntime.java - Built-in function registration
builtinFunctions.put("spawn_monster", args -> {
    checkArgs("spawn_monster", args, 1);
    if (gameBridge != null) {
        String npcId = args.get(0).toString();
        gameBridge.spawnMonster(npcId);
    }
    return null;
});

// GameBridge interface
void spawnMonster(String npcId);

// DSLEntitySpawner.java - Public NPC creation
public static Entity createNPCEntity(String npcId, NPC npcDef, DSLRuntime runtime) {
    // Creates hostile or friendly NPC with event handlers
    // Spawns at random floor position
    // Returns fully configured Entity
}
```

**Use Cases:**

1. **Arena battles**: Spawn waves of enemies when entering
2. **Dynamic difficulty**: Spawn more enemies based on player level
3. **Conditional spawning**: Spawn based on variables or triggers
4. **Boss encounters**: Spawn minions during boss fights
5. **Resource management**: Limit spawns based on player stats

---

## Events & Triggers (Game Logic)

### 5. Event Handlers

React to player actions and game events.

```dsl
room "dark_cave" {
    on_enter {
        player.health -= 10
        show_message("The darkness hurts you!")
        play_sound("damage")
    }

    on_exit {
        keysCollected += 1
        show_message("You found a key!")
    }

    on_first_enter {
        show_cutscene("cave_intro")
    }
}

item "healing_potion" {
    on_pickup {
        player.health += 50
        play_sound("healing")
        show_message("You feel refreshed!")
    }

    on_use {
        player.health = min(player.health + 100, player.maxHealth)
        destroy_item(this)
    }
}

npc "merchant" {
    on_interact {
        if (player.gold >= 100) {
            give_item("sword")
            player.gold -= 100
            say("Thank you for your purchase!")
        } else {
            say("You don't have enough gold!")
        }
    }

    on_death {
        drop_item("merchant_key")
        unlock("secret_shop")
    }
}
```

**Available Events:**
| Entity | Events |
|--------|--------|
| Room | `on_enter`, `on_exit`, `on_first_enter`, `on_clear` |
| Item | `on_pickup`, `on_use`, `on_drop`, `on_destroy` |
| NPC | `on_interact`, `on_death`, `on_spawn`, `on_attack` |
| Door | `on_open`, `on_close`, `on_unlock` |
| Quiz | `on_correct`, `on_wrong`, `on_complete` |

### 6. Global Triggers

Define game-wide conditions that trigger actions.

```dsl
triggers {
    when (keysCollected >= 3) {
        unlock("boss_room")
        show_message("The boss room is now accessible!")
    }

    when (player.health <= 0) {
        game_over("You died!")
    }

    when (room == "exit" && hasItem("artifact")) {
        victory("You escaped with the artifact!")
    }

    when (time_elapsed > 300) {  // 5 minutes
        spawn "time_guardian" in "current_room"
        show_message("You've taken too long... something awakens!")
    }

    // Periodic triggers
    every 60 seconds {
        if (room.has_monsters) {
            spawn random(["skeleton", "zombie"])
        }
    }
}
```
