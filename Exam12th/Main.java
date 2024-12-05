import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();


        Book book1 = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        Book book2 = new Book("B002", "1984", "George Orwell", "9780451524935");
        Magazine magazine1 = new Magazine("M001", "National Geographic", LocalDate.of(2023, 10, 1), "National Geographic Society");


        library.addItem(book1);
        library.addItem(book2);
        library.addItem(magazine1);


        System.out.println("Borrowing 'The Great Gatsby': " + library.borrowItem("B001"));


        System.out.println("Trying to borrow 'The Great Gatsby' again: " + library.borrowItem("B001"));


        System.out.println("Returning 'The Great Gatsby': " + library.returnItem("B001"));


        System.out.println("\nOverdue items (3 days late):");
        library.getOverdueItems(3).forEach(System.out::println);
    }
}
