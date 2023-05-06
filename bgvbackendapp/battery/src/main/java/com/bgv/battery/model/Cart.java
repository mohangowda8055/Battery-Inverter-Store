package com.bgv.battery.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private Integer id;
	
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_brand")
	private String productBrand;
	
	@Column(name="product_mrp")
	private int productMrp;
	
	@Column(name="product_rebate")
	private int productRebate;
	
	@Column(name="product_quantity")
	private int productQuantity;
	
	@Column(name="pincode")
	private int pincode;
	
	@Column(name="old_battery")
	private boolean oldBattery;
	
	@Column(name="price")
	private int price;
	
	@CreationTimestamp
	@Column(name="item_added_date")
	private Date cartDateTime;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	public Cart() {
		
	}

	public Cart(Integer productId, String productName, String productBrand, int productMrp, int productRebate,
			int productQuantity, int pincode, boolean oldBattery, int price, Date cartDateTime, User user) {
		this.productId = productId;
		this.productName = productName;
		this.productBrand = productBrand;
		this.productMrp = productMrp;
		this.productRebate = productRebate;
		this.productQuantity = productQuantity;
		this.pincode = pincode;
		this.oldBattery = oldBattery;
		this.price = price;
		this.cartDateTime = cartDateTime;
		this.user = user;
	}

	public Date getCartDateTime() {
		return cartDateTime;
	}

	public void setCartDateTime(Date cartDateTime) {
		this.cartDateTime = cartDateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public int getProductMrp() {
		return productMrp;
	}

	public void setProductMrp(int productMrp) {
		this.productMrp = productMrp;
	}

	public int getProductRebate() {
		return productRebate;
	}

	public void setProductRebate(int productRebate) {
		this.productRebate = productRebate;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public boolean isOldBattery() {
		return oldBattery;
	}

	public void setOldBattery(boolean oldBattery) {
		this.oldBattery = oldBattery;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
