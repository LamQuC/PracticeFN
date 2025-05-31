package hk2_2324_giai.de2.integration;

public abstract class AbstractPolynomial implements Polynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        double[] coeffs = coefficients();
        boolean first = true;

        for (int i = 0; i < coeffs.length; i++) {
            if (coeffs[i] != 0) {
                if (!first) {
                    sb.append(coeffs[i] > 0 ? " + " : " - ");
                } else if (coeffs[i] < 0) {
                    sb.append("-");
                }
                first = false;

                double absCoeff = Math.abs(coeffs[i]);
                if (i == 0) {
                    sb.append(absCoeff);
                } else {
                    if (absCoeff != 1) {
                        sb.append(absCoeff);
                    }
                    sb.append("x");
                    if (i > 1) {
                        sb.append("^").append(i);
                    }
                }
            }
        }
        if (first) {
            sb.append("0");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        double[] coeffs = coefficients();
        if (coeffs.length <= 1) {
            return new double[]{0};
        }

        double[] derivative = new double[coeffs.length - 1];
        for (int i = 1; i < coeffs.length; i++) {
            derivative[i - 1] = coeffs[i] * i;
        }
        return derivative;
    }
}