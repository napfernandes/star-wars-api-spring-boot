package com.napfernandes.starwarsapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.napfernandes.starwarsapi.dto.FilmOutput;
import com.napfernandes.starwarsapi.service.StarWarsFilmService;

@RestController
public class FilmController {
    private StarWarsFilmService starWarsFilmService;

    public FilmController(StarWarsFilmService starWarsFilmService) {
        this.starWarsFilmService = starWarsFilmService;
    }

    @GetMapping("/films")
    public List<FilmOutput> getFilms() {
        return this.starWarsFilmService.getFilms();
    }

    @GetMapping("/films/{filmId}")
    public FilmOutput getPersonById(@PathVariable("filmId") int filmId) {
        return this.starWarsFilmService.getFilmById(filmId);
    }
}
