package com.napfernandes.starwarsapi.service;

import org.springframework.web.reactive.function.client.WebClient;

public abstract class StarWarsService {
    protected WebClient starWarsApiClient;

    public StarWarsService(WebClient starWarsApiClient) {
        this.starWarsApiClient = starWarsApiClient;
    }
}
