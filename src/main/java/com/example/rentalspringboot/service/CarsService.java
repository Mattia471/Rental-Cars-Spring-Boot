package com.example.rentalspringboot.service;

import com.example.rentalspringboot.dto.CarsResponse;
import com.example.rentalspringboot.entity.Cars;

import java.util.List;

public interface CarsService
{
    CarsResponse getById(int id);

    CarsResponse getBylicensePlate(String licensePlate);

    List<CarsResponse> getAllBy();

    List<CarsResponse> getByManufacturer(String manufacturer);

    List<CarsResponse> getByModel(String model);

    List<CarsResponse> getByType(String type);

    List<CarsResponse> getByYear(String year);

    List<CarsResponse> getCarsAvailable(List<Integer> carsReserved);

    void saveCar(Cars car);

    void deleteCar(int id);
}
