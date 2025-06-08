package practice_Mid.HK2223.de1hk2.dataset;

public class SimpsonRule implements MyIntegrator {
    private double precision;
    private int maxIterations;

    public SimpsonRule(double precision, int maxIterations) {
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    @Override
    public double integrate(MyPolynomial polynomial, double lower, double upper) {
        int n = 10; // Initial number of subintervals (must be even)
        if (n % 2 != 0) n++;
        double prevResult = integrate(polynomial, lower, upper, n);
        int iteration = 0;

        while (iteration < maxIterations) {
            n *= 2;
            double result = integrate(polynomial, lower, upper, n);
            if (Math.abs(result - prevResult) / 3 < precision) {
                return result;
            }
            prevResult = result;
            iteration++;
        }
        return prevResult;
    }

    private double integrate(MyPolynomial polynomial, double lower, double upper, int numOfSubIntervals) {
        if (numOfSubIntervals % 2 != 0) {
            numOfSubIntervals++;
        }
        double h = (upper - lower) / numOfSubIntervals;
        double sum = polynomial.evaluate(lower) + polynomial.evaluate(upper);
        for (int i = 1; i < numOfSubIntervals; i++) {
            double x = lower + i * h;
            sum += (i % 2 == 0) ? 2 * polynomial.evaluate(x) : 4 * polynomial.evaluate(x);
        }
        return sum * h / 3;
    }
}