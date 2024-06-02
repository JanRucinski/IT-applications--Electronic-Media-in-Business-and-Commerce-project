package backend.service;

import backend.model.Item;
import backend.model.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public interface ItemService {
    Item addItem(Item item);

    boolean deleteItem(Long id);

    List<Item> findAllItems();

    Item updateItem(Long id, Item item);

    Item findItemById(Long id);

    List<Item> findAllBikes(String name, String[] categoryNames, BigDecimal minPrice, BigDecimal maxPrice);

    List<Item> findAllParts(String name, String[] categoryNames, BigDecimal minPrice, BigDecimal maxPrice);

    List<Item> findAllRentItems(String name, String[] categoryNames, BigDecimal minPrice, BigDecimal maxPrice);

    void updateItemQuantity(OrderItem orderItem, Boolean subtract);
}