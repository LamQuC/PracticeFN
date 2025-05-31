package hk2_2223_giai.de1.matrix;

import java.util.Arrays;

public class SquareMatrixTestDrive {
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
        int size = 5 + (int)(Math.random() * 6);
        SquareMatrix matrix1 = new SquareMatrix(size);
        System.out.println("Matrix 1: \n" + matrix1);
        System.out.println("Transpose of matrix 1: \n" + matrix1.transpose());
        System.out.println("Principal diagonal of matrix 1: \n" +
                Arrays.toString(matrix1.principalDiagonal()));
        System.out.println("Secondary diagonal of matrix 1: \n" +
                Arrays.toString(matrix1.secondaryDiagonal()));
        System.out.println();
        SquareMatrix matrix2 = new SquareMatrix(size);
        System.out.println("Matrix 2: \n" + matrix2);
        System.out.println("Transpose of matrix 2: \n" + matrix2.transpose());
        System.out.println("Principal diagonal of matrix 2: \n" +
                Arrays.toString(matrix2.principalDiagonal()));
        System.out.println("Secondary diagonal of matrix 2: \n" +
                Arrays.toString(matrix2.secondaryDiagonal()));
        System.out.println();
        System.out.println("Matrix 1 add matrix 2: \n" + matrix1.add(matrix2));
        System.out.println("Matrix 1 minus matrix 2: \n" + matrix1.minus(matrix2));
        System.out.println("Matrix 1 multiply matrix 2: \n" + matrix1.multiply(matrix2));
        System.out.println();
        System.out.println("Sorted matrix of matrix 1: \n" + matrix1.getSortedMatrix());
        System.out.println();
        System.out.println("Prime numbers in matrix 1: \n" + Arrays.toString(matrix1.primes()));
    }
}
