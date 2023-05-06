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
@Table(name="inverter")
public class Inverter {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="inv_id")
	private Integer id;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="model")
	private String model;
	
	@Column(name="warranty")
	private int warranty;
	
	@Column(name="no_battery_req")
	private int noBatteryReq;
	
	@Column(name="price")
	private double price;
	
	@Column(name="image")
	private String image;
	
	@Column(name="inverter_type")
	private String inverterType;
	
	@Column(name="recom_bat_capacity")
	private String recomBatteryCapacity;
	
	@Column(name="nominal_voltage")
	private int nominalVoltage;
	
	@Column(name="stock")
	private int stock;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="capacity_id")
	private InvCapacity invCapacity;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="inverter_inv_battery", 
			joinColumns=@JoinColumn(name="inv_id"), 
			inverseJoinColumns=@JoinColumn(name="battery_id")
			)
	private List<InvBattery> invBattery = new ArrayList<>();
	
	public Inverter() {
		
	}

	public Inverter(String brand, String model, int warranty, int noBatteryReq, double price, String image,
			String inverterType, String recomBatteryCapacity, int nominalVoltage, int stock, InvCapacity invCapacity,
			List<InvBattery> invBattery) {
		this.brand = brand;
		this.model = model;
		this.warranty = warranty;
		this.noBatteryReq = noBatteryReq;
		this.price = price;
		this.image = image;
		this.inverterType = inverterType;
		this.recomBatteryCapacity = recomBatteryCapacity;
		this.nominalVoltage = nominalVoltage;
		this.stock = stock;
		this.invCapacity = invCapacity;
		this.invBattery = invBattery;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public int getNoBatteryReq() {
		return noBatteryReq;
	}

	public void setNoBatteryReq(int noBatteryReq) {
		this.noBatteryReq = noBatteryReq;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getInverterType() {
		return inverterType;
	}

	public void setInverterType(String inverterType) {
		this.inverterType = inverterType;
	}

	public String getRecomBatteryCapacity() {
		return recomBatteryCapacity;
	}

	public void setRecomBatteryCapacity(String recomBatteryCapacity) {
		this.recomBatteryCapacity = recomBatteryCapacity;
	}

	public int getNominalVoltage() {
		return nominalVoltage;
	}

	public void setNominalVoltage(int nominalVoltage) {
		this.nominalVoltage = nominalVoltage;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public InvCapacity getInvCapacity() {
		return invCapacity;
	}

	public void setInvCapacity(InvCapacity invCapacity) {
		this.invCapacity = invCapacity;
	}

	public List<InvBattery> getInvBattery() {
		return invBattery;
	}

	public void setInvBattery(List<InvBattery> invBattery) {
		this.invBattery = invBattery;
	}
	
}
