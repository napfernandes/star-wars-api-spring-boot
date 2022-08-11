package com.napfernandes.starwarsapi.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.napfernandes.starwarsapi.dto.PersonOutput;
import com.napfernandes.starwarsapi.entity.Person;
import com.napfernandes.starwarsapi.mapper.PersonMapper;

@Service
public class StarWarsPeopleServiceImpl extends StarWarsService implements StarWarsPeopleService {
    private PersonMapper personMapper;

    public StarWarsPeopleServiceImpl(
            PersonMapper personMapper,
            WebClient starWarsApiClient) {
        super(starWarsApiClient);

        this.personMapper = personMapper;
    }

    @Override
    public PersonOutput getPersonById(int personId) {
        Person person = super.starWarsApiClient.get()
                .uri("/people/%s/".formatted(personId))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Person.class)
                .block();

        if (person == null) {
            return null;
        }

        return this.personMapper.personToPersonOutput(person);
    }
}
