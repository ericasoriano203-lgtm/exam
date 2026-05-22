package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ParkingDto;
import com.example.demo.dto.VehicleDto;

public interface ParkingService {
	
	ParkingDto createParking(ParkingDto vehicleDto);
	
	ParkingDto getParkingByLot(Long lot);
	
	List<ParkingDto> getAllParking();
	
	ParkingDto updateParking(Long lot, ParkingDto updateParking);

	void deleteParking(Long lot);
}
