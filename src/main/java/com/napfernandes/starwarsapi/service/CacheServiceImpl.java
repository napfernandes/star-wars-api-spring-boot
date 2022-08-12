package com.napfernandes.starwarsapi.service;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl<T> implements CacheService<T> {
    private RedissonClient redissonClient;

    public CacheServiceImpl(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public void setItem(String cacheKey, T item) {
        RBucket<T> bucket = redissonClient.getBucket(cacheKey);
        bucket.set(item, 10, TimeUnit.SECONDS);
    }

    @Override
    public T getItem(String cacheKey) {
        RBucket<T> bucket = redissonClient.getBucket(cacheKey);

        return bucket.get();
    }

}
