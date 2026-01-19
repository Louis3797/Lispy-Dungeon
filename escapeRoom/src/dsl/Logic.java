package dsl;

import dsl.runtime.ast.Expression;
import java.util.Map;

public class Logic {
  public String winCondition; // Simplified as string for now, or AST node
  public Expression winConditionExpression;
  public Map<String, String> dependencies;
  public Map<String, Object> stateVariables;
  public Map<String, Object> timers;
}
