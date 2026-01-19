# DSL Programming Features Roadmap

This document outlines the planned programming features to elevate the `.esc` DSL from a static configuration language to a dynamic scripting language capable of expressing game logic.

---

## 🔹 Tier 1: Variables & Expressions (Foundation)

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

-   Track player progress
-   Store inventory counts
-   Flag completion states

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

-   Arithmetic: `+`, `-`, `*`, `/`, `%`
-   Comparison: `==`, `!=`, `<`, `>`, `<=`, `>=`
-   Logical: `&&`, `||`, `!`
-   Property access: `player.health`, `room.width`

---

## 🔹 Tier 2: Conditionals & Control Flow

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

### 4.5 Dynamic Monster Spawning (✅ IMPLEMENTED)

Spawn multiple monsters dynamically using loops with the `spawn_monster()` function.

**Implementation Status:** ✅ Fully Implemented (January 2026)

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

-   ✅ **Dynamic spawning**: Monsters are created at runtime, not pre-defined in room
-   ✅ **Loop integration**: Works with both `repeat N` and `repeat i from X to Y` loops
-   ✅ **NPC definitions**: Spawn from any NPC defined in the `npcs` section
-   ✅ **Event handlers**: Dynamically spawned NPCs retain their `on_death` and `on_interact` handlers
-   ✅ **Random positioning**: Monsters spawn at random valid floor tiles in the current room
-   ✅ **Combat ready**: Spawned monsters are fully functional with AI, health, and damage

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

## 🔹 Tier 3: Events & Triggers (Game Logic)

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

---

## 🔹 Tier 4: Functions & Templates (Reusability)

### 7. Functions

Define reusable logic blocks.

```dsl
function spawnEnemyGroup(type, count, baseX, baseY) {
    repeat i from 0 to count - 1 {
        spawn type at (baseX + i * 2, baseY)
    }
}

function healPlayer(amount) {
    player.health = min(player.health + amount, player.maxHealth)
    play_sound("healing")
    show_particles("heal", player.position)
}

function unlockDoorWithKey(doorId, keyItem) {
    if (hasItem(keyItem)) {
        unlock(doorId)
        remove_item(keyItem)
        play_sound("unlock")
        return true
    }
    return false
}

room "arena" {
    on_enter {
        call spawnEnemyGroup("skeleton", 5, 10, 10)
        call spawnEnemyGroup("zombie", 3, 15, 15)
    }
}
```

### 8. Room Templates

Create reusable room patterns with parameters.

```dsl
template corridor(length, hasTraps, enemyType) {
    width: length * 5
    height: 3

    if (hasTraps) {
        repeat i from 0 to length - 1 {
            item "trap" at (i * 5 + 2, 1)
        }
    }

    if (enemyType != null) {
        repeat i from 0 to length / 2 {
            spawn enemyType at (i * 10, 1)
        }
    }
}

template treasure_vault(treasureItem, guardCount) {
    width: 10
    height: 10

    item treasureItem at (5, 5) {
        on_pickup {
            show_message("You found the " + treasureItem + "!")
        }
    }

    repeat guardCount {
        spawn "guardian" at random
    }
}

// Usage
room "north_corridor" from corridor(4, true, "skeleton") {
    connect: "main_hall" -> "treasure_room"
}

room "golden_vault" from treasure_vault("golden_crown", 3) {
    on_clear {
        unlock("exit")
    }
}
```

---

## 🔹 Tier 5: State Machines & Quests

### 9. Quest System

Define multi-stage quests with state transitions.

