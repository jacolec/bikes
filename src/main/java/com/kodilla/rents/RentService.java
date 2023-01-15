package com.kodilla.rents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {

    @Autowired
    private RentRepository rentRepository;

    public List<Rent> getAllRents() {
        return (List<Rent>) rentRepository.findAll();
    }

    public Rent getRent(Long rentId) {
        return rentRepository.findById(rentId).get();
    }

    public Rent saveRent(final Rent rent) {
        return rentRepository.save(rent);
    }

    public void deleteRent(Long rentId) {
        rentRepository.deleteById(rentId);
    }
}
