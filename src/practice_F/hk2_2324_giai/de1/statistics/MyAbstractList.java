package practice_F.hk2_2324_giai.de1.statistics;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1 a2 a3 ... an]
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        MyIterator iterator = iterator(0);
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}