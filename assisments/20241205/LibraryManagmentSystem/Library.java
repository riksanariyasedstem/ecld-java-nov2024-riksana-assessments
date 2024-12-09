import java.util.ArrayList;
import java.util.List;


public class Library {
    List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public LibraryItem searchById(String id) {
        for (LibraryItem item : items) {
            if (item.id.equals(id)) {
                return item;
            }
        }
        return null;
    }

    public boolean borrowItem(String id) {
        LibraryItem item = searchById(id);
        if (item != null && item.available) {
            item.available = false;
            return true;
        }
        return false;
    }

    public boolean returnItem(String id) {
        LibraryItem item = searchById(id);
        if (item != null && !item.available) {
            item.available = true;
            return true;
        }
        return false;
    }

    public List<String> getOverdueItems(int daysOverdue) {
        List<String> overdueItems = new ArrayList<>();
        for (LibraryItem item : items) {
            if (!item.available) {
                overdueItems.add(item.title + " - Late Fee: $" + item.calculateLateFee(daysOverdue));
            }
        }
        return overdueItems;
    }
}
