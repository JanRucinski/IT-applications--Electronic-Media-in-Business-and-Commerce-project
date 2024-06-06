package backend.api;

import backend.model.*;
import backend.service.CategoryService;
import backend.service.ItemService;
import backend.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
public class ItemController {
    private final ItemService is;
    private final CategoryService cs;
    private final RentalService rs;

    @Autowired
    public ItemController(ItemService is, CategoryService cs, RentalService rs) {
        this.is = is;
        this.cs = cs;
        this.rs = rs;
    }

    @PostMapping
    public ResponseEntity<ItemDTO> addItem(@RequestBody ItemDTO itemDTO) {
        Item item = createItemFromDTO(itemDTO);
        if (item == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
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
        Item item = createItemFromDTO(itemDTO);
        if (item == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
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
    public ResponseEntity<Page<ItemDTO>> getBikes(@RequestParam(required = false) String name,
                                                  @RequestParam(required = false) String[] categoryNames,
                                                  @RequestParam(required = false) BigDecimal minPrice,
                                                  @RequestParam(required = false) BigDecimal maxPrice,
                                                  @RequestParam(required = false) String brand,
                                                  @RequestParam(required = false) String model,
                                                  @RequestParam(required = false) Double minWeight,
                                                  @RequestParam(required = false) Double maxWeight,
                                                  @RequestParam(required = false) String wheelSize,
                                                  @RequestParam(defaultValue = "1") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Item> bikes = is.findAllBikes(name, categoryNames, minPrice, maxPrice, brand, model, minWeight, maxWeight, wheelSize, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(bikes.map(ItemDTO::new));
    }

    @GetMapping("/parts")
    public ResponseEntity<Page<ItemDTO>> getParts(@RequestParam(required = false) String name,
                                                  @RequestParam(required = false) String[] categoryNames,
                                                  @RequestParam(required = false) BigDecimal minPrice,
                                                  @RequestParam(required = false) BigDecimal maxPrice,
                                                  @RequestParam(required = false) String material,
                                                  @RequestParam(required = false) String partType,
                                                  @RequestParam(defaultValue = "1") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Item> parts = is.findAllParts(name, categoryNames, minPrice, maxPrice, material, partType, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(parts.map(ItemDTO::new));
    }

    @GetMapping("/rent-items")
    public ResponseEntity<Page<ItemDTO>> getRentItems(@RequestParam(required = false) String name,
                                                      @RequestParam(required = false) String[] categoryNames,
                                                      @RequestParam(required = false) BigDecimal minPrice,
                                                      @RequestParam(required = false) BigDecimal maxPrice,
                                                      @RequestParam(required = false) String brand,
                                                      @RequestParam(required = false) String model,
                                                      @RequestParam(required = false) Double minWeight,
                                                      @RequestParam(required = false) Double maxWeight,
                                                      @RequestParam(required = false) String wheelSize,
                                                      @RequestParam(defaultValue = "1") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Item> rentItems = is.findAllRentItems(name, categoryNames, minPrice, maxPrice, brand, model, minWeight, maxWeight, wheelSize, pageable);
        Page<ItemDTO> rentItemDTOs = rentItems.map(item -> {
            ItemDTO dto = new ItemDTO(item);
            dto.setReservedDates(rs.findReservedDatesOfItem(dto.getId()));
            return dto;
        });
        return ResponseEntity.status(HttpStatus.OK).body(rentItemDTOs);
    }

    private Item createItemFromDTO(ItemDTO itemDTO) {
        if (itemDTO == null || itemDTO.getCategoryId() == null) {
            return null;
        }
        Category category = cs.findCategoryById(itemDTO.getCategoryId());
        if (category == null) {
            return null;
        }
        Item item = new Item(itemDTO);
        item.setCategory(category);
        if (itemDTO.getBikeDetails() != null) {
            item.setBikeDetails(new BikeDetails(itemDTO.getBikeDetails()));
        }
        if (itemDTO.getPartDetails() != null) {
            item.setPartDetails(new PartDetails(itemDTO.getPartDetails()));
        }
        return item;
    }
}
