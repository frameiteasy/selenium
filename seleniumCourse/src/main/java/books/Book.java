package books;

public class Book {

    public static int numberOfBooks = 0;
    private String author;
    private String title;

    public Book(String authorName, String bookTitle) {
        this.author = authorName;
        this.title = bookTitle;
        numberOfBooks = numberOfBooks + 1;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String authorName) {
        this.author = authorName;
    }

}
