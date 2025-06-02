package practice_Mid.HK2526.datastructure;

import java.util.Random;

public class TestDataStructure {

    public static void main(String[] args) {
        // Test các phương thức
        testArrayStack();
        testLinkedListStack();
        testArrayQueue();
        testLinkedListQueue();
    }

    public static void testArrayStack() {
        // Sinh ngẫu nhiên ra n trong khoảng [20 - 30]
        Random random = new Random();
        int n = random.nextInt(11) + 20;  // n trong khoảng từ 20 đến 30

        System.out.println("Test ArrayStack with n = " + n);

        MyArrayStack stack = new MyArrayStack();

        // Sinh ngẫu nhiên n số nguyên và đưa vào stack
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(100); // Số ngẫu nhiên từ 0 đến 99
            stack.push(value);
        }

        // In ra các phần tử trong stack
        System.out.println("Elements in stack:");
        stack.display();

        // Xóa các phần tử trong stack và in ra kết quả sau mỗi lần xóa
        for (int i = 0; i < n; i++) {
            stack.pop();
            System.out.println("Stack after pop " + (i + 1) + ":");
            stack.display();
        }
    }

    public static void testLinkedListStack() {
        // Sinh ngẫu nhiên ra n trong khoảng [20 - 30]
        Random random = new Random();
        int n = random.nextInt(11) + 20;  // n trong khoảng từ 20 đến 30

        System.out.println("Test LinkedListStack with n = " + n);

        MyLinkedListStack stack = new MyLinkedListStack();

        // Sinh ngẫu nhiên n số nguyên và đưa vào stack
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(100); // Số ngẫu nhiên từ 0 đến 99
            stack.push(value);
        }

        // In ra các phần tử trong stack
        System.out.println("Elements in stack:");
        stack.display();

        // Xóa các phần tử trong stack và in ra kết quả sau mỗi lần xóa
        for (int i = 0; i < n; i++) {
            stack.pop();
            System.out.println("Stack after pop " + (i + 1) + ":");
            stack.display();
        }
    }

    public static void testArrayQueue() {
        // Sinh ngẫu nhiên ra n trong khoảng [20 - 30]
        Random random = new Random();
        int n = random.nextInt(11) + 20;  // n trong khoảng từ 20 đến 30

        System.out.println("Test ArrayQueue with n = " + n);

        MyArrayQueue queue = new MyArrayQueue();

        // Sinh ngẫu nhiên n số nguyên và đưa vào queue
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(100); // Số ngẫu nhiên từ 0 đến 99
            queue.enqueue(value);
        }

        // In ra các phần tử trong queue
        System.out.println("Elements in queue:");
        queue.display();

        // Xóa các phần tử trong queue và in ra kết quả sau mỗi lần xóa
        for (int i = 0; i < n; i++) {
            queue.dequeue();
            System.out.println("Queue after dequeue " + (i + 1) + ":");
            queue.display();
        }
    }

    public static void testLinkedListQueue() {
        // Sinh ngẫu nhiên ra n trong khoảng [20 - 30]
        Random random = new Random();
        int n = random.nextInt(11) + 20;  // n trong khoảng từ 20 đến 30

        System.out.println("Test LinkedListQueue with n = " + n);

        MyLinkedListQueue queue = new MyLinkedListQueue();

        // Sinh ngẫu nhiên n số nguyên và đưa vào queue
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(100); // Số ngẫu nhiên từ 0 đến 99
            queue.enqueue(value);
        }

        // In ra các phần tử trong queue
        System.out.println("Elements in queue:");
        queue.display();

        // Xóa các phần tử trong queue và in ra kết quả sau mỗi lần xóa
        for (int i = 0; i < n; i++) {
            queue.dequeue();
            System.out.println("Queue after dequeue " + (i + 1) + ":");
            queue.display();
        }
    }
}
