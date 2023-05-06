package com.bgv.battery.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgv.battery.dto.FourVBatteryDTO;
import com.bgv.battery.dto.FourVBrandDTO;
import com.bgv.battery.dto.FourVModelDTO;
import com.bgv.battery.exceptions.ResourceNotFoundException;
import com.bgv.battery.model.FourVBattery;
import com.bgv.battery.model.FourVBrand;
import com.bgv.battery.model.FourVModel;
import com.bgv.battery.model.FuelType;
import com.bgv.battery.repository.FourVBatteryRepo;
import com.bgv.battery.repository.FourVBrandRepo;
import com.bgv.battery.repository.FourVModelRepo;
import com.bgv.battery.repository.FuelTypeRepo;

@Service
public class FourVServiceImp implements FourVService {

	@Autowired
	private FourVBrandRepo fourVBrandRepo;
	
	@Autowired
	private FourVModelRepo fourVModelRepo;
	
	@Autowired
	private FuelTypeRepo fuelTypeRepo;
	
	@Autowired
	private FourVBatteryRepo fourVBatteryRepo;
	
	@Override
	public List<FourVBrandDTO> listBrand() {
		return fourVBrandRepo.findAll().stream().map(this::convertEntityToBrandDto).collect(Collectors.toList());
	}

	private FourVBrandDTO convertEntityToBrandDto(FourVBrand fourVBrand) {
		FourVBrandDTO fourVBrandDTO = new FourVBrandDTO(fourVBrand);
		return fourVBrandDTO;
	}
	
	@Override
	public List<FourVModelDTO> listModel(Integer brandId) {
		return fourVModelRepo.findByBrandId(brandId).stream().map(this::convertEntityToModelDto).collect(Collectors.toList());
	}

	private FourVModelDTO convertEntityToModelDto(FourVModel fourVModel) {
		FourVModelDTO fourVModelDTO = new FourVModelDTO(fourVModel);
		return fourVModelDTO;
	}

	@Override
	public List<FuelType> listFuelType() {
		return fuelTypeRepo.findAll();
	}

	@Override
	public List<FourVBatteryDTO> listBattery(Integer fuelId, Integer modelId) {
		return fourVBatteryRepo.findByFuelIdAndModelId(fuelId, modelId).stream().map(this::convertEntityToBatteryDto).collect(Collectors.toList());
	}
	
	@Override
	public FourVBatteryDTO getBattery(Integer batteryId) {
		Optional<FourVBattery> battery = fourVBatteryRepo.findById(batteryId);
		if(battery.isEmpty()) {
			throw new ResourceNotFoundException("fourvbattery", "Id", batteryId);
		}
		FourVBattery fourVBattery=battery.get();
		FourVBatteryDTO fourVBatteryDto= new FourVBatteryDTO();
		fourVBatteryDto.setId(fourVBattery.getId());
		fourVBatteryDto.setBatteryModelName(fourVBattery.getBatteryModelName());
		fourVBatteryDto.setBrand(fourVBattery.getBrand());
		fourVBatteryDto.setSeries(fourVBattery.getSeries());
		fourVBatteryDto.setVoltage(fourVBattery.getVoltage());
		fourVBatteryDto.setAh(fourVBattery.getAh());
		fourVBatteryDto.setImage(fourVBattery.getImage());
		fourVBatteryDto.setTerminalLayout(fourVBattery.getTerminalLayout());
		fourVBatteryDto.setGuarantee(fourVBattery.getGuarantee());
		fourVBatteryDto.setWarranty(fourVBattery.getWarranty());
		fourVBatteryDto.setMrp(fourVBattery.getMrp());
		fourVBatteryDto.setRebate(fourVBattery.getRebate());
		fourVBatteryDto.setStock(fourVBattery.getStock());
		return fourVBatteryDto;
	}
	
	private FourVBatteryDTO convertEntityToBatteryDto(FourVBattery fourVBattery) {
		FourVBatteryDTO fourVBatteryDTO = new FourVBatteryDTO(fourVBattery);
		return fourVBatteryDTO;
	}
}
