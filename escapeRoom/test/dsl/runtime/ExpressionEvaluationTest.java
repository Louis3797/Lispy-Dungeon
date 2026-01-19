package dsl.runtime;

import static org.junit.jupiter.api.Assertions.*;

import dsl.runtime.ast.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive tests for Expression evaluation in the DSL Runtime.
 * Tests all expression types and edge cases.
 */
public class ExpressionEvaluationTest {

    private DSLRuntime runtime;

    @BeforeEach
    void setUp() {
        runtime = new DSLRuntime();
    }

    // =============================================================================
    // LITERAL TESTS
    // =============================================================================

    @Test
    void testIntegerLiterals() {
        assertEquals(0, new IntLiteralExpr(0).evaluate(runtime));
        assertEquals(42, new IntLiteralExpr(42).evaluate(runtime));
        assertEquals(-10, new IntLiteralExpr(-10).evaluate(runtime));
        assertEquals(1000000, new IntLiteralExpr(1000000).evaluate(runtime));
    }

    @Test
    void testFloatLiterals() {
        assertEquals(0.0, new FloatLiteralExpr(0.0).evaluate(runtime));
        assertEquals(3.14, new FloatLiteralExpr(3.14).evaluate(runtime));
        assertEquals(-2.5, new FloatLiteralExpr(-2.5).evaluate(runtime));
        assertEquals(1.5e10, new FloatLiteralExpr(1.5e10).evaluate(runtime));
    }

    @Test
    void testStringLiterals() {
        assertEquals("", new StringLiteralExpr("").evaluate(runtime));
        assertEquals("hello", new StringLiteralExpr("hello").evaluate(runtime));
        assertEquals("Hello World!", new StringLiteralExpr("Hello World!").evaluate(runtime));
        assertEquals("123", new StringLiteralExpr("123").evaluate(runtime));
    }

    @Test
    void testBooleanLiterals() {
        assertEquals(true, new BoolLiteralExpr(true).evaluate(runtime));
        assertEquals(false, new BoolLiteralExpr(false).evaluate(runtime));
    }

    // =============================================================================
    // IDENTIFIER TESTS
    // =============================================================================

    @Test
    void testIdentifierWithGlobalVariable() {
        runtime.defineGlobalVariable("myVar", 123);
        assertEquals(123, new IdentifierExpr("myVar").evaluate(runtime));
    }

    @Test
    @DisplayName("Global variable access")
    void testGlobalVariableAccess() {
        runtime.defineGlobalVariable("globalVar", "test");
        assertEquals("test", runtime.getVariable("globalVar"));
    }

    @Test
    void testIdentifierNotFound() {
        // Should throw exception or return null - test runtime behavior
        assertThrows(RuntimeException.class, () -> {
            new IdentifierExpr("nonExistent").evaluate(runtime);
        });
    }

    // =============================================================================
    // ARITHMETIC OPERATIONS
    // =============================================================================

