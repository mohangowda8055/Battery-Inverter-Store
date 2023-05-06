package com.bgv.battery.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bgv.battery.dto.UserDTO;
import com.bgv.battery.exceptions.ResourceNotFoundException;
import com.bgv.battery.model.Role;
import com.bgv.battery.model.User;
import com.bgv.battery.repository.RoleRepo;
import com.bgv.battery.repository.UserRepo;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = this.convertUserDtoToEntity(userDTO);
		User savedUser = this.userRepo.save(user);
		return this.convertEntityToUserDto(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
//		user.setFirstName(userDTO.getFirstName());
//		user.setLastName(userDTO.getLastName());
//		user.setEmail(userDTO.getEmail());
		user.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
//		user.setPhoneNo(userDTO.getPhoneNo());
		User updatedUser = this.userRepo.save(user);
	UserDTO userDTO1 =this.convertEntityToUserDto(updatedUser);
		return userDTO1 ;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		return this.convertEntityToUserDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userRepo.findAll();
	List<UserDTO> userDTOs = users.stream().map(user->this.convertEntityToUserDto(user)).collect(Collectors.toList());
		return userDTOs;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);
	}
	
	public User convertUserDtoToEntity(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setPhoneNo(userDTO.getPhoneNo());
		user.setRoles(userDTO.getRoles());
		return user;
	}

	public UserDTO convertEntityToUserDto(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		userDTO.setPhoneNo(user.getPhoneNo());
		userDTO.setRoles(user.getRoles());
		return userDTO;
	}

	@Override
	public UserDTO registerNewUser(UserDTO userDTO) {
		User user=this.convertUserDtoToEntity(userDTO);
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		Role role=this.roleRepo.findById(1).get();
		user.getRoles().add(role);
		User newUser=this.userRepo.save(user);
		UserDTO newUserDTO=this.convertEntityToUserDto(newUser);
		return newUserDTO;
	}
}
