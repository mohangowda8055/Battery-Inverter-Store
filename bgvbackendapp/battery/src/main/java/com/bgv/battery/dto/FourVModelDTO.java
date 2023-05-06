package com.bgv.battery.dto;

import com.bgv.battery.model.FourVModel;

public class FourVModelDTO {

	private int id;
	
	private String modelName;
	
	private int brandId;
	
	public FourVModelDTO() {
		
	}

	public FourVModelDTO(String modelName, int brandId) {
		this.modelName = modelName;
		this.brandId = brandId;
	}
	
	public FourVModelDTO(FourVModel fourVModel) {
		this.setId(fourVModel.getId());
		this.setModelName(fourVModel.getModelName());
		this.setBrandId(fourVModel.getFourVBrand().getId());
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

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	
	
	
}
