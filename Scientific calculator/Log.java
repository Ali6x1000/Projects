/**
 * Represents the natural logarithm function.
 *  @author [Ali Nawaf]
 */
public class Log implements Function {
    private final Function operand;

    /**
     * Constructs a Log object with the specified operand.
     *
     * @param operand The function operand.
     */
    public Log(Function operand) {
        this.operand = operand;
    }

    /**
     * Returns the value of the natural logarithm function.
     *
     * @param x The input value.
     * @return The value of the natural logarithm function.
     */
    @Override
    public double value(double x) {
        return Math.log(operand.value(x));
    }
    
 // Implementation of value() method with no input
    @Override
    public double value() {
        throw new UnsupportedOperationException("Input expected."); // Log function requires input
    }
    
    /**
     * Returns the derivative of the natural logarithm function.
     *
     * @return The derivative of the natural logarithm function.
     */
    @Override
    public Function derivative() {
        return new BinaryOp(BinaryOp.Operator.DIVIDE,
                operand.derivative(),
                operand
        );
    }

    /**
     * Returns the operand of the logarithm function.
     *
     * @return The operand of the logarithm function.
     */
    public Function getOperand() {
        return operand;
    }

    /**
     * Checks if this Log function is equal to another object.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Log log = (Log) obj;
        return operand.equals(log.operand);
    }

    /**
     * Returns the string representation of the logarithm function.
     *
     * @return The string representation of the logarithm function.
     */
    @Override
    public String toString() {
        return "Log[" + operand + "]";
    }
}
