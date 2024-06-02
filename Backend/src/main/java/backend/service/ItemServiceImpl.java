package backend.service;

import backend.model.Category;
import backend.model.Item;
import backend.model.OrderItem;
import backend.repository.ItemRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item addItem(Item item) {
        item.setModifiedAt(OffsetDateTime.now());
        item.setCreatedAt(OffsetDateTime.now());
        return itemRepository.save(item);
    }

    @Override
    public boolean deleteItem(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item updateItem(Long id, Item item) {
        Optional<Item> oi = itemRepository.findById(id);
        if (oi.isPresent()) {
            oi.get().setName(item.getName());
            oi.get().setDesc(item.getDesc());
            oi.get().setQuantity(item.getQuantity());
            oi.get().setPrice(item.getPrice());
            oi.get().setImage(item.getImage());
            oi.get().setCategory(item.getCategory());
            oi.get().setModifiedAt(OffsetDateTime.now());
            return itemRepository.save(oi.get());
        }
        return null;
    }

    @Override
    public Item findItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public List<Item> findAllBikes(String name, String[] categoryNames, BigDecimal minPrice, BigDecimal maxPrice) {
        return itemRepository.findAll((root, query, criteriaBuilder) -> {
            Join<Item, Category> categoryJoin = root.join("category");
            List<Predicate> predicates = generateCommonItemPredicates(root, criteriaBuilder, categoryJoin, name, categoryNames, minPrice, maxPrice);

            predicates.add(criteriaBuilder.equal(categoryJoin.get("superCategory"), Category.SuperCategory.BIKES));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    @Override
    public List<Item> findAllParts(String name, String[] categoryNames, BigDecimal minPrice, BigDecimal maxPrice) {
        return itemRepository.findAll((root, query, criteriaBuilder) -> {
            Join<Item, Category> categoryJoin = root.join("category");
            List<Predicate> predicates = generateCommonItemPredicates(root, criteriaBuilder, categoryJoin, name, categoryNames, minPrice, maxPrice);

            predicates.add(criteriaBuilder.equal(categoryJoin.get("superCategory"), Category.SuperCategory.PARTS));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    @Override
    public List<Item> findAllRentItems(String name, String[] categoryNames, BigDecimal minPrice, BigDecimal maxPrice) {
        return itemRepository.findAll((root, query, criteriaBuilder) -> {
            Join<Item, Category> categoryJoin = root.join("category");
            List<Predicate> predicates = generateCommonItemPredicates(root, criteriaBuilder, categoryJoin, name, categoryNames, minPrice, maxPrice);

            predicates.add(criteriaBuilder.equal(categoryJoin.get("superCategory"), Category.SuperCategory.RENT_ITEMS));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    @Override
    public void updateItemQuantity(OrderItem orderItem, Boolean subtract) {
        Optional<Item> oi = itemRepository.findById(orderItem.getItem().getId());
        if (oi.isPresent()) {
            if (subtract) {
                oi.get().setQuantity(oi.get().getQuantity() - orderItem.getQuantity());
            } else {
                oi.get().setQuantity(oi.get().getQuantity() + orderItem.getQuantity());
            }
            oi.get().setModifiedAt(OffsetDateTime.now());
            itemRepository.save(oi.get());
        }
    }

    private List<Predicate> generateCommonItemPredicates(Root<Item> root, CriteriaBuilder criteriaBuilder, Join<Item, Category> categoryJoin, String name, String[] categoryNames, BigDecimal minPrice, BigDecimal maxPrice) {
        List<Predicate> predicates = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
        }
        if (categoryNames != null && categoryNames.length > 0) {
            predicates.add(categoryJoin.get("name").in((Object[]) categoryNames));
        }
        if (minPrice != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
        }
        if (maxPrice != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
        }
        return predicates;
    }
}
