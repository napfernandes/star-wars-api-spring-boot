package com.napfernandes.starwarsapi.service;

import java.util.List;

import com.napfernandes.starwarsapi.dto.FilmOutput;

public interface StarWarsFilmService {

    List<FilmOutput> getFilms();

    FilmOutput getFilmById(int filmId);
}
