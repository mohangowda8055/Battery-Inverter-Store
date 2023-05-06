package com.bgv.battery.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bgv.battery.dto.TwoVBatteryDTO;
import com.bgv.battery.dto.TwoVBrandDTO;
import com.bgv.battery.dto.TwoVModelDTO;
import com.bgv.battery.exceptions.ResourceNotFoundException;
import com.bgv.battery.model.TwoVBattery;
import com.bgv.battery.model.TwoVBrand;
import com.bgv.battery.model.TwoVModel;
import com.bgv.battery.repository.TwoVBatteryRepo;
import com.bgv.battery.repository.TwoVBrandRepo;
import com.bgv.battery.repository.TwoVModelRepo;


@Service
public class TwoVServiceImp implements TwoVService {

	@Autowired
	private TwoVBrandRepo twoVBrandRepo;
	
	@Autowired
	private TwoVModelRepo twoVModelRepo;
	
	@Autowired
	private TwoVBatteryRepo twoVBatteryRepo;
	
	@Override
	public List<TwoVBrandDTO> listBrand() {
		return twoVBrandRepo.findAll().stream().map(this::convertEntityToBrandDto).collect(Collectors.toList());
	}

	@Override
	public List<TwoVModelDTO> listModel(Integer brandId) {
		return twoVModelRepo.findByBrandId(brandId).stream().map(this::convertEntityToModelDto).collect(Collectors.toList());
	}

	@Override
	public List<TwoVBatteryDTO> listBattery(Integer modelId) {
		return twoVBatteryRepo.findByModelId(modelId).stream().map(this::convertEntityToBatteryDto).collect(Collectors.toList());
	}
	
	@Override
	public TwoVBatteryDTO getBattery(Integer batteryId) {
		Optional<TwoVBattery> battery = twoVBatteryRepo.findById(batteryId);
		if(battery.isEmpty()) {
			throw new ResourceNotFoundException("battery", "Id", batteryId);
		}
		TwoVBattery twoVBattery=battery.get();
		TwoVBatteryDTO twoVBatteryDto= new TwoVBatteryDTO();
		twoVBatteryDto.setId(twoVBattery.getId());
		twoVBatteryDto.setBatteryModelName(twoVBattery.getBatteryModelName());
		twoVBatteryDto.setBrand(twoVBattery.getBrand());
		twoVBatteryDto.setSeries(twoVBattery.getSeries());
		twoVBatteryDto.setVoltage(twoVBattery.getVoltage());
		twoVBatteryDto.setAh(twoVBattery.getAh());
		twoVBatteryDto.setImage(twoVBattery.getImage());
		twoVBatteryDto.setTerminalLayout(twoVBattery.getTerminalLayout());
		twoVBatteryDto.setGuarantee(twoVBattery.getGuarantee());
		twoVBatteryDto.setWarranty(twoVBattery.getWarranty());
		twoVBatteryDto.setMrp(twoVBattery.getMrp());
		twoVBatteryDto.setRebate(twoVBattery.getRebate());
		twoVBatteryDto.setStock(twoVBattery.getStock());
		return twoVBatteryDto;
	}
	
	private TwoVBrandDTO convertEntityToBrandDto(TwoVBrand twoVBrand) {
		TwoVBrandDTO twoVBrandDTO = new TwoVBrandDTO(twoVBrand);
		return twoVBrandDTO;
	}
	
	private TwoVModelDTO convertEntityToModelDto(TwoVModel twoVModel) {
		TwoVModelDTO twoVModelDTO=new TwoVModelDTO(twoVModel);
		return twoVModelDTO;
	}
	
	private TwoVBatteryDTO convertEntityToBatteryDto(TwoVBattery twoVBattery) {
		TwoVBatteryDTO twoVBatteryDTO=new TwoVBatteryDTO(twoVBattery);
		return twoVBatteryDTO;
	}
}
