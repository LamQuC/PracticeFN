package lab12.integration;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 2;
    private double[] coefficients;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        /* TODO */
        coefficients = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     *
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index >= size) return 0;
        return coefficients[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     *
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double[] result = new double[size];
        System.arraycopy(coefficients, 0, result, 0, size);
        return result;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     *
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial append(double coefficient) {
        /* TODO */
        if (size == coefficients.length) enlarge();
        coefficients[size++] = coefficient;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insert(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index > size) return this;
        if (size == coefficients.length) enlarge();
        for (int i = size; i > index; i--) {
            coefficients[i] = coefficients[i - 1];
        }
        coefficients[index] = coefficient;
        size++;
        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index >= size) return this;
        coefficients[index] = coefficient;
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     *
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        /* TODO */
        for (int i = size - 1; i >= 0; i--) {
            if (coefficients[i] != 0) return i;
        }
        return 0;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     *
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     *
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        double[] derived = differentiate();
        ArrayPolynomial result = new ArrayPolynomial();
        for (double coeff : derived) {
            result.append(coeff);
        }
        return result;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plus(ArrayPolynomial another) {
        /* TODO */
        ArrayPolynomial result = new ArrayPolynomial();
        int maxSize = Math.max(this.size, another.size);
        for (int i = 0; i < maxSize; i++) {
            double coeffThis = (i < this.size) ? this.coefficients[i] : 0;
            double coeffAnother = (i < another.size) ? another.coefficients[i] : 0;
            result.append(coeffThis + coeffAnother);
        }
        return result;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minus(ArrayPolynomial another) {
        /* TODO */
        ArrayPolynomial result = new ArrayPolynomial();
        int maxSize = Math.max(this.size, another.size);
        for (int i = 0; i < maxSize; i++) {
            double coeffThis = (i < this.size) ? this.coefficients[i] : 0;
            double coeffAnother = (i < another.size) ? another.coefficients[i] : 0;
            result.append(coeffThis - coeffAnother);
        }
        return result;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiply(ArrayPolynomial another) {
        /* TODO */
        ArrayPolynomial result = new ArrayPolynomial();
        double[] newCoeffs = new double[this.size + another.size - 1];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < another.size; j++) {
                newCoeffs[i + j] += this.coefficients[i] * another.coefficients[j];
            }
        }
        for (double coeff : newCoeffs) {
            result.append(coeff);
        }
        return result;
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
        double[] newCoefficients = new double[coefficients.length * 2];
        System.arraycopy(coefficients, 0, newCoefficients, 0, size);
        coefficients = newCoefficients;
    }
}
