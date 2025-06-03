package hus.oop.fraction;

public class MyArrayDataSet implements MyDataSet {
    private static int DEFAULT_CAPACITY = 16;
    private MyFraction[] fractions;
    private int length;

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số có kích thước là DEFAULT_CAPACITY.
     */
    public MyArrayDataSet() {
        this.fractions = new MyFraction[DEFAULT_CAPACITY];
        this.length = 0;
    }

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số truyền vào.
     * @param fractions
     */
    public MyArrayDataSet(MyFraction[] fractions) {
        // Tạo mảng đủ chứa dữ liệu
        this.fractions = new MyFraction[Math.max(DEFAULT_CAPACITY, fractions.length)];
        // Copy từng phần tử
        for (int i = 0; i < fractions.length; i++) {
            // Tạo bản sao để không thay đổi mảng gốc
            this.fractions[i] = new MyFraction(fractions[i]);
        }
        this.length = fractions.length;
    }

    /**
     * Phương thức chèn phân số fraction vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không chèn được vào.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction là một phân số.
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    @Override
    public boolean insert(MyFraction fraction, int index) {
        if (!checkBoundaries(index, length)) {
            return false;
        }
        // Nếu đầy, mở rộng mảng
        if (length == fractions.length) {
            allocateMore();
        }
        // Dịch chuyển từ cuối xuống index
        for (int i = length - 1; i >= index; i--) {
            fractions[i + 1] = fractions[i];
        }
        // Chèn vào
        fractions[index] = new MyFraction(fraction);
        length++;
        return true;
    }

    /**
     * Phương thức thêm phân số fraction vào vị trí cuối cùng chưa có dứ liệu của mảng data.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    @Override
    public boolean append(MyFraction fraction) {
        if (length == fractions.length) {
            allocateMore();
        }
        fractions[length++] = new MyFraction(fraction);
        return true;
    }

    @Override
    public MyArrayDataSet toSimplify() {
        // Tạo mảng mới chứa phiên bản tối giản
        MyFraction[] simplified = new MyFraction[length];
        for (int i = 0; i < length; i++) {
            MyFraction tmp = new MyFraction(fractions[i]);
            tmp.simplify();
            simplified[i] = tmp;
        }
        return new MyArrayDataSet(simplified);
    }

    @Override
    public MyArrayDataSet sortIncreasing() {
        // Sao chép mảng hiện tại
        MyFraction[] copyArr = new MyFraction[length];
        for (int i = 0; i < length; i++) {
            copyArr[i] = new MyFraction(fractions[i]);
        }
        // Thực hiện sorting (chọn thuật toán đơn giản: bubble sort) theo tăng dần (compareTo đã xử lý cả khi bằng giá trị thì so mẫu số)
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (copyArr[j].compareTo(copyArr[j + 1]) > 0) {
                    MyFraction tmp = copyArr[j];
                    copyArr[j] = copyArr[j + 1];
                    copyArr[j + 1] = tmp;
                }
            }
        }
        return new MyArrayDataSet(copyArr);
    }

    @Override
    public MyArrayDataSet sortDecreasing() {
        // Sao chép mảng hiện tại
        MyFraction[] copyArr = new MyFraction[length];
        for (int i = 0; i < length; i++) {
            copyArr[i] = new MyFraction(fractions[i]);
        }
        // Thực hiện sorting giảm dần: đảo ngược compareTo, và khi bằng giá trị, compare mẫu số giảm dần
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                // Nếu j < j+1 trong compareTo thì ta nên đổi để thành giảm dần
                if (copyArr[j].compareTo(copyArr[j + 1]) < 0) {
                    MyFraction tmp = copyArr[j];
                    copyArr[j] = copyArr[j + 1];
                    copyArr[j + 1] = tmp;
                }
            }
        }
        return new MyArrayDataSet(copyArr);
    }

    @Override
    public String myDataSetToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < length; i++) {
            sb.append(fractions[i].toString());
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void print() {
        System.out.println(myDataSetToString());
    }

    /**
     * Phương thức mở rộng kích thước mảng gấp đôi, bằng cách tạo ra mảng mới có kích thước
     * gấp đôi, sau đó copy dữ liệu từ mảng cũ vào.
     */
    private void allocateMore() {
        int newCapacity = fractions.length * 2;
        MyFraction[] newArr = new MyFraction[newCapacity];
        for (int i = 0; i < length; i++) {
            newArr[i] = fractions[i];
        }
        fractions = newArr;
    }

    /**
     * Phương thức kiểm tra xem index có nằm trong khoảng [0, upperBound] hay không.
     * @param index
     * @param upperBound
     * @return true nếu index nằm trong khoảng [0, upperBound], false nếu ngược lại.
     */
    private boolean checkBoundaries(int index, int upperBound) {
        return index >= 0 && index <= upperBound;
    }
}

