package com.example.rentalspringboot.service;

import com.example.rentalspringboot.dto.ReservationUserResponse;
import com.example.rentalspringboot.dto.ReservationsCarsAvailable;
import com.example.rentalspringboot.dto.ReservationsResponse;
import com.example.rentalspringboot.entity.Cars;
import com.example.rentalspringboot.entity.Reservations;
import com.example.rentalspringboot.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional//tutte le query sotto transazione
public class ReservationsServiceImpl implements ReservationsService {

    @Autowired
    ReservationsRepository reservationsRepository;


    @Override
    public List<ReservationsResponse> getAllBy() {
        List<ReservationsResponse> reservationsRespons = new ArrayList<>();
        List<Reservations> reservations = reservationsRepository.getAllBy();
        for (Reservations res : reservations) {
            ReservationsResponse response = new ReservationsResponse();
            response.setIdReservation(res.getId());
            response.setIdUser(res.getUser().getId());
            response.setIdCar(res.getCar().getId());
            response.setStatus(res.getStatus());
            response.setStartDate(res.getStartDate());
            response.setEndDate(res.getEndDate());
            reservationsRespons.add(response);
        }
        return reservationsRespons;
    }


    @Override
    public List<ReservationUserResponse> getByUserId(int userId) {
        List<ReservationUserResponse> reservationUserResponse = new ArrayList<>();
        List<Reservations> reservations = reservationsRepository.getByUserId(userId);
        for (Reservations res : reservations) {
            ReservationUserResponse response = new ReservationUserResponse();
            response.setIdReservation(res.getId());
            response.setIdUser(res.getUser().getId());
            response.setIdCar(res.getCar().getId());
            response.setStatus(res.getStatus());
            response.setStartDate(res.getStartDate());
            response.setEndDate(res.getEndDate());
            reservationUserResponse.add(response);
        }
        return reservationUserResponse;
    }

    @Override
    public ReservationsResponse getReservationsById(int id) {
        Reservations reservations = reservationsRepository.getReservationsById(id);
        ReservationsResponse response = new ReservationsResponse();
        response.setIdReservation(reservations.getId());
        response.setEndDate(reservations.getEndDate());
        response.setStartDate(reservations.getStartDate());
        response.setStatus(reservations.getStatus());
        response.setIdCar(reservations.getCar().getId());
        response.setIdUser(reservations.getUser().getId());
        return response;
    }

    @Override
    public List<ReservationsCarsAvailable> getCarsAvailable(Date endD, Date startD) {

        List<Cars> carsReserved = new ArrayList<>();
        List<Reservations> reservations = reservationsRepository.getReservationsByStartDateLessThanEqualAndEndDateGreaterThanEqual(startD, endD);

        //estrapola auto occupate
            for (Reservations resReserved : reservations) {
                carsReserved.add(resReserved.getCar());
            }

            //TODO CONTROLLO SE RISULTATO DI RESERVATIONS è NULLO IL NOT IN NON OPERA SU NESSUN ID

        List<ReservationsCarsAvailable> carsAvailables = new ArrayList<>();

        //importa nel parametro la lista di auto
        List<Reservations> listAvailableCars = reservationsRepository.getReservationsByCarNotIn(carsReserved);

        //estrapola le prenotazioni fuori dal range
        for (Reservations resAvailable : listAvailableCars) {
            ReservationsCarsAvailable response1 = new ReservationsCarsAvailable();
            response1.setIdCar(resAvailable.getCar().getId());
            response1.setManufacturer(resAvailable.getCar().getManufacturer());
            response1.setLicensePlate(resAvailable.getCar().getLicensePlate());
            response1.setModel(resAvailable.getCar().getModel());
            response1.setType(resAvailable.getCar().getType());
            response1.setYear(resAvailable.getCar().getYear());
            carsAvailables.add(response1);
        }
        return carsAvailables;
    }


}
