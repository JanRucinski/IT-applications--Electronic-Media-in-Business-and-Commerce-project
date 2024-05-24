package backend.api;

import backend.model.Category;
import backend.model.Item;
import backend.model.ItemDTO;
import backend.service.CategoryService;
import backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService is;
    private final CategoryService cs;

    @Autowired
    public ItemController(ItemService is, CategoryService cs) {
        this.is = is;
        this.cs = cs;
    }

    @PostMapping
    public ResponseEntity<ItemDTO> addItem(@RequestBody ItemDTO itemDTO) {
        if (itemDTO == null || itemDTO.getCategoryId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Category category = cs.findCategoryById(itemDTO.getCategoryId());
        if (category == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Item item = new Item(itemDTO);
        item.setCategory(category);
        Item createdItem = is.addItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ItemDTO(createdItem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItem(@PathVariable Long id) {
        Item item = is.findItemById(id);
        if (item != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ItemDTO(item));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getItems() {
        List<Item> items = is.findAllItems();
        return ResponseEntity.status(HttpStatus.OK).body(items.stream().map(ItemDTO::new).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable Long id, @RequestBody ItemDTO itemDTO) {
        if (itemDTO == null || itemDTO.getCategoryId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Category category = cs.findCategoryById(itemDTO.getCategoryId());
        if (category == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Item item = new Item(itemDTO);
        item.setCategory(cs.findCategoryById(itemDTO.getCategoryId()));
        Item updatedItem = is.updateItem(id, item);
        if (updatedItem != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ItemDTO(updatedItem));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        boolean deleted = is.deleteItem(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/bikes")
    public ResponseEntity<List<ItemDTO>> getBikes() {
        List<Item> bikes = is.findAllBikes();
        return ResponseEntity.status(HttpStatus.OK).body(bikes.stream().map(ItemDTO::new).collect(Collectors.toList()));

    }

    @GetMapping("/parts")
    public ResponseEntity<List<ItemDTO>> getParts() {
        List<Item> parts = is.findAllParts();
        return ResponseEntity.status(HttpStatus.OK).body(parts.stream().map(ItemDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/rent-items")
    public ResponseEntity<List<ItemDTO>> getRentItems() {
        List<Item> rentItems = is.findAllRentItems();
        return ResponseEntity.status(HttpStatus.OK).body(rentItems.stream().map(ItemDTO::new).collect(Collectors.toList()));
    }
}
