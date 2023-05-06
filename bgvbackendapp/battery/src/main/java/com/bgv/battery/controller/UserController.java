package com.bgv.battery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bgv.battery.common.ApiResponse;
import com.bgv.battery.dto.UserDTO;
import com.bgv.battery.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
		UserDTO createdUserDTO = this.userService.createUser(userDTO);
		return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @RequestParam Integer userId){
		UserDTO updatedUserDTO = this.userService.updateUser(userDTO, userId);
		return ResponseEntity.ok(updatedUserDTO);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List<UserDTO> body = this.userService.getAllUsers();
		return new ResponseEntity<List<UserDTO>> (body,HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<UserDTO> getSingleUser(@RequestParam Integer userId){
		 UserDTO body = this.userService.getUserById(userId);
		return new ResponseEntity<UserDTO>(body,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("")
	public ResponseEntity<ApiResponse> deleteUser(@RequestParam("userId") Integer uid){
		this.userService.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "User deleted successfully"),HttpStatus.OK);
	}
}
