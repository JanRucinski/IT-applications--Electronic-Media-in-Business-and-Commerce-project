package backend.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "part_details")
public class PartDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "color")
    private String color;
    @OneToOne(mappedBy = "partDetails")
    private Item item;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    public PartDetails() {
    }

    public PartDetails(PartDetailsDTO partDetailsDTO) {
        this.id = partDetailsDTO.getId();
        this.color = partDetailsDTO.getColor();
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
        PartDetails that = (PartDetails) o;
        return Objects.equals(id, that.id) && Objects.equals(color, that.color) && Objects.equals(item, that.item) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, item, createdAt, modifiedAt);
    }
}
