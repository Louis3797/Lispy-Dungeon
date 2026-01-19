package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/** Binary expression for arithmetic and comparison operations. */
public class BinaryExpr implements Expression {
  private final Expression left;
  private final String operator;
  private final Expression right;

  public BinaryExpr(Expression left, String operator, Expression right) {
    this.left = left;
    this.operator = operator;
    this.right = right;
  }

  @Override
  public Object evaluate(DSLRuntime runtime) {
    Object leftVal = left.evaluate(runtime);
    Object rightVal = right.evaluate(runtime);

    // Handle string concatenation
    if ("+".equals(operator) && (leftVal instanceof String || rightVal instanceof String)) {
      return String.valueOf(leftVal) + String.valueOf(rightVal);
    }

    // Numeric operations
    if (isNumeric(leftVal) && isNumeric(rightVal)) {
      double leftNum = toDouble(leftVal);
      double rightNum = toDouble(rightVal);

      switch (operator) {
        case "+":
          return simplify(leftNum + rightNum, leftVal, rightVal);
        case "-":
          return simplify(leftNum - rightNum, leftVal, rightVal);
        case "*":
          return simplify(leftNum * rightNum, leftVal, rightVal);
        case "/":
          if (rightNum == 0) {
            throw new RuntimeException("Division by zero");
          }
          return simplify(leftNum / rightNum, leftVal, rightVal);
        case "%":
          return simplify(leftNum % rightNum, leftVal, rightVal);
        case "<":
          return leftNum < rightNum;
        case ">":
          return leftNum > rightNum;
        case "<=":
          return leftNum <= rightNum;
        case ">=":
          return leftNum >= rightNum;
        case "==":
          return leftNum == rightNum;
        case "!=":
          return leftNum != rightNum;
        default:
          throw new RuntimeException("Unknown operator: " + operator);
      }
    }

    // Boolean operations
    if (leftVal instanceof Boolean && rightVal instanceof Boolean) {
      boolean leftBool = (Boolean) leftVal;
      boolean rightBool = (Boolean) rightVal;

      switch (operator) {
        case "&&":
          return leftBool && rightBool;
        case "||":
          return leftBool || rightBool;
        case "==":
          return leftBool == rightBool;
        case "!=":
          return leftBool != rightBool;
        default:
          throw new RuntimeException("Invalid operator for boolean: " + operator);
      }
    }

    // Equality for other types
    if ("==".equals(operator)) {
      return leftVal == null ? rightVal == null : leftVal.equals(rightVal);
    }
    if ("!=".equals(operator)) {
      return leftVal == null ? rightVal != null : !leftVal.equals(rightVal);
    }

    throw new RuntimeException(
        "Cannot apply operator '"
            + operator
            + "' to "
            + (leftVal != null ? leftVal.getClass().getSimpleName() : "null")
            + " and "
            + (rightVal != null ? rightVal.getClass().getSimpleName() : "null"));
  }

  private boolean isNumeric(Object value) {
    return value instanceof Number;
  }

  private double toDouble(Object value) {
    return ((Number) value).doubleValue();
  }

  /** Simplify the result to Integer if both operands were integers and result is whole. */
  private Object simplify(double result, Object left, Object right) {
    if (left instanceof Integer && right instanceof Integer && result == Math.floor(result)) {
      return (int) result;
    }
    return result;
  }

  public Expression getLeft() {
    return left;
  }

  public String getOperator() {
    return operator;
  }

  public Expression getRight() {
    return right;
  }

  @Override
  public String toString() {
    return "(" + left + " " + operator + " " + right + ")";
  }
}
