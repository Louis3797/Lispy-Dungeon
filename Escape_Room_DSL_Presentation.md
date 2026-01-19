# Escape Room DSL Präsentation

## Domain Specific Language für Educational Escape Rooms

**Version 1.1 | 20-Minuten Präsentation**

---

## Folie 1: Titelfolie

**Escape Room DSL**  
_Eine benutzerfreundliche Sprache zur Erstellung von Lern-Escape-Rooms_

-   Projekt: Lispy-Dungeon
-   Version: 1.1 (Oktober 2025)
-   Entwickelt für: PRODUS & L<ESC>ROD Projekte

---

## Folie 2: Agenda

1. 🎯 **Überblick & Motivation**
2. 🏗️ **DSL Grundlagen**
3. 🎮 **Kernfeatures**
4. 💻 **Syntax & Beispiele**
5. 🚀 **Live Demo**
6. 📊 **Use Cases & Ausblick**

---

## Folie 3: Was ist die Escape Room DSL?

### Problem

-   Traditionelle Spielentwicklung erfordert **Java-Programmierung**
-   Lehrkräfte ohne Programmierkenntnisse können keine Inhalte erstellen
-   Zeitaufwändig und fehleranfällig

### Lösung: Escape Room DSL

-   **Domain Specific Language** (DSL) für Escape Room Erstellung
-   **YAML-ähnliche Syntax** - menschenlesbar, einfach zu schreiben
-   **Programmiersprachen-Features**: Variablen, Bedingungen, Logik
-   **Kein Java-Code erforderlich** - Low-Code Ansatz
-   **Sofort spielbar** - Automatische Generierung von Levels

---

## Folie 4: Projektkontext

### PRODUS Projekt (2024-2026)

-   Programming Dungeon Adventures at School
-   Workshops für Schüler:innen (Blockly, Java, Advanced)
-   Förderung von MINT-Fächern

### L<ESC>ROD Projekt (2025-2027)

-   Lehr-Escape-Rooms mit LowCode
-   **Multiplayer-Funktionalität** (geplant)
-   Didaktische Escape Rooms für Studierende
-   **Low-Code für Lehrende ohne Programmiererfahrung**

---

## Folie 5: DSL Architektur

```
┌─────────────────────────────────┐
│   .esc Datei (DSL Code)        │
│   - Menschenlesbar              │
│   - YAML-ähnliche Syntax        │
└──────────────┬──────────────────┘
               │
               ▼
┌─────────────────────────────────┐
│   ANTLR Parser                  │
│   - Grammatik: EscapeRoomDSL.g4 │
│   - Syntax Validation           │
└──────────────┬──────────────────┘
               │
               ▼
┌─────────────────────────────────┐
│   Java Code Generator           │
│   - Erstellt Dungeon-Entities   │
│   - Generiert Level-Logik       │
└──────────────┬──────────────────┘
               │
               ▼
┌─────────────────────────────────┐
│   Spielbares Level              │
│   - Lauffähig im Framework      │
└─────────────────────────────────┘
```

---

## Folie 6: Programmiersprachen-Features ✅ IMPLEMENTIERT

### 📝 **Variables** - Spielzustand speichern

-   Zahlen, Strings, Booleans tracken
-   `score`, `keysCollected`, `talkedToNPC`
-   Mathematische Ausdrücke: `score += 50 * 2`

### 🔄 **Loops** - Wiederholungen

-   `repeat 5 { ... }` - Einfache Wiederholung
-   `repeat i from 1 to 10 { ... }` - Mit Zähler
-   Dynamisches Monster-Spawning

### ⚡ **Event Handlers** - Auf Spieler reagieren

-   `on_enter` - Raum betreten
-   `on_first_enter` - Nur beim ersten Mal
-   `on_clear` - Alle Gegner besiegt
-   `on_death` - NPC stirbt
-   `on_interact` - Mit NPC sprechen

### 🔀 **Conditionals** - Bedingungen

-   `if (score > 100) { ... }`
-   `else if (keysCollected == 3) { ... }`
-   `else { ... }`
-   Vergleiche: `==`, `!=`, `<`, `>`, `<=`, `>=`

### 🛠️ **Built-in Functions** - Spielaktionen

-   `show_message("Text")` - Nachricht anzeigen
-   `spawn_monster("goblin")` - Monster spawnen
-   `give_item("key")` - Item geben
-   `unlock("door")` - Tür öffnen
-   `victory("You won!")` - Spiel gewinnen
-   `print("Debug")` - Konsolen-Output

---

## Folie 7: Kernfeatures (1/3) - Level Design

### 🏗️ **Multi-Room Layouts**

