package com.bgv.battery.service;

import org.springframework.stereotype.Service;

import com.bgv.battery.dto.CartDTO;
import com.bgv.battery.dto.CartsDto;
import com.bgv.battery.model.User;

@Service
public interface CartService {

	public void addToCart(CartDTO cartDTO, User user);
	
	public CartsDto updateCart(CartDTO cartDTO, Integer cartItemId, User user);

	public CartsDto listCartItems(User user);

	public CartsDto deleteCartItem(Integer itemId, User user);

	public CartsDto deleteAllCartItem(User user);

	
}
