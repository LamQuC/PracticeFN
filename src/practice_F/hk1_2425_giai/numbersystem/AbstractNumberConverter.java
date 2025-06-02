package practice_F.hk1_2425_giai.numbersystem;

import java.math.BigInteger;

public abstract class AbstractNumberConverter implements NumberConverter {
    protected MyNumber originalNumber;  // Số gốc
    protected String convertedNumber;   // Số được chuyển đổi theo cơ số nào đó từ số gốc

    public AbstractNumberConverter(MyNumber originalNumber) {
        /* TODO */
        this.originalNumber = originalNumber;
    }

    /*
     * Chuyển đổi số decimal từ hệ cơ số 10 thành số có hệ cơ số nào đó.
     * @param decimal
     * @return xâu ký tự biểu diễn một số trong hệ cơ số nào đó.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     *
     * Gợi ý: có thể sử dụng lớp trung gian BigInteger để thuận lợi hơn cho việc tính toán.
     */
    public abstract String decimalTo(String decimal);

    /*
     * Chuyển đổi số được biểu diễn trong originalNumber sang biểu diễn số trong hệ cơ số 10.
     * @return xâu ký tự biểu diễn một số trong hệ cơ số 10.
     *
     * Yêu cầu: sử dụng thuật toán Horner để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    public String toDecimal() {
        /* TODO */
        String num = originalNumber.getNumberPresentation().toUpperCase();
        int radix = originalNumber.getRadix();
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int digit = "0123456789ABCDEF".indexOf(c);
            result = result.multiply(BigInteger.valueOf(radix)).add(BigInteger.valueOf(digit));
        }
        return result.toString();
    }

    /**
     * Thực hiện chuyển đổi số từ biểu diễn số và hệ cơ số ban đầu trong originalNumber
     * sang số có hệ cơ số nào đó. Kết quả số được chuyển đổi được lưu trong biến 
     * thành viên convertedNumber.
     */
    public void convert() {
        /* TODO */
        String decimal = toDecimal();
        convertedNumber = decimalTo(decimal);
    }
}
