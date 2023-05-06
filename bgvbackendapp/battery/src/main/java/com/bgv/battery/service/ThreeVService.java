package com.bgv.battery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bgv.battery.dto.ThreeVBatteryDTO;
import com.bgv.battery.dto.ThreeVBrandDTO;
import com.bgv.battery.dto.ThreeVModelDTO;

@Service
public interface ThreeVService {

	public List<ThreeVBrandDTO> listBrand();
	
	public List<ThreeVModelDTO> listModel(Integer brandId);
	
	public List<ThreeVBatteryDTO> listBattery(Integer modelId );
}