-   Beliebig viele Räume
-   Automatische Positionierung auf Grid
-   **Rechteckige Räume**: Einfache width/height Angabe
-   **Custom ASCII Patterns**: L-Formen, Kreise, T-Formen, Labyrinthe

### 🚪 **Intelligente Türen & Korridore**

-   Automatische 3-Tile-breite Korridore zwischen verbundenen Räumen
-   Türen mit Schlüsselsystem
-   Visuelle Tür-Feedback
-   Wände um Türen automatisch generiert

### 🗺️ **Dynamische Level-Generierung**

-   ASCII-Konsolen-Karte für Debugging
-   Automatische Kollisionserkennung

---

## Folie 8: Kernfeatures (2/3) - Gameplay Systeme

### ⚔️ **Vollständiges Kampfsystem**

-   **Hostile Mobs** mit Health, Damage & AI
-   **Player Combat**: Skills (Fireball, Bow)
-   **AI-Verhalten**: Fight AI, Idle AI, Transition AI
-   **Ressourcen-Management**: Mana & Stamina Regeneration

### 👤 **Charakterklassen**

-   **Wizard**: 15 HP, 100 Mana, Fireball/Heal Skills
-   **Hunter**: 35 HP, 120 Stamina, Bow/Dash Skills
-   **Custom Stats**: Health, Mana, Stamina, Speed überschreibbar

### 🧩 **Quiz & Belohnungssystem**

-   Single-Choice & Multiple-Choice
-   Freitext-Eingaben
-   Item-Belohnungen bei Erfolg
-   Anhängen an Chests, NPCs oder standalone

---

## Folie 9: Kernfeatures (3/3) - Advanced Features

### 🌫️ **Fog of War System** _(NEU in v1.1)_

-   Begrenzte Sichtweite für mehr Spannung
-   Global konfigurierbar oder pro Raum
-   Einstellbare View Distance

### 📷 **Camera & Zoom Controls** _(NEU in v1.1)_

-   Globale Zoom-Einstellungen (0.5 - 2.0)
-   Raum-spezifische Kamera-Einstellungen
-   Camera Focus auf Hero oder Entities

### 🎒 **Items & Inventory**

-   Schlüssel, Scrolls, Lesbare Objekte
-   Unbegrenztes Inventar
-   Interaktive Items aufsammeln/ablegen
-   Smart Spawning bei Quiz-Belohnungen

---

## Folie 10: DSL Syntax - Grundstruktur

```dsl
escape_room:
    metadata:        # Spiel-Informationen (ERFORDERLICH)
    rooms:           # Räume (ERFORDERLICH - mind. 1)
    items:           # Sammelbare Objekte (OPTIONAL)
    quizzes:         # Interaktive Rätsel (OPTIONAL)
    npcs:            # NPCs (OPTIONAL)
    player:          # Spieler-Konfiguration (OPTIONAL)
```

### Syntax-Regeln (Programmiersprachen-ähnlich)

-   **2-Space Indentation** (wie Python/YAML)
-   **Kommentare**: `# Dies ist ein Kommentar` (wie Python)
-   **Strings**: `"Text"` oder `'Text'` (wie JavaScript/Python)
-   **Arrays**: `[item1, item2, item3]` (wie JSON)
-   **IDs**: Alphanumerisch + Unterstrich (wie Variablennamen)
-   **Key-Value Pairs**: `key: value` (wie YAML/JSON)
-   **Nested Objects**: Durch Indentation (wie Python)

---

## Folie 11: Code-Beispiel - Variables & Expressions

### 📝 **Variables definieren**

```dsl
escape_room:
    variables:
        # Zahlen
        score: 0
        keysCollected: 0
        enemiesDefeated: 0

        # Booleans
        talkedToMerchant: false
        doorUnlocked: false

        # Strings
        playerName: "Hero"

        # Berechnete Werte (Expressions!)
        requiredKeys: 3
        bonusThreshold: 100 * 5        # = 500
        treasureValue: 50 * 10         # = 500
        maxScore: 1000 + 500           # = 1500
```

### 🧮 **Mathematische Operationen**

```dsl
# Addition, Subtraktion, Multiplikation, Division
score += 100                    # score = score + 100
keysCollected -= 1              # Schlüssel verbraucht
reward = baseValue * 2          # Doppelter Wert

# String-Verkettung
show_message("Score: " + score)          # "Score: 250"
show_message("Keys: " + keysCollected)   # "Keys: 3"
```

---

## Folie 12: Code-Beispiel - Conditionals (If/Else)

### 🔀 **Bedingte Logik**

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
                show_message("Fantastisch! Score: " + score)
            } else {
                show_message("Weiter so! Score: " + score)
            }

            # If-Else-If Chain
            if (keysCollected == 0) {
                show_message("Keine Schlüssel gefunden")
            } else if (keysCollected < 3) {
                show_message("Schlüssel: " + keysCollected + "/3")
            } else {
                show_message("Alle Schlüssel! Geh zum Schatz!")
                unlock("treasure_door")
            }
        }
