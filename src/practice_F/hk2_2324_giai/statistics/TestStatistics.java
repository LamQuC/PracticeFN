//package hus.oop.mid_term_2024.statistics;
//
//public class TestStatistics {
//    public static void main(String[] args) {
//        /* Yêu cầu:
//
//        I. Hoàn thiện các file source code đã cho. Viết các chức năng test cho chương trình.
//        Viết hàm test cho ArrayDataSet:
//            1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [20 - 30]. Tạo ra tập dữ liệu kiểu ArrayDataSet gồm các phần tử
//               là các số double được sinh ngẫu nhiên, và có số phần tử bằng số tự nhiên đã cho.
//            2. In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
//            3. Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu. In ra các dữ liệu thống kê về tập dữ liệu
//               (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
//
//         Viết hàm test cho LinkedListDataSet:
//            1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [20 - 30]. Tạo ra tập dữ liệu kiểu ArrayDataSet gồm các phần tử
//               là các số double được sinh ngẫu nhiên, và có số phần tử bằng số tự nhiên đã cho.
//            2. In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
//            3. Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu. In ra các dữ liệu thống kê về tập dữ liệu
//               (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
//
//         II. Chạy các hàm test để test chương trình.
//         Copy kết quả chạy chương trình và lưu vào file text có tên <TenSinhVien_MaSinhVien_Statistics>.txt
//         (ví dụ, NguyenVanA_123456S_Statistics.txt).
//         Nén các file source code và file text kết quả chạy chương trình theo định dạng .zip,
//         đặt tên là <TenSinhVien_MaSinhVien_Statistics>.zip (ví dụ, NguyenVanA_123456_Statistics.zip) và nộp lên classroom.
//         */
//    }
//
//    /**
//     * Hàm test cho tập dữ liệu kiểu ArrayDataSet.
//     */
//    public static void testStatisticsUsingArrayDataSet() {
//        /* TODO */
//    }
//
//    /**
//     * Hàm test cho tập dữ liệu kiểu LinkedListDataSet.
//     */
//    public static void testStatisticsUsingLinkedListDataSet() {
//        /* TODO */
//    }
//}
package hus.oop.mid_term_2024.statistics;

import java.util.Random;

public class TestStatistics {
    public static void main(String[] args) {
        testStatisticsUsingArrayDataSet();
        testStatisticsUsingLinkedListDataSet();
    }

    public static void testStatisticsUsingArrayDataSet() {
        Random rnd = new Random();
        int n = rnd.nextInt(11) + 20; // [20,30]
        ArrayDataSet ds = new ArrayDataSet();
        for (int i = 0; i < n; i++) ds.append(rnd.nextDouble() * 100);
        BasicStatistics stats = new BasicStatistics();
        stats.setDataSet(ds);
        System.out.println("ArrayDataSet (n="+n+"):");
        printAll(ds, stats);
        ds.remove(0);
        ds.remove(ds.size()-1);
        System.out.println("After removing first and last:");
        printAll(ds, stats);
    }

    public static void testStatisticsUsingLinkedListDataSet() {
        Random rnd = new Random();
        int n = rnd.nextInt(11) + 20;
        LinkedListDataSet ds = new LinkedListDataSet();
        for (int i = 0; i < n; i++) ds.append(rnd.nextDouble() * 100);
        BasicStatistics stats = new BasicStatistics();
        stats.setDataSet(ds);
        System.out.println("LinkedListDataSet (n="+n+"):");
        printAll(ds, stats);
        ds.remove(0);
        ds.remove(ds.size()-1);
        System.out.println("After removing first and last:");
        printAll(ds, stats);
    }

    private static void printAll(DataSet ds, BasicStatistics stats) {
        System.out.println("Data: " + ds.toString());
        System.out.println("Size: " + stats.size());
        System.out.println("Max: " + stats.max());
        System.out.println("Min: " + stats.min());
        System.out.println("Mean: " + stats.mean());
        System.out.println("Variance: " + stats.variance());
        System.out.println("Rank: " + stats.rank().toString());
        System.out.println("Median: " + stats.median());
        System.out.println();
    }
}