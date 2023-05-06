package com.bgv.battery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bgv.battery.model.FourVBrand;

@Repository
public interface FourVBrandRepo extends JpaRepository<FourVBrand, Integer> {

}
