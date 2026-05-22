package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.VehicleDto;

public interface VehicleService {
	
	VehicleDto createVehicle(VehicleDto vehicleDto);
	
	VehicleDto getVehicleByLot(Long lot);
	
	List<VehicleDto> getAllVehicle();
	
	VehicleDto updateVehicle(Long lot, VehicleDto updateVehicle);

	void deleteVehicle(Long lot);
}
