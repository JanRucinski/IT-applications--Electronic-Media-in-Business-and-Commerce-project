package backend.service;

import backend.model.Rental;
import backend.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RentalServiceImpl implements RentalService{
    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public Rental addRental(Rental rental) {
        return null;
    }

    @Override
    public Rental deleteRental(long id) {
        return null;
    }

    @Override
    public List<Rental> findAllRentals() {
        return null;
    }

    @Override
    public Rental updateRental(Rental rental) {
        return null;
    }

    @Override
    public Rental findRentalById(long id) {
        return null;
    }
}
