package com.alifetvaci.walletapiapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * Redis işlemlerini tek noktadan yönetir
 */
@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String,Object> redisTemplate;

    public void save(
            String key,
            Object value,
            Duration ttl) {

        redisTemplate.opsForValue()
                .set(key, value, ttl);
    }

    public Object get(String key) {

        return redisTemplate.opsForValue()
                .get(key);
    }

    public void delete(String key) {

        redisTemplate.delete(key);
    }
}