package practice_F.hk1_2425_giai.rootsolver;

public class TestRootFinding {
    public static void main(String[] args) {
        /* TODO
        Chạy các hàm test để test chương trình.
        Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_RootSolver>.txt
        (ví dụ, NguyenVanA_123456_RootSolver.txt).
        Nén tất cả các file source code và file kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_RootSolver>.zip (ví dụ, NguyenVanA_123456_RootSolver.txt), và nộp bài
        lên classroom.
        */
        testRootSolver();
    }

    public static void testRootSolver() {
        /* TODO
         - Viết chương trình tìm nghiệm của hàm (sin(x).x - 3) theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           UnivariateRealRootFinding. Các phương pháp tìm nghiệm có thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, hàm và nghiệm tìm được trong khoảng [a, b] đã cho.
         */
        AbstractFunction f = new UnivariateRealFunction();

        RootSolver[] solvers = new RootSolver[] {
                new BisectionSolver(1e-8, 100),
                new NewtonRaphsonSolver(1e-8, 100),
                new SecantSolver(1e-8, 100)
        };

        String[] solverNames = {"Bisection", "Newton-Raphson", "Secant"};

        double lower = 0;
        double upper = 3;

        for (int i = 0; i < solvers.length; i++) {
            UnivariateRealRootFinding finder = new UnivariateRealRootFinding(f, solvers[i]);
            double root = finder.solve(lower, upper);
            System.out.printf("Method: %s, Root of sin(x)*x - 3 in [%.2f, %.2f] = %.10f%n",
                    solverNames[i], lower, upper, root);
        }
    }
}
