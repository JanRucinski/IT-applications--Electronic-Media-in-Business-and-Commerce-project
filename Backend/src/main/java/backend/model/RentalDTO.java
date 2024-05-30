package backend.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

public class RentalDTO {
    private Long id;
    private OffsetDateTime rentalStart;
    private OffsetDateTime rentalEnd;
    private BigDecimal total;
    private Rental.RentalStatus status;
    private Long itemId;
    private Long userId;
    private PaymentDTO payment;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    public RentalDTO() {
    }

    public RentalDTO(Rental rental) {
        this.id = rental.getId();
        this.rentalStart = rental.getRentalStart();
        this.rentalEnd = rental.getRentalEnd();
        this.total = rental.getTotal();
        this.status = rental.getStatus();
        this.itemId = rental.getItem().getId();
        this.userId = rental.getUser().getId();
        this.payment = new PaymentDTO(rental.getPayment());
        this.createdAt = rental.getCreatedAt();
        this.modifiedAt = rental.getModifiedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getRentalStart() {
        return rentalStart;
    }

    public void setRentalStart(OffsetDateTime rentalStart) {
        this.rentalStart = rentalStart;
    }

    public OffsetDateTime getRentalEnd() {
        return rentalEnd;
    }

    public void setRentalEnd(OffsetDateTime rentalEnd) {
        this.rentalEnd = rentalEnd;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Rental.RentalStatus getStatus() {
        return status;
    }

    public void setStatus(Rental.RentalStatus status) {
        this.status = status;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalDTO rentalDTO = (RentalDTO) o;
        return Objects.equals(id, rentalDTO.id) && Objects.equals(rentalStart, rentalDTO.rentalStart) && Objects.equals(rentalEnd, rentalDTO.rentalEnd) && Objects.equals(total, rentalDTO.total) && status == rentalDTO.status && Objects.equals(itemId, rentalDTO.itemId) && Objects.equals(userId, rentalDTO.userId) && Objects.equals(payment, rentalDTO.payment) && Objects.equals(createdAt, rentalDTO.createdAt) && Objects.equals(modifiedAt, rentalDTO.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentalStart, rentalEnd, total, status, itemId, userId, payment, createdAt, modifiedAt);
    }
}
