package practice_Mid.HK2223.d2hk2giai.myiterator;

public class MyLinkedListIterator implements MyIterator {
    private MyLinkedListNode currentNode;

    public MyLinkedListIterator(MyLinkedListNode head) {
        this.currentNode = head;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public Object next() {
        Object val = currentNode.getPayload();
        currentNode = currentNode.getNext();
        return val;
    }
}