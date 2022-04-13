package com.example.rentalspringboot.controllers;

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
@CrossOrigin(origins = {"http://localhost:4200"},
        methods = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
public class CarsController {

    @Autowired
    private CarsService carsService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<CarsResponse>> listAll() {
        List<CarsResponse> car = carsService.getAllBy();
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping(value = "id/{id}", produces = "application/json")
    public ResponseEntity<Cars> carById(@PathVariable("id") int id) {
        Cars car = carsService.getById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping(value = "car/{id}", produces = "application/json")
    public ResponseEntity<CarsResponse> getCarById(@PathVariable("id") int id) {
        CarsResponse car = carsService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping(value = "add")
    public ResponseEntity<?> addCar(@RequestBody Cars car) {
        carsService.saveCar(car);
        return ResponseEntity.ok("auto aggiunta");
    }

    @PutMapping(value = "edit", produces = "application/json")
    public ResponseEntity<?> editUser(@RequestBody Cars car) {
        carsService.saveCar(car);
        return ResponseEntity.ok("auto aggiornata ");
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") int id) {
        carsService.deleteCar(id);
        return ResponseEntity.ok("auto eliminata");
    }

}
