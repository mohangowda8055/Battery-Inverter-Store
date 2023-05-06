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

import com.bgv.battery.dto.FourVBatteryDTO;
import com.bgv.battery.dto.FourVBrandDTO;
import com.bgv.battery.dto.FourVModelDTO;
import com.bgv.battery.service.FourVService;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/fourv")
public class FourVController {

	@Autowired
	private FourVService fourVService;
	
	@GetMapping("/brand")
	public ResponseEntity<List<FourVBrandDTO>> getBrand(){
		List<FourVBrandDTO> body = fourVService.listBrand();
		return new ResponseEntity<List<FourVBrandDTO>>(body, HttpStatus.OK);
	}
	
	@GetMapping("/model")
	public ResponseEntity<List<FourVModelDTO>> getModel(@RequestParam Integer brandId){
		List<FourVModelDTO> body = fourVService.listModel(brandId);
		return new ResponseEntity<List<FourVModelDTO>>(body, HttpStatus.OK);
	}
	
	@GetMapping("/batteries")
	public ResponseEntity<List<FourVBatteryDTO>> getBattery(@RequestParam Integer fuelId, @RequestParam Integer modelId){
		List<FourVBatteryDTO> body = fourVService.listBattery(fuelId, modelId);
		return new ResponseEntity<List<FourVBatteryDTO>>(body, HttpStatus.OK);
	}
	
	@GetMapping("/battery")
	public ResponseEntity<FourVBatteryDTO> getSingleBattery(@RequestParam Integer batteryId){
		FourVBatteryDTO body = fourVService.getBattery(batteryId);
		return new ResponseEntity<FourVBatteryDTO> (body, HttpStatus.OK);
	}
}