# Escape Room DSL - Technische Präsentation

## Folie 1: Einführung

"Heute stelle ich unsere Escape Room DSL vor - eine domänenspezifische Sprache, die sich von einem einfachen Konfigurationsformat zu einer vollwertigen Programmiersprache entwickelt hat. Wir haben mit statischen Raumdefinitionen angefangen und sind bei Variablen, Bedingungen, Schleifen, Events und Triggern gelandet."

---

## Folie 2: Architektur-Überblick

"Das System folgt einer klassischen Compiler-Architektur mit fünf Schichten:

Zuerst haben wir die DSL-Datei - eure .esc-Datei mit Escape-Room-Definitionen. Diese durchläuft den ANTLR-Parser, der die Syntax validiert. Der Parser erstellt einen Parse Tree, den unser Visitor Pattern in einen Abstract Syntax Tree umwandelt. Dieser AST wird von der DSL Runtime ausgeführt, die über das GameBridge-Interface mit dem Spiel integriert ist.

Man kann es so sehen: DSL ist der Quellcode, ANTLR ist der Compiler, AST ist die Zwischendarstellung und Runtime ist die virtuelle Maschine."

---

## Folie 3: ANTLR Grammatik - Expression-Beispiele

"Schauen wir uns an, wie ANTLR unsere DSL-Syntax definiert. Hier ist ein Ausschnitt aus der Expression-Grammatik:

```antlr
expression:
    primary_expression              # Literale, Variablen
    | expression '.' ID             # Property-Zugriff: player.health
    | ID '(' ... ')'                # Funktionsaufruf: min(a, b)
    | expression '*' expression     # Multiplikation: 3 * 5
    | expression '+' expression     # Addition: score + 100
    | expression '>' expression     # Vergleich: health > 50
    | expression '&&' expression    # Logisches AND
```

Die Reihenfolge definiert Präzedenz - was oben steht, bindet stärker. Das bedeutet: `3 + 4 * 5` wird automatisch als `3 + (4 * 5)` geparst, weil Multiplikation vor Addition kommt.

Beispiele wie ANTLR unsere DSL versteht:

**Einfacher Ausdruck:**

```
score + 50
```

→ Parser erkennt: `expression '+' expression`  
→ Links: Identifier `score`, Rechts: Integer `50`

**Verketteter Ausdruck:**

```
player.health + 25
```

→ Parser erkennt: `expression '.' ID` dann `'+' expression`  
→ Erst Property-Zugriff, dann Addition

**Komplexe Bedingung:**

```
keysCollected >= 3 && score > 500
```

→ Parser erkennt: `(expression '>=' expression) '&&' (expression '>' expression)`  
→ Zwei Vergleiche, verbunden mit AND

Die Grammatik-Regeln erzeugen einen Parse Tree, den wir dann in unseren AST umwandeln."

---

## Folie 4: Das GameBridge Pattern

"Die GameBridge ist unser wichtigstes Design Pattern. Es ist ein Interface, das die DSL Runtime von der eigentlichen Game Engine entkoppelt.

Wenn euer DSL-Code `show_message('Hallo')` aufruft, weiß die Runtime nichts über LibGDX, Entities oder Dialogsysteme. Stattdessen ruft sie `gameBridge.showMessage()` auf. Das eigentliche Spiel implementiert dann dieses Interface und erledigt die echte Arbeit - die Hero-Entity finden, eine Dialog-Komponente erstellen, sie auf dem Bildschirm anzeigen.

Warum ist das wertvoll? Drei Gründe: Erstens, Separation of Concerns - die Runtime kennt nur Variablen und Expressions. Zweitens, Testbarkeit - wir können die GameBridge für Unit Tests mocken. Drittens, Flexibilität - verschiedene Spiele könnten dieselbe DSL Runtime mit unterschiedlichen Implementierungen nutzen."

---

## Folie 5: GameBridge Interface

"So sieht das Interface aus. Wir haben Methoden für Spielereigenschaften wie getPlayerHealth und setPlayerHealth. Inventar-Methoden wie hasItem und giveItem. Raumverwaltung mit unlockDoor und lockDoor. UI-Methoden wie showMessage. Entity-Spawning. Und Spielstatus-Kontrolle wie victory und gameOver.

