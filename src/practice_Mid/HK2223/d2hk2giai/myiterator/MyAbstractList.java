package practice_Mid.HK2223.d2hk2giai.myiterator;

public abstract class MyAbstractList implements MyIterable {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        MyIterator it = this.iterator();
        sb.append("[");
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Các phương thức cơ bản mà MyList, MyArrayList, MyLinkedList sẽ implement:
    public abstract void append(Object obj);
    public abstract Object get(int index);
    public abstract void insert(Object obj, int index);
    public abstract Object remove(int index);
    public abstract void set(Object obj, int index);
    public abstract int size();
}
