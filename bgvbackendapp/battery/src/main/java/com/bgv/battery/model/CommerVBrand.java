package com.bgv.battery.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="commer_v_brand")
public class CommerVBrand {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="brand_id")
	private int id;
	
	@Column(name="brand_name")
	private String brandName;
	
	@OneToMany(mappedBy="commerVBrand", fetch=FetchType.LAZY)
	private List<CommerVSegment> commerVSegment;
	
	public CommerVBrand() {
		
	}

	public CommerVBrand(String brandName) {
		this.brandName = brandName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public List<CommerVSegment> getCommerVSegment() {
		return commerVSegment;
	}

	public void setCommerVSegment(List<CommerVSegment> commerVSegment) {
		this.commerVSegment = commerVSegment;
	}

}
