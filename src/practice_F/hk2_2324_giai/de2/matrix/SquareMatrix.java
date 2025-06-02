package practice_F.hk2_2324_giai.de2.matrix;

public class SquareMatrix extends Matrix {

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong đoạn [1, 10]
     * @param size
     */
    public SquareMatrix(int size) {
        /* TODO */
        super(size, size);
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo chính của ma trận.
     * @return đường chéo chính của ma trận.
     */
    public double[] principalDiagonal() {
        /* TODO */
        int n = getColumnCount();
        double[] diag = new double[n];
        for (int i = 0; i < n; i++) {
            diag[i] = this.get(i, i);
        }
        return diag;
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo phụ của ma trận.
     * @return đường chéo phụ của ma trận.
     */
    public double[] secondaryDiagonal() {
        /* TODO */
        int n = getColumnCount();
        double[] diag = new double[n];
        for (int i = 0; i < n; i++) {
            diag[i] = this.get(i, n - i - 1);
        }
        return diag;
    }
}
