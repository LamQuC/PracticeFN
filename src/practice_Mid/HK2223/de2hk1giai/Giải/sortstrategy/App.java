package practice_Mid.HK2223.de2hk1giai.Giải.sortstrategy;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        /* TODO */
        // Tạo một mảng các số tự nhiên, các số tự nhiên được sinh ngẫu nhiên
        // In ra mảng vừa tạo theo định dạng, ví dụ [1 2 3 4 5].
        // Sắp xếp mảng theo thứ tự tăng dần sử dụng các thuật toán sắp xếp khác nhau.
        // In ra mảng sau khi sắp xếp.
        // In ra số lần đổi vị trí trong thuật toán đang sử dụng.
        // Ví dụ:
        // Using Bubble Sort Algorithm:
        // Before sorting: [5 4 3 2 1]
        // After sorting: [1 2 3 4 5]
        // Number of swap: 10

        // Using Selection Sort Algorithm:
        // Before sorting: [5 4 3 2 1]
        // After sorting: [1 2 3 4 5]
        // Number of swap: 10

        // Kết quả chạy chương trình lưu vào file SortStrategy<Mã sinh viên>.txt và nộp cùng source code.
        int[] arr = generateArray();
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, 0, arr2, 0, arr2.length);

        System.out.println("Using Bubble Sort Algorithm");
        System.out.println("Before Sorting: " + Arrays.toString(arr));
        SortStrategy.getInstance().setSortee(new BubbleSort());
        int countArr = SortStrategy.getInstance().sort(arr);
        System.out.println("After Sorting: " + Arrays.toString(arr));
        System.out.println("Number of swap: " + countArr);
        System.out.println();

        System.out.println("Using Insertion Algorithm");
        System.out.println("Before Sorting: " + Arrays.toString(arr1));
        SortStrategy.getInstance().setSortee(new InsertionSort());
        int countArr1 = SortStrategy.getInstance().sort(arr1);
        System.out.println("After Sorting: " + Arrays.toString(arr1));
        System.out.println("Number of swap: " + countArr1);
        System.out.println();

        System.out.println("Using Selection Algorithm");
        System.out.println("Before Sorting: " + Arrays.toString(arr2));
        SortStrategy.getInstance().setSortee(new SelectionSort());
        int countArr2 = SortStrategy.getInstance().sort(arr2);
        System.out.println("After Sorting: " + Arrays.toString(arr2));
        System.out.println("Number of swap: " + countArr2);
    }

    public static int[] generateArray() {
        int n = 10;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.round(Math.random() * 100) / 10);
        }
        return array;
    }
}
