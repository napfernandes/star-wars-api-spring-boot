package com.napfernandes.starwarsapi.service;

import org.springframework.stereotype.Service;

import com.napfernandes.starwarsapi.client.StarWarsPeopleClient;
import com.napfernandes.starwarsapi.dto.PersonOutput;
import com.napfernandes.starwarsapi.entity.Person;
import com.napfernandes.starwarsapi.mapper.PersonMapper;

@Service
public class StarWarsPeopleServiceImpl implements StarWarsPeopleService {
    private PersonMapper personMapper;
    private CacheService<Person> personCacheService;
    private StarWarsPeopleClient starWarsPeopleClient;

    public StarWarsPeopleServiceImpl(
            PersonMapper personMapper,
            CacheService<Person> personCacheService,
            StarWarsPeopleClient starWarsPeopleClient) {
        this.personMapper = personMapper;
        this.personCacheService = personCacheService;
        this.starWarsPeopleClient = starWarsPeopleClient;
    }

    @Override
    public PersonOutput getPersonById(int personId) {
        Person person = null;
        String cacheKey = String.format("person#%s", personId);

        person = this.personCacheService.getItem(cacheKey);

        if (person == null) {
            person = this.starWarsPeopleClient.getPersonById(personId);
            this.personCacheService.setItem(cacheKey, person);
        }

        return this.personMapper.personToPersonOutput(person);
    }
}
