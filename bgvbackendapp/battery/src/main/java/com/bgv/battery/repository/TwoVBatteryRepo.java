package com.bgv.battery.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bgv.battery.model.TwoVBattery;

@Repository
public interface TwoVBatteryRepo extends JpaRepository<TwoVBattery, Integer> {

	@Query(value="SELECT b.* FROM two_v_battery AS b "
			+ "INNER JOIN two_v_battery_model AS bm ON b.battery_id = bm.battery_id "
			+ "INNER JOIN two_v_model AS m ON bm.model_id = m.model_id "
			+ "WHERE m.model_id=:modelId", nativeQuery=true)
	List<TwoVBattery> findByModelId(Integer modelId);
}
