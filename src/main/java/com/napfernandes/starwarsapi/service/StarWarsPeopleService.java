package com.napfernandes.starwarsapi.service;

import java.util.List;

import com.napfernandes.starwarsapi.dto.PersonOutput;

public interface StarWarsPeopleService {
    List<PersonOutput> getPeople();

    PersonOutput getPersonById(int personId);
}
