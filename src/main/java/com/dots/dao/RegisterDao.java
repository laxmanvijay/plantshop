package com.dots.dao;

import java.util.List;

import com.dots.dto.Register;

public interface RegisterDao {
	
	boolean createUser(Register r);
	boolean deleteUser(Register r);
	List<Register> getSingleUserWithEmail(String email);
	Register getSingleUserWithId(int id);
	boolean updateUser(Register r);
	boolean checkUserAlreadyRegistered(String email);
	boolean checkUserPassword(String email,String password);

}
