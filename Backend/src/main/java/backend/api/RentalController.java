package backend.api;

import backend.model.Rental;
import backend.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    private final RentalService rs;

    @Autowired
    public RentalController(RentalService rs) {
        this.rs = rs;
    }

    @PostMapping
    public ResponseEntity<Rental> addRental(@RequestBody Rental rental) {
        Rental createdRental = rs.addRental(rental);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRental);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rental> getRental(@PathVariable Long id) {
        Rental rental = rs.findRentalById(id);
        if (rental != null) {
            return ResponseEntity.status(HttpStatus.OK).body(rental);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Rental>> getRentals() {
        List<Rental> rentals = rs.findAllRentals();
        return ResponseEntity.status(HttpStatus.OK).body(rentals);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rental> updateRental(@PathVariable Long id, @RequestBody Rental rental) {
        Rental updatedRental = rs.updateRental(id, rental);
        if (updatedRental != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedRental);
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