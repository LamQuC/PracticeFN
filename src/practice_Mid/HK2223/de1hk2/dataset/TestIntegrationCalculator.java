package practice_Mid.HK2223.de1hk2.dataset;

import java.util.Random;
import java.io.PrintWriter;
import java.io.File;

public class TestIntegrationCalculator {
    private MyPolynomial polynomial;

    public TestIntegrationCalculator(MyPolynomial polynomial) {
        this.polynomial = polynomial;
    }

    public static void main(String[] args) {
        // The result was saved to .txt file

        try (PrintWriter writer = new PrintWriter(new File("NguyenVanA_123456_Integration.txt"))) {
            TestIntegrationCalculator test = new TestIntegrationCalculator(null);
            writer.println("=== Array Polynomial Test ===");
            test.testArrayPolynomial(writer);
            writer.println("\n=== List Polynomial Test ===");
            test.testListPolynomial(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testArrayPolynomial(PrintWriter writer) {

        Random rand = new Random();
        int size = rand.nextInt(5) + 1; // Random size from 1 to 5
        MyArrayPolynomial polynomial = new MyArrayPolynomial();
        writer.println("Generated coefficients:");
        for (int i = 0; i < size; i++) {
            double coeff = rand.nextDouble() * 10 - 5; // Random from -5 to 5
            polynomial.append(coeff);
            writer.println("Coefficient " + i + ": " + coeff);
        }
        writer.println("Polynomial: " + polynomial);
        writer.println("Degree: " + polynomial.degree());

        polynomial.append(3.5);
        writer.println("After appending 3.5: " + polynomial);
        polynomial.set(2.0, 1);
        writer.println("After setting index 1 to 2.0: " + polynomial);
        polynomial.add(1.5, 2);
        writer.println("After adding 1.5 to index 2: " + polynomial);

        MyArrayPolynomial other = new MyArrayPolynomial();
        other.append(1.0).append(2.0);
        writer.println("Other polynomial: " + other);
        writer.println("Sum: " + polynomial.plus(other));
        writer.println("Difference: " + polynomial.minus(other));
        writer.println("Product: " + polynomial.multiply(other));
        writer.println("Evaluate at x=2: " + polynomial.evaluate(2.0));

        IntegrationCalculator calc = new IntegrationCalculator(new TrapezoidRule(0.001, 10), polynomial);
        double integral = calc.integrate(1.0, 5.0);
        writer.println("Integral from 1.0 to 5.0: " + integral);
    }

    public void testListPolynomial(PrintWriter writer) {
        Random rand = new Random();
        int size = rand.nextInt(5) + 1; // Random size from 1 to 5
        MyListPolynomial polynomial = new MyListPolynomial();
        writer.println("Generated coefficients:");
        for (int i = 0; i < size; i++) {
            double coeff = rand.nextDouble() * 10 - 5; // Random from -5 to 5
            polynomial.append(coeff);
            writer.println("Coefficient " + i + ": " + coeff);
        }
        writer.println("Polynomial: " + polynomial);
        writer.println("Degree: " + polynomial.degree());

        polynomial.append(3.5);
        writer.println("After appending 3.5: " + polynomial);
        polynomial.set(2.0, 1);
        writer.println("After setting index 1 to 2.0: " + polynomial);
        polynomial.add(1.5, 2);
        writer.println("After adding 1.5 to index 2: " + polynomial);

        MyListPolynomial other = new MyListPolynomial();
        other.append(1.0).append(2.0);
        writer.println("Other polynomial: " + other);
        writer.println("Sum: " + polynomial.plus(other));
        writer.println("Difference: " + polynomial.minus(other));
        writer.println("Product: " + polynomial.multiply(other));
        writer.println("Evaluate at x=2: " + polynomial.evaluate(2.0));

        IntegrationCalculator calc = new IntegrationCalculator(new TrapezoidRule(0.001, 10), polynomial);
        double integral = calc.integrate(2.0, 6.0);
        writer.println("Integral from 2.0 to 6.0: " + integral);
    }
}