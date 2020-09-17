public class BookCollection {

    public static void main(String[] args) {
        Book book1 = new Book("Jan Brzechwa", "Kaczka Dziwaczka");
        Book book2 = new Book("Adam Mickiewicz", "Pan Tadeusz");

        System.out.println(book1.getAuthor());
        System.out.println(book2.getAuthor());

        book1.setAuthor("Julian Tuwim");

        System.out.println(book1.getAuthor());
    }

}
