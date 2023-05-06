package com.bgv.battery.dto;

import com.bgv.battery.model.CommerVSegment;

public class CommerVSegmentDTO {

	private int id;
	
	private String segmentName;
	
	private int brandId;
	
	public CommerVSegmentDTO() {
		
	}

	public CommerVSegmentDTO(String segmentName, int brandId) {
		this.segmentName = segmentName;
		this.brandId = brandId;
	}
	
	public CommerVSegmentDTO(CommerVSegment commerVSegment) {
		this.setId(commerVSegment.getId());
		this.setSegmentName(commerVSegment.getSegmentName());
		this.setBrandId(commerVSegment.getCommerVBrand().getId());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSegmentName() {
		return segmentName;
	}

	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	
}
