package backend.service;

import backend.model.Item;
import backend.model.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface ItemService {
    Item addItem(Item item);

    boolean deleteItem(Long id);

    List<Item> findAllItems();

    Item updateItem(Long id, Item item);

    Item findItemById(Long id);

    Page<Item> findAllBikes(String name, String[] categoryNames, BigDecimal minPrice, BigDecimal maxPrice, String brand, String model, Double minWeight, Double maxWeight, String wheelSize, Pageable pageable);

    Page<Item> findAllParts(String name, String[] categoryNames, BigDecimal minPrice, BigDecimal maxPrice, String material, String partType, Pageable pageable);

    Page<Item> findAllRentItems(String name, String[] categoryNames, BigDecimal minPrice, BigDecimal maxPrice, String brand, String model, Double minWeight, Double maxWeight, String wheelSize, Pageable pageable);

    void updateItemQuantity(OrderItem orderItem, Boolean subtract);
}