package com.example.chargingstationservice.charging_station_service.repository;

import com.example.chargingstationservice.charging_station_service.entity.ChargingStations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargingStationRepository extends JpaRepository<ChargingStations,Long> {

   List<ChargingStations> findByLocationAndAvailabilityGreaterThanAndChargingSpeedGreaterThan(String location, Long availability,Long expectedChargingSpeed);
}
