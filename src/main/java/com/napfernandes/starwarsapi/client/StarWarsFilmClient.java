package com.napfernandes.starwarsapi.client;

import java.util.List;

import com.napfernandes.starwarsapi.entity.Film;

public interface StarWarsFilmClient {
    List<Film> getFilms();

    Film getFilmById(int filmId);
}
