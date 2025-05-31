package hk1_2425_giai.rootsolver;

public class UnivariateRealFunction implements AbstractFunction {
    @Override
    public double evaluate(double x) {
        /* TODO */
        return MyMath.sin(x) * x - 3;
    }

    @Override
    public double derivative(double x) {
        /* TODO */
        return MyMath.sin(x) + x * MyMath.cos(x);
    }
}
