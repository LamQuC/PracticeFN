package practice_Mid.HK2425giai.de1hk1giai.statistics;

import java.util.Arrays;

public class BasicStatistic implements Statistic {
    private DataSet dataSet;

    /**
     * Hàm dựng khởi tạo tập dữ liệu.
     */
    public BasicStatistic() {
        /* TODO */
        this.dataSet = null;
    }

    public void setDataSet(DataSet dataSet) {
        /* TODO */
        this.dataSet = dataSet;
    }

    @Override
    public int size() {
        /* TODO */
        return dataSet.size();
    }

    @Override
    public double max() {
        /* TODO */
        double[] arr = dataSet.getAll(0,dataSet.size());
        double max = arr[0];
        for(double i : arr){
            if (max<i){
                max = i;
            }
        }
        return max;
    }

    @Override
    public double min() {
        double[] arr = dataSet.getAll(0,dataSet.size());
        double min = arr[0];
        for(double i : arr){
            if (min>i){
                min = i;
            }
        }
        return min;
        /* TODO */
    }

    @Override
    public double mean() {
        /* TODO */
        double[] arr = dataSet.getAll(0, dataSet.size());
        double mean = arr[0];
        for (double item : arr) {
            mean += item;
        }
        return mean / arr.length;
    }

    @Override
    public double variance() {
        /* TODO */
        double[] arr = dataSet.getAll(0, dataSet.size());
        double mean = mean();
        double variance = 0;
        for (double item : arr) {
            variance += (item - mean) * (item - mean);
        }
        return variance / arr.length;
    }

    @Override
    public double[] rank() {
        /* TODO */
        double[] arr = dataSet.getAll(0, dataSet.size());
        Arrays.sort(arr);
        AbstractDataSet dataSet1 = new ArrayDataSet();
        double temp = arr[0];
        dataSet1.append(temp);
        for (double item : arr) {
            if (temp < item) {
                temp = item;
                dataSet1.append(temp);
            }
        }
        return dataSet1.getAll(0, dataSet1.size());
    }

    @Override
    public double median() {
        /* TODO */
        double[] arr = dataSet.getAll(0, dataSet.size());
        Arrays.sort(arr);
        if (arr.length % 2 == 1) {
            return arr[arr.length / 2];
        }
        return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
    }
}
