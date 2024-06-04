package backend.model;

import java.time.OffsetDateTime;
import java.util.Objects;

public class BikeDetailsDTO {
    private Long id;
    private String color;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    public BikeDetailsDTO() {
    }
    public BikeDetailsDTO(BikeDetails bikeDetails) {
        this.id = bikeDetails.getId();
        this.color = bikeDetails.getColor();
        this.createdAt = bikeDetails.getCreatedAt();
        this.modifiedAt = bikeDetails.getModifiedAt();
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
        BikeDetailsDTO that = (BikeDetailsDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(color, that.color) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, createdAt, modifiedAt);
    }
}
