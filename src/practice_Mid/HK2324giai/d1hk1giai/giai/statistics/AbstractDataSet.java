package practice_Mid.HK2324giai.d1hk1giai.giai.statistics;

public abstract class AbstractDataSet implements DataSet {
    /**
     * Mô tả tập dữ liệu.
     * @return mô tả tập dữ liệu dạng [a1, a2, a3, ..., an].
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < getAll(0, size()).length; i++) {
            if (i ==getAll(0, size()).length - 1) {
                sb.append(getAt(i));
            } else {
                sb.append(getAt(i)).append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
