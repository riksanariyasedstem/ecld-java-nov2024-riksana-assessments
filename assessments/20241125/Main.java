import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EcommerceOrderManager orderManager = new EcommerceOrderManager();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println("Welcome to the Ecommerce Order Manager!");
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Order");
            System.out.println("2. Update Order Status");
            System.out.println("3. Get Orders by Customer");
            System.out.println("4. Get Orders by Date Range");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid option.");
                continue;
            }

            try {
                switch (choice) {
                    case 1: {
                        System.out.print("Enter Order ID: ");
                        Long orderId = Long.parseLong(scanner.nextLine());

                        System.out.print("Enter Customer ID: ");
                        Long customerId = Long.parseLong(scanner.nextLine());

                        System.out.print("Enter Order Time (yyyy-MM-dd HH:mm): ");
                        LocalDateTime orderTime = LocalDateTime.parse(scanner.nextLine(), formatter);

                        System.out.print("Enter Order Status (PENDING, SHIPPED, DELIVERED, CANCELED): ");
                        OrderStatus status = OrderStatus.valueOf(scanner.nextLine().toUpperCase());

                        Order order = new Order(orderId, customerId, orderTime, status);
                        orderManager.addOrder(order);
                        System.out.println("Order added successfully!");
                        break;
                    }
                    case 2: {
                        System.out.print("Enter Order ID: ");
                        Long orderId = Long.parseLong(scanner.nextLine());

                        System.out.print("Enter New Status (PENDING, SHIPPED, DELIVERED, CANCELED): ");
                        OrderStatus newStatus = OrderStatus.valueOf(scanner.nextLine().toUpperCase());

                        orderManager.updateOrderStatus(orderId, newStatus);
                        System.out.println("Order status updated successfully!");
                        break;
                    }
                    case 3: {
                        System.out.print("Enter Customer ID: ");
                        Long customerId = Long.parseLong(scanner.nextLine());

                        List<Order> customerOrders = orderManager.getOrdersByCustomer(customerId);
                        System.out.println("Orders for customer " + customerId + ":");
                        if (customerOrders.isEmpty()) {
                            System.out.println("No orders found.");
                        } else {
                            customerOrders.forEach(order ->
                                    System.out.println("Order ID: " + order.getOrderId() + ", Status: " + order.getStatus()));
                        }
                        break;
                    }
                    case 4: {
                        System.out.print("Enter Start Date (yyyy-MM-dd HH:mm): ");
                        LocalDateTime start = LocalDateTime.parse(scanner.nextLine(), formatter);

                        System.out.print("Enter End Date (yyyy-MM-dd HH:mm): ");
                        LocalDateTime end = LocalDateTime.parse(scanner.nextLine(), formatter);

                        Iterator<Order> dateRangeOrders = orderManager.getOrdersByDateRange(start, end);
                        System.out.println("Orders in date range:");
                        boolean found = false;
                        while (dateRangeOrders.hasNext()) {
                            Order order = dateRangeOrders.next();
                            System.out.println("Order ID: " + order.getOrderId() + ", Date: " + order.getOrderTime() + ", Status: " + order.getStatus());
                            found = true;
                        }
                        if (!found) {
                            System.out.println("No orders found in the given date range.");
                        }
                        break;
                    }
                    case 5: {
                        System.out.println("Exiting... Thank you!");
                        scanner.close();
                        return;
                    }
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again with valid inputs.");
            }
        }
    }
}
