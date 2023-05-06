package com.bgv.battery.dto;

import com.bgv.battery.model.BackupDuration;

public class BackupDurationDTO {

    private Integer id;
	
	private double backupDuration;
	
	public BackupDurationDTO() {
		
	}

	public BackupDurationDTO(double backupDuration) {
		this.backupDuration = backupDuration;
	}
	
	public BackupDurationDTO(BackupDuration backupDuration) {
		this.setId(backupDuration.getId());
		this.setBackupDuration(backupDuration.getBackupDuration());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getBackupDuration() {
		return backupDuration;
	}

	public void setBackupDuration(double backupDuration) {
		this.backupDuration = backupDuration;
	}
	
}
