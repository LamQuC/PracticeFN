package practice_Mid.HK2223.de1hk2.dataset;

public class MyArrayPolynomial extends MyAbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    public MyArrayPolynomial() {
        coefficents = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= size) return 0;
        return coefficents[index];
    }

    @Override
    public double[] coefficients() {
        double[] result = new double[size];
        System.arraycopy(coefficents, 0, result, 0, size);
        return result;
    }

    @Override
    public MyArrayPolynomial append(double coefficient) {
        if (size == coefficents.length) {
            allocateMore();
        }
        coefficents[size++] = coefficient;
        return this;
    }

    @Override
    public MyArrayPolynomial add(double coefficient, int index) {
        if (index < 0) return this;
        while (index >= coefficents.length) {
            allocateMore();
        }
        if (index >= size) {
            size = index + 1;
        }
        coefficents[index] += coefficient;
        return this;
    }

    @Override
    public MyArrayPolynomial set(double coefficient, int index) {
        if (index < 0) return this;
        while (index >= coefficents.length) {
            allocateMore();
        }
        if (index >= size) {
            size = index + 1;
        }
        coefficents[index] = coefficient;
        return this;
    }

    @Override
    public int degree() {
        for (int i = size - 1; i >= 0; i--) {
            if (coefficents[i] != 0) return i;
        }
        return 0;
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = size - 1; i >= 0; i--) {
            result = result * x + coefficents[i];
        }
        return result;
    }

    @Override
    public MyArrayPolynomial derivative() {
        MyArrayPolynomial result = new MyArrayPolynomial();
        double[] deriv = differentiate();
        for (double coeff : deriv) {
            result.append(coeff);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial plus(MyPolynomial right) {
        MyArrayPolynomial result = new MyArrayPolynomial();
        double[] rightCoeffs = right.coefficients();
        int maxSize = Math.max(size, rightCoeffs.length);
        for (int i = 0; i < maxSize; i++) {
            double sum = coefficient(i) + right.coefficient(i);
            result.append(sum);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial minus(MyPolynomial right) {
        MyArrayPolynomial result = new MyArrayPolynomial();
        double[] rightCoeffs = right.coefficients();
        int maxSize = Math.max(size, rightCoeffs.length);
        for (int i = 0; i < maxSize; i++) {
            double diff = coefficient(i) - right.coefficient(i);
            result.append(diff);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial multiply(MyPolynomial right) {
        MyArrayPolynomial result = new MyArrayPolynomial();
        double[] rightCoeffs = right.coefficients();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < rightCoeffs.length; j++) {
                double product = coefficents[i] * rightCoeffs[j];
                result.add(product, i + j);
            }
        }
        return result;
    }

    private void allocateMore() {
        double[] newCoeffs = new double[coefficents.length * 2];
        System.arraycopy(coefficents, 0, newCoeffs, 0, coefficents.length);
        coefficents = newCoeffs;
    }
}