```dsl
quest "find_the_artifact" {
    states: [not_started, accepted, clue_found, artifact_found, completed]
    initial: not_started

    transition not_started -> accepted {
        when: talked_to("sage")
        action {
            show_message("Quest accepted: Find the Ancient Artifact")
            mark_location("library")
        }
    }

    transition accepted -> clue_found {
        when: hasItem("ancient_map")
        action {
            show_message("The map reveals a hidden passage!")
            reveal_room("secret_passage")
        }
    }

    transition clue_found -> artifact_found {
        when: hasItem("artifact")
        action {
            show_message("You found the artifact! Return to the sage.")
            mark_location("sage_room")
        }
    }

    transition artifact_found -> completed {
        when: talked_to("sage") && hasItem("artifact")
        action {
            remove_item("artifact")
            give_item("reward_gold", 500)
            victory("Quest Complete: The sage thanks you!")
        }
    }
}

quest "side_quest_gems" {
    variables {
        gemsCollected: 0
        totalGems: 5
    }

    on_item_pickup("gem") {
        gemsCollected += 1
        show_message("Gems: ${gemsCollected}/${totalGems}")

        if (gemsCollected >= totalGems) {
            complete()
        }
    }

    on_complete {
        give_item("gem_crown")
        player.maxHealth += 50
    }
}
```

### 10. Room States

Define multiple states for rooms with different behaviors.

```dsl
room "secret_chamber" {
    states: [hidden, revealed, looted]
    initial: hidden

    state hidden {
        visible: false
        on_discover {  // triggered externally
            transition_to: revealed
        }
    }

    state revealed {
        visible: true
        items: ["treasure_chest", "gold_pile", "ancient_scroll"]

        on_enter {
            show_message("You found a secret chamber!")
            play_sound("discovery")
        }

        on_all_items_collected {
            transition_to: looted
        }
    }

    state looted {
        items: []
        on_enter {
            show_message("This chamber has been emptied.")
        }
    }
}

room "boss_arena" {
    states: [waiting, battle, cleared]
    initial: waiting

    state waiting {
        on_enter {
            show_cutscene("boss_intro")
            spawn "dragon_boss" at (10, 10)
            transition_to: battle
        }
    }

    state battle {
        lock_doors: true
        music: "boss_battle.ogg"

        on_enemy_death("dragon_boss") {
            transition_to: cleared
        }
    }

    state cleared {
        lock_doors: false
        music: "victory.ogg"

        on_enter {
            show_message("The dragon has been defeated!")
            spawn_item "dragon_treasure" at (10, 10)
        }
    }
}
```

---

## 🔹 Tier 6: Advanced Features

### 11. Imports/Modules

Split large escape rooms into multiple files.

```dsl
// common/items.esc
export item "health_potion" {
    texture: "potion_red"
    on_use {
        player.health += 50
    }
}

export item "mana_potion" {
    texture: "potion_blue"
    on_use {
        player.mana += 30
    }
}

// common/enemies.esc
export npc "skeleton" {
    type: "monster"
    health: 50
    damage: 10
}

export npc "zombie" {
    type: "monster"
    health: 80
    damage: 15
    speed: 0.5
}

// main.esc
import "common/items.esc"
import "common/enemies.esc" as enemies

room "armory" {
    items: [health_potion, mana_potion]
    npcs: [enemies.skeleton, enemies.zombie]
}
```

### 12. Random & Procedural Generation

Add randomness and procedural elements.

```dsl
room "mystery_chest" {
    item "chest" {
        contains: weighted_random([
            { item: "gold",     weight: 50 },
            { item: "sword",    weight: 30 },
            { item: "artifact", weight: 5 },
            { item: "trap",     weight: 15 }
        ])

        on_open {
            var result = roll()
            show_message("You found: " + result.name)
        }
    }
}

room "procedural_dungeon" {
    layout: procedural {
        algorithm: "maze"
        seed: 12345  // or "random" for true randomness
        size: (10, 10)

        features {
            dead_ends: spawn random(["chest", "trap", "nothing"])
            intersections: 20% chance spawn "enemy"
        }
    }
}

room "random_encounter" {
    on_enter {
        var roll = random(1, 100)

        if (roll <= 10) {
            spawn "rare_merchant"
            show_message("A mysterious merchant appears!")
        } else if (roll <= 40) {
            call spawnEnemyGroup("goblin", random(2, 5), 5, 5)
        } else {
            // Nothing happens
        }
    }
}
```

