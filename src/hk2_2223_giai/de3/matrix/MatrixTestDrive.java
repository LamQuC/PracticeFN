package hk2_2223_giai.de3.matrix;

public class MatrixTestDrive {
    public static void main(String[] args) {
        /* TODO
        Tạo ra 2 ma trận vuông có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10].
        Các phần tử của ma trận được khởi tạo ngẫu nhiên có giá trị nằm trong đoạn [1, 10].
        */
        SquareMatrix matrix1 = new SquareMatrix(5);
        SquareMatrix matrix2 = new SquareMatrix(5);
        /*
        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - Tìm và in ra một ma trận dạng hình thang theo hàng (row echelon form) dùng phép khử Gauss của 2 ma trận.
          - Tìm và in ra ma trận dạng hình thang theo hàng rút gọn (reduced row echelon form) dùng phép khử Gauss-Jordan.
         */
        System.out.println("Matrix 1:");
        System.out.println(matrix1);
        System.out.println("Matrix 1 Transpose:");
        System.out.println(matrix1.transpose());
        System.out.println("Matrix 2:");
        System.out.println(matrix2);
        System.out.println("Matrix 2 Transpose:");
        System.out.println(matrix2.transpose());
        System.out.println("Matrix 1 Principal Diagonal:");
        for (double element : matrix1.principalDiagonal()) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("Matrix 1 Secondary Diagonal:");
        for (double element : matrix1.secondaryDiagonal()) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("Matrix 2 Principal Diagonal:");
        for (double element : matrix2.principalDiagonal()) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("Matrix 2 Secondary Diagonal:");
        for (double element : matrix2.secondaryDiagonal()) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("Matrix 1 + Matrix 2:");
        System.out.println(matrix1.add(matrix2));
        System.out.println("Matrix 1 - Matrix 2:");
        System.out.println(matrix1.minus(matrix2));
        System.out.println("Matrix 1 * Matrix 2:");
        System.out.println(matrix1.multiply(matrix2));

        System.out.println("Matrix 1 gauss:");
        System.out.println(matrix1.gaussianElimination());
        System.out.println("Matrix 1 Row Echelon Form:");
        System.out.println(matrix1.gaussJordanElimination());
        /*
         Lưu kết quả chạy chương trình trên terminal vào file text và nộp cùng source code chương trình.
         File text kết quả được đặt tên như sau: <TenSinhVien_MaSinhVien_Matrix.txt> (Ví dụ, NguyenVanA_123456_Matrix.txt).
         */
    }
}
