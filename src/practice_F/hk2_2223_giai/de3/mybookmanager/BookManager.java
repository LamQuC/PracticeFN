package practice_F.hk2_2223_giai.de3.mybookmanager;

public class BookManager {
    // Singleton pattern
    private static BookManager instance;

    private MyList bookList;

    private BookManager() {
        bookList = new MyLinkedList();
    }

    public static BookManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    public MyList getBookList() {
        /* TODO */
        return bookList;
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void append(Book book) {
        /* TODO */
        bookList.append(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void add(Book book, int index) {
        /* TODO */
        bookList.insert(book, index);
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        bookList.remove(index);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        /* TODO */
        return (Book) bookList.get(index);
    }

    /**
     * Sắp xếp danh sách book theo thứ tự số trang tăng dần.
     * @return
     */
    public MyList sortPagesIncreasing() {
        /* TODO */
        MyList result = copyList(bookList);
        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                Book book1 = (Book) result.get(i);
                Book book2 = (Book) result.get(j);
                if (book1.getPages() > book2.getPages()) {
                    Book temp = book1;
                    result.set(book2, i);
                    result.set(temp, j);
                }
            }
        }
        return result;
    }

    private MyList copyList(MyList list) {
        MyList result = new MyArrayList();
        MyIterator it = list.iterator();
        while (it.hasNext()) {
            result.append(it.next());
        }
        return result;
    }

    /**
     * Sắp xếp book theo thứ tự số trang giảm dần.
     * @return
     */
    public MyList sortPagesDecreasing() {
        /* TODO */
        MyList result = copyList(bookList);
        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                Book book1 = (Book) result.get(i);
                Book book2 = (Book) result.get(j);
                if (book1.getPages() < book2.getPages()) {
                    Book temp = book1;
                    result.set(book2, i);
                    result.set(temp, j);
                }
            }
        }
        return result;
    }

    /**
     * Sắp xếp sách theo thứ tự giá tăng dần.
     * @return
     */
    public MyList sortPriceIncreasing() {
        /* TODO */
        MyList result = copyList(bookList);
        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                Book book1 = (Book) result.get(i);
                Book book2 = (Book) result.get(j);
                if (book1.getPrice() > book2.getPrice()) {
                    Book temp = book1;
                    result.set(book2, i);
                    result.set(temp, j);
                }
            }
        }
        return result;
    }

    /**
     * Sắp xếp sách theo thứ tự giá giảm dần.
     * @return
     */
    public MyList sortPriceDecreasing() {
        /* TODO */
        MyList result = copyList(bookList);
        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                Book book1 = (Book) result.get(i);
                Book book2 = (Book) result.get(j);
                if (book1.getPrice() < book2.getPrice()) {
                    Book temp = book1;
                    result.set(book2, i);
                    result.set(temp, j);
                }
            }
        }
        return result;
    }

    /**
     * Lọc ra những sách theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public MyList filterBooksOfPublisher(String publisher) {
        /* TODO */
        MyList result = new MyLinkedList();
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            if (book.getPublisher().equals(publisher)) {
                result.append(book);
            }
        }
        return result;
    }

    /**
     * Lọc ra những sách theo thể loại.
     * @param genre
     * @return
     */
    public MyList filterBooksOfGenre(String genre) {
        /* TODO */
        MyList result = new MyLinkedList();
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            if (book.getGenre().equals(genre)) {
                result.append(book);
            }
        }
        return result;
    }

    /**
     * Lọc ra những sách theo tác giả.
     * @param author
     * @return
     */
    public MyList filterBooksOfAuthor(String author) {
        /* TODO */
        MyList result = new MyLinkedList();
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            if (book.getAuthor().equals(author)) {
                result.append(book);
            }
        }
        return result;
    }

    public static String titleOfBooksToString(MyList bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            titleOfBooks.append(book.getTitle()).append("\n");
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public static void print(MyList bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "\n]");
    }
}
