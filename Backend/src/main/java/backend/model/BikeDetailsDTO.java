package backend.model;

import java.time.OffsetDateTime;
import java.util.Objects;

public class BikeDetailsDTO {
    private Long id;
    private String brand;
    private String model;
    private Double weight;
    private String wheelSize;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    public BikeDetailsDTO() {
    }

    public BikeDetailsDTO(BikeDetails bikeDetails) {
        this.id = bikeDetails.getId();
        this.brand = bikeDetails.getBrand();
        this.model = bikeDetails.getModel();
        this.weight = bikeDetails.getWeight();
        this.wheelSize = bikeDetails.getWheelSize();
        this.createdAt = bikeDetails.getCreatedAt();
        this.modifiedAt = bikeDetails.getModifiedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(String wheelSize) {
        this.wheelSize = wheelSize;
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
        return Objects.equals(id, that.id) && Objects.equals(brand, that.brand) && Objects.equals(model, that.model) && Objects.equals(weight, that.weight) && Objects.equals(wheelSize, that.wheelSize) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, weight, wheelSize, createdAt, modifiedAt);
    }
}
