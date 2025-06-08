package practice_Mid.HK2223.de1hk2.dataset;

public class IntegrationCalculator {
    private MyIntegrator integrator;
    private MyPolynomial poly;

    /**
     * Hàm dựng, khởi tạo đa thức cần tính tích phân.
     * @param poly
     */
    public IntegrationCalculator(MyPolynomial poly) {
        this.poly = poly;
    }

    /**
     * Hàm dựng, khởi tạo phương pháp tính tích phân và đa thức cần tính tích phân.
     * @param integrator
     * @param poly
     */
    public IntegrationCalculator(MyIntegrator integrator, MyPolynomial poly) {
        this.integrator = integrator;
        this.poly = poly;
    }

    public void setPoly(MyPolynomial poly) {
        this.poly = poly;
    }

    public void setIntegrator(MyIntegrator integrator) {
        this.integrator = integrator;
    }

    public double integrate(double lower, double upper) {
        if (integrator == null) {
            throw new IllegalStateException("Integrator is not set.");
        }
        return integrator.integrate(poly, lower, upper);
    }
}