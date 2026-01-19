package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;
import java.util.ArrayList;
import java.util.List;

/**
 * Function call statement (function call without using the return value). Example:
 * show_message("Hello"), play_sound("click")
 */
public class FunctionCallStatement implements Statement {
  private final String functionName;
  private final List<Expression> arguments;

  public FunctionCallStatement(String functionName, List<Expression> arguments) {
    this.functionName = functionName;
    this.arguments = arguments != null ? arguments : new ArrayList<>();
  }

  @Override
  public void execute(DSLRuntime runtime) {
    List<Object> evaluatedArgs = new ArrayList<>();
    for (Expression arg : arguments) {
      evaluatedArgs.add(arg.evaluate(runtime));
    }
    runtime.callFunction(functionName, evaluatedArgs);
  }

  public String getFunctionName() {
    return functionName;
  }

  public List<Expression> getArguments() {
    return arguments;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(functionName);
    sb.append("(");
    for (int i = 0; i < arguments.size(); i++) {
      if (i > 0) sb.append(", ");
      sb.append(arguments.get(i));
    }
    sb.append(")");
    return sb.toString();
  }
}
