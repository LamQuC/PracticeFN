package hk1_2425_giai.basicstatistics;

public class BasicStatistic {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public BasicStatistic(MyList data) {
        /* TODO */
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     * @return giá trị lớn nhất.
     */
    public double max() {
        /* TODO */
        MyIterator it = data.iterator();
        double max = it.next().doubleValue();
        while (it.hasNext()) {
            double val = it.next().doubleValue();
            if (val > max) max = val;
        }
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        /* TODO */
        MyIterator it = data.iterator();
        double min = it.next().doubleValue();
        while (it.hasNext()) {
            double val = it.next().doubleValue();
            if (val < min) min = val;
        }
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu lưu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        /* TODO */
        MyIterator it = data.iterator();
        double sum = 0;
        int count = 0;
        while (it.hasNext()) {
            sum += it.next().doubleValue();
            count++;
        }
        return sum / count;
    }

    /**
     * Tính phương sai của mẫu lưu trong list.
     * @return phương sai.
     */
    public double variance() {
        /* TODO */
        double mean = mean();
        MyIterator it = data.iterator();
        double sumSq = 0;
        int count = 0;
        while (it.hasNext()) {
            double x = it.next().doubleValue();
            sumSq += (x - mean) * (x - mean);
            count++;
        }
        return sumSq / count;
    }
}
