package hk1_2324_giai.basicstatistics;

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
        Object max = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            if ((double) data.get(i) > (double) max) {
                max = data.get(i);
            }
        }
        return (double) max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        /* TODO */
        Object min = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            if ((double) data.get(i) < (double) min) {
                min = data.get(i);
            }
        }
        return (double) min;
    }

    /**
     * Tính kỳ vọng của mẫu lưu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        /* TODO */
        double sum = 0;
        for (int i = 0; i < data.size(); i++) {
            sum += (double) data.get(i);
        }
        return sum / data.size();
    }

    /**
     * Tính phương sai của mẫu lưu trong list.
     * @return phương sai.
     */
    public double variance() {
        /* TODO */
        double mean = mean();
        double sum = 0;
        for (int i = 0; i < data.size(); i++) {
            sum += Math.pow((double) data.get(i) - mean, 2);
        }
        return sum / data.size();
    }
}
