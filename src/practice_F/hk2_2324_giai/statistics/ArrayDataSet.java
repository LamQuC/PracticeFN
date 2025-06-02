//package hus.oop.mid_term_2024.statistics;
//
//public class ArrayDataSet extends AbstractDataSet {
//    private static final int DEFAULT_CAPACITY = 16;
//    private double[] data;
//    private int size;
//
//    /**
//     * Hàm dựng để khởi tạo dữ liệu.
//     */
//    public ArrayDataSet() {
//        /* TODO */
//    }
//
//    /**
//     * Lấy kích thước của tập dữ liệu.
//     * @return
//     */
//    @Override
//    public int size() {
//        /* TODO */
//        return size;
//    }
//
//    /**
//     * Lấy giá trị của phần tử ở vị trí index.
//     * @param index
//     * @return
//     */
//    @Override
//    public double get(int index) {
//        /* TODO */
//        return 0;
//    }
//
//    /**
//     * Sửa dữ liệu ở vị trí index thành data.
//     * @param data
//     * @param index
//     */
//    @Override
//    public void set(double data, int index) {
//        /* TODO */
//    }
//
//    /**
//     * Thêm phần tử dữ liệu vào cuối mảng dữ liệu.
//     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
//     * @param value là giá trị của phần tử dữ liệu được thêm vào.
//     */
//    @Override
//    public void append(double value) {
//        /* TODO */
//    }
//
//    /**
//     * Thêm phần tử dữ liệu vào vị trí index của mảng dữ liệu.
//     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
//     * @param value
//     * @param index
//     */
//    @Override
//    public void insert(double value, int index) {
//        /* TODO */
//    }
//
//    /**
//     * Xóa phần tử dữ liệu tại vị trí index.
//     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size - 1)]
//     * @param index
//     */
//    @Override
//    public void remove(int index) {
//        /* TODO */
//    }
//
//    /**
//     * Mở rộng gấp đôi kích thước mảng nếu hết chỗ để chứa dữ liệu.
//     */
//    private void allocateMore() {
//        /* TODO */
//    }
//
//    /**
//     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
//     * @return
//     */
//    @Override
//    public double[] toArray() {
//        /* TODO */
//        return null;
//    }
//}
package hus.oop.mid_term_2024.statistics;

import java.util.Arrays;

public class ArrayDataSet extends AbstractDataSet {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    public ArrayDataSet() {
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public double get(int index) {
        if (!checkBoundaries(index, size - 1)) throw new IndexOutOfBoundsException();
        return data[index];
    }

    @Override
    public void set(double value, int index) {
        if (!checkBoundaries(index, size - 1)) throw new IndexOutOfBoundsException();
        data[index] = value;
    }

    @Override
    public void append(double value) {
        if (size >= data.length) allocateMore();
        data[size++] = value;
    }

    @Override
    public void insert(double value, int index) {
        if (!checkBoundaries(index, size)) throw new IndexOutOfBoundsException();
        if (size >= data.length) allocateMore();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        if (!checkBoundaries(index, size - 1)) throw new IndexOutOfBoundsException();
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }

    private void allocateMore() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public double[] toArray() {
        return Arrays.copyOf(data, size);
    }
}
