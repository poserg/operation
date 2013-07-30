package org.eclipse.functions.var;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.functions.operators.Div;
import org.eclipse.functions.operators.IGetValue;
import org.eclipse.functions.operators.Minus;
import org.eclipse.functions.operators.Mul;
import org.eclipse.functions.operators.Operator;
import org.eclipse.functions.operators.Plus;

public class Expression {

  List<IGetValue> varList;
  double          result;
  List<Integer>   operators;

  public Expression(List<IGetValue> varList, double result) {
    this.varList = varList;
    this.result = result;
    operators = new ArrayList<Integer>();
  }

  public List<IGetValue> find() {
    int count = (int) Math.pow(4, varList.size()); // сколько всего возможностей

    for (int i = 0; i < count; i++) {
      List<Integer> intList = new ArrayList<Integer>();
      decToFour(i, intList);

      operators.clear();
      for (int j = 0; j < intList.size(); j++) {
        operators.add(intList.get(j));
      }
      for (int j = intList.size(); j < varList.size() - 1; j++) {
        operators.add(0);
      }

      List<IGetValue> values = new ArrayList<IGetValue>();
      for (IGetValue var : varList) {
        values.add(new Num(var.get()));
      }
      if (check(values)) {
        return values;
      }
    }

    return null;
  }

  private boolean check(List<IGetValue> varList) {
    System.out.print("operators = ");
    for (int i = 0; i < operators.size(); i++) {
      System.out.print(operators.get(i) + ", ");
    }
    System.out.print("\r\n");

    // Проверяем умножение/деление
    for (int i = 0; i < operators.size(); i++) {
      if (operators.get(i) == 0 || operators.get(i) == 1) {
        // если умножить или разделить, то сразу же приводим к оператору

        IGetValue oper1 = varList.get(i);
        IGetValue oper2 = varList.get(i + 1);
        varList.remove(i);
        varList.remove(i);

        Operator commonOperator;
        if (operators.get(i) == 0) {
          commonOperator = new Mul(oper1, oper2);
        }
        else {
          commonOperator = new Div(oper1, oper2);
        }
        varList.add(i, commonOperator);
        operators.remove(i);
        i--;
      }
    }

    // Знаки сложения/вычитания
    for (int i = 0; i < operators.size(); i++) {
      if (operators.get(i) == 2 || operators.get(i) == 3) {

        IGetValue oper1 = varList.get(i);
        IGetValue oper2 = varList.get(i + 1);
        varList.remove(i);
        varList.remove(i);

        Operator commonOperator;
        if (operators.get(i) == 2) {
          commonOperator = new Plus(oper1, oper2);
        }
        else {
          commonOperator = new Minus(oper1, oper2);
        }
        varList.add(i, commonOperator);
        operators.remove(i);
        i--;
      }
    }

    return varList.size() == 1 && varList.get(0).get() == result;
  }

  private void decToFour(int num, List<Integer> intList) {
    if (num == 0) {
      return;
    }
    int t = num / 4;
    intList.add(num - t * 4);
    decToFour(t, intList);
  }
}
