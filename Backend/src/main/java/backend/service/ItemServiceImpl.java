package backend.service;

import backend.model.*;
import backend.repository.ItemRepository;
import backend.repository.OrderItemRepository;
import backend.repository.RentalRepository;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    private final RentalRepository rentalRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, RentalRepository rentalRepository, OrderItemRepository orderItemRepository) {
        this.itemRepository = itemRepository;
        this.rentalRepository = rentalRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Item addItem(Item item) {
        item.setModifiedAt(OffsetDateTime.now());
        item.setCreatedAt(OffsetDateTime.now());
        if (item.getBikeDetails() != null) {
            item.getBikeDetails().setModifiedAt(OffsetDateTime.now());
            item.getBikeDetails().setCreatedAt(OffsetDateTime.now());
        }
        if (item.getPartDetails() != null) {
            item.getPartDetails().setModifiedAt(OffsetDateTime.now());
            item.getPartDetails().setCreatedAt(OffsetDateTime.now());
        }
        return itemRepository.save(item);
    }

    @Override
    public boolean deleteItem(Long id) {
        if (itemRepository.existsById(id)) {
            List<Rental> rentals = rentalRepository.findRentalsByItemId(id);
            for (Rental rental : rentals) {
                rental.setItem(null);
                rentalRepository.save(rental);
            }
            List<OrderItem> orderItems = orderItemRepository.findOrderItemsByItemId(id);
            for (OrderItem orderItem : orderItems) {
                orderItem.setItem(null);
                orderItemRepository.save(orderItem);
            }
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
            oi.get().setImageUrl(item.getImageUrl());
            oi.get().setCategory(item.getCategory());
            oi.get().setModifiedAt(OffsetDateTime.now());
            if (item.getBikeDetails() != null) {
                if (oi.get().getBikeDetails() != null) {
                    oi.get().getBikeDetails().setBrand(item.getBikeDetails().getBrand());
                    oi.get().getBikeDetails().setModel(item.getBikeDetails().getModel());
                    oi.get().getBikeDetails().setWeight(item.getBikeDetails().getWeight());
                    oi.get().getBikeDetails().setWheelSize(item.getBikeDetails().getWheelSize());
                    oi.get().getBikeDetails().setModifiedAt(OffsetDateTime.now());
                } else {
                    oi.get().setBikeDetails(item.getBikeDetails());
                    oi.get().getBikeDetails().setModifiedAt(OffsetDateTime.now());
                    oi.get().getBikeDetails().setCreatedAt(OffsetDateTime.now());
                }
            } else {
                oi.get().setBikeDetails(null);
            }
            if (item.getPartDetails() != null) {
                if (oi.get().getPartDetails() != null) {
                    oi.get().getPartDetails().setMaterial(item.getPartDetails().getMaterial());
                    oi.get().getPartDetails().setPartType(item.getPartDetails().getPartType());
                    oi.get().getPartDetails().setModifiedAt(OffsetDateTime.now());
                } else {
                    oi.get().setPartDetails(item.getPartDetails());
                    oi.get().getPartDetails().setModifiedAt(OffsetDateTime.now());
                    oi.get().getPartDetails().setCreatedAt(OffsetDateTime.now());
                }
            } else {
                oi.get().setPartDetails(null);
            }
            return itemRepository.save(oi.get());
        }
        return null;
    }

    @Override
    public Item findItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Item> findAllBikes(String name, String[] categoryNames, BigDecimal minPrice, BigDecimal maxPrice, String brand, String model, Double minWeight, Double maxWeight, String wheelSize, Pageable pageable) {
        return itemRepository.findAll((root, query, criteriaBuilder) -> {
            Join<Item, Category> categoryJoin = root.join("category");
            List<Predicate> predicates = generateCommonItemPredicates(root, criteriaBuilder, categoryJoin, name, categoryNames, minPrice, maxPrice);

            predicates.add(criteriaBuilder.equal(categoryJoin.get("superCategory"), Category.SuperCategory.BIKES));

            predicates.addAll(generateCommonBikePredicates(root, criteriaBuilder, brand, model, minWeight, maxWeight, wheelSize));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    @Override
    public Page<Item> findAllParts(String name, String[] categoryNames, BigDecimal minPrice, BigDecimal maxPrice, String material, String partType, Pageable pageable) {
        return itemRepository.findAll((root, query, criteriaBuilder) -> {
            Join<Item, Category> categoryJoin = root.join("category");
            List<Predicate> predicates = generateCommonItemPredicates(root, criteriaBuilder, categoryJoin, name, categoryNames, minPrice, maxPrice);

            predicates.add(criteriaBuilder.equal(categoryJoin.get("superCategory"), Category.SuperCategory.PARTS));

            Join<Item, PartDetails> partDetailsJoin = root.join("partDetails", JoinType.LEFT);
            if (material != null && !material.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(partDetailsJoin.get("material")), "%" + material.toLowerCase() + "%"));
            }
            if (partType != null && !partType.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(partDetailsJoin.get("partType")), "%" + partType.toLowerCase() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    @Override
    public Page<Item> findAllRentItems(String name, String[] categoryNames, BigDecimal minPrice, BigDecimal maxPrice, String brand, String model, Double minWeight, Double maxWeight, String wheelSize, Pageable pageable) {
        return itemRepository.findAll((root, query, criteriaBuilder) -> {
            Join<Item, Category> categoryJoin = root.join("category");
            List<Predicate> predicates = generateCommonItemPredicates(root, criteriaBuilder, categoryJoin, name, categoryNames, minPrice, maxPrice);

            predicates.add(criteriaBuilder.equal(categoryJoin.get("superCategory"), Category.SuperCategory.RENT_ITEMS));

            predicates.addAll(generateCommonBikePredicates(root, criteriaBuilder, brand, model, minWeight, maxWeight, wheelSize));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
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
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
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

    private List<Predicate> generateCommonBikePredicates(Root<Item> root, CriteriaBuilder criteriaBuilder, String brand, String model, Double minWeight, Double maxWeight, String wheelSize) {
        List<Predicate> predicates = new ArrayList<>();
        Join<Item, BikeDetails> bikeDetailsJoin = root.join("bikeDetails", JoinType.LEFT);
        if (brand != null && !brand.isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(bikeDetailsJoin.get("brand")), "%" + brand.toLowerCase() + "%"));
        }
        if (model != null && !model.isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(bikeDetailsJoin.get("model")), "%" + model.toLowerCase() + "%"));
        }
        if (minWeight != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(bikeDetailsJoin.get("weight"), minWeight));
        }
        if (maxWeight != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(bikeDetailsJoin.get("weight"), maxWeight));
        }
        if (wheelSize != null && !wheelSize.isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(bikeDetailsJoin.get("wheelSize")), "%" + wheelSize.toLowerCase() + "%"));
        }
        return predicates;
    }
}
