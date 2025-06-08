package practice_Mid.HK2223.de1hk2.dataset;

import java.util.ArrayList;
import java.util.List;

public class MyListPolynomial extends MyAbstractPolynomial {
    private List<Double> coefficients;

    public MyListPolynomial() {
        coefficients = new ArrayList<>();
    }

    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= coefficients.size()) return 0;
        return coefficients.get(index);
    }

    @Override
    public double[] coefficients() {
        double[] result = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            result[i] = coefficients.get(i);
        }
        return result;
    }

    @Override
    public MyListPolynomial append(double coefficient) {
        coefficients.add(coefficient);
        return this;
    }

    @Override
    public MyListPolynomial add(double coefficient, int index) {
        if (index < 0) return this;
        while (index >= coefficients.size()) {
            coefficients.add(0.0);
        }
        coefficients.set(index, coefficients.get(index) + coefficient);
        return this;
    }

    @Override
    public MyListPolynomial set(double coefficient, int index) {
        if (index < 0) return this;
        while (index >= coefficients.size()) {
            coefficients.add(0.0);
        }
        coefficients.set(index, coefficient);
        return this;
    }

    @Override
    public int degree() {
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) != 0) return i;
        }
        return 0;
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            result = result * x + coefficients.get(i);
        }
        return result;
    }

    @Override
    public MyListPolynomial derivative() {
        MyListPolynomial result = new MyListPolynomial();
        double[] deriv = differentiate();
        for (double coeff : deriv) {
            result.append(coeff);
        }
        return result;
    }

    @Override
    public MyListPolynomial plus(MyPolynomial right) {
        MyListPolynomial result = new MyListPolynomial();
        double[] rightCoeffs = right.coefficients();
        int maxSize = Math.max(coefficients.size(), rightCoeffs.length);
        for (int i = 0; i < maxSize; i++) {
            double sum = coefficient(i) + right.coefficient(i);
            result.append(sum);
        }
        return result;
    }

    @Override
    public MyListPolynomial minus(MyPolynomial right) {
        MyListPolynomial result = new MyListPolynomial();
        double[] rightCoeffs = right.coefficients();
        int maxSize = Math.max(coefficients.size(), rightCoeffs.length);
        for (int i = 0; i < maxSize; i++) {
            double diff = coefficient(i) - right.coefficient(i);
            result.append(diff);
        }
        return result;
    }

    @Override
    public MyListPolynomial multiply(MyPolynomial right) {
        MyListPolynomial result = new MyListPolynomial();
        double[] rightCoeffs = right.coefficients();
        for (int i = 0; i < coefficients.size(); i++) {
            for (int j = 0; j < rightCoeffs.length; j++) {
                double product = coefficients.get(i) * rightCoeffs[j];
                result.add(product, i + j);
            }
        }
        return result;
    }
}