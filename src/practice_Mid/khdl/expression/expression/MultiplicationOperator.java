package practice_Mid.khdl.expression.expression;

public class MultiplicationOperator implements Operator {
    @Override
    public double doOperation(Evaluable leftOperand, Evaluable rightOperand) {
        /* TODO */
        return leftOperand.evaluate() * rightOperand.evaluate();
    }
}
