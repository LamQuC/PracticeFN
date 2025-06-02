package practice_Mid.HK2223.d2hk2giai.myiterator;

import java.util.Arrays;

public class MyArrayList extends MyAbstractList implements MyList {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void append(Object obj) {
        if (size == data.length) {
            enlarge();
        }
        data[size++] = obj;
    }

    private void enlarge() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public void insert(Object obj, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (size == data.length) enlarge();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = obj;
        size++;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        Object removed = data[index];
        int moveCount = size - index - 1;
        if (moveCount > 0) {
            System.arraycopy(data, index + 1, data, index, moveCount);
        }
        data[--size] = null;
        return removed;
    }

    @Override
    public void set(Object obj, int index) {
        checkIndex(index);
        data[index] = obj;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    @Override
    public MyIterator iterator() {
        return new MyArrayListIterator(this);
    }
}