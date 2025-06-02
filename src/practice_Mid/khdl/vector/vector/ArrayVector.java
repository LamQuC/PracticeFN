package practice_Mid.khdl.vector.vector;

import java.util.Arrays;

public class ArrayVector implements IVector {
    private double[] data;
    private int length;

    public ArrayVector() {
         data = new double[1];
         length = 0;
    }

    public ArrayVector(double[] coefficients) {
        /* TODO */
        data = new double[coefficients.length];
        System.arraycopy(coefficients, 0, data, 0, coefficients.length);
        length = coefficients.length;
    }

    /*
    * Hàm tăng số phần tử của mảng lên gấp đôi.
    * Do mảng không thay đổi được số phần tử sau khi đã cấp phát, nên để tăng
    * số phần tử của mảng, cần phải cấp phát lại mảng khác có số phần tử gấp đôi,
    * sau đó copy những phần tử của mảng cũ sang mảng mới.
    */
    private void extend() {
        /* TODO */
        double[] newData = new double[length * 2];
        System.arraycopy(data, 0, newData, 0, length);
        data = newData;
    }

    /*
    * Hàm thêm một phần tử vào cuối vector.
    * Kiểm tra xem mảng còn chỗ để thêm phần tử mới không, nếu không còn chỗ
    * thì cần phải cấp phát một mảng lớn hơn.
    */
    @Override
    public void append(double value) {
        /* TODO */
        if (length == data.length) {
            extend();
        }
        data[length++] = value;
    }

    /*
     * Hàm thêm một phần tử vào vector ở vị trí index.
     * Kiểm tra xem mảng còn chỗ để thêm phần tử mới không, nếu không còn chỗ
     * thì cần phải cấp phát một mảng lớn hơn.
     */
    @Override
    public void insert(double value, int index) {
        /* TODO */
        if (index < 0 || index >= length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (length == data.length) {
            extend();
        }
        for (int i = length - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        length++;
    }

    /*
    * Hàm xóa một phần tử của vector ở vị trí index.
    */
    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        for (int i = index; i < length - 1; i++) {
            data[i] = data[i + 1];
        }
        length--;
    }

    @Override
    public int length() {
        /* TODO */
        return length;
    }

    @Override
    public double magnitude() {
        /* TODO */
        double sum = 0.0;
        for (int i = 0; i < length; i++) {
            sum += data[i] * data[i];
        }
        return Math.sqrt(sum);
    }

    public double distanceTo(ArrayVector another) {
        /* TODO */
        if (another == null || another.length != length) {
            return 0.0;
        }
        double sum = 0.0;
        for (int i = 0; i < length; i++) {
            sum += Math.pow(data[i] - another.data[i], 2);
        }
        return Math.sqrt(sum);
    }

    @Override
    public double[] elements() {
        /* TODO */
        return Arrays.copyOf(data, length);
    }

    @Override
    public double element(int index) {
        /* TODO */
        if (index < 0 || index >= length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return data[index];
    }

    public ArrayVector minus(ArrayVector another) {
        /* TODO */
        if (another == null || another.length != length) {
            return this;
        }
        ArrayVector result = new ArrayVector();
        for (int i = 0; i < length; i++) {
            result.append(element(i) - another.element(i));
        }
        return result;
    }

    public ArrayVector plus(ArrayVector another) {
        /* TODO */
        if (another == null || another.length != length) {
            return this;
        }
        ArrayVector result = new ArrayVector();
        for (int i = 0; i < length; i++) {
            result.append(element(i) + another.element(i));
        }
        return result;
    }

    public ArrayVector scale(double factor) {
        /* TODO */
        ArrayVector result = new ArrayVector();
        for (int i = 0; i < length; i++) {
            result.append(element(i) * factor);
        }
        return result;
    }

    public double dot(ArrayVector another) {
        /* TODO */
        if (another == null || another.length != length) {
            return 0.0;
        }
        double product = 0.0;
        for (int i = 0; i < length; i++) {
            product += element(i) * another.element(i);
        }
        return product;
    }

    /*
    * Hàm trả ra format của vector dạng: [a1, a2, ..., an].
    */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder result = new StringBuilder();
        result.append('[');
        for (int i = 0; i < length; i++) {
            if (i != length() - 1) {
                result.append(element(i)).append(", ");
            } else {
                result.append(element(i));
            }
        }
        result.append(']');
        return result.toString();
    }
}
