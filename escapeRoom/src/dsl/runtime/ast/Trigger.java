package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/**
 * Represents a global trigger that monitors a condition and executes when it becomes true. Example:
 * when (keysCollected >= 3) { unlock("boss_room") }
 */
public class Trigger {
  private final Expression condition;
  private final StatementBlock body;
  private boolean hasFired; // Prevents repeated firing

  public Trigger(Expression condition, StatementBlock body) {
    this.condition = condition;
    this.body = body;
    this.hasFired = false;
  }

  /**
   * Check if the condition is met and execute if it is (and hasn't fired yet).
   *
   * @param runtime The runtime context
   * @return true if the trigger fired, false otherwise
   */
  public boolean checkAndFire(DSLRuntime runtime) {
    if (hasFired) {
      return false;
    }

    try {
      Object condValue = condition.evaluate(runtime);

      if (!(condValue instanceof Boolean)) {
        return false; // Non-boolean conditions are ignored
      }

      if ((Boolean) condValue) {
        hasFired = true;
        body.execute(runtime);
        return true;
      }
    } catch (Exception e) {
      // Silently ignore evaluation errors in triggers
      // (variables might not exist yet)
    }

    return false;
  }

  /** Reset the trigger so it can fire again. */
  public void reset() {
    this.hasFired = false;
  }

  public Expression getCondition() {
    return condition;
  }

  public StatementBlock getBody() {
    return body;
  }

  public boolean hasFired() {
    return hasFired;
  }

  @Override
  public String toString() {
    return "when (" + condition + ") " + body;
  }
}
