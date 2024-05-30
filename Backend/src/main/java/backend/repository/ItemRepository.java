package backend.repository;

import backend.model.Category;
import backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {
    List<Item> findItemsByCategorySuperCategory(Category.SuperCategory superCategory);
}
