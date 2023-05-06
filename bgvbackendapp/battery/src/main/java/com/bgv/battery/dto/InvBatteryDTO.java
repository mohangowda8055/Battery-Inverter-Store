package com.bgv.battery.dto;

import com.bgv.battery.model.InvBattery;

public class InvBatteryDTO {

    private Integer id;
	
	private String batteryModelName;
	
	private String brand;
	
	private String series;

	private int voltage;
	
	private int ah;
	
	private String terminalLayout;
	
	private String image;
	
	private int guarantee;

	private int warranty;
	
	private double mrp;
	
	private double rebate;
	
	private int stock;
	
	private double backupDuration;
	
	private int totalWarranty;
	
	public InvBatteryDTO() {
		
	}

		public InvBatteryDTO(String batteryModelName, String brand, String series, int voltage, int ah,
			String terminalLayout, String image, int guarantee, int warranty, double mrp, double rebate, int stock,
			double backupDuration, int totalWarranty) {
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
		this.stock = stock;
		this.backupDuration = backupDuration;
		this.totalWarranty = totalWarranty;
	}

		public InvBatteryDTO(InvBattery invBattery) {
		this.setId(invBattery.getId());
		this.setBatteryModelName(invBattery.getBatteryModelName());
		this.setBrand(invBattery.getBrand());
		this.setSeries(invBattery.getSeries());
		this.setVoltage(invBattery.getVoltage());
		this.setAh(invBattery.getAh());
		this.setTerminalLayout(invBattery.getTerminalLayout());
		this.setImage(invBattery.getImage());
		this.setGuarantee(invBattery.getGuarantee());
		this.setWarranty(invBattery.getWarranty());
		this.setMrp(invBattery.getMrp());
		this.setRebate(invBattery.getRebate());
		this.setStock(invBattery.getStock());
		this.setBackupDuration(invBattery.getBackupDurations().getBackupDuration());
		this.setTotalWarranty(invBattery.getInvBatteryWarranties().getTotalWarranty());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getRebate() {
		return rebate;
	}

	public void setRebate(double rebate) {
		this.rebate = rebate;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getBackupDuration() {
		return backupDuration;
	}

	public void setBackupDuration(double backupDuration) {
		this.backupDuration = backupDuration;
	}

	public int getTotalWarranty() {
		return totalWarranty;
	}

	public void setTotalWarranty(int totalWarranty) {
		this.totalWarranty = totalWarranty;
	}
	
}
