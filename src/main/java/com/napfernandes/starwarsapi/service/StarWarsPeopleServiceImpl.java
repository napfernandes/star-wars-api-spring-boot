package com.napfernandes.starwarsapi.service;

import org.springframework.stereotype.Service;

import com.napfernandes.starwarsapi.client.StarWarsPeopleClient;
import com.napfernandes.starwarsapi.dto.PersonOutput;
import com.napfernandes.starwarsapi.entity.Person;
import com.napfernandes.starwarsapi.gson.GsonConverter;
import com.napfernandes.starwarsapi.mapper.PersonMapper;

@Service
public class StarWarsPeopleServiceImpl implements StarWarsPeopleService {
    private PersonMapper personMapper;
    private CacheService cacheService;
    private StarWarsPeopleClient starWarsPeopleClient;

    public StarWarsPeopleServiceImpl(
            PersonMapper personMapper,
            CacheService cacheService,
            GsonConverter gsonConverter,
            StarWarsPeopleClient starWarsPeopleClient) {
        this.personMapper = personMapper;
        this.cacheService = cacheService;
        this.starWarsPeopleClient = starWarsPeopleClient;
    }

    @Override
    public PersonOutput getPersonById(int personId) {
        String cacheKey = String.format("getPersonById#%s", personId);

        Person person = this.cacheService.getItem(cacheKey);

        if (person == null) {
            person = this.starWarsPeopleClient.getPersonById(personId);
            this.cacheService.setItem(cacheKey, person);
        }

        return this.personMapper.personToPersonOutput(person);
    }
}
