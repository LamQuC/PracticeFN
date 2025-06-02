package practice_F.lab12.integration;

import java.io.PrintWriter;

public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) {
        /*
         TODO

         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        try (PrintWriter writer = new PrintWriter("integration/LeQuocLam_21002153_Integration.txt")) {
            writer.println("Test ArrayPolynomial:");
            testArrayPolynomial(writer);
            writer.println("\nTest ListPolynomial:");
            testListPolynomial(writer);
            writer.println("\nTest IntegrationCalculator:");
            testIntegrationCalculator(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testArrayPolynomial(PrintWriter writer) {
        /*
         TODO

         - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        ArrayPolynomial p1 = new ArrayPolynomial().append(1).append(2).append(3); // 1 + 2x + 3x^2
        ArrayPolynomial p2 = new ArrayPolynomial().append(2).append(1); // 2 + x
        writer.println("p1 = " + p1);
        writer.println("p2 = " + p2);
        writer.println("p1 degree: " + p1.degree());
        writer.println("p1 at x=2: " + p1.evaluate(2));
        writer.println("p1 derivative: " + p1.derivative());
        writer.println("p1 + p2: " + p1.plus(p2));
        writer.println("p1 - p2: " + p1.minus(p2));
        writer.println("p1 * p2: " + p1.multiply(p2));
    }

    public static void testListPolynomial(PrintWriter writer) {
        /*
         TODO

         - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        ListPolynomial p1 = new ListPolynomial().append(1).append(2).append(3); // 1 + 2x + 3x^2
        ListPolynomial p2 = new ListPolynomial().append(2).append(1); // 2 + x
        writer.println("p1 = " + p1);
        writer.println("p2 = " + p2);
        writer.println("p1 degree: " + p1.degree());
        writer.println("p1 at x=2: " + p1.evaluate(2));
        writer.println("p1 derivative: " + p1.derivative());
        writer.println("p1 + p2: " + p1.plus(p2));
        writer.println("p1 - p2: " + p1.minus(p2));
        writer.println("p1 * p2: " + p1.multiply(p2));

    }

    public static void testIntegrationCalculator(PrintWriter writer) {
        /*
         TODO

         - Tạo một đa thức.
         - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho (MidpointRule, TrapezoidRule, SimpsonRule) sử dụng
           IntegrationCalculator. Các phương pháp tính tích phân có thể thay đổi ở thời gian chạy chương trình.
         - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
         */
        Polynomial poly = new ArrayPolynomial().append(1).append(2).append(1); // 1 + 2x + x^2
        IntegrationCalculator calc = new IntegrationCalculator(poly);
        writer.println("Polynomial: " + poly);

        calc.setIntegrator(new MidpointRule(0.001, 100));
        writer.println("MidpointRule integral [0, 1]: " + calc.integrate(0, 1));

        calc.setIntegrator(new TrapezoidRule(0.001, 100));
        writer.println("TrapezoidRule integral [0, 1]: " + calc.integrate(0, 1));

        calc.setIntegrator(new SimpsonRule(0.001, 100));
        writer.println("SimpsonRule integral [0, 1]: " + calc.integrate(0, 1));

    }
}
