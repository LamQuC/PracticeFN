package practice_Mid.HK2526.datastructure;

public class MyArrayQueue implements MyQueue {
    public static final int MAX_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private int[] elements;
    private int headIndex;
    private int tailIndex;
    private int numberOfElements;

    public MyArrayQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public MyArrayQueue(int capacity) {
        /* TODO */
        elements = new int[capacity];
        headIndex = 0;
        tailIndex = numberOfElements;
        numberOfElements = 0;

    }

    @Override
    public void enqueue(int element) {
        /* TODO */
        if (this.elements.length == 0) {
            this.elements[headIndex] = element;
            return;
        }
        if (numberOfElements == elements.length) {
            grow();
        }
        //
        elements[tailIndex] =element;
        tailIndex = (tailIndex + 1) % elements.length;
        numberOfElements++;
    }

    /*
     * Tăng kích thước queue gấp đôi.
     */
    private void grow() {
        int newSize = this.elements.length * 2;
        int[] newData = new int[newSize];

        // Copy các phần tử từ headIndex đến cuối mảng
        for (int i = 0; i < numberOfElements; i++) {
            newData[i] = elements[(headIndex + i) % elements.length];
        }

        this.elements = newData;
        headIndex = 0;
        tailIndex = numberOfElements;
    }
    @Override
    public int dequeue() {
        /* TODO */
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int value = elements[headIndex];
        headIndex = (headIndex + 1) % elements.length; // Cập nhật headIndex theo kiểu vòng tròn
        numberOfElements--;
        return value;
    }

    @Override
    public int peek() {
        /* TODO */
        return elements[headIndex];
    }

    @Override
    public boolean isEmpty() {
        /* TODO */
        return elements.length == 0;
    }
    public void display() {
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
}
