# Escape Room DSL - Kompakte Präsentation

**Domain Specific Language für Educational Escape Rooms**

Version 1.2 | Januar 2026 | 15-Minuten Präsentation

---

## Folie 1: Escape Room DSL

### Eine programmierbare Sprache für Lern-Escape-Rooms

**Projekt:** Lispy-Dungeon  
**Version:** 1.2 (Januar 2026)  
**Entwickelt für:** PRODUS & L<ESC>ROD Projekte

**Kernidee:**  
Lehrkräfte erstellen interaktive Escape Rooms **ohne Java-Programmierung** - mit einer einfachen, aber **mächtigen DSL** mit echten Programmiersprachen-Features.

---

## Folie 2: Problem & Lösung

### ❌ Problem

-   Traditionelle Spielentwicklung erfordert **Java-Programmierung**
-   Lehrkräfte können keine dynamischen Inhalte erstellen
-   Zeitaufwändig und fehleranfällig

### ✅ Lösung: Escape Room DSL

```
.esc Datei (YAML-ähnlich)
    ↓
ANTLR Parser → AST → DSLRuntime
    ↓
Spielbares Level mit Programmlogik
```

**Features:**

-   🔄 **Variables** - Spielzustand tracken
-   🔀 **Conditionals** - If/Else Logik
-   🔄 **Loops** - Wiederholungen
-   ⚡ **Event Handlers** - Reaktives Programming
-   🛠️ **Built-in Functions** - Spielaktionen

---

## Folie 3: Game Features Überblick

### 🎮 Was kann man bauen?

**Level Design:**

-   Multi-Room Layouts mit automatischen Korridoren
-   Custom ASCII Room Patterns (L-Formen, Labyrinthe)
-   Locked Doors mit Schlüsselsystem

**Gameplay:**

-   ⚔️ Combat System (Hostile NPCs, Player Skills)
-   🧩 Quiz & Belohnungen (Single/Multiple Choice)
-   🎒 Items & Inventory
-   👤 Charakterklassen (Wizard, Hunter)

**Advanced:**

-   🌫️ Fog of War
-   📷 Camera Controls
-   🎯 Dynamisches Monster-Spawning

**→ Alles steuerbar durch DSL-Code!**

---

## Folie 4: Programmiersprachen-Features

### 📝 **Variables** - Spielzustand speichern

```dsl
variables:
    score: 0
    keysCollected: 0
    talkedToMerchant: false
    bonusThreshold: 100 * 5    # Expressions!
```

### 🔀 **Conditionals** - Bedingte Logik

```dsl
if (keysCollected == 3) {
    show_message("Alle Schlüssel gefunden!")
    unlock("treasure_door")
} else {
    show_message("Noch " + (3 - keysCollected) + " Schlüssel nötig")
}
```

### 🔄 **Loops** - Wiederholungen

```dsl
repeat 5 {
    spawn_monster("goblin")
}

repeat i from 1 to 10 {
    spawn_monster("zombie")
    print("Wave", i)
}
```

### ⚡ **Event Handlers** - Reaktives Programming

```dsl
rooms:
    arena:
        on_first_enter { ... }
        on_clear { ... }

npcs:
    boss:
        on_death { victory("Gewonnen!") }
```

---

## Folie 5: Variables - Syntax & Beispiel

### 📝 **Definition & Verwendung**

```dsl
escape_room:
    variables:
        # Verschiedene Typen
        score: 0                    # Integer
        playerName: "Hero"          # String
        doorUnlocked: false         # Boolean

        # Berechnete Werte
        requiredKeys: 3
        bonusThreshold: 100 * 5     # = 500
        treasureValue: 50 * 10      # = 500

    rooms:
        entrance:
            on_enter {
                # Variablen lesen
                if (score > bonusThreshold) {
                    show_message("Bonus erreicht!")
                }

                # Variablen schreiben
                score += 100
                keysCollected -= 1
                doorUnlocked = true
            }
```

### 🧮 **Operatoren**

```dsl
score += 100        # Addition
score -= 50         # Subtraktion
reward = base * 2   # Multiplikation
half = total / 2    # Division
```

---

## Folie 6: Conditionals - Syntax & Beispiel

### 🔀 **If/Else Chains**

```dsl
rooms:
    entrance:
        on_enter {
            # Einfaches If
            if (keysCollected == 0) {
                show_message("Finde Schlüssel!")
            }

            # If-Else
            if (score > 500) {
                show_message("Hervorragend!")
            } else {
                show_message("Weiter so!")
            }

            # If-Else-If
            if (keysCollected == 0) {
                show_message("Keine Schlüssel")
            } else if (keysCollected < 3) {
                show_message("Schlüssel: " + keysCollected + "/3")
            } else {
                show_message("Alle Schlüssel!")
                unlock("treasure_door")
            }
        }
```

