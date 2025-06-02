package practice_F.hk2_2324_giai.de2.integration;

import java.util.ArrayList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        coefficients = new ArrayList<>();
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= coefficients.size()) {
            return 0;
        }
        return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     * @return
     */
    @Override
    public double[] coefficients() {
        double[] result = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            result[i] = coefficients.get(i);
        }
        return result;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial insertAtStart(double coefficient) {
        coefficients.add(0, coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial insertAtEnd(double coefficient) {
        coefficients.add(coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insertAtPosition(double coefficient, int index) {
        if (index < 0 || index > coefficients.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        coefficients.add(index, coefficient);
        return this;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        coefficients.set(index, coefficient);
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) != 0) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public ListPolynomial derivative() {
        ListPolynomial result = new ListPolynomial();
        double[] deriv = differentiate();
        for (double coeff : deriv) {
            result.insertAtEnd(coeff);
        }
        return result;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là tổng hai đa thức.
     */
    public ListPolynomial plus(Polynomial another) {
        ListPolynomial result = new ListPolynomial();
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
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plusTo(Polynomial another) {
        double[] coeffs2 = another.coefficients();
        int maxSize = Math.max(coefficients.size(), coeffs2.length);

        for (int i = coefficients.size(); i < maxSize; i++) {
            coefficients.add(0.0);
        }
        for (int i = 0; i < coeffs2.length; i++) {
            if (i < coefficients.size()) {
                coefficients.set(i, coefficients.get(i) + coeffs2[i]);
            } else {
                coefficients.add(coeffs2[i]);
            }
        }
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là hiệu hai đa thức.
     */
    public ListPolynomial minus(Polynomial another) {
        ListPolynomial result = new ListPolynomial();
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
    public ListPolynomial minusFrom(Polynomial another) {
        double[] coeffs2 = another.coefficients();
        List<Double> temp = new ArrayList<>();
        int maxSize = Math.max(coefficients.size(), coeffs2.length);

        for (int i = 0; i < maxSize; i++) {
            double coeff1 = i < coefficients.size() ? coefficients.get(i) : 0;
            double coeff2 = i < coeffs2.length ? coeffs2[i] : 0;
            temp.add(coeff2 - coeff1);
        }
        coefficients = temp;
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là đa thức nhân của hai đa thức.
     */
    public ListPolynomial multiply(Polynomial another) {
        ListPolynomial result = new ListPolynomial();
        double[] coeffs1 = coefficients();
        double[] coeffs2 = another.coefficients();

        for (int i = 0; i < coeffs1.length + coeffs2.length - 1; i++) {
            result.insertAtEnd(0);
        }

        for (int i = 0; i < coeffs1.length; i++) {
            for (int j = 0; j < coeffs2.length; j++) {
                double newCoeff = result.coefficients.get(i + j) + coeffs1[i] * coeffs2[j];
                result.coefficients.set(i + j, newCoeff);
            }
        }
        return result;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiplyBy(Polynomial another) {
        ListPolynomial result = multiply(another);
        this.coefficients = result.coefficients;
        return this;
    }
}