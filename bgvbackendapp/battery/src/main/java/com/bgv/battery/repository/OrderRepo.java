package com.bgv.battery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bgv.battery.model.Order;
import com.bgv.battery.model.User;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

	List<Order> findAllByUser(User user);
}
