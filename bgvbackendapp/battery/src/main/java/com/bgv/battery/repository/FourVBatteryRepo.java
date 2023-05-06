package com.bgv.battery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bgv.battery.model.FourVBattery;

@Repository
public interface FourVBatteryRepo extends JpaRepository<FourVBattery, Integer> {

	@Query(value="SELECT b.* FROM four_v_battery AS b "
			+ "INNER JOIN four_v_battery_model AS bm ON b.battery_id = bm.battery_id "
			+ "INNER JOIN four_v_model AS m ON bm.model_id = m.model_id "
			+ "WHERE b.fuel_id=:fuelId AND m.model_id=:modelId", nativeQuery=true)
	List<FourVBattery> findByFuelIdAndModelId(Integer fuelId, Integer modelId);
}
