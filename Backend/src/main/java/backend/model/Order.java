package backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @Column(name = "modified_at")
    private OffsetDateTime modifiedAt;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    public Order() {
        this.createdAt = OffsetDateTime.now();
        this.modifiedAt = OffsetDateTime.now();
    }

    public Order(OrderDTO orderDTO) {
        this.id = orderDTO.getId();
        this.total = orderDTO.getTotal();
        this.status = orderDTO.getStatus();
        this.orderItems = new ArrayList<>();
        if (orderDTO.getOrderItems() != null) {
            for (OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
                OrderItem orderItem = new OrderItem(orderItemDTO);
                orderItem.setOrder(this);
                this.orderItems.add(orderItem);
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(user, order.user) && Objects.equals(total, order.total) && status == order.status && Objects.equals(payment, order.payment) && Objects.equals(createdAt, order.createdAt) && Objects.equals(modifiedAt, order.modifiedAt) && Objects.equals(orderItems, order.orderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, total, status, payment, createdAt, modifiedAt, orderItems);
    }

    public enum OrderStatus {
        PENDING,
        PROCESSING,
        SHIPPED,
        DELIVERED,
        CANCELLED;
    }
}
