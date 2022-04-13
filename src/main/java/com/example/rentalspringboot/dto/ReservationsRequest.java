package com.example.rentalspringboot.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationsRequest {
    private int id;
    private Date startDate;
    private Date endDate;
    private String status;
    private int carId;
    private int userId;
}