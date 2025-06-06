package practice_F.hk1_2425_giai.rootsolver;

public interface AbstractFunction {
    /*
     * Tính giá trị của hàm tại điểm x
     */
    double evaluate(double x);

    /*
     * Tính giá trị của đạo hàm tại điểm x
     */
    double derivative(double x);
}
