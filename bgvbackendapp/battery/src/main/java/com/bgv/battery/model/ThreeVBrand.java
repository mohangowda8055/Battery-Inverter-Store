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
@Table(name="three_v_brand")
public class ThreeVBrand {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="brand_id")
	private Integer id;
	
	@Column(name="brand_name")
	private String brandName;
	
	@OneToMany(mappedBy="threeVBrand", fetch=FetchType.LAZY)
	private List<ThreeVModel> threeVModel;
	
	public ThreeVBrand() {
		
	}

	public ThreeVBrand(String brandName) {
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

	
	public List<ThreeVModel> getThreeVModel() {
		return threeVModel;
	}

	public void setThreeVModel(List<ThreeVModel> threeVModel) {
		this.threeVModel = threeVModel;
	}

}
