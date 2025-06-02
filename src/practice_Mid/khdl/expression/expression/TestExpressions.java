package practice_Mid.khdl.expression.expression;

public class TestExpressions {
    public static void main(String[] args) {
        /* TODO */
        /* Viết code đề mô tính biểu thức (1 + 2) * 3 - 4 */
        Evaluable add = new Operand(new AdditionOperator().doOperation(
                new Operand(1), new Operand(2)
        ));
        Evaluable mul = new Operand(new MultiplicationOperator().doOperation(
                add, new Operand(3)
        ));
        Evaluable sub = new Operand(new SubtractionOperator().doOperation(
                mul, new Operand(4)
        ));
        System.out.println(sub.evaluate());
    }
}
