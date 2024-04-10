package backend.service;

import backend.model.Rental;

import java.util.List;

interface RentalService {
    Rental addRental(Rental rental);
    Rental deleteRental(long id);
    List<Rental> findAllRentals();
    Rental updateRental(Rental rental);
    Rental findRentalById(long id);
}