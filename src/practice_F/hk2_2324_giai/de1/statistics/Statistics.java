package practice_F.hk2_2324_giai.de1.statistics;

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
        if (data.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        double max = Double.NEGATIVE_INFINITY;
        MyIterator iterator = data.iterator(0);
        while (iterator.hasNext()) {
            double value = iterator.next().doubleValue();
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        if (data.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        double min = Double.POSITIVE_INFINITY;
        MyIterator iterator = data.iterator(0);
        while (iterator.hasNext()) {
            double value = iterator.next().doubleValue();
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu theo dữ liệu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        if (data.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        double sum = 0;
        MyIterator iterator = data.iterator(0);
        while (iterator.hasNext()) {
            sum += iterator.next().doubleValue();
        }
        return sum / data.size();
    }

    /**
     * Tính phương sai của mẫu theo dữ liệu trong list.
     * @return phương sai.
     */
    public double variance() {
        if (data.size() <= 1) {
            throw new IllegalStateException("List size must be greater than 1 for variance");
        }
        double mean = mean();
        double sumSquaredDiff = 0;
        MyIterator iterator = data.iterator(0);
        while (iterator.hasNext()) {
            double value = iterator.next().doubleValue();
            sumSquaredDiff += Math.pow(value - mean, 2);
        }
        return sumSquaredDiff / (data.size() - 1);
    }

    /**
     * Tìm kiếm trong list có phẩn tử nào có giá trị bằng data không, sử dụng binarySearch trong list.
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
        MyList sorted = data.sortIncreasing();
        double[] ranks = new double[data.size()];
        MyIterator original = data.iterator(0);
        int i = 0;
        while (original.hasNext()) {
            double value = original.next().doubleValue();
            MyIterator sortedIter = sorted.iterator(0);
            int rank = 1;
            while (sortedIter.hasNext()) {
                double sortedValue = sortedIter.next().doubleValue();
                if (sortedValue < value) {
                    rank++;
                } else if (sortedValue == value) {
                    break;
                }
            }
            ranks[i++] = rank;
        }
        return ranks;
    }
}