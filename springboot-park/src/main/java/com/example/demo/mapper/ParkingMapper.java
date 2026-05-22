package com.example.demo.mapper;

import com.example.demo.dto.VehicleDto;
import com.example.demo.dto.ParkingDto;
import com.example.demo.entity.Vehicle;
import com.example.demo.entity.Parking;

public class ParkingMapper {
	
	public static ParkingDto mapToParkingDto(Parking parking) {
//	    VehicleDto callForward = new VehicleDto(
//	            parking.getCallForwardNoReply().isProvisioned(),
//	            parking.getCallForwardNoReply().getDestination()
//	    );
//	    FeaturesDto features = new FeaturesDto(callForward);
//		return new ParkingDto(
//				parking.getPhoneNumber(),
//				parking.getUserName(),
//				parking.getPassword(),
//				parking.getDomain(),
//				parking.getStatus(),
//				features
//				);
		return new ParkingDto(
					parking.getLot(),
					parking.getLocation(),
					parking.getCapacity(),
					parking.getSpace(),
					parking.getCost()
				);
	}
	
	public static Parking mapToParking(ParkingDto parkingDto) {
		
		
		return new Parking(
				parkingDto.getLot(),
				parkingDto.getLocation(),
				parkingDto.getCapacity(),
				parkingDto.getSpace(),
				parkingDto.getCost()
		);
		
//	    Parking parking = new Parking();
//	    parking.setPhoneNumber(parkingDto.getPhoneNumber());
//	    parking.setUserName(parkingDto.getUserName());
//	    parking.setPassword(parkingDto.getPassword());
//	    parking.setDomain(parkingDto.getDomain());
//	    parking.setStatus(parkingDto.getStatus());
//	    
//	    Vehicle callForward = new Vehicle();
//		callForward.setSubscriber(parking);
//		callForward.setProvisioned(parkingDto.getFeatures().getCallForwardNoReply().isProvisioned());
//	    callForward.setDestination(parkingDto.getFeatures().getCallForwardNoReply().getDestination());
//	    parking.setCallForwardNoReply(callForward);
//
//	    return parking;
	}

}
