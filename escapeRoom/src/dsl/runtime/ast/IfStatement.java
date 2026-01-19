package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/**
 * If statement for conditional execution. Supports optional else branch (which can be another
 * IfStatement for else-if chains).
 */
public class IfStatement implements Statement {
  private final Expression condition;
  private final StatementBlock thenBlock;
  private final Statement elseBlock; // Can be StatementBlock or another IfStatement

  public IfStatement(Expression condition, StatementBlock thenBlock, Statement elseBlock) {
    this.condition = condition;
    this.thenBlock = thenBlock;
    this.elseBlock = elseBlock;
  }

  @Override
  public void execute(DSLRuntime runtime) {
    Object condValue = condition.evaluate(runtime);

    if (!(condValue instanceof Boolean)) {
      throw new RuntimeException(
          "If condition must be boolean, got: "
              + (condValue != null ? condValue.getClass().getSimpleName() : "null"));
    }

    if ((Boolean) condValue) {
      thenBlock.execute(runtime);
    } else if (elseBlock != null) {
      elseBlock.execute(runtime);
    }
  }

  public Expression getCondition() {
    return condition;
  }

  public StatementBlock getThenBlock() {
    return thenBlock;
  }

  public Statement getElseBlock() {
    return elseBlock;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("if (");
    sb.append(condition).append(") ");
    sb.append(thenBlock);
    if (elseBlock != null) {
      sb.append(" else ").append(elseBlock);
    }
    return sb.toString();
  }
}
