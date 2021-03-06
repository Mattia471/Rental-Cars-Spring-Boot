package com.example.rentalspringboot.repository;

import com.example.rentalspringboot.entity.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationsRepository extends JpaRepository<Reservations, Integer> {

    List<Reservations> getAllBy();

    List<Reservations> getByUserId(int userId);

    List<Reservations> getReservationsByStartDateLessThanEqualAndEndDateGreaterThanEqual(Date endD, Date startD);

    Reservations getReservationsById(int id);


}
