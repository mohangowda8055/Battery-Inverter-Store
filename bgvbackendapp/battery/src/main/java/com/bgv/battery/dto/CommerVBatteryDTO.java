package com.bgv.battery.dto;

import com.bgv.battery.model.CommerVBattery;

public class CommerVBatteryDTO {

	private int id;
	
	private String batteryModelName;
	
	private String brand;
	
	private String series;
	
	private int voltage;
	
	private int ah;
	
	private String terminalLayout;
	
	private String image;
	
	private int guarantee;
	
	private int warranty;
	
	private int mrp;
	
	private int rebate;
	
	private int modelId;
	
	public CommerVBatteryDTO() {
		
	}

	public CommerVBatteryDTO(String batteryModelName, String brand, String series, int voltage, int ah,
			String terminalLayout, String image, int guarantee, int warranty, int mrp, int rebate, int modelId) {
		this.batteryModelName = batteryModelName;
		this.brand = brand;
		this.series = series;
		this.voltage = voltage;
		this.ah = ah;
		this.terminalLayout = terminalLayout;
		this.image = image;
		this.guarantee = guarantee;
		this.warranty = warranty;
		this.mrp = mrp;
		this.rebate = rebate;
		this.modelId = modelId;
	}

	public CommerVBatteryDTO(CommerVBattery commerVBattery) {
		this.setId(commerVBattery.getId());
		this.setBatteryModelName(commerVBattery.getBatteryModelName());
		this.setBrand(commerVBattery.getBrand());
		this.setSeries(commerVBattery.getSeries());
		this.setVoltage(commerVBattery.getVoltage());
		this.setAh(commerVBattery.getAh());
		this.setTerminalLayout(commerVBattery.getTerminalLayout());
		this.setImage(commerVBattery.getImage());
		this.setGuarantee(commerVBattery.getGuarantee());
		this.setWarranty(commerVBattery.getWarranty());
		this.setMrp(commerVBattery.getMrp());
		this.setRebate(commerVBattery.getRebate());
		this.setModelId(commerVBattery.getCommerVModel().getId());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBatteryModelName() {
		return batteryModelName;
	}

	public void setBatteryModelName(String batteryModelName) {
		this.batteryModelName = batteryModelName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public int getVoltage() {
		return voltage;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	public int getAh() {
		return ah;
	}

	public void setAh(int ah) {
		this.ah = ah;
	}

	public String getTerminalLayout() {
		return terminalLayout;
	}

	public void setTerminalLayout(String terminalLayout) {
		this.terminalLayout = terminalLayout;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(int guarantee) {
		this.guarantee = guarantee;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public int getMrp() {
		return mrp;
	}

	public void setMrp(int mrp) {
		this.mrp = mrp;
	}

	public int getRebate() {
		return rebate;
	}

	public void setRebate(int rebate) {
		this.rebate = rebate;
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	
	
}
