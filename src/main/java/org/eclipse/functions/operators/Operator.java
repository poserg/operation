package org.eclipse.functions.operators;

public abstract class Operator implements IGetValue {

  protected IGetValue oper1;
  protected IGetValue oper2;

  public Operator(IGetValue oper1, IGetValue oper2) {
    this.oper1 = oper1;
    this.oper2 = oper2;
  }

  @Override
  public abstract double get();
}
