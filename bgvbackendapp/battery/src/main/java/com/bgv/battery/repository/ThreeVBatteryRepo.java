package com.bgv.battery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bgv.battery.model.ThreeVBattery;

@Repository
public interface ThreeVBatteryRepo extends JpaRepository<ThreeVBattery, Integer> {

	@Query(value="SELECT b.* FROM three_v_battery AS b "
			+ "INNER JOIN three_v_battery_model AS bm ON bm.battery_id = b.battery_id "
			+ "INNER JOIN three_v_model AS m ON m.model_id = bm.model_id "
			+ "WHERE m.model_id=:modelId", nativeQuery=true)
	List<ThreeVBattery> findByModelId(Integer modelId);
}
