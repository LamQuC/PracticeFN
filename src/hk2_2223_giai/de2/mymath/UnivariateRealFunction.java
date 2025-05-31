package hk2_2223_giai.de2.mymath;

public class UnivariateRealFunction implements AbstractFunction {
    public UnivariateRealFunction() {
    }

    public double evaluate(double x) {
        MyMath myMath = new MyMath();
        return x * myMath.sin(x) - 3;
    }

    public double derivative(double x) {
        MyMath myMath = new MyMath();
        return myMath.sin(x) + x * myMath.cos(x);
    }
}
