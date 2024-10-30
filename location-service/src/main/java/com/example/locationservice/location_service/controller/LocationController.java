package com.example.locationservice.location_service.controller;

import com.example.locationservice.location_service.constant.UrlConstant;
import com.example.locationservice.location_service.dto.CarLocation;
import com.example.locationservice.location_service.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PutMapping(UrlConstant.UPDATE_CURRENT_LOCATION)
    public ResponseEntity<?> updateCarLocation(@RequestBody CarLocation carLocation) {
        locationService.updateCarLocation(carLocation);
        return new ResponseEntity<>(carLocation,HttpStatus.NO_CONTENT);
    }

    @GetMapping(UrlConstant.GET_CURRENT_LOCATION)
    public String getLocation(@PathVariable String id) {
        return locationService.getCarLocation(id);
    }

}