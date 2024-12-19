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
        if (isRecentOrder(order)) {
            recentOrders.add(order);
        } else {
            historicalOrders.add(order);
        }


        orderIdIndex.put(order.getOrderId(), order);


        customerOrderIndex.computeIfAbsent(order.getCustomerId(), k -> new ArrayList<>()).add(order);
    }

    private boolean isRecentOrder(Order order) {

        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
        LocalDateTime orderTime = order.getOrderTime();
        return orderTime.isAfter(now.minus(RECENT_ORDER_THRESHOLD_MILLIS, ChronoUnit.MILLIS));

    }

    @Override
    public void updateOrderStatus(Long orderId, OrderStatus newStatus) {

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
    }

    @Override
    public List<Order> getOrdersByCustomer(Long customerId) {

        return customerOrderIndex.getOrDefault(customerId, Collections.emptyList());
    }

    @Override
    public Iterator<Order> getOrdersByDateRange(LocalDateTime start, LocalDateTime end) {
        return new FilteredIterator<>(iterator(), order -> {
            LocalDateTime orderTime = order.getOrderTime();
            return orderTime.isAfter(start) && orderTime.isBefore(end);
        });
    }

    @Override

    public Iterator<Order> iterator() {
        return new Iterator<Order>() {
            private final Iterator<Order> recentIterator = recentOrders.iterator();
            private final Iterator<Order> historicalIterator = historicalOrders.iterator();

            @Override
            public boolean hasNext() {
                return recentIterator.hasNext() || historicalIterator.hasNext();
            }

            @Override
            public Order next() {
                if (recentIterator.hasNext()) {
                    return recentIterator.next();
                } else {
                    return historicalIterator.next();
                }
            }
        };
    }


    private class StatusIterator implements Iterator<Order> {
        private final Iterator<Order> iterator;
        private final OrderStatus status;

        public StatusIterator(Iterator<Order> iterator, OrderStatus status) {
            this.iterator = iterator;
            this.status = status;
        }
//        public static <T> Iterator<T> concat(Iterator<? extends T> a,
//                                             Iterator<? extends T> b)
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Order next() {
            Order order = iterator.next();
            while (order.getStatus() != status && iterator.hasNext()) {
                order = iterator.next();
            }
            return order;
        }
    }


    private class CustomerIterator implements Iterator<Order> {
        private final Iterator<Order> iterator;
        private final Long customerId;

        public CustomerIterator(Iterator<Order> iterator, Long customerId) {
            this.iterator = iterator;
            this.customerId = customerId;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Order next() {
            Order order = iterator.next();
            while (!order.getCustomerId().equals(customerId) && iterator.hasNext()) {
                order = iterator.next();
            }
            return order;
        }
    }

    public Iterator<Order> getOrdersByCustomerIterator(Long customerId) {
        return new CustomerIterator(iterator(), customerId);
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
            while (sourceIterator.hasNext()) {
                if (filter.test(sourceIterator.next())) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Order next() {
            while (sourceIterator.hasNext()) {
                Order order = sourceIterator.next();
                if (filter.test(order)) {
                    return order;
                }
            }
            return null;
        }
    }


    private interface OrderFilter {
        boolean test(Order order);
    }
}

