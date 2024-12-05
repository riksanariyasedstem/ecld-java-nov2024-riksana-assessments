public abstract class LibraryItem {
    String id;
    String title;
    boolean available = true;

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public abstract double calculateLateFee(int daysLate);
}


