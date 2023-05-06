package com.bgv.battery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bgv.battery.model.FourVModel;

public interface FourVModelRepo extends JpaRepository<FourVModel, Integer> {

	@Query(value="SELECT * FROM four_v_model f WHERE f.brand_id=:brandId", nativeQuery=true)
	List<FourVModel> findByBrandId(Integer brandId);
}
