package lab12.mylist;

public class TestMyList {
    public static void main(String[] args) {
        /*
         * TODO
         * Chạy demo các hàm test.
         */
        System.out.println("Testing MyArrayList:");
        testMyArrayList();
        System.out.println("\nTesting MyLinkedList:");
        testMyLinkedList();
    }

    public static void testMyArrayList() {
        /*
         * TODO
         * Tạo ra một list kiểu MyArrayList có các phần tử dữ liệu kiểu Double.
         * Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
         * In ra terminal các thông tin về dữ liệu và các đại lượng thống kê.
         */
        MyArrayList list = new MyArrayList();
        list.append(5.5);
        list.append(6.3);
        list.append(9.9);
        list.append(1.9);

        BasicStatistic stats = new BasicStatistic(list);
        System.out.println("ArrayList: " + list);
        System.out.println("Max: " + stats.max());
        System.out.println("Min: " + stats.min());
        System.out.println("Mean: " + stats.mean());
        System.out.println("Variance: " + stats.variance());
    }

    public static void testMyLinkedList() {
        /*
         * TODO
         * Tạo ra một list kiểu MyLinkedList có các phần tử dữ liệu kiểu Double.
         * Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
         * In ra terminal các thông tin về dữ liệu và các đại lượng thống kê.
         */
        MyLinkedList list = new MyLinkedList();
        list.append(5.5);
        list.append(6.3);
        list.append(9.9);
        list.append(1.9);

        BasicStatistic stats = new BasicStatistic(list);
        System.out.println("LinkedList: " + list);
        System.out.println("Max: " + stats.max());
        System.out.println("Min: " + stats.min());
        System.out.println("Mean: " + stats.mean());
        System.out.println("Variance: " + stats.variance());
    }
}
