package hus.oop.statistics;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class TestStatistics {
    private Statistics statistics;

    public TestStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public static void main(String[] args) {
        // Thay "TEN_SINH_VIEN" và "MA_SINH_VIEN" bằng thông tin của bạn
        String TEN_SINH_VIEN = "NguyenVanA";
        String MA_SINH_VIEN = "123456";
        String fileName = TEN_SINH_VIEN + "_" + MA_SINH_VIEN + "_Statistics.txt";

        try {
            // Lưu lại standard out ban đầu
            PrintStream originalOut = System.out;
            // Mở file để ghi
            FileOutputStream fos = new FileOutputStream(fileName);
            PrintStream fileOut = new PrintStream(fos);
            // Đổi System.out về fileOut
            System.setOut(fileOut);

            // Thực hiện test cho MyArrayList
            System.out.println("=== TEST MyArrayList ===");
            TestStatistics testerArray = new TestStatistics(new Statistics(new MyArrayList()));
            testerArray.testMyArrayList();

            System.out.println();
            // Thực hiện test cho MyLinkedList
            System.out.println("=== TEST MyLinkedList ===");
            TestStatistics testerLinked = new TestStatistics(new Statistics(new MyLinkedList()));
            testerLinked.testMyLinkedList();

            // Khôi phục System.out
            System.setOut(originalOut);
            fileOut.close();
            fos.close();
            System.out.println("Đã ghi kết quả vào file: " + fileName);
        } catch (Exception e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public void testMyArrayList() {
        Random rnd = new Random();
        int length = rnd.nextInt(21) + 30; // trong [30,50]
        System.out.println("Số lượng phần tử (ngẫu nhiên): " + length);

        // Tạo MyArrayList và điền dữ liệu ngẫu nhiên trong [1,20]
        MyArrayList arr = new MyArrayList();
        for (int i = 0; i < length; i++) {
            double v = 1.0 + rnd.nextDouble() * 19.0;
            arr.add(v);
        }

        // Lưu vào Statistics
        this.statistics = new Statistics(arr);

        // In ra tập dữ liệu gốc
        System.out.println("Tập dữ liệu gốc (MyArrayList): " + arr.toString());

        // Sử dụng sortIncreasing()
        MyList sorted = arr.sortIncreasing();
        System.out.println("Tập dữ liệu đã sắp xếp (tăng dần): " + sorted.toString());

        // Tính max, min, mean, variance
        double max = this.statistics.max();
        double min = this.statistics.min();
        double mean = this.statistics.mean();
        double var = this.statistics.variance();
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
        System.out.println("Mean = " + mean);
        System.out.println("Variance = " + var);

        // Tính rank
        double[] ranks = this.statistics.rank();
        System.out.print("Rank (theo thứ tự gốc): [");
        for (int i = 0; i < ranks.length; i++) {
            System.out.print(ranks[i]);
            if (i < ranks.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");

        // Thử search một phần tử: dùng phần tử đầu tiên làm ví dụ
        if (arr.size() > 0) {
            double key = arr.iterator(0).next().doubleValue();
            int idx = this.statistics.search(key);
            System.out.println("Search giá trị \"" + key + "\" trả về index = " + idx);
        }
    }

    public void testMyLinkedList() {
        Random rnd = new Random();
        int length = rnd.nextInt(21) + 30; // trong [30,50]
        System.out.println("Số lượng phần tử (ngẫu nhiên): " + length);

        // Tạo MyLinkedList và điền dữ liệu ngẫu nhiên trong [1,20]
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < length; i++) {
            double v = 1.0 + rnd.nextDouble() * 19.0;
            list.add(v);
        }

        // Lưu vào Statistics
        this.statistics = new Statistics(list);

        // In ra tập dữ liệu gốc
        System.out.println("Tập dữ liệu gốc (MyLinkedList): " + list.toString());

        // Sử dụng sortIncreasing()
        MyList sorted = list.sortIncreasing();
        System.out.println("Tập dữ liệu đã sắp xếp (tăng dần): " + sorted.toString());

        // Tính max, min, mean, variance
        double max = this.statistics.max();
        double min = this.statistics.min();
        double mean = this.statistics.mean();
        double var = this.statistics.variance();
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
        System.out.println("Mean = " + mean);
        System.out.println("Variance = " + var);

        // Tính rank
        double[] ranks = this.statistics.rank();
        System.out.print("Rank (theo thứ tự gốc): [");
        for (int i = 0; i < ranks.length; i++) {
            System.out.print(ranks[i]);
            if (i < ranks.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");

        // Thử search một phần tử: dùng phần tử đầu tiên làm ví dụ
        if (list.size() > 0) {
            double key = list.iterator(0).next().doubleValue();
            int idx = this.statistics.search(key);
            System.out.println("Search giá trị \"" + key + "\" trả về index = " + idx);
        }
    }
}
