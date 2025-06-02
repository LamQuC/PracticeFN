package practice_F.hk1_2425_giai.rootsolver;

public class MyMath {
    public static double sin(double x) {
        /* TODO */
        double term = x, sum = 0;
        int n = 1;
        while (Math.abs(term) > 1e-15) {
            sum += term;
            term *= -x * x / ((2 * n) * (2 * n + 1));
            n++;
        }
        return sum;
    }

    public static double cos(double x) {
        /* TODO */
        double term = 1, sum = 0;
        int n = 1;
        while (Math.abs(term) > 1e-15) {
            sum += term;
            term *= -x * x / ((2 * n - 1) * (2 * n));
            n++;
        }
        return sum;
    }

    public double exp(double x) {
        /* TODO */
        double sum = 1, term = 1;
        int n = 1;
        while (term > 1e-15) {
            term *= x / n;
            sum += term;
            n++;
        }
        return sum;
    }

    public double ln(double x) {
        /* TODO */
        if (x <= 0) throw new IllegalArgumentException("x must be > 0");
        double result = 0;
        double y = (x - 1) / (x + 1);
        double y2 = y * y;
        double term = y;
        for (int i = 1; i < 1000; i += 2) {
            result += term / i;
            term *= y2;
        }
        return 2 * result;
    }
}
