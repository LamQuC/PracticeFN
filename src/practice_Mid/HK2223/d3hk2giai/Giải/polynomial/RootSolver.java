package practice_Mid.HK2223.d3hk2giai.Giải.polynomial;

public interface RootSolver {
    /**
     * Tìm nghiệm của đa thức trong khoảng [lower, upper]
     * @param polynomial
     * @param lower
     * @param upper
     * @return nghiệm của đa thức.
     */
    double solve(Polynomial polynomial, double lower, double upper);
}
