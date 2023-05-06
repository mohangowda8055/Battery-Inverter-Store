package com.bgv.battery.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="four_v_model")
public class FourVModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="model_id")
	private Integer id;
	
	@Column(name="model_name")
	private String modelName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="brand_id")
	private FourVBrand fourVBrand;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="four_v_battery_model", 
			joinColumns=@JoinColumn(name="model_id"), 
			inverseJoinColumns=@JoinColumn(name="battery_id")
			)
	private List<FourVBattery> fourVBattery = new ArrayList<>();
	
	public FourVModel() {
		
	}
	
	public FourVModel(String modelName, FourVBrand fourVBrand, List<FourVBattery> fourVBattery) {
		this.modelName = modelName;
		this.fourVBrand = fourVBrand;
		this.fourVBattery = fourVBattery;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public FourVBrand getFourVBrand() {
		return fourVBrand;
	}

	public void setFourVBrand(FourVBrand fourVBrand) {
		this.fourVBrand = fourVBrand;
	}

	public List<FourVBattery> getFourVBattery() {
		return fourVBattery;
	}

	public void setFourVBattery(List<FourVBattery> fourVBattery) {
		this.fourVBattery = fourVBattery;
	}

}
