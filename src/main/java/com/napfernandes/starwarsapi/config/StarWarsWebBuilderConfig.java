package com.napfernandes.starwarsapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class StarWarsWebBuilderConfig {

    @Value("${starwarsapi.url}")
    private String starWarsApiUrl;

    @Bean
    public WebClient starWarsApiClient() {
        return WebClient.create(starWarsApiUrl);
    }
}
