package hk1_2324_giai.integration;

public class TrapezoidMethod extends AbstractIntegrator {
    public TrapezoidMethod(double precision, int maxIterations) {
        /* TODO */
        super(precision, maxIterations);
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân. Giá trị xấp xỉ được chấp nhận nếu phép tính đạt độ chính xác đã cho,
     * hoặc có số vòng lặp vượt quá ngưỡng quy định.
     * Độ chính xác được xác định như sau, chọn n0 tùy ý, sau đó tính I_n với n = n_0, 2n_0, 4n_0, ...
     * Việc tính toán dừng lại khi |I_2n - I_n|/3 < eps (precision), hoặc số lần chia đôi vượt quá ngưỡng quy định (maxIterations).
     * @param polynomial
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double integrate(MyPolynomial polynomial, double lower, double upper) {
        /* TODO */
        int n = 1;
        double I_n = integrate(polynomial, lower, upper, n);
        double I_2n = integrate(polynomial, lower, upper, 2 * n);
        while (Math.abs(I_2n - I_n) / 3 >= getPrecision() && n < getMaxIterations()) {
            n *= 2;
            I_n = I_2n;
            I_2n = integrate(polynomial, lower, upper, 2 * n);
        }
        return I_2n;
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân với numOfSubIntervals khoảng phân hoạch đều.
     * @param polynomial
     * @param lower
     * @param upper
     * @param numOfSubIntervals
     * @return giá trị xấp xỉ giá trị tích phân.
     */
    private double integrate(MyPolynomial polynomial, double lower, double upper, int numOfSubIntervals) {
        /* TODO */
        double h = (upper - lower) / numOfSubIntervals;
        double result = h * (polynomial.evaluate(lower) + polynomial.evaluate(upper)) / 2;
        for (int i = 1; i < numOfSubIntervals; i++) {
            double x0 = lower + i * h;
            double x1 = lower + (i + 1) * h;
            result += (polynomial.evaluate(x0) + polynomial.evaluate(x1)) * h / 2;
        }
        return result;
    }
}
