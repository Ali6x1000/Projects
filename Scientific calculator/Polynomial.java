import java.util.List;
import java.util.ArrayList;
/**
 * Represents a function raised to a power.
 */
public class Polynomial implements Function {
    private final Function operand;
    private final double power;

    /**
     * Constructs a Polynomial object with the specified operand and power.
     *
     * @param operand The function operand.
     * @param power   The power.
     */
    public Polynomial(Function operand, double power) {
        this.operand = operand;
        this.power = power;
    }

    /**
     * Returns the value of the polynomial.
     *
     * @param x The input value.
     * @return The value of the polynomial.
     */
    @Override
    public double value(double x) {
        return Math.pow(operand.value(x), power);
    }

 /**
   * Computes the derivative of the polynomial function
   *
   * @return The derivative function of the polynomial
   */
   @Override
public Function derivative() {
    List<Function> derivativeTerms = new ArrayList<>();
    
    // Iterate over each term of the polynomial
    for (int i = 1; i <= power; i++) {
        // Compute the derivative of the current term
        Function termDerivative = new BinaryOp(
            BinaryOp.Operator.MULTIPLY,  // Multiplication operator
            new Number(i),               // Power of the term
            new BinaryOp(
                BinaryOp.Operator.MULTIPLY,  // Multiplication operator
                new Polynomial(operand, i - 1),  // Term with reduced power
                operand.derivative()  // Derivative of the term
            )
        );
        // Add the derivative of the current term to the list
        derivativeTerms.add(termDerivative);
    }

    // Initialize the sum of derivatives with the first term
    Function sumOfDerivatives = derivativeTerms.get(0);
    
    // Add the rest of the derivative terms to the sum
    for (int i = 1; i < derivativeTerms.size(); i++) {
        sumOfDerivatives = new BinaryOp(
            BinaryOp.Operator.ADD,
            sumOfDerivatives,
            derivativeTerms.get(i)
        );
    }
    
    return sumOfDerivatives;
}
      // Implementation of value() method with no input
    @Override
    public double value() {
        throw new UnsupportedOperationException("Input expected."); // Polynomial requires input
    }


    /**
     * Returns the power of the polynomial.
     *
     * @return The power of the polynomial.
     */
    public double getPower() {
        return power;
    }

    /**
     * Returns the operand of the polynomial.
     *
     * @return The operand of the polynomial.
     */
    public Function getOperand() {
        return operand;
    }

    /**
     * Checks if this Polynomial is equal to another object.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Polynomial that = (Polynomial) obj;
        return Double.compare(that.power, power) == 0 && operand.equals(that.operand);
    }

    /**
     * Returns the string representation of the polynomial.
     *
     * @return The string representation of the polynomial.
     */
    @Override
    public String toString() {
        String operandString = operand instanceof BinaryOp ? "(" + operand + ")" : operand.toString();
        return operandString + "^" + power;
    }
    }