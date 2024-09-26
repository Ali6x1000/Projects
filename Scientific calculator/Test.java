import static org.junit.Assert.*;
import org.junit.Test;
public class Test {
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
    
    
    
    // 2.CosTest
    
    
    
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
    
    //4. LogTest
    
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
        assertEquals(1, result3, 0.0001);
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
    
    // 5. PolynomialTest
    
     // Test value calculation
    @Test
    public void testValue() {
        // Create a polynomial x^2 + 2x + 1
        Function operand = new Variable(); // Operand equivalent to 'x'
        Polynomial polynomialFunction = new Polynomial(operand, 2); // x^2
        polynomialFunction = new Polynomial(new BinaryOp(BinaryOp.Operator.ADD, polynomialFunction, new BinaryOp(BinaryOp.Operator.MULTIPLY, new Number(2), operand)), 1); // + 2x
        polynomialFunction = new Polynomial(new BinaryOp(BinaryOp.Operator.ADD, polynomialFunction, new Number(1)), 0); // + 1

        // Test for various input values
        double result1 = polynomialFunction.value(0); // 0^2 + 2 * 0 + 1 = 1
        double result2 = polynomialFunction.value(1); // 1^2 + 2 * 1 + 1 = 4
        double result3 = polynomialFunction.value(-1); // (-1)^2 + 2 * (-1) + 1 = 0

        assertEquals(1, result1, 0.0001); // Tolerance added for floating-point comparison
        assertEquals(4, result2, 0.0001);
        assertEquals(0, result3, 0.0001);
    }

    // Test derivative calculation
    @Test
    public void testDerivative() {
        // Create a polynomial x^2 + 2x + 1
        Function operand = new Variable(); // Operand equivalent to 'x'
        Polynomial polynomialFunction = new Polynomial(operand, 2); // x^2
        polynomialFunction = new Polynomial(new BinaryOp(BinaryOp.Operator.ADD, polynomialFunction, new BinaryOp(BinaryOp.Operator.MULTIPLY, new Number(2), operand)), 1); // + 2x
        polynomialFunction = new Polynomial(new BinaryOp(BinaryOp.Operator.ADD, polynomialFunction, new Number(1)), 0); // + 1

        // Derivative should be 2x + 2
        Function derivative = polynomialFunction.derivative();

        // Test for various input values
        double result1 = derivative.value(0); // 2 * 0 + 2 = 2
        double result2 = derivative.value(1); // 2 * 1 + 2 = 4
        double result3 = derivative.value(-1); // 2 * (-1) + 2 = 0

        assertEquals(2, result1, 0.0001);
        assertEquals(4, result2, 0.0001);
        assertEquals(0, result3, 0.0001);
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
        polynomialFunction = new Polynomial(new BinaryOp(BinaryOp.Operator.ADD, polynomialFunction, new Number(1)), 0); // + 1

        // String representation should be "x^2 + 2 * x + 1"
        String result = polynomialFunction.toString();
        assertEquals("x^2 + 2 * x + 1", result);
    }
    
    // 6. NumberTest
    
      // Test value calculation
    @Test
    public void testValue() {
        double value = 5.0;
        Number number = new Number(value);

        double result = number.value(); // Get the value

        assertEquals(value, result, 0.0001); // Tolerance added for floating-point comparison
    }

    // Test equality
    @Test
    public void testEquality() {
        Number number1 = new Number(5.0);
        Number number2 = new Number(5.0);
        Number number3 = new Number(10.0);

        // Numbers with the same value should be equal
        assertEquals(number1, number2);

        // Numbers with different values should not be equal
        assertNotEquals(number1, number3);
    }

    // Test string representation
    @Test
    public void testToString() {
        double value = 5.0;
        Number number = new Number(value);

        String result = number.toString();

        assertEquals(Double.toString(value), result);
    }
    
  //  7. VariableTest
    
    
    // Test value calculation
    @Test
    public void testValue() {
        double inputValue = 5.0;
        Variable variable = new Variable();

        double result = variable.value(inputValue); // Get the value for input

        assertEquals(inputValue, result, 0.0001); // The value of the variable should be the same as the input
    }

    // Test equality
    @Test
    public void testEquality() {
        Variable variable1 = new Variable();
        Variable variable2 = new Variable();

        // Variables representing the same entity should be equal
        assertEquals(variable1, variable2);
    }

    // Test string representation
    @Test
    public void testToString() {
        Variable variable = new Variable();

        String result = variable.toString();

        assertEquals("x", result); // The string representation should be "x"
    }
    // 8.BinaryOpTest
    // Test value calculation for addition operation
    @Test
    public void testAddition() {
        Function operand1 = new Number(5.0);
        Function operand2 = new Number(3.0);
        BinaryOp addition = new BinaryOp(BinaryOp.Operator.ADD, operand1, operand2);

        double result = addition.value();

        assertEquals(8.0, result, 0.0001); // Addition of 5 and 3 should be 8
    }

    // Test value calculation for subtraction operation
    @Test
    public void testSubtraction() {
        Function operand1 = new Number(5.0);
        Function operand2 = new Number(3.0);
        BinaryOp subtraction = new BinaryOp(BinaryOp.Operator.SUBTRACT, operand1, operand2);

        double result = subtraction.value();

        assertEquals(2.0, result, 0.0001); // Subtraction of 5 and 3 should be 2
    }

    // Test value calculation for multiplication operation
    @Test
    public void testMultiplication() {
        Function operand1 = new Number(5.0);
        Function operand2 = new Number(3.0);
        BinaryOp multiplication = new BinaryOp(BinaryOp.Operator.MULTIPLY, operand1, operand2);

        double result = multiplication.value();

        assertEquals(15.0, result, 0.0001); // Multiplication of 5 and 3 should be 15
    }

    // Test value calculation for division operation
    @Test
    public void testDivision() {
        Function operand1 = new Number(6.0);
        Function operand2 = new Number(3.0);
        BinaryOp division = new BinaryOp(BinaryOp.Operator.DIVIDE, operand1, operand2);

        double result = division.value();

        assertEquals(2.0, result, 0.0001); // Division of 6 by 3 should be 2
    }

    // Test equality
    @Test
    public void testEquality() {
        Function operand1 = new Number(5.0);
        Function operand2 = new Number(3.0);
        BinaryOp addition1 = new BinaryOp(BinaryOp.Operator.ADD, operand1, operand2);
        BinaryOp addition2 = new BinaryOp(BinaryOp.Operator.ADD, operand1, operand2);
        BinaryOp multiplication = new BinaryOp(BinaryOp.Operator.MULTIPLY, operand1, operand2);

        // BinaryOps with the same operator and operands should be equal
        assertEquals(addition1, addition2);

        // BinaryOps with different operators or operands should not be equal
        assertNotEquals(addition1, multiplication);
    }

    // Test string representation
    @Test
    public void testToString() {
        Function operand1 = new Number(5.0);
        Function operand2 = new Number(3.0);
        BinaryOp addition = new BinaryOp(BinaryOp.Operator.ADD, operand1, operand2);

        String result = addition.toString();

        assertEquals("(5.0 + 3.0)", result); // The string representation should be "(5.0 + 3.0)"
    }
    
    
}