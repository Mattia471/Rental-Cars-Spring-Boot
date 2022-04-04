package com.example.rentalspringboot.dto;

import lombok.Data;

@Data
public class ReservationsCarsAvailable {

    int idCar;
    String manufacturer;
    String licensePlate;
    String model;
    String year;
    String type;
}
