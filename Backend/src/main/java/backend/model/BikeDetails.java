package backend.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "bike_details")
public class BikeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "color")
    private String color;
    @OneToOne(mappedBy = "bikeDetails")
    private Item item;
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @Column(name = "modified_at")
    private OffsetDateTime modifiedAt;

    public BikeDetails() {
    }

    public BikeDetails(BikeDetailsDTO bikeDetailsDTO) {
        this.id = bikeDetailsDTO.getId();
        this.color = bikeDetailsDTO.getColor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
        BikeDetails that = (BikeDetails) o;
        return Objects.equals(id, that.id) && Objects.equals(color, that.color) && Objects.equals(item, that.item) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, item, createdAt, modifiedAt);
    }
}
