package practice_Mid.khdl.vector.vector;

import java.util.ArrayList;
import java.util.List;

public class ListVector implements IVector {
    private List<Double> data;

    public ListVector() {
        /* TODO */
        data = new ArrayList<Double>();
    }

    public ListVector(List<Double> data) {
        /* TODO */
        this.data = data;
    }

    @Override
    public void append(double value) {
        /* TODO */
        data.add(value);
    }

    @Override
    public void insert(double value, int index) {
        /* TODO */
        data.add(index, value);
    }

    @Override
    public void remove(int index) {
        /* TODO */
        data.remove(index);
    }

    @Override
    public int length() {
        /* TODO */
        return data.size();
    }

    @Override
    public double magnitude() {
        /* TODO */
        double sum = 0.0;
        for (double d : data) {
            sum += d * d;
        }
        return Math.sqrt(sum);
    }

    public double distanceTo(ListVector another) {
        /* TODO */
        if (another.length() != length()) {
            return 0.0;
        }
        double sum = 0.0;
        for (int i = 0; i < data.size(); i++) {
            sum += Math.pow(data.get(i) - another.data.get(i), 2);
        }
        return Math.sqrt(sum);
    }

    @Override
    public double[] elements() {
        /* TODO */
        double[] elements = new double[length()];
        for (int i = 0; i < length(); i++) {
            elements[i] = data.get(i);
        }
        return elements;
    }

    public double element(int index) {
        /* TODO */
        return data.get(index);
    }

    public ListVector minus(ListVector another) {
        /* TODO */
        if (another.length() != length()) {
            return this;
        }
        ListVector result = new ListVector();
        for (int i = 0; i < length(); i++) {
            result.append(element(i) - another.element(i));
        }
        return result;
    }

    public ListVector plus(ListVector another) {
        /* TODO */
        if (another.length() != length()) {
            return this;
        }
        ListVector result = new ListVector();
        for (int i = 0; i < length(); i++) {
            result.append(element(i) + another.element(i));
        }
        return result;
    }

    public ListVector scale(double factor) {
        /* TODO */
        ListVector result = new ListVector();
        for (int i = 0; i < length(); i++) {
            result.append(element(i) * factor);
        }
        return result;
    }

    public double dot(ListVector another) {
        /* TODO */
        if (another.length() != length()) {
            return 0.0;
        }
        double sum = 0.0;
        for (int i = 0; i < length(); i++) {
            sum += element(i) * another.element(i);
        }
        return sum;
    }

    /*
     * Hàm trả ra format của vector dạng: [a1, a2, ..., an].
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder result = new StringBuilder();
        result.append('[');
        for (int i = 0; i < length(); i++) {
            if (i != length() - 1) {
                result.append(element(i)).append(", ");
            } else {
                result.append(element(i));
            }
        }
        result.append(']');
        return result.toString();
    }
}
