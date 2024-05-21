package backend.api;

import backend.model.Item;
import backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService is;

    @Autowired
    public ItemController(ItemService is) {
        this.is = is;
    }

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item createdItem = is.addItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        Item item = is.findItemById(id);
        if (item != null) {
            return ResponseEntity.status(HttpStatus.OK).body(item);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
        List<Item> items = is.findAllItems();
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        Item updatedItem = is.updateItem(id, item);
        if (updatedItem != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedItem);
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
    public ResponseEntity<List<Item>> getBikes() {
        List<Item> bikes = is.findAllBikes();
        return ResponseEntity.status(HttpStatus.OK).body(bikes);
    }

    @GetMapping("/parts")
    public ResponseEntity<List<Item>> getParts() {
        List<Item> parts = is.findAllParts();
        return ResponseEntity.status(HttpStatus.OK).body(parts);
    }

    @GetMapping("/rent-items")
    public ResponseEntity<List<Item>> getRentItems() {
        List<Item> rentItems = is.findAllRentItems();
        return ResponseEntity.status(HttpStatus.OK).body(rentItems);
    }
}
