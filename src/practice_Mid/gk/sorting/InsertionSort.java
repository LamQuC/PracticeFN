package practice_Mid.gk.sorting;

public class InsertionSort implements ISort {
    public int sort(int[] data){
        int count = 0 ;
        int n = data.length;
        for (int i = 1; i < n; ++i) {
            int key = data[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && data[j] > key) {
               data[j + 1] = data[j];
                j = j - 1;
                count++;
            }
           data[j + 1] = key;

        }
        return count;
    }
}
