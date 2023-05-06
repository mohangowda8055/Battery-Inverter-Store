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

import com.bgv.battery.dto.TwoVBatteryDTO;
import com.bgv.battery.dto.TwoVBrandDTO;
import com.bgv.battery.dto.TwoVModelDTO;
import com.bgv.battery.service.TwoVService;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/twov")
public class TwoVController {

	@Autowired
	private TwoVService twoVService;
	
	@GetMapping("/brand")
	public ResponseEntity<List<TwoVBrandDTO>> listBrand(){
		List<TwoVBrandDTO> body = twoVService.listBrand();
		return new ResponseEntity<List<TwoVBrandDTO>> (body,HttpStatus.OK);
	}
	
	@GetMapping("/model")
	public ResponseEntity<List<TwoVModelDTO>> listModel(@RequestParam Integer brandId){
		List<TwoVModelDTO> body = twoVService.listModel(brandId);
		return new ResponseEntity<List<TwoVModelDTO>> (body, HttpStatus.OK);
	}
	
	@GetMapping("/batteries")
	public ResponseEntity<List<TwoVBatteryDTO>> listBattery(@RequestParam Integer modelId){
		List<TwoVBatteryDTO> body = twoVService.listBattery(modelId);
		return new ResponseEntity<List<TwoVBatteryDTO>> (body,HttpStatus.OK);
	}
	
	@GetMapping("/battery")
	public ResponseEntity<TwoVBatteryDTO> getBattery(@RequestParam Integer batteryId){
		TwoVBatteryDTO body = twoVService.getBattery(batteryId);
		return new ResponseEntity<TwoVBatteryDTO> (body, HttpStatus.OK);
	}
}
