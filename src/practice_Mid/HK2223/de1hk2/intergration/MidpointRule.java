package practice_Mid.HK2223.de1hk2.dataset;

public class MidpointRule implements MyIntegrator {
    private double precision;
    private int maxIterations;

    public MidpointRule(double precision, int maxIterations) {
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    @Override
    public double integrate(MyPolynomial polynomial, double lower, double upper) {
        int n = 10; // Initial number of subintervals
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
        double h = (upper - lower) / numOfSubIntervals;
        double sum = 0.0;
        for (int i = 0; i < numOfSubIntervals; i++) {
            double x = lower + (i + 0.5) * h;
            sum += polynomial.evaluate(x);
        }
        return sum * h;
    }
}
