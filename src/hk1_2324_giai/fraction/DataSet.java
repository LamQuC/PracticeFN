package hk1_2324_giai.fraction;

import java.util.Arrays;
import java.util.Collections;

public class DataSet {
    private static int DEFAULT_CAPACITY = 8;
    private Fraction[] data;
    private int length;

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số có kích thước là DEFAULT_CAPACITY.
     */
    public DataSet() {
        data = new Fraction[DEFAULT_CAPACITY];
    }

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số theo data.
     * @param data
     */
    public DataSet(Fraction[] data) {
        this.data = data;
        this.length = data.length;
    }

    /**
     * Phương thức chèn phân số fraction vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không chèn được vào.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction là một phân số.
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    public boolean insert(Fraction fraction, int index) {
        /* TODO */
        if (checkBoundaries(index, length)) {
            if (length == data.length) {
                enlarge();
            }
            for (int i = length; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = fraction;
            length++;
            return true;
        }
        return false;
    }

    /**
     * Phương thức tạo ra một tập dữ liệu lưu các phân số tối giản của các phân số trong tập dữ liệu gốc.
     * @return tập dữ liệu mới lưu các phân số tối giản của các phân số trong tập dữ liệu gốc.
     */
    public DataSet toSimplify() {
        /* TODO */
        Fraction[] simplifiedFractions = new Fraction[length];
        for (int i = 0; i < length; i++) {
            Fraction fraction = new Fraction(data[i]);
            fraction.simplify();
            simplifiedFractions[i] = fraction;
        }
        return new DataSet(simplifiedFractions);
    }

    /**
     * Phương thức thêm phân số fraction vào vị trí cuối cùng chưa có dứ liệu của mảng data.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction
     * @return
     */
    public void append(Fraction fraction) {
        /* TODO */
        if (length == data.length) {
            enlarge();
        }
        data[length++] = fraction;
    }

    private Fraction[] copyFraction(Fraction[] fractions, int fromIdx, int toIdx) {
        /* TODO */
        Fraction[] fraction = new Fraction[toIdx - fromIdx + 1];
        for (int i = fromIdx; i <= toIdx; i++) {
            fraction[i - fromIdx] = new Fraction(fractions[i]);
        }
        return fraction;
    }

    /**
     * Sắp xếp mảng các phân số theo thứ tự có giá trị tăng dần.
     * Nếu hai phân số bằng nhau thì sắp xếp theo thứ tự có mẫu số tăng dần.
     * @return mảng mới được sắp xếp theo thứ tự có giá trị tăng dần.
     */
    public Fraction[] sortIncreasing() {
        /* TODO */
        Fraction[] sortedFractions = copyFraction(data, 0, length - 1);
        FractionComparator comparator = (Fraction f1, Fraction f2) -> {
            if (f1.compareTo(f2) == 0) {
                return f1.getDenominator() - f2.getDenominator();
            }
            return f1.compareTo(f2);
        };
        Arrays.sort(sortedFractions, comparator);
        return sortedFractions;
    }

    /**
     * Sắp xếp mảng các phân số theo thứ tự có giá trị giảm dần.
     * Nếu hai phân số bằng nhau thì sắp xếp theo thứ tự có mẫu số giảm dần.
     * @return mảng mới được sắp xếp theo thứ tự có giá trị giảm dần.
     */
    public Fraction[] sortDecreasing() {
        /* TODO */
        Fraction[] sortedFractions = copyFraction(data, 0, length - 1);
        FractionComparator comparator = (Fraction f1, Fraction f2) -> {
            if (f1.compareTo(f2) == 0) {
                return f1.getDenominator() - f2.getDenominator();
            }
            return f1.compareTo(f2);
        };
        Arrays.sort(sortedFractions, Collections.reverseOrder(comparator));
        return sortedFractions;
    }

    /**
     * Phương thức mở rộng kích thước mảng gấp đôi, bằng cách tạo ra mảng mới có kích thước
     * gấp đôi, sau đó copy dự liệu từ mảng cũ vào.
     */
    private void enlarge() {
        /* TODO */
        Fraction[] newData = new Fraction[data.length * 2];
        int count = 0;
        for (Fraction fraction: data) {
            newData[count++] = fraction;
        }
        data = newData;
    }

    /**
     * Phương thức kiểm tra xem index có nằm trong khoảng [0, upperBound] hay không.
     * @param index
     * @param upperBound
     * @return true nếu index nằm trong khoảng [0, upperBound], false nếu ngược lại.
     */
    private boolean checkBoundaries(int index, int upperBound) {
        /* TODO */
        return index >= 0 && index <= upperBound;
    }

    /**
     * In ra tập dữ liệu theo định dạng [a1, a2, ... , an].
     * @return
     */
    @Override
    public String toString() {
        /* TODO */
        int count = 0;
        StringBuilder result = new StringBuilder("[");
        for (Fraction fraction : data) {
            result.append(fraction);
            if (count ++ < length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    /**
     * In ra mảng các phân số fractions theo định dạng [a1, a2, ... , an].
     * @param fractions
     */
    public static void printFractions(Fraction[] fractions) {
        /* TODO */
        DataSet result = new DataSet(fractions);
        System.out.println(result);
    }
}
