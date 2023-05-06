package com.bgv.battery.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgv.battery.dto.BackupDurationDTO;
import com.bgv.battery.dto.InvBatteryDTO;
import com.bgv.battery.dto.InvBatteryWarrantyDTO;
import com.bgv.battery.exceptions.ResourceNotFoundException;
import com.bgv.battery.model.BackupDuration;
import com.bgv.battery.model.InvBattery;
import com.bgv.battery.model.InvBatteryWarranty;
import com.bgv.battery.repository.BackupDurationRepo;
import com.bgv.battery.repository.InvBatteryRepo;
import com.bgv.battery.repository.InvBatteryWarrantyRepo;

@Service
public class InvBatteryServiceImp implements InvBatteryService {

	@Autowired
	private BackupDurationRepo backupDurationRepo;
	
	@Autowired
	private InvBatteryWarrantyRepo invBatteryWarrantyRepo;
	
	@Autowired
	private InvBatteryRepo invBatteryRepo;
	
	@Override
	public List<BackupDurationDTO> listBackupDuration() {
		
		return backupDurationRepo.findAll().stream().map(this::convertEntityToBackup).collect(Collectors.toList());
	}

	@Override
	public List<InvBatteryWarrantyDTO> listInvBatteryWarranty(Integer backupDurationId) {
	
		return invBatteryWarrantyRepo.findByBackupDurationId(backupDurationId).stream().map(this::convertEntityToWarrantyDto).collect(Collectors.toList());
	}

	@Override
	public List<InvBatteryDTO> listInvBatteries(Integer backupDurationId, Integer invBatteryWarrantyId) {
	
	    return invBatteryRepo.findByBackupDurationAndWarranty(backupDurationId, invBatteryWarrantyId).stream().map(this::convertEntityToBatteryDto).collect(Collectors.toList());
	}
	
	@Override
	public InvBatteryDTO getBattery(Integer batteryId) {
		Optional<InvBattery> invBattery = invBatteryRepo.findById(batteryId);
		if(invBattery.isEmpty()) {
			throw new ResourceNotFoundException("inv-battery", "Id", batteryId);
		}
		 InvBattery inv = invBattery.get();
		 InvBatteryDTO invBatteryDTO = this.convertEntityToBatteryDto(inv);
		 return invBatteryDTO;
	}

	public BackupDurationDTO convertEntityToBackup(BackupDuration backupDuration) {
		BackupDurationDTO backupDurationDTO = new BackupDurationDTO(backupDuration);
		return backupDurationDTO;
	}
	
	public InvBatteryWarrantyDTO convertEntityToWarrantyDto(InvBatteryWarranty invBatteryWarranty) {
		InvBatteryWarrantyDTO invBatteryWarrantyDTO = new InvBatteryWarrantyDTO(invBatteryWarranty);
		return invBatteryWarrantyDTO;
	}
	
	public InvBatteryDTO convertEntityToBatteryDto(InvBattery invBattery) {
		InvBatteryDTO invBatteryDTO = new InvBatteryDTO(invBattery);
		return invBatteryDTO;
	}


}
