import java.time.LocalDate;

public class Magazine extends LibraryItem {
    LocalDate issueDate;
    String publisher;
    double lateFeePerDay = 1.0;

    public Magazine(String id, String title, LocalDate issueDate, String publisher) {
        super(id, title);
        this.issueDate = issueDate;
        this.publisher = publisher;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * lateFeePerDay;
    }
}
