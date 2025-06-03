package hus.oop.vector;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TestVector {
    private MyVector vector;

    public TestVector(MyVector vector) {
        this.vector = vector;
    }

    public static void main(String[] args) {
        // Thay "TEN_SINH_VIEN" và "MA_SINH_VIEN" bằng thông tin của bạn
        String TEN_SINH_VIEN = "NguyenVanA";
        String MA_SINH_VIEN = "123456";
        String fileName = TEN_SINH_VIEN + "_" + MA_SINH_VIEN + "_Vector.txt";

        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            pw.println("=== TEST MyArrayVector ===");
            TestVector testerArray = new TestVector(new MyArrayVector());
            testerArray.testArrayVector(pw);

            pw.println();
            pw.println("=== TEST MyListVector ===");
            TestVector testerList = new TestVector(new MyListVector());
            testerList.testListVector(pw);

            System.out.println("Đã ghi kết quả vào file: " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public void testArrayVector(PrintWriter pw) {
        Random rnd = new Random();
        int n = rnd.nextInt(8) + 3; // kích thước ngẫu nhiên trong [3,10]
        pw.println("Kích thước ban đầu (random): " + n);

        // Tạo vector với MyArrayVector
        MyArrayVector arrVec = new MyArrayVector();
        for (int i = 0; i < n; i++) {
            double val = rnd.nextDouble() * 10; // giá trị ngẫu nhiên [0,10)
            arrVec.insert(val);
        }
        pw.println("Vector gốc: " + arrVec.toString());

        // Thử insert một phần tử vào cuối
        arrVec.insert(5.5);
        pw.println("Sau insert(5.5) vào cuối: " + arrVec.toString());

        // Thử insert một phần tử vào vị trí index 1
        arrVec.insert(9.9, 1);
        pw.println("Sau insert(9.9, 1): " + arrVec.toString());

        // Thử remove tại index 2
        arrVec.remove(2);
        pw.println("Sau remove(2): " + arrVec.toString());

        // Thử set tại index 0 thành 7.7
        arrVec.set(7.7, 0);
        pw.println("Sau set(7.7, 0): " + arrVec.toString());

        // Thử extract các chỉ số {0, 2}
        int[] indices = {0, 2};
        MyArrayVector extracted = arrVec.extract(indices);
        pw.println("Extract(indices={0,2}): " + extracted.toString());

        // Thử cộng với scalar (không thay đổi arrVec, tạo mới)
        MyArrayVector addedScalar = arrVec.add(1.1);
        pw.println("arrVec.add(1.1): " + addedScalar.toString());
        pw.println("Xác nhận arrVec không đổi: " + arrVec.toString());

        // Thử cộng vector với vector (cùng kích thước)
        MyArrayVector otherArr = new MyArrayVector();
        for (int i = 0; i < arrVec.size(); i++) {
            otherArr.insert(rnd.nextDouble() * 5);
        }
        pw.println("otherArr: " + otherArr.toString());
        MyArrayVector addedVec = arrVec.add(otherArr);
        pw.println("arrVec.add(otherArr): " + addedVec.toString());

        // Thử addTo scalar (in-place)
        arrVec.addTo(2.2);
        pw.println("arrVec.addTo(2.2): " + arrVec.toString());

        // Thử addTo vector (in-place)
        arrVec.addTo(otherArr);
        pw.println("arrVec.addTo(otherArr): " + arrVec.toString());

        // Thử minus scalar (new)
        MyArrayVector minusScalar = arrVec.minus(3.3);
        pw.println("arrVec.minus(3.3): " + minusScalar.toString());

        // Thử minus vector (new)
        MyArrayVector minusVec = arrVec.minus(otherArr);
        pw.println("arrVec.minus(otherArr): " + minusVec.toString());

        // Thử minusFrom scalar (in-place)
        arrVec.minusFrom(1.0);
        pw.println("arrVec.minusFrom(1.0): " + arrVec.toString());

        // Thử minusFrom vector (in-place)
        arrVec.minusFrom(otherArr);
        pw.println("arrVec.minusFrom(otherArr): " + arrVec.toString());

        // Thử dot product
        double dotProd = arrVec.dot(otherArr);
        pw.println("arrVec.dot(otherArr): " + dotProd);

        // Thử pow (in-place)
        arrVec.pow(2.0);
        pw.println("arrVec.pow(2.0): " + arrVec.toString());

        // Thử scale (in-place)
        arrVec.scale(0.5);
        pw.println("arrVec.scale(0.5): " + arrVec.toString());

        // Thử norm
        double normVal = arrVec.norm();
        pw.println("arrVec.norm(): " + normVal);
    }

    public void testListVector(PrintWriter pw) {
        Random rnd = new Random();
        int n = rnd.nextInt(8) + 3; // kích thước ngẫu nhiên trong [3,10]
        pw.println("Kích thước ban đầu (random): " + n);

        // Tạo vector với MyListVector
        MyListVector listVec = new MyListVector();
        for (int i = 0; i < n; i++) {
            double val = rnd.nextDouble() * 10; // giá trị ngẫu nhiên [0,10)
            listVec.insert(val);
        }
        pw.println("Vector gốc: " + listVec.toString());

        // Thử insert một phần tử vào cuối
        listVec.insert(4.4);
        pw.println("Sau insert(4.4) vào cuối: " + listVec.toString());

        // Thử insert một phần tử vào vị trí index 2
        listVec.insert(8.8, 2);
        pw.println("Sau insert(8.8, 2): " + listVec.toString());

        // Thử remove tại index 1
        listVec.remove(1);
        pw.println("Sau remove(1): " + listVec.toString());

        // Thử set tại index 0 thành 6.6
        listVec.set(6.6, 0);
        pw.println("Sau set(6.6, 0): " + listVec.toString());

        // Thử extract các chỉ số {1, 3}
        int[] indices = {1, 3};
        MyListVector extracted = listVec.extract(indices);
        pw.println("Extract(indices={1,3}): " + extracted.toString());

        // Thử cộng với scalar (không thay đổi listVec, tạo mới)
        MyListVector addedScalar = listVec.add(0.5);
        pw.println("listVec.add(0.5): " + addedScalar.toString());
        pw.println("Xác nhận listVec không đổi: " + listVec.toString());

        // Thử cộng vector với vector (cùng kích thước)
        MyListVector otherList = new MyListVector();
        for (int i = 0; i < listVec.size(); i++) {
            otherList.insert(rnd.nextDouble() * 5);
        }
        pw.println("otherList: " + otherList.toString());
        MyListVector addedVec = listVec.add(otherList);
        pw.println("listVec.add(otherList): " + addedVec.toString());

        // Thử addTo scalar (in-place)
        listVec.addTo(1.5);
        pw.println("listVec.addTo(1.5): " + listVec.toString());

        // Thử addTo vector (in-place)
        listVec.addTo(otherList);
        pw.println("listVec.addTo(otherList): " + listVec.toString());

        // Thử minus scalar (new)
        MyListVector minusScalar = listVec.minus(2.5);
        pw.println("listVec.minus(2.5): " + minusScalar.toString());

        // Thử minus vector (new)
        MyListVector minusVec = listVec.minus(otherList);
        pw.println("listVec.minus(otherList): " + minusVec.toString());

        // Thử minusFrom scalar (in-place)
        listVec.minusFrom(1.0);
        pw.println("listVec.minusFrom(1.0): " + listVec.toString());

        // Thử minusFrom vector (in-place)
        listVec.minusFrom(otherList);
        pw.println("listVec.minusFrom(otherList): " + listVec.toString());

        // Thử dot product
        double dotProd = listVec.dot(otherList);
        pw.println("listVec.dot(otherList): " + dotProd);

        // Thử pow (in-place)
        listVec.pow(3.0);
        pw.println("listVec.pow(3.0): " + listVec.toString());

        // Thử scale (in-place)
        listVec.scale(0.2);
        pw.println("listVec.scale(0.2): " + listVec.toString());

        // Thử norm
        double normVal = listVec.norm();
        pw.println("listVec.norm(): " + normVal);
    }
}
