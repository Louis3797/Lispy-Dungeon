package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/** Base interface for all DSL statements. Statements perform actions but don't return values. */
public interface Statement {
  /**
   * Execute this statement in the given runtime context.
   *
   * @param runtime The runtime environment containing variables and functions
   */
  void execute(DSLRuntime runtime);
}
