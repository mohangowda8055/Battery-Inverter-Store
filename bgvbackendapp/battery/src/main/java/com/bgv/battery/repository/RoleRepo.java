package com.bgv.battery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bgv.battery.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
