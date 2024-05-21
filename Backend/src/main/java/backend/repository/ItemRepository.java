package backend.repository;

import backend.model.Category;
import backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findItemsByCategorySuperCategory(Category.SuperCategory superCategory);
}
