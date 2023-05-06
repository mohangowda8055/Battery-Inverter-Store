package com.bgv.battery.dto;

import java.util.ArrayList;
import java.util.List;

import com.bgv.battery.model.FourVBattery;
import com.bgv.battery.model.FourVModel;

public class FourVBatteryDTO {

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
	
	private int fuelId;
	
	private int stock;
	
	private List<Integer> modelId;
	
	public FourVBatteryDTO() {
		
	}

	public FourVBatteryDTO(String batteryModelName, String brand, String series, int voltage, int ah,
			String terminalLayout, String image, int guarantee, int warranty, double mrp, double rebate, int stock, int fuelId,
			List<Integer> modelId) {
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
		this.fuelId = fuelId;
		this.modelId = modelId;
	}

	public FourVBatteryDTO(FourVBattery fourVBattery) {
		this.setId(fourVBattery.getId());
		this.setBatteryModelName(fourVBattery.getBatteryModelName());
		this.setBrand(fourVBattery.getBrand());
		this.setSeries(fourVBattery.getSeries());
		this.setVoltage(fourVBattery.getVoltage());
		this.setAh(fourVBattery.getAh());
		this.setTerminalLayout(fourVBattery.getTerminalLayout());
		this.setImage(fourVBattery.getImage());
		this.setGuarantee(fourVBattery.getGuarantee());
		this.setWarranty(fourVBattery.getWarranty());
		this.setMrp(fourVBattery.getMrp());
		this.setRebate(fourVBattery.getRebate());
		this.setStock(fourVBattery.getStock());
		this.setFuelId(fourVBattery.getFuelType().getId());
		List<Integer> id= new ArrayList<>();
		List<FourVModel> fourVModels= fourVBattery.getFourVModels();
		for(FourVModel fourVModel: fourVModels ) {
			id.add(fourVModel.getId());
		}
		this.setModelId(id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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

	public int getFuelId() {
		return fuelId;
	}

	public void setFuelId(int fuelId) {
		this.fuelId = fuelId;
	}

	public List<Integer> getModelId() {
		return modelId;
	}

	public void setModelId(List<Integer> modelId) {
		this.modelId = modelId;
	}

}
