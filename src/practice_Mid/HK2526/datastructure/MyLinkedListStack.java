package practice_Mid.HK2526.datastructure;

/**
 * Stack sử dụng cấu trúc dữ liệu linked list.
 */
public class MyLinkedListStack implements MyStack {
    private Node top;  // Phần tử đầu của stack (đỉnh stack)

    // Node định nghĩa cho linked list
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;  // Chỉ vào phần tử cũ (đưa phần tử mới lên trên)
        top = newNode;  // Đặt phần tử mới làm top
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int poppedValue = top.data;  // Lấy giá trị top
        top = top.next;  // Di chuyển top về phần tử kế tiếp
        return poppedValue;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;  // Trả về giá trị top mà không thay đổi stack
    }

    @Override
    public boolean isEmpty() {
        return top == null;  // Stack rỗng khi top là null
    }
    public void display() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }

        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
