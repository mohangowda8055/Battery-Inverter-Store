package com.bgv.battery.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bgv.battery.model.InvBattery;

@Repository
public interface InvBatteryRepo extends JpaRepository<InvBattery, Integer> {

	@Query(value="SELECT * FROM inv_battery b WHERE b.backup_duration_id=:backupDurationId AND b.warranty_id=:warrantyId", nativeQuery=true)
	Set<InvBattery> findByBackupDurationAndWarranty(Integer backupDurationId, Integer warrantyId);
}
