package com.bgv.battery.dto;

import com.bgv.battery.model.TwoVModel;

public class TwoVModelDTO {

	private Integer id;
	
	private String modelName;
	
	private Integer brandId;
	
	public TwoVModelDTO() {
		
	}

	public TwoVModelDTO(String modelName, int brandId) {
		this.modelName = modelName;
		this.brandId = brandId;
	}
	
	public TwoVModelDTO(TwoVModel twoVModel) {
		this.setId(twoVModel.getId());
		this.setModelName(twoVModel.getModelName());
		this.setBrandId(twoVModel.getTwoVBrand().getId());
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
