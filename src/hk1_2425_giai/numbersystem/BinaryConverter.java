package hk1_2425_giai.numbersystem;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
public class BinaryConverter extends AbstractNumberConverter {
    public BinaryConverter(MyNumber originalNumber) {
        /* TODO */
        super(originalNumber);
    }

    /*
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 2.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 2.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        /* TODO */
        BigInteger value = new BigInteger(decimal);
        StringBuilder result = new StringBuilder();
        if (value.equals(BigInteger.ZERO)) return "0";
        while (value.compareTo(BigInteger.ZERO) > 0) {
            result.insert(0, value.mod(BigInteger.valueOf(2)));
            value = value.divide(BigInteger.valueOf(2));
        }
        return result.toString();
    }

    /*
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal
     * số được chuyển đổi theo định dạng a1a2...an(2).
     */
    @Override
    public void update() {
        /* TODO */
        convert();
        display();
    }

    /*
     * Hiển thị số ra terminal theo định dạng a1a2...an(2).
     */
    @Override
    public void display() {
        System.out.println("Binary: " + convertedNumber + "(2)");
    }
}
