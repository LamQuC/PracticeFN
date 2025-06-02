package practice_F.hk1_2324_giai.integration_polynomial;

public class MyArrayPolynomial extends MyAbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficients;
    private int length;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayPolynomial() {
        /* TODO */
        coefficients = new double[DEFAULT_CAPACITY];
        length = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
        }
        return coefficients[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double[] result = new double[length];
        for (int i = 0; i < length; i++) {
            result[i] = coefficients[i];
        }
        return result;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial append(double coefficient) {
        /* TODO */
        if (length == coefficients.length) {
            enlarge();
        }
        coefficients[length++] = coefficient;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không thêm được.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial insert(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index > length) {
            return this;
        }
        if (length == coefficients.length) {
            enlarge();
        }
        for (int i = length; i > index; i--) {
            coefficients[i] = coefficients[i - 1];
        }
        coefficients[index] = coefficient;
        length++;
        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index >= length) {
            return this;
        }
        coefficients[index] = coefficient;
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        /* TODO */
        return length - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0;
        for (int i = length - 1; i >= 0; i--) {
            result = result * x + coefficients[i];
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public MyPolynomial derivative() {
        /* TODO */
        MyArrayPolynomial result = new MyArrayPolynomial();
        for (int i = 1; i < length; i++) {
            result.append(coefficients[i] * i);
        }
        return result;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial plus(MyArrayPolynomial another) {
        /* TODO */
        int maxLength = Math.max(length, another.length);
        for (int i = 0; i < maxLength; i++) {
            if (i < length && i < another.length) {
                coefficients[i] += another.coefficients[i];
            } else if (i >= length && i < another.length) {
                append(another.coefficients[i]);
            }
        }
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial minus(MyArrayPolynomial another) {
        /* TODO */
        int maxLength = Math.max(length, another.length);
        for (int i = 0; i < maxLength; i++) {
            if (i < length && i < another.length) {
                coefficients[i] -= another.coefficients[i];
            } else if (i >= length && i < another.length) {
                append(-another.coefficients[i]);
            }
        }
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial multiply(MyArrayPolynomial another) {
        /* TODO */
        double[] result = new double[length + another.length - 1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < another.length; j++) {
                result[i + j] += coefficients[i] * another.coefficients[j];
            }
        }
        coefficients = result;
        length = result.length;
        return this;
    }

    /**
     * Tăng kích thước gấp đôi để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
        double[] newCoefficients = new double[coefficients.length * 2];
        for (int i = 0; i < length; i++) {
            newCoefficients[i] = coefficients[i];
        }
        coefficients = newCoefficients;
    }
}
