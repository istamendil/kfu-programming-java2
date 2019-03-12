package info.istamendil.junit;

public class Calculator {
  public enum OPERATOR {PLUS, MINUS, GEOMETRIC_MEAN};
  
  public static double getResult(double firstOperand, double secondOperand, OPERATOR operator){
    double result;
    switch(operator){
      case PLUS:
        result = firstOperand + secondOperand;
      case MINUS:
        result = firstOperand - secondOperand;
        break;
      case GEOMETRIC_MEAN:
        result = Math.sqrt(firstOperand*secondOperand);
        break;
      default:
        throw new IllegalArgumentException("Calculator can't do this operator yet.");
    }
    return result;
  }
  
}