    @Test
    void testAdditionIntegers() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(10),
                "+",
                new IntLiteralExpr(5));
        assertEquals(15, expr.evaluate(runtime));
    }

    @Test
    void testAdditionFloats() {
        BinaryExpr expr = new BinaryExpr(
                new FloatLiteralExpr(1.5),
                "+",
                new FloatLiteralExpr(2.5));
        assertEquals(4.0, expr.evaluate(runtime));
    }

    @Test
    void testAdditionMixedTypes() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(10),
                "+",
                new FloatLiteralExpr(2.5));
        // Result should be 12.5 as double
        Object result = expr.evaluate(runtime);
        assertTrue(result instanceof Number);
        assertEquals(12.5, ((Number) result).doubleValue(), 0.001);
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
    void testMultiplicationWithFloat() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(10),
                "*",
                new FloatLiteralExpr(1.5));
        assertEquals(15.0, ((Number) expr.evaluate(runtime)).doubleValue(), 0.001);
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
    void testDivisionByZero() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(10),
                "/",
                new IntLiteralExpr(0));
        assertThrows(ArithmeticException.class, () -> expr.evaluate(runtime));
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
    void testNegativeModulo() {
        BinaryExpr expr = new BinaryExpr(
                new IntLiteralExpr(-10),
                "%",
                new IntLiteralExpr(3));
        Object result = expr.evaluate(runtime);
        assertTrue(result instanceof Number);
    }

    // =============================================================================
    // COMPARISON OPERATIONS
    // =============================================================================

    @Test
    void testEqualityIntegers() {
        assertTrue((Boolean) new BinaryExpr(
                new IntLiteralExpr(5),
                "==",
                new IntLiteralExpr(5)).evaluate(runtime));

        assertFalse((Boolean) new BinaryExpr(
                new IntLiteralExpr(5),
                "==",
                new IntLiteralExpr(3)).evaluate(runtime));
    }

    @Test
    void testEqualityStrings() {
        assertTrue((Boolean) new BinaryExpr(
                new StringLiteralExpr("hello"),
                "==",
                new StringLiteralExpr("hello")).evaluate(runtime));

        assertFalse((Boolean) new BinaryExpr(
                new StringLiteralExpr("hello"),
                "==",
                new StringLiteralExpr("world")).evaluate(runtime));
    }

    @Test
    void testEqualityBooleans() {
        assertTrue((Boolean) new BinaryExpr(
                new BoolLiteralExpr(true),
                "==",
                new BoolLiteralExpr(true)).evaluate(runtime));

        assertFalse((Boolean) new BinaryExpr(
                new BoolLiteralExpr(true),
                "==",
                new BoolLiteralExpr(false)).evaluate(runtime));
    }

    @Test
    void testInequality() {
        assertTrue((Boolean) new BinaryExpr(
                new IntLiteralExpr(5),
                "!=",
                new IntLiteralExpr(3)).evaluate(runtime));

        assertFalse((Boolean) new BinaryExpr(
                new IntLiteralExpr(5),
                "!=",
                new IntLiteralExpr(5)).evaluate(runtime));
    }

    @Test
    void testGreaterThan() {
        assertTrue((Boolean) new BinaryExpr(
                new IntLiteralExpr(10),
                ">",
                new IntLiteralExpr(5)).evaluate(runtime));

        assertFalse((Boolean) new BinaryExpr(
                new IntLiteralExpr(5),
                ">",
                new IntLiteralExpr(10)).evaluate(runtime));

        assertFalse((Boolean) new BinaryExpr(
                new IntLiteralExpr(5),
                ">",
                new IntLiteralExpr(5)).evaluate(runtime));
    }

    @Test
    void testLessThan() {
        assertTrue((Boolean) new BinaryExpr(
                new IntLiteralExpr(3),
                "<",
                new IntLiteralExpr(7)).evaluate(runtime));

        assertFalse((Boolean) new BinaryExpr(
                new IntLiteralExpr(7),
                "<",
                new IntLiteralExpr(3)).evaluate(runtime));
    }

    @Test
    void testGreaterOrEqual() {
        assertTrue((Boolean) new BinaryExpr(
                new IntLiteralExpr(5),
                ">=",
                new IntLiteralExpr(5)).evaluate(runtime));

        assertTrue((Boolean) new BinaryExpr(
                new IntLiteralExpr(10),
                ">=",
                new IntLiteralExpr(5)).evaluate(runtime));

        assertFalse((Boolean) new BinaryExpr(
                new IntLiteralExpr(3),
                ">=",
                new IntLiteralExpr(5)).evaluate(runtime));
    }

    @Test
    void testLessOrEqual() {
        assertTrue((Boolean) new BinaryExpr(
                new IntLiteralExpr(4),
                "<=",
                new IntLiteralExpr(7)).evaluate(runtime));

        assertTrue((Boolean) new BinaryExpr(
                new IntLiteralExpr(7),
                "<=",
                new IntLiteralExpr(7)).evaluate(runtime));
    }

    // =============================================================================
    // LOGICAL OPERATIONS
    // =============================================================================

    @Test
    void testLogicalAnd() {
        assertTrue((Boolean) new BinaryExpr(
                new BoolLiteralExpr(true),
                "&&",
                new BoolLiteralExpr(true)).evaluate(runtime));

        assertFalse((Boolean) new BinaryExpr(
                new BoolLiteralExpr(true),
                "&&",
                new BoolLiteralExpr(false)).evaluate(runtime));

        assertFalse((Boolean) new BinaryExpr(
                new BoolLiteralExpr(false),
                "&&",
                new BoolLiteralExpr(false)).evaluate(runtime));
    }

    @Test
    void testLogicalOr() {
        assertTrue((Boolean) new BinaryExpr(
                new BoolLiteralExpr(true),
                "||",
                new BoolLiteralExpr(false)).evaluate(runtime));

        assertTrue((Boolean) new BinaryExpr(
                new BoolLiteralExpr(false),
                "||",
                new BoolLiteralExpr(true)).evaluate(runtime));

        assertFalse((Boolean) new BinaryExpr(
                new BoolLiteralExpr(false),
                "||",
                new BoolLiteralExpr(false)).evaluate(runtime));
    }

    @Test
    void testLogicalNot() {
        assertEquals(false, new UnaryExpr(
                "!",
                new BoolLiteralExpr(true)).evaluate(runtime));

        assertEquals(true, new UnaryExpr(
                "!",
                new BoolLiteralExpr(false)).evaluate(runtime));
    }

    @Test
    void testDoubleNegation() {
        UnaryExpr expr = new UnaryExpr(
                "!",
                new UnaryExpr("!", new BoolLiteralExpr(true)));
        assertEquals(true, expr.evaluate(runtime));
    }

    // =============================================================================
    // STRING OPERATIONS
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
    void testStringConcatenationWithInteger() {
        BinaryExpr expr = new BinaryExpr(
                new StringLiteralExpr("Score: "),
                "+",
                new IntLiteralExpr(100));
        assertEquals("Score: 100", expr.evaluate(runtime));
    }

    @Test
    void testStringConcatenationWithFloat() {
        BinaryExpr expr = new BinaryExpr(
                new StringLiteralExpr("Value: "),
                "+",
                new FloatLiteralExpr(3.14));
        assertEquals("Value: 3.14", expr.evaluate(runtime));
    }

    @Test
    void testStringConcatenationWithBoolean() {
        BinaryExpr expr = new BinaryExpr(
                new StringLiteralExpr("Active: "),
                "+",
                new BoolLiteralExpr(true));
        assertEquals("Active: true", expr.evaluate(runtime));
    }

    @Test
    void testMultipleStringConcatenation() {
        // "Hello" + " " + "World"
        BinaryExpr expr = new BinaryExpr(
                new BinaryExpr(
                        new StringLiteralExpr("Hello"),
                        "+",
                        new StringLiteralExpr(" ")),
                "+",
                new StringLiteralExpr("World"));
        assertEquals("Hello World", expr.evaluate(runtime));
    }

    // =============================================================================
    // COMPLEX EXPRESSIONS
    // =============================================================================

    @Test
    void testComplexArithmeticExpression() {
        // (10 + 5) * 2 - 3 = 27
        BinaryExpr expr = new BinaryExpr(
                new BinaryExpr(
                        new BinaryExpr(
                                new IntLiteralExpr(10),
                                "+",
                                new IntLiteralExpr(5)),
                        "*",
                        new IntLiteralExpr(2)),
                "-",
                new IntLiteralExpr(3));
        assertEquals(27, expr.evaluate(runtime));
    }

    @Test
    void testComplexLogicalExpression() {
        // (true && false) || (true && true) = true
        BinaryExpr expr = new BinaryExpr(
                new BinaryExpr(
                        new BoolLiteralExpr(true),
                        "&&",
                        new BoolLiteralExpr(false)),
                "||",
                new BinaryExpr(
                        new BoolLiteralExpr(true),
                        "&&",
                        new BoolLiteralExpr(true)));
        assertEquals(true, expr.evaluate(runtime));
    }

    @Test
    void testComplexComparisonExpression() {
        // (10 > 5) && (20 < 30)
        BinaryExpr expr = new BinaryExpr(
                new BinaryExpr(
                        new IntLiteralExpr(10),
                        ">",
                        new IntLiteralExpr(5)),
                "&&",
                new BinaryExpr(
                        new IntLiteralExpr(20),
                        "<",
                        new IntLiteralExpr(30)));
        assertEquals(true, expr.evaluate(runtime));
    }

    @Test
    void testExpressionWithVariables() {
        runtime.defineGlobalVariable("x", 10);
        runtime.defineGlobalVariable("y", 20);

        // x + y * 2 = 50
        BinaryExpr expr = new BinaryExpr(
                new IdentifierExpr("x"),
                "+",
                new BinaryExpr(
                        new IdentifierExpr("y"),
                        "*",
                        new IntLiteralExpr(2)));
        assertEquals(50, expr.evaluate(runtime));
    }

    @Test
    void testDeeplyNestedExpression() {
        // ((10 + 5) * (3 - 1)) / 2 = 15
        BinaryExpr expr = new BinaryExpr(
                new BinaryExpr(
                        new BinaryExpr(
                                new IntLiteralExpr(10),
                                "+",
                                new IntLiteralExpr(5)),
                        "*",
                        new BinaryExpr(
                                new IntLiteralExpr(3),
                                "-",
                                new IntLiteralExpr(1))),
                "/",
                new IntLiteralExpr(2));
        assertEquals(15, expr.evaluate(runtime));
    }

    // =============================================================================
    // EDGE CASES
    // =============================================================================

    @Test
    void testZeroValues() {
        assertEquals(0, new IntLiteralExpr(0).evaluate(runtime));
        assertEquals(0.0, new FloatLiteralExpr(0.0).evaluate(runtime));
        assertEquals("", new StringLiteralExpr("").evaluate(runtime));
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(-42, new IntLiteralExpr(-42).evaluate(runtime));
        assertEquals(-3.14, new FloatLiteralExpr(-3.14).evaluate(runtime));
    }

    @Test
    void testLargeNumbers() {
        assertEquals(1000000, new IntLiteralExpr(1000000).evaluate(runtime));
        assertEquals(1.5e10, new FloatLiteralExpr(1.5e10).evaluate(runtime));
    }

    @Test
    void testUnaryMinus() {
        UnaryExpr expr = new UnaryExpr(
                "-",
                new IntLiteralExpr(42));
        assertEquals(-42, expr.evaluate(runtime));
    }

    @Test
    void testUnaryMinusWithExpression() {
        UnaryExpr expr = new UnaryExpr(
                "-",
                new BinaryExpr(
                        new IntLiteralExpr(10),
                        "+",
                        new IntLiteralExpr(5)));
        assertEquals(-15, expr.evaluate(runtime));
    }
}
