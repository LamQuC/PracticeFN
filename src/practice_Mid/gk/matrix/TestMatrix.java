package practice_Mid.gk.matrix;

import java.io.PrintWriter;
import java.io.File;
import java.util.Arrays;

public class TestMatrix {
    public static void main(String[] args) {
        /* TODO
        Tạo ra 2 ma trận có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10].
        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - In ra các số nguyên tố có trong 2 ma trận.

         Lưu kết quả chạy chương trình trên terminal vào file text và nộp cùng source code chương trình.
         File text kết quả được đặt tên như sau: <TenSinhVien_MaSinhVien_Matrix.txt> (Ví dụ, NguyenVanA_123456_Matrix.txt).
         */

        // The result was saved to .txt file
        try (PrintWriter writer = new PrintWriter(new File("NguyenVanA_123456_Matrix.txt"))) {
            java.util.Random rand = new java.util.Random();
            int size = rand.nextInt(6) + 5; // Random size from 5 to 10
            MySquareMatrix matrix1 = new MySquareMatrix(size);
            MySquareMatrix matrix2 = new MySquareMatrix(size);

            writer.println("Matrix 1:");
            writer.println(matrix1);
            writer.println("Transpose of Matrix 1:");
            writer.println(matrix1.transpose());
            writer.println("Principal Diagonal of Matrix 1: " + Arrays.toString(matrix1.principalDiagonal()));
            writer.println("Secondary Diagonal of Matrix 1: " + Arrays.toString(matrix1.secondaryDiagonal()));
            writer.println("Primes in Matrix 1: " + Arrays.toString(matrix1.primes()));
            writer.println();

            writer.println("Matrix 2:");
            writer.println(matrix2);
            writer.println("Transpose of Matrix 2:");
            writer.println(matrix2.transpose());
            writer.println("Principal Diagonal of Matrix 2: " + Arrays.toString(matrix2.principalDiagonal()));
            writer.println("Secondary Diagonal of Matrix 2: " + Arrays.toString(matrix2.secondaryDiagonal()));
            writer.println("Primes in Matrix 2: " + Arrays.toString(matrix2.primes()));
            writer.println();

            writer.println("Sum of Matrix 1 and Matrix 2:");
            writer.println(matrix1.add(matrix2));
            writer.println("Difference of Matrix 1 and Matrix 2:");
            writer.println(matrix1.minus(matrix2));
            writer.println("Product of Matrix 1 and Matrix 2:");
            writer.println(matrix1.multiply(matrix2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}