package com.example.demo.mapper;

import com.example.demo.dto.VehicleDto;
import com.example.demo.entity.Vehicle;

public class VehicleMapper {
	
	public static VehicleDto mapToVehicleDto(Vehicle vehicle) {

		return new VehicleDto(
					vehicle.getLicense(),
					vehicle.getType(),
					vehicle.getOwner(),
					vehicle.getLot()
				);
	}
	
	public static Vehicle mapToVehicle(VehicleDto vehicleDto) {
		
		return new Vehicle(
				vehicleDto.getLicense(),
				vehicleDto.getType(),
				vehicleDto.getOwner(),
				vehicleDto.getLot()
		);
	}

}
