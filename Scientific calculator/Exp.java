/**
 * Represents the natural exponential function.
 */
public class Exp implements Function {
    private final Function operand;

    /**
     * Constructs an Exp object with the specified operand.
     *
     * @param operand The function operand.
     */
    public Exp(Function operand) {
        this.operand = operand;
    }

    /**
     * Returns the value of the natural exponential function.
     *
     * @param x The input value.
     * @return The value of the natural exponential function.
     */
    @Override
    public double value(double x) {
        return Math.exp(operand.value(x));
    }
    
  // Implementation of value() method with no input
    @Override
    public double value() {
        throw new UnsupportedOperationException("Input expected."); // Exp function requires input
    }
    
    /**
     * Returns the derivative of the natural exponential function using the chain rule.
     *
     * @return The derivative of the natural exponential function.
     */
    @Override
    public Function derivative() {
        return new BinaryOp(BinaryOp.Operator.MULTIPLY,
                new Exp(operand),
                operand.derivative()
        );
    }

    /**
     * Returns the operand of the exponential function.
     *
     * @return The operand of the exponential function.
     */
    public Function getOperand() {
        return operand;
    }

    /**
     * Checks if this Exp function is equal to another object.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Exp exp = (Exp) obj;
        return operand.equals(exp.operand);
    }

    /**
     * Returns the string representation of the exponential function.
     *
     * @return The string representation of the exponential function.
     */
    @Override
    public String toString() {
        return "Exp[" + operand + "]";
    }
}
