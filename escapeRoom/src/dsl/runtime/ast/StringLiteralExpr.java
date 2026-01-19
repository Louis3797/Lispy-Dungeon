package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/** Literal expression for string values. */
public class StringLiteralExpr implements Expression {
  private final String value;

  public StringLiteralExpr(String value) {
    this.value = value;
  }

  @Override
  public Object evaluate(DSLRuntime runtime) {
    return value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "\"" + value + "\"";
  }
}
