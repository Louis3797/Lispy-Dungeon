package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/** Unary expression for negation and logical NOT. */
public class UnaryExpr implements Expression {
  private final String operator;
  private final Expression operand;

  public UnaryExpr(String operator, Expression operand) {
    this.operator = operator;
    this.operand = operand;
  }

  @Override
  public Object evaluate(DSLRuntime runtime) {
    Object value = operand.evaluate(runtime);

    switch (operator) {
      case "-":
        if (value instanceof Integer) {
          return -((Integer) value);
        } else if (value instanceof Double) {
          return -((Double) value);
        } else if (value instanceof Number) {
          return -((Number) value).doubleValue();
        }
        throw new RuntimeException("Cannot negate non-numeric value: " + value);

      case "!":
        if (value instanceof Boolean) {
          return !((Boolean) value);
        }
        throw new RuntimeException("Cannot apply '!' to non-boolean value: " + value);

      default:
        throw new RuntimeException("Unknown unary operator: " + operator);
    }
  }

  public String getOperator() {
    return operator;
  }

  public Expression getOperand() {
    return operand;
  }

  @Override
  public String toString() {
    return operator + operand;
  }
}
