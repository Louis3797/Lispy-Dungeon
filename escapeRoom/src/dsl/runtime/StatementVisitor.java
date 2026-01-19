package dsl.runtime;

import dsl.parser.EscapeRoomDSLBaseVisitor;
import dsl.parser.EscapeRoomDSLParser;
import dsl.runtime.ast.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Visitor for parsing DSL statements into AST nodes. This visitor returns Statement objects that
 * can be executed at runtime.
 */
public class StatementVisitor extends EscapeRoomDSLBaseVisitor<Statement> {

  private final ExpressionVisitor expressionVisitor = new ExpressionVisitor();

  // ========================================================================
  // Statement Block
  // ========================================================================

  /** Parse a statement block into a StatementBlock object. */
  public StatementBlock parseStatementBlock(EscapeRoomDSLParser.Statement_blockContext ctx) {
    List<Statement> statements = new ArrayList<>();
    if (ctx != null && ctx.statement() != null) {
      for (var stmtCtx : ctx.statement()) {
        Statement stmt = visit(stmtCtx);
        if (stmt != null) {
          statements.add(stmt);
        }
      }
    }
    return new StatementBlock(statements);
  }

  // ========================================================================
  // Individual Statements
  // ========================================================================

  @Override
  public Statement visitStatement(EscapeRoomDSLParser.StatementContext ctx) {
    if (ctx.assignment_statement() != null) {
      return visitAssignment_statement(ctx.assignment_statement());
    } else if (ctx.function_call_statement() != null) {
      return visitFunction_call_statement(ctx.function_call_statement());
    } else if (ctx.if_statement() != null) {
      return visitIf_statement(ctx.if_statement());
    } else if (ctx.repeat_statement() != null) {
      return visit(ctx.repeat_statement());
    }
    return null;
  }

  @Override
  public Statement visitAssignment_statement(EscapeRoomDSLParser.Assignment_statementContext ctx) {
    String operator = ctx.op.getText();
    Expression value = expressionVisitor.visit(ctx.expression());

    if (ctx.property_access() != null) {
      // Property access like player.health
      String fullPath = ctx.property_access().getText();
      // Parse the path to get variable name and property
      String[] parts = fullPath.split("\\.", 2);
      String variableName = parts[0];
      String propertyPath = parts.length > 1 ? fullPath : null;
      return new AssignmentStatement(variableName, propertyPath, operator, value);
    } else {
      // Simple variable like score
      String variableName = ctx.ID().getText();
      return new AssignmentStatement(variableName, operator, value);
    }
  }

  @Override
  public Statement visitFunction_call_statement(
      EscapeRoomDSLParser.Function_call_statementContext ctx) {
    // First token is the function name; it might be an ID or a keyword-like literal
    // (e.g., 'show_message') depending on lexer rules.
    String functionName = ctx.getStart().getText();
    List<Expression> arguments = new ArrayList<>();

    for (var exprCtx : ctx.expression()) {
      arguments.add(expressionVisitor.visit(exprCtx));
    }

    return new FunctionCallStatement(functionName, arguments);
  }

  @Override
  public Statement visitIf_statement(EscapeRoomDSLParser.If_statementContext ctx) {
    Expression condition = expressionVisitor.visit(ctx.expression());
    StatementBlock thenBlock = parseStatementBlock(ctx.statement_block(0));
    Statement elseBlock = null;

    // Check for else clause
    if (ctx.if_statement() != null) {
      // else if - wrap in another IfStatement
      elseBlock = visitIf_statement(ctx.if_statement());
    } else if (ctx.statement_block().size() > 1) {
      // else block
      elseBlock = parseStatementBlock(ctx.statement_block(1));
    }

    return new IfStatement(condition, thenBlock, elseBlock);
  }

  @Override
  public Statement visitRepeatCount(EscapeRoomDSLParser.RepeatCountContext ctx) {
    int count = Integer.parseInt(ctx.INT().getText());
    Expression countExpr = new IntLiteralExpr(count);
    StatementBlock body = parseStatementBlock(ctx.statement_block());
    return new RepeatStatement(countExpr, body);
  }

  @Override
  public Statement visitRepeatRange(EscapeRoomDSLParser.RepeatRangeContext ctx) {
    String variableName = ctx.ID().getText();
    Expression fromExpr = expressionVisitor.visit(ctx.expression(0));
    Expression toExpr = expressionVisitor.visit(ctx.expression(1));
    StatementBlock body = parseStatementBlock(ctx.statement_block());
    return new RepeatStatement(variableName, fromExpr, toExpr, body);
  }

  // ========================================================================
  // Event Handlers
  // ========================================================================

  /** Parse an event handler into an EventHandler object. */
  public EventHandler parseEventHandler(EscapeRoomDSLParser.Event_handlerContext ctx) {
    return parseEventHandler(ctx, null, null);
  }

  /** Parse an event handler with entity context. */
  public EventHandler parseEventHandler(
      EscapeRoomDSLParser.Event_handlerContext ctx, String attachedToId, String attachedToType) {
    String keyword = ctx.getChild(0).getText();
    EventType eventType = EventType.fromKeyword(keyword);
    StatementBlock body = parseStatementBlock(ctx.statement_block());
    return new EventHandler(eventType, body, attachedToId, attachedToType);
  }

  // ========================================================================
  // Triggers
  // ========================================================================

  /** Parse a trigger definition into a Trigger object. */
  public Trigger parseTrigger(EscapeRoomDSLParser.Trigger_defContext ctx) {
    Expression condition = expressionVisitor.visit(ctx.expression());
    StatementBlock body = parseStatementBlock(ctx.statement_block());
    return new Trigger(condition, body);
  }

  /** Parse all triggers from a triggers block. */
  public List<Trigger> parseTriggers(EscapeRoomDSLParser.Triggers_blockContext ctx) {
    List<Trigger> triggers = new ArrayList<>();
    if (ctx != null && ctx.trigger_def() != null) {
      for (var triggerCtx : ctx.trigger_def()) {
        triggers.add(parseTrigger(triggerCtx));
      }
    }
    return triggers;
  }
}
