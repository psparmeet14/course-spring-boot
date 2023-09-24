package com.parmeet.flightcheckin.integration;

import com.parmeet.flightcheckin.integration.dto.Reservation;
import com.parmeet.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

    Reservation findReservation(Long id);
    Reservation updateReservation(ReservationUpdateRequest request);
}
