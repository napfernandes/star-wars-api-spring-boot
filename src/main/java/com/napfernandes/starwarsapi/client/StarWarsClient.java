package com.napfernandes.starwarsapi.client;

import org.springframework.web.reactive.function.client.WebClient;

public abstract class StarWarsClient {
    protected WebClient starWarsApiClient;

    public StarWarsClient(WebClient starWarsApiClient) {
        this.starWarsApiClient = starWarsApiClient;
    }
}
