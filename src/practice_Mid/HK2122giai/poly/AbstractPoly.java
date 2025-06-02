package practice_Mid.HK2122giai.poly;

import java.util.Arrays;

public abstract class AbstractPoly implements Poly {
    protected int degree;

    protected int[] differentiate(int[] coeffs) {
        if (coeffs.length <= 1) return new int[]{0};
        int[] result = new int[coeffs.length - 1];
        for (int i = 1; i < coeffs.length; i++) {
            result[i - 1] = i * coeffs[i];
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Poly)) return false;
        Poly other = (Poly) obj;
        return this.degree() == other.degree() &&
                Arrays.equals(this.coefficients(), other.coefficients());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Poly[");
        int[] coeffs = coefficients();
        for (int i = 0; i < coeffs.length; i++) {
            if (i > 0) sb.append(" + ");
            sb.append(coeffs[i]).append("x^").append(i);
        }
        sb.append("]");
        return sb.toString();
    }
}
