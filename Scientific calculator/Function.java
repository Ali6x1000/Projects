/**
 * Represents a mathematical function.
 * 
 * @author [Ali Nawaf]
 */
public interface Function {
    /**
     * Returns the value of the function at the given input.
     * 
     * @param input the input value for the function
     * @return the value of the function at the given input
     * @throws UnsupportedOperationException if the method is called with no input
     */
    double value(double input);

    /**
     * Returns the value of the function with no input.
     * 
     * @return the value of the function
     * @throws UnsupportedOperationException if the method is called without input
     */
    default double value() {
        throw new UnsupportedOperationException("Input expected.");
    }

    /**
     * Returns the derivative of this function.
     * 
     * @return the derivative function
     */
    Function derivative();
}