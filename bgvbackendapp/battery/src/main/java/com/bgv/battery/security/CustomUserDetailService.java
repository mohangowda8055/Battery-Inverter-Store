package com.bgv.battery.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bgv.battery.exceptions.ResourceNotFoundException;
import com.bgv.battery.model.User;
import com.bgv.battery.repository.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//loading user from database by username
	User user = this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User", "email", username));
		return user;
	}

}
