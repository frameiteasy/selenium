public class Labrary {
    public static void main(String[] args) {

        BookCollection books =new BookCollection();
        Book book1 = new Book("Jan Brzechwa", "Kaczka Dziwaczka");
        Book book2 = new Book("Adam Mickiewicz", "Pan Tadeusz");

        books.getBooks().add(book1);
        books.getBooks().add(book2);

        System.out.println("Books amount: " + books.getBooks().size());

        for(Book bookItem : books.getBooks() ){
            System.out.println("Author: " + bookItem.getAuthor() + " Title: " + bookItem.getTitle());
        }

    }
}
