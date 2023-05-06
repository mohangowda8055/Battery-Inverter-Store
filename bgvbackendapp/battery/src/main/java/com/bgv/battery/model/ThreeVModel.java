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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="three_v_model")
public class ThreeVModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="model_id")
	private Integer id;
	
	@Column(name="model_name")
	private String modelName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="brand_id")
	private ThreeVBrand threeVBrand;
	
	@ManyToMany(mappedBy="threeVModels", fetch=FetchType.LAZY)
	private List<ThreeVBattery> threeVBatteries = new ArrayList<>();
	
	public ThreeVModel() {
		
	}

	public ThreeVModel(String modelName, ThreeVBrand threeVBrand, List<ThreeVBattery> threeVBatteries) {
		this.modelName = modelName;
		this.threeVBrand = threeVBrand;
		this.threeVBatteries = threeVBatteries;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public ThreeVBrand getThreeVBrand() {
		return threeVBrand;
	}

	public void setThreeVBrand(ThreeVBrand threeVBrand) {
		this.threeVBrand = threeVBrand;
	}

	public List<ThreeVBattery> getThreeVBatteries() {
		return threeVBatteries;
	}

	public void setThreeVBatteries(List<ThreeVBattery> threeVBatteries) {
		this.threeVBatteries = threeVBatteries;
	}

}
