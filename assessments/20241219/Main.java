import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EcommerceOrderManager orderManager = new EcommerceOrderManager();


        Order order1 = new Order(1L, 100L, LocalDateTime.now(), OrderStatus.PENDING);
        Order order2 = new Order(2L, 100L, LocalDateTime.now().minusDays(1), OrderStatus.SHIPPED);
        Order order3 = new Order(3L, 200L, LocalDateTime.now().minusDays(2), OrderStatus.PENDING);
        orderManager.addOrder(order1);
        orderManager.addOrder(order2);
        orderManager.addOrder(order3);


        orderManager.updateOrderStatus(1L, OrderStatus.SHIPPED);


        List<Order> customerOrders = orderManager.getOrdersByCustomer(100L);
        System.out.println("Orders for customer 100:");
        customerOrders.forEach(order -> System.out.println("Order ID: " + order.getOrderId() + ", Status: " + order.getStatus()));

        
        Iterator<Order> dateRangeOrders = orderManager.getOrdersByDateRange(LocalDateTime.now().minusDays(2), LocalDateTime.now());
        System.out.println("Orders in date range (last 2 days):");
        while (dateRangeOrders.hasNext()) {
            Order order = dateRangeOrders.next();
            System.out.println("Order ID: " + order.getOrderId() + ", Date: " + order.getOrderTime() + ", Status: " + order.getStatus());
        }
    }
}
