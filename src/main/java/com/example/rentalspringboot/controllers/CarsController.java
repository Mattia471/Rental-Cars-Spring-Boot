package com.example.rentalspringboot.controllers;

import com.example.rentalspringboot.dto.CarsRequest;
import com.example.rentalspringboot.dto.CarsResponse;
import com.example.rentalspringboot.entity.Cars;
import com.example.rentalspringboot.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@CrossOrigin("http://localhost:4200")
public class CarsController
{

    @Autowired
    private CarsService carsService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<CarsResponse>> listAll()
    {
        List<CarsResponse> car = carsService.getAllBy();
        return new ResponseEntity<>(car, HttpStatus.OK);
    }


    @GetMapping(value = "id/{id}", produces = "application/json")
    public ResponseEntity<CarsResponse> carById(@PathVariable("id") int id)
    {
        CarsResponse car = carsService.getById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping(value = "licensePlate/{licensePlate}", produces = "application/json")
    public ResponseEntity<CarsResponse> carBylicensePlate(@PathVariable("licensePlate") String licensePlate)
    {
        CarsResponse car = carsService.getBylicensePlate(licensePlate);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping(value = "manufacturer/{manufacturer}", produces = "application/json")
    public ResponseEntity<List<CarsResponse>> listByManufacturer(@PathVariable("manufacturer") String manufacturer)
    {
        List<CarsResponse> car = carsService.getByManufacturer(manufacturer);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping(value = "model/{model}", produces = "application/json")
    public ResponseEntity<List<CarsResponse>> listByModel(@PathVariable("model") String model)
    {
        List<CarsResponse> car = carsService.getByModel(model);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping(value = "type/{type}", produces = "application/json")
    public ResponseEntity<List<CarsResponse>> listByType(@PathVariable("type") String type)
    {
        List<CarsResponse> car = carsService.getByType(type);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping(value = "year/{year}", produces = "application/json")
    public ResponseEntity<List<CarsResponse>> listByYear(@PathVariable("year") String year)
    {
        List<CarsResponse> car = carsService.getByYear(year);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping(value = "add")
    public ResponseEntity<?> addCar(@RequestBody CarsRequest car)
    {
        carsService.saveCar(car);
        return ResponseEntity.ok("auto aggiunta");
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") int id)
    {
        carsService.deleteCar(id);
        return ResponseEntity.ok("auto eliminata");
    }

}
