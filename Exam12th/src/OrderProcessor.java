import java.util.*;

public class OrderProcessor {
    LinkedList<Order> orders = new LinkedList<>();


    public void processOrder(Order order) {
        orders.add(order);
    }


    public double getTotalRevenue() {
        return orders.stream().mapToDouble(Order::calculateTotal).sum();
    }


    public double getAverageOrderValue() {
        return orders.isEmpty() ? 0 : getTotalRevenue() / orders.size();
    }


    public String getTopCustomer() {
        Map<String, Double> customerTotal = new HashMap<>();
        for (Order order : orders) {
            customerTotal.put(order.customerName, customerTotal.getOrDefault(order.customerName, 0.0) + order.calculateTotal());
        }

        return customerTotal.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No customers");
    }


    public void processOrdersFIFO() {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            System.out.println(order.orderId + " - Total: ruppees" + order.calculateTotal());
        }
    }
}