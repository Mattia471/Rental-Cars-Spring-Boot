package com.example.rentalspringboot.service;

import com.example.rentalspringboot.dto.ReservationUserResponse;
import com.example.rentalspringboot.dto.ReservationsCarsAvailable;
import com.example.rentalspringboot.dto.ReservationsResponse;

import java.util.Date;
import java.util.List;

public interface ReservationsService {
    List<ReservationsResponse> getAllBy();

    List<ReservationUserResponse> getByUserId(int userId);

    ReservationsResponse getReservationsById(int id);

    List<ReservationsCarsAvailable> getCarsAvailable(Date endD, Date startD);

}
