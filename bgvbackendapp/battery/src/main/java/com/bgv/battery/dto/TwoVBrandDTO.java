package com.bgv.battery.dto;

import com.bgv.battery.model.TwoVBrand;

public class TwoVBrandDTO {

	private int id;
	
	private String brandName;
	
	public TwoVBrandDTO() {
		
	}

	public TwoVBrandDTO(String brandName) {
		this.brandName = brandName;
	}
	
	public TwoVBrandDTO(TwoVBrand twoVBrand) {
		this.setId(twoVBrand.getId());
		this.setBrandName(twoVBrand.getBrandName());
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

	@Override
	public String toString() {
		return "TwoVBrandDTO [id=" + id + ", brandName=" + brandName + "]";
	}
	
}