```

### ⚖️ **Vergleichsoperatoren**

```dsl
# Gleichheit
if (keysCollected == 3) { ... }
if (talkedToNPC != true) { ... }

# Größer/Kleiner
if (score > 1000) { victory("Gewonnen!") }
if (health < 20) { show_message("Achtung! Wenig Leben!") }
if (enemiesDefeated >= 10) { give_item("bonus_sword") }
```

---

## Folie 13: Code-Beispiel - Loops

### 🔄 **Einfache Wiederholung**

```dsl
rooms:
    arena:
        on_first_enter {
            # Spawn 5 Goblins
            repeat 5 {
                spawn_monster("goblin")
            }

            show_message("5 Goblins erscheinen!")
        }
```

### 🔢 **Loop mit Zähler**

```dsl
rooms:
    zombie_horde:
        on_first_enter {
            show_message("Zombie-Horde nähert sich!")

            # Spawne 10 Zombies mit Feedback
            repeat i from 1 to 10 {
                spawn_monster("zombie")
                print("Spawning zombie ", i, " of 10")
            }

            show_message("10 Zombies spawned!")
            score += 50
        }
```

### 🎯 **Loops mit Variablen**

```dsl
variables:
    waveSize: 3
    difficultyMultiplier: 2

rooms:
    boss_arena:
        on_first_enter {
            # Dynamische Anzahl mit Range-Loop
            repeat i from 1 to (waveSize * difficultyMultiplier) {
               spawn_monster("skeleton_warrior")
            }
            # Spawnt 3 * 2 = 6 Skelette!
        }
```

---

## Folie 14: Code-Beispiel - Event Handlers

### 🚪 **Room Events**

```dsl
rooms:
    treasure_vault:
        on_enter {
            # Läuft JEDES MAL beim Betreten
            roomsVisited += 1
            show_message("Willkommen im Schatzraum!")
        }

        on_first_enter {
            # Läuft NUR beim ERSTEN MAL
            show_message("Erster Besuch - Bonus +500!")
            score += 500
            give_item("treasure_map")
        }

        on_clear {
            # Läuft wenn ALLE GEGNER besiegt
            show_message("Raum gesäubert!")
            unlock("secret_passage")
            score += 200
        }
```

### ⚔️ **NPC Events**

```dsl
npcs:
    boss_dragon:
        description: "Ein mächtiger Drache"
        hostile: true
        health: 500
        damage: 50

        on_death {
            # Wenn Boss stirbt
            show_message("Der Drache wurde besiegt!")
            score += 1000
            give_item("dragon_treasure")
            unlock("exit_portal")
            victory("Boss besiegt!")
        }

    merchant:
        description: "Ein freundlicher Händler"
        hostile: false

        on_interact {
            # Wenn Spieler E-Taste drückt
            talkedToMerchant = true
            show_message("Willkommen! Möchtest du handeln?")
            score += 10
        }
```

---

## Folie 15: Code-Beispiel - Built-in Functions

### 🛠️ **Spieler-Aktionen**

```dsl
rooms:
    reward_chamber:
        on_enter {
            # Items geben
            give_item("golden_sword")
            give_item("health_potion")

            # Nachrichten anzeigen
            show_message("Du hast einen goldenen Schwert gefunden!")
            show_message("Score: " + score)

            # Türen/Räume freischalten
            unlock("boss_door")
            unlock("secret_room")
        }
```

### 👹 **Monster spawnen**

```dsl
rooms:
    arena:
        on_first_enter {
            # Einzelnes Monster
            spawn_monster("goblin_king")

            # Mehrere Monster mit Loop
            repeat 5 {
                spawn_monster("skeleton_warrior")
            }

            show_message("Die Arena erwacht zum Leben!")
        }
```

### 🏆 **Spiel beenden**

```dsl
rooms:
    exit:
        on_enter {
            if (keysCollected >= 3 && score >= 1000) {
                show_message("Gratulation! Final Score: " + score)
                victory("Du hast das Escape Room gemeistert!")
            } else {
                show_message("Du brauchst 3 Schlüssel und 1000 Punkte!")
            }
        }
```

### 🐛 **Debugging**

```dsl
# Konsolen-Output für Entwickler
print("Debug: Score =", score)
print("Keys collected:", keysCollected)
print("Spawning enemy wave", i)
```

---

## Folie 16: Beispiel - Metadata & Player

### Metadata (Spiel-Info)

```dsl
escape_room:
    metadata:
        title: "Das Antike Tempel"
        description: "Entdecke die verborgenen Geheimnisse"
        difficulty: "easy"          # easy/normal/hard/extreme
        max_time: 30                # Minuten
        fog_of_war: true           # Fog aktivieren
        view_distance: 5            # Sichtweite in Tiles
        camera_zoom: 0.8           # Zoom-Level
