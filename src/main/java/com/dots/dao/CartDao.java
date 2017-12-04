package com.dots.dao;

import java.util.List;

import com.dots.dto.Cart;

public interface CartDao {
	
	
	boolean addToCart(Cart c);
	List<Cart> getProducts(String useremail);
	boolean removeProduct(Cart c);
	
}
