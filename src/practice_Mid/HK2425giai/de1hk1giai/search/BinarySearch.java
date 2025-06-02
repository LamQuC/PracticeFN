package practice_Mid.HK2425giai.de1hk1giai.search;

import java.util.Arrays;

public class BinarySearch implements Search {
    private Sorter sorter;

    public BinarySearch() {
        /* TODO */

    }

    public void setSorter(Sorter sorter) {
        /* TODO */
        this.sorter =sorter;
    }

    /**
     * Tìm kiếm giá trị value trong mảng data.
     * @param data: mảng tập hợp các giá trị.
     * @param value: giá trị cần tìm kiếm.
     * @return
     */
    @Override
    public int search(double[] data, double value) {
        /* TODO */
       return binarySearch(data,value);
    }

    /**
     * Tìm kiếm giá trị value trong mảng data, sử dụng thuật toán tìm kiếm nhị phân.
     * @param data
     * @param value
     * @return
     */
    private int binarySearch(double[] data, double value) {
        /* TODO */
        sort(data);
        int index = Arrays.binarySearch(data,value);
        return index;
    }

    /**
     * Sắp xếp mảng dữ liệu data.
     * @param data
     */
    private void sort(double[] data) {
        /* TODO */
        for (int i = 0 ; i < data.length - 1; i ++){
            int minPosition = i;
            for (int j = i+1 ; j<data.length;j++){
                if (data[minPosition] >data[j]){
                    minPosition = j;
                }
            }
            if (minPosition !=i ){
                double temp = data[i];
                data[i] = data[minPosition];
                data[minPosition] = temp;
            }
        }
    }
}
