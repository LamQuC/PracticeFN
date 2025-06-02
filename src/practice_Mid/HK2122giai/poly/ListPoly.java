package practice_Mid.HK2122giai.poly;

import java.util.ArrayList;
import java.util.List;

public class ListPoly extends AbstractPoly {
    private List<Integer> coeffs;

    public ListPoly(List<Integer> coeffs) {
        this.coeffs = new ArrayList<>(coeffs);
        reduce();
    }

    @Override
    public int coefficient(int i) {
        return i < coeffs.size() ? coeffs.get(i) : 0;
    }

    @Override
    public int[] coefficients() {
        return coeffs.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    public int degree() {
        return degree;
    }

    @Override
    public Poly derivative() {
        List<Integer> deriv = new ArrayList<>();
        for (int i = 1; i < coeffs.size(); i++) {
            deriv.add(i * coeffs.get(i));
        }
        return new ListPoly(deriv);
    }

    @Override
    public double evaluate(double x) {
        double sum = 0;
        for (int i = 0; i < coeffs.size(); i++) {
            sum += coeffs.get(i) * Math.pow(x, i);
        }
        return sum;
    }

    public void reduce() {
        degree = coeffs.size() - 1;
        while (degree > 0 && coeffs.get(degree) == 0) {
            coeffs.remove(degree);
            degree--;
        }
    }

    public String type() {
        return "List Poly";
    }
}
