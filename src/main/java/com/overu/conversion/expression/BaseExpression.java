package com.overu.conversion.expression;

public class BaseExpression implements Expression {

  private double byMultiply;

  public BaseExpression(double byMultiply) {
    this.byMultiply = byMultiply;
  }

  @Override
  public double operation(double num) {
    return num * this.byMultiply;
  }
}
