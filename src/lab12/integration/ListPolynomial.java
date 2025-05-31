package lab12.integration;

import java.util.ArrayList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        /* TODO */
        coefficients = new ArrayList<>();
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     *
     * @return
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index >= coefficients.size()) return 0;
        return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     *
     * @return
     */
    @Override
    public double[] coefficients() {
        /* TODO */

        double[] result = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            result[i] = coefficients.get(i);
        }
        return result;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức hiện tại.
     *
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial append(double coefficient) {
        /* TODO */

        coefficients.add(coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insert(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index > coefficients.size()) return this;
        coefficients.add(index, coefficient);
        return this;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index >= coefficients.size()) return this;
        coefficients.set(index, coefficient);
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     *
     * @return
     */
    @Override
    public int degree() {
        /* TODO */
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) != 0) return i;
        }
        return 0;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     *
     * @return
     */
    @Override
    public double evaluate(double x) {
        /* TODO */

        double result = 0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     *
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */

        double[] derived = differentiate();
        ListPolynomial result = new ListPolynomial();
        for (double coeff : derived) {
            result.append(coeff);
        }
        return result;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
        /* TODO */
        ListPolynomial result = new ListPolynomial();
        int maxSize = Math.max(this.coefficients.size(), another.coefficients.size());
        for (int i = 0; i < maxSize; i++) {
            double coeffThis = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0;
            double coeffAnother = (i < another.coefficients.size()) ? another.coefficients.get(i) : 0;
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
    public ListPolynomial minus(ListPolynomial another) {
        /* TODO */
        ListPolynomial result = new ListPolynomial();
        int maxSize = Math.max(this.coefficients.size(), another.coefficients.size());
        for (int i = 0; i < maxSize; i++) {
            double coeffThis = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0;
            double coeffAnother = (i < another.coefficients.size()) ? another.coefficients.get(i) : 0;
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
    public ListPolynomial multiply(ListPolynomial another) {
        /* TODO */
        ListPolynomial result = new ListPolynomial();
        double[] newCoeffs = new double[this.coefficients.size() + another.coefficients.size() - 1];
        for (int i = 0; i < this.coefficients.size(); i++) {
            for (int j = 0; j < another.coefficients.size(); j++) {
                newCoeffs[i + j] += this.coefficients.get(i) * another.coefficients.get(j);
            }
        }
        for (double coeff : newCoeffs) {
            result.append(coeff);
        }
        return result;
    }
}
