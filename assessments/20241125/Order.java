import java.time.LocalDateTime;

enum OrderStatus {
    PENDING,
    SHIPPED,
    DELIVERED,
    CANCELED
}


public  class Order {
    private Long orderId;
    private Long customerId;
    private LocalDateTime orderTime;
    private OrderStatus status;

    public Order(Long orderId, Long customerId, LocalDateTime orderTime, OrderStatus status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderTime = orderTime;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
