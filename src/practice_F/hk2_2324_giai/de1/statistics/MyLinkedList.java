package practice_F.hk2_2324_giai.de1.statistics;

public class MyLinkedList extends MyAbstractList {
    private MyNode top;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        top = null;
    }

    @Override
    public int size() {
        int count = 0;
        MyNode current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public void add(double data) {
        MyNode newNode = new MyNode(data);
        if (top == null) {
            top = newNode;
        } else {
            MyNode current = top;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.previous = current;
        }
    }

    @Override
    public void insert(double data, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        MyNode newNode = new MyNode(data);
        if (index == 0) {
            newNode.next = top;
            if (top != null) {
                top.previous = newNode;
            }
            top = newNode;
        } else {
            MyNode current = getNodeByIndex(index - 1);
            if (current == null) {
                throw new IndexOutOfBoundsException("Invalid index: " + index);
            }
            newNode.next = current.next;
            newNode.previous = current;
            if (current.next != null) {
                current.next.previous = newNode;
            }
            current.next = newNode;
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || top == null) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            top = top.next;
            if (top != null) {
                top.previous = null;
            }
        } else {
            MyNode current = getNodeByIndex(index - 1);
            if (current == null || current.next == null) {
                throw new IndexOutOfBoundsException("Invalid index: " + index);
            }
            current.next = current.next.next;
            if (current.next != null) {
                current.next.previous = current;
            }
        }
    }

    @Override
    public MyLinkedList sortIncreasing() {
        MyLinkedList sorted = new MyLinkedList();
        double[] array = new double[size()];
        MyIterator iterator = iterator(0);
        int i = 0;
        while (iterator.hasNext()) {
            array[i++] = iterator.next().doubleValue();
        }
        java.util.Arrays.sort(array);
        for (double value : array) {
            sorted.add(value);
        }
        return sorted;
    }

    @Override
    public int binarySearch(double data) {
        MyLinkedList sorted = sortIncreasing();
        int left = 0;
        int right = sorted.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            MyNode midNode = sorted.getNodeByIndex(mid);
            double midValue = midNode.data;
            if (midValue == data) {
                return mid;
            } else if (midValue < data) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        return new MyLinkedListIterator(start);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyNode getNodeByIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        MyNode current = top;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        return current;
    }

    private class MyLinkedListIterator implements MyIterator {
        /*
         * Vị trí hiện tại của iterator trong list.
         */
        private int currentPosition;
        private MyNode currentNode;

        /**
         * Khởi tạo cho iterator ở vị trí position trong MyLinkedList.
         * @param position
         */
        public MyLinkedListIterator(int position) {
            if (position < 0) {
                throw new IndexOutOfBoundsException("Invalid position: " + position);
            }
            currentPosition = position;
            currentNode = getNodeByIndex(position);
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Number next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            double value = currentNode.data;
            currentNode = currentNode.next;
            currentPosition++;
            return value;
        }

        @Override
        public void remove() {
            if (currentPosition <= 0 || currentNode == null) {
                throw new IllegalStateException("No element to remove");
            }
            MyLinkedList.this.remove(currentPosition - 1);
        }
    }
}