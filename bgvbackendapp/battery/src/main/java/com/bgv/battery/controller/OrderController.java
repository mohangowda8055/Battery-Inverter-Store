package com.bgv.battery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bgv.battery.common.ApiResponse;
import com.bgv.battery.dto.OrderDto;
import com.bgv.battery.dto.ShowOrderDto;
import com.bgv.battery.exceptions.ResourceNotFoundException;
import com.bgv.battery.model.Order;
import com.bgv.battery.model.User;
import com.bgv.battery.repository.UserRepo;
import com.bgv.battery.security.JwtTokenHelper;
import com.bgv.battery.service.OrderService;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@PostMapping("/create")
	public ResponseEntity<OrderDto> createOrder(@RequestBody Order order, @RequestHeader(name="Authorization") String token){
		
		token=token.substring(7);
		String username = this.jwtTokenHelper.getUsernameFromToken(token);
		User user=this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User", "email", username));
		OrderDto body = orderService.addOrder( order, user);
		return new ResponseEntity<OrderDto> (body,HttpStatus.OK);
	}
	
	@PutMapping("/{orderId}")
	public ResponseEntity<ApiResponse> cancelOrder(@PathVariable Integer orderId){
		this.orderService.cancelOrder(orderId);
		return new ResponseEntity<>(new ApiResponse(true, "Cancelled Order"), HttpStatus.OK);
	}
		
	@GetMapping("/show")
	public ResponseEntity<List<ShowOrderDto>> showOrders(@RequestHeader(name="Authorization") String token){
		
		token=token.substring(7);
		String username = this.jwtTokenHelper.getUsernameFromToken(token);
		User user=this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User", "email", username));
		List<ShowOrderDto> orders =this.orderService.showOrders(user);
		return new ResponseEntity<List<ShowOrderDto>> (orders, HttpStatus.OK);
	}
}
