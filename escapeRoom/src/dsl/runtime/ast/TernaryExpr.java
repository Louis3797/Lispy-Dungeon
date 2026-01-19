package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/**
 * Ternary/conditional expression (if-else expression). Example: if (condition) trueValue else
 * falseValue
 */
public class TernaryExpr implements Expression {
  private final Expression condition;
  private final Expression thenExpr;
  private final Expression elseExpr;

  public TernaryExpr(Expression condition, Expression thenExpr, Expression elseExpr) {
    this.condition = condition;
    this.thenExpr = thenExpr;
    this.elseExpr = elseExpr;
  }

  @Override
  public Object evaluate(DSLRuntime runtime) {
    Object condValue = condition.evaluate(runtime);

    if (!(condValue instanceof Boolean)) {
      throw new RuntimeException(
          "Condition must be boolean, got: "
              + (condValue != null ? condValue.getClass().getSimpleName() : "null"));
    }

    if ((Boolean) condValue) {
      return thenExpr.evaluate(runtime);
    } else {
      return elseExpr.evaluate(runtime);
    }
  }

  public Expression getCondition() {
    return condition;
  }

  public Expression getThenExpr() {
    return thenExpr;
  }

  public Expression getElseExpr() {
    return elseExpr;
  }

  @Override
  public String toString() {
    return "if (" + condition + ") " + thenExpr + " else " + elseExpr;
  }
}
