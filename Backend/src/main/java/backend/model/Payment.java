package backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "provider")
    private String provider;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @Column(name = "modified_at")
    private OffsetDateTime modifiedAt;
    @OneToOne(mappedBy = "payment")
    private Order order;
    @OneToOne(mappedBy = "payment")
    private Rental rental;

    public Payment() {
        this.createdAt = OffsetDateTime.now();
        this.modifiedAt = OffsetDateTime.now();
    }

    public Payment(long id, BigDecimal amount, String provider, PaymentStatus status, OffsetDateTime createdAt, OffsetDateTime modifiedAt, Order order, Rental rental) {
        this.id = id;
        this.amount = amount;
        this.provider = provider;
        this.status = status;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.order = order;
        this.rental = rental;
    }

    public Payment(BigDecimal amount, String provider) {
        this.amount = amount;
        this.provider = provider;
        this.status = PaymentStatus.PENDING;
        this.createdAt = OffsetDateTime.now();
        this.modifiedAt = OffsetDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id && Objects.equals(amount, payment.amount) && Objects.equals(provider, payment.provider) && Objects.equals(status, payment.status) && Objects.equals(createdAt, payment.createdAt) && Objects.equals(modifiedAt, payment.modifiedAt) && Objects.equals(order, payment.order) && Objects.equals(rental, payment.rental);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, provider, status, createdAt, modifiedAt, order, rental);
    }

    public enum PaymentStatus {
        PENDING,
        COMPLETED,
        FAILED,
        CANCELLED,
        REFUNDED
    }
}
