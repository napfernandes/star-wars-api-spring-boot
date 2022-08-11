package com.napfernandes.starwarsapi.service;

import com.napfernandes.starwarsapi.dto.PersonOutput;

public interface StarWarsPeopleService {
    PersonOutput getPersonById(int personId);
}
