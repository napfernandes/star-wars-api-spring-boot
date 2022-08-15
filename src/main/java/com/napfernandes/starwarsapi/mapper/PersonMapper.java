package com.napfernandes.starwarsapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.napfernandes.starwarsapi.dto.PersonOutput;
import com.napfernandes.starwarsapi.entity.Person;

@Service
@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthYear", source = "person.birth_year")
    @Mapping(target = "eyeColor", source = "person.eye_color")
    @Mapping(target = "hairColor", source = "person.hair_color")
    @Mapping(target = "skinColor", source = "person.skin_color")
    PersonOutput personToPersonOutput(Person person);
}