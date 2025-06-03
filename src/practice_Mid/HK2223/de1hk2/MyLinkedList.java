package hus.oop.statistics;

import java.util.Arrays;

public class MyLinkedList extends MyAbstractList {
    private MyNode top;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        this.top = null;
    }

    @Override
    public int size() {
        int count = 0;
        MyNode curr = top;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    @Override
    public void add(double data) {
        MyNode newNode = new MyNode(data);
        if (top == null) {
            top = newNode;
        } else {
            MyNode curr = top;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.previous = curr;
        }
    }

    @Override
    public void insert(double data, int index) {
        int n = size();
        if (index < 0 || index > n) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        MyNode newNode = new MyNode(data);
        if (index == 0) {
            // chèn trước top
            newNode.next = top;
            if (top != null) {
                top.previous = newNode;
            }
            top = newNode;
        } else if (index == n) {
            // chèn ở cuối
            MyNode curr = top;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.previous = curr;
        } else {
            MyNode curr = getNodeByIndex(index);
            MyNode prev = curr.previous;
            prev.next = newNode;
            newNode.previous = prev;
            newNode.next = curr;
            curr.previous = newNode;
        }
    }

    @Override
    public void remove(int index) {
        int n = size();
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        MyNode curr = getNodeByIndex(index);
        MyNode prev = curr.previous;
        MyNode next = curr.next;
        if (prev != null) {
            prev.next = next;
        } else {
            top = next;
        }
        if (next != null) {
            next.previous = prev;
        }
    }

    @Override
    public MyLinkedList sortIncreasing() {
        int n = size();
        if (n == 0) {
            return new MyLinkedList();
        }
        double[] arr = new double[n];
        MyNode curr = top;
        int idx = 0;
        while (curr != null) {
            arr[idx++] = curr.data;
            curr = curr.next;
        }
        Arrays.sort(arr);
        MyLinkedList sorted = new MyLinkedList();
        for (double v : arr) {
            sorted.add(v);
        }
        return sorted;
    }

    @Override
    public int binarySearch(double data) {
        int n = size();
        if (n == 0) {
            return -1;
        }
        double[] arr = new double[n];
        MyNode curr = top;
        int idx = 0;
        while (curr != null) {
            arr[idx++] = curr.data;
            curr = curr.next;
        }
        Arrays.sort(arr);
        int pos = Arrays.binarySearch(arr, data);
        return (pos < 0 ? -1 : pos);
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        int n = size();
        if (start < 0 || start > n) {
            throw new IndexOutOfBoundsException("Iterator start " + start + " out of bounds");
        }
        return new MyLinkedListIterator(start);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyNode getNodeByIndex(int index) {
        int n = size();
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        MyNode curr = top;
        int count = 0;
        while (count < index) {
            curr = curr.next;
            count++;
        }
        return curr;
    }

    private class MyLinkedListIterator implements MyIterator {
        private int currentPosition;
        private int lastReturned;

        public MyLinkedListIterator(int position) {
            this.currentPosition = position;
            this.lastReturned = -1;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < MyLinkedList.this.size();
        }

        @Override
        public Number next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements");
            }
            MyNode node = getNodeByIndex(currentPosition);
            lastReturned = currentPosition;
            currentPosition++;
            return Double.valueOf(node.data);
        }

        @Override
        public void remove() {
            if (lastReturned < 0) {
                throw new IllegalStateException("next() chưa được gọi hoặc đã remove rồi");
            }
            MyLinkedList.this.remove(lastReturned);
            if (lastReturned < currentPosition) {
                currentPosition--;
            }
            lastReturned = -1;
        }
    }
}
