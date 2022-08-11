package com.napfernandes.starwarsapi.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonOutput {
    private String name;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String url;
    private LocalDateTime created;
}
