/**
 * Represents a constant number.
 */
public class Number implements Function {
    private final double value;

    /**
     * Constructs a Number object with the specified value.
     *
     * @param value The constant value.
     */
    public Number(double value) {
        this.value = value;
    }

    /**
     * Returns the value of the constant.
     *
     * @param x The input value (ignored).
     * @return The constant value.
     */
    @Override
    public double value(double value10) {
        return value;
    }
    
  // Implementation of value() method with no input
    @Override
    public double value() {
        return value; // Return the stored value
    }
    
    /**
     * Returns the derivative of the constant, which is always 0.
     *
     * @return The derivative of the constant (constant 0).
     */
    @Override
    public Function derivative() {
        return new Number(0);
    }

    /**
     * Returns the string representation of the constant.
     *
     * @return The string representation of the constant value.
     */
    @Override
    public String toString() {
        return Double.toString(value);
    }

    /**
     * Checks if this Number is equal to another object (based on value).
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Number number = (Number) obj;
        return Double.compare(number.value, value) == 0;
    }
}