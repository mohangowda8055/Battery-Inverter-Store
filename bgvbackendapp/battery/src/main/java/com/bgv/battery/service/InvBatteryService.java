package com.bgv.battery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bgv.battery.dto.BackupDurationDTO;
import com.bgv.battery.dto.InvBatteryDTO;
import com.bgv.battery.dto.InvBatteryWarrantyDTO;

@Service
public interface InvBatteryService {

	public List<BackupDurationDTO> listBackupDuration();
	
	public List<InvBatteryWarrantyDTO> listInvBatteryWarranty(Integer backupDurationId);
	
	public List<InvBatteryDTO> listInvBatteries(Integer backupDurationId, Integer invBatteryWarrantyId);

	public InvBatteryDTO getBattery(Integer batteryId);
}
