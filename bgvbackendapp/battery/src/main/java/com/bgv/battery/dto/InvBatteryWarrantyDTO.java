package com.bgv.battery.dto;

import com.bgv.battery.model.InvBatteryWarranty;

public class InvBatteryWarrantyDTO {

    private Integer id;
	
	private int totalWarranty;
	
	public InvBatteryWarrantyDTO() {
		
	}

	public InvBatteryWarrantyDTO(int totalWarranty) {
		this.totalWarranty = totalWarranty;
	}
	
    public InvBatteryWarrantyDTO(InvBatteryWarranty warranty) {
		this.setId(warranty.getId());
		this.setTotalWarranty(warranty.getTotalWarranty());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTotalWarranty() {
		return totalWarranty;
	}

	public void setTotalWarranty(int totalWarranty) {
		this.totalWarranty = totalWarranty;
	}
	
}
