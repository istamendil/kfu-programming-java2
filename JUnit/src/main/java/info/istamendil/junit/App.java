package info.istamendil.junit;

public class App {

  public static void main(String[] args) {
    
    // Plus operator
    System.out.println("Calculator Plus test");
    if(Calculator.getResult(2, 2, Calculator.OPERATOR.PLUS) == 4.0){
      System.out.println("Passed");
    }
    else{
      System.out.println("Failed");
    }
    
    // Minus operator
    System.out.println("Calculator Minus test");
    if(Calculator.getResult(2, 2, Calculator.OPERATOR.MINUS) == 0.0){
      System.out.println("Passed");
    }
    else{
      System.out.println("Failed");
    }
    
    // Geometric Mean operator
    System.out.println("Geometric Mean test with two positive operands");
    if(Calculator.getResult(2, 8, Calculator.OPERATOR.GEOMETRIC_MEAN) == 4.0){
      System.out.println("Passed");
    }
    else{
      System.out.println("Failed");
    }
    System.out.println("Geometric Mean test with one negative operand and one positive operand");
    if(Double.isNaN(Calculator.getResult(2, -8, Calculator.OPERATOR.GEOMETRIC_MEAN))){
      System.out.println("Passed");
    }
    else{
      System.out.println("Failed");
    }
    System.out.println("Geometric Mean test with two negative operands");
    if(Double.isNaN(Calculator.getResult(-2, -8, Calculator.OPERATOR.GEOMETRIC_MEAN))){
      System.out.println("Passed");
    }
    else{
      System.out.println("Failed");
    }
  }

}
