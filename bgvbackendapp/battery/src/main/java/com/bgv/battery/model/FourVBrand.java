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
@Table(name="four_v_brand")
public class FourVBrand {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="brand_id")
	private Integer id;
	
	@Column(name="brand_name")
	private String brandName;
	
	@OneToMany(mappedBy="fourVBrand", fetch=FetchType.LAZY)
	private List<FourVModel> fourVModel;
	
	public FourVBrand() {
		
	}

	public FourVBrand(String brandName) {
		this.brandName = brandName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public List<FourVModel> getFourVModel() {
		return fourVModel;
	}

	public void setFourVModel(List<FourVModel> fourVModel) {
		this.fourVModel = fourVModel;
	}

}
