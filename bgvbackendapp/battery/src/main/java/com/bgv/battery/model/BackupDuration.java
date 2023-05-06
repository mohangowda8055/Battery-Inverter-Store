package com.bgv.battery.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="backup_duration")
public class BackupDuration {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="backup_duration_id")
	private Integer id;
	
	@Column(name="backup_duration")
	private double backupDuration;
	
	@OneToMany(mappedBy="backupDurations", fetch=FetchType.LAZY)
	private List<InvBattery> invBattery;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="backup_warranty",
			joinColumns=@JoinColumn(name="backup_duration_id"),
			inverseJoinColumns=@JoinColumn(name="warranty_id")
			)
	private List<InvBatteryWarranty> invBatteryWarranty;
	
	public BackupDuration() {
		
	}

	public BackupDuration(double backupDuration, List<InvBattery> invBattery,
			List<InvBatteryWarranty> invBatteryWarranty) {
		this.backupDuration = backupDuration;
		this.invBattery = invBattery;
		this.invBatteryWarranty = invBatteryWarranty;
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

	public List<InvBattery> getInvBattery() {
		return invBattery;
	}

	public void setInvBattery(List<InvBattery> invBattery) {
		this.invBattery = invBattery;
	}

	public List<InvBatteryWarranty> getInvBatteryWarranty() {
		return invBatteryWarranty;
	}

	public void setInvBatteryWarranty(List<InvBatteryWarranty> invBatteryWarranty) {
		this.invBatteryWarranty = invBatteryWarranty;
	}

	
}