### 13. String Interpolation

Dynamic text generation.

```dsl
variables {
    playerName: "Hero"
    keysCollected: 0
    maxKeys: 5
}

npc "guide" {
    dialogue: [
        "Welcome, ${playerName}!",
        "You have collected ${keysCollected} of ${maxKeys} keys.",
        "Your current health is ${player.health}/${player.maxHealth}.",
        if (keysCollected == maxKeys) {
            "Congratulations! You can now enter the final chamber."
        } else {
            "Keep searching for more keys!"
        }
    ]
}

room "score_room" {
    on_enter {
        show_message("Time: ${format_time(time_elapsed)}")
        show_message("Score: ${calculate_score()}")
    }
}
```

### 14. Built-in Functions

Standard library of utility functions.

```dsl
// Math functions
min(a, b)
max(a, b)
abs(x)
floor(x)
ceil(x)
round(x)
random(min, max)
sqrt(x)
pow(base, exp)

// String functions
concat(str1, str2)
length(str)
substring(str, start, end)
uppercase(str)
lowercase(str)

// List functions
size(list)
contains(list, item)
add(list, item)
remove(list, item)
get(list, index)
shuffle(list)
first(list)
last(list)

// Game functions
hasItem(itemName)
give_item(itemName, count?)
remove_item(itemName, count?)
spawn(entityType, position?)
spawn_monster(npcId)        // Dynamically spawn a monster from NPC definitions
destroy(entity)
unlock(doorOrRoom)
lock(doorOrRoom)
show_message(text)
play_sound(soundName)
play_music(musicName)
show_cutscene(cutsceneName)
teleport(player, room, position?)
distance(pos1, pos2)
is_room_cleared(roomName)
get_room(roomName)
```

---

## 📊 Implementation Priority Matrix

| Priority | Feature                 | Impact    | Complexity | Dependencies       |
| -------- | ----------------------- | --------- | ---------- | ------------------ |
| 1️⃣       | Variables               | High      | Low        | None               |
| 2️⃣       | Expressions & Math      | High      | Medium     | Variables          |
| 3️⃣       | If/Else Conditions      | Very High | Medium     | Expressions        |
| 4️⃣       | Events (on_enter, etc.) | Very High | Medium     | Variables          |
| 5️⃣       | Global Triggers         | High      | Medium     | Events, Conditions |
| 6️⃣       | String Interpolation    | Medium    | Low        | Variables          |
| 7️⃣       | Loops                   | Medium    | Medium     | Expressions        |
| 8️⃣       | Functions               | Medium    | High       | All above          |
| 9️⃣       | Templates               | Medium    | High       | Functions          |
| 🔟       | State Machines          | Medium    | High       | Events, Triggers   |
| 1️⃣1️⃣     | Quest System            | Medium    | Very High  | State Machines     |
| 1️⃣2️⃣     | Imports                 | Low       | Medium     | None               |
| 1️⃣3️⃣     | Procedural Gen          | Low       | Very High  | Loops, Random      |

---

## 🛠️ Implementation Notes

### Grammar Changes Required

For each feature, the ANTLR grammar (`EscapeRoomDSL.g4`) needs to be extended:

```antlr
// Variables
variables_block: 'variables' LBRACE variable_def* RBRACE;
variable_def: IDENTIFIER COLON expression;

// Expressions
expression: literal
          | IDENTIFIER
          | expression op=(PLUS|MINUS|STAR|SLASH) expression
          | expression op=(EQ|NEQ|LT|GT|LTE|GTE) expression
          | expression op=(AND|OR) expression
          | NOT expression
          | LPAREN expression RPAREN
          | function_call
          | property_access
          ;

// Conditionals
if_expression: 'if' LPAREN expression RPAREN block ('else' (if_expression | block))?;

// Events
event_handler: event_type block;
event_type: 'on_enter' | 'on_exit' | 'on_pickup' | 'on_interact' | ...;

// Loops
loop_statement: 'repeat' (IDENTIFIER 'from' expression 'to' expression)? block;

// Functions
function_def: 'function' IDENTIFIER LPAREN param_list? RPAREN block;
function_call: 'call'? IDENTIFIER LPAREN arg_list? RPAREN;
```

