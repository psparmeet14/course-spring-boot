package com.parmeet.flightreservation.services;

import com.parmeet.flightreservation.dto.ReservationRequest;
import com.parmeet.flightreservation.entities.Reservation;

public interface ReservationService {
    Reservation bookFlight(ReservationRequest request);
}
