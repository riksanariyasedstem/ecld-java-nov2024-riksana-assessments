
import java.time.LocalDateTime;
import java.util.Arrays;

        public class Main {
            public static void main(String[] args) {

                OrderItem item1 = new OrderItem("P001", 2, 25.0);
                OrderItem item2 = new OrderItem("P002", 1, 50.0);
                OrderItem item3 = new OrderItem("P003", 3, 15.0);


                RegularOrder regularOrder = new RegularOrder("R001", "John Doe", LocalDateTime.now(), Arrays.asList(item1, item2));
                PriorityOrder priorityOrder = new PriorityOrder("P001", "Jane Doe", LocalDateTime.now(), Arrays.asList(item3), true);


                OrderProcessor orderProcessor = new OrderProcessor();


                orderProcessor.processOrder(regularOrder);
                orderProcessor.processOrder(priorityOrder);


                System.out.println("Total Revenue: " + orderProcessor.getTotalRevenue());


                System.out.println("Average Order Value: " + orderProcessor.getAverageOrderValue());


                System.out.println("Top Customer: " + orderProcessor.getTopCustomer());


                System.out.println("\nProcessing orders in :");
                orderProcessor.processOrdersFIFO();


    }
}