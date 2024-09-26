/**
 * Represents the cosine function.
 */
public class Cos implements Function {
    private final Function operand;

    /**
     * Constructs a Cos object with the specified operand.
     *
     * @param operand The function operand.
     */
    public Cos(Function operand) {
        this.operand = operand;
    }

    /**
     * Returns the value of the cosine function.
     *
     * @param x The input value.
     * @return The value of the cosine function.
     */
    @Override
    public double value(double x) {
        return Math.cos(operand.value(x));
    }
    
    // Implementation of value() method with no input
    @Override
    public double value() {
        throw new UnsupportedOperationException("Input expected."); // Cos function requires input
    }

    /**
     * Returns the derivative of the cosine function using the chain rule.
     *
     * @return The derivative of the cosine function.
     */
    @Override
    public Function derivative() {
        return new BinaryOp(BinaryOp.Operator.MULTIPLY,
                new Number(-1),
                new BinaryOp(BinaryOp.Operator.MULTIPLY,
                        new Sin(operand),
                        operand.derivative())
        );
    }

    /**
     * Returns the operand of the cosine function.
     *
     * @return The operand of the cosine function.
     */
    public Function getOperand() {
        return operand;
    }

    /**
     * Checks if this Cos function is equal to another object.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cos cos = (Cos) obj;
        return operand.equals(cos.operand);
    }

    /**
     * Returns the string representation of the cosine function.
     *
     * @return The string representation of the cosine function.
     */
    @Override
    public String toString() {
        return "Cos[" + operand + "]";
    }
}
