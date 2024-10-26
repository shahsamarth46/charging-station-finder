package com.example.chargingstationservice.charging_station_service.service;

import com.example.chargingstationservice.charging_station_service.dto.NearestChargingStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargingStationService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public List<NearestChargingStation> findNearestChargingStationBasedOnPreference(String carId, String preference) {
        String currentLocation = redisTemplate.opsForValue().get(carId);
        return null;
    }

}
