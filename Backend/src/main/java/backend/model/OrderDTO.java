package backend.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderDTO {
    private Long id;
    private Long userId;
    private BigDecimal total;
    private Order.OrderStatus status;
    private PaymentDTO payment;
    private List<OrderItemDTO> orderItems;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    public OrderDTO() {
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        if (order.getUser() != null) {
            this.userId = order.getUser().getId();
        }
        this.total = order.getTotal();
        this.status = order.getStatus();
        this.payment = new PaymentDTO(order.getPayment());
        this.orderItems = new ArrayList<>();
        for (OrderItem orderItem : order.getOrderItems()) {
            this.orderItems.add(new OrderItemDTO(orderItem));
        }
        this.createdAt = order.getCreatedAt();
        this.modifiedAt = order.getModifiedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Order.OrderStatus getStatus() {
        return status;
    }

    public void setStatus(Order.OrderStatus status) {
        this.status = status;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id) && Objects.equals(userId, orderDTO.userId) && Objects.equals(total, orderDTO.total) && status == orderDTO.status && Objects.equals(payment, orderDTO.payment) && Objects.equals(orderItems, orderDTO.orderItems) && Objects.equals(createdAt, orderDTO.createdAt) && Objects.equals(modifiedAt, orderDTO.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, total, status, payment, orderItems, createdAt, modifiedAt);
    }
}
