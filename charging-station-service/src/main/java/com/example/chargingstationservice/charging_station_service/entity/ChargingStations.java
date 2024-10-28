package com.example.chargingstationservice.charging_station_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "charging_stations")
@Data
public class ChargingStations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;
    private Long capacity;
    private Long availability;
    private Long chargingSpeed;
    private String address;


}