```

### Player Konfiguration

```dsl
    player:
        class: "wizard"             # wizard oder hunter
        spawn_room: entrance        # Startposition
        health: 20                  # Überschreibt Klassenwert
        mana: 150
        speed: 1.2
```

---

## Folie 17: Beispiel - Räume (Rechteckig)

```dsl
    rooms:
        entrance:
            description: "Die große Eingangshalle"
            x: 2
            y: 2
            width: 12
            height: 10
            items: [golden_key, scroll]
            connections: [treasure_room, secret_chamber]
            fog_enabled: false      # Kein Fog in diesem Raum

        treasure_room:
            description: "Ein Raum voller Schätze"
            x: 18
            y: 2
            width: 10
            height: 8
            connections: [entrance]
            locked_by: golden_key   # Benötigt golden_key!
```

**Features:**

-   Automatische Korridore zwischen verbundenen Räumen
-   Türen bei `locked_by` automatisch platziert
-   Grid-basierte Positionierung

---

## Folie 18: Beispiel - Custom Room Patterns

```dsl
    rooms:
        # L-förmiger Raum
        storage_room:
            description: "Ein L-förmiger Lagerraum"
            x: 20
            y: 5
            pattern: """
##########
#........#
#........#
#####....#
    #....#
    ######
"""
            connections: [entrance]

        # Kreisförmige Kammer
        ritual_chamber:
            description: "Eine kreisförmige Ritualkammer"
            x: 35
            y: 8
            pattern: """
  ######
 #......#
#........#
#........#
 #......#
  ######
"""
```

**ASCII Symbole:** `#` = Wand, `.` = Boden, ` ` = Leer

---

## Folie 19: Beispiel - Items & Quizzes

### Items

```dsl
    items:
        golden_key:
            description: "Ein glänzender goldener Schlüssel"
            type: "key"
            texture: "items/key/big_key.png"
            visible: true

        ancient_scroll:
            description: "Eine alte Schriftrolle"
            type: "readable"
            texture: "items/book/book"
            readable: true
            content: "Der Schlüssel liegt, wo die Sonne untergeht..."
```

### Quiz

```dsl
    quizzes:
        chest_quiz:
            type: "single_choice"
            question: "Was ist 2 + 2?"
            answers: ["3", "4", "5"]
            correct_answers: [1]    # Index 1 = "4"
            reward: golden_key      # Item bei Erfolg
            attached_to: treasure_chest
```

---

## Folie 20: Beispiel - NPCs & Combat

### Feindliche NPCs

```dsl
    npcs:
        goblin_guard:
            name: "Goblin Wache"
            description: "Ein aggressiver Goblin"
            type: "hostile"
            texture: "character/monster/goblin"
            health: 20
            damage: 5
            ai_type: "fight"        # fight/idle/transition
            room: entrance

        skeleton_archer:
            name: "Skelett Bogenschütze"
            type: "hostile"
            texture: "character/monster/skeleton_archer"
            health: 15
            damage: 8
            ai_type: "fight"
            room: treasure_room
```

**AI-Typen:**

-   **fight**: Verfolgt & greift Spieler an
-   **idle**: Patrouilliert friedlich
-   **transition**: Greift nur an wenn beschädigt

---

## Folie 21: Schwierigkeitsgrade

| Difficulty  | Monster Stats  | Player Stats  | Verwendung          |
| ----------- | -------------- | ------------- | ------------------- |
| **easy**    | 70% HP/Damage  | 130% HP/Stats | Anfänger, Tutorials |
| **normal**  | 100% HP/Damage | 100% HP/Stats | Standard-Erfahrung  |
| **hard**    | 150% HP/Damage | 80% HP/Stats  | Herausfordernd      |
| **extreme** | 200% HP/Damage | 60% HP/Stats  | Sehr schwierig      |

**Beispiel:**

```dsl
metadata:
    difficulty: "hard"  # Monster sind stärker, Spieler schwächer
```

---

## Folie 22: Vollständiges Programmier-Beispiel

### 🎮 **Alles zusammen: Arena mit Wellen-System**

