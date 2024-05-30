package backend.service;

import backend.model.Rental;
import backend.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RentalServiceImpl implements RentalService {
    private final RentalRepository rentalRepository;

    @Autowired
    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public Rental addRental(Rental rental) {
        rental.setModifiedAt(OffsetDateTime.now());
        rental.setCreatedAt(OffsetDateTime.now());
        rental.getPayment().setCreatedAt(OffsetDateTime.now());
        rental.getPayment().setModifiedAt(OffsetDateTime.now());
        return rentalRepository.save(rental);
    }

    @Override
    public boolean deleteRental(Long id) {
        if (rentalRepository.existsById(id)) {
            rentalRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Rental> findAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental updateRental(Long id, Rental rental) {
        Optional<Rental> or = rentalRepository.findById(id);
        if (or.isPresent()) {
            or.get().setStatus(rental.getStatus());
            or.get().getPayment().setStatus(rental.getPayment().getStatus());
            or.get().getPayment().setModifiedAt(OffsetDateTime.now());
            or.get().setModifiedAt(OffsetDateTime.now());
            return rentalRepository.save(or.get());
        }
        return null;
    }

    @Override
    public Rental findRentalById(Long id) {
        return rentalRepository.findById(id).orElse(null);
    }
}
