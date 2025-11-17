# Exposé

## 1. Projektziel: Was wollen wir machen?

Wir entwickeln eine Domain-Specific Language für die deklarative Spezifikation von Escape-Room-Spielen. Die DSL soll es ermöglichen, komplexe Spielinhalte ohne Programmierung zu definieren – Räume, Items, NPCs, Rätsel und Spielermechaniken werden in einer intuitiven, textuellen Notation beschrieben.

### Kernfunktionalität

```
escape_room:
    metadata:
        title: "The Cursed Fortress"
        difficulty: "hard"
        fog_of_war: true

    rooms:
        entrance_hall:
            x: 0, y: 0, width: 15, height: 15
            connections: [armory, library]

        treasure_vault:
            locked_by: golden_key
            items: [treasure_chest]

    items:
        golden_key:
            type: "key"
            description: "A shimmering golden key"

    npcs:
        guard:
            hostile: true
            health: 100
            damage: 15
```

Die DSL soll durch einen **ANTLR-basierten Parser** verarbeitet, validiert und in eine spielbare Repräsentation transformiert werden die dann die nötigen Schnittstellen des Dungeons anspricht.

Features:

-   **Grammar Design**: ANTLR Grammatik mit Lexer/Parser-Regeln.
-   **Interpreter**: Visitor-Pattern für AST-Traversierung.
-   **Validation Framework**: Validierung der DSL mit hilfreichen Error Nachrichten bei Kompilierung.
-   **Code Generation**: Transformation zu Game Engine Entities.
-   **Tooling**: VS Code Extension für Syntax Highlighting.

---

## 2. Motivation: Warum ist das spannend?

Das Projekt vereint fundamentale Compiler-Konzepte in einer greifbaren Anwendung:

-   **Sprachdesign**: Wie entwerfe ich eine DSL, die ausdrucksstark aber nicht überladen ist?
-   **Parsing**: ANTLR 4 Grammar mit Left-Recursion, Token-Precedence, Ambiguity-Resolution.
-   **Semantic Analysis**: Referenz-Validierung (existiert `locked_by: golden_key`?), Typ-Checking (Health > 0?).
-   **IR Design**: Intermediate Representation zwischen Parse-Tree und Runtime-Objekten.
-   **Error Recovery**: Präzise Fehlermeldungen mit Zeilennummern und Context.

## 3. Umsetzung: Wie werden wir das implementieren?

Zu Beginn wird eine DSL entworfen. Dabei wird sich an bereits existierende Sprachmodelle orientiert. Dies dient der Abwägung von Vor- und Nachteilen existierender Sprachdesigns. Der Fokus liegt dabei auf einer Nutzergruppe mit wenig bis gar keiner Programmiererfahrung.
Implementierung eines VisitorPatterns mittels ANTLR zur Verarbeitung der DSL-Eingabe zu einer IR. Das Visitor Patterns erhält die Eingabe als AST und generiert eine IR, die einem Interpreter übergeben wird. Ein Interpreter verwendet die IR, um einen Dungeon zu generieren.

**Deliverables**:

-   Vollständiger Grammatik definiert durch ANTLR.
-   Funktionierende Spielbare Level basierend auf DSL und den Dungeon Code.
-   1-2 Beispiel DSL-Dateien für verschiedene Level.

---

## 4. Erfolgsbewertung: Wie messen wir den Erfolg?

Grob definierte Ziele:

-   Wir haben das Aussehen unserer DSL definiert.
-   Wir können einfache quadratische Räume ohne jeglichen Entities erzeugen.
-   Wir können durch die DSL Spieler Character, NPCs, Hostile Mobs sowie Items ins Spiel bringen.
-   Wir können durch unsere DSL mehrere Räume definieren, sowie deren Nachbar Räume und generieren diese wie definiert.
-   Durch die DSL können wir Rätsel oder Quizzes definieren die wir dann z.B durch NPC ins Spiel bringen.
-   Der Spieler kann durch Quizzes Items erlangen wie z.B Schlüssel durch die er in vorher gesperrte Bereiche erreichen kann.

## 5. Risiken und Mitigationsstrategien

-   Lesen und verstehen des Dungeon Codes führt zu verspäteten oder gar nicht machbaren Features.

-   Team Member springt ab.

-   Machbarkeit stark überschätzt.
