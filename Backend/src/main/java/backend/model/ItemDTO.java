package backend.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

public class ItemDTO {
    private Long id;
    private String name;
    private String desc;
    private Integer quantity;
    private BigDecimal price;
    private String imageUrl;
    private Long categoryId;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    public ItemDTO() {
    }

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.desc = item.getDesc();
        this.quantity = item.getQuantity();
        this.price = item.getPrice();
        this.imageUrl = item.getImageUrl();
        this.categoryId = item.getCategory().getId();
        this.createdAt = item.getCreatedAt();
        this.modifiedAt = item.getModifiedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
        ItemDTO itemDTO = (ItemDTO) o;
        return Objects.equals(id, itemDTO.id) && Objects.equals(name, itemDTO.name) && Objects.equals(desc, itemDTO.desc) && Objects.equals(quantity, itemDTO.quantity) && Objects.equals(price, itemDTO.price) && Objects.equals(imageUrl, itemDTO.imageUrl) && Objects.equals(categoryId, itemDTO.categoryId) && Objects.equals(createdAt, itemDTO.createdAt) && Objects.equals(modifiedAt, itemDTO.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, quantity, price, imageUrl, categoryId, createdAt, modifiedAt);
    }
}
