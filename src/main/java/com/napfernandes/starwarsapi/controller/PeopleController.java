package com.napfernandes.starwarsapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.napfernandes.starwarsapi.dto.PersonOutput;
import com.napfernandes.starwarsapi.service.StarWarsPeopleService;

@RestController
public class PeopleController {

    private StarWarsPeopleService starWarsPeopleService;

    public PeopleController(StarWarsPeopleService starWarsPeopleService) {
        this.starWarsPeopleService = starWarsPeopleService;
    }

    @GetMapping("/people")
    public List<PersonOutput> getPeople() {
        return this.starWarsPeopleService.getPeople();
    }

    @GetMapping("/people/{personId}")
    public PersonOutput getPersonById(@PathVariable("personId") int personId) {
        return this.starWarsPeopleService.getPersonById(personId);
    }
}
