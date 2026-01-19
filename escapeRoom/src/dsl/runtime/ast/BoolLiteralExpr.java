package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/** Literal expression for boolean values. */
public class BoolLiteralExpr implements Expression {
  private final boolean value;

  public BoolLiteralExpr(boolean value) {
    this.value = value;
  }

  @Override
  public Object evaluate(DSLRuntime runtime) {
    return value;
  }

  public boolean getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