Aktuell haben wir über 20 Methoden, und neue Spielfeatures hinzuzufügen bedeutet einfach neue Interface-Methoden hinzuzufügen."

---

## Folie 6: Event System Überblick

"Events sind der Weg, wie die DSL auf Spielaktionen reagiert. Wenn ihr definiert:

```
items:
    golden_key:
        on_pickup {
            score += 50
            show_message('Key found!')
        }
```

```
items:
    golden_key:
        on_pickup {
            score += 50
            show_message('Schlüssel gefunden!')
        }
```

Die Frage ist: Wie wird dieser Code ausgeführt, wenn der Spieler tatsächlich den Schlüssel aufhebt? Die Game Engine weiß nichts über unsere DSL. Hier kommt das Event Wiring ins Spiel."

---

## Folie 7: Event Wiring - Das Decorator Pattern

"Wir verwenden das Decorator Pattern. Wenn wir Entities spawnen, umhüllen wir ihre Callbacks mit unserem eigenen Code, der DSL-Events auslöst.

Das Muster ist immer gleich: Game Component hat einen Callback. Wir umhüllen ihn. Der Wrapper ruft das ursprüngliche Verhalten auf und löst dann das DSL-Event aus.

Zum Beispiel nimmt InteractionComponent eine Callback-Funktion. Wir geben ihm unsere umhüllte Version statt des Originals. Unser Wrapper führt zuerst die Spiellogik aus und benachrichtigt dann die DSL Runtime."

---

## Folie 8: Item Pickup Events

"Schauen wir uns das im Detail für Item-Aufnahme an. Wenn wir eine Item-Entity erstellen, holen wir uns zuerst den ursprünglichen collect-Callback - das ist eine Methodenreferenz auf `item.collect()`.

Dann erstellen wir einen umhüllten Callback. Dieser Wrapper ruft zuerst das Original auf - das fügt das Item zum Inventar hinzu und entfernt es aus der Welt. Dann löst er das DSL-Event aus.

Schließlich bauen wir die World-Item-Entity und ersetzen ihre InteractionComponent mit unserer umhüllten Version. Wenn der Spieler jetzt E drückt, führt das Spiel unseren Wrapper aus, der sowohl das ursprüngliche Verhalten als auch das DSL-Event auslöst."

---

## Folie 8: NPC Interaktions-Events

"NPC-Interaktionen funktionieren ähnlich. Wir erstellen einen Interaktions-Callback, der zuerst den Standard-Dialog anzeigt und dann das DSL ON_INTERACT Event auslöst.

Wir fügen eine InteractionComponent mit diesem Callback hinzu. Wenn der Spieler interagiert, werden sowohl der Dialog angezeigt als auch die benutzerdefinierten DSL-Handler ausgeführt."

---

## Folie 9: NPC Death Events

"Für feindliche NPCs nutzen wir den eingebauten onDeath-Callback des MonsterBuilders. Wenn wir das Monster erstellen, übergeben wir ein Lambda, das das DSL ON_DEATH Event auslöst.

Wenn die Gesundheit des Monsters null erreicht, ruft die Game Engine diesen Callback auf, was unsere DSL-Event-Handler triggert. So funktioniert `give_item('silver_key')` in einem on_death Handler."

---

## Folie 10: Raum-Eintritts-Erkennung

"Raum-Events sind anders - es gibt keinen Callback zum Umhüllen. Wir brauchen kontinuierliche Positions-Verfolgung.

Wir haben RoomTrackingSystem erstellt, das jeden Frame läuft. Es holt die Spielerposition, findet heraus, welcher Raum diese Position enthält, und vergleicht sie mit dem vorherigen Raum.

Wenn sich der Raum geändert hat, löst es ON_EXIT für den alten Raum und ON_ENTER für den neuen Raum aus. Es verfolgt auch besuchte Räume, um ON_FIRST_ENTER nur einmal auszulösen."

---

## Folie 11: Raum-Generierung - Koordinaten sind wichtig

"Eine häufige Frage: Werden die x- und y-Koordinaten tatsächlich verwendet? Ja, absolut!

Räume werden in einem 2D-Gitter an ihren exakten Koordinaten platziert. Das System findet zuerst die Min- und Max-Koordinaten über alle Räume hinweg, um die Level-Größe zu bestimmen. Wenn ein Raum negative Koordinaten hat, berechnen wir einen Offset und verschieben alle Räume, um negative Array-Indizes zu vermeiden.

