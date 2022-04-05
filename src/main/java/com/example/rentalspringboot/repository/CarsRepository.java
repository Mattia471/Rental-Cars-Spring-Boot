package com.example.rentalspringboot.repository;

import com.example.rentalspringboot.dto.CarsRequest;
import com.example.rentalspringboot.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarsRepository extends JpaRepository<Cars, Integer>
{
    Cars getById(int id);

    List<Cars> getAllBy();

    Cars getBylicensePlate(String licensePlate);

    List<Cars> getByManufacturer(String manufacturer);

    List<Cars> getByModel(String model);

    List<Cars> getByType(String type);

    List<Cars> getByYear(String year);

    void save(CarsRequest car);

}
