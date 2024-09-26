   import static org.junit.Assert.*;
import org.junit.Test;
public class LogTest {

// LogTest
    
    // Test value calculation
    @Test
    public void testValue() {
        Function operand = new Variable(); // Operand equivalent to 'x'
        Log logFunction = new Log(operand);

        // Test for various input values
        double result1 = logFunction.value(1); // log(1) = 0
        double result2 = logFunction.value(Math.E); // log(e) = 1
        double result3 = logFunction.value(10); // log(10) = 1

        assertEquals(0, result1, 0.0001); // Tolerance added for floating-point comparison
        assertEquals(1, result2, 0.0001);
        assertEquals(2.3025, result3, 0.0001);
    }

    // Test derivative calculation
    @Test
    public void testDerivative() {
        Function operand = new Variable(); // Operand equivalent to 'x'
        Log logFunction = new Log(operand);
        Function derivative = logFunction.derivative();

        // Test for various input values
        double result1 = derivative.value(1); // 1/x, at x=1, derivative is 1/1 = 1
        double result2 = derivative.value(Math.E); // 1/x, at x=e, derivative is 1/e
        double result3 = derivative.value(10); // 1/x, at x=10, derivative is 1/10

        assertEquals(1, result1, 0.0001); // Derivative of log(x) is 1/x
        assertEquals(1 / Math.E, result2, 0.0001);
        assertEquals(1 / 10.0, result3, 0.0001);
    }

    // Test equality
    @Test
    public void testEquality() {
        Function operand1 = new Variable(); // Operand equivalent to 'x'
        Function operand2 = new Number(2);
        Log logFunction1 = new Log(operand1);
        Log logFunction2 = new Log(operand2);

        // Log functions with different operands should not be equal
        assertNotEquals(logFunction1, logFunction2);

        // Log function with the same operand should be equal
        Log logFunction3 = new Log(operand1);
        assertEquals(logFunction1, logFunction3);
    }

    // Test string representation
    @Test
    public void testToString() {
        Function operand = new Variable(); // Operand equivalent to 'x'
        Log logFunction = new Log(operand);
        String result = logFunction.toString();
        assertEquals("Log[x]", result);
    }
}
    
  