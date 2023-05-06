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
@Table(name="two_v_model")
public class TwoVModel {

	//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="model_id")
	private Integer id;
	
	@Column(name="model_name")
	private String modelName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="brand_id")
	private TwoVBrand twoVBrand; 
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="two_v_battery_model", 
			joinColumns=@JoinColumn(name="model_id"), 
			inverseJoinColumns=@JoinColumn(name="battery_id")
			)
	private List<TwoVBattery> twoVBatteries = new ArrayList<>();
	
	public TwoVModel(){
		
	}

	public TwoVModel(String modelName, TwoVBrand twoVBrand, List<TwoVBattery> twoVBatteries) {
		this.modelName = modelName;
		this.twoVBrand = twoVBrand;
		this.twoVBatteries = twoVBatteries;
	}

	public void addBattery(TwoVBattery twoVBattery) {
		twoVBatteries.add(twoVBattery);
	}
	
	public void removeBattery(TwoVBattery twoVBattery) {
		twoVBatteries.remove(twoVBattery);
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

	public TwoVBrand getTwoVBrand() {
		return twoVBrand;
	}

	public void setTwoVBrand(TwoVBrand twoVBrand) {
		this.twoVBrand = twoVBrand;
	}


	public List<TwoVBattery> getTwoVBatteries() {
		return twoVBatteries;
	}

	public void setTwoVBatteries(List<TwoVBattery> twoVBatteries) {
		this.twoVBatteries = twoVBatteries;
	}

	@Override
	public String toString() {
		return "TwoVModel [id=" + id + ", modelName=" + modelName + ", twoVBrand=" + twoVBrand + ", twoVBatteries="
				+ twoVBatteries + "]";
	}

	
}
