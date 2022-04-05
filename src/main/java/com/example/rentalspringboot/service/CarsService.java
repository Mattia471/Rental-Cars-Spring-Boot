package com.example.rentalspringboot.service;

import com.example.rentalspringboot.dto.CarsRequest;
import com.example.rentalspringboot.dto.CarsResponse;

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

    void saveCar(CarsRequest car);

    void deleteCar(int id);
}
