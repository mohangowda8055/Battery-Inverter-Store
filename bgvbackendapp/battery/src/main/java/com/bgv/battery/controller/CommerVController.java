package com.bgv.battery.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bgv.battery.dto.CommerVBrandDTO;
import com.bgv.battery.service.CommerVService;

@RestController
@RequestMapping("/commerv")
public class CommerVController {
	
	private CommerVService commerVService;

	@GetMapping("/")
	public ResponseEntity<List<CommerVBrandDTO>> getBrand(){
		List<CommerVBrandDTO> body = commerVService.listBrand();
		return new ResponseEntity<List<CommerVBrandDTO>>(body, HttpStatus.OK);
	}
}
