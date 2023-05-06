package com.bgv.battery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bgv.battery.model.CommerVBrand;

@Repository
public interface CommerVBrandRepo extends JpaRepository<CommerVBrand, Integer> {

}
