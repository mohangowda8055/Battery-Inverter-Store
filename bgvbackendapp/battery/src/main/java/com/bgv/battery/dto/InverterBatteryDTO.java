package com.bgv.battery.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bgv.battery.model.InvBattery;
import com.bgv.battery.model.Inverter;

public class InverterBatteryDTO {

    private int id;
	
	private String brand;
	
	private String model;
	
	private int warranty;
	
	private int noBatteryReq;
	
	private double price;
	
	private String image;
	
	private String inverterType;
	
	private String recomBatteryCapacity;
	
	private int nominalVoltage;
	
	private int stock;
	
	private int capacityId;
	
	private List<InvBatteryDTO> invBatteryDTO = new ArrayList<>();
	
	public InverterBatteryDTO() {
		
	}

	public InverterBatteryDTO(String brand, String model, int warranty, int noBatteryReq, double price, String image,
			String inverterType, String recomBatteryCapacity, int nominalVoltage, int stock, int capacityId,
			List<InvBatteryDTO> invBatteryDTO) {
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
		this.capacityId = capacityId;
		this.invBatteryDTO = invBatteryDTO;
	}
	
	public InverterBatteryDTO(Inverter inverter) {
		this.setId(inverter.getId());
		this.setBrand(inverter.getBrand());
		this.setModel(inverter.getModel());
		this.setWarranty(inverter.getWarranty());
		this.setNoBatteryReq(inverter.getNoBatteryReq());
		this.setPrice(inverter.getPrice());
		this.setImage(inverter.getImage());
		this.setInverterType(inverter.getInverterType());
		this.setRecomBatteryCapacity(inverter.getRecomBatteryCapacity());
		this.setNominalVoltage(inverter.getNominalVoltage());
		this.setStock(inverter.getStock());
		this.setCapacityId(inverter.getInvCapacity().getId());
		List<InvBatteryDTO> invbatt= new ArrayList<>();
		List<InvBatteryDTO> invbat = inverter.getInvBattery().stream().map(this::convertEntityToBatteryDto).collect(Collectors.toList());
		for(InvBatteryDTO bat: invbat) {
			InvBatteryDTO ib = new InvBatteryDTO();
			ib.setId(bat.getId());
			ib.setBrand(bat.getBrand());
			ib.setBatteryModelName(bat.getBatteryModelName());
			ib.setSeries(bat.getSeries());
			ib.setVoltage(bat.getVoltage());
			ib.setAh(bat.getAh());
			ib.setTerminalLayout(bat.getTerminalLayout());
			ib.setImage(bat.getImage());
			ib.setGuarantee(bat.getGuarantee());
			ib.setWarranty(bat.getWarranty());
			ib.setMrp(bat.getMrp());
			ib.setRebate(bat.getRebate());
			ib.setStock(bat.getStock());
			ib.setBackupDuration(bat.getBackupDuration());
			invbatt.add(ib);
		}
		this.setInvBatteryDTO(invbatt);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getCapacityId() {
		return capacityId;
	}

	public void setCapacityId(int capacityId) {
		this.capacityId = capacityId;
	}

	public List<InvBatteryDTO> getInvBatteryDTO() {
		return invBatteryDTO;
	}

	public void setInvBatteryDTO(List<InvBatteryDTO> invBatteryDTO) {
		this.invBatteryDTO = invBatteryDTO;
	}
	
	public InvBatteryDTO convertEntityToBatteryDto(InvBattery invBattery) {
		InvBatteryDTO invBatteryDTO = new InvBatteryDTO(invBattery);
		return invBatteryDTO;
	}
}