Dann erstellen wir ein 2D-Layout-Array, das mit Wänden initialisiert wird. Jeder Raum wird an seiner exakten x, y Position mit seiner Breite und Höhe ausgeschnitten."

---

## Folie 12: Raum-Platzierungs-Beispiel

"Hier ist ein visuelles Beispiel. Wenn ihr entrance bei x=2, y=2 mit width=5, height=4 definiert, schnitzt das System Boden-Tiles genau an dieser Position im Gitter aus.

Die x- und y-Koordinaten bestimmen das räumliche Layout. Räume mit unterschiedlichen Koordinaten sind physisch getrennt. Das ist kritisch für Korridor-Generierung und Raum-Eintritts-Erkennung."

---

## Folie 13: Korridor-Generierung

"Korridore nutzen auch die Raum-Koordinaten. Wir berechnen den Mittelpunkt jedes Raums mit x + width/2 und y + height/2.

Dann erstellen wir einen L-förmigen Korridor, der die Mittelpunkte verbindet - horizontales Segment vom Mittelpunkt von Raum1 zur x-Koordinate von Raum2, dann vertikales Segment zum Mittelpunkt von Raum2.

Türen werden platziert, wo Korridore Raumwände schneiden. Ohne Koordinaten wäre das unmöglich."

---

## Folie 14: Raum-Tracking nutzt Koordinaten

"Raum-Eintritts-Erkennung hängt auch von Koordinaten ab. Für jeden Raum prüfen wir, ob die Spielerposition innerhalb der Raum-Bounding-Box liegt: x bis x+width, y bis y+height.

Wenn der Spieler an Position (5, 3) einen Raum bei x=2, y=2, width=5, height=4 betritt, prüfen wir: Ist 5 zwischen 2 und 7? Ja. Ist 3 zwischen 2 und 6? Ja. Spieler ist in diesem Raum. Löse ON_ENTER Event aus."

---

## Folie 15: Expression Parsing - Operator-Präzedenz

"Jetzt sprechen wir darüber, wie wir Programmier-Konstrukte verarbeiten. Die Grammatik definiert Operator-Präzedenz durch Regel-Reihenfolge.

Primäre Expressions wie Literale und Variablen haben höchste Präzedenz. Dann Property-Zugriff. Dann Funktionsaufrufe. Unäre Operatoren wie Negation. Dann Multiplikation und Division. Addition und Subtraktion. Vergleiche. Gleichheit. Logisches AND. Logisches OR hat niedrigste Präzedenz.

Das erzeugt automatische Präzedenz. `3 + 4 * 5` wird geparst als `3 + (4 * 5)`. `a > 5 && b < 10` wird geparst als `(a > 5) && (b < 10)`."

---

## Folie 16: Verkettete Bedingungen - Parse Tree

"Verfolgen wir eine komplexe Bedingung: `keysCollected >= totalKeys && score >= 500`.

Der Parser erstellt einen Baum mit AND an der Wurzel. Das linke Kind ist der erste Vergleich: keysCollected >= totalKeys. Das rechte Kind ist der zweite Vergleich: score >= 500.

Jeder Vergleich ist selbst eine binäre Expression mit einem Identifier links, dem Operator und dem Wert rechts."

---

## Folie 17: Verkettete Bedingungen - AST-Struktur

"Das Visitor Pattern wandelt diesen Parse Tree in unseren AST um. Wir bekommen verschachtelte BinaryExpr-Objekte.

Der Top-Level BinaryExpr hat Operator '&&'. Seine linke Seite ist ein weiterer BinaryExpr mit Operator '>='. Seine rechte Seite ist ebenfalls ein BinaryExpr mit '>=' Operator.

Diese Baumstruktur wird zur Laufzeit ausgewertet."

---

## Folie 18: Verkettete Bedingungen - Ausführung

"Wenn wir diese Bedingung auswerten, ist es rekursiv.

Zuerst, werte die linke Seite aus. Hole keysCollected von der Runtime - das ist 3. Hole totalKeys - das ist 3. Wende >= Operator an: 3 >= 3 ist true.

Zweitens, werte die rechte Seite aus. Hole score - das ist 650. Wende >= 500 an, ist true.

