package practice_F.hk2_2324_giai.de1.statistics;

import java.io.PrintWriter;
import java.io.File;
import java.util.Random;
import java.util.Arrays;

public class TestStatistics {
    private Statistics statistics;

    public TestStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public static void main(String[] args) {
        /* TODO
           - Thực hiện từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
             là <TenSinhVien_MaSinhVien_Statistics>.txt (Ví dụ, NguyenVanA_123456_Statistics.txt).
           - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
             <TenSinhVien_MaSinhVien_Statistics>.zip (Ví dụ, NguyenVanA_123456_Statistics.zip),
             nộp lên classroom.
         */

        // The result was saved to .txt file

        try (PrintWriter writer = new PrintWriter(new File("NguyenVanA_123456_Statistics.txt"))) {
            TestStatistics test = new TestStatistics(null);
            writer.println("=== Testing MyArrayList ===");
            test.testMyArrayList(writer);
            writer.println("\n=== Testing MyLinkedList ===");
            test.testMyLinkedList(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testMyArrayList(PrintWriter writer) {
        /* TODO
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một list kiểu MyArrayList, có các phần tử dữ liệu kiểu double được sinh ngẫu nhiên
             nằm trong đoạn [1, 20]. Tạo Statistics có dữ liệu là list dữ liệu vừa tạo, lưu vào statistics.
           - Sử dụng Statistics để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, sắp xếp, tìm kiếm).
             In ra terminal tập dữ liệu, tập dữ liệu được sắp xếp, các đại lượng thống kê và kết quả chức năng tìm kiếm.
         */
        Random rand = new Random();
        int length = rand.nextInt(21) + 30; // Random from 30 to 50
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < length; i++) {
            double value = rand.nextDouble() * 19 + 1; // Random from 1 to 20
            list.add(value);
        }
        statistics = new Statistics(list);

        writer.println("Original ArrayList: " + list);
        writer.println("Sorted ArrayList: " + list.sortIncreasing());
        writer.println("Max: " + statistics.max());
        writer.println("Min: " + statistics.min());
        writer.println("Mean: " + statistics.mean());
        writer.println("Variance: " + statistics.variance());
        writer.println("Ranks: " + Arrays.toString(statistics.rank()));
        double searchValue = list.iterator(0).next().doubleValue(); // Search for first element
        writer.println("Search for " + searchValue + ": index = " + statistics.search(searchValue));
    }

    public void testMyLinkedList(PrintWriter writer) {
        /* TODO
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một list kiểu MyLinkedList, có các phần tử lưu dữ liệu kiểu double được sinh ngẫu nhiên
             nằm trong đoạn [1, 20]. Tạo Statistics có dữ liệu là list dữ liệu vừa tạo, lưu vào statistics.
           - Sử dụng Statistics để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, sắp xếp, tìm kiếm).
             In ra terminal tập dữ liệu, tập dữ liệu được sắp xếp, các đại lượng thống kê và kết quả chức năng tìm kiếm.
         */
        Random rand = new Random();
        int length = rand.nextInt(21) + 30; // Random from 30 to 50
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < length; i++) {
            double value = rand.nextDouble() * 19 + 1; // Random from 1 to 20
            list.add(value);
        }
        statistics = new Statistics(list);

        writer.println("Original LinkedList: " + list);
        writer.println("Sorted LinkedList: " + list.sortIncreasing());
        writer.println("Max: " + statistics.max());
        writer.println("Min: " + statistics.min());
        writer.println("Mean: " + statistics.mean());
        writer.println("Variance: " + statistics.variance());
        writer.println("Ranks: " + Arrays.toString(statistics.rank()));
        double searchValue = list.iterator(0).next().doubleValue(); // Search for first element
        writer.println("Search for " + searchValue + ": index = " + statistics.search(searchValue));
    }
}