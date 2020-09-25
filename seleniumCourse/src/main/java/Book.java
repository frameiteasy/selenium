public class Book {

    private String author;
    private String title;

    public Book(String authorName, String bookTitle) {
        this.author = authorName;
        this.title = bookTitle;
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
