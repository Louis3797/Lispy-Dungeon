package dsl.runtime;

import dsl.parser.EscapeRoomDSLBaseVisitor;
import dsl.parser.EscapeRoomDSLParser;
import dsl.runtime.ast.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Visitor for parsing DSL expressions into AST nodes. This visitor returns Expression objects that
 * can be evaluated at runtime.
 */
public class ExpressionVisitor extends EscapeRoomDSLBaseVisitor<Expression> {

  // ========================================================================
  // Primary Expressions
  // ========================================================================

  @Override
  public Expression visitIntLiteral(EscapeRoomDSLParser.IntLiteralContext ctx) {
    return new IntLiteralExpr(Integer.parseInt(ctx.INT().getText()));
  }

  @Override
  public Expression visitFloatLiteral(EscapeRoomDSLParser.FloatLiteralContext ctx) {
    return new FloatLiteralExpr(Double.parseDouble(ctx.FLOAT().getText()));
  }

  @Override
  public Expression visitStringLiteral(EscapeRoomDSLParser.StringLiteralContext ctx) {
    String text = ctx.STRING().getText();
    // Remove surrounding quotes
    return new StringLiteralExpr(unquote(text));
  }

  @Override
  public Expression visitBoolLiteral(EscapeRoomDSLParser.BoolLiteralContext ctx) {
    return new BoolLiteralExpr(Boolean.parseBoolean(ctx.BOOLEAN().getText()));
  }

  @Override
  public Expression visitIdentifierExpr(EscapeRoomDSLParser.IdentifierExprContext ctx) {
    return new IdentifierExpr(ctx.ID().getText());
  }

  @Override
  public Expression visitParenExpr(EscapeRoomDSLParser.ParenExprContext ctx) {
    return visit(ctx.expression());
  }

  @Override
  public Expression visitArrayLiteral(EscapeRoomDSLParser.ArrayLiteralContext ctx) {
    List<Expression> elements = new ArrayList<>();
    if (ctx.array() != null && ctx.array().value() != null) {
      for (var valueCtx : ctx.array().value()) {
        elements.add(parseValue(valueCtx));
      }
    }
    return new ArrayLiteralExpr(elements);
  }

  // ========================================================================
  // Compound Expressions
  // ========================================================================

  @Override
  public Expression visitPrimaryExpr(EscapeRoomDSLParser.PrimaryExprContext ctx) {
    return visit(ctx.primary_expression());
  }

  @Override
  public Expression visitPropertyAccessExpr(EscapeRoomDSLParser.PropertyAccessExprContext ctx) {
    Expression target = visit(ctx.expression());
    String property = ctx.ID().getText();
    return new PropertyAccessExpr(target, property);
  }

  @Override
  public Expression visitFunctionCallExpr(EscapeRoomDSLParser.FunctionCallExprContext ctx) {
    // Function name is the first token; may be an ID or a keyword-like literal depending on lexer.
    String functionName = ctx.getStart().getText();
    List<Expression> arguments = new ArrayList<>();

    for (var exprCtx : ctx.expression()) {
      arguments.add(visit(exprCtx));
    }

    return new FunctionCallExpr(functionName, arguments);
  }

  @Override
  public Expression visitUnaryExpr(EscapeRoomDSLParser.UnaryExprContext ctx) {
    Expression operand = visit(ctx.expression());
    String operator = ctx.getChild(0).getText(); // '!' or '-'
    return new UnaryExpr(operator, operand);
  }

  @Override
  public Expression visitMulDivExpr(EscapeRoomDSLParser.MulDivExprContext ctx) {
    Expression left = visit(ctx.expression(0));
    Expression right = visit(ctx.expression(1));
    String operator = ctx.op.getText();
    return new BinaryExpr(left, operator, right);
  }

  @Override
  public Expression visitAddSubExpr(EscapeRoomDSLParser.AddSubExprContext ctx) {
    Expression left = visit(ctx.expression(0));
    Expression right = visit(ctx.expression(1));
    String operator = ctx.op.getText();
    return new BinaryExpr(left, operator, right);
  }

  @Override
  public Expression visitCompareExpr(EscapeRoomDSLParser.CompareExprContext ctx) {
    Expression left = visit(ctx.expression(0));
    Expression right = visit(ctx.expression(1));
    String operator = ctx.op.getText();
    return new BinaryExpr(left, operator, right);
  }

  @Override
  public Expression visitEqualityExpr(EscapeRoomDSLParser.EqualityExprContext ctx) {
    Expression left = visit(ctx.expression(0));
    Expression right = visit(ctx.expression(1));
    String operator = ctx.op.getText();
    return new BinaryExpr(left, operator, right);
  }

  @Override
  public Expression visitAndExpr(EscapeRoomDSLParser.AndExprContext ctx) {
    Expression left = visit(ctx.expression(0));
    Expression right = visit(ctx.expression(1));
    return new BinaryExpr(left, "&&", right);
  }

  @Override
  public Expression visitOrExpr(EscapeRoomDSLParser.OrExprContext ctx) {
    Expression left = visit(ctx.expression(0));
    Expression right = visit(ctx.expression(1));
    return new BinaryExpr(left, "||", right);
  }

  @Override
  public Expression visitTernaryExpr(EscapeRoomDSLParser.TernaryExprContext ctx) {
    Expression condition = visit(ctx.expression(0));
    Expression thenExpr = visit(ctx.expression(1));
    Expression elseExpr = visit(ctx.expression(2));
    return new TernaryExpr(condition, thenExpr, elseExpr);
  }

  // ========================================================================
  // Helper Methods
  // ========================================================================

  /** Parse a value context into an Expression. */
  private Expression parseValue(EscapeRoomDSLParser.ValueContext ctx) {
    if (ctx.INT() != null) {
      return new IntLiteralExpr(Integer.parseInt(ctx.INT().getText()));
    } else if (ctx.FLOAT() != null) {
      return new FloatLiteralExpr(Double.parseDouble(ctx.FLOAT().getText()));
    } else if (ctx.STRING() != null) {
      return new StringLiteralExpr(unquote(ctx.STRING().getText()));
    } else if (ctx.BOOLEAN() != null) {
      return new BoolLiteralExpr(Boolean.parseBoolean(ctx.BOOLEAN().getText()));
    } else if (ctx.ID() != null) {
      return new IdentifierExpr(ctx.ID().getText());
    } else if (ctx.array() != null) {
      List<Expression> elements = new ArrayList<>();
      for (var valueCtx : ctx.array().value()) {
        elements.add(parseValue(valueCtx));
      }
      return new ArrayLiteralExpr(elements);
    }
    // Default case
    return new StringLiteralExpr(ctx.getText());
  }

  /** Removes surrounding quotes from a string literal. */
  private String unquote(String text) {
    if (text == null) return null;
    if (text.length() >= 2) {
      if ((text.startsWith("\"") && text.endsWith("\""))
          || (text.startsWith("'") && text.endsWith("'"))) {
        return text.substring(1, text.length() - 1);
      }
    }
    return text;
  }
}
