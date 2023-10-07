package com.parmeet.flightcheckin.integration;

import com.parmeet.flightcheckin.integration.dto.Reservation;
import com.parmeet.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

    @Value("${com.parmeet.flightcheckin.reservation.rest.url}")
    private String RESERVATION_REST_URL;

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
