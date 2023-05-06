package com.bgv.battery.dto;

public class MyRequestData {

	private String email;
	
	private Integer otp;
	
	private String type;

	public MyRequestData() {
		
	}
	
	public MyRequestData(String email, Integer otp, String type) {
		this.email = email;
		this.otp = otp;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