```dsl
escape_room:
    variables:
        wave: 0
        enemiesInWave: 3
        totalKills: 0
        arenaActive: false

    rooms:
        battle_arena:
            on_first_enter {
                show_message("Willkommen zur Arena! Überlebe 3 Wellen!")
                arenaActive = true
                wave = 1

                # Welle 1: 3 Goblins
                repeat enemiesInWave {
                    spawn_monster("goblin")
                }
                show_message("Welle 1: 3 Goblins!")
            }

            on_clear {
                totalKills += enemiesInWave
                wave += 1

                if (wave == 2) {
                    # Welle 2: 5 Skelette
                    enemiesInWave = 5
                    repeat enemiesInWave {
                        spawn_monster("skeleton")
                    }
                    show_message("Welle 2: 5 Skelette!")
                } else if (wave == 3) {
                    # Welle 3: Boss
                    spawn_monster("arena_boss")
                    show_message("FINALE: Boss erscheint!")
                } else if (wave > 3) {
                    # Arena gewonnen!
                    arenaActive = false
                    show_message("Arena gemeistert! Kills: " + totalKills)
                    score += 1000
                    give_item("champion_sword")
                    unlock("treasure_vault")
                }
            }

    npcs:
        arena_boss:
            description: "Arena Champion"
            hostile: true
            health: 200
            damage: 30

            on_death {
                show_message("Der Champion wurde besiegt!")
                score += 500
            }
```

---

## Folie 23: Implementierung - DSL Parsing & Runtime

### 🔧 **Wie funktioniert die DSL intern?**

```
1. ANTLR Parser (EscapeRoomDSL.g4)
   └─ Liest .esc Datei
   └─ Erstellt Parse Tree

2. Visitor Pattern
   └─ ExpressionVisitor: Expressions → AST Nodes
   └─ StatementVisitor: Statements → AST Nodes
   └─ EscapeRoomVisitor: Gesamte Datei → Java Objects

3. DSLRuntime
   └─ Variable Scopes (Stack)
   └─ Built-in Functions Registry
   └─ Event Handler Storage
   └─ GameBridge Interface

4. Execution
   └─ AST Nodes werden zur Laufzeit ausgeführt
   └─ Visitor wertet Expressions aus
   └─ Statements manipulieren Game State
```

### 📊 **AST (Abstract Syntax Tree)**

```java
// Expression AST Nodes
Interface Expression {
  Object evaluate(DSLRuntime runtime);
}

// Beispiele:
class IntLiteral implements Expression { ... }
class BinaryOperation implements Expression { ... }
class VariableReference implements Expression { ... }

// Statement AST Nodes
Interface Statement {
  void execute(DSLRuntime runtime);
}

// Beispiele:
class AssignmentStatement implements Statement { ... }
class IfStatement implements Statement { ... }
class RepeatStatement implements Statement { ... }
```

---

## Folie 24: Implementierung - Variable Scopes

### 🗂️ **Scope Management**

```java
public class DSLRuntime {
  // Stack von Scopes (Maps)
  private final Deque<Map<String, Object>> scopes;

  public Object getVariable(String name) {
    // Suche von innen nach außen
    for (Map<String, Object> scope : scopes) {
      if (scope.containsKey(name)) {
        return scope.get(name);
      }
    }
    return null; // Undefined
  }

  public void setVariable(String name, Object value) {
    // Update in existierendem Scope
    for (Map<String, Object> scope : scopes) {
      if (scope.containsKey(name)) {
        scope.put(name, value);
        return;
      }
    }
    // Oder neu im aktuellen Scope
    scopes.peek().put(name, value);
  }
}
```

### 🔍 **Beispiel: Variable Resolution**

```dsl
variables:
    score: 0        # Global Scope

rooms:
    arena:
        on_enter {
            score += 100    # Findet 'score' im Global Scope

            repeat i from 1 to 5 {  # Neuer Scope für Loop
                print(i)            # 'i' nur in Loop Scope
            }
            # 'i' hier nicht mehr verfügbar
        }
```

---

## Folie 25: Implementierung - Expression Evaluation

### 🧮 **Wie werden Expressions ausgewertet?**

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

      case "==":
        return Objects.equals(leftVal, rightVal);

      case ">":
        return ((Number) leftVal).doubleValue() >
               ((Number) rightVal).doubleValue();

      // ... weitere Operatoren
    }
  }
}
```

### 📝 **Expression Types**

| Expression Type | Beispiel             | AST Node                  |
| --------------- | -------------------- | ------------------------- |
| Literal         | `42`, `"Hello"`      | IntLiteral, StringLiteral |
| Variable        | `score`              | VariableReference         |
| Binary Op       | `score + 100`        | BinaryOperation           |
| Comparison      | `score > 500`        | BinaryOperation           |
| Function Call   | `show_message("Hi")` | FunctionCall              |
| Property Access | `player.health`      | PropertyAccess            |

---

## Folie 26: Implementierung - Event System

### ⚡ **Event Handler Registration**

```java
public class DSLRuntime {
  // Map<EventType, Map<EntityID, List<Handler>>>
  private Map<EventType, Map<String, List<EventHandler>>> eventHandlers;

