package com.example.rentalspringboot.service;

import com.example.rentalspringboot.dto.ReservationUserResponse;
import com.example.rentalspringboot.dto.ReservationsRequest;
import com.example.rentalspringboot.dto.ReservationsResponse;
import com.example.rentalspringboot.entity.Reservations;

import java.util.Date;
import java.util.List;

public interface ReservationsService {
    List<ReservationsResponse> getAllBy();

    List<ReservationUserResponse> getByUserId(int userId);

    ReservationsResponse getReservationsById(int id);

    List<Integer> getCarsReserved(Date endD, Date startD);

    void saveReservation(Reservations reservation);

    void deleteReservation(int id);
}
