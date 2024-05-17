package backend.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "rental_start")
    private OffsetDateTime rentalStart;
    @Column(name = "rental_end")
    private OffsetDateTime rentalEnd;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RentalStatus status;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @Column(name = "modified_at")
    private OffsetDateTime modifiedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public enum RentalStatus {
        REQUESTED,
        CANCELLED,
        IN_PROGRESS,
        COMPLETED
    }

    public Rental() {
    }

    public Rental(long id, OffsetDateTime rentalStart, OffsetDateTime rentalEnd, BigDecimal total, RentalStatus status, Item item, User user, Payment payment, OffsetDateTime createdAt, OffsetDateTime modifiedAt) {
        this.id = id;
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
        this.total = total;
        this.status = status;
        this.item = item;
        this.user = user;
        this.payment = payment;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Rental(OffsetDateTime rentalStart, OffsetDateTime rentalEnd, BigDecimal total, Item item, User user) {
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
        this.total = total;
        this.item = item;
        this.user = user;
        this.status = RentalStatus.REQUESTED;
        this.createdAt = OffsetDateTime.now();
        this.modifiedAt = OffsetDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return id == rental.id && Objects.equals(rentalStart, rental.rentalStart) && Objects.equals(rentalEnd, rental.rentalEnd) && Objects.equals(total, rental.total) && Objects.equals(status, rental.status) && Objects.equals(item, rental.item) && Objects.equals(user, rental.user) && Objects.equals(payment, rental.payment) && Objects.equals(createdAt, rental.createdAt) && Objects.equals(modifiedAt, rental.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentalStart, rentalEnd, total, status, item, user, payment, createdAt, modifiedAt);
    }
}
