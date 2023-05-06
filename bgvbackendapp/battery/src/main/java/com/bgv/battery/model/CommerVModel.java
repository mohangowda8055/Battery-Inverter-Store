package com.bgv.battery.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="commer_v_model")
public class CommerVModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="model_id")
	private int id;
	
	@Column(name="model_name")
	private String modelName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="segment_id")
	private CommerVSegment commerVSegment;
	
	@OneToMany(mappedBy="commerVModel", fetch=FetchType.LAZY)
	private List<CommerVBattery> commerVBattery;
	
	public CommerVModel() {
		
	}

	public CommerVModel(String modelName, CommerVSegment commerVSegment) {
		this.modelName = modelName;
		this.commerVSegment = commerVSegment;
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

	public CommerVSegment getCommerVSegment() {
		return commerVSegment;
	}

	public void setCommerVSegment(CommerVSegment commerVSegment) {
		this.commerVSegment = commerVSegment;
	}

	public List<CommerVBattery> getCommerVBattery() {
		return commerVBattery;
	}

	public void setCommerVBattery(List<CommerVBattery> commerVBattery) {
		this.commerVBattery = commerVBattery;
	}

}
