package practice_Mid.HK2122giai.mylist;

public class MyArrayList extends MyAbstractList {
    private Object[] data = new Object[10];

    @Override
    public void add(Object o) {
        if (size == data.length) enlarge();
        data[size++] = o;
    }

    @Override
    public Object get(int index) {
        checkBoundaries(index, size);
        return data[index];
    }

    @Override
    public Object remove(int index) {
        checkBoundaries(index, size);
        Object removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
        return removed;
    }

    @Override
    public int size() {
        return size;
    }

    private void enlarge() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
