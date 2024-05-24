package backend.model;

import java.math.BigDecimal;
import java.util.Objects;

public class PaymentDTO {
    private Long id;
    private BigDecimal amount;
    private String provider;
    private Payment.PaymentStatus status;

    public PaymentDTO() {
    }

    public PaymentDTO(Payment payment) {
        this.id = payment.getId();
        this.amount = payment.getAmount();
        this.provider = payment.getProvider();
        this.status = payment.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Payment.PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(Payment.PaymentStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDTO that = (PaymentDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(amount, that.amount) && Objects.equals(provider, that.provider) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, provider, status);
    }
}
