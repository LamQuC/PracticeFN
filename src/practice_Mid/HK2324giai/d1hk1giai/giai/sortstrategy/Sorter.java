package practice_Mid.HK2324giai.d1hk1giai.giai.sortstrategy;

public interface Sorter {

    /**
     * Phương thức sắp xếp mảng dữ liệu data.
     * Nếu order là true thì sắp xếp theo thứ tự tăng dần,
     * nếu order là false thì sắp xếp theo thứ tự giảm dần.
     * @param data
     * @param order
     */
    // Phương thức sắp xếp dữ liệu data. nếu order là true.
    void sort(double[] data, boolean order);
}
