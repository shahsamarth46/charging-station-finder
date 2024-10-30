package com.example.locationservice.location_service.service;

import com.example.locationservice.location_service.dto.CarLocation;
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

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LocationServiceTest {

    @Mock
    private RedisTemplate<String, String> redisTemplate;

    @Mock
    private ValueOperations valueOperations;

    @InjectMocks
    private LocationService locationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(redisTemplate.opsForValue()).thenReturn(valueOperations);
    }

    @Test
    void testSaveCarLocation_verifyMethodCalled() {
        String location = "location";
        String carId = "carId";

        CarLocation carLocation = new CarLocation();
        carLocation.setLocation(location);
        carLocation.setCarId(carId);

        Mockito.doNothing().when(valueOperations).set(carId, location, Duration.ofSeconds(600));

        locationService.updateCarLocation(carLocation);

        Mockito.verify(valueOperations, Mockito.times(1))
                .set(carId, location, Duration.ofSeconds(600));
    }

    @Test
    void testGetCarLocation_valuePresent_verifyLocation() {
        String location = "location";
        String carId = "carId";


        Mockito.doReturn(location).when(valueOperations).get(carId);

        String carLocation = locationService.getCarLocation(carId);

        Assertions.assertThat(carLocation).isNotNull();
        assertEquals(carLocation, location);
        Mockito.verify(valueOperations, Mockito.times(1))
                .get(carId);
    }

    @Test
    void testGetCarLocation_valueNotPresent_verifyNullResponse() {
        String carId = "carId";

        Mockito.doReturn(null).when(valueOperations).get(carId);

        String carLocation = locationService.getCarLocation(carId);

        Assertions.assertThat(carLocation).isNull();
        Mockito.verify(valueOperations, Mockito.times(1))
                .get(carId);
    }
}