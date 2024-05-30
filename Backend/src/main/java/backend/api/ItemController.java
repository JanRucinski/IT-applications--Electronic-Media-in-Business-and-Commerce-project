package backend.api;

import backend.model.Category;
import backend.model.Item;
import backend.model.ItemDTO;
import backend.service.CategoryService;
import backend.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
public class ItemController {
    private final ItemService is;
    private final CategoryService cs;

    @Autowired
    public ItemController(ItemService is, CategoryService cs) {
        this.is = is;
        this.cs = cs;
    }

    @PostMapping
    public ResponseEntity<ItemDTO> addItem(@RequestParam("itemDTO") String itemDTOString,
                                           @RequestParam("image") MultipartFile file) {
        ObjectMapper objectMapper = new ObjectMapper();
        ItemDTO itemDTO;
        try {
            itemDTO = objectMapper.readValue(itemDTOString, ItemDTO.class);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        if (itemDTO == null || itemDTO.getCategoryId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Category category = cs.findCategoryById(itemDTO.getCategoryId());
        if (category == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Item item = new Item(itemDTO);
        item.setCategory(category);
        try {
            item.setImage(file.getBytes());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        item = is.addItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ItemDTO(item));
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
        item = is.updateItem(id, item);
        if (item != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ItemDTO(item));
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
