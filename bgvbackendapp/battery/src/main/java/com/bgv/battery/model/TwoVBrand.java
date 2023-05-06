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
@Table(name="two_v_brand")
public class TwoVBrand {

	//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="brand_id")
	private Integer id;
	
	@Column(name="brand_name")
	private String brandName;
	
	@OneToMany(mappedBy="twoVBrand", fetch=FetchType.LAZY)
	private List<TwoVModel> twoVModel;
	
	public TwoVBrand() {
		
	}

	//define constructors
	public TwoVBrand(String brandName) {
		this.brandName = brandName;
	}

	//define getters and setters
	public String getBrandName() {
		return brandName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public List<TwoVModel> getTwoVModel() {
		return twoVModel;
	}

	public void setTwoVModel(List<TwoVModel> twoVModel) {
		this.twoVModel = twoVModel;
	}

	//define tostring
	@Override
	public String toString() {
		return "TwoVBrand [id=" + id + ", brandName=" + brandName + ", twoVModel=" + twoVModel + "]";
	}
}
