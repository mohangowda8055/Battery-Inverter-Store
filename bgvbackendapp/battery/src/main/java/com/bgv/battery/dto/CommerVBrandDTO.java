package com.bgv.battery.dto;

import com.bgv.battery.model.CommerVBrand;

public class CommerVBrandDTO {

    private int id;
	
	private String brandName;
	
	public CommerVBrandDTO() {
		
	}

	public CommerVBrandDTO(String brandName) {
		this.brandName = brandName;
	}
	
	public CommerVBrandDTO(CommerVBrand commerVBrand) {
		this.setId(commerVBrand.getId());
		this.setBrandName(commerVBrand.getBrandName());
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
		return "CommerVBrandDTO [id=" + id + ", brandName=" + brandName + "]";
	}
	
}
