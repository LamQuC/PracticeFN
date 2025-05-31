package hk1_2425_giai.basicstatistics;

public class MyLinkedList extends MyAbstractList {
    private Node head;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        head = null;
    }

    /**
     * Lấy kích thước của list.
     * @return
     */
    @Override
    public int size() {
        /* TODO */
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Number get(int index) {
        /* TODO */
        return getNodeByIndex(index).payload;
    }

    /**
     * Xóa phần tử của list ở vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index == 0) {
            head = head.next;
            return;
        }
        Node prev = getNodeByIndex(index - 1);
        if (prev.next == null) throw new IndexOutOfBoundsException();
        prev.next = prev.next.next;
    }

    /**
     * Thêm vào cuối list phần tử có dữ liệu payload.
     * @param payload
     */
    @Override
    public void append(Number payload) {
        /* TODO */
        if (head == null) {
            head = new Node(payload);
        } else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = new Node(payload);
        }
    }

    /**
     * Thêm vào list phần tử có dữ liệu payload ở vị trí index.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Number payload, int index) {
        /* TODO */
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index == 0) {
            head = new Node(payload, head);
            return;
        }
        Node prev = getNodeByIndex(index - 1);
        prev.next = new Node(payload, prev.next);
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        /* TODO */
        return new MyLinkedListIterator(0);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        /* TODO */
        if (index < 0) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) throw new IndexOutOfBoundsException();
            current = current.next;
        }
        if (current == null) throw new IndexOutOfBoundsException();
        return current;
    }

    private class MyLinkedListIterator implements MyIterator {
        /*
         * Vị trí hiện tại của iterator trong list.
         */
        private Node current = head;
        private Node prev = null;
        private int currentPosition;

        /**
         * Khởi tạo cho iterator ở vị trí position trong MyLinkedList.
         * @param position
         */
        public MyLinkedListIterator(int position) {
            /* TODO */
            for (int i = 0; i < position && current != null; i++) {
                prev = current;
                current = current.next;
            }
        }

        /**
         * Kiểm tra trong MyLinkedList có còn phần tử không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            /* TODO */
            return current != null;
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyLinkedList và trả ra dữ liệu (payload) của phần tử hiện tại của MyLinkedList.
         * @return payload của phần tử hiện tại.
         */
        @Override
        public Number next() {
            /* TODO */
            Number data = current.payload;
            prev = current;
            current = current.next;
            return data;
        }

        @Override
        public void remove() {
            /* TODO */
            MyLinkedList.this.remove(0);
        }
    }
}
