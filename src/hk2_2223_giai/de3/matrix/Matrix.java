package hk2_2223_giai.de3.matrix;

import java.util.Random;

public class Matrix {
    private double[][] data;
    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong đoạn [1, 10]
     * @param rows số hàng, columns số cột
     */
    public Matrix(int rows, int columns) {
        /* TODO */
        initRandom(rows, columns);
    }

    private Matrix(double[][] data) {
        this.data = data;
    }

    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong đoạn [1, 10]
     * @param rows số hàng, columns số cột
     */
    private void initRandom(int rows, int columns) {
        /* TODO */
        Random random = new Random();
        data = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = random.nextDouble(10) + 1;
            }
        }
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     * @param row
     * @param col
     * @return
     */
    public double get(int row, int col) {
        /* TODO */
        return data[row][col];
    }

    /**
     * Sửa giá trị phần tử ở vị trí (row, col) thành value.
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, double value) {
        /* TODO */
        data[row][col] = value;
    }

    /**
     * Phương thức sắp xếp các phần tử của ma trận theo thứ tự tăng dần.
     * @return ma trận có các phần tử là phần tử của ma trận ban đầu được sắp xếp theo thứ tự tăng dần.
     * Các phần tử được sắp xếp theo thứ tự từ trái sang phải ở mỗi hàng, và từ trên xuống dưới.
     */
    public Matrix getSortedMatrix() {
        /* TODO */
        double[][] newMatrix = new double[data.length][data.length];
        for (int i = 0; i < newMatrix.length; i++) {
            System.arraycopy(data[i], 0, newMatrix[i], 0, data[i].length);
        }
        for (double[] matrix : newMatrix) {
            sortEachRow(matrix);
        }
        sortByFirstCol(newMatrix);
        return new Matrix(newMatrix);
    }

    private void sortEachRow(double[] row) {
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

    private void swap(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void sortByFirstCol(double[][] matrix) {
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

    private void swapRow(double[][] matrix, int i, int j) {
        double[] temp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = temp;
    }


    /**
     * Phương thức cộng ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận tổng của 2 ma trận.
     */
    public Matrix add(Matrix that) {
        /* TODO */
        double[][] newMatrix = new double[data.length][data[0].length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = data[i][j] + that.get(i, j);
            }
        }
        return new Matrix(newMatrix);
    }

    /**
     * Phương thức trừ ma trận hiện tại cho một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận hiệu của ma trận hiện tại và ma trận truyền vào.
     */
    public Matrix minus(Matrix that) {
        /* TODO */
        double[][] newMatrix = new double[data.length][data[0].length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = data[i][j] - that.get(i, j);
            }
        }
        return new Matrix(newMatrix);
    }

    /**
     * Phương thức nhân ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận nhân của ma trận hiện tại với ma trận truyền vào.
     */
    public Matrix multiply(Matrix that) {
        /* TODO */
        double[][] newMatrix = new double[data.length][that.data[0].length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = 0;
                for (int k = 0; k < data[0].length; k++) {
                    newMatrix[i][j] += data[i][k] * that.data[k][j];
                }
            }
        }
        return new Matrix(newMatrix);
    }

    /**
     * Phương thức nhân ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận hiện tại được nhân với một số vô hướng.
     */
    public Matrix scaled(int value) {
        /* TODO */
        double[][] newMatrix = new double[data.length][data[0].length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = data[i][j] * value;
            }
        }
        return new Matrix(newMatrix);
    }

    /**
     * Phương thức nhân hàng thứ rowIndex của ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận có hàng rowIndex bằng hàng rowIndex của ma trận hiện tại nhân với một số vô hướng.
     */
    public Matrix scaledRow(int value, int rowIndex) {
        /* TODO */
        double[][] newMatrix = new double[data.length][data[0].length];
        for (int i = 0; i < newMatrix.length; i++) {
            if (i == rowIndex) {
                for (int j = 0; j < newMatrix[i].length; j++) {
                    newMatrix[i][j] = data[i][j] * value;
                }
            } else {
                System.arraycopy(data[i], 0, newMatrix[i], 0, data[i].length);
            }
        }
        return new Matrix(newMatrix);
    }

    /**
     * Phương thức nhân cột thứ columnIndex của ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận có cột columnIndex bằng cột columnIndex của ma trận hiện tại nhân với một số vô hướng.
     */
    public Matrix scaledColumn(int value, int columnIndex) {
        /* TODO */
        double[][] newMatrix = new double[data.length][data[0].length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                if (j == columnIndex) {
                    newMatrix[i][j] = data[i][j] * value;
                } else {
                    newMatrix[i][j] = data[i][j];
                }
            }
        }
        return new Matrix(newMatrix);
    }

    /**
     * Phương thức hoán đổi hai hàng của ma trận.
     * @param firstIndex
     * @param secondIndex
     */
    public void swapRows(int firstIndex, int secondIndex) {
        /* TODO */
        double[] temp = data[firstIndex];
        data[firstIndex] = data[secondIndex];
        data[secondIndex] = temp;
    }

    /**
     * Phương thức hoán đổi hai cột của ma trận.
     * @param firstIndex
     * @param secondIndex
     */
    public void swapColumns(int firstIndex, int secondIndex) {
        /* TODO */
        for (int i = 0; i < data.length; i++) {
            double temp = data[i][firstIndex];
            data[i][firstIndex] = data[i][secondIndex];
            data[i][secondIndex] = temp;
        }
    }

    /**
     * Phương thức cộng hàng destIndex của ma trận với hàng sourceIndex của ma trận được nhân với một số value.
     * @param value
     * @param sourceIndex
     * @param destIndex
     */
    public void addRow(double value, int sourceIndex, int destIndex) {
        /* TODO */
        for (int i = 0; i < data[0].length; i++) {
            data[destIndex][i] += data[sourceIndex][i] * value;
        }
    }

    /**
     * Phương thức cộng cột destIndex của ma trận với cột sourceIndex của ma trận được nhân với một số value.
     * @param value
     * @param sourceIndex
     * @param destIndex
     */
    public void addColumn(double value, int sourceIndex, int destIndex) {
        /* TODO */
        for (int i = 0; i < data.length; i++) {
            data[i][destIndex] += data[i][sourceIndex] * value;
        }
    }

    /**
     * Phương thức lấy ma trận chuyển vị.
     * @return ma trận mới là ma trận chuyển vị của ma trận hiện tại.
     */
    public Matrix transpose() {
        /* TODO */
        double[][] newMatrix = new double[data[0].length][data.length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = data[j][i];
            }
        }
        return new Matrix(newMatrix);
    }

    /**
     * Phương thức lấy ra ma trận dạng hình thang theo hàng (row echelon form)
     * sau khi thực hiện phép khử Gauss.
     * @return ma trận dạng hình thang theo hàng.
     */
    public Matrix gaussianElimination() {
        /* TODO */
        double[][] newMatrix = copyMatrix(data);
        Matrix result = new Matrix(newMatrix);
        for (int i = 0; i < newMatrix.length; i++) {
            swap(result, i);
            if (result.get(i, i) == 0) {
                continue;
            }
            eliminationDown(result, i);
        }
        return result;
    }

    private double[][] copyMatrix(double[][] matrix) {
        double[][] newMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < newMatrix.length; i++) {
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, matrix[i].length);
        }
        return newMatrix;
    }

    private void swap(Matrix matrix, int i) {
        if (matrix.get(i, i) == 0) {
            for (int j = i + 1; j < matrix.data.length; j++) {
                if (matrix.get(j, i) != 0) {
                    matrix.swapRows(i, j);
                    break;
                }
            }
        }
    }

    private void eliminationDown(Matrix matrix, int i) {
        for (int j = i + 1; j < matrix.data.length; j++) {
            double factor = matrix.get(j, i) / matrix.get(i, i);
            matrix.addRow(-factor, i, j);
        }
    }
    /**
     * Phương thức lấy ra ma trận dạng hình thang theo hàng rút gọn (reduced row echelon form)
     * sau khi thực hiện phép khử Gauss-Jordan
     * @return
     */
    public Matrix gaussJordanElimination() {
        /* TODO */
        double[][] newMatrix = gaussianElimination().data;
        Matrix result = new Matrix(newMatrix);
        for (int i = newMatrix.length - 1; i >= 0; i--) {
            if (result.get(i, i) == 0) {
                continue;
            }
            eliminationUp(result, i);
        }
        return result;
    }

    private void eliminationUp( Matrix matrix, int i) {
        for (int j = i - 1; j >= 0; j--) {
            double factor = matrix.get(j, i) / matrix.get(i, i);
            matrix.addRow(-factor, i, j);
        }
    }

    /**
     * Biểu diễn ma trận theo định dạng
     * a11 a12 ... a1n
     * a21 a22 ... a2n
     * ...
     * am1 am2 ... amn
     * @return một chuỗi biểu diễn ma trận.
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder result = new StringBuilder();
        for (double[] row : data) {
            for (double value : row) {
                result.append(value).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
