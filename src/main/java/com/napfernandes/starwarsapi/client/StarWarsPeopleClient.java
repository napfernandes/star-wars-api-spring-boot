package com.napfernandes.starwarsapi.client;

import java.util.List;

import com.napfernandes.starwarsapi.entity.Person;

public interface StarWarsPeopleClient {
    List<Person> getPeople();

    Person getPersonById(int personId);
}
