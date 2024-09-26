
import static org.junit.Assert.*;
import org.junit.Test;
public class CosTest {

// Test value calculation
    @Test
    public void testValue() {
        Function operand = new Variable(); // Operand equivalent to 'x'
        Cos cosFunction = new Cos(operand);

        // Test for various input values
        double result1 = cosFunction.value(0); // cos(0) = 1
        double result2 = cosFunction.value(Math.PI / 2); // cos(pi/2) = 0
        double result3 = cosFunction.value(Math.PI); // cos(pi) = -1

        assertEquals(1, result1, 0.0001); // Tolerance added for floating-point comparison
        assertEquals(0, result2, 0.0001);
        assertEquals(-1, result3, 0.0001);
    }

    // Test derivative calculation
    @Test
    public void testDerivative() {
        Function operand = new Variable(); // Operand equivalent to 'x'
        Cos cosFunction = new Cos(operand);
        Function derivative = cosFunction.derivative();

        // Test for various input values
        double result1 = derivative.value(0); // -sin(0) = 0
        double result2 = derivative.value(Math.PI / 2); // -sin(pi/2) = -1
        double result3 = derivative.value(Math.PI); // -sin(pi) = 0

        assertEquals(0, result1, 0.0001);
        assertEquals(-1, result2, 0.0001);
        assertEquals(0, result3, 0.0001);
    }

    // Test equality
    @Test
    public void testEquality() {
        Function operand1 = new Variable(); // Operand equivalent to 'x'
        Function operand2 = new Number(2);
        Cos cosFunction1 = new Cos(operand1);
        Cos cosFunction2 = new Cos(operand2);

        // Cos functions with different operands should not be equal
        assertNotEquals(cosFunction1, cosFunction2);

        // Cos function with the same operand should be equal
        Cos cosFunction3 = new Cos(operand1);
        assertEquals(cosFunction1, cosFunction3);
    }

    // Test string representation
    @Test
    public void testToString() {
        Function operand = new Variable(); // Operand equivalent to 'x'
        Cos cosFunction = new Cos(operand);
        String result = cosFunction.toString();
        assertEquals("Cos[x]", result);
    }
    
    
    // 3. Exp class test
}