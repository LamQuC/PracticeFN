package hk2_2223_giai.de2.studentManager2;
public class MyLinkedList extends MyAbstractList {
    private MyLinkedListNode head;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        head = new MyLinkedListNode(null, null);
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

    @Override
    public void set(Object payload, int index) {
        MyLinkedListNode current = getNodeByIndex(index - 1);
        MyLinkedListNode newNode =
                new MyLinkedListNode(payload,
                        current.getNext().getNext());
        current.setNext(newNode);
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
        return new MyLinkedListIterator(head);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyLinkedListNode getNodeByIndex(int index) {
        /* TODO */
        MyLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    private class MyLinkedListIterator implements MyIterator {
        /*
         * MyLinkedListIterator cần phải tham chiếu đến node hiện tại của MyLinkedList để có thể duyệt qua
           các phần tử còn lại trong MyLinkedList.
        */
        private MyLinkedListNode currentNode;

        /**
         * Khởi tạo dữ liệu cho Iterator là node hiện tại trong MyLinkedList.
         * @param node
         */
        public MyLinkedListIterator(MyLinkedListNode node) {
            /* TODO */
            currentNode = node;
        }

        /**
         * Kiểm tra trong MyLinkedList có còn phần tử tiếp theo không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            /* TODO */
           return currentNode.getNext() != null;
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyLinkedList và trả ra dữ liệu (payload) của phần tử hiện tại của MyLinkedList.
         * @return payload của phần tử hiện tại.
         */
        @Override
        public Object next() {
            /* TODO */
            currentNode = currentNode.getNext();
            return currentNode.getPayload();
        }

        @Override
        public void remove() {
            /* TODO */
            currentNode.setNext(currentNode.getNext().getNext());
        }
    }
}
