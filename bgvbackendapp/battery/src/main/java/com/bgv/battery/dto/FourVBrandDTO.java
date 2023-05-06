package com.bgv.battery.dto;

import java.util.ArrayList;
import java.util.List;

import com.bgv.battery.model.FourVBrand;
import com.bgv.battery.model.FourVModel;

public class FourVBrandDTO {

	private int id;
	
	private String brandName;
	
	private List<Integer> modelId;
	
	public FourVBrandDTO() {
		
	}

	public FourVBrandDTO(String brandName, List<Integer> modelId) {
		this.brandName = brandName;
		this.modelId = modelId;
	}
	
	public FourVBrandDTO(FourVBrand fourVBrand) {
		this.setId(fourVBrand.getId());
		this.setBrandName(fourVBrand.getBrandName());
		List<Integer> id= new ArrayList<>();
		List<FourVModel> fourVModels= fourVBrand.getFourVModel();
		for(FourVModel fourVModel: fourVModels ) {
			id.add(fourVModel.getId());
		}
		this.setModelId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public List<Integer> getModelId() {
		return modelId;
	}

	public void setModelId(List<Integer> modelId) {
		this.modelId = modelId;
	}

	@Override
	public String toString() {
		return "FourVBrandDTO [id=" + id + ", brandName=" + brandName + ", modelId=" + modelId + "]";
	}
	
}