### Runtime Environment

A runtime environment is needed to:

1. Store variable values
2. Evaluate expressions
3. Execute event handlers
4. Manage game state
5. Handle triggers

```java
public class DSLRuntime {
    private Map<String, Object> variables;
    private Map<String, Function> functions;
    private List<Trigger> activeTriggers;
    private EventDispatcher eventDispatcher;

    public Object evaluate(Expression expr) { ... }
    public void execute(Statement stmt) { ... }
    public void fireEvent(GameEvent event) { ... }
}
```

---

## 📝 Example: Complete Dynamic Escape Room

```dsl
metadata {
    title: "The Dynamic Dungeon"
    author: "DSL Master"
    difficulty: "adaptive"  // Scales with player performance
}

variables {
    score: 0
    enemiesKilled: 0
    secretsFound: 0
    startTime: now()
}

triggers {
    when (enemiesKilled >= 10) {
        achievement("Monster Slayer")
        score += 100
    }

    when (secretsFound >= 3) {
        reveal_room("secret_boss")
    }

    when (player.health < 20 && !hasItem("emergency_potion")) {
        give_item("emergency_potion")
        show_message("A mysterious force grants you aid...")
    }
}

function calculateDifficulty() {
    var base = 1.0
    var timeBonus = max(0, (600 - time_elapsed) / 600)  // Bonus for speed
    var healthPenalty = (100 - player.health) / 200     // Harder when hurt
    return base + timeBonus - healthPenalty
}

template enemy_room(baseEnemies, bossChance) {
    var actualEnemies = ceil(baseEnemies * calculateDifficulty())

    repeat actualEnemies {
        spawn random(["skeleton", "zombie"]) at random
    }

    if (random(0, 100) < bossChance) {
        spawn "mini_boss" at center
    }

    on_clear {
        score += actualEnemies * 10
        enemiesKilled += actualEnemies
    }
}

room "entrance" {
    on_first_enter {
        show_cutscene("intro")
        show_message("Welcome, ${player.name}! Your adventure begins...")
    }
}

room "combat_arena" from enemy_room(5, 20) {
    on_enter {
        if (is_first_visit()) {
            lock_doors: true
        }
    }

    on_clear {
        unlock_doors: true
        spawn_item "reward_chest" at center
    }
}

room "puzzle_room" {
    var correctSequence: ["red", "blue", "green"]
    var playerSequence: []

    item "red_button" {
        on_interact {
            add(playerSequence, "red")
            check_sequence()
        }
    }

    // ... blue and green buttons ...

    function check_sequence() {
        if (playerSequence == correctSequence) {
            show_message("Correct!")
            unlock("treasure_room")
            score += 50
        } else if (size(playerSequence) >= 3) {
            show_message("Wrong sequence! Try again.")
            playerSequence = []
            player.health -= 10
        }
    }
}

room "exit" {
    on_enter {
        var finalTime = time_elapsed
        var timeBonus = max(0, (600 - finalTime) * 2)
        var finalScore = score + timeBonus + (player.health * 5)

        show_message("Congratulations!")
        show_message("Final Score: ${finalScore}")
        show_message("Time: ${format_time(finalTime)}")
        show_message("Secrets Found: ${secretsFound}/5")

        victory("Escape Complete!")
    }
}
```

---

## 🚀 Next Steps

1. **Phase 1**: Implement Variables + Expressions
2. **Phase 2**: Add Conditionals + Basic Events
3. **Phase 3**: Implement Triggers + Loops
4. **Phase 4**: Add Functions + Templates
5. **Phase 5**: State Machines + Quests
6. **Phase 6**: Advanced features (imports, procedural)

Each phase should include:

-   Grammar updates
-   Visitor implementation
-   Runtime support
-   Validation rules
-   Documentation
-   Example files
-   Unit tests
