package com.napfernandes.starwarsapi.service;

public interface CacheService<T> {
    void setItem(String cacheKey, T item);

    T getItem(String cacheKey);
}