  public void registerEventHandler(
      EventType type,
      String entityId,
      EventHandler handler
  ) {
    eventHandlers
      .computeIfAbsent(type, k -> new HashMap<>())
      .computeIfAbsent(entityId, k -> new ArrayList<>())
      .add(handler);
  }

  public void fireEvent(EventType type, String entityId) {
    List<EventHandler> handlers = eventHandlers
      .getOrDefault(type, Collections.emptyMap())
      .getOrDefault(entityId, Collections.emptyList());

    for (EventHandler handler : handlers) {
      handler.getStatementBlock().execute(this);
    }
  }
}
```

### 🎯 **Event Types**

```java
public enum EventType {
  ON_ENTER,        // Raum betreten
  ON_FIRST_ENTER,  // Erstes Mal betreten
  ON_EXIT,         // Raum verlassen
  ON_CLEAR,        // Alle Gegner besiegt
  ON_DEATH,        // NPC stirbt
  ON_INTERACT,     // Mit NPC interagieren
  ON_PICKUP,       // Item aufheben
  ON_CORRECT,      // Quiz korrekt
  ON_WRONG         // Quiz falsch
}
```

### 📍 **Beispiel: on_first_enter**

```java
// DSLRuntime trackt besuchte Räume
private final Set<String> visitedRooms;

public void fireOnEnterEvent(String roomId) {
  // Normal on_enter event
  fireEvent(EventType.ON_ENTER, roomId);

  // on_first_enter nur beim ersten Mal
  if (!visitedRooms.contains(roomId)) {
    visitedRooms.add(roomId);
    fireEvent(EventType.ON_FIRST_ENTER, roomId);
  }
}
```

---

## Folie 27: Implementierung - Built-in Functions

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

    // print(...) - für Debugging
    builtinFunctions.put("print", args -> {
      System.out.println(
        args.stream()
          .map(Object::toString)
          .collect(Collectors.joining(" "))
      );
      return null;
    });
  }
}
```

### 🔗 **GameBridge Interface**

```java
public interface GameBridge {
  // Nachrichten
  void showMessage(String message);

  // Monster spawnen
  void spawnMonster(String npcId);

  // Items
  void giveItem(String itemName);
  boolean hasItem(String itemName);

  // Türen/Räume
  void unlockDoor(String doorId);
  String getCurrentRoom();

  // Spielende
  void victory(String message);
  void gameOver(String message);

  // Player Stats
  int getPlayerHealth();
  void setPlayerHealth(int health);
}
```

**→ Trennt DSL Logic von Game Engine!**

---

## Folie 28: Implementierung - Loop Execution

### 🔄 **Repeat Statement**

```java
public class RepeatStatement implements Statement {
  private int count;              // Für repeat N
  private String loopVar;         // Für repeat i from X to Y
  private Expression fromExpr;
  private Expression toExpr;
  private StatementBlock body;

  @Override
  public void execute(DSLRuntime runtime) {
    if (loopVar == null) {
      // repeat N { ... }
      for (int i = 0; i < count; i++) {
        body.execute(runtime);
      }
    } else {
      // repeat i from X to Y { ... }
      int from = ((Number) fromExpr.evaluate(runtime)).intValue();
      int to = ((Number) toExpr.evaluate(runtime)).intValue();

      runtime.pushScope();  // Neuer Scope für Loop-Variable
      try {
        for (int i = from; i <= to; i++) {
          runtime.setVariable(loopVar, i);
          body.execute(runtime);
        }
      } finally {
        runtime.popScope();  // Scope aufräumen
      }
    }
  }
}
```

### 📊 **Beispiel: Monster Spawning**

```dsl
# DSL Code
repeat i from 1 to 5 {
    spawn_monster("goblin")
    print("Spawning goblin", i)
}
```

```java
// Execution Flow
1. fromExpr.evaluate(runtime) → 1
2. toExpr.evaluate(runtime) → 5
3. pushScope() → Neuer Scope für 'i'
4. Loop: i = 1, 2, 3, 4, 5
   - setVariable("i", i)
   - body.execute(runtime)
     - FunctionCall "spawn_monster" with ["goblin"]
     - FunctionCall "print" with ["Spawning goblin", i]
5. popScope() → 'i' entfernt
```

---

## Folie 29: Gameplay Controls

### Bewegung

-   **WASD** oder **Pfeiltasten**: Spieler bewegen
-   **Maus**: Richtung für Fernkampf-Angriffe

### Kampf

-   **Q-Taste**: Primärfähigkeit einsetzen (Fireball/Bow)
-   **Linksklick**: Alternative Fähigkeit
-   Skills verbrauchen Mana (Wizard) oder Stamina (Hunter)

### Interaktion

