package hk1_2425_giai.rootsolver;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến sử dụng phương pháp Newton-Raphson.
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double x = (lower + upper) / 2;
        for (int i = 0; i < maxIterations; i++) {
            double f_x = function.evaluate(x);
            double df_x = function.derivative(x);
            if (Math.abs(df_x) < 1e-15) break;
            double x_new = x - f_x / df_x;
            if (Math.abs(x_new - x) < tolerance) return x_new;
            x = x_new;
        }
        return x;
    }
}
