package com.bgv.battery.dto;

import java.util.List;

public class CartsDto {

	private List<CartItemDto> cartItems;
	
	private double totalCost;
	
	public CartsDto() {
		
	}

	public List<CartItemDto> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemDto> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
