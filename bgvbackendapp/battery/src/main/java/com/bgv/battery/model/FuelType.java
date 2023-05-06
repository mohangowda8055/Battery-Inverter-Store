package com.bgv.battery.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="fuel_type")
public class FuelType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fuel_id")
	private Integer id;
	
	@Column(name="fuel_type")
	private String fuelType;
	
	public FuelType() {
		
	}

	public FuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

}