Schließlich, wende den && Operator an: true && true ergibt true. Die gesamte Bedingung ist true."

---

## Folie 19: If/Else Statement Verarbeitung

"If-Statements werden in IfStatement AST-Knoten geparst. Der Visitor extrahiert die Bedingungs-Expression, den Then-Block und optional den Else-Block.

Else-if-Ketten werden zu verschachtelten IfStatements. Der Else-Block des ersten If enthält ein weiteres IfStatement. Das setzt sich für jedes else-if fort.

Das finale else wird zu einem einfachen StatementBlock."

---

## Folie 20: If/Else Ausführungs-Ablauf

"Die Ausführung ist straightforward. Zuerst, werte die Bedingung aus. Das Ergebnis muss boolean sein.

Wenn true, führe den Then-Block aus. Wenn false und es gibt einen Else-Block, führe ihn aus. Wenn der Else-Block ein weiteres IfStatement ist, wertet dieses IfStatement seine eigene Bedingung aus und setzt die Kette fort.

So unterstützen wir unbegrenzte else-if-Ketten ohne spezielle Syntax."

---

## Folie 21: Schleifen-Verarbeitung - Zwei Formen

"Wir unterstützen zwei Schleifen-Formen. Einfaches Repeat: `repeat 3 { ... }` führt den Block 3-mal aus.

Range-Repeat: `repeat i from 1 to 5 { ... }` führt mit einer Schleifenvariable aus, die sich bei jeder Iteration ändert.

Beide werden durch denselben RepeatStatement AST-Knoten mit unterschiedlichen befüllten Feldern repräsentiert."

---

## Folie 22: Einfache Repeat-Ausführung

"Für einfaches Repeat werten wir die Count-Expression aus. Sie muss eine Zahl sein. Dann führen wir den Body so oft in einer einfachen For-Schleife aus.

Es existiert keine Schleifenvariable. Jede Iteration führt einfach denselben Code aus. In der Schleife modifizierte Variablen bleiben über Iterationen hinweg bestehen."

---

## Folie 23: Range-Repeat-Ausführung

"Range-Repeat ist komplexer. Wir werten die Start- und End-Expressions aus - beide müssen Zahlen sein.

Dann pushen wir einen neuen Scope auf den Scope-Stack der Runtime. Dieser Scope wird die Schleifenvariable halten.

Für jede Iteration von Start bis End inklusive setzen wir die Schleifenvariable im aktuellen Scope und führen den Body aus.

Nach der Schleife poppen wir den Scope. Das entfernt die Schleifenvariable, sodass sie nicht in den äußeren Scope leckt."

---

## Folie 24: Registrierungs-Prozess

"Wenn das Spiel startet, verarbeitet DSLEscapeRoom.initializeDSLRuntime die geparste Definition.

Schritt 1: Materialize variables. Wir werten die initiale Expression jeder Variable aus und speichern das Ergebnis im globalen Scope.

Schritt 2: Registriere globale Triggers. Jeder Trigger wird zur Trigger-Liste der Runtime hinzugefügt.

Schritt 3: Registriere Event-Handler. Für jeden Raum, jedes Item, jeden NPC und jedes Quiz iterieren wir durch ihre Event-Handler und registrieren sie bei der Runtime, gemappt nach Event-Typ und Entity-ID."

---

## Folie 25: Vollständiges Ablauf-Beispiel - Setup

"Verfolgen wir ein vollständiges Beispiel. Wir haben Variablen: keysCollected startet bei 0, totalKeys ist 3, score ist 0.

Wir haben einen Trigger: wenn keysCollected >= totalKeys && score >= 500, entsperre den Ausgang und löse Victory aus.

Wir haben ein Item golden_key mit einem on_pickup-Handler, der keysCollected inkrementiert, score addiert und eine bedingte Nachricht anzeigt."

---

## Folie 26: Vollständiges Ablauf-Beispiel - Parsing

"Zur Parse-Zeit erstellt ANTLR den Parse Tree gemäß den Grammatik-Regeln. Variables-Block erstellt Expression-AST-Knoten. Triggers-Block erstellt einen Trigger mit Bedingungs-Expression und Statement-Block. Der Event-Handler des Items erstellt einen EventHandler mit Statements.

Das If-Statement im Handler wird zu einem IfStatement AST mit Bedingung und Then/Else-Blöcken."

