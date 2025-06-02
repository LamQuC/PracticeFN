package practice_F.hk2_2223_giai.de1.matrix;

import java.util.ArrayList;

public class SquareMatrix {
    private int[][] data;

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong khoảng [1, 100]
     * @param size
     */
    public SquareMatrix(int size) {
        initRandom(size);
    }

    public SquareMatrix(int[][] data) {
        this.data = data;
    }

    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong khoảng [1, 100]
     * @param size
     */
    private void initRandom(int size) {
        /* TODO */
        data = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = (int) (1 + Math.random() * 100);
            }
        }
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo chính của ma trận.
     * @return đường chéo chính của ma trận.
     */
    public int[] principalDiagonal() {
        /* TODO */
        int[] diagonal = new int[data.length];
        for (int i = 0; i < diagonal.length; i++) {
            diagonal[i] = data[i][i];
        }
        return diagonal;
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo phụ của ma trận.
     * @return đường chéo phụ của ma trận.
     */
    public int[] secondaryDiagonal() {
        /* TODO */
        int[] diagonal = new int[data.length];
        for (int i = 0; i < diagonal.length; i++) {
            diagonal[i] = data[i][data.length - 1 - i];
        }
        return diagonal;
    }

    /**
     * Phương thức lấy ra các số là số nguyên tố trong ma trận.
     * @return các số nguyên tố trong ma trận.
     */
    public int[] primes() {
        /* TODO */
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (isPrime(data[i][j])) {
                    primes.add(i);
                }
            }
        }
        return primes.stream().mapToInt(i -> i).toArray();
    }

    private boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Phương thức sắp xếp các phần tử của ma trận theo thứ tự tăng dần.
     * @return ma trận có các phần tử là phần tử của ma trận ban đầu được sắp xếp theo thứ tự tăng dần.
     * Các phần tử được sắp xếp theo thứ tự từ trái sang phải ở mỗi hàng, và từ trên xuống dưới.
     */
    public SquareMatrix getSortedMatrix() {
        /* TODO */
        int[][] newMatrix = new int[data.length][data.length];
        for (int i = 0; i < newMatrix.length; i++) {
            System.arraycopy(data[i], 0, newMatrix[i], 0, data[i].length);
        }
        for (int[] matrix : newMatrix) {
            sortEachRow(matrix);
        }
        sortByFirstCol(newMatrix);
        return new SquareMatrix(newMatrix);
    }

    private void sortEachRow(int[] row) {
        boolean swapped;
        for (int i = 0; i < row.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < row.length - i - 1; j++) {
                if (row[j] > row[j + 1]) {
                    swapped = true;
                    swap(row, j, j + 1);
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void sortByFirstCol(int[][] matrix) {
        boolean swapped;
        for (int i = 0; i < matrix.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < matrix.length - i - 1; j++) {
                if (matrix[j][0] > matrix[j + 1][0]) {
                    swapped = true;
                    swapRow(matrix, j, j + 1);
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private void swapRow(int[][] matrix, int i, int j) {
        int[] temp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = temp;
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     * @param row
     * @param col
     * @return
     */
    public int get(int row, int col) {
        /* TODO */
        return data[row][col];
    }

    /**
     * Sửa giá trị phần tử ở vị trí (row, col) thành value.
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, int value) {
        /* TODO */
        data[row][col] = value;
    }

    /**
     * Phương thức cộng ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận tổng của 2 ma trận.
     */
    public SquareMatrix add(SquareMatrix that) {
        /* TODO */
        int[][] newMatrix = new int[data.length][data.length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                newMatrix[i][j] = data[i][j] + that.get(i, j);
            }
        }
        return new SquareMatrix(newMatrix);
    }

    /**
     * Phương thức trừ ma trận hiện tại cho một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận hiệu của ma trận hiện tại và ma trận truyền vào.
     */
    public SquareMatrix minus(SquareMatrix that) {
        /* TODO */
        int[][] newMatrix = new int[data.length][data.length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                newMatrix[i][j] = data[i][j] - that.get(i, j);
            }
        }
        return new SquareMatrix(newMatrix);
    }

    /**
     * Phương thức nhân ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận nhân của ma trận hiện tại với ma trận truyền vào.
     */
    public SquareMatrix multiply(SquareMatrix that) {
        /* TODO */
        int[][] newMatrix = new int[data.length][data.length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                for (int k = 0; k < newMatrix.length; k++) {
                    newMatrix[i][j] += data[i][k] * that.get(k, j);
                }
            }
        }
        return new SquareMatrix(newMatrix);
    }

    /**
     * Phương thức nhân ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận hiện tại được nhân với một số vô hướng.
     */
    public SquareMatrix scaled(int value) {
        /* TODO */
        int[][] newMatrix = new int[data.length][data.length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                newMatrix[i][j] = data[i][j] * value;
            }
        }
        return new SquareMatrix(newMatrix);
    }

    /**
     * Phương thức lấy ma trận chuyển vị.
     * @return ma trận mới là ma trận chuyển vị của ma trận hiện tại.
     */
    public SquareMatrix transpose() {
        /* TODO */
        int[][] newMatrix = new int[data.length][data.length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                newMatrix[j][i] = data[i][j];
            }
        }
        return new SquareMatrix(newMatrix);
    }

    /**
     * Mô tả ma trận theo định dạng biểu diễn ma trận, ví dụ
     *   1 2 3
     *   4 5 6
     *   7 8 9
     * @return một chuỗi mô tả ma trận.
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        for (int[] datum : data) {
            for (int j = 0; j < data.length; j++) {
                sb.append(datum[j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
