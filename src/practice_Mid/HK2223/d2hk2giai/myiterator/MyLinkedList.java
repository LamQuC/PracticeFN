package practice_Mid.HK2223.d2hk2giai.myiterator;

public class MyLinkedList extends MyAbstractList implements MyList {
    private MyLinkedListNode head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void append(Object obj) {
        MyLinkedListNode node = new MyLinkedListNode(obj);
        if (head == null) {
            head = node;
        } else {
            MyLinkedListNode cur = head;
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            cur.setNext(node);
        }
        size++;
    }

    private MyLinkedListNode getNodeByIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyLinkedListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }
        return cur;
    }

    @Override
    public Object get(int index) {
        return getNodeByIndex(index).getPayload();
    }

    @Override
    public void insert(Object obj, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        MyLinkedListNode node = new MyLinkedListNode(obj);
        if (index == 0) {
            node.setNext(head);
            head = node;
        } else {
            MyLinkedListNode prev = getNodeByIndex(index - 1);
            node.setNext(prev.getNext());
            prev.setNext(node);
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyLinkedListNode removed;
        if (index == 0) {
            removed = head;
            head = head.getNext();
        } else {
            MyLinkedListNode prev = getNodeByIndex(index - 1);
            removed = prev.getNext();
            prev.setNext(removed.getNext());
        }
        size--;
        return removed.getPayload();
    }

    @Override
    public void set(Object obj, int index) {
        MyLinkedListNode node = getNodeByIndex(index);
        node.payload = obj;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator(head);
    }
}
