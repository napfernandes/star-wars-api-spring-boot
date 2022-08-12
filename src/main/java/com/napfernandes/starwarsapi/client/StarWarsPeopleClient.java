package com.napfernandes.starwarsapi.client;

import com.napfernandes.starwarsapi.entity.Person;

public interface StarWarsPeopleClient {
    Person getPersonById(int personId);
}
