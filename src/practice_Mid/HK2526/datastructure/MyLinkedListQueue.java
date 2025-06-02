package practice_Mid.HK2526.datastructure;

public class MyLinkedListQueue implements MyQueue {
    private Node head;  // Phần tử đầu của queue
    private Node tail;  // Phần tử cuối của queue

    public MyLinkedListQueue() {
        head = null;
        tail = null;
    }

    @Override
    public void enqueue(int element) {
        Node newNode = new Node(element);
        if (tail == null) {  // Nếu queue rỗng, cả head và tail đều trỏ vào node mới
            head = newNode;
            tail = newNode;
        } else {  // Nếu queue không rỗng, thêm node mới vào cuối và cập nhật tail
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int dequeuedValue = head.data;
        head = head.next;  // Di chuyển head sang phần tử tiếp theo
        if (head == null) {  // Nếu sau khi dequeue, queue trống thì cần đặt tail = null
            tail = null;
        }
        return dequeuedValue;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;  // Queue trống khi head là null
    }
    public void display() {
        if (head == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data+ " ");
            current = current.next;
        }
        System.out.println();
    }
}
