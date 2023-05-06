package com.bgv.battery.dto;

import java.util.ArrayList;
import java.util.List;

import com.bgv.battery.model.TwoVBattery;
import com.bgv.battery.model.TwoVModel;

public class TwoVBatteryDTO {
	
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
	
	private int stock;
	
	private List<Integer> modelId;
	
	public TwoVBatteryDTO() {
		
	}

	public TwoVBatteryDTO(String batteryModelName, String brand, String series, int voltage, int ah,
			String terminalLayout, String image, int guarantee, int warranty, int mrp, int rebate,int stock,
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
		this.stock=stock;
		this.modelId = modelId;
	}

	public TwoVBatteryDTO(TwoVBattery twoVBattery) {
		this.setId(twoVBattery.getId());
		this.setBatteryModelName(twoVBattery.getBatteryModelName());
		this.setBrand(twoVBattery.getBrand());
		this.setSeries(twoVBattery.getSeries());
		this.setVoltage(twoVBattery.getVoltage());
		this.setAh(twoVBattery.getAh());
		this.setTerminalLayout(twoVBattery.getTerminalLayout());
		this.setImage(twoVBattery.getImage());
		this.setGuarantee(twoVBattery.getGuarantee());
		this.setWarranty(twoVBattery.getWarranty());
		this.setMrp(twoVBattery.getMrp());
		this.setRebate(twoVBattery.getRebate());
	    this.setStock(twoVBattery.getStock());
		List<Integer> id= new ArrayList<>();
		List<TwoVModel> twoVModels= twoVBattery.getTwoVModels();
		for(TwoVModel twoVModel: twoVModels ) {
			id.add(twoVModel.getId());
		}
		this.setModelId(id);
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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

	public List<Integer> getModelId() {
		return modelId;
	}

	public void setModelId(List<Integer> modelId) {
		this.modelId = modelId;
	}

}
