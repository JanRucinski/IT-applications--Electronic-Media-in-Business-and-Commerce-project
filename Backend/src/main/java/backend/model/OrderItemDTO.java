package backend.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

public class OrderItemDTO {
    private Long id;
    private Integer quantity;
    private BigDecimal prize;
    private Long orderId;
    private Long itemId;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    public OrderItemDTO() {
    }

    public OrderItemDTO(OrderItem orderItem) {
        this.id = orderItem.getId();
        this.quantity = orderItem.getQuantity();
        this.prize = orderItem.getPrize();
        this.orderId = orderItem.getOrder().getId();
        this.itemId = orderItem.getItem().getId();
        this.createdAt = orderItem.getCreatedAt();
        this.modifiedAt = orderItem.getModifiedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public void setPrize(BigDecimal prize) {
        this.prize = prize;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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
        OrderItemDTO that = (OrderItemDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(quantity, that.quantity) && Objects.equals(prize, that.prize) && Objects.equals(orderId, that.orderId) && Objects.equals(itemId, that.itemId) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, prize, orderId, itemId, createdAt, modifiedAt);
    }
}
