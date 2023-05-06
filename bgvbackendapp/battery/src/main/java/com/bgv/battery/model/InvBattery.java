package com.bgv.battery.model;

import java.util.ArrayList;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="inv_battery")
public class InvBattery {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="battery_id")
	private Integer id;
	
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
	private double mrp;
	
	@Column(name="rebate")
	private double rebate;
	
	@Column(name="stock")
	private int stock;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="backup_duration_id")
	private BackupDuration backupDurations;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="warranty_id")
	private InvBatteryWarranty invBatteryWarranties;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="inverter_inv_battery", 
			joinColumns=@JoinColumn(name="battery_id"), 
			inverseJoinColumns=@JoinColumn(name="inv_id")
			)
	private List<Inverter> inverter = new ArrayList<>();
	
	public InvBattery() {
		
	}

	public InvBattery(String batteryModelName, String brand, String series, int voltage, int ah, String terminalLayout,
			String image, int guarantee, int warranty, double mrp, double rebate, int stock,
			BackupDuration backupDurations, InvBatteryWarranty invBatteryWarranties, List<Inverter> inverter) {
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
		this.backupDurations = backupDurations;
		this.invBatteryWarranties = invBatteryWarranties;
		this.inverter = inverter;
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

	public BackupDuration getBackupDurations() {
		return backupDurations;
	}

	public void setBackupDuartions(BackupDuration backupDurations) {
		this.backupDurations = backupDurations;
	}

	public InvBatteryWarranty getInvBatteryWarranties() {
		return invBatteryWarranties;
	}

	public void setInvBatteryWarranties(InvBatteryWarranty invBatteryWarranties) {
		this.invBatteryWarranties = invBatteryWarranties;
	}

	public List<Inverter> getInverter() {
		return inverter;
	}

	public void setInverter(List<Inverter> inverter) {
		this.inverter = inverter;
	}

}
