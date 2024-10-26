package com.example.chargingstationservice.charging_station_service.controller;

import com.example.chargingstationservice.charging_station_service.constant.UrlConstant;
import com.example.chargingstationservice.charging_station_service.dto.NearestChargingStation;
import com.example.chargingstationservice.charging_station_service.service.ChargingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChargingStationController {

    @Autowired
    private ChargingStationService chargingStationService;

    @GetMapping(UrlConstant.FIND_NEAREST_CHARGING_STATION_BASED_ON_PREFERENCE)
    public ResponseEntity<List<NearestChargingStation>> findNearestChargingStationBasedOnPreference(@PathVariable String carId, @PathVariable String preference) {
        List<NearestChargingStation> nearestChargingStationList = chargingStationService.findNearestChargingStationBasedOnPreference(carId, preference);
        return new ResponseEntity<>(nearestChargingStationList, HttpStatus.ACCEPTED);
    }

}