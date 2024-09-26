import static org.junit.Assert.*;
import org.junit.Test;
public class TestFunction {
//1.SinTest
    // Test value calculation
    @Test
    public void testValue() {
        Function operand = new Variable(); // Operand equivalent to 'x'
        Sin sinFunction = new Sin(operand);

        // Test for various input values
        double result1 = sinFunction.value(0); // sin(0) = 0
        double result2 = sinFunction.value(Math.PI / 2); // sin(pi/2) = 1
        double result3 = sinFunction.value(Math.PI); // sin(pi) = 0

        assertEquals(0, result1, 0.0001); // Tolerance added for floating-point comparison
        assertEquals(1, result2, 0.0001);
        assertEquals(0, result3, 0.0001);
    }

    // Test derivative calculation
    @Test
    public void testDerivative() {
        Function operand = new Variable(); // Operand equivalent to 'x'
        Sin sinFunction = new Sin(operand);
        Function derivative = sinFunction.derivative();

        // Test for various input values
        double result1 = derivative.value(0); // cos(0) = 1
        double result2 = derivative.value(Math.PI / 2); // cos(pi/2) = 0
        double result3 = derivative.value(Math.PI); // cos(pi) = -1

        assertEquals(1, result1, 0.0001);
        assertEquals(0, result2, 0.0001);
        assertEquals(-1, result3, 0.0001);
    }

    // Test equality
    @Test
    public void testEquality() {
        Function operand1 = new Variable(); // Operand equivalent to 'x'
        Function operand2 = new Number(2);
        Sin sinFunction1 = new Sin(operand1);
        Sin sinFunction2 = new Sin(operand2);

        // Sin functions with different operands should not be equal
        assertNotEquals(sinFunction1, sinFunction2);

        // Sin function with the same operand should be equal
        Sin sinFunction3 = new Sin(operand1);
        assertEquals(sinFunction1, sinFunction3);
    }

    // Test string representation
    @Test
    public void testToString() {
        Function operand = new Variable(); // Operand equivalent to 'x'
        Sin sinFunction = new Sin(operand);
        String result = sinFunction.toString();
        assertEquals("Sin[x]", result);
    }
    
    
}