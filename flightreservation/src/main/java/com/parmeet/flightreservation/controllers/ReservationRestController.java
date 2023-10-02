package com.parmeet.flightreservation.controllers;

import com.parmeet.flightreservation.dto.ReservationUpdateRequest;
import com.parmeet.flightreservation.entities.Reservation;
import com.parmeet.flightreservation.repos.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ReservationRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

    @Autowired
    private ReservationRepository reservationRepository;


    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {
        LOGGER.info("Inside findReservation() for id: " + id);
        return reservationRepository.findById(id).orElse(null);
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
        LOGGER.info("Inside updateReservation() for " + request);
        Reservation reservation = reservationRepository.findById(request.getId()).orElse(null);
        assert reservation != null;
        reservation.setCheckedIn(request.getCheckedIn());
        reservation.setNumberOfBags(request.getNumberOfBags());
        LOGGER.info("Saving reservation " + reservation);
        return reservationRepository.save(reservation);
    }
}
