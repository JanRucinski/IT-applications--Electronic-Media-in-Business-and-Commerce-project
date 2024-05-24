package backend.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemDTO {
    private Long id;
    private String name;
    private String desc;
    private Integer quantity;
    private BigDecimal price;
    private Long categoryId;

    public ItemDTO() {
    }

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.desc = item.getDesc();
        this.quantity = item.getQuantity();
        this.price = item.getPrice();
        this.categoryId = item.getCategory().getId();
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return Objects.equals(id, itemDTO.id) && Objects.equals(name, itemDTO.name) && Objects.equals(desc, itemDTO.desc) && Objects.equals(quantity, itemDTO.quantity) && Objects.equals(price, itemDTO.price) && Objects.equals(categoryId, itemDTO.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, quantity, price, categoryId);
    }
}
