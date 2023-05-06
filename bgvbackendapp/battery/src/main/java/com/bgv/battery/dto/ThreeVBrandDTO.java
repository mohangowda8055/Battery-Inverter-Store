package com.bgv.battery.dto;

import com.bgv.battery.model.ThreeVBrand;

public class ThreeVBrandDTO {

    private int id;
	
	private String brandName;
	
	public ThreeVBrandDTO() {
		
	}

	public ThreeVBrandDTO(String brandName) {
		this.brandName = brandName;
	}
	
	public ThreeVBrandDTO(ThreeVBrand threeVBrand) {
		this.setId(threeVBrand.getId());
		this.setBrandName(threeVBrand.getBrandName());
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
		return "ThreeVBrandDTO [id=" + id + ", brandName=" + brandName + "]";
	}

}
