package com.bgv.battery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bgv.battery.dto.CommerVBrandDTO;

@Service
public interface CommerVService {

	public List<CommerVBrandDTO> listBrand();
}