---

## Folie 27: Vollständiges Ablauf-Beispiel - Registrierung

"Bei der Initialisierung definiert die Runtime keysCollected als 0, totalKeys als 3, score als 0.

Sie registriert den Trigger mit seiner Bedingungs-Expression und Statement-Block.

Sie registriert den Event-Handler für ON_PICKUP auf golden_key mit all seinen Statements inklusive des If-Statements."

---

## Folie 28: Vollständiges Ablauf-Beispiel - Ausführung Teil 1

"Wenn der Spieler den Schlüssel aufhebt, löst der umhüllte collect-Callback das ON_PICKUP Event aus.

Die Runtime findet alle Handler für ON_PICKUP auf golden_key. Sie führt jedes Statement in Reihenfolge aus.

Statement 1: AssignmentStatement wird ausgeführt. Es holt den aktuellen Wert von keysCollected (0), wertet die Expression (1) aus, addiert sie und setzt keysCollected auf 1.

Statement 2: Dasselbe für score - setzt es auf 50."

---

## Folie 29: Vollständiges Ablauf-Beispiel - Ausführung Teil 2

"Statement 3: IfStatement wird ausgeführt. Es wertet die Bedingung aus: keysCollected < totalKeys.

Dieser BinaryExpr holt keysCollected (1) und totalKeys (3), wendet den < Operator an, gibt true zurück.

Da die Bedingung true ist, führt es den Then-Block aus: show_message mit dem berechneten String.

Der Else-Block wird nicht ausgeführt."

---

## Folie 30: Vollständiges Ablauf-Beispiel - Trigger-Prüfung

"Nachdem alle Event-Handler fertig sind, prüft die Runtime die Triggers.

Die Trigger-Bedingung wird ausgewertet: keysCollected >= totalKeys ist 1 >= 3, was false ist. Score >= 500 ist 50 >= 500, was false ist.

False && false ergibt false. Der Trigger feuert nicht.

Wenn der Spieler alle 3 Schlüssel aufhebt und genug Score bekommt, dann wird keysCollected zu 3 und score könnte 650 sein. Dann ist 3 >= 3 true, 650 >= 500 ist true, true && true ergibt true, und der Trigger feuert!"

---

## Folie 31: Wichtige Design Patterns

"Schauen wir uns die verwendeten Patterns an.

Visitor Pattern wandelt Parse Tree in AST um. Strategy Pattern - verschiedene Expression- und Statement-Typen implementieren dasselbe Interface. Observer Pattern - Events benachrichtigen registrierte Handler. Bridge Pattern - GameBridge entkoppelt DSL von Game Engine. Interpreter Pattern - jeder AST-Knoten weiß, wie er sich selbst auswertet oder ausführt. Decorator Pattern - wir umhüllen Callbacks, um Event-Firing hinzuzufügen."

---

## Folie 32: Technische Errungenschaften

"Was haben wir gebaut? Einen vollständigen Parser mit ANTLR mit korrekter Operator-Präzedenz. Einen AST-basierten Interpreter mit rekursiver Auswertung. Ein Scope-basiertes Variablen-System mit Push/Pop für verschachtelte Scopes. Ein komplettes Event-System mit Registrierung und Dispatch. Globale Triggers mit automatischer Prüfung. Eine GameBridge-Abstraktionsschicht. Und Integration mit einer echten Game Engine."

---

## Folie 33: Lessons Learned

"Grammatik-Design ist kritisch - Operator-Präzedenz muss von Anfang an richtig sein. AST-Ausführung schlägt direkte Interpretation - sie erlaubt Validierung und Optimierung. Das GameBridge-Pattern war essentiell für saubere Trennung. Event-Wiring durch Callback-Wrapping funktioniert wunderbar. Triggers sind mächtiger als erwartet - sie ermöglichen komplexe Quest-Logik mit einfacher Syntax.

Die größte Erkenntnis: Eine gute DSL macht komplexe Aufgaben einfach, nicht einfache Aufgaben möglich."

---

## Folie 34: Beispiel - Einfach vs Komplex

"Das ist es, was das ermöglicht. Ohne die DSL erfordert die Implementierung von 'entsperre Ausgang, wenn Spieler 3 Schlüssel und 500 Punkte hat' verstreuten Code in mehreren Dateien - Item-Pickup-Logik, Door-Unlock-Logik, Bedingungsprüfung, UI-Updates.

