package com.bgv.battery.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="commer_v_battery")
public class CommerVBattery {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="battery_id")
	private int id;
	
	@Column(name="battery_model_name")
	private String batteryModelName;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="series")
	private String series;
	
	@Column(name="voltage")
	private int voltage;
	
	@Column(name="AH")
	private int ah;
	
	@Column(name="terminal_layout")
	private String terminalLayout;
	
	@Column(name="image")
	private String image;
	
	@Column(name="guarantee")
	private int guarantee;
	
	@Column(name="warranty")
	private int warranty;
	
	@Column(name="mrp")
	private int mrp;
	
	@Column(name="rebate")
	private int rebate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="model_id")
	private CommerVModel commerVModel;
	
	public CommerVBattery() {
		
	}

	public CommerVBattery(String batteryModelName, String brand, String series, int voltage, int ah,
			String terminalLayout, String image, int guarantee, int warranty, int mrp, int rebate,
			CommerVModel commerVModel) {
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
		this.commerVModel = commerVModel;
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

	public CommerVModel getCommerVModel() {
		return commerVModel;
	}

	public void setCommerVModel(CommerVModel commerVModel) {
		this.commerVModel = commerVModel;
	}

}
