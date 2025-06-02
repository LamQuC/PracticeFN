package practice_F.hk2_2324_giai.de1.mybookmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        init();

        try {
            FileWriter writer = new FileWriter("NguyenVanA_123456_MyBookManager.txt");

            writer.write("Testing Original Data:\n");
            testOriginalData(writer);

            writer.write("\nTesting Filter Books by Author:\n");
            testFilterBooksOfAuthor(writer);

            writer.write("\nTesting Filter Books by Publisher:\n");
            testFilterBooksOfPublisher(writer);

            writer.write("\nTesting Filter Books by Genre:\n");
            testFilterBooksOfGenre(writer);

            writer.write("\nTesting Highest Price Book:\n");
            testGetHighestPriceBook(writer);

            writer.write("\nTesting Lowest Price Book:\n");
            testGetLowestPriceBook(writer);

            writer.write("\nTesting Highest Number of Pages Book:\n");
            testGetHighestNumberOfPagesBook(writer);

            writer.write("\nTesting Lowest Number of Pages Book:\n");
            testGetLowestNumberOfPagesBook(writer);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init() {
        String filePath = "data/books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));
            BookManager manager = BookManager.getInstance();

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("title")) {
                    continue;
                }

                Book newBook = new Book.BookBuilder(dataList.get(0))
                        .withAuthor(dataList.get(1))
                        .withGenre(dataList.get(2))
                        .withPages(Integer.parseInt(dataList.get(3)))
                        .withPrice(Double.parseDouble(dataList.get(4)))
                        .withPublisher(dataList.get(5))
                        .build();

                manager.insertAtEnd(newBook);
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
                result.add(splitData[i].trim());
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

    public static void testOriginalData(FileWriter writer) throws IOException {
        BookManager manager = BookManager.getInstance();
        MyIterator iterator = manager.getBookList().iterator();
        writer.write("All Books:\n");
        while (iterator.hasNext()) {
            writer.write(iterator.next().toString() + "\n");
        }
    }

    /**
     * Test lọc ra những book theo tác giả.
     */
    public static void testFilterBooksOfAuthor(FileWriter writer) throws IOException {
        BookManager manager = BookManager.getInstance();
        MyList filteredBooks = manager.filterBooksOfAuthor("Author1"); // Replace with actual author from data
        MyIterator iterator = filteredBooks.iterator();
        writer.write("Books by Author1:\n");
        while (iterator.hasNext()) {
            writer.write(iterator.next().toString() + "\n");
        }
    }

    /**
     * Test lọc ra những book theo nhà xuất bản.
     */
    public static void testFilterBooksOfPublisher(FileWriter writer) throws IOException {
        BookManager manager = BookManager.getInstance();
        MyList filteredBooks = manager.filterBooksOfPublisher("Publisher1"); // Replace with actual publisher from data
        MyIterator iterator = filteredBooks.iterator();
        writer.write("Books by Publisher1:\n");
        while (iterator.hasNext()) {
            writer.write(iterator.next().toString() + "\n");
        }
    }

    /**
     * Test lọc ra những book theo thể loại.
     */
    public static void testFilterBooksOfGenre(FileWriter writer) throws IOException {
        BookManager manager = BookManager.getInstance();
        MyList filteredBooks = manager.filterBooksOfGenre("Fiction"); // Replace with actual genre from data
        MyIterator iterator = filteredBooks.iterator();
        writer.write("Books in Fiction genre:\n");
        while (iterator.hasNext()) {
            writer.write(iterator.next().toString() + "\n");
        }
    }

    /**
     * Test lấy ra sách có giá cao nhất.
     */
    public static void testGetHighestPriceBook(FileWriter writer) throws IOException {
        BookManager manager = BookManager.getInstance();
        Book book = manager.highestPriceBook();
        writer.write("Highest Price Book: " + (book != null ? book.toString() : "No books") + "\n");
    }

    /**
     * Test lấy ra sách có giá thấp nhất.
     */
    public static void testGetLowestPriceBook(FileWriter writer) throws IOException {
        BookManager manager = BookManager.getInstance();
        Book book = manager.lowestPriceBook();
        writer.write("Lowest Price Book: " + (book != null ? book.toString() : "No books") + "\n");
    }

    /**
     * Test lấy ra sách có số trang cao nhất.
     */
    public static void testGetHighestNumberOfPagesBook(FileWriter writer) throws IOException {
        BookManager manager = BookManager.getInstance();
        Book book = manager.highestNumberOfPagesBook();
        writer.write("Highest Number of Pages Book: " + (book != null ? book.toString() : "No books") + "\n");
    }

    /**
     * Test lấy ra sách có số trang thấp nhất.
     */
    public static void testGetLowestNumberOfPagesBook(FileWriter writer) throws IOException {
        BookManager manager = BookManager.getInstance();
        Book book = manager.lowestNumberOfPagesBook();
        writer.write("Lowest Number of Pages Book: " + (book != null ? book.toString() : "No books") + "\n");
    }
}