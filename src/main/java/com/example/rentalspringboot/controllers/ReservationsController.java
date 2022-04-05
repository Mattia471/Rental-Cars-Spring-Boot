package com.example.rentalspringboot.controllers;

import com.example.rentalspringboot.dto.ReservationRequest;
import com.example.rentalspringboot.dto.ReservationUserResponse;
import com.example.rentalspringboot.dto.ReservationsCarsAvailable;
import com.example.rentalspringboot.dto.ReservationsResponse;
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
@CrossOrigin("http://localhost:4200")
public class ReservationsController {

    @Autowired
    private ReservationsService reservationsService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<ReservationsResponse>> listAll() {
        List<ReservationsResponse> reservations = reservationsService.getAllBy();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping(value = "user/{id}", produces = "application/json")
    public ResponseEntity<List<ReservationUserResponse>> listOccupied(@PathVariable("id") int id) {
        List<ReservationUserResponse> reservations = reservationsService.getByUserId(id);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping(value = "id/{id}", produces = "application/json")
    public ResponseEntity<ReservationsResponse> listById(@PathVariable("id") int id) {
        ReservationsResponse reservations = reservationsService.getReservationsById(id);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PostMapping(value = "reserved/{startD}/{endD}", produces = "application/json")
    public ResponseEntity<List<ReservationsCarsAvailable>> listReserved(@PathVariable("startD") String endD, @PathVariable("endD") String startD) throws ParseException {

        //TODO IMPLEMENTARE REQUESTBODY
        SimpleDateFormat pattern = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = pattern.parse(startD);
        Date endDate = pattern.parse(endD);

        List<ReservationsCarsAvailable> reservations = reservationsService.getCarsAvailable(endDate, startDate);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable("id") int id) {
        reservationsService.deleteReservation(id);
        return ResponseEntity.ok("prenotazione eliminata");
    }


    //TODO NON FUNZIONANTE
    @PostMapping(value = "add")
    public ResponseEntity<?> addReservation(@RequestBody ReservationRequest reservation) {
        reservationsService.saveReservation(reservation);
        return ResponseEntity.ok("prenotazione aggiunta");
    }
}
