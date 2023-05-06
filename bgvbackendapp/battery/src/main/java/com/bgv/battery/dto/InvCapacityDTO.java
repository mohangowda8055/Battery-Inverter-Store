package com.bgv.battery.dto;

import com.bgv.battery.model.InvCapacity;

public class InvCapacityDTO {

	private int id;
	
	private int capacity;
	
	public InvCapacityDTO() {
		
	}

	public InvCapacityDTO(int capacity) {
		this.capacity = capacity;
	}
	
	public InvCapacityDTO(InvCapacity invCapacity) {
		this.setId(invCapacity.getId());
		this.setCapacity(invCapacity.getCapacity());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "InvCapacityDTO [id=" + id + ", capacity=" + capacity + "]";
	}
}
