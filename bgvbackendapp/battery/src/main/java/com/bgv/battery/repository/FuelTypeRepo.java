package com.bgv.battery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bgv.battery.model.FuelType;

@Repository
public interface FuelTypeRepo extends JpaRepository<FuelType, Integer> {

}
