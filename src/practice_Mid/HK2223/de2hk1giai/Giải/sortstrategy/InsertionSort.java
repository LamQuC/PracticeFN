package practice_Mid.HK2223.de2hk1giai.Giải.sortstrategy;

public class InsertionSort implements ISort {
    @Override
    public int sort(int[] data) {
        /* TODO */
        int count = 0;
        for (int i = 1; i < data.length; i++) {
            int insertIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (data[j] > data[insertIndex]) {
                    data[j + 1] = data[j];
                    insertIndex = j;
                    count++;
                } else {
                    break;
                }
            }
            data[insertIndex] = data[i];
        }
        return count;
    }
}
