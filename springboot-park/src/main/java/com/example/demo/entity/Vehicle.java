package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
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
@Table(name = "vehicles")
public class Vehicle {
	
	
    @Id
    @Column(name = "license_plate", nullable = false, unique = true)
    private Long license;

	
	@Column(name = "type")
	private String type;
	
	@Column(name = "owner")
	private String owner;
	
	@Column(name = "lot_id")
	private Long lot;

}
