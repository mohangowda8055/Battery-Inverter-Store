package com.bgv.battery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgv.battery.dto.CommerVBrandDTO;
import com.bgv.battery.model.CommerVBrand;
import com.bgv.battery.repository.CommerVBrandRepo;

@Service
public class CommerVServiceImp implements CommerVService {

	@Autowired
	private CommerVBrandRepo commerVBrandRepo;
	
	@Override
	public List<CommerVBrandDTO> listBrand() {
		return commerVBrandRepo.findAll().stream().map(this::convertEntityToBrandDto).collect(Collectors.toList());
	}

	private CommerVBrandDTO convertEntityToBrandDto(CommerVBrand commerVBrand) {
		CommerVBrandDTO commerVBrandDTO = new CommerVBrandDTO(commerVBrand);
		return commerVBrandDTO;
	}
}
