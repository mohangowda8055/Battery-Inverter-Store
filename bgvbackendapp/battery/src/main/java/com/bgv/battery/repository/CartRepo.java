package com.bgv.battery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bgv.battery.model.Cart;
import com.bgv.battery.model.User;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

	List<Cart> findAllByUser(User user);
}
