package com.bgv.battery.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="otp_store")
public class OtpStore {

	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="otp")
	private Integer otp;
	
	@CreationTimestamp
	@Column(name="otp_created_date")
	private Date otpDateTime;
	
	public OtpStore() {
		
	}

	public OtpStore(String email, Integer otp, Date otpDateTime) {
		this.email = email;
		this.otp = otp;
		this.otpDateTime = otpDateTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public Date getOtpDateTime() {
		return otpDateTime;
	}

	public void setOtpDateTime(Date otpDateTime) {
		this.otpDateTime = otpDateTime;
	}
	
}
