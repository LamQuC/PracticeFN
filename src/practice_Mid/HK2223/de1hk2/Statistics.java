package hus.oop.statistics;

import java.util.Arrays;

public class Statistics {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public Statistics(MyList data) {
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     * @return giá trị lớn nhất.
     */
    public double max() {
        int n = data.size();
        if (n == 0) {
            throw new IllegalStateException("Dữ liệu rỗng");
        }
        MyIterator it = data.iterator(0);
        double max = it.next().doubleValue();
        while (it.hasNext()) {
            double v = it.next().doubleValue();
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        int n = data.size();
        if (n == 0) {
            throw new IllegalStateException("Dữ liệu rỗng");
        }
        MyIterator it = data.iterator(0);
        double min = it.next().doubleValue();
        while (it.hasNext()) {
            double v = it.next().doubleValue();
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu theo dữ liệu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        int n = data.size();
        if (n == 0) {
            throw new IllegalStateException("Dữ liệu rỗng");
        }
        double sum = 0.0;
        MyIterator it = data.iterator(0);
        while (it.hasNext()) {
            sum += it.next().doubleValue();
        }
        return sum / n;
    }

    /**
     * Tính phương sai của mẫu theo dữ liệu trong list.
     * @return phương sai.
     */
    public double variance() {
        int n = data.size();
        if (n < 2) {
            return 0.0;
        }
        double mu = mean();
        double sumSq = 0.0;
        MyIterator it = data.iterator(0);
        while (it.hasNext()) {
            double v = it.next().doubleValue();
            sumSq += (v - mu) * (v - mu);
        }
        // Phương sai mẫu: chia cho (n - 1)
        return sumSq / (n - 1);
    }

    /**
     * Tìm kiếm trong list có phần tử nào có giá trị bằng data không, sử dụng binarySearch trong list.
     * Trả về index một phần tử có giá trị bằng data, nếu không tìm thấy thì trả về -1.
     * @return
     */
    public int search(double data) {
        return this.data.binarySearch(data);
    }

    /**
     * Tính rank của các phần tử trong list.
     * @return rank của các phần tử trong list
     */
    public double[] rank() {
        int n = data.size();
        if (n == 0) {
            return new double[0];
        }
        double[] original = new double[n];
        int idx = 0;
        MyIterator it = data.iterator(0);
        while (it.hasNext()) {
            original[idx++] = it.next().doubleValue();
        }
        double[] sorted = Arrays.copyOf(original, n);
        Arrays.sort(sorted);
        double[] ranks = new double[n];
        // Nếu có giá trị trùng, rank = vị trí trung bình của các chỉ số trong mảng đã sắp
        for (int i = 0; i < n; i++) {
            double val = original[i];
            // tìm first và last index trong sorted[]
            int first = -1, last = -1;
            for (int j = 0; j < n; j++) {
                if (sorted[j] == val) {
                    if (first < 0) {
                        first = j;
                    }
                    last = j;
                }
            }
            // vị trí trong sorted mảng là [first..last], rank trung bình = (first + last)/2 + 1
            double r = ((first + last) / 2.0) + 1.0;
            ranks[i] = r;
        }
        return ranks;
    }
}
