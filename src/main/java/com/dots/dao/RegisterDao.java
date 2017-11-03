package com.dots.dao;

import java.util.List;

import com.dots.dto.Register;

public interface RegisterDao {
	
	boolean createUser(Register r);
	boolean deleteUser(Register r);
	Register getSingleUserWithEmail(String email);
	Register getSingleUserWithId(int id);
	boolean updateUser(Register r);
	boolean checkUserAlreadyRegistered(String email);
	String checkUserPassword(String email,String password);

}
