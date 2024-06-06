package backend.model;

import java.time.OffsetDateTime;
import java.util.Objects;


public class PartDetailsDTO {
    private Long id;
    private String material;
    private String partType;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    public PartDetailsDTO() {
    }

    public PartDetailsDTO(PartDetails partDetails) {
        this.id = partDetails.getId();
        this.material = partDetails.getMaterial();
        this.partType = partDetails.getPartType();
        this.createdAt = partDetails.getCreatedAt();
        this.modifiedAt = partDetails.getModifiedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
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
        return Objects.equals(id, that.id) && Objects.equals(material, that.material) && Objects.equals(partType, that.partType) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, material, partType, createdAt, modifiedAt);
    }
}
