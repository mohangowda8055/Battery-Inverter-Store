package com.bgv.battery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bgv.battery.dto.BackupDurationDTO;
import com.bgv.battery.dto.InvBatteryDTO;
import com.bgv.battery.dto.InvBatteryWarrantyDTO;
import com.bgv.battery.service.InvBatteryService;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/inv-battery")
public class InvBatteryController {

	@Autowired
	private InvBatteryService invBatteryService;
	
	@GetMapping("/backup-duration")
	public ResponseEntity<List<BackupDurationDTO>> listBackupDurations(){
		List<BackupDurationDTO> body = invBatteryService.listBackupDuration();
		return new ResponseEntity<List<BackupDurationDTO>>(body, HttpStatus.OK);
	}
	
	@GetMapping("/warranty")
	public ResponseEntity<List<InvBatteryWarrantyDTO>> listWarranty(@RequestParam Integer backupDurationId){
		List<InvBatteryWarrantyDTO> body = invBatteryService.listInvBatteryWarranty(backupDurationId);
		return new ResponseEntity<List<InvBatteryWarrantyDTO>>(body, HttpStatus.OK);
	}
	
	@GetMapping("/batteries")
	public ResponseEntity<List<InvBatteryDTO>> listBattery(@RequestParam Integer backupDurationId, @RequestParam Integer warrantyId){
		List<InvBatteryDTO> body = invBatteryService.listInvBatteries(backupDurationId, warrantyId);
		return new ResponseEntity<List<InvBatteryDTO>>(body, HttpStatus.OK);
	}
	
	@GetMapping("/invbattery")
	public ResponseEntity<InvBatteryDTO> getBattery(@RequestParam Integer invbatteryId){
		InvBatteryDTO body = invBatteryService.getBattery(invbatteryId);
		return new ResponseEntity<InvBatteryDTO>(body, HttpStatus.OK);
	}
}
