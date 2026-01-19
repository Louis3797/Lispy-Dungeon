package dsl.runtime.ast;

import dsl.runtime.DSLRuntime;
import java.util.ArrayList;
import java.util.List;

/** A block of statements to execute sequentially. */
public class StatementBlock implements Statement {
  private final List<Statement> statements;

  public StatementBlock(List<Statement> statements) {
    this.statements = statements != null ? statements : new ArrayList<>();
  }

  @Override
  public void execute(DSLRuntime runtime) {
    for (Statement statement : statements) {
      statement.execute(runtime);
    }
  }

  public List<Statement> getStatements() {
    return statements;
  }

  public void addStatement(Statement statement) {
    statements.add(statement);
  }

  public boolean isEmpty() {
    return statements.isEmpty();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("{\n");
    for (Statement stmt : statements) {
      sb.append("  ").append(stmt).append("\n");
    }
    sb.append("}");
    return sb.toString();
  }
}
