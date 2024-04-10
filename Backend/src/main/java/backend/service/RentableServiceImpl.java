package backend.service;

import backend.model.Rentable;
import backend.repository.RentableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RentableServiceImpl implements RentableService{
    @Autowired
    private RentableRepository rentableRepository;

    @Override
    public Rentable addRentable(Rentable rentable) {
        return null;
    }

    @Override
    public Rentable deleteRentable(long id) {
        return null;
    }

    @Override
    public List<Rentable> findAllRentables() {
        return null;
    }

    @Override
    public Rentable updateRentable(Rentable rentable) {
        return null;
    }

    @Override
    public Rentable findRentableById(long id) {
        return null;
    }
}
