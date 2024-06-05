package backend.api;

import backend.model.*;
import backend.service.ItemService;
import backend.service.RentalService;
import backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rentals")
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
public class RentalController {
    private final RentalService rs;
    private final ItemService is;
    private final UserService us;

    @Autowired
    public RentalController(RentalService rs, ItemService is, UserService us) {
        this.rs = rs;
        this.is = is;
        this.us = us;
    }

    @PostMapping
    public ResponseEntity<RentalDTO> addRental(@RequestBody RentalDTO rentalDTO) {
        if (rentalDTO == null || rentalDTO.getItemId() == null || rentalDTO.getUserId() == null || rentalDTO.getPayment() == null || rentalDTO.getRentalStart().isAfter(rentalDTO.getRentalEnd())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Item item = is.findItemById(rentalDTO.getItemId());
        User user = us.findUserById(rentalDTO.getUserId());
        if (item == null || user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Rental rental = new Rental(rentalDTO);
        rental.setItem(item);
        rental.setUser(user);
        rental.setTotal(item.getPrice().multiply(BigDecimal.valueOf(rental.getRentalStart().until(rental.getRentalEnd().plusDays(1), ChronoUnit.DAYS))));
        rental.setPayment(new Payment(rentalDTO.getPayment()));
        rental.getPayment().setAmount(rental.getTotal());
        rental = rs.addRental(rental);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RentalDTO(rental));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalDTO> getRental(@PathVariable Long id) {
        Rental rental = rs.findRentalById(id);
        if (rental != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new RentalDTO(rental));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<RentalDTO>> getRentals() {
        List<Rental> rentals = rs.findAllRentals();
        return ResponseEntity.status(HttpStatus.OK).body(rentals.stream().map(RentalDTO::new).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalDTO> updateRental(@PathVariable Long id, @RequestBody RentalDTO rentalDTO) {
        if (rentalDTO == null || rentalDTO.getPayment() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Rental rental = new Rental(rentalDTO);
        rental.setPayment(new Payment(rentalDTO.getPayment()));
        rental = rs.updateRental(id, rental);
        if (rental != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new RentalDTO(rental));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Long id) {
        boolean deleted = rs.deleteRental(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}