package com.napfernandes.starwarsapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.napfernandes.starwarsapi.client.StarWarsFilmClient;
import com.napfernandes.starwarsapi.dto.FilmOutput;
import com.napfernandes.starwarsapi.entity.Film;
import com.napfernandes.starwarsapi.mapper.FilmMapper;

@Service
public class StarWarsFilmServiceImpl implements StarWarsFilmService {
    private FilmMapper filmMapper;
    private CacheService cacheService;
    private StarWarsFilmClient starWarsFilmClient;

    public StarWarsFilmServiceImpl(FilmMapper filmMapper, CacheService cacheService,
            StarWarsFilmClient starWarsFilmClient) {
        this.filmMapper = filmMapper;
        this.cacheService = cacheService;
        this.starWarsFilmClient = starWarsFilmClient;
    }

    @Override
    public List<FilmOutput> getFilms() {
        String cacheKey = "getFilms";

        List<Film> films = this.cacheService.getItemAsList(cacheKey, Film.class);

        if (films == null) {
            films = this.starWarsFilmClient.getFilms();
            this.cacheService.setItem(cacheKey, films);
        }

        return films.stream()
                .map(film -> filmMapper.filmToFilmOutput(film))
                .collect(Collectors.toList());
    }

    @Override
    public FilmOutput getFilmById(int filmId) {
        String cacheKey = String.format("getFilmById#%s", filmId);
        Film film = this.cacheService.getItem(cacheKey, Film.class);

        if (film == null) {
            film = this.starWarsFilmClient.getFilmById(filmId);
            this.cacheService.setItem(cacheKey, film);
        }

        return this.filmMapper.filmToFilmOutput(film);
    }

}
