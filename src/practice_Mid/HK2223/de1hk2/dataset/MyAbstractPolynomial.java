package practice_Mid.HK2223.de1hk2.dataset;

public abstract class MyAbstractPolynomial implements MyPolynomial {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        double[] coeffs = coefficients();
        for (int i = 0; i < coeffs.length; i++) {
            if (i > 0 && coeffs[i] >= 0) sb.append(" + ");
            else if (i > 0) sb.append(" ");
            sb.append(coeffs[i]);
            if (i > 0) sb.append("x^").append(i);
        }
        sb.append("]");
        return sb.toString();
    }

    public double[] differentiate() {
        double[] coeffs = coefficients();
        if (coeffs.length <= 1) return new double[]{0};
        double[] deriv = new double[coeffs.length - 1];
        for (int i = 1; i < coeffs.length; i++) {
            deriv[i - 1] = coeffs[i] * i;
        }
        return deriv;
    }
}