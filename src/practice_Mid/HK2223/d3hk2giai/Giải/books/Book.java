package practice_Mid.HK2223.d3hk2giai.Giải.books;

public class Book implements BookComparable {
    private String title;
    private int year;
    private int pages;

    public Book(String title, int year, int pages) {
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                '}';
    }

    @Override
    public int compareTo(Book another) {
        if (this.title.compareTo(another.title) > 0) {
            return 1;
        } else if (this.title.compareTo(another.title) < 0) {
            return -1;
        }
        return 0;
    }
}
