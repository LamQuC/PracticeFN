package practice_Mid.HK2526.datastructure;

/**
 * Stack sử dụng cấu trúc dữ liệu mảng.
 */
public class MyArrayStack implements MyStack {
    public static final int MAX_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private int[] elements;
    private int numberOfElements;

    public MyArrayStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public MyArrayStack(int initialCapacity) {
        elements = new int[initialCapacity];
        numberOfElements = 0;
    }

    @Override
    public void push(int value) {
        if (numberOfElements == elements.length) {
            grow();
        }
        elements[numberOfElements++] = value;
    }

    private void grow() {
        int newCapacity = elements.length * 2;
        int[] newElements = new int[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[--numberOfElements];
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[numberOfElements - 1];
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }
    public void display() {
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
}
