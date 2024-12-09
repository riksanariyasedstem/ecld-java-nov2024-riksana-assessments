import java.time.LocalDateTime;
import java.util.List;

public class PriorityOrder extends Order {
    boolean expressShipping;
    double additionalFee = 20.0;
    LocalDateTime orderDate;//check it..

    public PriorityOrder(String orderId, String customerName, LocalDateTime orderDate, List<OrderItem> items, boolean expressShipping) {
        super(orderId, customerName, orderDate, items);
        this.expressShipping = expressShipping;
    }

    @Override
    public double calculateTotal() {
        double total = items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
        if (expressShipping) {
            total += additionalFee;
        }
        return total;
    }

    @Override
    public double calculateDiscount() {
        return 0;  // No discount for priority orders
    }
}
