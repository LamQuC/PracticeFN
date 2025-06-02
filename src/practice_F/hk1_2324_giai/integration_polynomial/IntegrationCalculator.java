package practice_F.hk1_2324_giai.integration_polynomial;

public class IntegrationCalculator {
    private Integrator integrator;
    private MyPolynomial polynomial;

    /**
     * Hàm dựng, khởi tạo đa thức cần tính tích phân.
     * @param polynomial
     */
    public IntegrationCalculator(MyPolynomial polynomial) {
        /* TODO */
        this.polynomial = polynomial;
        integrator = new SimpsonMethod(0.01, 1000);
    }

    /**
     * Hàm dựng, khởi tạo phương pháp tính tích phân và đa thức cần tính tích phân.
     * @param integrator
     * @param polynomial
     */
    public IntegrationCalculator(Integrator integrator, MyPolynomial polynomial) {
        /* TODO */
        this.integrator = integrator;
        this.polynomial = polynomial;
    }

    public void setPolynomial(MyPolynomial polynomial) {
        /* TODO */
        this.polynomial = polynomial;
    }

    public void setIntegrator(Integrator integrator) {
        /* TODO */
        this.integrator = integrator;
    }

    public double integrate(double lower, double upper) {
        /* TODO */
        return integrator.integrate(polynomial, lower, upper);
    }
}
