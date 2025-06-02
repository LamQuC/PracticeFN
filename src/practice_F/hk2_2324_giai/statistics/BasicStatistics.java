//package hus.oop.mid_term_2024.statistics;
//
//public class BasicStatistics implements Statistics {
//    private DataSet dataSet;
//
//    /**
//     * Hàm dựng khởi tạo tập dữ liệu.
//     */
//    public BasicStatistics() {
//        /* TODO */
//    }
//
//    public void setDataSet(DataSet dataSet) {
//        /* TODO */
//    }
//
//    @Override
//    public int size() {
//        /* TODO */
//        return 1;
//    }
//
//    @Override
//    public double max() {
//        /* TODO */
//        return 1;
//    }
//
//    @Override
//    public double min() {
//        /* TODO */
//        return 1;
//    }
//
//    @Override
//    public double mean() {
//        /* TODO */
//        return 1;
//    }
//
//    @Override
//    public double variance() {
//        /* TODO */
//        return 1;
//    }
//
//    @Override
//    public AbstractDataSet rank() {
//        /* TODO */
//        return null;
//    }
//
//    @Override
//    public double median() {
//        /* TODO */
//        return 1;
//    }
//}
package hus.oop.mid_term_2024.statistics;

import java.util.Arrays;

public class BasicStatistics implements Statistics {
    private DataSet dataSet;

    public BasicStatistics() {
        this.dataSet = null;
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public int size() {
        return dataSet.size();
    }

    @Override
    public double max() {
        double m = dataSet.get(0);
        for (int i = 1; i < dataSet.size(); i++) m = Math.max(m, dataSet.get(i));
        return m;
    }

    @Override
    public double min() {
        double m = dataSet.get(0);
        for (int i = 1; i < dataSet.size(); i++) m = Math.min(m, dataSet.get(i));
        return m;
    }

    @Override
    public double mean() {
        double sum = 0;
        for (int i = 0; i < dataSet.size(); i++) sum += dataSet.get(i);
        return sum / dataSet.size();
    }

    @Override
    public double variance() {
        double mu = mean();
        double sum = 0;
        for (int i = 0; i < dataSet.size(); i++) {
            double d = dataSet.get(i) - mu;
            sum += d * d;
        }
        return sum / (dataSet.size() - 1);
    }

    @Override
    public AbstractDataSet rank() {
        double[] arr = dataSet.toArray();
        double[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        ArrayDataSet r = new ArrayDataSet();
        for (double v : sorted) r.append(v);
        return r;
    }

    @Override
    public double median() {
        ArrayDataSet r = (ArrayDataSet) rank();
        int n = r.size();
        if (n % 2 == 1) return r.get(n / 2);
        return (r.get(n / 2 - 1) + r.get(n / 2)) / 2.0;
    }
}
