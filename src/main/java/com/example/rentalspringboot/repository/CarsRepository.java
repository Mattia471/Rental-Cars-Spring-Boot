package com.example.rentalspringboot.repository;

import com.example.rentalspringboot.dto.CarsReserved;
import com.example.rentalspringboot.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarsRepository extends JpaRepository<Cars, Integer> {
    Cars getById(int id);

    List<Cars> getAllBy();

    Cars getBylicensePlate(String licensePlate);

    List<Cars> getByManufacturer(String manufacturer);

    List<Cars> getByModel(String model);

    List<Cars> getByType(String type);

    List<Cars> getByYear(String year);


    List<Cars> getCarsByIdNotIn(List<Integer> carsReservedId);


}