Mit der DSL sind es vier Zeilen:

```
when (keysCollected >= 3 && score >= 500) {
    unlock('exit_room')
    victory('Du gewinnst!')
}
```

Die DSL kompiliert die Komplexität weg, während die Absicht klar bleibt."

---

## Folie 35: Zukunftsmöglichkeiten

"Wir könnten das noch weiter ausbauen. Funktionen - Nutzer können wiederverwendbare DSL-Funktionen definieren. Arrays und Schleifen über Collections. Mehr Event-Typen - on_timer, on_player_health_low. State Machines - definiere Spielzustände und Übergänge. Modding-Support - Spieler erstellen eigene Escape Rooms ohne Java-Code.

Die Architektur unterstützt all das, weil die Runtime von der Game Engine isoliert ist."

---

## Folie 36: Demo

"Jetzt zeige ich euch eine Live-Demo. Ich werde die dynamic_test.esc-Datei ausführen, die alle Features nutzt - Variablen, Expressions, Conditionals, Loops, Events und Triggers. Schaut zu, wie das Aufheben von Schlüsseln den Zähler aktualisiert, bedingte Nachrichten auslöst und schließlich den Ausgang entsperrt, wenn die Bedingungen erfüllt sind."

---

## Folie 37: Fazit

"Wir haben mit einer einfachen Idee angefangen: Escape Rooms in einer Textdatei definieren. Wir sind bei einer vollständigen Programmiersprache gelandet, die in unser Spiel eingebettet ist.

Der Schlüssel zum Erfolg war klare Architektur - Trennung von Parsing, AST-Konstruktion und Ausführung. Das GameBridge-Pattern für Spiel-Integration. Und das Decorator-Pattern für Event-Wiring.

Vielen Dank für eure Aufmerksamkeit. Fragen?"

---

## Anhang: Häufige Fragen

**F: Warum nicht eine existierende Scripting-Sprache wie Lua oder Python verwenden?**
A: "Domänenspezifische Sprachen sind für ihre Domäne optimiert. Unsere DSL-Syntax ist natürlich für Escape-Room-Designer - `room`, `item`, `on_pickup` liest sich wie normales Deutsch. Allzweck-Sprachen erfordern mehr Boilerplate und sind für diesen spezifischen Anwendungsfall nicht so ausdrucksstark. Außerdem haben wir mehr gelernt, indem wir es selbst gebaut haben."

**F: Wie ist die Performance im Vergleich zu hardcodiertem Java?**
A: "Es gibt Overhead durch Interpretation, aber der ist vernachlässigbar. DSL-Code läuft bei Game-Events - Item-Aufnahme, Raum-Eintritt - die in menschlicher Geschwindigkeit passieren, nicht in engen Schleifen. Der Flaschenhals ist Rendering, nicht unser Interpreter. Und die gewonnene Flexibilität überwiegt die winzigen Performance-Kosten bei Weitem."

**F: Kann man DSL-Dateien während der Entwicklung hot-reloaden?**
A: "Aktuell nicht, aber die Architektur unterstützt es. Wir müssten den Runtime-State clearen, die DSL-Datei neu parsen und alle Handler neu registrieren. Die Trennung zwischen Parsing und Ausführung macht das machbar. Es wäre eine großartige Ergänzung für schnellere Iteration beim Level-Design."

**F: Wie debuggt man DSL-Code?**
A: "Wir haben umfangreiches Logging. Jede Variablen-Änderung, jedes gefeuerte Event und jeder geprüfte Trigger wird geloggt. Wir haben auch Validierung, die zur Parse-Zeit läuft, um Fehler früh zu fangen. Zukünftige Arbeit könnte einen DSL-Debugger mit Breakpoints und Variablen-Inspektion hinzufügen."

**F: Was war der schwierigste Teil der Implementierung?**
A: "Der Expression-Parser mit korrekter Präzedenz war anfangs knifflig. Wir mussten die ANTLR-Grammatik-Syntax tief verstehen. Event-Wiring brauchte Iteration - herauszufinden, wo man Game-Callbacks abfängt, ohne den Engine-Code zu modifizieren. Und das Scope-System für Schleifen brauchte sorgfältiges Testing, um Variablen-Leaks zu vermeiden."
