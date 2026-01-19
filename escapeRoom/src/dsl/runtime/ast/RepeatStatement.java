package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/**
 * Repeat statement for loops. Supports two forms: 1. repeat N { ... } - Execute N times 2. repeat i
 * from start to end { ... } - Execute with loop variable
 */
public class RepeatStatement implements Statement {
  private final String loopVariable; // null for simple repeat
  private final Expression startExpr; // null for simple repeat (uses 0)
  private final Expression endExpr; // The count or end value
  private final StatementBlock body;

  /** Create a simple repeat (repeat N times). */
  public RepeatStatement(Expression count, StatementBlock body) {
    this.loopVariable = null;
    this.startExpr = null;
    this.endExpr = count;
    this.body = body;
  }

  /** Create a range repeat (repeat i from start to end). */
  public RepeatStatement(
      String loopVariable, Expression startExpr, Expression endExpr, StatementBlock body) {
    this.loopVariable = loopVariable;
    this.startExpr = startExpr;
    this.endExpr = endExpr;
    this.body = body;
  }

  @Override
  public void execute(DSLRuntime runtime) {
    if (loopVariable == null) {
      // Simple repeat N times
      Object countValue = endExpr.evaluate(runtime);
      if (!(countValue instanceof Number)) {
        throw new RuntimeException(
            "Repeat count must be a number, got: "
                + (countValue != null ? countValue.getClass().getSimpleName() : "null"));
      }
      int count = ((Number) countValue).intValue();

      for (int i = 0; i < count; i++) {
        body.execute(runtime);
      }
    } else {
      // Range repeat with loop variable
      Object startValue = startExpr.evaluate(runtime);
      Object endValue = endExpr.evaluate(runtime);

      if (!(startValue instanceof Number) || !(endValue instanceof Number)) {
        throw new RuntimeException("Repeat range values must be numbers");
      }

      int start = ((Number) startValue).intValue();
      int end = ((Number) endValue).intValue();

      // Create a new scope for the loop variable
      runtime.pushScope();
      try {
        for (int i = start; i <= end; i++) {
          runtime.setVariable(loopVariable, i);
          body.execute(runtime);
        }
      } finally {
        runtime.popScope();
      }
    }
  }

  public String getLoopVariable() {
    return loopVariable;
  }

  public Expression getStartExpr() {
    return startExpr;
  }

  public Expression getEndExpr() {
    return endExpr;
  }

  public StatementBlock getBody() {
    return body;
  }

  @Override
  public String toString() {
    if (loopVariable == null) {
      return "repeat " + endExpr + " " + body;
    } else {
      return "repeat " + loopVariable + " from " + startExpr + " to " + endExpr + " " + body;
    }
  }
}
