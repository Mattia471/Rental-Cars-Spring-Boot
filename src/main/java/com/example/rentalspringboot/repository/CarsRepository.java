package com.example.rentalspringboot.repository;

import com.example.rentalspringboot.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarsRepository extends JpaRepository<Cars, Integer> {
    Cars getById(int id);

    Cars getCarsById(int id);

    List<Cars> getAllBy();

    List<Cars> getCarsByIdNotIn(List<Integer> carsReservedId);


}
