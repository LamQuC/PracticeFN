package practice_Mid.gk.sorting;

public class SelectionSort implements ISort {
    @Override
    public int sort(int[] data) {
            /* TODO */
        int count = 0;
        for (int i = 0 ; i < data.length - 1; i ++){
            int minPosition = i;
            for (int j = i+1 ; j<data.length;j++){
                if (data[minPosition] >data[j]){
                    minPosition = j;
                }
            }
            if (minPosition !=i ){
                int temp = data[i];
                data[i] = data[minPosition];
                data[minPosition] = temp;
                count++;
            }
        }
        return count;
    }

}
