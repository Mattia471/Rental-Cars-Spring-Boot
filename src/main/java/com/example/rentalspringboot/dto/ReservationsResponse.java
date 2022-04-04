package com.example.rentalspringboot.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationsResponse {
    private int idReservation;
    private Date startDate;
    private Date endDate;
    private String status;
    private int idCar;
    private int idUser;
}
