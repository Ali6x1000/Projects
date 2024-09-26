// 
import static org.junit.Assert.*;
import org.junit.Test;
public class BinaryOpTest {


//  BinaryOpTest
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

        assertEquals("5.0 + 3.0", result); // The string representation should be "5.0 + 3.0"
    } }