-   **E-Taste**: Mit Objekten interagieren (Lesen, NPCs, Türen)
-   **G-Taste**: Item aus Inventar ablegen
-   **Quiz**: Mausklick zum Antworten wählen

### Tipps

-   Monster greifen an wenn beschädigt
-   Verschiedene Klassen = verschiedene Stärken

---

## Folie 30: Workflow - Von DSL zu Level

```
1. DSL schreiben
   └─ my_escape_room.esc erstellen
   └─ In escapeRoom/assets/levels/ speichern

2. Validierung
   └─ Parser prüft Syntax
   └─ Fehler werden angezeigt

3. Level generieren
   └─ Automatische Code-Generierung
   └─ Räume, Items, NPCs werden erstellt

4. Spielen!
   └─ Level starten
   └─ Debuggen mit ASCII-Map
   └─ Anpassen und neu laden
```

**Vorteil:** Schneller Iterations-Zyklus ohne Neucompilierung!

---

## Folie 31: Use Cases

### 🎓 **Bildungsbereich**

-   **Schulen**: Programmier-Workshops (PRODUS)
-   **Universitäten**: Didaktische Escape Rooms (L<ESC>ROD)
-   **Selbststudium**: Interaktive Lernumgebungen

### 🎮 **Game Design**

-   **Rapid Prototyping**: Schnelles Testen von Level-Designs
-   **Educational Games**: Quiz-basierte Lernspiele
-   **Narrative Adventures**: Story-getriebene Erlebnisse

### 👨‍🏫 **Für Lehrkräfte**

-   Keine Programmier-Kenntnisse erforderlich
-   Anpassung an eigene Lerninhalte
-   Wiederverwendbare Templates

---

## Folie 32: Vorteile der DSL

### ✅ **Echte Programmierung**

-   **Variables** - State tracking wie in echten Spielen
-   **Conditionals** - If/Else Logik
-   **Loops** - Wiederholungen und Automatisierung
-   **Event Handlers** - Event-driven Programming
-   **Functions** - Built-in game functions
-   **Expressions** - Mathematische Berechnungen

### ✅ **Pädagogischer Wert**

-   Sanfter Einstieg in Programmierkonzepte
-   Sofortiges visuelles Feedback
-   Fehlertolerantes Lernen
-   Von einfach (Variables) bis komplex (Event Handlers)

### ✅ **Produktivität**

-   10x schneller als Java-Programmierung
-   Kein Kompilieren erforderlich
-   Änderungen sofort sichtbar
-   Weniger Boilerplate-Code

### ✅ **Flexibilität**

-   Dynamisches Gameplay möglich
-   Arena-Systeme, Quests, Puzzles
-   Kombinierbar für komplexe Logik
-   Erweiterbar für neue Features

---

## Folie 33: Roadmap & Ausblick

### ✨ **Aktuelle Features (v1.2 - Januar 2026)**

-   ✅ **Variables** - Spielzustand tracken
-   ✅ **Conditionals** - If/Else Logik
-   ✅ **Loops** - repeat, repeat i from X to Y
-   ✅ **Event Handlers** - on_enter, on_first_enter, on_clear, on_death
-   ✅ **Built-in Functions** - spawn_monster, show_message, give_item, unlock
-   ✅ **Expressions** - Mathematische Operationen
-   ✅ **Dynamic Monster Spawning**
-   ✅ **Combat System** - Hostile NPCs, AI
-   ✅ **Quiz System** - Interactive Rätsel
-   ✅ **Fog of War & Camera Controls**

### 🚀 **Geplante Features (v2.0)**

-   **Functions** - Wiederverwendbare Code-Blöcke
-   🎯 **Quest System** - Multi-stage Quests
-   🎲 **Random & Procedural** - Zufällige Spawns
-   📦 **Imports/Modules** - Code aufteilen
-   🔄 **Multiplayer Support** (L<ESC>ROD Projekt)

---

## Folie 34: Live Demo - Programmierfeatures

### 💻 **Demo: Variables, Conditionals, Loops, Events**

```dsl
escape_room:
    metadata:
        title: "Mein Erstes Escape Room"
        description: "Ein einfacher Raum mit einem Rätsel"
        difficulty: "easy"
        max_time: 10

    rooms:
        start:
            description: "Der Startraum"
            x: 2
            y: 2
            width: 10
            height: 10
            items: [key]
            connections: [exit]

        exit:
            description: "Der Ausgang"
            x: 15
            y: 2
            width: 6
            height: 6
            locked_by: key

    items:
        key:
            description: "Ein Schlüssel"
            type: "key"
            texture: "items/key/big_key.png"
```

**→ Level spielen!**

---

## Folie 35: Komplexes Beispiel - Arena System

### Features in diesem Beispiel:

