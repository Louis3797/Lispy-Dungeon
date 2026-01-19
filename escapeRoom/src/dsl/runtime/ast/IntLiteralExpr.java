package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/** Literal expression for integer values. */
public class IntLiteralExpr implements Expression {
  private final int value;

  public IntLiteralExpr(int value) {
    this.value = value;
  }

  @Override
  public Object evaluate(DSLRuntime runtime) {
    return value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
