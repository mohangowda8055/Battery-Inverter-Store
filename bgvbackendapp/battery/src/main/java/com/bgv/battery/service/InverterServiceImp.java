package com.bgv.battery.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgv.battery.dto.InvCapacityDTO;
import com.bgv.battery.dto.InverterBatteryDTO;
import com.bgv.battery.dto.InverterDTO;
import com.bgv.battery.exceptions.ResourceNotFoundException;
import com.bgv.battery.model.InvCapacity;
import com.bgv.battery.model.Inverter;
import com.bgv.battery.repository.InvCapacityRepo;
import com.bgv.battery.repository.InverterRepo;

@Service
public class InverterServiceImp implements InverterService {
	
	@Autowired
	private InverterRepo inverterRepo;
	
	@Autowired
	private InvCapacityRepo invCapacityRepo;

	@Override
	public List<InvCapacityDTO> listCapacity() {
	     
		return invCapacityRepo.findAll().stream().map(this::convertEntityToCapacityDto).collect(Collectors.toList());
	}

	@Override
	public List<InverterDTO> listInverter(Integer capacityId) {
		
		return inverterRepo.findByCapacityId(capacityId).stream().map(this::convertEntityToInverterDto).collect(Collectors.toList());
	}

	@Override
	public List<InverterBatteryDTO> listInverterBattery(Integer capacityId) {
	
		return inverterRepo.findByCapacityIdAndInveter(capacityId).stream().map(this::convertEntityToInvBatDto).collect(Collectors.toList());
	}
	
	@Override
	public InverterDTO getInverter(Integer inverterId) {
		
		Optional<Inverter> inverter = inverterRepo.findById(inverterId);
		if(inverter.isEmpty()) {
			throw new ResourceNotFoundException("inverter", "Id", inverterId);
		}
		Inverter inv = inverter.get();
		InverterDTO inverterDTO = new InverterDTO();
		inverterDTO.setId(inv.getId());
		inverterDTO.setBrand(inv.getBrand());
		inverterDTO.setModel(inv.getModel());
		inverterDTO.setWarranty(inv.getWarranty());
		inverterDTO.setNoBatteryReq(inv.getNoBatteryReq());
		inverterDTO.setPrice(inv.getPrice());
		inverterDTO.setImage(inv.getImage());
		inverterDTO.setInverterType(inv.getInverterType());
		inverterDTO.setRecomBatteryCapacity(inv.getRecomBatteryCapacity());
		inverterDTO.setNominalVoltage(inv.getNominalVoltage());
		inverterDTO.setStock(inv.getStock());
		inverterDTO.setCapacityId(inv.getInvCapacity().getId());
		return inverterDTO;
	}
		
	public InvCapacityDTO convertEntityToCapacityDto(InvCapacity invCapacity) {
		InvCapacityDTO invCapacityDTO = new InvCapacityDTO(invCapacity);
		return invCapacityDTO;
	}

	public InverterDTO convertEntityToInverterDto(Inverter inverter) {
		InverterDTO inverterDTO = new InverterDTO(inverter);
		return inverterDTO;
	}

	public InverterBatteryDTO convertEntityToInvBatDto(Inverter inverter) {
        InverterBatteryDTO inverterBatteryDTO = new InverterBatteryDTO(inverter);
	    return inverterBatteryDTO;
	}
}
