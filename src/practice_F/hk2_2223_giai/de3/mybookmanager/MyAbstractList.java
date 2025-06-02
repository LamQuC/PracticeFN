package practice_F.hk2_2223_giai.de3.mybookmanager;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1] [a2] [a3] ... [an]
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder result = new StringBuilder();
        int length = size();
        result.append("[");
        for (int i = 0; i < length; i++) {
            result.append(get(i));
            if (i < length - 1) {
                result.append("] [");
            }
        }
        result.append("]");
        return result.toString();
    }
}
