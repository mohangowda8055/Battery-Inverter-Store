package com.bgv.battery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bgv.battery.model.ThreeVBrand;

@Repository
public interface ThreeVBrandRepo extends JpaRepository<ThreeVBrand, Integer> {

}
