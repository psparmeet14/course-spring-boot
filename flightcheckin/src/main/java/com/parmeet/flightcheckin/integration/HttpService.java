package com.parmeet.flightcheckin.integration;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public class HttpService<T> {

    public Optional<T> doGet(String endpoint, ParameterizedTypeReference<T> ptr) throws RestClientException {
        var restTemplate = new RestTemplate();
        var entity = buildEntity(null);
        var result = restTemplate.exchange(
                endpoint,
                HttpMethod.GET,
                entity,
                ptr
        );
        return Optional.ofNullable(result.getBody());
    }

    public <U> Optional<T> doPost(String endpoint, U requestBody, ParameterizedTypeReference<T> ptr) throws RestClientException {
        var restTemplate = new RestTemplate();
        var entity = buildEntity(requestBody);
        var result = restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                entity,
                ptr
        );
        return Optional.ofNullable(result.getBody());
    }

    private <T> HttpEntity<?> buildEntity(T body) {
        var httpHeaders = new HttpHeaders();
        //httpHeaders.add("Accept", "application/json");
        //httpHeaders.add("Content-Type", "application/json");
        // add token
        //httpHeaders.add("Authorization", "Bearer " + token);

        if (body != null) {
            return new HttpEntity<>(body, httpHeaders);
        }
        return new HttpEntity<>(httpHeaders);
    }

}
