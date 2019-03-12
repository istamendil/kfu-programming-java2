package info.istamendil.junit;

import info.istamendil.junit.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
  @Test
  public void plusExpression() {
    double result = Calculator.getResult(2.0, 2.0, Calculator.OPERATOR.PLUS);
    Assert.assertEquals(4.0, result, 0.0);
  }
  @Test
  public void minusExpression() {
    double result = Calculator.getResult(2.0, 2.0, Calculator.OPERATOR.MINUS);
    Assert.assertEquals(0.0, result, 0.0);
  }
  @Test
  public void geometricMeanOneNegativeOperandExpression() {
    double result = Calculator.getResult(2, -8, Calculator.OPERATOR.GEOMETRIC_MEAN);
    Assert.assertTrue(Double.isNaN(result));
  }
  @Test
  public void geometricMeanTwoNegativeOperandsExpression() {
    double result = Calculator.getResult(-2, -8, Calculator.OPERATOR.GEOMETRIC_MEAN);
    Assert.assertTrue(Double.isNaN(result));
  }
}
