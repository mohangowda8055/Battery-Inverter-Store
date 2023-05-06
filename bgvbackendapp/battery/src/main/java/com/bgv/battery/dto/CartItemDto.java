package com.bgv.battery.dto;

import java.util.Date;

public class CartItemDto {

	private Integer id;
	
    private Integer productId;
	
	private String productName;
	
	private String productBrand;
	
	private int productMrp;
	
	private int productRebate;

	private int productQuantity;
	
	private int pincode;
	
	private boolean oldBattery;
	
	private int price;
	
	private Date cartDateTime;

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

	public Date getCartDateTime() {
		return cartDateTime;
	}

	public void setCartDateTime(Date cartDateTime) {
		this.cartDateTime = cartDateTime;
	}
	
}
