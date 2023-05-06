package com.bgv.battery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bgv.battery.dto.ThreeVBatteryDTO;
import com.bgv.battery.dto.ThreeVBrandDTO;
import com.bgv.battery.dto.ThreeVModelDTO;
import com.bgv.battery.service.ThreeVService;

@RestController
@RequestMapping("/threev")
public class ThreeVController {
	
	@Autowired
	private ThreeVService threeVService;

	@GetMapping("/brand")
	public ResponseEntity<List<ThreeVBrandDTO>> listBrand(){
		List<ThreeVBrandDTO> body = threeVService.listBrand();
		return new ResponseEntity<List<ThreeVBrandDTO>>(body, HttpStatus.OK);
	}
	
	@GetMapping("/model")
	public ResponseEntity<List<ThreeVModelDTO>> listModel(@RequestParam Integer brandId){
		List<ThreeVModelDTO> body = threeVService.listModel(brandId);
		return new ResponseEntity<List<ThreeVModelDTO>>(body, HttpStatus.OK);
	}
	
	@GetMapping("/battery")
	public ResponseEntity<List<ThreeVBatteryDTO>> listBattery(@RequestParam Integer modelId){
		List<ThreeVBatteryDTO> body = threeVService.listBattery(modelId);
		return new ResponseEntity<List<ThreeVBatteryDTO>>(body, HttpStatus.OK);
	}
}
