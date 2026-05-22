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

import com.example.demo.dto.VehicleDto;
import com.example.demo.service.VehicleService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/smartpark/vehicle")
public class VehicleController {
	
	private VehicleService vehicleService;
	
	// Get All Subscribers
	@GetMapping
	public ResponseEntity<List<VehicleDto>> getAllVehicle(){
			List<VehicleDto> vehicle = vehicleService.getAllVehicle();
			return ResponseEntity.ok(vehicle);
	}
	
	// Add Vehicle
	@PostMapping
	public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto){
		VehicleDto savedVehicle = vehicleService.createVehicle(vehicleDto);
		return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
	}
	
	// Get Vehicle
	@GetMapping("{lot}")
	public ResponseEntity<VehicleDto> getVehicleByLot(@PathVariable("lot")Long lot){
		VehicleDto vehicleDto = vehicleService.getVehicleByLot(lot);
		return ResponseEntity.ok(vehicleDto);
	}
	
	
	// Update Vehicle
	@PutMapping("{lot}")
	public ResponseEntity<VehicleDto> updateVehicle(@PathVariable("lot") Long lot, @RequestBody VehicleDto updatedVehicle){
		VehicleDto vehicleDto = vehicleService.updateVehicle(lot, updatedVehicle);
		return ResponseEntity.ok(vehicleDto);
	}
	
	// Delete Vehicle
	@DeleteMapping("{phoneNumber}")
	public ResponseEntity<String> deleteVehicleByLot(@PathVariable("lot")Long lot){
		vehicleService.deleteVehicle(lot);
		return ResponseEntity.ok("Vehicle Deleted Successfully");
	}
	
}
