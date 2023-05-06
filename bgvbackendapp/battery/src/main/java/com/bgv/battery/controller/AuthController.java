package com.bgv.battery.controller;


import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bgv.battery.dto.MyRequestData;
import com.bgv.battery.dto.UserDTO;
import com.bgv.battery.exceptions.ApiException;
import com.bgv.battery.model.User;
import com.bgv.battery.repository.UserRepo;
import com.bgv.battery.security.JwtAuthRequest;
import com.bgv.battery.security.JwtAuthResponse;
import com.bgv.battery.security.JwtTokenHelper;
import com.bgv.battery.service.EmailService;
import com.bgv.battery.service.UserService;

import jakarta.servlet.http.HttpSession;



@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
		this.authenticate(request.getUsername(),request.getPassword());
		UserDetails userDetails=this.userDetailsService.loadUserByUsername(request.getUsername());
		String token=this.jwtTokenHelper.generateToken(userDetails);
		JwtAuthResponse response=new JwtAuthResponse();
		response.setToken(token);
		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
	}

	private void authenticate(String username, String password) throws Exception {
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username, password);
	
		try {
			this.authenticationManager.authenticate(authenticationToken);
		}catch(BadCredentialsException e) {
			System.out.println("Invalid Details !!");
			throw new ApiException("Invalid username or password");
		}
	}
	
	@PutMapping("/update-password")
	public ResponseEntity<UserDTO> updatePassword(@RequestBody User user, @RequestParam Integer userId){
		UserDTO result = this.emailService.updatePassword(user.getPassword(), userId);
		return new ResponseEntity<UserDTO>(result, HttpStatus.OK);
	}
	
	@PostMapping("/send-otp")
	public ResponseEntity<String> sendOTP(@RequestBody MyRequestData requestData, HttpSession session) {
		boolean value = this.emailService.isEmailPresent(requestData.getEmail());
		String type = requestData.getType();
		String typeValue = "register";
		System.out.println(type + " " +type.getClass());
		System.out.println(value);
		if(type.equals(typeValue) && value) {
			return new ResponseEntity<String>("present", HttpStatus.OK);
		}
		Random random = new Random();
		Integer otp = random.nextInt(9000) + 1000;
		System.out.println(otp);
		String msg;
		String message = "<div style='border:1px solid #e2e2e2; padding:20px'>"
				+"<h1> OTP is <b>" +otp+ "</b></h1>"
				+"</div>";
		System.out.println(requestData.getEmail());
		String email= requestData.getEmail();
		boolean result = emailService.sendEmail(email, message, otp);
		if(result) {
			msg = "Sent OTP";
			
		}else {
			msg = "Failed";
		}
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PostMapping("/verify-otp")
	public ResponseEntity<String> verifyOTP(@RequestBody MyRequestData requestData, HttpSession session ){
	Integer myOtp = this.emailService.getOtp(requestData.getEmail());
	Integer otp = requestData.getOtp();
		String result;
		System.out.println();
		System.out.println(otp + " " +otp.getClass());
		System.out.println(myOtp+ " " +otp.getClass());

		if(myOtp.equals(otp)) {
			Optional<User> optionalUser = this.userRepo.findByEmail(requestData.getEmail());
			if(optionalUser.isEmpty()) {
				result = "nouserid";
			}else {
				User user =optionalUser.get();
				result = user.getId().toString();
			}
		}else {
			result = "wrongotp";
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDto){
		UserDTO registeredUser=this.userService.registerNewUser(userDto);
		return new ResponseEntity<UserDTO>(registeredUser, HttpStatus.CREATED);
	}
}
