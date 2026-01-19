package dsl.runtime;

import static org.junit.jupiter.api.Assertions.*;

import dsl.runtime.ast.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * Comprehensive tests for DSL Runtime - Tier 1, 2, and 3 features.
 * Tests Variables, Expressions, Conditionals, Loops, Event Handlers, and
 * Triggers.
 */
public class DSLRuntimeTest {

    private DSLRuntime runtime;

    @BeforeEach
    void setUp() {
        runtime = new DSLRuntime();
    }

    // =============================================================================
    // TIER 1: VARIABLES TESTS
    // =============================================================================

    @Test
    void testDefineAndRetrieveGlobalVariable() {
        runtime.defineGlobalVariable("score", 100);
        assertEquals(100, runtime.getVariable("score"));
    }

    @Test
    void testDefineAndRetrieveLocalVariable() {
        runtime.pushScope();
        runtime.setVariable("tempVar", "hello");
        assertEquals("hello", runtime.getVariable("tempVar"));
        runtime.popScope();
    }

    @Test
    void testUpdateGlobalVariable() {
        runtime.defineGlobalVariable("health", 50);
        runtime.setVariable("health", 75);
        assertEquals(75, runtime.getVariable("health"));
    }

    @Test
    void testVariableScoping() {
        runtime.defineGlobalVariable("x", 10);
        runtime.pushScope();
        runtime.setVariable("x", 20);
        assertEquals(20, runtime.getVariable("x"));
        runtime.popScope();
        assertEquals(10, runtime.getVariable("x"));
    }

    @Test
    void testBooleanVariable() {
        runtime.defineGlobalVariable("hasKey", false);
        assertEquals(false, runtime.getVariable("hasKey"));
        runtime.setVariable("hasKey", true);
        assertEquals(true, runtime.getVariable("hasKey"));
    }

    @Test
    void testStringVariable() {
        runtime.defineGlobalVariable("playerName", "Hero");
        assertEquals("Hero", runtime.getVariable("playerName"));
    }

    @Test
    void testFloatVariable() {
        runtime.defineGlobalVariable("multiplier", 1.5);
        assertEquals(1.5, runtime.getVariable("multiplier"));
    }

    // =============================================================================
    // TIER 1: EXPRESSION EVALUATION TESTS
    // =============================================================================

    @Test
    void testIntegerLiteralEvaluation() {
        IntLiteralExpr expr = new IntLiteralExpr(42);
        assertEquals(42, expr.evaluate(runtime));
    }

    @Test
    void testFloatLiteralEvaluation() {
        FloatLiteralExpr expr = new FloatLiteralExpr(3.14);
        assertEquals(3.14, expr.evaluate(runtime));
    }

    @Test
    void testStringLiteralEvaluation() {
        StringLiteralExpr expr = new StringLiteralExpr("Hello World");
        assertEquals("Hello World", expr.evaluate(runtime));
    }

    @Test
    void testBooleanLiteralEvaluation() {
        BoolLiteralExpr trueExpr = new BoolLiteralExpr(true);
        BoolLiteralExpr falseExpr = new BoolLiteralExpr(false);
        assertEquals(true, trueExpr.evaluate(runtime));
        assertEquals(false, falseExpr.evaluate(runtime));
    }

    @Test
    void testIdentifierEvaluation() {
        runtime.defineGlobalVariable("myVar", 123);
        IdentifierExpr expr = new IdentifierExpr("myVar");
        assertEquals(123, expr.evaluate(runtime));
    }

    // =============================================================================
    // TIER 1: ARITHMETIC EXPRESSIONS
    // =============================================================================

