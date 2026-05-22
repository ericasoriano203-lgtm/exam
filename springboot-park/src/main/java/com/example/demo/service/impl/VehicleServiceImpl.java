package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.VehicleDto;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.VehicleMapper;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService{
	
	private VehicleRepository vehicleRepository;

	@Override
	public List<VehicleDto> getAllVehicle() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		return vehicles.stream().map((vehicle) -> VehicleMapper.mapToVehicleDto(vehicle))
				.collect(Collectors.toList());
	}

	
	@Override
	public VehicleDto createVehicle(VehicleDto vehicleDto) {
		Vehicle vehicle = VehicleMapper.mapToVehicle(vehicleDto);
		Vehicle savedvehicle = vehicleRepository.save(vehicle);
		return VehicleMapper.mapToVehicleDto(savedvehicle);
	}


	@Override
	public VehicleDto getVehicleByLot(Long lot) {
		Vehicle vehicle = vehicleRepository.findById(lot)
		.orElseThrow(() -> new ResourceNotFoundException("vehicle does not exist with given lot : " + lot));
		return VehicleMapper.mapToVehicleDto(vehicle);
	}

	@Override
	public VehicleDto updateVehicle(Long lot, VehicleDto updatedVehicle) {
		Vehicle vehicle = vehicleRepository.findById(lot).orElseThrow(
				() -> new ResourceNotFoundException("vehicle does not exists with given lot : " + lot));

		vehicle.setLicense(updatedVehicle.getLicense());
		vehicle.setType(updatedVehicle.getType());
		vehicle.setOwner(updatedVehicle.getOwner());
		vehicle.setLot(updatedVehicle.getLot());
	
		Vehicle updatedvehicleObj = vehicleRepository.save(vehicle);
		return VehicleMapper.mapToVehicleDto(updatedvehicleObj);
	}

	@Override
	public void deleteVehicle(Long lot) {
		Vehicle vehicle = vehicleRepository.findById(lot).orElseThrow(
				() -> new ResourceNotFoundException("vehicle does not exists with given lot : " + lot));
		vehicleRepository.deleteById(lot);
	}

}
