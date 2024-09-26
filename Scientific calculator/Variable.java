/**
 * Represents the variable 'x'.
 */
public class Variable implements Function {

    /**
     * Constructs a Variable object.
     */
    public Variable() {
        // No fields to initialize
    }

    /**
     * Returns the value of the variable.
     *
     * @param x The input value (ignored).
     * @return The value of the variable.
     */
    @Override
    public double value(double x) {
        return x;
    }

    /**
     * Returns the derivative of the variable, which is always 1.
     *
     * @return The derivative of the variable (constant 1).
     */
    @Override
    public Function derivative() {
        return new Number(1); // Using a subclass of Number to represent the constant 1
    }

    /**
     * Returns the string representation of the variable.
     *
     * @return The string representation "x".
     */
    @Override
    public String toString() {
        return "x";
    }

    /**
     * Checks if this Variable is equal to another object (always returns true).
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Variable;
    }
}