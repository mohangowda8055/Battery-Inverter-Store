package com.bgv.battery.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bgv.battery.model.InvBatteryWarranty;

@Repository
public interface InvBatteryWarrantyRepo extends JpaRepository<InvBatteryWarranty, Integer> {

	@Query(value="SELECT w.* FROM inv_battery_warranty AS w "
			+ "INNER JOIN backup_warranty AS bw ON bw.warranty_id = w.warranty_id "
			+ "INNER JOIN backup_duration AS b ON b.backup_duration_id = bw.backup_duration_id "
			+ "WHERE bw.backup_duration_id=:backupDurationId", nativeQuery=true)
	Set<InvBatteryWarranty> findByBackupDurationId(Integer backupDurationId);
}
