

import static org.junit.Assert.*;
import org.junit.Test;
public class ExpTest {

    //  Exp class test
    
    
    // Test value calculation
    @Test
    public void testValue() {
        Function operand = new Variable(); // Operand equivalent to 'x'
        Exp expFunction = new Exp(operand);

        // Test for various input values
        double result1 = expFunction.value(0); // exp(0) = 1
        double result2 = expFunction.value(1); // exp(1) = e
        double result3 = expFunction.value(-1); // exp(-1) = 1/e

        assertEquals(1, result1, 0.0001); // Tolerance added for floating-point comparison
        assertEquals(Math.E, result2, 0.0001);
        assertEquals(1 / Math.E, result3, 0.0001);
    }

    // Test derivative calculation
    @Test
    public void testDerivative() {
        Function operand = new Variable(); // Operand equivalent to 'x'
        Exp expFunction = new Exp(operand);
        Function derivative = expFunction.derivative();

        // Test for various input values
        double result1 = derivative.value(0); // exp(0) = 1
        double result2 = derivative.value(1); // exp(1) = e
        double result3 = derivative.value(-1); // exp(-1) = 1/e

        assertEquals(1, result1, 0.0001); // Derivative of exp(x) is exp(x)
        assertEquals(Math.E, result2, 0.0001);
        assertEquals(1 / Math.E, result3, 0.0001);
    }

    // Test equality
    @Test
    public void testEquality() {
        Function operand1 = new Variable(); // Operand equivalent to 'x'
        Function operand2 = new Number(2);
        Exp expFunction1 = new Exp(operand1);
        Exp expFunction2 = new Exp(operand2);

        // Exp functions with different operands should not be equal
        assertNotEquals(expFunction1, expFunction2);

        // Exp function with the same operand should be equal
        Exp expFunction3 = new Exp(operand1);
        assertEquals(expFunction1, expFunction3);
    }

    // Test string representation
    @Test
    public void testToString() {
        Function operand = new Variable(); // Operand equivalent to 'x'
        Exp expFunction = new Exp(operand);
        String result = expFunction.toString();
        assertEquals("Exp[x]", result);
    }
    
 
    
    
}