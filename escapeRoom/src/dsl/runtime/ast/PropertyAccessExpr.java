package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/** Expression for property access (e.g., player.health, room.width). */
public class PropertyAccessExpr implements Expression {
  private final Expression target;
  private final String property;

  public PropertyAccessExpr(Expression target, String property) {
    this.target = target;
    this.property = property;
  }

  @Override
  public Object evaluate(DSLRuntime runtime) {
    Object targetValue = target.evaluate(runtime);
    return runtime.getProperty(targetValue, property);
  }

  public Expression getTarget() {
    return target;
  }

  public String getProperty() {
    return property;
  }

  /** Get the full property path as a string (e.g., "player.health"). */
  public String getFullPath() {
    if (target instanceof IdentifierExpr) {
      return ((IdentifierExpr) target).getName() + "." + property;
    } else if (target instanceof PropertyAccessExpr) {
      return ((PropertyAccessExpr) target).getFullPath() + "." + property;
    }
    return "?" + "." + property;
  }

  @Override
  public String toString() {
    return target.toString() + "." + property;
  }
}
