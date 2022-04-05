package com.example.rentalspringboot.dto;

import lombok.Data;

@Data
public class CarsRequest {
    int id;
    String licensePlate;
    String manufacturer;
    String model;
    String type;
    String year;
}
