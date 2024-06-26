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
    @Column(name = "material")
    private String material;
    @Column(name = "part_type")
    private String partType;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;
    @OneToOne(mappedBy = "partDetails")
    private Item item;

    public PartDetails() {
    }

    public PartDetails(PartDetailsDTO partDetailsDTO) {
        this.id = partDetailsDTO.getId();
        this.material = partDetailsDTO.getMaterial();
        this.partType = partDetailsDTO.getPartType();
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartDetails that = (PartDetails) o;
        return Objects.equals(id, that.id) && Objects.equals(material, that.material) && Objects.equals(partType, that.partType) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, material, partType, createdAt, modifiedAt);
    }
}
