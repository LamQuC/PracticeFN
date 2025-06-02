package practice_Mid.HK2223.d2hk2giai.myiterator;

public class MyArrayListIterator implements MyIterator {
    private final MyArrayList list;
    private int current = 0;

    public MyArrayListIterator(MyArrayList list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return current < list.size();
    }

    @Override
    public Object next() {
        return list.get(current++);
    }
}