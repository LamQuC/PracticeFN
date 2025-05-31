package hk2_2223_giai.de2.mymath;

public class RootFindingTestDrive {
    public static void main(String[] args) {
        testRootSolver();
    }

    public static void testRootSolver() {
        AbstractFunction function =
                new UnivariateRealFunction();
        UnivariateRealRootFinding finding =
                new UnivariateRealRootFinding(function);
        finding.rootSolver =
                new BisectionSolver(0.000001, 500);
        System.out.println("BisectionSolver: " + finding.solve(12, 14));
        finding.rootSolver =
                new SecantSolver(0.000001, 500);
        System.out.println("SecantSolver: " + finding.solve(12, 14));
        finding.rootSolver =
                new NewtonRaphsonSolver(0.000001, 500);
        System.out.println("NewtonRaphsonSolver: " + finding.solve(12, 14));
        /*
        Các kết qủa có thể khác nhau nhưng chúng đều là nghiệm của
        phương trình xsinx - 3 = 0
        */
    }
}
