package com.bgv.battery.service;

import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bgv.battery.dto.UserDTO;
import com.bgv.battery.exceptions.ResourceNotFoundException;
import com.bgv.battery.model.OtpStore;
import com.bgv.battery.model.User;
import com.bgv.battery.repository.OtpStoreRepo;
import com.bgv.battery.repository.UserRepo;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private OtpStoreRepo otpStoreRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepo userRepo;
	
	public boolean sendEmail(String email, String message, Integer otp) {

		boolean flag = false;
		Properties properties = System.getProperties();
		
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("mohangowda1381999", "suhktrbnxhkryhpe");
			}
		});
		
		session.setDebug(true);
		
		 Message msg = new MimeMessage(session);
		 
		 try {
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			msg.setFrom(new InternetAddress("mohangowda1381999@gmail.com"));
			msg.setSubject("Verify Email Address");
			msg.setContent(message, "text/html");
			
			Transport.send(msg);
			
			flag = true;
			
		OtpStore otpStore = new OtpStore();
		otpStore.setEmail(email);
		otpStore.setOtp(otp);
		this.otpStoreRepo.save(otpStore);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag; 
	}
	
	public Integer getOtp(String email) {
		OtpStore otpStore = this.otpStoreRepo.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User", "email", email));
		Integer otp = otpStore.getOtp();
		return otp;
	}
	
	public Boolean isEmailPresent(String email) {
		Optional<User> user = this.userRepo.findByEmail(email);
		if(user.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	public UserDTO updatePassword(String password, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		user.setPassword(this.passwordEncoder.encode(password));
		User updatedUser = this.userRepo.save(user);
		UserDTO userDTO1 =this.convertEntityToUserDto(updatedUser);
		return userDTO1 ;
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
}
