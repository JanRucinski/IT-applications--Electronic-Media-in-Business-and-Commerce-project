package backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rental_start")
    private LocalDate rentalStart;
    @Column(name = "rental_end")
    private LocalDate rentalEnd;
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

    public Rental() {
    }

    public Rental(RentalDTO rentalDTO) {
        this.id = rentalDTO.getId();
        this.rentalStart = rentalDTO.getRentalStart();
        this.rentalEnd = rentalDTO.getRentalEnd();
        this.total = rentalDTO.getTotal();
        this.status = rentalDTO.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRentalStart() {
        return rentalStart;
    }

    public void setRentalStart(LocalDate rentalStart) {
        this.rentalStart = rentalStart;
    }

    public LocalDate getRentalEnd() {
        return rentalEnd;
    }

    public void setRentalEnd(LocalDate rentalEnd) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(id, rental.id) && Objects.equals(rentalStart, rental.rentalStart) && Objects.equals(rentalEnd, rental.rentalEnd) && Objects.equals(total, rental.total) && status == rental.status && Objects.equals(item, rental.item) && Objects.equals(user, rental.user) && Objects.equals(payment, rental.payment) && Objects.equals(createdAt, rental.createdAt) && Objects.equals(modifiedAt, rental.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentalStart, rentalEnd, total, status, item, user, payment, createdAt, modifiedAt);
    }

    public enum RentalStatus {
        REQUESTED,
        CANCELLED,
        IN_PROGRESS,
        COMPLETED
    }
}
