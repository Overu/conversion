package com.overu.conversion.expression;

public class ChengExpression implements Expression {

  private Expression base;

  public ChengExpression(Expression base) {
    this.base = base;
  }

  @Override
  public double operation(double num) {
    return num * base.operation(1);
  }

}
