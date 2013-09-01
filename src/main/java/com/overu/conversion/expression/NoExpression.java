package com.overu.conversion.expression;

public class NoExpression implements Expression {

  private double byMultiply;

  public NoExpression(double byMultiply) {
    this.byMultiply = byMultiply;
  }

  @Override
  public double operation(double num) {
    return this.byMultiply;
  }
}
