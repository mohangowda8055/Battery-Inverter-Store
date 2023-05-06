package com.bgv.battery.dto;

import com.bgv.battery.model.Order;
import com.bgv.battery.model.OrderItem;

public class ShowOrderDto {

	private Integer orderItemId;
	
	private String productName;
	
	private int productQty;
	
	private double productPrice;
	
	private String orderStatus;
	
	private boolean oldBattery;
	
	private Integer orderId;
	
	public ShowOrderDto() {
		
	}

	public ShowOrderDto(Integer orderItemId, String productName, int productQty, double productPrice,
			String orderStatus, boolean oldBattery, Integer orderId) {
		this.orderItemId = orderItemId;
		this.productName = productName;
		this.productQty = productQty;
		this.productPrice = productPrice;
		this.orderStatus = orderStatus;
		this.oldBattery = oldBattery;
		this.orderId = orderId;
	}
	
	public ShowOrderDto(Order order, OrderItem orderItem) {
		this.orderItemId = orderItem.getId();
		this.productName = orderItem.getProductName();
		this.productQty = orderItem.getProductQty();
		this.productPrice = orderItem.getProductPrice();
		this.orderStatus = order.getOrderStatus();
		this.oldBattery = orderItem.isOldBattery();
		this.orderId = order.getId();
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
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

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public boolean isOldBattery() {
		return oldBattery;
	}

	public void setOldBattery(boolean oldBattery) {
		this.oldBattery = oldBattery;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
}
