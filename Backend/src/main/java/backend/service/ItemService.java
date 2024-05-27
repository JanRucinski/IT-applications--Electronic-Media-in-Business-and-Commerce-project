package backend.service;

import backend.model.Item;
import backend.model.OrderItem;

import java.util.List;

public interface ItemService {
    Item addItem(Item item);

    boolean deleteItem(Long id);

    List<Item> findAllItems();

    Item updateItem(Long id, Item item);

    Item findItemById(Long id);

    List<Item> findAllBikes();

    List<Item> findAllParts();

    List<Item> findAllRentItems();

    void updateItemQuantity(OrderItem orderItem);
}