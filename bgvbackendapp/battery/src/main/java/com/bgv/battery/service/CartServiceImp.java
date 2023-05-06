package com.bgv.battery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgv.battery.dto.CartDTO;
import com.bgv.battery.dto.CartItemDto;
import com.bgv.battery.dto.CartsDto;
import com.bgv.battery.exceptions.ResourceNotFoundException;
import com.bgv.battery.model.Cart;
import com.bgv.battery.model.User;
import com.bgv.battery.repository.CartRepo;

@Service
public class CartServiceImp implements CartService {

	@Autowired
	private CartRepo cartRepo;
	
	@Override
	public void addToCart(CartDTO cartDTO, User user) {
		Cart cart = this.convertCartDTOToCart(cartDTO);
		cart.setUser(user);
		this.cartRepo.save(cart);
	}
	
	
	@Override
	public CartsDto listCartItems(User user) {
		List<Cart> cartList = cartRepo.findAllByUser(user);
		List<CartItemDto> cartItems = new ArrayList<>();
		double totalCost = 0;
		for (Cart cart: cartList) {
			CartItemDto cartItemDto = this.convertEntityToCartItemDto(cart);
			totalCost += cartItemDto.getPrice() * cartItemDto.getProductQuantity();
			cartItems.add(cartItemDto);
		}
		CartsDto cartDto = new CartsDto();
		cartDto.setTotalCost(totalCost);
		cartDto.setCartItems(cartItems);
		return cartDto;
	}

	@Override
	public CartsDto deleteCartItem(Integer cartItemId, User user) {
		
		Optional<Cart> optionalCart = cartRepo.findById(cartItemId);
		if(optionalCart.isEmpty()) {
			throw new ResourceNotFoundException("cart item", "Id", cartItemId);
		}
		 Cart cart = optionalCart.get();
		 if (cart.getUser() != user) {
			 throw new ResourceNotFoundException("user", "user", "cart item does not belong to user");
		 }
		 cartRepo.delete(cart);
		 
		 List<Cart> cartsList = cartRepo.findAllByUser(user);
			List<CartItemDto> cartItems = new ArrayList<>();
			double totalCost = 0;
			for (Cart carts: cartsList) {
				CartItemDto cartItemDto = this.convertEntityToCartItemDto(carts);
				totalCost += cartItemDto.getPrice() * cartItemDto.getProductQuantity();
				cartItems.add(cartItemDto);
			}
			CartsDto cartDto = new CartsDto();
			cartDto.setTotalCost(totalCost);
			cartDto.setCartItems(cartItems);
			return cartDto;
		}
	
	@Override
	public CartsDto deleteAllCartItem(User user) {
		List<Cart> cartList = cartRepo.findAllByUser(user);
		cartRepo.deleteAll(cartList);
		
		List<Cart> cartsList = cartRepo.findAllByUser(user);
		List<CartItemDto> cartItems = new ArrayList<>();
		double totalCost = 0;
		for (Cart carts: cartsList) {
			CartItemDto cartItemDto = this.convertEntityToCartItemDto(carts);
			totalCost += cartItemDto.getPrice() * cartItemDto.getProductQuantity();
			cartItems.add(cartItemDto);
		}
		CartsDto cartDto = new CartsDto();
		cartDto.setTotalCost(totalCost);
		cartDto.setCartItems(cartItems);
		return cartDto;
	}

	@Override
	public CartsDto updateCart(CartDTO cartDTO, Integer cartItemId, User user) {
		Optional<Cart> optionalCart = cartRepo.findById(cartItemId);
		if(optionalCart.isEmpty()) {
			throw new ResourceNotFoundException("cart item", "Id", cartItemId);
		}
			Cart cart = optionalCart.get();
			 if (cart.getUser() != user) {
				 throw new ResourceNotFoundException("user", "user", "cart item does not belong to user");
			 }
			 
			 cart.setOldBattery(cartDTO.isOldBattery());
			 cart.setPincode(cartDTO.getPincode());
			 cart.setProductQuantity(cartDTO.getProductQuantity());
			 cart.setPrice(cartDTO.getPrice());
			 this.cartRepo.save(cart);
			 
			 List<Cart> cartList = cartRepo.findAllByUser(user);
				List<CartItemDto> cartItems = new ArrayList<>();
				double totalCost = 0;
				for (Cart carts: cartList) {
					CartItemDto cartItemDto = this.convertEntityToCartItemDto(carts);
					totalCost += cartItemDto.getPrice() * cartItemDto.getProductQuantity();
					cartItems.add(cartItemDto);
				}
				CartsDto cartDto = new CartsDto();
				cartDto.setTotalCost(totalCost);
				cartDto.setCartItems(cartItems);
				return cartDto;
		}
		
	public CartDTO convertEntityToCartDTO(Cart cart) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setId(cart.getId());
		cartDTO.setProductId(cart.getProductId());
		cartDTO.setProductName(cart.getProductName());
		cartDTO.setProductBrand(cart.getProductBrand());
		cartDTO.setProductMrp(cart.getProductMrp());
		cartDTO.setProductRebate(cart.getProductRebate());
		cartDTO.setProductQuantity(cart.getProductQuantity());
		cartDTO.setOldBattery(cart.isOldBattery());
		cartDTO.setPincode(cart.getPincode());
		cartDTO.setPrice(cart.getPrice());
		cartDTO.setCartDateTime(cart.getCartDateTime());
		return cartDTO;
	}
	
	public Cart convertCartDTOToCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		cart.setId(cartDTO.getId());
		cart.setProductId(cartDTO.getProductId());
		cart.setProductName(cartDTO.getProductName());
		cart.setProductBrand(cartDTO.getProductBrand());
		cart.setProductMrp(cartDTO.getProductMrp());
		cart.setProductRebate(cartDTO.getProductRebate());
		cart.setProductQuantity(cartDTO.getProductQuantity());
		cart.setOldBattery(cartDTO.isOldBattery());
		cart.setPincode(cartDTO.getPincode());
		cart.setPrice(cartDTO.getPrice());
		cart.setCartDateTime(cartDTO.getCartDateTime());
		return cart;
	}
	
	public CartItemDto convertEntityToCartItemDto(Cart cart) {
		CartItemDto cartDTO = new CartItemDto();
		cartDTO.setId(cart.getId());
		cartDTO.setProductId(cart.getProductId());
		cartDTO.setProductName(cart.getProductName());
		cartDTO.setProductBrand(cart.getProductBrand());
		cartDTO.setProductMrp(cart.getProductMrp());
		cartDTO.setProductRebate(cart.getProductRebate());
		cartDTO.setProductQuantity(cart.getProductQuantity());
		cartDTO.setOldBattery(cart.isOldBattery());
		cartDTO.setPincode(cart.getPincode());
		cartDTO.setPrice(cart.getPrice());
		cartDTO.setCartDateTime(cart.getCartDateTime());
		return cartDTO;
	}
		
	}


