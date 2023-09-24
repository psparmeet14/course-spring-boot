package com.parmeet.flightreservation.controllers;

import com.parmeet.flightreservation.dto.ReservationUpdateRequest;
import com.parmeet.flightreservation.entities.Reservation;
import com.parmeet.flightreservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ReservationRestController {

    @Autowired
    private ReservationRepository reservationRepository;

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
        Reservation reservation = reservationRepository.findById(request.getId()).orElse(null);
        assert reservation != null;
        reservation.setCheckedIn(request.getCheckedIn());
        reservation.setNumberOfBags(request.getNumberOfBags());
        return reservationRepository.save(reservation);
    }
}
