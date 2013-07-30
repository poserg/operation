package org.eclipse.functions.var;

import org.eclipse.functions.operators.IGetValue;

public class Num implements IGetValue {

  private double num;

  public Num(double num) {
    this.num = num;
  }

  @Override
  public double get() {
    return num;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.functions.operators.IGetValue#out()
   */
  @Override
  public String out() {
    return Double.toString(num);
  }

}
