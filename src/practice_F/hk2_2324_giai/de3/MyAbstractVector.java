package hus.oop.vector;

public abstract class MyAbstractVector implements MyVector {
    /**
     * Mô tả vector theo định dạng [a1 a2 ... an]
     * @return
     */
    @Override
    public String toString() {
        double[] coords = coordinates();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < coords.length; i++) {
            sb.append(coords[i]);
            if (i < coords.length - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * So sánh hai vector có bằng nhau không.
     * Hai vector bằng nhau nếu có cùng kích thước và có các phần tử bằng nhau.
     * @param another
     * @return
     */
    @Override
    public boolean equals(MyVector another) {
        if (another == null) return false;
        if (this.size() != another.size()) return false;
        for (int i = 0; i < this.size(); i++) {
            if (this.coordinate(i) != another.coordinate(i)) {
                return false;
            }
        }
        return true;
    }
}

