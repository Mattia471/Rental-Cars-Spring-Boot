package com.example.rentalspringboot.service;

import com.example.rentalspringboot.dto.ReservationRequest;
import com.example.rentalspringboot.dto.ReservationUserResponse;
import com.example.rentalspringboot.dto.ReservationsCarsAvailable;
import com.example.rentalspringboot.dto.ReservationsResponse;
import com.example.rentalspringboot.entity.Cars;

import java.util.Date;
import java.util.List;

public interface ReservationsService {
    List<ReservationsResponse> getAllBy();

    List<ReservationUserResponse> getByUserId(int userId);

    ReservationsResponse getReservationsById(int id);

    List<ReservationsCarsAvailable> getCarsAvailable(Date endD, Date startD);

    void saveReservation(ReservationRequest reservation);

    void deleteReservation(int id);
}
