# Combat System Guide

## Overview

The escape room DSL now supports hostile mobs with full combat capabilities. Both the player and hostile NPCs can attack, take damage, and die.

## Player Combat

### Hero Class: Wizard (Default)

-   **Health**: 15 HP
-   **Starting Skills**:
    -   **Fireball** (Primary Attack): Press `Q` or `Left Mouse Click` to shoot a fireball at your cursor position
        -   Costs: 30 mana
        -   Damage: Variable based on fireball skill
    -   **Self Heal**: Press assigned key to heal yourself
        -   Costs: 80 mana
        -   Heals: 5 HP over time

### Controls

-   **Q Key**: Cast Fireball (primary attack skill)
-   **Left Mouse Click**: Also casts active skill (fireball)
-   **WASD/Arrow Keys**: Move the hero
-   **E Key**: Interact with objects/NPCs

### Resources

-   **Mana**: 100 starting, regenerates at 10/sec
-   **Health**: 15 HP

## Hostile Mobs

### DSL Configuration

Define hostile NPCs with combat properties:

```
npc skeleton_warrior {
    texture: "character/monster/skeleton"
    hostile: true
    health: 15
    damage: 2
    location: treasure_room
}

npc goblin {
    texture: "character/monster/goblin"
    hostile: true
    health: 10
    damage: 1
    location: secret_chamber
}
```

### Properties

-   **hostile: true/false** - Determines if the NPC will attack the player
-   **health: INT** - Hit points (default: 10)
-   **damage: INT** - Damage dealt on collision/attack (default: 1)
-   **texture: "path"** - Sprite path for the mob

### AI Behavior

Hostile mobs use randomized AI from the framework:

**Fight AI** (when player is near):

-   **Chase Behavior**: Runs directly at the player for melee attacks
-   **Melee Behavior**: Uses close-range attack skills
-   **Range Behavior**: Shoots projectiles at the player

**Idle AI** (when no target):

-   **Patrol Walk**: Walks along a patrol path
-   **Radius Walk**: Wanders within a certain radius
-   **Static Walk**: Stays mostly in one area

**Transitions**: Automatically switches between fight and idle based on player proximity

## Combat Mechanics

### Damage System

1. **Player → Mob**:

    - Fireball hits mob → mob's HealthComponent takes damage
    - Mob dies when health reaches 0

2. **Mob → Player**:
    - Mob collision → player's HealthComponent takes damage (from `collideDamage`)
    - Mob projectile hits → player takes projectile damage
    - Player dies when health reaches 0

### Death

-   Both player and mobs can die when health reaches 0
-   Death callbacks can trigger game over screens, respawns, etc.

## Implementation Details

### Code Structure

-   **DSL Grammar**: `EscapeRoomDSL.g4` - Defines hostile/health/damage syntax
-   **NPC Definition**: `EscapeRoomDefinition.java` - Data class with combat fields
-   **Interpreter**: `EscapeRoomInterpreter.java` - Parses combat properties from DSL
-   **Entity Spawner**: `DSLEntitySpawner.java` - Creates hostile mobs with MonsterBuilder
-   **Hero Factory**: `HeroFactory.java` - Creates player with combat skills
-   **Monster Builder**: `MonsterBuilder.java` - Framework builder for combat entities

### MonsterBuilder Configuration

When spawning hostile mobs, the system configures:

```java
npcEntity = new MonsterBuilder<>()
    .name(npcId)
    .texturePath(npcDef.texture)           // Texture path for rendering
    .health(health)                         // Max health
    .collideDamage(damage)                  // Collision damage
    .fightAI(() -> AIFactory.randomFightAI())     // Combat behavior
    .idleAI(() -> AIFactory.randomIdleAI())       // Patrol behavior
    .transitionAI(() -> AIFactory.randomTransition(null))  // State switching
    .build(position);
```

## Testing

### Demo Room

The `demo_room.esc` file includes:

-   **guardian**: Friendly NPC (hostile: false) with dialogue
-   **skeleton_warrior**: Hostile mob with 15 HP, 2 damage in treasure room
-   **goblin**: Hostile mob with 10 HP, 1 damage in secret chamber

### What to Test

1. ✅ Mobs render with correct textures (not pink boxes)
2. ✅ Mobs have AI behavior (chase player when nearby, patrol when idle)
3. ✅ Player can attack mobs with Q key or mouse click (fireball)
4. ✅ Mobs can damage player through collision/attacks
5. ✅ Both player and mobs can die (health reaches 0)
6. ✅ Friendly NPCs (hostile: false) don't attack

## Troubleshooting

### Pink Box Mobs

**Problem**: Mobs appear as magenta/pink boxes instead of textures
**Cause**: Missing texture path in MonsterBuilder
**Solution**: Fixed - texturePath() now properly configured

### Mobs Not Attacking

**Problem**: Mobs don't chase or attack the player
**Cause**: Missing AI configuration in MonsterBuilder
**Solution**: Fixed - fightAI(), idleAI(), transitionAI() now properly configured

### Player Can't Attack

**Problem**: Player pressing Q doesn't cast fireball
**Cause**: May need to aim at valid target or have enough mana
**Solution**:

-   Ensure mana is available (starts with 100, costs 30 per fireball)
-   Aim cursor at target location
-   Make sure Q key is properly bound in KeyboardConfig

## Future Enhancements

-   Add more attack skills (melee sword, bow, different spells)
-   Add boss NPCs with special behaviors
-   Add difficulty levels (easy/normal/hard mobs)
-   Add loot drops from defeated mobs
-   Add status effects (poison, slow, stun)
-   Add mob spawners for waves of enemies
