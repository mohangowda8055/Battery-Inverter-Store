package com.bgv.battery.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bgv.battery.model.Inverter;

@Repository
public interface InverterRepo extends JpaRepository<Inverter, Integer> {

	@Query(value="SELECT * FROM inverter i WHERE i.capacity_id=:capacityId", nativeQuery=true)
	List<Inverter> findByCapacityId(Integer capacityId);
	
	@Query(value="SELECT i.* FROM inverter AS i "
			+ "INNER JOIN inverter_inv_battery AS iib ON iib.inv_id = i.inv_id "
			+ "INNER JOIN inv_battery AS ib ON ib.battery_id = iib.battery_id "
			+ "WHERE i.capacity_id=:capacityId", nativeQuery=true)
	Set<Inverter> findByCapacityIdAndInveter(Integer capacityId);
}
