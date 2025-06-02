package practice_Mid.HK2122giai.number;

import java.lang.Comparable;

public class Fraction extends Number implements Comparable<Fraction> {
    private int numerator;
    private int denominator;
    public Fraction(Fraction frac){
        this.numerator = frac.numerator;
        this.denominator = frac.denominator;
    }
    public Fraction(int numerator){
        this.numerator = numerator;
        this.denominator = 1;
    }
    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator  = denominator;
    }
    public Fraction add(Fraction fraction){
        this.numerator = this.numerator*fraction.denominator + fraction.numerator*this.denominator;
        this.denominator = this.denominator*fraction.denominator;
        return this;
    }
    public Fraction add(int numerator){
        this.numerator = this.numerator+numerator*this.denominator;
        return this;
    }
    @Override
    public int compareTo(Fraction other) {
        return Integer.compare(this.numerator * other.denominator,
                other.numerator * this.denominator);
    }
    public boolean equals(Fraction other){
        return this.numerator * other.denominator==
        other.numerator * this.denominator;
    }
    public int gcd(int a, int b){
        if (b == 0) return Math.abs(a);
        return gcd(b, a % b);
    }
    public void simplify(){
        int g = gcd(numerator, denominator);
        numerator /= g;
        denominator /= g;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }
    public String toString()
    {
        return "Fraction[ "+ numerator + "/" +denominator+" ]";
    }

    @Override
    public long longValue() {
        return super.longValue();
    }

    @Override
    public int intValue() {
        return super.intValue();
    }

    @Override
    public double doubleValue() {
        return super.doubleValue();
    }

    @Override
    public float floatValue() {
        return super.floatValue();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}
