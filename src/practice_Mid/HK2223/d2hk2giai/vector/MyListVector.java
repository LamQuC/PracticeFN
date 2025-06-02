package practice_Mid.HK2223.d2hk2giai.vector;

import java.util.ArrayList;
import java.util.List;

public class MyListVector extends AbstractMyVector {
    private List<Double> data;

    public MyListVector() {
        data = new ArrayList<>();
    }

    // Add 1 phần tử double vào cuối danh sách (KHÔNG trả về, chỉ thêm vào)
    public void add(double d) {
        data.add(d);
    }

    // Cộng 2 vector kiểu MyListVector → trả về 1 MyListVector mới
    public MyListVector add(MyListVector v) {
        MyListVector result = new MyListVector();
        int maxSize = Math.max(this.size(), v.size());
        for (int i = 0; i < maxSize; i++) {
            double sum = this.getOrZero(i) + v.getOrZero(i);
            result.add(sum);
        }
        return result;
    }

    private double getOrZero(int i) {
        return (i < data.size()) ? data.get(i) : 0;
    }

    @Override
    public double coordinate(int i) {
        return data.get(i);
    }

    @Override
    public double[] coordinates() {
        double[] array = new double[data.size()];
        for (int i = 0; i < data.size(); i++) {
            array[i] = data.get(i);
        }
        return array;
    }

    @Override
    public double norm() {
        double sum = 0;
        for (double e : data) {
            sum += e * e;
        }
        return Math.sqrt(sum);
    }

    @Override
    public void set(double d, int i) {
        data.set(i, d);
    }

    @Override
    public int size() {
        return data.size();
    }
}