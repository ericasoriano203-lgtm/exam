package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingDto {


	private Long lot;
	
	private String location;
	
	private Long capacity;
	
	private Long space;
	
	private Long cost;

}
