package backend.repository;

import backend.model.Rentable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentableRepository extends JpaRepository<Rentable, Long> {
}
