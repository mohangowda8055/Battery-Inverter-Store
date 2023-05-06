package com.bgv.battery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bgv.battery.dto.FourVBatteryDTO;
import com.bgv.battery.dto.FourVBrandDTO;
import com.bgv.battery.dto.FourVModelDTO;
import com.bgv.battery.model.FuelType;

@Service
public interface FourVService {

	public List<FourVBrandDTO> listBrand();
	
	public List<FourVModelDTO> listModel(Integer brandID);
	
	public List<FuelType> listFuelType();
	
	public List<FourVBatteryDTO> listBattery(Integer fuelId, Integer modelId);
	
	public FourVBatteryDTO getBattery(Integer batteryId);
}
