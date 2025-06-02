package practice_Mid.HK2122giai.number;

import java.util.*;

public class TestFraction {
    private List<Fraction> fraction;
    public TestFraction(){
       fraction = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int num = rand.nextInt(1000) + 1; // 1..1000
            int den = rand.nextInt(1000) + 1;
            fraction.add(new Fraction(num, den));
        }
    }
    public Fraction getSecondLargestValue(){
        List<Fraction> secondValue = sortByValue(fraction);
        if(secondValue.size() < 2)
            return null;
        return secondValue.get(secondValue.size()-2);
    }

    public static void main(String[] args) {
        TestFraction test = new TestFraction();

        System.out.println("Danh sách phân số gốc:");
        test.print(test.fraction);

        System.out.println("\nPhân số theo thứ tự tăng dần giá trị:");
        List<Fraction> sortedByValue = test.sortByValue(test.fraction);
        test.print(sortedByValue);

        System.out.println("\nPhân số theo thứ tự tăng dần mẫu số:");
        List<Fraction> sortedByDenominator = test.sortByDenominator(test.fraction);
        test.print(sortedByDenominator);

        System.out.println("\nPhân số có giá trị lớn thứ hai:");
        Fraction second = test.getSecondLargestValue();
        System.out.println(second);
    }

    public void print(List<Fraction> list) {
        for (Fraction f : list) {
            System.out.println(f);
        }
    }
    public List<Fraction> sortByDenominator(List<Fraction> fraction){
        List<Fraction> sorting = new ArrayList<>(fraction);
        sorting.sort(Comparator.comparingInt(Fraction::getDenominator));
        return sorting;
    }
    public List<Fraction> sortByValue(List<Fraction> fraction){
        List<Fraction> sorting = new ArrayList<>(fraction);
        Collections.sort(sorting);
        return sorting;
    }
}
