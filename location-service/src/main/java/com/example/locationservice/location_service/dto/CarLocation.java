package com.example.locationservice.location_service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CarLocation implements Serializable {

    private String carId;
    private String location;

}