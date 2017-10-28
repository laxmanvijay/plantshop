package com.dots.dao;

import java.util.List;

import com.dots.dto.Product;


public interface ProductDao {
	
	boolean createProduct(Product p);
	
	List<Product> allProducts();
	List<Product> getProductByCategory(String category);
	Product getProductById(int id);
	
	boolean updateProduct(Product p);
	
	boolean deleteProduct(Product p);
	

	
}
