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

import com.bgv.battery.dto.InvCapacityDTO;
import com.bgv.battery.dto.InverterBatteryDTO;
import com.bgv.battery.dto.InverterDTO;
import com.bgv.battery.service.InverterService;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/inv")
public class InverterController {

	@Autowired
	private InverterService inverterService;
	
	@GetMapping("/capacity")
	public ResponseEntity<List<InvCapacityDTO>> getCapacity(){
		List<InvCapacityDTO> body = inverterService.listCapacity();
		return new ResponseEntity<List<InvCapacityDTO>>(body, HttpStatus.OK);
	}
	
	@GetMapping("/inverters")
	public ResponseEntity<List<InverterDTO>> listInverter(@RequestParam Integer capacityId){
		List<InverterDTO> body = inverterService.listInverter(capacityId);
		return new ResponseEntity<List<InverterDTO>>(body, HttpStatus.OK);
	}
	
	@GetMapping("/inverter-battery")
	public ResponseEntity<List<InverterBatteryDTO>> listInverterBattery(@RequestParam Integer capacityId){
		List<InverterBatteryDTO> body = inverterService.listInverterBattery(capacityId);
		return new ResponseEntity<List<InverterBatteryDTO>>(body, HttpStatus.OK);
	}
	
	@GetMapping("inverter")
	public ResponseEntity<InverterDTO> getInverter(@RequestParam Integer inverterId){
		InverterDTO body = inverterService.getInverter(inverterId);
		return new ResponseEntity<InverterDTO>(body, HttpStatus.OK);
	}
}
