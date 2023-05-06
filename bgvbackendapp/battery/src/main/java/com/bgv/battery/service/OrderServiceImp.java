package com.bgv.battery.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgv.battery.dto.CartItemDto;
import com.bgv.battery.dto.CartsDto;
import com.bgv.battery.dto.OrderDto;
import com.bgv.battery.dto.ShowOrderDto;
import com.bgv.battery.exceptions.ResourceNotFoundException;
import com.bgv.battery.model.Order;
import com.bgv.battery.model.OrderItem;
import com.bgv.battery.model.User;
import com.bgv.battery.repository.OrderItemRepo;
import com.bgv.battery.repository.OrderRepo;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private OrderItemRepo orderItemRepo;
	
	@Override
	public OrderDto addOrder(Order _order, User user) {
		
	CartsDto cart=cartService.listCartItems(user);
	List<CartItemDto> cartItems =cart.getCartItems();
	Order order = new Order();
    
    	Set<OrderItem> orders=cartItems.stream().map((item)->{
    	OrderItem orderItemDto = new OrderItem();
    orderItemDto.setProductId(item.getProductId());
    orderItemDto.setProductName(item.getProductName());
    orderItemDto.setProductQty(item.getProductQuantity());
    orderItemDto.setOldBattery(item.isOldBattery());
    orderItemDto.setProductPrice(item.getPrice());
    orderItemDto.setOrder(order);
//    order.setDeliveryPincode(item.getPincode());
		return orderItemDto;
    	}).collect(Collectors.toSet());
    	order.setOrderStatus("Placed");
    	order.setPaymentStatus("Pending");
    	order.setPaymentType(_order.getPaymentType());
    	order.setPaymentAmt(_order.getPaymentAmt());
    	order.setOrderDateTime(new Date());
    	order.setDeliveryPincode(_order.getDeliveryPincode());
    	order.setDeliveryAddress(_order.getDeliveryAddress());
    	order.setPhoneNo(_order.getPhoneNo());
    	order.setUser(user);
    	order.setOrderItem(orders);
    	Order result=this.orderRepo.save(order);
    	for(OrderItem item : orders ) {
    		item.setOrder(order);
    		this.orderItemRepo.save(item);
    	}
    	return convertEntityToOrderDto(result);
	}
	
	@Override
	public void cancelOrder(Integer orderId) {
	     Optional<Order> optionalOrder = this.orderRepo.findById(orderId);
	     if(optionalOrder.isEmpty()) {
				throw new ResourceNotFoundException("cart item", "Id", orderId);
			}
	     Order order= optionalOrder.get();
	     order.setOrderStatus("Cancelled");
	     this.orderRepo.save(order);
	}
	
	@Override
	public List<ShowOrderDto> showOrders(User user) {
		
		List<ShowOrderDto> show = new ArrayList<>();
		List<Order> orders = this.orderRepo.findAllByUser(user);
		for(Order order : orders) {
		List<OrderItem> orderItems =this.orderItemRepo.findAllByOrder(order);
		for(OrderItem orderItem : orderItems) {
			ShowOrderDto showOrderDto = new ShowOrderDto();
			showOrderDto.setOrderItemId(orderItem.getId());
			showOrderDto.setProductName(orderItem.getProductName());
			showOrderDto.setProductQty(orderItem.getProductQty());
			showOrderDto.setProductPrice(orderItem.getProductPrice());
			showOrderDto.setOldBattery(orderItem.isOldBattery());
			showOrderDto.setOrderItemId(orderItem.getId());
			showOrderDto.setOrderStatus(order.getOrderStatus());
			showOrderDto.setOrderId(order.getId());
			show.add(showOrderDto);
		}
		}
		return show;
	}
	
	public OrderDto convertEntityToOrderDto(Order order) {
		OrderDto orderDto = new OrderDto(order);
		return orderDto;
	}
	
	public ShowOrderDto convertEntityToShowOrderDto(Order order, OrderItem orderItem) {
		ShowOrderDto showOrderDto = new ShowOrderDto();
		return showOrderDto;
	}
	

}
