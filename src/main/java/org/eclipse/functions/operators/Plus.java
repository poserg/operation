package org.eclipse.functions.operators;

public class Plus extends Operator {

  /**
   * @param oper1
   * @param oper2
   */
  public Plus(IGetValue oper1, IGetValue oper2) {
    super(oper1, oper2);
    // TODO Auto-generated constructor stub
  }

  @Override
  public double get() {
    return oper1.get() + oper2.get();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.functions.operators.IGetValue#out()
   */
  @Override
  public String out() {
    return oper1.out() + " + " + oper2.out();
  }
}
