package com.bgv.battery.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="commer_v_segment")
public class CommerVSegment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="segment_id")
	private int id;
	
	@Column(name="segment_name")
	private String segmentName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="brand_id")
	private CommerVBrand commerVBrand;
	
	@OneToMany(mappedBy="commerVSegment", fetch=FetchType.LAZY)
	private List<CommerVModel> commerVModel;
	
	public CommerVSegment() {
		
	}

	public CommerVSegment(String segmentName, CommerVBrand commerVBrand) {
		this.segmentName = segmentName;
		this.commerVBrand = commerVBrand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSegmentName() {
		return segmentName;
	}

	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}

	public CommerVBrand getCommerVBrand() {
		return commerVBrand;
	}

	public void setCommerVBrand(CommerVBrand commerVBrand) {
		this.commerVBrand = commerVBrand;
	}

	public List<CommerVModel> getCommerVModel() {
		return commerVModel;
	}

	public void setCommerVModel(List<CommerVModel> commerVModel) {
		this.commerVModel = commerVModel;
	}

}
