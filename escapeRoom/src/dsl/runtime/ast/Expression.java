package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;

/** Base interface for all DSL expressions. Expressions evaluate to a value. */
public interface Expression {
  /**
   * Evaluate this expression in the given runtime context.
   *
   * @param runtime The runtime environment containing variables and functions
   * @return The evaluated value (can be Integer, Double, String, Boolean, or List)
   */
  Object evaluate(DSLRuntime runtime);
}
