package com.parmeet.flightreservation.services;

import com.parmeet.flightreservation.dto.ReservationRequest;
import com.parmeet.flightreservation.entities.Flight;
import com.parmeet.flightreservation.entities.Passenger;
import com.parmeet.flightreservation.entities.Reservation;
import com.parmeet.flightreservation.repos.FlightRepository;
import com.parmeet.flightreservation.repos.PassengerRepository;
import com.parmeet.flightreservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation bookFlight(ReservationRequest request) {
        // Make Payment

        Flight flight = flightRepository.findById(request.getFlightId()).orElse(null);

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setMiddleName(request.getPassengerMiddleName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());
        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        Reservation savedReservation = reservationRepository.save(reservation);
        return savedReservation;
    }
}
