package com.example.chargingstationservice.charging_station_service.service;

import com.example.chargingstationservice.charging_station_service.entity.ChargingStations;
import com.example.chargingstationservice.charging_station_service.repository.ChargingStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargingStationService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ChargingStationRepository chargingStationRepository;

    public List<ChargingStations> findNearestChargingStationBasedOnPreference(String carId, Long expectedChargingSpeed) {
        String currentLocation = redisTemplate.opsForValue().get(carId);
        return chargingStationRepository.findByLocationAndAvailabilityGreaterThanAndChargingSpeedGreaterThan(currentLocation, 0L, expectedChargingSpeed);
    }

}
