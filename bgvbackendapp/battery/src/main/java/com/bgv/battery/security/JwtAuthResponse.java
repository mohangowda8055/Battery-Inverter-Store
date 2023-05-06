package com.bgv.battery.security;

public class JwtAuthResponse {

	private String token;
	
	public JwtAuthResponse() {
		
	}

	public JwtAuthResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
