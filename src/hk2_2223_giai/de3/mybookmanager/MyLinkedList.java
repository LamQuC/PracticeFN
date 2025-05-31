package hk2_2223_giai.de3.mybookmanager;

public class MyLinkedList extends MyAbstractList {
    private MyLinkedListNode head;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        head = new MyLinkedListNode(null);
    }

    /**
     * Lấy kích thước của list.
     * @return
     */
    @Override
    public int size() {
        /* TODO */
        int count = 0;
        MyLinkedListNode current = head;
        while (current.getNext() != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        /* TODO */
        return getNodeByIndex(index + 1).getPayload();
    }

    /**
     * Sửa phần tử ở vị trí index là payload.
     * @param payload
     * @param index
     */
    @Override
    public void set(Object payload, int index) {
        /* TODO */
        getNodeByIndex(index + 1).setPayload(payload);
    }

    /**
     * Xóa phần tử của list ở vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        MyLinkedListNode current = getNodeByIndex(index);
        current.setNext(current.getNext().getNext());
    }

    /**
     * Thêm vào cuối list phần tử có dữ liệu payload.
     * @param payload
     */
    @Override
    public void append(Object payload) {
        /* TODO */
        MyLinkedListNode current = getNodeByIndex(size() + 1);
        current.setNext(new MyLinkedListNode(payload, null));
    }

    /**
     * Thêm vào list phần tử có dữ liệu payload ở vị trí index.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Object payload, int index) {
        /* TODO */
        MyLinkedListNode current = getNodeByIndex(index);
        MyLinkedListNode newNode = new MyLinkedListNode(payload, current.getNext());
        current.setNext(newNode);
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        /* TODO */
        return new MyLinkedListIterator();
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyLinkedListNode getNodeByIndex(int index) {
        /* TODO */
        MyLinkedListNode current = head;
        int count = 0;
        while (current.getNext() != null && index > count) {
            current = current.getNext();
            count++;
        }
        return current;
    }

    /*
     * Inner class implements the Iterator pattern
     */
    private class MyLinkedListIterator implements MyIterator {
        /*
         * MyLinkedListIterator cần phải biết vị trí hiện tại khi nó đang duyệt qua dữ liệu của MyLinkedList.
         */
        private int currentPosition;

        /**
         * Khởi tạo dữ liệu cho Iterator là vị trí node đầu tiên trong MyLinkedList.
         */
        public MyLinkedListIterator() {
            /* TODO */
            currentPosition = 0;
        }

        /**
         * Kiểm tra trong MyLinkedList có còn phần tử tiếp theo không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            /* TODO */
            return currentPosition < size();
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyLinkedList và trả ra dữ liệu (payload) của phần tử hiện tại của MyLinkedList.
         * @return payload của phần tử hiện tại.
         */
        @Override
        public Object next() {
            /* TODO */
            return get(currentPosition++);
        }

        /**
         * iterator xóa phần tử hiện tại của MyLinkedList.
         */
        @Override
        public void remove() {
            /* TODO */
            MyLinkedList.this.remove(currentPosition);
        }
    }
}