### ⚖️ **Vergleichsoperatoren**

```dsl
==  !=  <  >  <=  >=  &&  ||
```

---

## Folie 7: Loops - Syntax & Beispiel

### 🔄 **Zwei Loop-Typen**

```dsl
# Einfache Wiederholung
rooms:
    arena:
        on_first_enter {
            repeat 5 {
                spawn_monster("goblin")
            }
            show_message("5 Goblins spawned!")
        }
```

```dsl
# Loop mit Zähler-Variable
rooms:
    horde_chamber:
        on_first_enter {
            repeat i from 1 to 10 {
                spawn_monster("zombie")
                print("Spawning zombie", i, "of 10")
            }
            score += 50
        }
```

### 🎯 **Mit Expressions**

```dsl
variables:
    waveSize: 3
    difficultyMultiplier: 2

rooms:
    boss_arena:
        on_first_enter {
            # Dynamische Anzahl!
            repeat i from 1 to (waveSize * difficultyMultiplier) {
                spawn_monster("skeleton_warrior")
            }
            # Spawnt 3 * 2 = 6 Skelette
        }
```

---

## Folie 8: Event Handlers - Syntax & Beispiel

### ⚡ **Room Events**

```dsl
rooms:
    treasure_vault:
        on_enter {
            # JEDES MAL beim Betreten
            roomsVisited += 1
            show_message("Willkommen!")
        }

        on_first_enter {
            # NUR beim ERSTEN MAL
            score += 500
            give_item("treasure_map")
        }

        on_clear {
            # ALLE GEGNER besiegt
            unlock("secret_passage")
            score += 200
        }
```

### ⚔️ **NPC Events**

```dsl
npcs:
    dragon_boss:
        hostile: true
        health: 500
        damage: 50

        on_death {
            show_message("Drache besiegt!")
            score += 1000
            give_item("dragon_treasure")
            victory("Boss defeated!")
        }

    merchant:
        hostile: false

        on_interact {
            talkedToMerchant = true
            show_message("Willkommen!")
            score += 10
        }
```

---

## Folie 9: Built-in Functions

### 🛠️ **Verfügbare Funktionen**

**Spieler-Aktionen:**

```dsl
show_message("Text")           # Nachricht anzeigen
give_item("key")               # Item geben
unlock("door")                 # Tür öffnen
victory("You won!")            # Spiel gewinnen
```

**Monster & Entities:**

```dsl
spawn_monster("goblin")        # Monster spawnen
spawn("entity", x, y)          # Entity an Position
```

**Utility:**

```dsl
print("Debug:", score)         # Konsolen-Output
random(1, 10)                  # Zufallszahl
min(a, b)                      # Minimum
max(a, b)                      # Maximum
```

### 📊 **Beispiel: Arena System**

```dsl
variables:
    wave: 0
    enemiesInWave: 3

rooms:
    arena:
        on_first_enter {
            wave = 1
            repeat enemiesInWave {
                spawn_monster("goblin")
            }
            show_message("Welle 1!")
        }

        on_clear {
            wave += 1
            if (wave == 2) {
                enemiesInWave = 5
                repeat enemiesInWave {
                    spawn_monster("skeleton")
                }
            } else if (wave > 2) {
                victory("Arena gemeistert!")
            }
        }
```

---

## Folie 10: Implementierung - Parsing & Runtime

### 🔧 **Architektur**

```
┌─────────────────────────────────┐
│   .esc Datei (DSL Code)        │
└──────────────┬──────────────────┘
               │
               ▼
┌─────────────────────────────────┐
│   ANTLR Parser                  │
│   - Liest Grammar               │
│   - Erstellt Parse Tree         │
└──────────────┬──────────────────┘
               │
               ▼
┌─────────────────────────────────┐
│   Visitor Pattern               │
│   - ExpressionVisitor           │
│   - StatementVisitor            │
│   - EscapeRoomVisitor           │
└──────────────┬──────────────────┘
               │
               ▼
┌─────────────────────────────────┐
│   AST (Abstract Syntax Tree)    │
│   - Expression Nodes            │
│   - Statement Nodes             │
│   - EventHandler Nodes          │
└──────────────┬──────────────────┘
               │
               ▼
┌─────────────────────────────────┐
│   DSLRuntime                    │
│   - Variable Scopes (Stack)     │
│   - Built-in Functions          │
│   - Event Handlers              │
│   - GameBridge Interface        │
└─────────────────────────────────┘
```

