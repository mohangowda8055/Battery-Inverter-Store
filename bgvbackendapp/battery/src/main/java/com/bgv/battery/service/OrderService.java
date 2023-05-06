package com.bgv.battery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bgv.battery.dto.OrderDto;
import com.bgv.battery.dto.ShowOrderDto;
import com.bgv.battery.model.Order;
import com.bgv.battery.model.User;

@Service
public interface OrderService {

	public OrderDto addOrder(Order order, User user);
	
	public void cancelOrder(Integer orderId);
	
	public List<ShowOrderDto> showOrders(User user);
}
