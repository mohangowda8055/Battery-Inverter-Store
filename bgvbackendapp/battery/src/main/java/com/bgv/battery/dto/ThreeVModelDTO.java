package com.bgv.battery.dto;

import com.bgv.battery.model.ThreeVModel;

public class ThreeVModelDTO {

	private int id;
	
	private String modelName;
	
	private int brandId;
	
	public ThreeVModelDTO() {
		
	}

	public ThreeVModelDTO(String modelName, int brandId) {
		this.modelName = modelName;
		this.brandId = brandId;
	}
	
	public ThreeVModelDTO(ThreeVModel threeVModel) {
		this.setId(threeVModel.getId());
		this.setModelName(threeVModel.getModelName());
		this.setBrandId(threeVModel.getThreeVBrand().getId());
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
