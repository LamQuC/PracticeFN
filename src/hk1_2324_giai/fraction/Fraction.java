package hk1_2324_giai.fraction;

public class Fraction implements FractionComparable {
    private int numerator;
    private int denominator;

    /**
     * Hàm dựng khởi tạo giá trị mặc định là 1/1.
     */
    public Fraction() {
        /* TODO */
        numerator = 1;
        denominator = 1;
    }

    /**
     * Hàm dựng khởi tạo giá trị cho tử số và mẫu số.
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        /* TODO */
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Hàm dựng copy, copy giá trị của phân số truyền vào.
     * @param copyFraction
     */
    public Fraction(Fraction copyFraction) {
        /* TODO */
        numerator = copyFraction.numerator;
        denominator = copyFraction.denominator;
    }

    public int getNumerator() {
        /* TODO */
        return numerator;
    }

    public void setNumerator(int numerator) {
        /* TODO */
        this.numerator = numerator;
    }

    public int getDenominator() {
        /* TODO */
        return denominator;
    }

    public void setDenominator(int denominator) {
        /* TODO */
        this.denominator = denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu byte của phân số.
     * @return
     */
    public byte byteValue() {
        /* TODO */
        return (byte) (numerator / denominator);
    }

    /**
     * Phương thức trả về giá trị kiểu int của phân số.
     * @return
     */
    public int intValue() {
        /* TODO */
        return numerator / denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu long của phân số.
     * @return
     */
    public long longValue() {
        /* TODO */
        return numerator / denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu short của phân số.
     * @return
     */
    public short shortValue() {
        /* TODO */
        return (short) (numerator / denominator);
    }

    /**
     * Phương thức trả về giá trị kiểu double của phân số.
     * @return
     */
    public double doubleValue() {
        /* TODO */
        return (double) numerator / denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu float của phân số.
     * @return
     */
    public float floatValue() {
        /* TODO */
        return (float) numerator / denominator;
    }

    /**
     * Phương thức tính ước số chung lớn nhất của tử số và mẫu số.
     * @return ước số chung lớn nhất của tử số và mẫu số.
     */
    private int gcd() {
        /* TODO */
        int left = Math.abs(numerator);
        int right = Math.abs(denominator);
        while (left * right != 0) {
            if (left > right) {
                left %= right;
            } else {
                right %= left;
            }
        }
        return left + right;
    }

    /**
     * Phương thức rút gọn phân số về phân số tối giản.
     */
    public void simplify() {
        /* TODO */
        int gcd = gcd();
        numerator /= gcd;
        denominator /= gcd;
    }

    @Override
    public int compareTo(Fraction another) {
        /* TODO */
        return (numerator * another.denominator - another.numerator * denominator);
    }

    /**
     * Phương thức mô tả phân số theo định dạng numerator/denominator;
     * @return
     */
    @Override
    public String toString() {
        /* TODO */
        if (denominator * numerator < 0) {
            return "-" + Math.abs(numerator) + "/" + Math.abs(denominator);
        } else {
            return Math.abs(numerator) + "/" + Math.abs(denominator);
        }
    }
}
