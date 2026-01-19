package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/** Assignment statement for setting variable or property values. Supports: =, +=, -=, *=, /= */
public class AssignmentStatement implements Statement {
  private final String variableName;
  private final String propertyPath; // null for simple variables, "player.health" for properties
  private final String operator;
  private final Expression value;

  /** Create a simple variable assignment. */
  public AssignmentStatement(String variableName, String operator, Expression value) {
    this.variableName = variableName;
    this.propertyPath = null;
    this.operator = operator;
    this.value = value;
  }

  /** Create a property assignment (e.g., player.health = 100). */
  public AssignmentStatement(
      String variableName, String propertyPath, String operator, Expression value) {
    this.variableName = variableName;
    this.propertyPath = propertyPath;
    this.operator = operator;
    this.value = value;
  }

  @Override
  public void execute(DSLRuntime runtime) {
    Object newValue = value.evaluate(runtime);
    String fullPath = propertyPath != null ? propertyPath : variableName;

    // Handle compound assignment operators
    if (!operator.equals("=")) {
      Object currentValue =
          propertyPath != null
              ? runtime.getPropertyByPath(propertyPath)
              : runtime.getVariable(variableName);

      if (currentValue == null) {
        throw new RuntimeException(
            "Cannot apply '" + operator + "' to undefined variable: " + fullPath);
      }

      newValue = applyCompoundOperator(currentValue, operator, newValue);
    }

    // Set the value
    if (propertyPath != null) {
      runtime.setPropertyByPath(propertyPath, newValue);
    } else {
      runtime.setVariable(variableName, newValue);
    }
  }

  private Object applyCompoundOperator(Object current, String op, Object operand) {
    if (!(current instanceof Number) || !(operand instanceof Number)) {
      if (op.equals("+=") && current instanceof String) {
        return current.toString() + operand.toString();
      }
      throw new RuntimeException("Compound assignment requires numeric values for operator: " + op);
    }

    double currentNum = ((Number) current).doubleValue();
    double operandNum = ((Number) operand).doubleValue();
    double result;

    switch (op) {
      case "+=":
        result = currentNum + operandNum;
        break;
      case "-=":
        result = currentNum - operandNum;
        break;
      case "*=":
        result = currentNum * operandNum;
        break;
      case "/=":
        if (operandNum == 0) {
          throw new RuntimeException("Division by zero");
        }
        result = currentNum / operandNum;
        break;
      default:
        throw new RuntimeException("Unknown compound operator: " + op);
    }

    // Preserve integer type if both operands were integers
    if (current instanceof Integer && operand instanceof Integer && result == Math.floor(result)) {
      return (int) result;
    }
    return result;
  }

  public String getVariableName() {
    return variableName;
  }

  public String getPropertyPath() {
    return propertyPath;
  }

  public String getOperator() {
    return operator;
  }

  public Expression getValue() {
    return value;
  }

  @Override
  public String toString() {
    String target = propertyPath != null ? propertyPath : variableName;
    return target + " " + operator + " " + value;
  }
}
