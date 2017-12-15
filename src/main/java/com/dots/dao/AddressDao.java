package com.dots.dao;

import java.util.List;

import com.dots.dto.Address;
import com.dots.dto.Register;

public interface AddressDao {

	boolean createAddress(Address a);
	boolean deleteAddress(Address a);
	boolean updateAddress(Address a);
	List<? extends Address> getAddressByUser(Register user);
	
}
