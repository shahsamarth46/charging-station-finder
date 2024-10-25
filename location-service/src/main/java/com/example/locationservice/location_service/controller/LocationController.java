package com.example.locationservice.location_service.controller;

import com.example.locationservice.location_service.constant.UrlConstant;
import com.example.locationservice.location_service.dto.CarLocation;
import com.example.locationservice.location_service.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PutMapping(UrlConstant.UPDATE_CURRENT_LOCATION)
    public void saveCarLocation(@RequestBody CarLocation carLocation) {
        locationService.saveCarLocation(carLocation);
    }

    @GetMapping(UrlConstant.GET_CURRENT_LOCATION)
    public String getLocation(@PathVariable String id) {
        return locationService.getCarLocation(id);
    }

}