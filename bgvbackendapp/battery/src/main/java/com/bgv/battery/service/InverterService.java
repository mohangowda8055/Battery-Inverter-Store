package com.bgv.battery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bgv.battery.dto.InvCapacityDTO;
import com.bgv.battery.dto.InverterBatteryDTO;
import com.bgv.battery.dto.InverterDTO;

@Service
public interface InverterService {

	public List<InvCapacityDTO> listCapacity();
	
	public List<InverterDTO> listInverter(Integer capacityId);
	
	public List<InverterBatteryDTO> listInverterBattery(Integer capacityId);
	
	public InverterDTO getInverter(Integer inverterId);
}
