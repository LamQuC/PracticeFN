package hus.oop.statistics;

import java.util.Arrays;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        this.data = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(double data) {
        if (size == this.data.length) {
            allocateMore();
        }
        this.data[size++] = data;
    }

    @Override
    public void insert(double data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        if (size == this.data.length) {
            allocateMore();
        }
        // shift phải từ cuối về index
        for (int i = size - 1; i >= index; i--) {
            this.data[i + 1] = this.data[i];
        }
        this.data[index] = data;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        // shift trái từ index+1 về
        for (int i = index; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        size--;
    }

    @Override
    public MyArrayList sortIncreasing() {
        double[] copy = new double[size];
        System.arraycopy(this.data, 0, copy, 0, size);
        Arrays.sort(copy);
        MyArrayList sorted = new MyArrayList();
        for (double v : copy) {
            sorted.add(v);
        }
        return sorted;
    }

    @Override
    public int binarySearch(double data) {
        if (size == 0) {
            return -1;
        }
        double[] copy = new double[size];
        System.arraycopy(this.data, 0, copy, 0, size);
        Arrays.sort(copy);
        int idx = Arrays.binarySearch(copy, data);
        return (idx < 0 ? -1 : idx);
    }

    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        if (start < 0 || start > size) {
            throw new IndexOutOfBoundsException("Iterator start " + start + " out of bounds");
        }
        return new MyArrayListIterator(start);
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void allocateMore() {
        int newCapacity = this.data.length * 2;
        double[] newArr = new double[newCapacity];
        System.arraycopy(this.data, 0, newArr, 0, size);
        this.data = newArr;
    }

    private class MyArrayListIterator implements MyIterator {
        private int currentPosition;
        private int lastReturned;

        public MyArrayListIterator(int position) {
            this.currentPosition = position;
            this.lastReturned = -1;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < size;
        }

        @Override
        public Number next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements");
            }
            double val = data[currentPosition];
            lastReturned = currentPosition;
            currentPosition++;
            return Double.valueOf(val);
        }

        @Override
        public void remove() {
            if (lastReturned < 0) {
                throw new IllegalStateException("next() chưa được gọi hoặc đã remove rồi");
            }
            // Xóa phần tử ở lastReturned
            MyArrayList.this.remove(lastReturned);
            // Sau khi xóa, giảm currentPosition để tiếp tục vòng lặp đúng
            currentPosition = lastReturned;
            lastReturned = -1;
        }
    }
}
