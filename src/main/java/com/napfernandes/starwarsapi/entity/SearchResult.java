package com.napfernandes.starwarsapi.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResult<T> implements Serializable {
    private int count;
    private String next;
    private String previous;
    private List<T> results;
}
