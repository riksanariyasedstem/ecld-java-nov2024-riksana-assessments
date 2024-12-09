import java.time.LocalDateTime;
import java.util.List;

public class RegularOrder extends Order {
    double minimumForDiscount = 100;
    double discountPercent = 0.10;
    LocalDateTime orderDate;

    public RegularOrder(String orderId, String customerName, LocalDateTime orderDate, List<OrderItem> items) {
        super(orderId, customerName, orderDate, items);
    }

    @Override
    public double calculateTotal() {
        double total = items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
        return total - calculateDiscount();
    }

    @Override
    public double calculateDiscount() {
        double total = items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
        return (total >= minimumForDiscount) ? total * discountPercent : 0;
    }
}
