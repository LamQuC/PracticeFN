package practice_Mid.HK2223.d2hk2giai.myiterator;

public interface MyList extends MyIterable {
    void append(Object obj);
    Object get(int index);
    void insert(Object obj, int index);
    Object remove(int index);
    void set(Object obj, int index);
    int size();
}