-   ✅ **Variables**: wave, enemiesInWave, totalKills, score
-   ✅ **Conditionals**: if/else if/else chains
-   ✅ **Loops**: repeat mit dynamischen Werten
-   ✅ **Event Handlers**: on_first_enter, on_clear, on_death
-   ✅ **Built-in Functions**: spawn_monster, show_message, give_item, unlock
-   ✅ **Expressions**: Mathematische Berechnungen
-   ✅ **Dynamic Spawning**: Monster zur Laufzeit erzeugen

**→ Siehe complete_showcase.esc**  
**→ Gameplay demonstrieren**

---

## Folie 36: Best Practices - Programmierung

### 📝 **Strukturierung**

-   Logische Raum-IDs verwenden (`entrance`, `boss_room`)
-   Kommentare für komplexe Logik
-   Items vor Verwendung definieren

### 🎯 **Level Design**

-   Progression-Kurve beachten (einfach → schwer)
-   Balance zwischen Kämpfen und Rätseln
-   Belohnungen für Exploration

### 🐛 **Testing**

-   ASCII-Map für Debugging nutzen
-   Schwierigkeit testen mit verschiedenen Klassen
-   Quiz-Fragen validieren

### 🎨 **Textures**

-   Einheitlicher Art-Style
-   Korrekte Pfade verwenden
-   Fallback-Texturen berücksichtigen

---

## Folie 37: Ressourcen & Dokumentation

### 📚 **Dokumentation**

-   `ESCAPE_ROOM_DSL_DOCUMENTATION.md` - Vollständige DSL-Referenz
-   `blockly/doc/` - Blockly-Workshops
-   `README.md` - Projekt-Übersicht

### 🔧 **Tools**

-   VS Code mit Syntax Highlighting (geplant)
-   ANTLR Grammar: `escape_room_dsl/EscapeRoomDSL.g4`
-   Sprite Sheet Generator: `sprite-sheet-generator.py`

### 🌐 **Community**

-   GitHub: Dungeon-CampusMinden/Dungeon
-   PRODUS Projekt Website
-   L<ESC>ROD Projekt (Freiraum 2025)

### 💡 **Support**

-   Issues auf GitHub
-   Kontakt auf Deutsch oder Englisch

---

## Folie 38: Zusammenfassung

### 🎯 **Implementierte Programmierfeatures**

1. **Variables** - Spielzustand speichern (score, keys, flags)
2. **Conditionals** - If/Else Logik für dynamisches Verhalten
3. **Loops** - repeat & repeat i from X to Y für Wiederholungen
4. **Event Handlers** - on_enter, on_first_enter, on_clear, on_death, on_interact
5. **Built-in Functions** - spawn_monster, show_message, give_item, unlock, victory
6. **Expressions** - Mathematische Operationen und String-Verkettung
7. **Dynamic Spawning** - Monster zur Laufzeit erzeugen

### ✨ **Key Takeaways**

-   ✅ **Echte Programmierung** - Nicht nur Konfiguration!
-   ✅ **Event-Driven** - Reagiert auf Spieler-Aktionen
-   ✅ **Dynamisch** - Loops & Conditionals ermöglichen komplexe Logik
-   ✅ **Sofortiges Feedback** - Keine Kompilierung nötig
-   ✅ **Lernfreundlich** - Sanfter Einstieg in Programming
-   ✅ **Mächtig** - Arena-Systeme, Quests, Puzzles möglich

### 🚀 **Nächste Schritte**

-   Eigenes Escape Room mit Programmierlogik erstellen
-   complete_showcase.esc als Beispiel studieren
-   Dokumentation durcharbeiten

---

## Folie 39: Q&A

### Fragen?

**Kontakt:**

-   📧 GitHub Issues
-   🌐 Projekt-Website
-   👥 PRODUS & L<ESC>ROD Teams

**Vielen Dank für Ihre Aufmerksamkeit!**

---

## Anhang: Schnellreferenz

### Minimale DSL-Struktur

```dsl
escape_room:
    metadata:
        title: "Titel"
        description: "Beschreibung"
        difficulty: "easy"
        max_time: 30
    rooms:
        room1:
            description: "Raum"
            x: 2
            y: 2
            width: 10
            height: 10
```

### Häufige Item-Types

-   `"key"` - Schlüssel für Türen
-   `"readable"` - Bücher, Scrolls
-   `"consumable"` - Verbrauchsgegenstände
-   `"tool"` - Werkzeuge

### Quiz-Types

-   `"single_choice"` - Eine Antwort
-   `"multiple_choice"` - Mehrere Antworten

### AI-Types für NPCs

-   `"fight"` - Aggressiv
-   `"idle"` - Neutral
-   `"transition"` - Defensiv
