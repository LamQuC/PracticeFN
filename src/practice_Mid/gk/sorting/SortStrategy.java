package practice_Mid.gk.sorting;

public class SortStrategy {
    private static SortStrategy instance;

    private ISort sortee;

    private SortStrategy() {

    }
    public static SortStrategy getInstance() {
        if (instance == null) {
            instance = new SortStrategy();
        }
        return instance;
    }

    public void setSortee(ISort sortee) {
        this.sortee = sortee;
    }
    public int sort(int[] data) {
        return sortee.sort(data);
    }
}
