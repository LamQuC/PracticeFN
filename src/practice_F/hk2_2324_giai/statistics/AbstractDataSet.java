//package hus.oop.mid_term_2024.statistics;
//
//public abstract class AbstractDataSet implements DataSet {
//    /**
//     * Phương thức kiểm tra xem index có nằm trong đoạn [0 - limit] không.
//     * @param index
//     * @param limit
//     * @return
//     */
//    public boolean checkBoundaries(int index, int limit) {
//        /* TODO */
//        return false;
//    }
//
//    /**
//     * Mô tả tập dữ liệu.
//     * @return mô tả tập dữ liệu theo định dạng [a1, a2, a3, ..., an].
//     */
//    @Override
//    public String toString() {
//        /* TODO */
//        return "";
//    }
//}
package hus.oop.mid_term_2024.statistics;

public abstract class AbstractDataSet implements DataSet {
    public boolean checkBoundaries(int index, int limit) {
        return index >= 0 && index <= limit;
    }

    @Override
    public String toString() {
        double[] arr = toArray();
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