### 🌳 **AST Interfaces**

```java
// Expression - wird ausgewertet zu einem Wert
interface Expression {
    Object evaluate(DSLRuntime runtime);
}

// Statement - wird ausgeführt, verändert State
interface Statement {
    void execute(DSLRuntime runtime);
}
```

---

## Folie 11: Implementierung - Variable Scopes

### 🗂️ **Scope Stack Implementation**

```java
public class DSLRuntime {
    // Stack von Scopes (Maps)
    private final Deque<Map<String, Object>> scopes;

    public DSLRuntime() {
        this.scopes = new ArrayDeque<>();
        this.scopes.push(new HashMap<>()); // Global scope
    }

    /** Suche Variable von innen nach außen */
    public Object getVariable(String name) {
        for (Map<String, Object> scope : scopes) {
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }

        // Special runtime variables
        if (gameBridge != null) {
            switch (name) {
                case "player": return new PlayerProxy(this);
                case "room": return gameBridge.getCurrentRoom();
            }
        }

        LOGGER.warning("Undefined variable: " + name);
        return null;
    }

    /** Setze Variable in existierendem Scope */
    public void setVariable(String name, Object value) {
        for (Map<String, Object> scope : scopes) {
            if (scope.containsKey(name)) {
                scope.put(name, value);
                return;
            }
        }
        // Neu im aktuellen Scope
        scopes.peek().put(name, value);
    }

    public void pushScope() { scopes.push(new HashMap<>()); }
    public void popScope() { if (scopes.size() > 1) scopes.pop(); }
}
```

### 📍 **Beispiel: Scope Resolution**

```
Global Scope: { score: 100, keysCollected: 2 }
    ↓
Loop Scope: { i: 3 }
    ↓
getVariable("i")             → 3 (findet in Loop Scope)
getVariable("score")         → 100 (findet in Global Scope)
getVariable("undefined")     → null + Warning
```

---

## Folie 12: Implementierung - Expression Evaluation

### 🧮 **BinaryOperation Evaluator**

```java
public class BinaryOperation implements Expression {
    private Expression left;
    private String operator;
    private Expression right;

    @Override
    public Object evaluate(DSLRuntime runtime) {
        Object leftVal = left.evaluate(runtime);
        Object rightVal = right.evaluate(runtime);

        switch (operator) {
            case "+":
                if (leftVal instanceof Number && rightVal instanceof Number) {
                    return ((Number) leftVal).doubleValue() +
                           ((Number) rightVal).doubleValue();
                }
                // String concatenation
                return leftVal.toString() + rightVal.toString();

            case "-":
                return ((Number) leftVal).doubleValue() -
                       ((Number) rightVal).doubleValue();

            case "*":
                return ((Number) leftVal).doubleValue() *
                       ((Number) rightVal).doubleValue();

            case "==":
                return Objects.equals(leftVal, rightVal);

            case ">":
                return ((Number) leftVal).doubleValue() >
                       ((Number) rightVal).doubleValue();

            case "&&":
                return toBoolean(leftVal) && toBoolean(rightVal);

            // ... weitere Operatoren
        }
    }
}
```

### 📊 **Expression Types**

| AST Node            | DSL Code      | evaluate() Returns    |
| ------------------- | ------------- | --------------------- |
| `IntLiteral`        | `42`          | `42` (Integer)        |
| `StringLiteral`     | `"Hi"`        | `"Hi"` (String)       |
| `VariableReference` | `score`       | Value aus Scope       |
| `BinaryOperation`   | `score + 100` | Berechnetes Ergebnis  |
| `FunctionCall`      | `min(a, b)`   | Function Return Value |

---

## Folie 13: Implementierung - Event System

### ⚡ **Event Handler Registration & Firing**

```java
public class DSLRuntime {
    // Map<EventType, Map<EntityID, List<Handler>>>
    private final Map<EventType, Map<String, List<EventHandler>>> eventHandlers;
    private final Set<String> visitedRooms;  // Für on_first_enter

    /** Event Handler registrieren */
    public void registerEventHandler(EventHandler handler) {
        eventHandlers
            .computeIfAbsent(handler.getEventType(), k -> new HashMap<>())
            .computeIfAbsent(handler.getAttachedToId(), k -> new ArrayList<>())
            .add(handler);
    }

    /** Event feuern */
    public void fireEvent(EventType eventType, String entityId) {
        // on_first_enter Spezialfall
        if (eventType == EventType.ON_ENTER) {
            if (!visitedRooms.contains(entityId)) {
                visitedRooms.add(entityId);
                fireEvent(EventType.ON_FIRST_ENTER, entityId);
            }
        }

        // Alle registrierten Handlers ausführen
        Map<String, List<EventHandler>> handlersForType =
            eventHandlers.get(eventType);
        if (handlersForType != null) {
            List<EventHandler> handlers = handlersForType.get(entityId);
            if (handlers != null) {
                for (EventHandler handler : handlers) {
                    try {
                        handler.execute(this);
                    } catch (Exception e) {
                        LOGGER.severe("Error executing handler: " + e);
                    }
                }
            }
        }

        checkTriggers();  // Global triggers prüfen
    }
}
```

