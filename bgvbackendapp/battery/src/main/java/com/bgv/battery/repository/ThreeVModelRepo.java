package com.bgv.battery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bgv.battery.model.ThreeVModel;
@Repository
public interface ThreeVModelRepo extends JpaRepository<ThreeVModel, Integer> {

	@Query(value="SELECT * FROM three_v_model t WHERE t.brand_id=:brandId ", nativeQuery=true)
	List<ThreeVModel> findByBrandId(Integer brandId);
}
