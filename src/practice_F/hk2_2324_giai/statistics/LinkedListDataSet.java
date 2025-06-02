//package hus.oop.mid_term_2024.statistics;
//
//public class LinkedListDataSet extends AbstractDataSet {
//    private Node head;
//
//    /**
//     * Hàm dựng khởi tạo list để chứa dữ liệu.
//     */
//    public LinkedListDataSet() {
//        this.head = null;
//    }
//
//    @Override
//    public int size() {
//        /* TODO */
//        return 1;
//    }
//
//    /**
//     * Lấy giá trị của phần tử ở vị trí index.
//     * @param index
//     * @return
//     */
//    @Override
//    public double get(int index) {
//        /* TODO */
//        return 1;
//    }
//
//    /**
//     * Sửa dữ liệu ở vị trí index thành data.
//     * @param data
//     * @param index
//     */
//    @Override
//    public void set(double data, int index) {
//        /* TODO */
//    }
//
//    /**
//     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
//     * @param value giá trị của phần tử dữ liệu được thêm vào.
//     */
//    @Override
//    public void append(double value) {
//        /* TODO */
//    }
//
//    /**
//     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
//     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
//     * @param value
//     * @param index
//     */
//    @Override
//    public void insert(double value, int index) {
//        /* TODO */
//    }
//
//    /**
//     * Xóa phần tử dữ liệu tại vị trí index.
//     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
//     * @param index
//     */
//    @Override
//    public void remove(int index) {
//        /* TODO */
//    }
//
//    /**
//     * Phương thức lấy Node ở vị trí index.
//     * @param index
//     * @return
//     */
//    private Node getNodeByIndex(int index) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
//     * @return
//     */
//    @Override
//    public double[] toArray() {
//        /* TODO */
//        return null;
//    }
//}
package hus.oop.mid_term_2024.statistics;

public class LinkedListDataSet extends AbstractDataSet {
    private Node head;

    public LinkedListDataSet() {
        head = null;
    }

    @Override
    public int size() {
        int count = 0;
        Node cur = head;
        while (cur != null) { count++; cur = cur.next; }
        return count;
    }

    @Override
    public double get(int index) {
        Node node = getNodeByIndex(index);
        return node.data;
    }

    @Override
    public void set(double value, int index) {
        Node node = getNodeByIndex(index);
        node.data = value;
    }

    @Override
    public void append(double value) {
        Node newNode = new Node(value);
        if (head == null) head = newNode;
        else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = newNode;
        }
    }

    @Override
    public void insert(double value, int index) {
        if (!checkBoundaries(index, size())) throw new IndexOutOfBoundsException();
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node prev = getNodeByIndex(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    @Override
    public void remove(int index) {
        if (!checkBoundaries(index, size() - 1)) throw new IndexOutOfBoundsException();
        if (index == 0) head = head.next;
        else {
            Node prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
        }
    }

    private Node getNodeByIndex(int index) {
        if (!checkBoundaries(index, size() - 1)) throw new IndexOutOfBoundsException();
        Node cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur;
    }

    @Override
    public double[] toArray() {
        int n = size();
        double[] arr = new double[n];
        Node cur = head;
        for (int i = 0; i < n; i++) {
            arr[i] = cur.data;
            cur = cur.next;
        }
        return arr;
    }
}

