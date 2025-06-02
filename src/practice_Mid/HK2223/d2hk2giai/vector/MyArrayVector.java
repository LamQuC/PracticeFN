package practice_Mid.HK2223.d2hk2giai.vector;

import java.util.Arrays;

public class MyArrayVector extends AbstractMyVector {
    private static final int DEFAULT_CAPACITY = 10;
    private double[] data;
    private int size;

    public MyArrayVector() {
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    // Add 1 phần tử double vào mảng (KHÔNG trả về, chỉ thêm vào)
    public void add(double d) {
        if (size >= data.length) {
            enlarge();
        }
        data[size++] = d;
    }

    // Cộng 2 vector kiểu MyArrayVector → trả về 1 MyArrayVector mới
    public MyArrayVector add(MyArrayVector v) {
        MyArrayVector result = new MyArrayVector();
        int maxSize = Math.max(this.size(), v.size());
        for (int i = 0; i < maxSize; i++) {
            double sum = this.getOrZero(i) + v.getOrZero(i);
            result.add(sum);
        }
        return result;
    }

    private void enlarge() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    private double getOrZero(int i) {
        return (i < size) ? data[i] : 0;
    }

    @Override
    public double coordinate(int i) {
        return data[i];
    }

    @Override
    public double[] coordinates() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public double norm() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += data[i] * data[i];
        }
        return Math.sqrt(sum);
    }

    @Override
    public void set(double d, int i) {
        data[i] = d;
    }

    @Override
    public int size() {
        return size;
    }
}