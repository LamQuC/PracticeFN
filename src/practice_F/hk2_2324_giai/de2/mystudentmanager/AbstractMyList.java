package practice_F.hk2_2324_giai.de2.mystudentmanager;

public abstract class AbstractMyList implements MyList {
    /**
     * Phương thức kiểm tra xem index có nằm trong đoạn [0 - limit] không.
     * @param index
     * @param limit
     * @return
     */
    public boolean checkBoundaries(int index, int limit) {
        /* TODO */
        if (index < 0 || index >= limit) {
            return false;
        }
        return true;
    }
}
