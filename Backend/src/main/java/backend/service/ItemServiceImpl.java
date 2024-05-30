package backend.service;

import backend.model.Category;
import backend.model.Item;
import backend.model.OrderItem;
import backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
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
    public List<Item> findAllBikes() {
        return itemRepository.findItemsByCategorySuperCategory(Category.SuperCategory.BIKES);
    }

    @Override
    public List<Item> findAllParts() {
        return itemRepository.findItemsByCategorySuperCategory(Category.SuperCategory.PARTS);
    }

    @Override
    public List<Item> findAllRentItems() {
        return itemRepository.findItemsByCategorySuperCategory(Category.SuperCategory.RENT_ITEMS);
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
}
