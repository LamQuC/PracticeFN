package hus.oop.vector;

import java.util.ArrayList;
import java.util.List;

public class MyListVector extends MyAbstractVector {
    private List<Double> data;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyListVector() {
        this.data = new ArrayList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public double coordinate(int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        return data.get(index);
    }

    @Override
    public double[] coordinates() {
        double[] result = new double[data.size()];
        for (int i = 0; i < data.size(); i++) {
            result[i] = data.get(i);
        }
        return result;
    }

    @Override
    public MyListVector insert(double value) {
        data.add(value);
        return this;
    }

    @Override
    public MyListVector insert(double value, int index) {
        if (index < 0 || index > data.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        data.add(index, value);
        return this;
    }

    @Override
    public MyListVector remove(int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        data.remove(index);
        return this;
    }

    @Override
    public MyListVector extract(int[] indices) {
        if (indices == null) {
            throw new IllegalArgumentException("Indices cannot be null");
        }
        MyListVector result = new MyListVector();
        for (int idx : indices) {
            if (idx < 0 || idx >= data.size()) {
                throw new IndexOutOfBoundsException("Index " + idx + " out of bounds");
            }
            result.insert(data.get(idx));
        }
        return result;
    }

    @Override
    public void set(double value, int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        data.set(index, value);
    }

    @Override
    public MyListVector add(double value) {
        MyListVector result = new MyListVector();
        for (Double d : data) {
            result.insert(d + value);
        }
        return result;
    }

    @Override
    public MyListVector add(MyVector another) {
        if (another == null || another.size() != this.size()) {
            throw new IllegalArgumentException("Vectors must have same dimension");
        }
        MyListVector result = new MyListVector();
        for (int i = 0; i < data.size(); i++) {
            result.insert(data.get(i) + another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyListVector addTo(double value) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + value);
        }
        return this;
    }

    @Override
    public MyListVector addTo(MyVector another) {
        if (another == null || another.size() != this.size()) {
            throw new IllegalArgumentException("Vectors must have same dimension");
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + another.coordinate(i));
        }
        return this;
    }

    @Override
    public MyListVector minus(double value) {
        MyListVector result = new MyListVector();
        for (Double d : data) {
            result.insert(d - value);
        }
        return result;
    }

    @Override
    public MyListVector minus(MyVector another) {
        if (another == null || another.size() != this.size()) {
            throw new IllegalArgumentException("Vectors must have same dimension");
        }
        MyListVector result = new MyListVector();
        for (int i = 0; i < data.size(); i++) {
            result.insert(data.get(i) - another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyListVector minusFrom(double value) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) - value);
        }
        return this;
    }

    @Override
    public MyListVector minusFrom(MyVector another) {
        if (another == null || another.size() != this.size()) {
            throw new IllegalArgumentException("Vectors must have same dimension");
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) - another.coordinate(i));
        }
        return this;
    }

    @Override
    public double dot(MyVector another) {
        if (another == null || another.size() != this.size()) {
            throw new IllegalArgumentException("Vectors must have same dimension");
        }
        double sum = 0.0;
        for (int i = 0; i < data.size(); i++) {
            sum += data.get(i) * another.coordinate(i);
        }
        return sum;
    }

    @Override
    public MyListVector pow(double power) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, Math.pow(data.get(i), power));
        }
        return this;
    }

    @Override
    public MyListVector scale(double value) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) * value);
        }
        return this;
    }

    @Override
    public double norm() {
        double sumSq = 0.0;
        for (Double d : data) {
            sumSq += d * d;
        }
        return Math.sqrt(sumSq);
    }
}
