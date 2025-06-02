package practice_F.hk2_2223_giai.de1.integration;

public class TrapezoidRule implements Integrator {
    private double precision;
    private int maxIterations;

    public TrapezoidRule(double precision, int maxIterations) {
        /* TODO */
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân. Giá trị xấp xỉ được chấp nhận nếu phép tính đạt độ chính xác đã cho,
     * hoặc có số vòng vượt quá ngưỡng quy định.
     * Độ chính xác được xác định như sau, chọn n0 tùy ý, sau đó tính I_n với n = n0, 2n0, 4n0, ...
     * Việc tính toán dừng lại khi |I_2n - In|/3 < eps (precision), hoặc số lần chia đôi vượt quá ngưỡng quy định (maxIterations).
     * @param poly
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double integrate(Polynomial poly, double lower, double upper) {
        /* TODO */
        int n = 1;
        int count = 0;
        double i1 = integrate(poly, lower, upper, n);
        double i2 = integrate(poly, lower, upper, n * 2);
        n *= 4;
        count += 1;
        while (Math.abs(i2 - i1) >= precision * 3 && count <= maxIterations) {
            i1 = i2;
            i2 = integrate(poly, lower, upper, n);
            n *= 2;
            count += 1;
        }
        return i2;
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân với numOfSubIntervals khoảng phân hoạch đều.
     * @param poly
     * @param lower
     * @param upper
     * @param numOfSubIntervals
     * @return giá trị xấp xỉ giá trị tích phân.
     */
    private double integrate(Polynomial poly, double lower, double upper, int numOfSubIntervals) {
        /* TODO */
        double delta = (upper - lower) / numOfSubIntervals;
        double x0 = lower;
        double sum = poly.evaluate(x0);
        x0 += delta;
        for (int i = 1; i < numOfSubIntervals; i++) {
            sum += poly.evaluate(x0) * 2;
            x0 = x0 + delta;
        }
        sum += poly.evaluate(upper);
        return sum * delta / 2;
    }
}
