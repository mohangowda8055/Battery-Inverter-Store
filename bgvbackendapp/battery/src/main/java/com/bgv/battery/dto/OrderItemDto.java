package com.bgv.battery.dto;

import com.bgv.battery.model.Order;
import com.bgv.battery.model.OrderItem;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrderItemDto {

		private Integer id;
		
		private int productId;
		
		private String productName;
		
		private int productQty;
		
		private boolean oldBattery;
		
		private double productPrice;

		@JsonIgnore
		private Order order;
		
	public OrderItemDto() {
		
	}

	public OrderItemDto(int productId, String productName, int productQty, boolean oldBattery, double productPrice,
			Order order) {
		this.productId = productId;
		this.productName = productName;
		this.productQty = productQty;
		this.oldBattery = oldBattery;
		this.productPrice = productPrice;
		this.order = order;
	}
	
	public OrderItemDto(OrderItem orderItem) {
		this.setId(orderItem.getId());
		this.setProductId(orderItem.getProductId());
		this.setProductName(orderItem.getProductName());
		this.setProductQty(orderItem.getProductQty());
		this.setProductPrice(orderItem.getProductPrice());
		this.setOldBattery(orderItem.isOldBattery());
		this.setOrder(orderItem.getOrder());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public boolean isOldBattery() {
		return oldBattery;
	}

	public void setOldBattery(boolean oldBattery) {
		this.oldBattery = oldBattery;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
