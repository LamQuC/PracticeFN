package practice_Mid.HK2324giai.de1hk2giai.giai.bookmanager;

import java.util.Comparator;

public interface MyBookComparator extends Comparator<Book> {
    int compare(Book left, Book right);
}
