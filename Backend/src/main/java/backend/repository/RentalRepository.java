package backend.repository;

import backend.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findRentalsByItemId(Long itemId);

    List<Rental> findRentalsByUserId(Long userId);
}
