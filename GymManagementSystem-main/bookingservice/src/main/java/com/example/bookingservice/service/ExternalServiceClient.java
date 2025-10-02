package com.example.bookingservice.service;

import com.example.bookingservice.dto.GymDto;
import com.example.bookingservice.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalServiceClient {

    private final RestTemplate restTemplate;

    @Value("${user.service.url:https://9091-firebase-gymmanagementsystem-1759230100803.cluster-ombtxv25tbd6yrjpp3lukp6zhc.cloudworkstations.dev}")
    private String userServiceUrl;

    @Value("${gym.service.url:https://9090-firebase-gymmanagementsystem-1759230100803.cluster-ombtxv25tbd6yrjpp3lukp6zhc.cloudworkstations.dev}")
    private String gymServiceUrl;

    public ExternalServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto getUserById(Long id) {
        String url = userServiceUrl + "/users/" + id;
        try {
            ResponseEntity<UserDto> resp = restTemplate.getForEntity(url, UserDto.class);
            return resp.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to fetch user from " + url, e);
        }
    }

    public GymDto getGymById(Long id) {
        String url = gymServiceUrl + "/gyms/" + id;
        try {
            ResponseEntity<GymDto> resp = restTemplate.getForEntity(url, GymDto.class);
            return resp.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to fetch gym from " + url, e);
        }
    }
}