    @Test
    void testAddition() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(10),
                "+",
                new IntLiteralExpr(5));
        assertEquals(15, expr.evaluate(runtime));
    }

    @Test
    void testSubtraction() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(10),
                "-",
                new IntLiteralExpr(3));
        assertEquals(7, expr.evaluate(runtime));
    }

    @Test
    void testMultiplication() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(6),
                "*",
                new IntLiteralExpr(7));
        assertEquals(42, expr.evaluate(runtime));
    }

    @Test
    void testDivision() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(20),
                "/",
                new IntLiteralExpr(4));
        assertEquals(5, expr.evaluate(runtime));
    }

    @Test
    void testModulo() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(10),
                "%",
                new IntLiteralExpr(3));
        assertEquals(1, expr.evaluate(runtime));
    }

    @Test
    void testComplexArithmetic() {
        // (10 + 5) * 2 = 30
        BinaryExpr expr = new BinaryExpr(
                new BinaryExpr(
                        new IntLiteralExpr(10),
                        "+",
                        new IntLiteralExpr(5)),
                "*",
                new IntLiteralExpr(2));
        assertEquals(30, expr.evaluate(runtime));
    }

    @Test
    void testArithmeticWithVariables() {
        runtime.defineGlobalVariable("a", 10);
        runtime.defineGlobalVariable("b", 20);

        BinaryExpr expr = new BinaryExpr(
                new IdentifierExpr("a"),
                "+",
                new IdentifierExpr("b"));
        assertEquals(30, expr.evaluate(runtime));
    }

    // =============================================================================
    // TIER 1: COMPARISON EXPRESSIONS
    // =============================================================================

    @Test
    void testEquality() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(5),
                "==",
                new IntLiteralExpr(5));
        assertEquals(true, expr.evaluate(runtime));
    }

    @Test
    void testInequality() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(5),
                "!=",
                new IntLiteralExpr(3));
        assertEquals(true, expr.evaluate(runtime));
    }

    @Test
    void testGreaterThan() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(10),
                ">",
                new IntLiteralExpr(5));
        assertEquals(true, expr.evaluate(runtime));
    }

    @Test
    void testLessThan() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(3),
                "<",
                new IntLiteralExpr(7));
        assertEquals(true, expr.evaluate(runtime));
    }

    @Test
    void testGreaterOrEqual() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(5),
                ">=",
                new IntLiteralExpr(5));
        assertEquals(true, expr.evaluate(runtime));
    }

    @Test
    void testLessOrEqual() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(4),
                "<=",
                new IntLiteralExpr(7));
        assertEquals(true, expr.evaluate(runtime));
    }

    // =============================================================================
    // TIER 1: LOGICAL EXPRESSIONS
    // =============================================================================

    @Test
    void testLogicalAnd() {
        BinaryExpr expr = new BinaryExpr(
                new BoolLiteralExpr(true),
                "&&",
                new BoolLiteralExpr(true));
        assertEquals(true, expr.evaluate(runtime));
    }

    @Test
    void testLogicalOr() {
        BinaryExpr expr = new BinaryExpr(
                new BoolLiteralExpr(false),
                "||",
                new BoolLiteralExpr(true));
        assertEquals(true, expr.evaluate(runtime));
    }

    @Test
    void testLogicalNot() {
        UnaryExpr expr = new UnaryExpr(
                "!",
                new BoolLiteralExpr(true));
        assertEquals(false, expr.evaluate(runtime));
    }

    @Test
    void testComplexLogicalExpression() {
        // (true && false) || true = true
        BinaryExpr expr = new BinaryExpr(
                new BinaryExpr(
                        new BoolLiteralExpr(true),
                        "&&",
                        new BoolLiteralExpr(false)),
                "||",
                new BoolLiteralExpr(true));
        assertEquals(true, expr.evaluate(runtime));
    }

    // =============================================================================
    // TIER 1: STRING CONCATENATION
    // =============================================================================

    @Test
    void testStringConcatenation() {
        BinaryExpr expr = new BinaryExpr(
                new StringLiteralExpr("Hello "),
                "+",
                new StringLiteralExpr("World"));
        assertEquals("Hello World", expr.evaluate(runtime));
    }

    @Test
    void testStringWithNumberConcatenation() {
        BinaryExpr expr = new BinaryExpr(
                new StringLiteralExpr("Score: "),
                "+",
                new IntLiteralExpr(100));
        assertEquals("Score: 100", expr.evaluate(runtime));
    }

    @Test
    void testStringWithVariableConcatenation() {
        runtime.defineGlobalVariable("name", "Alice");
        BinaryExpr expr = new BinaryExpr(
                new StringLiteralExpr("Hello, "),
                "+",
                new IdentifierExpr("name"));
        assertEquals("Hello, Alice", expr.evaluate(runtime));
    }

    // =============================================================================
    // TIER 2: CONDITIONALS TESTS
    // =============================================================================

    @Test
    void testSimpleIfStatement() {
        runtime.defineGlobalVariable("result", 0);

        // if (true) { result = 42 }
        IfStatement ifStmt = new IfStatement(
                new BoolLiteralExpr(true),
                new StatementBlock(List.of(
                        new AssignmentStatement("result", "=", new IntLiteralExpr(42)))),
                null);

        ifStmt.execute(runtime);
        assertEquals(42, runtime.getVariable("result"));
    }

    @Test
    void testIfElseStatement() {
        runtime.defineGlobalVariable("result", 0);

        // if (false) { result = 10 } else { result = 20 }
        IfStatement ifStmt = new IfStatement(
                new BoolLiteralExpr(false),
                new StatementBlock(List.of(
                        new AssignmentStatement("result", "=", new IntLiteralExpr(10)))),
                new StatementBlock(List.of(
                        new AssignmentStatement("result", "=", new IntLiteralExpr(20)))));

        ifStmt.execute(runtime);
        assertEquals(20, runtime.getVariable("result"));
    }

    @Test
    void testIfElseIfStatement() {
        runtime.defineGlobalVariable("score", 75);
        runtime.defineGlobalVariable("grade", "");

        // if (score >= 90) { grade = "A" } else if (score >= 70) { grade = "B" } else {
        // grade = "C" }
        IfStatement elseIfPart = new IfStatement(
                new BinaryExpr(new IdentifierExpr("score"), ">=", new IntLiteralExpr(70)),
                new StatementBlock(List.of(
                        new AssignmentStatement("grade", "=", new StringLiteralExpr("B")))),
                new StatementBlock(List.of(
                        new AssignmentStatement("grade", "=", new StringLiteralExpr("C")))));

        IfStatement ifStmt = new IfStatement(
                new BinaryExpr(new IdentifierExpr("score"), ">=", new IntLiteralExpr(90)),
                new StatementBlock(List.of(
                        new AssignmentStatement("grade", "=", new StringLiteralExpr("A")))),
                elseIfPart);

        ifStmt.execute(runtime);
        assertEquals("B", runtime.getVariable("grade"));
    }

    @Test
    void testNestedIfStatements() {
        runtime.defineGlobalVariable("x", 10);
        runtime.defineGlobalVariable("y", 20);
        runtime.defineGlobalVariable("result", "");

        // if (x > 5) { if (y > 15) { result = "both" } }
        IfStatement innerIf = new IfStatement(
                new BinaryExpr(new IdentifierExpr("y"), ">", new IntLiteralExpr(15)),
                new StatementBlock(List.of(
                        new AssignmentStatement("result", "=", new StringLiteralExpr("both")))),
                null);

        IfStatement outerIf = new IfStatement(
                new BinaryExpr(new IdentifierExpr("x"), ">", new IntLiteralExpr(5)),
                new StatementBlock(List.of(innerIf)),
                null);

        outerIf.execute(runtime);
        assertEquals("both", runtime.getVariable("result"));
    }

    // =============================================================================
    // TIER 3: LOOPS TESTS
    // =============================================================================

    @Test
    void testSimpleRepeatLoop() {
        runtime.defineGlobalVariable("counter", 0);

        // repeat 5 { counter += 1 }
        RepeatStatement loop = new RepeatStatement(
                new IntLiteralExpr(5),
                new StatementBlock(List.of(
                        new AssignmentStatement("counter", "+=", new IntLiteralExpr(1)))));

        loop.execute(runtime);
        assertEquals(5, runtime.getVariable("counter"));
    }

    @Test
    void testRepeatLoopWithRange() {
        runtime.defineGlobalVariable("sum", 0);

        // repeat i from 1 to 5 { sum += i }
        RepeatStatement loop = new RepeatStatement(
                "i",
                new IntLiteralExpr(1),
                new IntLiteralExpr(5),
                new StatementBlock(List.of(
                        new AssignmentStatement("sum", "+=", new IdentifierExpr("i")))));

        loop.execute(runtime);
        assertEquals(15, runtime.getVariable("sum")); // 1+2+3+4+5 = 15
    }

    @Test
    void testNestedLoops() {
        runtime.defineGlobalVariable("count", 0);

        // repeat 3 { repeat 2 { count += 1 } }
        RepeatStatement innerLoop = new RepeatStatement(
                new IntLiteralExpr(2),
                new StatementBlock(List.of(
                        new AssignmentStatement("count", "+=", new IntLiteralExpr(1)))));

        RepeatStatement outerLoop = new RepeatStatement(
                new IntLiteralExpr(3),
                new StatementBlock(List.of(innerLoop)));

        outerLoop.execute(runtime);
        assertEquals(6, runtime.getVariable("count"));
    }

    @Test
    void testLoopWithConditional() {
        runtime.defineGlobalVariable("evenSum", 0);

        // repeat i from 1 to 10 { if (i % 2 == 0) { evenSum += i } }
        RepeatStatement loop = new RepeatStatement(
                "i",
                new IntLiteralExpr(1),
                new IntLiteralExpr(10),
                new StatementBlock(List.of(
                        new IfStatement(
                                new BinaryExpr(
                                        new BinaryExpr(new IdentifierExpr("i"), "%", new IntLiteralExpr(2)),
                                        "==",
                                        new IntLiteralExpr(0)),
                                new StatementBlock(List.of(
                                        new AssignmentStatement("evenSum", "+=", new IdentifierExpr("i")))),
                                null))));

        loop.execute(runtime);
        assertEquals(30, runtime.getVariable("evenSum")); // 2+4+6+8+10 = 30
    }

    // =============================================================================
    // TIER 3: TRIGGERS TESTS
    // =============================================================================

    @Test
    void testSimpleTrigger() {
        runtime.defineGlobalVariable("keys", 0);
        runtime.defineGlobalVariable("triggered", false);

        // when (keys >= 3) { triggered = true }
        Trigger trigger = new Trigger(
                new BinaryExpr(new IdentifierExpr("keys"), ">=", new IntLiteralExpr(3)),
                new StatementBlock(List.of(
                        new AssignmentStatement("triggered", "=", new BoolLiteralExpr(true)))));

        runtime.registerTrigger(trigger);

        // Should not trigger yet
        runtime.checkTriggers();
        assertEquals(false, runtime.getVariable("triggered"));

        // Update variable
        runtime.setVariable("keys", 3);

        // Should trigger now
        runtime.checkTriggers();
        assertEquals(true, runtime.getVariable("triggered"));
    }

    @Test
    void testTriggerOnlyFiresOnce() {
        runtime.defineGlobalVariable("count", 0);
        runtime.defineGlobalVariable("fireCount", 0);

        // when (count >= 5) { fireCount += 1 }
        Trigger trigger = new Trigger(
                new BinaryExpr(new IdentifierExpr("count"), ">=", new IntLiteralExpr(5)),
                new StatementBlock(List.of(
                        new AssignmentStatement("fireCount", "+=", new IntLiteralExpr(1)))));

        runtime.registerTrigger(trigger);

        runtime.setVariable("count", 10);
        runtime.checkTriggers();
        assertEquals(1, runtime.getVariable("fireCount"));

        // Evaluate again - should not fire again
        runtime.checkTriggers();
        assertEquals(1, runtime.getVariable("fireCount"));
    }

    @Test
    void testMultipleTriggers() {
        runtime.defineGlobalVariable("score", 0);
        runtime.defineGlobalVariable("bronze", false);
        runtime.defineGlobalVariable("silver", false);
        runtime.defineGlobalVariable("gold", false);

        // when (score >= 100) { bronze = true }
        Trigger bronzeTrigger = new Trigger(
                new BinaryExpr(new IdentifierExpr("score"), ">=", new IntLiteralExpr(100)),
                new StatementBlock(List.of(
                        new AssignmentStatement("bronze", "=", new BoolLiteralExpr(true)))));

        // when (score >= 500) { silver = true }
        Trigger silverTrigger = new Trigger(
                new BinaryExpr(new IdentifierExpr("score"), ">=", new IntLiteralExpr(500)),
                new StatementBlock(List.of(
                        new AssignmentStatement("silver", "=", new BoolLiteralExpr(true)))));

        // when (score >= 1000) { gold = true }
        Trigger goldTrigger = new Trigger(
                new BinaryExpr(new IdentifierExpr("score"), ">=", new IntLiteralExpr(1000)),
                new StatementBlock(List.of(
                        new AssignmentStatement("gold", "=", new BoolLiteralExpr(true)))));

        runtime.registerTrigger(bronzeTrigger);
        runtime.registerTrigger(silverTrigger);
        runtime.registerTrigger(goldTrigger);

        // Score 600 - should trigger bronze and silver
        runtime.setVariable("score", 600);
        runtime.checkTriggers();

        assertEquals(true, runtime.getVariable("bronze"));
        assertEquals(true, runtime.getVariable("silver"));
        assertEquals(false, runtime.getVariable("gold"));
    }

    // =============================================================================
    // TIER 2: EVENT HANDLERS TESTS
    // =============================================================================

    @Test
    void testEventHandlerRegistration() {
        EventHandler handler = new EventHandler(
                EventType.ON_ENTER,
                new StatementBlock(List.of(
                        new AssignmentStatement("entered", "=", new BoolLiteralExpr(true)))),
                "test_room",
                "room");

        runtime.registerEventHandler(handler);

        // Handler is registered - verify by executing an event
        runtime.defineGlobalVariable("entered", false);
        runtime.fireEvent(EventType.ON_ENTER, "test_room");
        assertEquals(true, runtime.getVariable("entered"));
    }

    @Test
    void testEventHandlerExecution() {
        runtime.defineGlobalVariable("entered", false);
        runtime.defineGlobalVariable("score", 0);

        EventHandler handler = new EventHandler(
                EventType.ON_ENTER,
                new StatementBlock(List.of(
                        new AssignmentStatement("entered", "=", new BoolLiteralExpr(true)),
                        new AssignmentStatement("score", "+=", new IntLiteralExpr(10)))),
                "entrance",
                "room");

        runtime.registerEventHandler(handler);
        runtime.fireEvent(EventType.ON_ENTER, "entrance");

        assertEquals(true, runtime.getVariable("entered"));
        assertEquals(10, runtime.getVariable("score"));
    }

    @Test
    void testMultipleEventHandlersForSameEvent() {
        runtime.defineGlobalVariable("count", 0);

        EventHandler handler1 = new EventHandler(
                EventType.ON_PICKUP,
                new StatementBlock(List.of(
                        new AssignmentStatement("count", "+=", new IntLiteralExpr(1)))),
                "item1",
                "item");

        EventHandler handler2 = new EventHandler(
                EventType.ON_PICKUP,
                new StatementBlock(List.of(
                        new AssignmentStatement("count", "+=", new IntLiteralExpr(1)))),
                "item2",
                "item");

        runtime.registerEventHandler(handler1);
        runtime.registerEventHandler(handler2);

        runtime.fireEvent(EventType.ON_PICKUP, "item1");
        assertEquals(1, runtime.getVariable("count"));

        runtime.fireEvent(EventType.ON_PICKUP, "item2");
        assertEquals(2, runtime.getVariable("count"));
    }

    // =============================================================================
    // COMPOUND ASSIGNMENT TESTS
    // =============================================================================

    @Test
    void testCompoundAddition() {
        runtime.defineGlobalVariable("x", 10);
        AssignmentStatement stmt = new AssignmentStatement("x", "+=", new IntLiteralExpr(5));
        stmt.execute(runtime);
        assertEquals(15, runtime.getVariable("x"));
    }

    @Test
    void testCompoundSubtraction() {
        runtime.defineGlobalVariable("x", 10);
        AssignmentStatement stmt = new AssignmentStatement("x", "-=", new IntLiteralExpr(3));
        stmt.execute(runtime);
        assertEquals(7, runtime.getVariable("x"));
    }

    @Test
    void testCompoundMultiplication() {
        runtime.defineGlobalVariable("x", 10);
        AssignmentStatement stmt = new AssignmentStatement("x", "*=", new IntLiteralExpr(3));
        stmt.execute(runtime);
        assertEquals(30, runtime.getVariable("x"));
    }

    @Test
    void testCompoundDivision() {
        runtime.defineGlobalVariable("x", 20);
        AssignmentStatement stmt = new AssignmentStatement("x", "/=", new IntLiteralExpr(4));
        stmt.execute(runtime);
        assertEquals(5, runtime.getVariable("x"));
    }

    // =============================================================================
    // INTEGRATION TESTS - Complex scenarios
    // =============================================================================

    @Test
    void testComplexGameScenario() {
        // Setup game state
        runtime.defineGlobalVariable("score", 0);
        runtime.defineGlobalVariable("keysCollected", 0);
        runtime.defineGlobalVariable("requiredKeys", 3);
        runtime.defineGlobalVariable("allKeysFound", false);

        // Trigger: when (keysCollected >= requiredKeys) { allKeysFound = true }
        Trigger keyTrigger = new Trigger(
                new BinaryExpr(
                        new IdentifierExpr("keysCollected"),
                        ">=",
                        new IdentifierExpr("requiredKeys")),
                new StatementBlock(List.of(
                        new AssignmentStatement("allKeysFound", "=", new BoolLiteralExpr(true)))));
        runtime.registerTrigger(keyTrigger);

        // Collect keys with a loop
        RepeatStatement collectKeys = new RepeatStatement(
                new IntLiteralExpr(3),
                new StatementBlock(List.of(
                        new AssignmentStatement("keysCollected", "+=", new IntLiteralExpr(1)),
                        new AssignmentStatement("score", "+=", new IntLiteralExpr(100)))));

        collectKeys.execute(runtime);
        runtime.checkTriggers();

        assertEquals(3, runtime.getVariable("keysCollected"));
        assertEquals(300, runtime.getVariable("score"));
        assertEquals(true, runtime.getVariable("allKeysFound"));
    }
}
