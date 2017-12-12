package com.dots.dao;

import java.util.List;

import com.dots.dto.Cart;
import com.dots.dto.Register;

public interface CartDao {
	
	
	boolean addToCart(Cart c);
	List<Cart> getProducts(Register user);
	boolean removeProduct(Cart c);
	
}
