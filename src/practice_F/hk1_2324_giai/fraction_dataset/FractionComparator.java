package practice_F.hk1_2324_giai.fraction_dataset;

import java.util.Comparator;

public interface FractionComparator extends Comparator<Fraction> {
    int compare(Fraction left, Fraction right);
}
