package backend.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "super_category")
    @Enumerated(EnumType.STRING)
    private SuperCategory superCategory;
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @Column(name = "modified_at")
    private OffsetDateTime modifiedAt;
    @OneToMany(mappedBy = "category")
    private List<Item> items;

    public Category() {
        this.createdAt = OffsetDateTime.now();
        this.modifiedAt = OffsetDateTime.now();
    }

    public Category(long id, String name, SuperCategory superCategory, OffsetDateTime createdAt, OffsetDateTime modifiedAt, List<Item> items) {
        this.id = id;
        this.name = name;
        this.superCategory = superCategory;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.items = items;
    }

    public Category(String name, SuperCategory superCategory) {
        this.name = name;
        this.superCategory = superCategory;
        this.createdAt = OffsetDateTime.now();
        this.modifiedAt = OffsetDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SuperCategory getSuperCategory() {
        return superCategory;
    }

    public void setSuperCategory(SuperCategory superCategory) {
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id && Objects.equals(name, category.name) && superCategory == category.superCategory && Objects.equals(createdAt, category.createdAt) && Objects.equals(modifiedAt, category.modifiedAt) && Objects.equals(items, category.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, superCategory, createdAt, modifiedAt, items);
    }

    public enum SuperCategory {
        BIKES,
        PARTS,
        RENT_ITEMS
    }
}
