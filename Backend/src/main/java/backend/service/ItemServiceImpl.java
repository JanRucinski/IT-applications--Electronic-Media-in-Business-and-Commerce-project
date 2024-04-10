package backend.service;

import backend.model.Item;
import backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item addItem(Item item) {
        return null;
    }

    @Override
    public Item deleteItem(long id) {
        return null;
    }

    @Override
    public List<Item> findAllItems() {
        return null;
    }

    @Override
    public Item updateItem(Item item) {
        return null;
    }

    @Override
    public Item findItemById(long id) {
        return null;
    }
}
