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
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @Column(name = "modified_at")
    private OffsetDateTime modifiedAt;
    @OneToMany(mappedBy = "category")
    private List<Item> items;
    @OneToMany(mappedBy = "category")
    private List<Rentable> rentables;

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

    public List<Rentable> getRentables() {
        return rentables;
    }

    public void setRentables(List<Rentable> rentables) {
        this.rentables = rentables;
    }

    public Category() {
    }

    public Category(long id, String name, OffsetDateTime createdAt, OffsetDateTime modifiedAt, List<Item> items, List<Rentable> rentables) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.items = items;
        this.rentables = rentables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id && Objects.equals(name, category.name) && Objects.equals(createdAt, category.createdAt) && Objects.equals(modifiedAt, category.modifiedAt) && Objects.equals(items, category.items) && Objects.equals(rentables, category.rentables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdAt, modifiedAt, items, rentables);
    }
}
