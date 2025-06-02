package practice_Mid.HK2223.d2hk2giai.vector;

import java.util.ArrayList;
import java.util.List;

public class BasicStatistics {
    private List<MyVector> vectors;

    public BasicStatistics() {
        vectors = new ArrayList<>();
    }

    public void doSimpleStatic() {
        System.out.println("Total vectors: " + vectors.size());
        System.out.println("Norm Max: " + normMax());
        System.out.println("Norm Min: " + normMin());
    }

    public MyVector filter(boolean isMax) {
        if (vectors.isEmpty()) return null;
        MyVector result = vectors.get(0);
        for (MyVector v : vectors) {
            if (isMax && v.norm() > result.norm()) {
                result = v;
            } else if (!isMax && v.norm() < result.norm()) {
                result = v;
            }
        }
        return result;
    }

    public double normMax() {
        MyVector v = filter(true);
        return (v != null) ? v.norm() : 0;
    }

    public double normMin() {
        MyVector v = filter(false);
        return (v != null) ? v.norm() : 0;
    }

    public double[] rank() {
        double[] ranks = new double[vectors.size()];
        for (int i = 0; i < vectors.size(); i++) {
            ranks[i] = vectors.get(i).norm();
        }
        return ranks;
    }

    public MyVector sortNorm(boolean descending) {
        if (vectors.isEmpty()) return null;
        vectors.sort((a, b) -> descending ? Double.compare(b.norm(), a.norm()) : Double.compare(a.norm(), b.norm()));
        return vectors.get(0); // Sau sort, lấy phần tử đầu tiên
    }

    public void testArrayVector() {
        // Tạo 1 MyArrayVector, thêm phần tử vào
        MyArrayVector v = new MyArrayVector();
        v.add(3.0);
        v.add(4.0);
        v.add(5.0);
        vectors.add(v);
    }

    public void testListVector() {
        // Tạo 1 MyListVector, thêm phần tử vào
        MyListVector v = new MyListVector();
        v.add(6.0);
        v.add(8.0);
        vectors.add(v);
    }

    public static void main(String[] args) {
        BasicStatistics stats = new BasicStatistics();

        stats.testArrayVector();
        stats.testListVector();

        System.out.println("----- Simple Statistics -----");
        stats.doSimpleStatic();

        System.out.println("\n----- Norms Ranking -----");
        double[] ranks = stats.rank();
        for (int i = 0; i < ranks.length; i++) {
            System.out.println("Vector " + i + " norm = " + ranks[i]);
        }

        System.out.println("\n----- Sorting by Norm -----");
        MyVector biggest = stats.sortNorm(true);
        System.out.println("Biggest Norm Vector: " + biggest);

        MyVector smallest = stats.sortNorm(false);
        System.out.println("Smallest Norm Vector: " + smallest);
    }
}
