package practice_F.hk2_2223_giai.de3.mybookmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        testOriginalData();

        /*
        TODO

        Viết code để test cho tất cả các hàm bên dưới.
        Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
        là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
        nộp lên classroom.
         */
        System.out.println();
        testSortPagesOfBookIncreasing();
        System.out.println();
        testSortPagesOfBookDecreasing();
        System.out.println();
        testPriceOfBooksIncreasing();
        System.out.println();
        testPriceOfBooksDecreasing();
        System.out.println();
        testFilterBooksOfAuthor();
        System.out.println();
        testFilterBooksOfPublisher();
        System.out.println();
        testFilterBooksOfGenre();
    }

    public static void init() {
        String filePath = "E:\\Code\\JAVAWORK\\OOP\\ThiCuoiKy\\src\\hk2_2223_giai\\de3\\mybookmanager\\books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("title")) {
                    continue;
                }

                /*
                TODO

                Đọc được dữ liệu, tạo ra các đối tượng Book ở đây, và cho vào BookManager để quản lý.
                */
                Book book = new Book.BookBuilder(dataList.get(0))
                        .withAuthor(dataList.get(1))
                        .withGenre(dataList.get(2))
                        .withPages(Integer.parseInt(dataList.get(3)))
                        .withPrice(Double.parseDouble(dataList.get(4)))
                        .withPublisher(dataList.get(5))
                        .build();
                BookManager.getInstance().append(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }

        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void testOriginalData() {
        init();
        String studentIds = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().getBookList());
        System.out.print(studentIds);
    }

    public static void testSortPagesOfBookIncreasing() {
        /* TODO */
        System.out.println("testSortPagesOfBookIncreasing:");
        MyList sortedList = BookManager.getInstance().sortPagesIncreasing();
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(((Book) sortedList.get(i)));
        }
    }

    public static void testSortPagesOfBookDecreasing() {
        /* TODO */
        System.out.println("testSortPagesOfBookDecreasing:");
        MyList sortedList = BookManager.getInstance().sortPagesDecreasing();
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(((Book) sortedList.get(i)));
        }
    }

    public static void testPriceOfBooksIncreasing() {
        /* TODO */
        System.out.println("testPriceOfBooksIncreasing:");
        MyList sortedList = BookManager.getInstance().sortPriceIncreasing();
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(((Book) sortedList.get(i)));
        }
    }

    public static void testPriceOfBooksDecreasing() {
        /* TODO */
        System.out.println("testPriceOfBooksDecreasing:");
        MyList sortedList = BookManager.getInstance().sortPriceDecreasing();
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(((Book) sortedList.get(i)));
        }
    }

    public static void testFilterBooksOfAuthor() {
        /* TODO */
        System.out.println("testFilterBooksOfAuthor:");
        MyList filteredList = BookManager.getInstance().filterBooksOfAuthor("Goswami Jaideva");
        for (int i = 0; i < filteredList.size(); i++) {
            System.out.println(((Book) filteredList.get(i)));
        }
    }

    public static void testFilterBooksOfPublisher() {
        /* TODO */
        System.out.println("testFilterBooksOfPublisher:");
        MyList filteredList = BookManager.getInstance().filterBooksOfPublisher("Wiley");
        for (int i = 0; i < filteredList.size(); i++) {
            System.out.println(((Book) filteredList.get(i)));
        }
    }

    public static void testFilterBooksOfGenre() {
        /* TODO */
        System.out.println("testFilterBooksOfGenre:");
        MyList filteredList = BookManager.getInstance().filterBooksOfGenre("signal_processing");
        for (int i = 0; i < filteredList.size(); i++) {
            System.out.println(((Book) filteredList.get(i)));
        }
    }
}
