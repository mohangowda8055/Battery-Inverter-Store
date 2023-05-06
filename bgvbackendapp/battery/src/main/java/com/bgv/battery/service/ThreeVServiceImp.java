package com.bgv.battery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgv.battery.dto.ThreeVBatteryDTO;
import com.bgv.battery.dto.ThreeVBrandDTO;
import com.bgv.battery.dto.ThreeVModelDTO;
import com.bgv.battery.model.ThreeVBattery;
import com.bgv.battery.model.ThreeVBrand;
import com.bgv.battery.model.ThreeVModel;
import com.bgv.battery.repository.ThreeVBatteryRepo;
import com.bgv.battery.repository.ThreeVBrandRepo;
import com.bgv.battery.repository.ThreeVModelRepo;

@Service
public class ThreeVServiceImp implements ThreeVService {

	@Autowired
	private ThreeVBrandRepo threeVBrandRepo;
	
	@Autowired
	private ThreeVModelRepo threeVModelRepo;
	
	@Autowired
	private ThreeVBatteryRepo threeVBatteryRepo;
	
	@Override
	public List<ThreeVBrandDTO> listBrand() {
		return threeVBrandRepo.findAll().stream().map(this::convertEntityToBrandDto).collect(Collectors.toList());
	}

	private ThreeVBrandDTO convertEntityToBrandDto(ThreeVBrand threeVBrand) {
		ThreeVBrandDTO threeVBrandDTO = new ThreeVBrandDTO(threeVBrand);
		return threeVBrandDTO;
		
	}
	
	@Override
	public List<ThreeVModelDTO> listModel(Integer brandId){
		return threeVModelRepo.findByBrandId(brandId).stream().map(this::convertEntityToModelDto).collect(Collectors.toList());
	}
	
	private ThreeVModelDTO convertEntityToModelDto(ThreeVModel threeVModel) {
		ThreeVModelDTO threeVModelDTO = new ThreeVModelDTO(threeVModel);
		return threeVModelDTO;
	}

	@Override
	public List<ThreeVBatteryDTO> listBattery(Integer modelId) {
		return threeVBatteryRepo.findByModelId(modelId).stream().map(this::convertEntityToBatteryDto).collect(Collectors.toList());
	}
	
	private ThreeVBatteryDTO convertEntityToBatteryDto(ThreeVBattery threeVBattery) {
		ThreeVBatteryDTO threeVBatteryDTO = new ThreeVBatteryDTO(threeVBattery);
		return threeVBatteryDTO;
	}
}
