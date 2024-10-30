package com.example.chargingstationservice.charging_station_service.service;

import com.example.chargingstationservice.charging_station_service.entity.ChargingStations;
import com.example.chargingstationservice.charging_station_service.repository.ChargingStationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChargingStationServiceTest {

    @Mock
    private RedisTemplate<String, String> redisTemplate;

    @Mock
    private ChargingStationRepository chargingStationRepository;

    @Mock
    private ValueOperations valueOperations;

    @InjectMocks
    private ChargingStationService chargingStationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(redisTemplate.opsForValue()).thenReturn(valueOperations);
    }

    @Test
    void testFindNearestChargingStationBasedOnPreference_noChargingStationFound_verifyBlankResponse() {
        String carId = "1";
        Mockito.doReturn("test").when(valueOperations).get(carId);
        Mockito.doReturn(new ArrayList<>()).when(chargingStationRepository).findByLocationAndAvailabilityGreaterThanAndChargingSpeedGreaterThan(Mockito.anyString(), Mockito.anyLong(), Mockito.anyLong());
        List<ChargingStations> chargingStations = chargingStationService.findNearestChargingStationBasedOnPreference(carId, 5L);
        Assertions.assertThat(chargingStations).isNotNull();
        Assertions.assertThat(chargingStations.size()).isEqualTo(0);
    }

    @Test
    void test_findNearestChargingStationBasedOnPreference_stationAvailable_verifyResponse(){
        String carId = "1";
        List<ChargingStations> chargingStationsList = new ArrayList<>();
        chargingStationsList.add(new ChargingStations(1L,"station 1","sun pharma road",5L,2L,25L, "address 1"));

        Mockito.doReturn("test").when(valueOperations).get(carId);
        Mockito.doReturn(chargingStationsList).when(chargingStationRepository).findByLocationAndAvailabilityGreaterThanAndChargingSpeedGreaterThan(Mockito.anyString(), Mockito.anyLong(), Mockito.anyLong());

        List<ChargingStations> chargingStations = chargingStationService.findNearestChargingStationBasedOnPreference(carId, 5L);
        Assertions.assertThat(chargingStations).isNotNull();
        Assertions.assertThat(chargingStations.size()).isEqualTo(1);
        Assertions.assertThat(chargingStations.get(0))
                .hasFieldOrPropertyWithValue("name", "station 1")
                .hasFieldOrPropertyWithValue("id", 1L);


    }


}