### 📋 **EventType Enum**

```java
public enum EventType {
    ON_ENTER, ON_FIRST_ENTER, ON_EXIT, ON_CLEAR,
    ON_DEATH, ON_INTERACT, ON_PICKUP,
    ON_CORRECT, ON_WRONG
}
```

---

## Folie 14: Implementierung - Built-in Functions & GameBridge

### 🛠️ **Function Registry**

```java
public class DSLRuntime {
    private Map<String, BuiltinFunction> builtinFunctions;

    @FunctionalInterface
    public interface BuiltinFunction {
        Object call(List<Object> args);
    }

    private void registerBuiltinFunctions() {
        // show_message(text)
        builtinFunctions.put("show_message", args -> {
            checkArgs("show_message", args, 1);
            if (gameBridge != null) {
                gameBridge.showMessage(args.get(0).toString());
            }
            return null;
        });

        // spawn_monster(npcId)
        builtinFunctions.put("spawn_monster", args -> {
            checkArgs("spawn_monster", args, 1);
            if (gameBridge != null) {
                gameBridge.spawnMonster(args.get(0).toString());
            }
            return null;
        });

        // give_item(itemName)
        builtinFunctions.put("give_item", args -> {
            checkArgs("give_item", args, 1);
            if (gameBridge != null) {
                gameBridge.giveItem(args.get(0).toString());
            }
            return null;
        });

        // print(...) - Debugging
        builtinFunctions.put("print", args -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < args.size(); i++) {
                if (i > 0) sb.append(" ");
                sb.append(args.get(i));
            }
            LOGGER.info("[DSL PRINT] " + sb);
            return null;
        });

        // Math: min, max, random, ...
        // String: concat, uppercase, lowercase, ...
        // Game: unlock, victory, hasItem, ...
    }
}
```

### 🔗 **GameBridge Interface** - Trennung DSL ↔ Game

```java
public interface GameBridge {
    // UI
    void showMessage(String message);
    void playSound(String soundName);

    // Spawning
    void spawnMonster(String npcId);
    void spawnEntity(String type, float x, float y);

    // Items
    void giveItem(String itemName);
    boolean hasItem(String itemName);

    // Doors/Rooms
    void unlockDoor(String doorId);
    String getCurrentRoom();

    // Game State
    void victory(String message);
    void gameOver(String message);

    // Player
    int getPlayerHealth();
    void setPlayerHealth(int health);
}
```

**→ DSL-Code bleibt unabhängig von Game Engine!**

---

## Folie 15: Zusammenfassung & Ausblick

### 🎯 **Was haben wir gezeigt?**

**DSL Programmiersprachen-Features:**

1. ✅ **Variables** - Spielzustand mit Scopes
2. ✅ **Conditionals** - If/Else Logik
3. ✅ **Loops** - repeat & repeat i from X to Y
4. ✅ **Event Handlers** - Reaktives Programming
5. ✅ **Built-in Functions** - Über 20 Funktionen

**Implementierung:**

1. ✅ **ANTLR Parser** → Visitor → AST
2. ✅ **DSLRuntime** mit Scope Stack
3. ✅ **Expression Evaluation** mit Type Coercion
4. ✅ **Event System** mit on_first_enter Tracking
5. ✅ **GameBridge** für Engine-Unabhängigkeit

### ✨ **Key Takeaways**

-   **Echte Programmierung** - Nicht nur Konfiguration
-   **Event-Driven** - Reaktiv auf Spieler-Aktionen
-   **Sauber getrennt** - DSL Logic ↔ Game Engine
-   **Lernfreundlich** - Sanfter Einstieg in Programming
-   **Mächtig** - Arena-Systeme, Quests, Puzzles möglich

### 🚀 **Nächste Schritte**

-   Eigenes Escape Room erstellen
-   `complete_showcase.esc` studieren
-   Dokumentation: `ESCAPE_ROOM_DSL_DOCUMENTATION.md`

### 📧 **Kontakt**

-   GitHub: Dungeon-CampusMinden/Dungeon
-   PRODUS & L<ESC>ROD Projekte

**Vielen Dank!**
