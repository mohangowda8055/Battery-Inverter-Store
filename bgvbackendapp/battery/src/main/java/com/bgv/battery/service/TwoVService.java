package com.bgv.battery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bgv.battery.dto.TwoVBatteryDTO;
import com.bgv.battery.dto.TwoVBrandDTO;
import com.bgv.battery.dto.TwoVModelDTO;

@Service
public interface TwoVService {

	public List<TwoVBrandDTO> listBrand();
	public List<TwoVModelDTO> listModel(Integer brandId);
	public List<TwoVBatteryDTO> listBattery(Integer modelId);
	public TwoVBatteryDTO getBattery(Integer batteryId);
}
