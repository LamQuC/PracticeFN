package practice_F.lab12.mylist;

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
     *
     * @return giá trị lớn nhất.
     */
    public double max() {
        /* TODO */
        if (data.size() == 0) throw new IllegalStateException("List is empty");
        double max = Double.NEGATIVE_INFINITY;
        MyIterator iterator = data.iterator();
        while (iterator.hasNext()) {
            double value = ((Number) iterator.next()).doubleValue();
            if (value > max) max = value;
        }
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     *
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        /* TODO */
        if (data.size() == 0) throw new IllegalStateException("List is empty");
        double min = Double.POSITIVE_INFINITY;
        MyIterator iterator = data.iterator();
        while (iterator.hasNext()) {
            double value = ((Number) iterator.next()).doubleValue();
            if (value < min) min = value;
        }
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu lưu trong list.
     *
     * @return kỳ vọng.
     */
    public double mean() {
        /* TODO */
        if (data.size() == 0) throw new IllegalStateException("List is empty");
        double sum = 0;
        int count = 0;
        MyIterator iterator = data.iterator();
        while (iterator.hasNext()) {
            sum += ((Number) iterator.next()).doubleValue();
            count++;
        }
        return sum / count;
    }

    /**
     * Tính phương sai của mẫu lưu trong list.
     *
     * @return phương sai.
     */
    public double variance() {
        /* TODO */
        if (data.size() == 0) throw new IllegalStateException("List is empty");
        double mean = mean();
        double sumSquaredDiff = 0;
        int count = 0;
        MyIterator iterator = data.iterator();
        while (iterator.hasNext()) {
            double value = ((Number) iterator.next()).doubleValue();
            sumSquaredDiff += (value - mean) * (value - mean);
            count++;
        }
        return sumSquaredDiff / count;

    }
}
