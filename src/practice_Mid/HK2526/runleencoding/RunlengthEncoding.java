package practice_Mid.HK2526.runleencoding;

import java.util.Collections;

public class RunlengthEncoding {
    public static void main(String[] args) {
        /*
        TODO:

        - Viết các hàm test mã hóa và giải mã theo mã hóa run-length và in ra theo mẫu:
        Ví dụ:
        Decoded Text: xxxxx
        Encoded Text: xxxxx

        và

        Encoded Text: xxxxx
        Decoded Text: xxxxx


         */
        testDecoding();
        testEncoding();
    }

    /*
     * Hàm mã hóa chuỗi ký tự text theo mã hóa run-length.
     */
    public static String encoding(String text) {
        /* TODO */
        StringBuilder result = new StringBuilder();
        int n = text.length();
        for (int i = 0; i < n; i++) {

            // Count occurrences of current character
            int count = 1;
            while (i < n - 1
                    && text.charAt(i) == text.charAt(i + 1)) {
                count++;
                i++;
            }
            String counting = String.valueOf(count);
            // Print character and its count
            result.append(counting+text.charAt(i));
        }
        return result.toString();
    }

    /*
     * Hàm giải mã chuỗi ký tự text theo mã hóa run-length.
     */
    public static String decoding(String text) {
        /* TODO */
        StringBuilder result = new StringBuilder();
        char[] chars = text.toCharArray();

        int count = 0;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                count = 10 * count + Character.getNumericValue(c);
            } else {
                result.append(String.join("", Collections.nCopies(count, String.valueOf(c))));
                count = 0;
            }
        }
        return result.toString();

    }

    /*
     * Hàm test mã hóa theo mã hóa run-length.
     */
    public static void testEncoding() {
        /* TODO */
        String testEndcoding = "aaaabbbbccccdddd";
        System.out.println(encoding(testEndcoding));
    }

    /*
     * Hàm test giải mã theo mã hóa run-length.
     */
    public static void testDecoding() {
        /* TODO */
        String testDecoding = "3a4b5c6d";
        System.out.println(decoding(testDecoding));
    }
}
