/**
 * Represents the sine function.
 */
public class Sin implements Function {
    private final Function operand;

    /**
     * Constructs a Sin object with the specified operand.
     *
     * @param operand The function operand.
     */
    public Sin(Function operand) {
        this.operand = operand;
    }

    /**
     * Returns the value of the sine function.
     *
     * @param x The input value.
     * @return The value of the sine function.
     */
    @Override
    public double value(double x) {
        return Math.sin(operand.value(x));
    }
    
      // Implementation of value() method with no input
    @Override
    public double value() {
        throw new UnsupportedOperationException("Input expected."); // Sin function requires input
    }

    /**
     * Returns the derivative of the sine function using the chain rule.
     *
     * @return The derivative of the sine function.
     */
    @Override
    public Function derivative() {
        return new BinaryOp(BinaryOp.Operator.MULTIPLY,
                new Cos(operand),
                operand.derivative()
        );
    }

    /**
     * Returns the operand of the sine function.
     *
     * @return The operand of the sine function.
     */
    public Function getOperand() {
        return operand;
    }

    /**
     * Checks if this Sin function is equal to another object.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sin sin = (Sin) obj;
        return operand.equals(sin.operand);
    }

    /**
     * Returns the string representation of the sine function.
     *
     * @return The string representation of the sine function.
     */
    @Override
    public String toString() {
        return "Sin[" + operand + "]";
    }
}
