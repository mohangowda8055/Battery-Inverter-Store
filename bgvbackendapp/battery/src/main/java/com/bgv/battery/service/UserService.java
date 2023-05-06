package com.bgv.battery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bgv.battery.dto.UserDTO;

@Service
public interface UserService {

	public UserDTO registerNewUser(UserDTO user);
	public UserDTO createUser(UserDTO user);
	public UserDTO updateUser(UserDTO user, Integer userId);
	public UserDTO getUserById(Integer userId);
	public List<UserDTO> getAllUsers();
	public void deleteUser(Integer userId);
}
