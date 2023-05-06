package com.bgv.battery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bgv.battery.model.InvCapacity;

@Repository
public interface InvCapacityRepo extends JpaRepository<InvCapacity, Integer> {

}
