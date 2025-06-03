package hus.oop.vector;

public class MyArrayVector extends MyAbstractVector {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyArrayVector() {
        this.data = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public double coordinate(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        return data[index];
    }

    @Override
    public double[] coordinates() {
        double[] result = new double[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    @Override
    public MyArrayVector insert(double value) {
        if (size == data.length) {
            allocateMore();
        }
        data[size++] = value;
        return this;
    }

    @Override
    public MyArrayVector insert(double value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        if (size == data.length) {
            allocateMore();
        }
        // shift right
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
        return this;
    }

    @Override
    public MyArrayVector remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        // shift left
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return this;
    }

    @Override
    public MyArrayVector extract(int[] indices) {
        if (indices == null) {
            throw new IllegalArgumentException("Indices cannot be null");
        }
        MyArrayVector result = new MyArrayVector();
        for (int idx : indices) {
            if (idx < 0 || idx >= size) {
                throw new IndexOutOfBoundsException("Index " + idx + " out of bounds");
            }
            result.insert(data[idx]);
        }
        return result;
    }

    @Override
    public void set(double value, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        data[index] = value;
    }

    @Override
    public MyArrayVector add(double value) {
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] + value);
        }
        return result;
    }

    @Override
    public MyArrayVector add(MyVector another) {
        if (another == null || another.size() != this.size) {
            throw new IllegalArgumentException("Vectors must have same dimension");
        }
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(this.data[i] + another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyArrayVector addTo(double value) {
        for (int i = 0; i < size; i++) {
            data[i] += value;
        }
        return this;
    }

    @Override
    public MyArrayVector addTo(MyVector another) {
        if (another == null || another.size() != this.size) {
            throw new IllegalArgumentException("Vectors must have same dimension");
        }
        for (int i = 0; i < size; i++) {
            data[i] += another.coordinate(i);
        }
        return this;
    }

    @Override
    public MyArrayVector minus(double value) {
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] - value);
        }
        return result;
    }

    @Override
    public MyArrayVector minus(MyVector another) {
        if (another == null || another.size() != this.size) {
            throw new IllegalArgumentException("Vectors must have same dimension");
        }
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(this.data[i] - another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyArrayVector minusFrom(double value) {
        for (int i = 0; i < size; i++) {
            data[i] -= value;
        }
        return this;
    }

    @Override
    public MyArrayVector minusFrom(MyVector another) {
        if (another == null || another.size() != this.size) {
            throw new IllegalArgumentException("Vectors must have same dimension");
        }
        for (int i = 0; i < size; i++) {
            data[i] -= another.coordinate(i);
        }
        return this;
    }

    @Override
    public double dot(MyVector another) {
        if (another == null || another.size() != this.size) {
            throw new IllegalArgumentException("Vectors must have same dimension");
        }
        double sum = 0.0;
        for (int i = 0; i < size; i++) {
            sum += this.data[i] * another.coordinate(i);
        }
        return sum;
    }

    @Override
    public MyArrayVector pow(double power) {
        for (int i = 0; i < size; i++) {
            data[i] = Math.pow(data[i], power);
        }
        return this;
    }

    @Override
    public MyArrayVector scale(double value) {
        for (int i = 0; i < size; i++) {
            data[i] *= value;
        }
        return this;
    }

    @Override
    public double norm() {
        double sumSq = 0.0;
        for (int i = 0; i < size; i++) {
            sumSq += data[i] * data[i];
        }
        return Math.sqrt(sumSq);
    }

    /**
     * Mở rộng kích thước vector lên gấp đôi khi cần thiết.
     */
    private void allocateMore() {
        int newCapacity = data.length * 2;
        double[] newArr = new double[newCapacity];
        System.arraycopy(data, 0, newArr, 0, size);
        data = newArr;
    }
}
