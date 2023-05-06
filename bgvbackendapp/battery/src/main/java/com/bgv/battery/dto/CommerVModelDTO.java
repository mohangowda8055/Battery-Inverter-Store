package com.bgv.battery.dto;

import com.bgv.battery.model.CommerVModel;

public class CommerVModelDTO {

	private int id;
	
	private String modelName;
	
	private int segmentId;
	
	public CommerVModelDTO() {
		
	}

	public CommerVModelDTO(String modelName, int segmentId) {
		this.modelName = modelName;
		this.segmentId = segmentId;
	}

	public CommerVModelDTO(CommerVModel commerVModel) {
		this.setId(commerVModel.getId());
		this.setModelName(commerVModel.getModelName());
		this.setSegmentId(commerVModel.getCommerVSegment().getId());
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

	public int getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(int segmentId) {
		this.segmentId = segmentId;
	}	
}
