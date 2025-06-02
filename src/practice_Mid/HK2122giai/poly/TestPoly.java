package practice_Mid.HK2122giai.poly;

import java.util.*;

public class TestPoly {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Poly> polyList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int[] coeffs = rand.ints(3 + rand.nextInt(3), 0, 10).toArray();
            polyList.add(new ArrayPoly(coeffs));
        }

        for (int i = 0; i < 5; i++) {
            List<Integer> coeffs = new ArrayList<>();
            for (int j = 0; j < 3 + rand.nextInt(3); j++) {
                coeffs.add(rand.nextInt(10));
            }
            polyList.add(new ListPoly(coeffs));
        }

        double x = 2;
        int count = 1;
        for (Poly p : polyList) {
            System.out.println("Poly" + count + ": " + p);
            System.out.println("Derivative: " + p.derivative());
            System.out.println("Value at x=" + x + ": " + p.evaluate(x));
            System.out.println("Type: " + (p instanceof ArrayPoly ? ((ArrayPoly)p).type() : ((ListPoly)p).type()));
            System.out.println();
            count++;
        }
    }
}