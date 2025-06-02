package practice_Mid.HK2425giai.de1hk1giai.datastructure;

public abstract class AbstractMyList implements MyList {
    /**
     * Kiểm tra xem index có nằm trong đoạn [0 - limit] không.
     * @param index
     * @param limit
     * @return
     */
    public boolean checkBoundaries(int index, int limit) {
        /* TODO */
        if (index >= 0 && index <= limit){
            return true;
        }
        return false;
    }

    /**
     * Mô tả tập dữ liệu.
     * @return mô tả tập dữ liệu theo định dạng [a1, a2, a3, ..., an].
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size(); i++) {
            if (i == size() - 1) {
                sb.append(get(i));
            } else {
                sb.append(get(i)).append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
