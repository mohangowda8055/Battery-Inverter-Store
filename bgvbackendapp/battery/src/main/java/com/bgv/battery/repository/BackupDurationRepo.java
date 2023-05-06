package com.bgv.battery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bgv.battery.model.BackupDuration;

@Repository
public interface BackupDurationRepo extends JpaRepository<BackupDuration, Integer> {

}
