package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;
import java.util.ArrayList;
import java.util.List;

/** Literal expression for array values. */
public class ArrayLiteralExpr implements Expression {
  private final List<Expression> elements;

  public ArrayLiteralExpr(List<Expression> elements) {
    this.elements = elements != null ? elements : new ArrayList<>();
  }

  @Override
  public Object evaluate(DSLRuntime runtime) {
    List<Object> result = new ArrayList<>();
    for (Expression element : elements) {
      result.add(element.evaluate(runtime));
    }
    return result;
  }

  public List<Expression> getElements() {
    return elements;
  }

  @Override
  public String toString() {
    return elements.toString();
  }
}
