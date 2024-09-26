 
import static org.junit.Assert.*;
import org.junit.Test;
public class VariableTest {


//   VariableTest
    
    
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
   }