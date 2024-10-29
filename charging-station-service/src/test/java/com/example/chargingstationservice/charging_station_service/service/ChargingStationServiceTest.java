package com.example.chargingstationservice.charging_station_service.service;

import com.example.chargingstationservice.charging_station_service.entity.ChargingStations;
import com.example.chargingstationservice.charging_station_service.repository.ChargingStationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChargingStationServiceTest {

    @Mock
    private RedisTemplate<String, String> redisTemplate;

    @Mock
    private ChargingStationRepository chargingStationRepository;

    private ChargingStationService chargingStationService;




}