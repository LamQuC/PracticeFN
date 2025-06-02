package practice_Mid.HK2122giai.poly;

public class ArrayPoly extends AbstractPoly {
    private int[] coeffs;

    public ArrayPoly(int[] coeffs) {
        this.coeffs = coeffs;
        reduce();
    }

    @Override
    public int coefficient(int i) {
        return i < coeffs.length ? coeffs[i] : 0;
    }

    @Override
    public int[] coefficients() {
        return coeffs;
    }

    @Override
    public int degree() {
        return degree;
    }

    @Override
    public Poly derivative() {
        return new ArrayPoly(differentiate(coeffs));
    }

    @Override
    public double evaluate(double x) {
        double sum = 0;
        for (int i = 0; i < coeffs.length; i++) {
            sum += coeffs[i] * Math.pow(x, i);
        }
        return sum;
    }

    public void reduce() {
        degree = coeffs.length - 1;
        while (degree > 0 && coeffs[degree] == 0) degree--;
    }

    public String type() {
        return "Array Poly";
    }
}

