package backend.model;

import java.util.Objects;

public class CategoryDTO {
    private Long id;
    private String name;
    private Category.SuperCategory superCategory;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.superCategory = category.getSuperCategory();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDTO that = (CategoryDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && superCategory == that.superCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, superCategory);
    }
}
