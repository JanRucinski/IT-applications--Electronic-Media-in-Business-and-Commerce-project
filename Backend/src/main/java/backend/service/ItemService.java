package backend.service;

import backend.model.Item;

import java.util.List;

public interface ItemService {
    Item addItem(Item item);
    Item deleteItem(long id);
    List<Item> findAllItems();
    Item updateItem(Item item);
    Item findItemById(long id);
}