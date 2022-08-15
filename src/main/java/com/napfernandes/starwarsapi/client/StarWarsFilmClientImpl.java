package com.napfernandes.starwarsapi.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.napfernandes.starwarsapi.entity.Film;
import com.napfernandes.starwarsapi.entity.SearchResult;

@Service
public class StarWarsFilmClientImpl extends StarWarsClient implements StarWarsFilmClient {
    public StarWarsFilmClientImpl(WebClient starWarsWebClient) {
        super(starWarsWebClient);
    }

    @Override
    public List<Film> getFilms() {
        SearchResult<Film> searchResult = super.starWarsApiClient.get()
                .uri("/films/")
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SearchResult<Film>>() {
                })
                .block();

        return searchResult.getResults();
    }

    @Override
    public Film getFilmById(int filmId) {
        return super.starWarsApiClient.get()
                .uri("/films/%s/".formatted(filmId))
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Film.class)
                .block();
    }

}
