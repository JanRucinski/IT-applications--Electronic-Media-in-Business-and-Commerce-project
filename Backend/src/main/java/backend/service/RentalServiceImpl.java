package backend.service;

import backend.model.Rental;
import backend.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RentalServiceImpl implements RentalService{
    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public Rental addRental(Rental rentalDTO) {
        Rental rental = rentalRepository.save(new Rental(rentalDTO.getRentalStart(), rentalDTO.getRentalEnd(), rentalDTO.getTotal(), rentalDTO.getItem(), rentalDTO.getUser()));
        rentalDTO.setId(rental.getId());
        rentalDTO.setCreatedAt(rental.getCreatedAt());
        rentalDTO.setModifiedAt(rental.getModifiedAt());
        return rentalDTO;
    }

    @Override
    public Rental deleteRental(long id) {
        Optional<Rental> or = rentalRepository.findById(id);
        if (or.isPresent()) {
            rentalRepository.deleteById(id);
            return createDTOFromEntity(or.get());
        }
        return null;
    }

    @Override
    public List<Rental> findAllRentals() {
        List<Rental> rentals = rentalRepository.findAll();
        List<Rental> rentalDTOs = new ArrayList<>();
        for (Rental rental : rentals) {
            rentalDTOs.add(createDTOFromEntity(rental));
        }
        return rentalDTOs;
    }

    @Override
    public Rental updateRental(Rental rentalDTO) {
        Optional<Rental> or = rentalRepository.findById(rentalDTO.getId());
        if (or.isPresent()) {
            or.get().setRentalStart(rentalDTO.getRentalStart());
            or.get().setRentalEnd(rentalDTO.getRentalEnd());
            or.get().setTotal(rentalDTO.getTotal());
            or.get().setItem(rentalDTO.getItem());
            or.get().setStatus(rentalDTO.getStatus());
            or.get().setModifiedAt(OffsetDateTime.now());
            rentalRepository.save(or.get());
            rentalDTO = createDTOFromEntity(or.get());
            return rentalDTO;
        }
        return null;
    }

    @Override
    public Rental findRentalById(long id) {
        Optional<Rental> or = rentalRepository.findById(id);
        return or.map(this::createDTOFromEntity).orElse(null);
    }

    public Rental createDTOFromEntity(Rental rental) {
        Rental rentalDTO = new Rental();
        rentalDTO.setId(rental.getId());
        rentalDTO.setRentalStart(rental.getRentalStart());
        rentalDTO.setRentalEnd(rental.getRentalEnd());
        rentalDTO.setTotal(rental.getTotal());
        rentalDTO.setStatus(rental.getStatus());
        rentalDTO.setItem(rental.getItem());
        rentalDTO.setUser(rental.getUser());
        rentalDTO.setPayment(rental.getPayment());
        rentalDTO.setCreatedAt(rental.getCreatedAt());
        rentalDTO.setModifiedAt(rental.getModifiedAt());
        return rentalDTO;
    }
}
