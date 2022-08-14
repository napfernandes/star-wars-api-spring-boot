package com.napfernandes.starwarsapi.service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;
import com.napfernandes.starwarsapi.gson.GsonConverter;

@Service
public class CacheServiceImpl implements CacheService {
    private GsonConverter gsonConverter;
    private RedissonClient redissonClient;

    public CacheServiceImpl(RedissonClient redissonClient, GsonConverter gsonConverter) {
        this.gsonConverter = gsonConverter;
        this.redissonClient = redissonClient;
    }

    @Override
    public void setItem(String cacheKey, Object item) {
        RBucket<String> bucket = redissonClient.getBucket(cacheKey);

        bucket.set(gsonConverter.toJson(item), 10, TimeUnit.MINUTES);
    }

    @Override
    public <T> T getItem(String cacheKey) {
        RBucket<String> bucket = redissonClient.getBucket(cacheKey);

        Type itemType = new TypeToken<T>() {
        }.getType();

        return gsonConverter.fromJson(bucket.get(), itemType);
    }

    @Override
    public <T> List<T> getItemAsList(String cacheKey, Class<T> clazz) {
        RBucket<String> bucket = redissonClient.getBucket(cacheKey);

        return gsonConverter.fromJsonList(bucket.get(), clazz);
    }
}
