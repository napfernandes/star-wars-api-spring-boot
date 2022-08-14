package com.napfernandes.starwarsapi.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.napfernandes.starwarsapi.entity.Person;

@Service
public class StarWarsPeopleClientImpl extends StarWarsClient implements StarWarsPeopleClient {
    public StarWarsPeopleClientImpl(WebClient starWarsApiClient) {
        super(starWarsApiClient);
    }

    @Override
    public Person getPersonById(int personId) {
        return super.starWarsApiClient.get()
                .uri("/people/%s/".formatted(personId))
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Person.class)
                .block();
    }
}
