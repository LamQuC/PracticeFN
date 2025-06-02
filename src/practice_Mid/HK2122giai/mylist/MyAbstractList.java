package practice_Mid.HK2122giai.mylist;

public abstract class MyAbstractList implements MyList {
    protected int size = 0;

    protected void checkBoundaries(int index, int limit) {
        if (index < 0 || index >= limit) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Limit: " + limit);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append("[").append(get(i)).append("] ");
        }
        return sb.toString().trim();
    }
}
