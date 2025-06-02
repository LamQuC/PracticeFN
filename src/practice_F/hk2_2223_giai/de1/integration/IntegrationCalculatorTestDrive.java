package practice_F.hk2_2223_giai.de1.integration;

public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) {
        /*
         TODO

         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        testArrayPolynomial();
        System.out.println();
        testListPolynomial();
        System.out.println();
        testIntegrationCalculator();
    }

    public static void testArrayPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        double[] coef = {1, 2, 3, 4, 5, 6};
        double[] coef2 = {1, 2, 3, 4, 5, 7, 8};
        ArrayPolynomial arrayPolynomial = new ArrayPolynomial(coef);
        ArrayPolynomial arrayPolynomial2 = new ArrayPolynomial(coef2);
        System.out.println(arrayPolynomial.append(7));
        System.out.println(arrayPolynomial.set(6, 8));
        System.out.println(arrayPolynomial.plus(arrayPolynomial2));
        System.out.println(arrayPolynomial.minus(arrayPolynomial2));
        System.out.println(arrayPolynomial.multiply(arrayPolynomial2));
        System.out.println(arrayPolynomial.evaluate(1));
    }

    public static void testListPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        double[] coef = {1, 2, 3, 4, 5, 6};
        double[] coef2 = {1, 2, 3, 4, 5, 7, 8};
        ListPolynomial listPolynomial = new ListPolynomial(coef);
        ListPolynomial listPolynomial2 = new ListPolynomial(coef2);
        ArrayPolynomial arrayPolynomial = new ArrayPolynomial(coef);
        ArrayPolynomial arrayPolynomial2 = new ArrayPolynomial(coef2);
        System.out.println(arrayPolynomial.append(7));
        System.out.println(arrayPolynomial.set(6, 8));
        System.out.println(arrayPolynomial.plus(arrayPolynomial2));
        System.out.println(arrayPolynomial.minus(arrayPolynomial2));
        System.out.println(arrayPolynomial.multiply(arrayPolynomial2));
        System.out.println(arrayPolynomial.evaluate(1));
    }

    public static void testIntegrationCalculator() {
        /*
         TODO

         - Tạo một đa thức.
         - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho (MidpointRule, TrapezoidRule, SimpsonRule) sử dụng
           IntegrationCalculator. Các phương pháp tính tích phân có thể thay đổi ở thời gian chạy chương trình.
         - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
         */
        double[] coef = {1, 2, 3, 4};
        ListPolynomial listPolynomial = new ListPolynomial(coef);
        TrapezoidRule trapezoidRule = new TrapezoidRule(1E-12, 1000);
        SimpsonRule simpsonRule = new SimpsonRule(1E-12, 1000);
        MidpointRule midpointRule = new MidpointRule(1E-12, 1000);
        IntegrationCalculator integrationCalculator =
                new IntegrationCalculator(trapezoidRule, listPolynomial);
        IntegrationCalculator integrationCalculator1 =
                new IntegrationCalculator(simpsonRule, listPolynomial);
        IntegrationCalculator integrationCalculator2 =
                new IntegrationCalculator(midpointRule, listPolynomial);

        System.out.println(integrationCalculator.integrate(1, 3));
        System.out.println(integrationCalculator1.integrate(1, 3));
        System.out.println(integrationCalculator2.integrate(1, 3));
    }
}
