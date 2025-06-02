package practice_Mid.HK2324giai.d1hk1giai.giai.statistics;

import java.util.ArrayList;

public class ArrayDataSet extends AbstractDataSet {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] data;
    private int size;

    /**
     * Hàm dựng để khởi tạo dữ liệu.
     */
    public ArrayDataSet() {
        /* TODO */
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    @Override
    public double getAt(int index) {
        /* TODO */
        return data[index];
    }

    @Override
    public double[] getAll(int from, int to) {
        double[] result = new double[to - from];
        System.arraycopy(data, from, result, 0, to - from);
        return result;
        /* TODO */
    }

    /**
     * Thêm phần tử dữ liệu vào cuối mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void append(double value) {
        /* TODO */
        if(size >= data.length){
            allocateMore();
        }
        data[size++] = value;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param index
     * @param value
     */
    @Override
    public void insert(int index, double value) {
        /* TODO */
        allocateMore();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */

        System.arraycopy(data, index + 1, data, index, size - index - 1);
    }

    /**
     * Xóa tất cả các phần tử dữ liệu có giá trị bằng value trong tập dữ liệu.
     * @param value
     */
    @Override
    public void remove(double value) {
        /* TODO */
        ArrayList<Double> copy = new ArrayList<>();
        for (double i : data) {
            copy.add(i);
        }
        while (copy.contains(value)) {
            copy.remove(value);
        }
        data = new double[copy.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = copy.get(i);
        }
        size = copy.size();

    }

    /**
     * Mở rộng gấp đôi kích thước mảng this.data.
     */
    private void allocateMore() {
        /* TODO */
        if (size == data.length) {
            double[] newData = new double[size * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }
}
