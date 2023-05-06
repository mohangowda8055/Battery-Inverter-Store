package com.bgv.battery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bgv.battery.model.TwoVBrand;

@Repository
public interface TwoVBrandRepo extends JpaRepository<TwoVBrand, Integer> {

}
