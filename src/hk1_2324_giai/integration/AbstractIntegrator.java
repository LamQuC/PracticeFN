package hk1_2324_giai.integration;

public abstract class AbstractIntegrator implements Integrator {
    protected double precision;
    protected int maxIterations;

    public AbstractIntegrator(double precision, int maxIterations) {
        /* TODO */
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    public double getPrecision() {
        /* TODO */
        return precision;
    }

    public void setPrecision(double precision) {
        /* TODO */
        this.precision = precision;
    }

    public int getMaxIterations() {
        /* TODO */
        return maxIterations;
    }

    public void setMaxIterations(int maxIterations) {
        /* TODO */
        this.maxIterations = maxIterations;
    }
}
