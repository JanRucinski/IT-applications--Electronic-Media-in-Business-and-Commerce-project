package backend.service;

import backend.model.Rental;

import java.time.LocalDate;
import java.util.List;

public interface RentalService {
    Rental addRental(Rental rental);

    boolean deleteRental(Long id);

    List<Rental> findAllRentals();

    Rental updateRental(Long id, Rental rental);

    Rental findRentalById(Long id);

    List<LocalDate> findReservedDatesOfItem(Long itemId);
}