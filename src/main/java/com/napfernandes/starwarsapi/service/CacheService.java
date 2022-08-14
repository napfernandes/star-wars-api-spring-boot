package com.napfernandes.starwarsapi.service;

import java.util.List;

public interface CacheService {
    void setItem(String cacheKey, Object item);

    <T> T getItem(String cacheKey);

    <T> List<T> getItemAsList(String cacheKey, Class<T> clazz);
}
