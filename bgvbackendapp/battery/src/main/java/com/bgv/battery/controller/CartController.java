package com.bgv.battery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bgv.battery.common.ApiResponse;
import com.bgv.battery.dto.CartDTO;
import com.bgv.battery.dto.CartsDto;
import com.bgv.battery.exceptions.ResourceNotFoundException;
import com.bgv.battery.model.User;
import com.bgv.battery.repository.UserRepo;
import com.bgv.battery.security.JwtTokenHelper;
import com.bgv.battery.service.CartService;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	
	//post cart api
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addToCart(@RequestBody CartDTO cartDTO, @RequestHeader(name="Authorization") String token){
		
		token=token.substring(7);
		String username = this.jwtTokenHelper.getUsernameFromToken(token);
		User user=this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User", "email", username));
		cartService.addToCart(cartDTO,user);
		return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
	}
	
	@PutMapping("")
	public ResponseEntity<CartsDto> updateCart(@RequestBody CartDTO cartDTO, @RequestHeader(name="Authorization") String token, @RequestParam Integer cartItemId ){
		token=token.substring(7);
		String username = this.jwtTokenHelper.getUsernameFromToken(token);
		User user=this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User", "email", username));
		CartsDto body =this.cartService.updateCart(cartDTO, cartItemId, user);
		return new ResponseEntity<CartsDto> (body,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<CartsDto> getCartItems(@RequestHeader(name="Authorization") String token){
		
		token=token.substring(7);
		String username = this.jwtTokenHelper.getUsernameFromToken(token);
		User user=this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User", "email", username));
		CartsDto body = this.cartService.listCartItems(user);
		return new ResponseEntity<CartsDto> (body,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<CartsDto> deleteCartItem(@RequestParam("cartItemId") Integer itemId, @RequestHeader(name="Authorization") String token){
		token=token.substring(7);
		String username = this.jwtTokenHelper.getUsernameFromToken(token);
		User user=this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User", "email", username));
		CartsDto body=cartService.deleteCartItem(itemId, user);
		return new ResponseEntity<CartsDto> (body,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-all")
	public ResponseEntity<CartsDto> deleteAllCartItem(@RequestHeader(name="Authorization") String token){
		token=token.substring(7);
		String username = this.jwtTokenHelper.getUsernameFromToken(token);
		User user=this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User", "email", username));
		CartsDto body=cartService.deleteAllCartItem(user);
		return new ResponseEntity<CartsDto> (body,HttpStatus.OK);
	}
}
