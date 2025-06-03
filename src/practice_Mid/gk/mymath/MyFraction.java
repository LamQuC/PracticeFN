package hus.oop.fraction;

public class MyFraction implements MyFractionComparable {
    private int numerator;
    private int denominator;

    /**
     * Hàm dựng khởi tạo giá trị mặc định là 1/1.
     */
    public MyFraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     * Hàm dựng khởi tạo giá trị cho tử số và mẫu số.
     * @param numerator
     * @param denominator
     */
    public MyFraction(int numerator, int denominator) {
        // Nếu người dùng truyền denominator là 0, ta có thể ném ngoại lệ IllegalArgumentException
        if (denominator == 0) {
            throw new IllegalArgumentException("Mẫu số không thể là 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        // Không tự động rút gọn ở đây, để rút gọn khi cần thiết hoặc do người dùng yêu cầu
    }

    /**
     * Hàm dựng copy, copy giá trị của phân số truyền vào.
     * @param copyMyFraction
     */
    public MyFraction(MyFraction copyMyFraction) {
        this.numerator = copyMyFraction.numerator;
        this.denominator = copyMyFraction.denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Mẫu số không thể là 0");
        }
        this.denominator = denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu byte của phân số.
     * @return
     */
    public byte byteValue() {
        return (byte) doubleValue();
    }

    /**
     * Phương thức trả về giá trị kiểu int của phân số.
     * @return
     */
    public int intValue() {
        return (int) doubleValue();
    }

    /**
     * Phương thức trả về giá trị kiểu long của phân số.
     * @return
     */
    public long longValue() {
        return (long) doubleValue();
    }

    /**
     * Phương thức trả về giá trị kiểu short của phân số.
     * @return
     */
    public short shortValue() {
        return (short) doubleValue();
    }

    /**
     * Phương thức trả về giá trị kiểu double của phân số.
     * @return
     */
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu float của phân số.
     * @return
     */
    public float floatValue() {
        return (float) numerator / denominator;
    }

    /**
     * Phương thức tính ước số chung lớn nhất của tử số và mẫu số.
     * @return ước số chung lớn nhất của tử số và mẫu số.
     */
    private int gcd() {
        int a = Math.abs(numerator);
        int b = Math.abs(denominator);
        if (b == 0) {
            return a;
        }
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    /**
     * Phương thức rút gọn phân số về phân số tối giản.
     */
    public void simplify() {
        int gcd = gcd();
        if (gcd != 0) {
            numerator /= gcd;
            denominator /= gcd;
            // Giữ quy tắc: mẫu số luôn dương
            if (denominator < 0) {
                denominator = -denominator;
                numerator = -numerator;
            }
        }
    }

    @Override
    public int compareTo(MyFraction another) {
        // So sánh hai phân số a/b và c/d bằng (a*d) và (c*b)
        // Tránh lạm phát kiểu: ép kiểu về long nếu cần
        long lhs = (long) this.numerator * another.denominator;
        long rhs = (long) another.numerator * this.denominator;
        if (lhs < rhs) return -1;
        if (lhs > rhs) return 1;
        // Nếu bằng, so sánh tiếp theo theo mẫu số tăng dần
        // (theo yêu cầu: khi giá trị bằng, sắp xếp theo mẫu số tăng dần
        if (this.denominator < another.denominator) return -1;
        if (this.denominator > another.denominator) return 1;
        return 0;
    }

    /**
     * Phương thức mô tả phân số theo định dạng numerator/denominator;
     * @return
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

