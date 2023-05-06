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
@Table(name="inv_battery_warranty")
public class InvBatteryWarranty {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="warranty_id")
	private Integer id;
	
	@Column(name="warranty")
	private int totalWarranty;
	
	@OneToMany(mappedBy="invBatteryWarranties")
	private List<InvBattery> invBattery;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="backup_warranty",
			joinColumns=@JoinColumn(name="warranty_id"),
			inverseJoinColumns=@JoinColumn(name="backup_duration_id")
			)
	private List<BackupDuration> backupDuration;

	public InvBatteryWarranty() {
		
	}
	
	public InvBatteryWarranty(int totalWarranty, List<InvBattery> invBattery, List<BackupDuration> backupDuration) {
		this.totalWarranty = totalWarranty;
		this.invBattery = invBattery;
		this.backupDuration = backupDuration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTotalWarranty() {
		return totalWarranty;
	}

	public void setTotalWarranty(int totalWarranty) {
		this.totalWarranty = totalWarranty;
	}

	public List<InvBattery> getInvBattery() {
		return invBattery;
	}

	public void setInvBattery(List<InvBattery> invBattery) {
		this.invBattery = invBattery;
	}

	public List<BackupDuration> getBackupDuration() {
		return backupDuration;
	}

	public void setBackupDuration(List<BackupDuration> backupDuration) {
		this.backupDuration = backupDuration;
	}
	
}
