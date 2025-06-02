package practice_F.hk2_2223_giai.de3.matrix;

public class SquareMatrix extends Matrix {
    private int size;
    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong đoạn [1, 10]
     * @param size
     */
    public SquareMatrix(int size) {
        /* TODO */
        super(size, size);
        this.size = size;
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo chính của ma trận.
     * @return đường chéo chính của ma trận.
     */
    public double[] principalDiagonal() {
        /* TODO */
        double[] principalDiagonalArray = new double[size];
        for (int i = 0; i < size; i++) {
            principalDiagonalArray[i] = super.get(i, i);
        }
        return principalDiagonalArray;
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo phụ của ma trận.
     * @return đường chéo phụ của ma trận.
     */
    public double[] secondaryDiagonal() {
        /* TODO */
        double[] secondaryDiagonalArray = new double[size];
        for (int i = 0; i < size; i++) {
            secondaryDiagonalArray[i] = super.get(i, size - i - 1);
        }
        return secondaryDiagonalArray;
    }
}
