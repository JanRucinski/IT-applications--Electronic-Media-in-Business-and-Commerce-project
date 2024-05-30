package backend.model;

import jakarta.persistence.Column;

import java.time.OffsetDateTime;
import java.util.Objects;

public class CategoryDTO {
    private Long id;
    private String name;
    private Category.SuperCategory superCategory;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.superCategory = category.getSuperCategory();
        this.createdAt = category.getCreatedAt();
        this.modifiedAt = category.getModifiedAt();
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

    public Category.SuperCategory getSuperCategory() {
        return superCategory;
    }

    public void setSuperCategory(Category.SuperCategory superCategory) {
        this.superCategory = superCategory;
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
        CategoryDTO that = (CategoryDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && superCategory == that.superCategory && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, superCategory, createdAt, modifiedAt);
    }
}
