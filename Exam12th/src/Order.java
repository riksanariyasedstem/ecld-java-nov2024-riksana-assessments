import java.time.LocalDateTime;
import java.util.List;

public abstract class Order {
    String orderId;
    String customerName;
    LocalDateTime orderDate;
    List<OrderItem> items;

    public Order(String orderId, String customerName, LocalDateTime orderDate, List<OrderItem> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.items = items;
    }


    public abstract double calculateTotal();
    public abstract double calculateDiscount();
}



