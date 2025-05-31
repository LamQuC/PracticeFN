package hk2_2324_giai.de2.integration;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        this.coefficents = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= size) {
            return 0;
        }
        return coefficents[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        double[] result = new double[size];
        System.arraycopy(coefficents, 0, result, 0, size);
        return result;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insertAtStart(double coefficient) {
        if (size == coefficents.length) {
            enlarge();
        }
        for (int i = size; i > 0; i--) {
            coefficents[i] = coefficents[i - 1];
        }
        coefficents[0] = coefficient;
        size++;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insertAtEnd(double coefficient) {
        if (size == coefficents.length) {
            enlarge();
        }
        coefficents[size] = coefficient;
        size++;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insertAtPosition(double coefficient, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (size == coefficents.length) {
            enlarge();
        }
        for (int i = size; i > index; i--) {
            coefficents[i] = coefficents[i - 1];
        }
        coefficents[index] = coefficient;
        size++;
        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        coefficents[index] = coefficient;
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        for (int i = size - 1; i >= 0; i--) {
            if (coefficents[i] != 0) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += coefficents[i] * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public ArrayPolynomial derivative() {
        ArrayPolynomial result = new ArrayPolynomial();
        double[] deriv = differentiate();
        for (double coeff : deriv) {
            result.insertAtEnd(coeff);
        }
        return result;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức mới là tổng hai đa thức.
     */
    public ArrayPolynomial plus(Polynomial another) {
        ArrayPolynomial result = new ArrayPolynomial();
        double[] coeffs1 = coefficients();
        double[] coeffs2 = another.coefficients();
        int maxSize = Math.max(coeffs1.length, coeffs2.length);

        for (int i = 0; i < maxSize; i++) {
            double coeff1 = i < coeffs1.length ? coeffs1[i] : 0;
            double coeff2 = i < coeffs2.length ? coeffs2[i] : 0;
            result.insertAtEnd(coeff1 + coeff2);
        }
        return result;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plusTo(Polynomial another) {
        double[] coeffs2 = another.coefficients();
        int maxSize = Math.max(size, coeffs2.length);
        if (maxSize > coefficents.length) {
            enlarge();
        }
        for (int i = size; i < maxSize; i++) {
            coefficents[i] = 0;
            size++;
        }
        for (int i = 0; i < coeffs2.length; i++) {
            coefficents[i] += coeffs2[i];
        }
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là hiệu hai đa thức.
     */
    public ArrayPolynomial minus(Polynomial another) {
        ArrayPolynomial result = new ArrayPolynomial();
        double[] coeffs1 = coefficients();
        double[] coeffs2 = another.coefficients();
        int maxSize = Math.max(coeffs1.length, coeffs2.length);

        for (int i = 0; i < maxSize; i++) {
            double coeff1 = i < coeffs1.length ? coeffs1[i] : 0;
            double coeff2 = i < coeffs2.length ? coeffs2[i] : 0;
            result.insertAtEnd(coeff1 - coeff2);
        }
        return result;
    }

    /**
     * Trừ đa thức hiện tại cho đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minusFrom(Polynomial another) {
        double[] coeffs2 = another.coefficients();
        int maxSize = Math.max(size, coeffs2.length);
        if (maxSize > coefficents.length) {
            enlarge();
        }
        double[] temp = new double[maxSize];
        for (int i = 0; i < maxSize; i++) {
            double coeff1 = i < size ? coefficents[i] : 0;
            double coeff2 = i < coeffs2.length ? coeffs2[i] : 0;
            temp[i] = coeff2 - coeff1;
        }
        coefficents = temp;
        size = maxSize;
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là đa thức nhân của hai đa thức.
     */
    public ArrayPolynomial multiply(Polynomial another) {
        ArrayPolynomial result = new ArrayPolynomial();
        double[] coeffs1 = coefficients();
        double[] coeffs2 = another.coefficients();

        for (int i = 0; i < coeffs1.length + coeffs2.length - 1; i++) {
            result.insertAtEnd(0);
        }

        for (int i = 0; i < coeffs1.length; i++) {
            for (int j = 0; j < coeffs2.length; j++) {
                result.coefficents[i + j] += coeffs1[i] * coeffs2[j];
            }
        }
        return result;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiplyBy(Polynomial another) {
        ArrayPolynomial result = multiply(another);
        this.coefficents = result.coefficents;
        this.size = result.size;
        return this;
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        double[] newCoefficients = new double[coefficents.length * 2];
        System.arraycopy(coefficents, 0, newCoefficients, 0, size);
        coefficents = newCoefficients;
    }
}