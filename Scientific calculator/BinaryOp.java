/**
 * Represents a binary operator (+, -, *, /) and two function operands.
 */
public class BinaryOp implements Function {
    public enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    private final Operator operator;
    private final Function leftOperand;
    private final Function rightOperand;

    /**
     * Constructs a BinaryOp object with the specified operator and operands.
     *
     * @param operator     The binary operator.
     * @param leftOperand  The left operand.
     * @param rightOperand The right operand.
     */
    public BinaryOp(Operator operator, Function leftOperand, Function rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    /**
     * Returns the value of the binary operation.
     *
     * @param x The input value (ignored).
     * @return The value of the binary operation.
     */
    @Override
    public double value(double x) {
        double leftValue = leftOperand.value(x);
        double rightValue = rightOperand.value(x);
        switch (operator) {
            case ADD:
                return leftValue + rightValue;
            case SUBTRACT:
                return leftValue - rightValue;
            case MULTIPLY:
                return leftValue * rightValue;
            case DIVIDE:
                if (rightValue == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return leftValue / rightValue;
            default:
                throw new UnsupportedOperationException("Unsupported operator");
        }
    }

    /**
     * Returns the derivative of the binary operation using the chain rule.
     *
     * @return The derivative of the binary operation.
     */
    @Override
    public Function derivative() {
        switch (operator) {
            case ADD:
                return new BinaryOp(Operator.ADD, leftOperand.derivative(), rightOperand.derivative());
            case SUBTRACT:
                return new BinaryOp(Operator.SUBTRACT, leftOperand.derivative(), rightOperand.derivative());
            case MULTIPLY:
                return new BinaryOp(Operator.ADD,
                        new BinaryOp(Operator.MULTIPLY, leftOperand.derivative(), rightOperand),
                        new BinaryOp(Operator.MULTIPLY, leftOperand, rightOperand.derivative()));
            case DIVIDE:
                return new BinaryOp(Operator.DIVIDE,
                        new BinaryOp(Operator.SUBTRACT,
                                new BinaryOp(Operator.MULTIPLY, leftOperand.derivative(), rightOperand),
                                new BinaryOp(Operator.MULTIPLY, leftOperand, rightOperand.derivative())),
                        new BinaryOp(Operator.MULTIPLY, rightOperand, rightOperand));
            default:
                throw new UnsupportedOperationException("Unsupported operator");
        }
    }
    
 // Implementation of value() method with no input
    @Override
    public double value() {
        return value(10); // Default input value of 10
    }
    /**
     * Returns the binary operator.
     *
     * @return The binary operator.
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * Returns the left operand.
     *
     * @return The left operand.
     */
    public Function getLeftOperand() {
        return leftOperand;
    }

    /**
     * Returns the right operand.
     *
     * @return The right operand.
     */
    public Function getRightOperand() {
        return rightOperand;
    }

    /**
     * Checks if this BinaryOp is equal to another object.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BinaryOp binaryOp = (BinaryOp) obj;
        return operator == binaryOp.operator &&
                leftOperand.equals(binaryOp.leftOperand) &&
                rightOperand.equals(binaryOp.rightOperand);
    }

    /**
     * Returns the string representation of the binary operation.
     *
     * @return The string representation of the binary operation.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (leftOperand instanceof BinaryOp && ((BinaryOp) leftOperand).operator != operator) {
            builder.append("(").append(leftOperand).append(")");
        } else {
            builder.append(leftOperand);
        }
        builder.append(" ");
        switch (operator) {
            case ADD:
                builder.append("+");
                break;
            case SUBTRACT:
                builder.append("-");
                break;
            case MULTIPLY:
                builder.append("*");
                break;
            case DIVIDE:
                builder.append("/");
                break;
        }
        builder.append(" ");
        if (rightOperand instanceof BinaryOp && ((BinaryOp) rightOperand).operator != operator) {
            builder.append("(").append(rightOperand).append(")");
        } else {
            builder.append(rightOperand);
        }
        return builder.toString();
    }
}