package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/** Literal expression for floating-point values. */
public class FloatLiteralExpr implements Expression {
  private final double value;

  public FloatLiteralExpr(double value) {
    this.value = value;
  }

  @Override
  public Object evaluate(DSLRuntime runtime) {
    return value;
  }

  public double getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
