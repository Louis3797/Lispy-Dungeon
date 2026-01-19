package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/** Expression for variable/identifier references. */
public class IdentifierExpr implements Expression {
  private final String name;

  public IdentifierExpr(String name) {
    this.name = name;
  }

  @Override
  public Object evaluate(DSLRuntime runtime) {
    return runtime.getVariable(name);
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name;
  }
}
