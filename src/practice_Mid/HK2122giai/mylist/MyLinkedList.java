package practice_Mid.HK2122giai.mylist;

public class MyLinkedList extends MyAbstractList {
    private static class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
        }
    }

    private Node head = null, tail = null;

    @Override
    public void add(Object o) {
        Node newNode = new Node(o);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public Object get(int index) {
        checkBoundaries(index, size);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public Object remove(int index) {
        checkBoundaries(index, size);
        Node removed;
        if (index == 0) {
            removed = head;
            head = head.next;
            if (head == null) tail = null;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            removed = prev.next;
            prev.next = removed.next;
            if (removed == tail) tail = prev;
        }
        size--;
        return removed.data;
    }

    @Override
    public int size() {
        return size;
    }
}

