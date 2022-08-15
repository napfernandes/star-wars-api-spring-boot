package com.napfernandes.starwarsapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.napfernandes.starwarsapi.dto.FilmOutput;
import com.napfernandes.starwarsapi.entity.Film;

@Component
@Mapper(componentModel = "spring")
public interface FilmMapper {
    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

    @Mapping(target = "episodeId", source = "film.episode_id")
    @Mapping(target = "openingCrawl", source = "film.opening_crawl")
    @Mapping(target = "releaseDate", source = "film.release_date")
    @Mapping(target = "created", source = "film.created")
    @Mapping(target = "edited", source = "film.edited")
    FilmOutput filmToFilmOutput(Film film);
}