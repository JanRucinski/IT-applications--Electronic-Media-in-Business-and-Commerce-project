package backend.service;

import backend.model.Rentable;

import java.util.List;

interface RentableService {
    Rentable addRentable(Rentable rentable);
    Rentable deleteRentable(long id);
    List<Rentable> findAllRentables();
    Rentable updateRentable(Rentable rentable);
    Rentable findRentableById(long id);
}