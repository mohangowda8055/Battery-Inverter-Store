package com.bgv.battery.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="inv_capacity")
public class InvCapacity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="capacity_id")
	private Integer id;
	
	@Column(name="capacity")
	private int capacity;
	
	@OneToMany(mappedBy="invCapacity", fetch=FetchType.LAZY)
	private List<Inverter> inverter;
	
	public InvCapacity() {
		
	}

	public InvCapacity(int capacity) {
		this.capacity = capacity;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Inverter> getInverter() {
		return inverter;
	}

	public void setInverter(List<Inverter> inverter) {
		this.inverter = inverter;
	}

}
