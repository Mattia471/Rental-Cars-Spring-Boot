package com.example.rentalspringboot.service;

import com.example.rentalspringboot.dto.CarsResponse;
import com.example.rentalspringboot.entity.Cars;

import java.util.List;

public interface CarsService
{
    Cars getById(int id);

    CarsResponse getCarById(int id);

    List<CarsResponse> getAllBy();

    List<CarsResponse> getCarsAvailable(List<Integer> carsReserved);

    void saveCar(Cars car);

    void deleteCar(int id);
}
