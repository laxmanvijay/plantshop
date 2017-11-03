package com.dots.dao;

import java.util.List;

import com.dots.dto.Menu;

public interface MenuDao {
	
	List<Menu> list();
	
	boolean addMenu(Menu m);
	
	Menu getSingleMenu(int id);
	
	boolean updateMenu(Menu m);
	
	boolean trueDelete(Menu m);
	
	
	
	
	

}
