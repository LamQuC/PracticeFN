package practice_Mid.HK2223.de2hk1giai.Giải.sortstrategy;

public class BubbleSort implements ISort {
    @Override
    public int sort(int[] data) {
        /* TODO */
        int count = 0;
        boolean changed;
        for (int i = 0; i < data.length - 1; i++) {
            changed = true;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    changed = false;
                    count++;
                }
            }
            if (changed) {
                break;
            }
        }
        return count;
    }
}
