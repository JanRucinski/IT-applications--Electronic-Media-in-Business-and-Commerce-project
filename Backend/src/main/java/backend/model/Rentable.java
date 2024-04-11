package backend.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rentables")
public class Rentable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "desc")
    private String desc;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "price_period")
    private String pricePeriod;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @Column(name = "modified_at")
    private OffsetDateTime modifiedAt;
    @OneToMany(mappedBy = "rentable")
    private List<Rental> rentals;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPricePeriod() {
        return pricePeriod;
    }

    public void setPricePeriod(String pricePeriod) {
        this.pricePeriod = pricePeriod;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public Rentable() {
    }

    public Rentable(long id, String name, String desc, BigDecimal price, String pricePeriod, Category category, OffsetDateTime createdAt, OffsetDateTime modifiedAt, List<Rental> rentals) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.pricePeriod = pricePeriod;
        this.category = category;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.rentals = rentals;
    }

    public Rentable(String name, String desc, BigDecimal price, String pricePeriod, Category category) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.pricePeriod = pricePeriod;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rentable rentable = (Rentable) o;
        return id == rentable.id && Objects.equals(name, rentable.name) && Objects.equals(desc, rentable.desc) && Objects.equals(price, rentable.price) && Objects.equals(pricePeriod, rentable.pricePeriod) && Objects.equals(category, rentable.category) && Objects.equals(createdAt, rentable.createdAt) && Objects.equals(modifiedAt, rentable.modifiedAt) && Objects.equals(rentals, rentable.rentals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, price, pricePeriod, category, createdAt, modifiedAt, rentals);
    }
}

