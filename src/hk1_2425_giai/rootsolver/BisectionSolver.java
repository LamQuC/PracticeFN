package hk1_2425_giai.rootsolver;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp chia đôi (Bisection)
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double a = lower;
        double b = upper;
        double c = a;
        for (int i = 0; i < maxIterations; i++) {
            c = (a + b) / 2;
            double f_c = function.evaluate(c);
            if (Math.abs(f_c) < tolerance || Math.abs(b - a) < tolerance)
                return c;
            if (f_c * function.evaluate(a) < 0) b = c;
            else a = c;
        }
        return c;
    }
}
