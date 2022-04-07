package com.example.rentalspringboot.service;

import com.example.rentalspringboot.dto.CarsReserved;
import com.example.rentalspringboot.dto.CarsResponse;
import com.example.rentalspringboot.dto.UsersResponse;
import com.example.rentalspringboot.entity.Cars;
import com.example.rentalspringboot.entity.Users;
import com.example.rentalspringboot.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional//tutte le query sotto transazione
public class CarsServiceImpl implements CarsService {

    @Autowired
    CarsRepository carsRepository;


    @Override
    public Cars getById(int id) {
        Cars car = carsRepository.getById(id);
        return car;
    }

    @Override
    public CarsResponse getCarById(int id) {
        Cars car = carsRepository.getCarsById(id);
        CarsResponse response = new CarsResponse();
        response.setId(car.getId());
        response.setManufacturer(car.getManufacturer());
        response.setModel(car.getModel());
        response.setYear(car.getYear());
        response.setType(car.getType());
        response.setLicensePlate(car.getLicensePlate());
        return response;
    }


    @Override
    public CarsResponse getBylicensePlate(String licensePlate) {
        Cars cars = carsRepository.getBylicensePlate(licensePlate);
        CarsResponse response = new CarsResponse();
        response.setId(cars.getId());
        response.setManufacturer(cars.getManufacturer());
        response.setLicensePlate(cars.getLicensePlate());
        response.setModel(cars.getModel());
        response.setType(cars.getType());
        response.setYear(cars.getYear());
        return response;
    }

    @Override
    public List<CarsResponse> getAllBy() {
        List<CarsResponse> carsResponses = new ArrayList<>();
        List<Cars> cars = carsRepository.getAllBy();
        for (Cars res : cars) {
            CarsResponse response = new CarsResponse();
            response.setId(res.getId());
            response.setManufacturer(res.getManufacturer());
            response.setLicensePlate(res.getLicensePlate());
            response.setModel(res.getModel());
            response.setType(res.getType());
            response.setYear(res.getYear());
            carsResponses.add(response);
        }
        return carsResponses;
    }


    @Override
    public List<CarsResponse> getByManufacturer(String manufacturer) {
        List<CarsResponse> carsResponses = new ArrayList<>();
        List<Cars> cars = carsRepository.getByManufacturer(manufacturer);
        for (Cars res : cars) {
            CarsResponse response = new CarsResponse();
            response.setId(res.getId());
            response.setManufacturer(res.getManufacturer());
            response.setLicensePlate(res.getLicensePlate());
            response.setModel(res.getModel());
            response.setType(res.getType());
            response.setYear(res.getYear());
            carsResponses.add(response);
        }
        return carsResponses;
    }

    @Override
    public List<CarsResponse> getByModel(String model) {
        List<CarsResponse> carsResponses = new ArrayList<>();
        List<Cars> cars = carsRepository.getByModel(model);
        for (Cars res : cars) {
            CarsResponse response = new CarsResponse();
            response.setId(res.getId());
            response.setManufacturer(res.getManufacturer());
            response.setLicensePlate(res.getLicensePlate());
            response.setModel(res.getModel());
            response.setType(res.getType());
            response.setYear(res.getYear());
            carsResponses.add(response);
        }
        return carsResponses;
    }

    @Override
    public List<CarsResponse> getByType(String type) {
        List<CarsResponse> carsResponses = new ArrayList<>();
        List<Cars> cars = carsRepository.getByType(type);
        for (Cars res : cars) {
            CarsResponse response = new CarsResponse();
            response.setId(res.getId());
            response.setManufacturer(res.getManufacturer());
            response.setLicensePlate(res.getLicensePlate());
            response.setModel(res.getModel());
            response.setType(res.getType());
            response.setYear(res.getYear());
            carsResponses.add(response);
        }
        return carsResponses;
    }

    @Override
    public List<CarsResponse> getByYear(String year) {
        List<CarsResponse> carsResponses = new ArrayList<>();
        List<Cars> cars = carsRepository.getByYear(year);
        for (Cars res : cars) {
            CarsResponse response = new CarsResponse();
            response.setId(res.getId());
            response.setManufacturer(res.getManufacturer());
            response.setLicensePlate(res.getLicensePlate());
            response.setModel(res.getModel());
            response.setType(res.getType());
            response.setYear(res.getYear());
            carsResponses.add(response);
        }
        return carsResponses;
    }

    @Override
    public List<CarsResponse> getCarsAvailable(List<Integer> carsReserved) {
        List<Cars> carsAvailable = carsRepository.getCarsByIdNotIn(carsReserved);
        List<CarsResponse> cars = new ArrayList<>();
        //estrapola auto occupate
        for (Cars resAvailable : carsAvailable) {
            CarsResponse available = new CarsResponse();
            available.setId(resAvailable.getId());
            available.setType(resAvailable.getType());
            available.setYear(resAvailable.getYear());
            available.setModel(resAvailable.getModel());
            available.setLicensePlate(resAvailable.getLicensePlate());
            available.setManufacturer(resAvailable.getManufacturer());
            cars.add(available);
        }

        return cars;
    }

    @Override
    public void saveCar(Cars car) {
        carsRepository.save(car);
    }

    @Override
    public void deleteCar(int id) {
        carsRepository.deleteById(id);
    }
}
