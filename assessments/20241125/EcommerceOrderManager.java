import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

interface OrderProcessor {
    void addOrder(Order order);
    void updateOrderStatus(Long orderId, OrderStatus newStatus);
    List<Order> getOrdersByCustomer(Long customerId);
    Iterator<Order> getOrdersByDateRange(LocalDateTime start, LocalDateTime end);
    Iterator<Order> iterator();
}

public class EcommerceOrderManager implements OrderProcessor {
    private final List<Order> recentOrders = new ArrayList<>();
    private final List<Order> historicalOrders = new LinkedList<>();
    private static final long RECENT_ORDER_THRESHOLD_MILLIS = 24 * 60 * 60 * 1000;

    private final Map<Long, Order> orderIdIndex = new HashMap<>();
    private final Map<Long, List<Order>> customerOrderIndex = new HashMap<>();

    @Override
    public void addOrder(Order order) {
        try {
            if (isRecentOrder(order)) {
                recentOrders.add(order);
            } else {
                historicalOrders.add(order);
            }

            orderIdIndex.put(order.getOrderId(), order);
            customerOrderIndex.computeIfAbsent(order.getCustomerId(), k -> new ArrayList<>()).add(order);
        } catch (Exception e) {
            System.err.println("Error adding order: " + e.getMessage());
        }
    }

    private boolean isRecentOrder(Order order) {
        try {
            LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
            LocalDateTime orderTime = order.getOrderTime();
            return orderTime.isAfter(now.minus(RECENT_ORDER_THRESHOLD_MILLIS, ChronoUnit.MILLIS));
        } catch (Exception e) {
            System.err.println("Error determining if order is recent: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void updateOrderStatus(Long orderId, OrderStatus newStatus) {
        try {
            Order order = orderIdIndex.get(orderId);
            if (order != null) {
                order.setStatus(newStatus);
                return;
            }

            for (Order o : recentOrders) {
                if (o.getOrderId().equals(orderId)) {
                    o.setStatus(newStatus);
                    return;
                }
            }

            for (Order o : historicalOrders) {
                if (o.getOrderId().equals(orderId)) {
                    o.setStatus(newStatus);
                    return;
                }
            }

            throw new NoSuchElementException("Order with ID " + orderId + " not found.");
        } catch (Exception e) {
            System.err.println("Error updating order status: " + e.getMessage());
        }
    }

    @Override
    public List<Order> getOrdersByCustomer(Long customerId) {
        try {
            return customerOrderIndex.getOrDefault(customerId, Collections.emptyList());
        } catch (Exception e) {
            System.err.println("Error retrieving orders for customer: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public Iterator<Order> getOrdersByDateRange(LocalDateTime start, LocalDateTime end) {
        try {
            return new FilteredIterator<>(iterator(), order -> {
                LocalDateTime orderTime = order.getOrderTime();
                return orderTime.isAfter(start) && orderTime.isBefore(end);
            });
        } catch (Exception e) {
            System.err.println("Error filtering orders by date range: " + e.getMessage());
            return Collections.emptyIterator();
        }
    }

    @Override
    public Iterator<Order> iterator() {
        return new Iterator<Order>() {
            private final Iterator<Order> recentIterator = recentOrders.iterator();
            private final Iterator<Order> historicalIterator = historicalOrders.iterator();

            @Override
            public boolean hasNext() {
                try {
                    return recentIterator.hasNext() || historicalIterator.hasNext();
                } catch (Exception e) {
                    System.err.println("Error checking next element in iterator: " + e.getMessage());
                    return false;
                }
            }

            @Override
            public Order next() {
                try {
                    if (recentIterator.hasNext()) {
                        return recentIterator.next();
                    } else {
                        return historicalIterator.next();
                    }
                } catch (Exception e) {
                    System.err.println("Error retrieving next element in iterator: " + e.getMessage());
                    return null;
                }
            }
        };
    }

    private class FilteredIterator<T> implements Iterator<Order> {
        private final Iterator<Order> sourceIterator;
        private final OrderFilter filter;

        public FilteredIterator(Iterator<Order> sourceIterator, OrderFilter filter) {
            this.sourceIterator = sourceIterator;
            this.filter = filter;
        }

        @Override
        public boolean hasNext() {
            try {
                while (sourceIterator.hasNext()) {
                    if (filter.test(sourceIterator.next())) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                System.err.println("Error checking next element in filtered iterator: " + e.getMessage());
                return false;
            }
        }

        @Override
        public Order next() {
            try {
                while (sourceIterator.hasNext()) {
                    Order order = sourceIterator.next();
                    if (filter.test(order)) {
                        return order;
                    }
                }
                throw new NoSuchElementException("No more elements matching the filter.");
            } catch (Exception e) {
                System.err.println("Error retrieving next element in filtered iterator: " + e.getMessage());
                return null;
            }
        }
    }

    private interface OrderFilter {
        boolean test(Order order);
    }
}
