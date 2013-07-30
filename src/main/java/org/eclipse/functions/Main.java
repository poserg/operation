package org.eclipse.functions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.functions.operators.IGetValue;
import org.eclipse.functions.var.Expression;
import org.eclipse.functions.var.Num;

public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    double[] input = { 10, 12, 11, 3, 1, 2 };
    double result = 13;

    List<IGetValue> varList = new ArrayList<IGetValue>();
    for (int i = 0; i < input.length; i++) {
      varList.add(new Num(input[i]));
    }

    Expression expr = new Expression(varList, result);
    List<IGetValue> res = expr.find();
    if (res != null) {
      System.out.println(res.get(0).out() + " = " + result);
    }
    else {
      System.out.println("Not solve");
    }
  }

}
