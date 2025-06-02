package practice_F.hk2_2324_giai.de2.integration;

import java.io.FileWriter;
import java.io.IOException;

public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("NguyenVanA_123456_Integration.txt");

            writer.write("Testing Polynomial Operations:\n");
            testPolynomial(writer);
            writer.write("\nTesting Integration Calculator:\n");
            testIntegrationCalculator(writer);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testPolynomial() throws IOException {
        FileWriter writer = new FileWriter("NguyenVanA_123456_Integration.txt", true);

        // Test ArrayPolynomial
        writer.write("Testing ArrayPolynomial:\n");
        ArrayPolynomial poly1 = new ArrayPolynomial();
        poly1.insertAtEnd(1).insertAtEnd(2).insertAtEnd(3); // 1 + 2x + 3x^2
        writer.write("Created polynomial: " + poly1.toString() + "\n");

        writer.write("Coefficient at index 1: " + poly1.coefficient(1) + "\n");
        writer.write("Degree: " + poly1.degree() + "\n");
        writer.write("Evaluate at x=2: " + poly1.evaluate(2) + "\n");

        poly1.set(4, 1); // Change coefficient at index 1 to 4
        writer.write("After setting coefficient at index 1 to 4: " + poly1.toString() + "\n");

        ArrayPolynomial poly2 = new ArrayPolynomial();
        poly2.insertAtEnd(2).insertAtEnd(1); // 2 + x
        writer.write("Second polynomial: " + poly2.toString() + "\n");

        ArrayPolynomial sum = poly1.plus(poly2);
        writer.write("Sum: " + sum.toString() + "\n");

        ArrayPolynomial diff = poly1.minus(poly2);
        writer.write("Difference: " + diff.toString() + "\n");

        ArrayPolynomial product = poly1.multiply(poly2);
        writer.write("Product: " + product.toString() + "\n");

        ArrayPolynomial derivative = poly1.derivative();
        writer.write("Derivative: " + derivative.toString() + "\n");

        // Test ListPolynomial
        writer.write("\nTesting ListPolynomial:\n");
        ListPolynomial poly3 = new ListPolynomial();
        poly3.insertAtEnd(1).insertAtEnd(2).insertAtEnd(3); // 1 + 2x + 3x^2
        writer.write("Created polynomial: " + poly3.toString() + "\n");

        writer.write("Coefficient at index 1: " + poly3.coefficient(1) + "\n");
        writer.write("Degree: " + poly3.degree() + "\n");
        writer.write("Evaluate at x=2: " + poly3.evaluate(2) + "\n");

        poly3.set(4, 1);
        writer.write("After setting coefficient at index 1 to 4: " + poly3.toString() + "\n");

        ListPolynomial poly4 = new ListPolynomial();
        poly4.insertAtEnd(2).insertAtEnd(1); // 2 + x
        writer.write("Second polynomial: " + poly4.toString() + "\n");

        ListPolynomial sumList = poly3.plus(poly4);
        writer.write("Sum: " + sumList.toString() + "\n");

        ListPolynomial diffList = poly3.minus(poly4);
        writer.write("Difference: " + diffList.toString() + "\n");

        ListPolynomial productList = poly3.multiply(poly4);
        writer.write("Product: " + productList.toString() + "\n");

        ListPolynomial derivativeList = poly3.derivative();
        writer.write("Derivative: " + derivativeList.toString() + "\n");

        writer.close();
    }

    public static void testIntegrationCalculator() throws IOException {
        FileWriter writer = new FileWriter("NguyenVanA_123456_Integration.txt", true);

        ArrayPolynomial poly = new ArrayPolynomial();
        poly.insertAtEnd(1).insertAtEnd(2).insertAtEnd(3); // 1 + 2x + 3x^2
        writer.write("Polynomial for integration: " + poly.toString() + "\n");

        IntegrationCalculator calc = new IntegrationCalculator(poly);

        calc.setIntegrator(new MidpointRule(0.001, 1000));
        double resultMidpoint = calc.integrate(0, 1);
        writer.write("Midpoint Rule integration from 0 to 1: " + resultMidpoint + "\n");

        calc.setIntegrator(new TrapezoidRule(0.001, 1000));
        double resultTrapezoid = calc.integrate(0, 1);
        writer.write("Trapezoid Rule integration from 0 to 1: " + resultTrapezoid + "\n");

        calc.setIntegrator(new SimpsonRule(0.001, 1000));
        double resultSimpson = calc.integrate(0, 1);
        writer.write("Simpson Rule integration from 0 to 1: " + resultSimpson + "\n");

        writer.close();
    }
}