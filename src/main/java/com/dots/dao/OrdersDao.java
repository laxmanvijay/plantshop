package com.dots.dao;

import java.util.List;

import com.dots.dto.Orders;

public interface OrdersDao {

	boolean createOrder(Orders o);
	boolean removeOrder(Orders o);
	List<Orders> getAllOrders();
	List<Orders> getOrdersByEmail(String Email);
	
}
