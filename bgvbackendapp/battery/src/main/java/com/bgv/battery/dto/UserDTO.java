package com.bgv.battery.dto;

import java.util.HashSet;
import java.util.Set;

import com.bgv.battery.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO {

	private Integer id;
	@NotEmpty
	@Size(min = 4, message = "Username must be min of 4 characters !!")
	private String firstName;
	@NotNull
	private String lastName;
	@Email(message = "Email address not valid !!")
	private String email;
	@NotEmpty
	@Size(min = 5, max = 20, message = "Password must be min of 5 characters and max of 20 characters !!")
	private String password;
	@NotEmpty
	private String phoneNo;
	
	private Set<Role> roles = new HashSet<>();
	
	public UserDTO() {
		
	}

	public UserDTO(String firstName, String lastName, String email, String password, String phoneNo, Set<Role> roles) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.roles=roles;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}
    
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
