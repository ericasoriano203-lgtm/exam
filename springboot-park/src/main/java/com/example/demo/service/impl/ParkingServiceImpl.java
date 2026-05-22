package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ParkingDto;
import com.example.demo.entity.Vehicle;
import com.example.demo.entity.Parking;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.ParkingMapper;
import com.example.demo.repository.ParkingRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ParkingService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ParkingServiceImpl implements ParkingService{
	
	private ParkingRepository parkingRepository;
	


	@Override
	public List<ParkingDto> getAllParking() {
		List<Parking> parkings = parkingRepository.findAll();
		return parkings.stream().map((parking) -> ParkingMapper.mapToParkingDto(parking))
				.collect(Collectors.toList());
	}

	
	@Override
	public ParkingDto createParking(ParkingDto parkingDto) {
		Parking parking = ParkingMapper.mapToParking(parkingDto);
		Parking savedParking = parkingRepository.save(parking);
		return ParkingMapper.mapToParkingDto(savedParking);
	}


	@Override
	public ParkingDto getParkingByLot(Long lot) {
		Parking parking = parkingRepository.findById(lot)
		.orElseThrow(() -> new ResourceNotFoundException("Parking does not exist with given lot : " + lot));
		return ParkingMapper.mapToParkingDto(parking);
	}

	@Override
	public ParkingDto updateParking(Long lot, ParkingDto updatedParking) {
		Parking parking = parkingRepository.findById(lot).orElseThrow(
				() -> new ResourceNotFoundException("Parking does not exists with given lot : " + lot));		
		
		parking.setLot(updatedParking.getLot());
		parking.setLocation(updatedParking.getLocation());
		parking.setCapacity(updatedParking.getCapacity());
		parking.setSpace(updatedParking.getSpace());
		parking.setCost(updatedParking.getCost());
		Parking updatedParkingObj = parkingRepository.save(parking);
		return ParkingMapper.mapToParkingDto(updatedParkingObj);
	}

	@Override
	public void deleteParking(Long lot) {
		Parking parking = parkingRepository.findById(lot).orElseThrow(
				() -> new ResourceNotFoundException("Parking does not exists with given lot : " + lot));
		parkingRepository.deleteById(lot);
	}

}
