package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ParkingDto;
import com.example.demo.service.ParkingService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/smartpark/parking")
public class ParkingController {
	
	private ParkingService parkingService;
	
	// Get All Subscribers
	@GetMapping
	public ResponseEntity<List<ParkingDto>> getAllParking(){
			List<ParkingDto> parking = parkingService.getAllParking();
			return ResponseEntity.ok(parking);
	}
	
	// Add Parking
	@PostMapping
	public ResponseEntity<ParkingDto> createParking(@RequestBody ParkingDto parkingDto){
		ParkingDto savedParking = parkingService.createParking(parkingDto);
		return new ResponseEntity<>(savedParking, HttpStatus.CREATED);
	}
	
	// Get Parking
	@GetMapping("{lot}")
	public ResponseEntity<ParkingDto> getParkingByLot(@PathVariable("lot")Long lot){
		ParkingDto parkingDto = parkingService.getParkingByLot(lot);
		return ResponseEntity.ok(parkingDto);
	}
	
	
	// Update Parking
	@PutMapping("{lot}")
	public ResponseEntity<ParkingDto> updateParking(@PathVariable("lot") Long lot, @RequestBody ParkingDto updatedParking){
		ParkingDto parkingDto = parkingService.updateParking(lot, updatedParking);
		return ResponseEntity.ok(parkingDto);
	}
	
	// Delete Parking
	@DeleteMapping("{lot}")
	public ResponseEntity<String> deleteParkingByLot(@PathVariable("lot")Long lot){
		parkingService.deleteParking(lot);
		return ResponseEntity.ok("Parking Deleted Successfully");
	}
	
}
