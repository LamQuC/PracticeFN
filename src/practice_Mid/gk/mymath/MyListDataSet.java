package hus.oop.fraction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyListDataSet implements MyDataSet {
    private List<MyFraction> fractions;

    /**
     * Hàm dựng khởi tạo list chứa các phân số.
     */
    public MyListDataSet() {
        this.fractions = new ArrayList<>();
    }

    /**
     * Hàm dựng khởi tạo list chứa các phân số theo truyền vào.
     * @param fractions
     */
    public MyListDataSet(List<MyFraction> fractions) {
        // Tạo mới để tránh chỉnh sửa list bên ngoài
        this.fractions = new ArrayList<>();
        for (MyFraction f : fractions) {
            this.fractions.add(new MyFraction(f));
        }
    }

    @Override
    public boolean insert(MyFraction fraction, int index) {
        if (index < 0 || index > fractions.size()) {
            return false;
        }
        fractions.add(index, new MyFraction(fraction));
        return true;
    }

    @Override
    public boolean append(MyFraction fraction) {
        fractions.add(new MyFraction(fraction));
        return true;
    }

    @Override
    public MyListDataSet toSimplify() {
        List<MyFraction> simplified = new ArrayList<>();
        for (MyFraction f : fractions) {
            MyFraction tmp = new MyFraction(f);
            tmp.simplify();
            simplified.add(tmp);
        }
        return new MyListDataSet(simplified);
    }

    @Override
    public MyListDataSet sortIncreasing() {
        List<MyFraction> copyList = new ArrayList<>();
        for (MyFraction f : fractions) {
            copyList.add(new MyFraction(f));
        }
        // Sử dụng Collections.sort với Comparator lấy từ compareTo
        Collections.sort(copyList, new Comparator<MyFraction>() {
            @Override
            public int compare(MyFraction o1, MyFraction o2) {
                return o1.compareTo(o2);
            }
        });
        return new MyListDataSet(copyList);
    }

    @Override
    public MyListDataSet sortDecreasing() {
        List<MyFraction> copyList = new ArrayList<>();
        for (MyFraction f : fractions) {
            copyList.add(new MyFraction(f));
        }
        Collections.sort(copyList, new Comparator<MyFraction>() {
            @Override
            public int compare(MyFraction o1, MyFraction o2) {
                return -o1.compareTo(o2);
            }
        });
        return new MyListDataSet(copyList);
    }

    @Override
    public String myDataSetToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < fractions.size(); i++) {
            sb.append(fractions.get(i).toString());
            if (i < fractions.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void print() {
        System.out.println(myDataSetToString());
    }
}


