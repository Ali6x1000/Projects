import static org.junit.Assert.*;
import org.junit.Test;
public class PolynomialTest {  
// PolynomialTest
    
     // Test value calculation
    @Test
    public void testValue() {
        // Create a polynomial x^2 + 2x
        Function operand = new Variable(); // Operand equivalent to 'x'
        Polynomial polynomialFunction = new Polynomial(operand, 2); // x^2
        polynomialFunction = new Polynomial(new BinaryOp(BinaryOp.Operator.ADD, polynomialFunction, new BinaryOp(BinaryOp.Operator.MULTIPLY, new Number(2), operand)), 1); // + 2x
      

        // Test for various input values
        double result1 = polynomialFunction.value(0); // 0^2 + 2 * 0  = 0
        double result2 = polynomialFunction.value(1); // 1^2 + 2 * 1  = 3
        double result3 = polynomialFunction.value(-1); // (-1)^2 + 2 * (-1) = -1

        assertEquals(0, result1, 0.0001); // Tolerance added for floating-point comparison
        assertEquals(3, result2, 0.0001);
        assertEquals(-1, result3, 0.0001);
    }

    // Test derivative calculation
    @Test
    public void testDerivative() {
        // Create a polynomial x^2 + 2x 
        Function operand = new Variable(); // Operand equivalent to 'x'
        Polynomial polynomialFunction = new Polynomial(operand, 2); // x^2
        polynomialFunction = new Polynomial(new BinaryOp(BinaryOp.Operator.ADD, polynomialFunction, new BinaryOp(BinaryOp.Operator.MULTIPLY, new Number(2), operand)), 1); // + 2x
       

        // Derivative should be 2x + 2
        Function derivative = polynomialFunction.derivative();

        // Test for various input values
        double result1 = derivative.value(1); // 2 * 1 + 2 = 4
        double result2 = derivative.value(-1); // 2 * (-1) + 2 = 0

        assertEquals(4, result1, 0.0001);
        assertEquals(0, result2, 0.0001);
    }

    // Test equality
    @Test
    public void testEquality() {
        // Create two polynomials representing the same function x^2 + 2x + 1
        Function operand = new Variable(); // Operand equivalent to 'x'
        Polynomial polynomialFunction1 = new Polynomial(operand, 2); // x^2
        polynomialFunction1 = new Polynomial(new BinaryOp(BinaryOp.Operator.ADD, polynomialFunction1, new BinaryOp(BinaryOp.Operator.MULTIPLY, new Number(2), operand)), 1); // + 2x
        polynomialFunction1 = new Polynomial(new BinaryOp(BinaryOp.Operator.ADD, polynomialFunction1, new Number(1)), 0); // + 1

        Polynomial polynomialFunction2 = new Polynomial(operand, 2); // x^2
        polynomialFunction2 = new Polynomial(new BinaryOp(BinaryOp.Operator.ADD, polynomialFunction2, new BinaryOp(BinaryOp.Operator.MULTIPLY, new Number(2), operand)), 1); // + 2x
        polynomialFunction2 = new Polynomial(new BinaryOp(BinaryOp.Operator.ADD, polynomialFunction2, new Number(1)), 0); // + 1

        // The two polynomials should be equal
        assertEquals(polynomialFunction1, polynomialFunction2);
    }

    // Test string representation
    @Test
    public void testToString() {
        // Create a polynomial x^2 + 2x + 1
        Function operand = new Variable(); // Operand equivalent to 'x'
        Polynomial polynomialFunction = new Polynomial(operand, 2); // x^2
        polynomialFunction = new Polynomial(new BinaryOp(BinaryOp.Operator.ADD, polynomialFunction, new BinaryOp(BinaryOp.Operator.MULTIPLY, new Number(2), operand)), 1); // + 2x
        polynomialFunction = new Polynomial(new BinaryOp(BinaryOp.Operator.ADD, polynomialFunction, new Number(1)), 1); // + 1

        // String representation should be "x^2 + 2 * x + 1"
        String result = polynomialFunction.toString();
        assertEquals("((x^2.0 + (2.0 * x))^1.0 + 1.0)^1.0", result);
    }
}