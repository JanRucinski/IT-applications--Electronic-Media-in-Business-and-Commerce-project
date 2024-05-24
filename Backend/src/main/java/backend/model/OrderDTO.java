package backend.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderDTO {
    private Long id;
    private Long userId;
    private BigDecimal total;
    private Long paymentId;
    private List<OrderItemDTO> orderItems;

    public OrderDTO() {
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.userId = order.getUser().getId();
        this.total = order.getTotal();
        this.paymentId = order.getPayment().getId();
        this.orderItems = new ArrayList<>();
        for (OrderItem orderItem : order.getOrderItems() ) {
           this.orderItems.add(new OrderItemDTO(orderItem));
        }
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

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id) && Objects.equals(userId, orderDTO.userId) && Objects.equals(total, orderDTO.total) && Objects.equals(paymentId, orderDTO.paymentId) && Objects.equals(orderItems, orderDTO.orderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, total, paymentId, orderItems);
    }
}