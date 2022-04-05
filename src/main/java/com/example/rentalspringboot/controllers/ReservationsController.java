package com.example.rentalspringboot.controllers;

import com.example.rentalspringboot.dto.CarsReserved;
import com.example.rentalspringboot.dto.CarsResponse;
import com.example.rentalspringboot.dto.ReservationUserResponse;
import com.example.rentalspringboot.dto.ReservationsResponse;
import com.example.rentalspringboot.entity.Cars;
import com.example.rentalspringboot.entity.Reservations;
import com.example.rentalspringboot.service.CarsService;
import com.example.rentalspringboot.service.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/reservations")
@CrossOrigin(origins = {"http://localhost:4200"},
        methods = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
public class ReservationsController {

    @Autowired
    private ReservationsService reservationsService;

    @Autowired
    private CarsService carsService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<ReservationsResponse>> listAll() {
        List<ReservationsResponse> reservations = reservationsService.getAllBy();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping(value = "user/{id}", produces = "application/json")
    public ResponseEntity<List<ReservationUserResponse>> listByCustomer(@PathVariable("id") int id) {
        List<ReservationUserResponse> reservations = reservationsService.getByUserId(id);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping(value = "id/{id}", produces = "application/json")
    public ResponseEntity<ReservationsResponse> listById(@PathVariable("id") int id) {
        ReservationsResponse reservations = reservationsService.getReservationsById(id);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping(value = "reserved", produces = "application/json")
    public ResponseEntity<List<CarsResponse>> listReserved(@RequestParam("endD") String endD, @RequestParam("startD") String startD) throws ParseException {

        //TODO IMPLEMENTARE REQUESTBODY
        SimpleDateFormat pattern = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = pattern.parse(startD);
        Date endDate = pattern.parse(endD);


        List<Integer> carsReserved = reservationsService.getCarsReserved(endDate, startDate);
        List<CarsResponse> carsAvailable = carsService.getCarsAvailable(carsReserved);
        return new ResponseEntity<>(carsAvailable, HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable("id") int id) {
        reservationsService.deleteReservation(id);
        return ResponseEntity.ok("prenotazione eliminata");
    }


    //TODO NON FUNZIONANTE SISTEMARE/CREARE DTO IN RICHIESTA
    @PostMapping(value = "add")
    public ResponseEntity<?> addReservation(@RequestBody Reservations reservation) {
        reservationsService.saveReservation(reservation);
        return ResponseEntity.ok("prenotazione aggiunta");
    }
}
