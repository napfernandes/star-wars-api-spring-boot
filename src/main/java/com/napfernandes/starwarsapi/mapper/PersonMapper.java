package com.napfernandes.starwarsapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.napfernandes.starwarsapi.dto.PersonOutput;
import com.napfernandes.starwarsapi.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthYear", source = "person.birth_year")
    PersonOutput personToPersonOutput(Person person);
}
