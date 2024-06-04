package backend.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "part_details")
public class PartDetailsDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "color")
    private String color;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    public PartDetailsDTO() {
    }
    public PartDetailsDTO(PartDetails partDetails) {
        this.id = partDetails.getId();
        this.color = partDetails.getColor();
        this.createdAt = partDetails.getCreatedAt();
        this.modifiedAt = partDetails.getModifiedAt();
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
        PartDetailsDTO that = (PartDetailsDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(color, that.color) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, createdAt, modifiedAt);
    }
}
