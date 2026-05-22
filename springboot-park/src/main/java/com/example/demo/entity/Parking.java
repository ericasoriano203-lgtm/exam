package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parking")
public class Parking {


	
	@Id
	@Column(name = "lot_id", nullable = false, unique = true)
	private Long lot;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "capacity")
	private Long capacity;
	
	@Column(name = "space")
	private Long space;
	
	@Column(name = "cost")
	private Long cost;
}
