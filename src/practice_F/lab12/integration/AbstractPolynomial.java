package practice_F.lab12.integration;

public abstract class AbstractPolynomial implements Polynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     *
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        boolean firstTerm = true;
        double[] coeffs = coefficients();
        int maxDegree = degree();

        for (int i = 0; i <= maxDegree && i < coeffs.length; i++) {
            if (coeffs[i] != 0) {
                double absCoeff = Math.abs(coeffs[i]);
                String coeffStr;
                if (Math.abs(absCoeff - (int) absCoeff) < 1e-10) {
                    coeffStr = String.valueOf((int) absCoeff);
                } else {
                    coeffStr = String.valueOf(absCoeff);
                }

                if (firstTerm) {
                    if (coeffs[i] < 0) {
                        sb.append("-");
                    }
                    sb.append(coeffStr);
                    firstTerm = false;
                } else {
                    if (coeffs[i] > 0) {
                        sb.append(" + ");
                    } else {
                        sb.append(" - ");
                    }
                    sb.append(coeffStr);
                }

                if (i == 1) {
                    sb.append("x");
                } else if (i > 1) {
                    sb.append("x^").append(i);
                }
            }
        }

        return sb.length() > 0 ? sb.toString() : "0";
    }

    /**
     * Lấy đạo hàm đa thức.
     *
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        /* TODO */
        double[] coeffs = coefficients();
        if (coeffs.length <= 1) {
            return new double[]{0};
        }
        double[] derived = new double[coeffs.length - 1];
        for (int i = 1; i < coeffs.length; i++) {
            derived[i - 1] = coeffs[i] * i;
        }
        return derived;
    }
}
