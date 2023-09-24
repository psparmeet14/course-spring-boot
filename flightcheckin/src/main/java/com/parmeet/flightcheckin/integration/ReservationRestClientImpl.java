package com.parmeet.flightcheckin.integration;

import com.parmeet.flightcheckin.integration.dto.Reservation;
import com.parmeet.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

    public static final String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/reservations";

    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(RESERVATION_REST_URL + "/" + id, Reservation.class);
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(RESERVATION_REST_URL, request, Reservation.class);
    }
}
