package hk1_2324_giai.fraction;

import java.util.Comparator;

public interface FractionComparator extends Comparator<Fraction> {
    int compare(Fraction left, Fraction right);
}
