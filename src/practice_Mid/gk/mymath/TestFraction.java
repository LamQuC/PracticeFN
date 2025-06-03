package hus.oop.fraction;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestFraction {
    private MyDataSet myDataSet;

    public TestFraction(MyDataSet myDataSet) {
        this.myDataSet = myDataSet;
    }

    public static void main(String[] args) {
        String TEN_SINH_VIEN = "NguyenVanA";
        String MA_SINH_VIEN = "123456";
        String fileName = TEN_SINH_VIEN + "_" + MA_SINH_VIEN + "_MyFractions.txt";

        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            // Chạy test cho MyArrayDataSet
            pw.println("=== TEST MyArrayDataSet ===");
            TestFraction testerArray = new TestFraction(new MyArrayDataSet());
            testerArray.testMyArrayDataSet(pw);

            pw.println();
            // Chạy test cho MyListDataSet
            pw.println("=== TEST MyListDataSet ===");
            TestFraction testerList = new TestFraction(new MyListDataSet());
            testerList.testMyListDataSet(pw);

            System.out.println("Đã ghi kết quả vào file: " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public void testMyArrayDataSet(PrintWriter pw) {
        Random rnd = new Random();
        int numbers = rnd.nextInt(21) + 30; // sinh số tự nhiên trong [30,50]

        // 2. Tạo ra numbers phân số ngẫu nhiên và lưu vào MyArrayDataSet
        MyArrayDataSet dsArray = new MyArrayDataSet();
        pw.println("Số lượng phân số sinh ngẫu nhiên: " + numbers);
        for (int i = 0; i < numbers; i++) {
            int tu = rnd.nextInt(100) + 1; // [1,100]
            int mau = rnd.nextInt(100) + 1; // [1,100]
            MyFraction f = new MyFraction(tu, mau);
            dsArray.append(f);
        }

        // In ra dữ liệu gốc
        pw.println("Dữ liệu gốc (MyArrayDataSet): " + dsArray.myDataSetToString());

        // 3. Sắp xếp và in ra
        MyArrayDataSet ascArray = dsArray.sortIncreasing();
        pw.println("Sắp xếp tăng dần: " + ascArray.myDataSetToString());

        MyArrayDataSet descArray = dsArray.sortDecreasing();
        pw.println("Sắp xếp giảm dần: " + descArray.myDataSetToString());

        // 4. In ra phân số tối giản
        MyArrayDataSet simplifiedOriginal = dsArray.toSimplify();
        pw.println("Phân số tối giản (theo thứ tự gốc): " + simplifiedOriginal.myDataSetToString());

        MyArrayDataSet simplifiedAsc = simplifiedOriginal.sortIncreasing();
        pw.println("Phân số tối giản sắp xếp tăng dần: " + simplifiedAsc.myDataSetToString());

        MyArrayDataSet simplifiedDesc = simplifiedOriginal.sortDecreasing();
        pw.println("Phân số tối giản sắp xếp giảm dần: " + simplifiedDesc.myDataSetToString());
    }

    public void testMyListDataSet(PrintWriter pw) {
        Random rnd = new Random();
        int numbers = rnd.nextInt(21) + 30; // sinh số tự nhiên trong [30,50]

        // 2. Tạo ra numbers phân số ngẫu nhiên và lưu vào MyListDataSet
        MyListDataSet dsList = new MyListDataSet();
        pw.println("Số lượng phân số sinh ngẫu nhiên: " + numbers);
        for (int i = 0; i < numbers; i++) {
            int tu = rnd.nextInt(100) + 1; // [1,100]
            int mau = rnd.nextInt(100) + 1; // [1,100]
            MyFraction f = new MyFraction(tu, mau);
            dsList.append(f);
        }

        // In ra dữ liệu gốc
        pw.println("Dữ liệu gốc (MyListDataSet): " + dsList.myDataSetToString());

        // 3. Sắp xếp và in ra
        MyListDataSet ascList = dsList.sortIncreasing();
        pw.println("Sắp xếp tăng dần: " + ascList.myDataSetToString());

        MyListDataSet descList = dsList.sortDecreasing();
        pw.println("Sắp xếp giảm dần: " + descList.myDataSetToString());

        // 4. In ra phân số tối giản
        MyListDataSet simplifiedOriginal = dsList.toSimplify();
        pw.println("Phân số tối giản (theo thứ tự gốc): " + simplifiedOriginal.myDataSetToString());

        MyListDataSet simplifiedAsc = simplifiedOriginal.sortIncreasing();
        pw.println("Phân số tối giản sắp xếp tăng dần: " + simplifiedAsc.myDataSetToString());

        MyListDataSet simplifiedDesc = simplifiedOriginal.sortDecreasing();
        pw.println("Phân số tối giản sắp xếp giảm dần: " + simplifiedDesc.myDataSetToString());
    }
}


