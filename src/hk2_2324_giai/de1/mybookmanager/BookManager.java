package hk2_2324_giai.de1.mybookmanager;

public class BookManager {
    private static BookManager instance;
    private MyList bookList;

    private BookManager() {
        bookList = new MyLinkedList();
    }

    public static BookManager getInstance() {
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    public MyList getBookList() {
        return bookList;
    }

    /**
     * Thêm book vào đầu danh sách.
     * @param book
     */
    public void insertAtStart(Book book) {
        bookList.insertAtStart(book);
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void insertAtEnd(Book book) {
        bookList.insertAtEnd(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void insertAPosition(Book book, int index) {
        bookList.insertAtPosition(book, index);
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        bookList.remove(index);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        MyIterator iterator = bookList.iterator();
        for (int i = 0; i < index && iterator.hasNext(); i++) {
            iterator.next();
        }
        Object result = iterator.next();
        return result instanceof Book ? (Book) result : null;
    }

    /**
     * Lấy ra sách có giá cao nhất.
     * @return
     */
    public Book highestPriceBook() {
        MyIterator iterator = bookList.iterator();
        Book highest = null;
        double maxPrice = Double.MIN_VALUE;

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (book.getPrice() > maxPrice) {
                maxPrice = book.getPrice();
                highest = book;
            }
        }
        return highest;
    }

    /**
     * Lấy ra sách có giá thấp nhất.
     * @return
     */
    public Book lowestPriceBook() {
        MyIterator iterator = bookList.iterator();
        Book lowest = null;
        double minPrice = Double.MAX_VALUE;

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (book.getPrice() < minPrice) {
                minPrice = book.getPrice();
                lowest = book;
            }
        }
        return lowest;
    }

    /**
     * Lấy ra sách có số trang cao nhất.
     * @return
     */
    public Book highestNumberOfPagesBook() {
        MyIterator iterator = bookList.iterator();
        Book highest = null;
        int maxPages = Integer.MIN_VALUE;

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (book.getPages() > maxPages) {
                maxPages = book.getPages();
                highest = book;
            }
        }
        return highest;
    }

    /**
     * Lấy ra sách có số trang thấp nhất.
     * @return
     */
    public Book lowestNumberOfPagesBook() {
        MyIterator iterator = bookList.iterator();
        Book lowest = null;
        int minPages = Integer.MAX_VALUE;

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (book.getPages() < minPages) {
                minPages = book.getPages();
                lowest = book;
            }
        }
        return lowest;
    }

    /**
     * Lọc ra những book theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public MyList filterBooksOfPublisher(String publisher) {
        MyList result = new MyLinkedList();
        MyIterator iterator = bookList.iterator();

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                result.insertAtEnd(book);
            }
        }
        return result;
    }

    /**
     * Lọc ra những book theo thể loại.
     * @param genre
     * @return
     */
    public MyList filterBooksOfGenre(String genre) {
        MyList result = new MyLinkedList();
        MyIterator iterator = bookList.iterator();

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (book.getGenre().equalsIgnoreCase(genre)) {
                result.insertAtEnd(book);
            }
        }
        return result;
    }

    /**
     * Lọc ra những book theo tác giả.
     * @param author
     * @return
     */
    public MyList filterBooksOfAuthor(String author) {
        MyList result = new MyLinkedList();
        MyIterator iterator = bookList.iterator();

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.insertAtEnd(book);
            }
        }
        return result;
    }
}