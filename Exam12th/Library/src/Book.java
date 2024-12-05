public class Book extends LibraryItem {
    String author;
    String isbn;
    double lateFeePerDay = 2.0;

    public Book(String id, String title, String author, String isbn) {
        super(id, title);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * lateFeePerDay;
    }
}
