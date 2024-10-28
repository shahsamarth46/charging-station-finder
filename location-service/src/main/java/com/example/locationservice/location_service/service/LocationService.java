package com.example.locationservice.location_service.service;

import com.example.locationservice.location_service.dto.CarLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class LocationService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void saveCarLocation(CarLocation carLocation) {
        redisTemplate.opsForValue().set(carLocation.getCarId(), carLocation.getLocation(), Duration.ofSeconds(60));
    }

    public String getCarLocation(String carId) {
        return redisTemplate.opsForValue().get(carId);
    }

}