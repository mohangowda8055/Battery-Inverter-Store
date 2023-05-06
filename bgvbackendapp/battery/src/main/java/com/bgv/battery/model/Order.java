package com.bgv.battery.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private Integer id;
	
	@Column(name="order_status")
	private String orderStatus;
	
	@Column(name="delivery_address")
	private String deliveryAddress;
	
	@Column(name="payment_status")
	private String paymentStatus;
	
	@Column(name="payment_type")
	private String paymentType;
	
	@CreationTimestamp
	@Column(name="order_created_date")
	private Date orderDateTime;
	
	@Column(name="order_delivered_date")
	private Date orderDeliveredTime;
	
	@Column(name="phone_no")
	private String phoneNo;
	
	@Column(name="order_amt")
	private double paymentAmt;
	
	@Column(name="delivery_pincode")
	private int deliveryPincode;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="order")
	private Set<OrderItem> orderItem = new HashSet<>();

	public Order() {
		
	}
	
	public Order(String orderStatus, String deliveryAddress, String paymentStatus, String paymentType,
			Date orderDateTime, Date orderDeliveredTime, String phoneNo, double paymentAmt, int deliveryPincode,
			User user, Set<OrderItem> orderItem) {
		this.orderStatus = orderStatus;
		this.deliveryAddress = deliveryAddress;
		this.paymentStatus = paymentStatus;
		this.paymentType = paymentType;
		this.orderDateTime = orderDateTime;
		this.orderDeliveredTime = orderDeliveredTime;
		this.phoneNo = phoneNo;
		this.paymentAmt = paymentAmt;
		this.deliveryPincode = deliveryPincode;
		this.user = user;
		this.orderItem = orderItem;
	}
	
	public Date getOrderDeliveredTime() {
		return orderDeliveredTime;
	}

	public void setOrderDeliveredTime(Date orderDeliveredTime) {
		this.orderDeliveredTime = orderDeliveredTime;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
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
	
}
