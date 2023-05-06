package com.bgv.battery.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.bgv.battery.model.Order;
import com.bgv.battery.model.OrderItem;
import com.bgv.battery.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrderDto {

	private Integer id;
	
	private String orderStatus;
	
	private String paymentStatus;
	
	private String paymentType;
	
	private Date orderDeliveredTime;
	
	private Date orderDateTime;
	
	private double paymentAmt;
	
	private int deliveryPincode;
	
	private String deliveryAddress;
	
	private String phoneNo;
	
	@JsonIgnore
	private User user;
	
	@JsonIgnore
	private Set<OrderItem> orderItem = new HashSet<>();
	
	public OrderDto() {
		
	}

	public OrderDto(String orderStatus, String paymentStatus, String paymentType, Date orderDeliveredTime,
			Date orderDateTime, double paymentAmt, int deliveryPincode, String deliveryAddress, String phoneNo,
			User user, Set<OrderItem> orderItem) {
		this.orderStatus = orderStatus;
		this.paymentStatus = paymentStatus;
		this.paymentType = paymentType;
		this.orderDeliveredTime = orderDeliveredTime;
		this.orderDateTime = orderDateTime;
		this.paymentAmt = paymentAmt;
		this.deliveryPincode = deliveryPincode;
		this.deliveryAddress = deliveryAddress;
		this.phoneNo = phoneNo;
		this.user = user;
		this.orderItem = orderItem;
	}



	public OrderDto(Order order) {
		
		this.setId(order.getId());
		this.setOrderStatus(order.getOrderStatus());
		this.setPaymentStatus(order.getPaymentStatus());
		this.setPaymentAmt(order.getPaymentAmt());
		this.setPaymentType(order.getPaymentType());
		this.setDeliveryPincode(order.getDeliveryPincode());
		this.setOrderDateTime(order.getOrderDateTime());
        this.setOrderDeliveredTime(order.getOrderDeliveredTime());
        this.setPhoneNo(order.getPhoneNo());
		this.setDeliveryAddress(order.getDeliveryAddress());
		this.setUser(order.getUser());
//		Set<Integer> id= new HashSet<>();
//		Set<OrderItem> orders= order.getOrderItem();
//		for(OrderItem orderItem:orders) {
//			id.add(orderItem.getId());
//		}
//		this.setOrderItem(id);
		this.setOrderItem(order.getOrderItem());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(Date orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public Date getOrderDeliveredTime() {
		return orderDeliveredTime;
	}

	public void setOrderDeliveredTime(Date orderDeliveredTime) {
		this.orderDeliveredTime = orderDeliveredTime;
	}

	public double getPaymentAmt() {
		return paymentAmt;
	}

	public void setPaymentAmt(double paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	public int getDeliveryPincode() {
		return deliveryPincode;
	}

	public void setDeliveryPincode(int deliveryPincode) {
		this.deliveryPincode = deliveryPincode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(Set<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
}
