package practice_Mid.khdl.expression.expression;

public class DivisionOperator implements Operator {
    @Override
    public double doOperation(Evaluable leftOperand, Evaluable rightOperand) {
        /* TODO */
        return leftOperand.evaluate() / rightOperand.evaluate();
    }
}
