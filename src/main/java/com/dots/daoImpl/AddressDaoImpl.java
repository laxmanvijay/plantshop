package com.dots.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dots.dao.AddressDao;
import com.dots.dto.Address;
import com.dots.dto.Register;

@Repository("addressdao")
@Transactional
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public boolean createAddress(Address a) {
		try {
			sessionfactory.getCurrentSession().persist(a);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteAddress(Address a) {
		try {
			sessionfactory.getCurrentSession().delete(a);
			sessionfactory.getCurrentSession().flush();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateAddress(Address a) {
		try {
			sessionfactory.getCurrentSession().update(a);
			return true;
		} catch (Exception e) {
		return false;
		}
	}

	@Override
	public List<? extends Address> getAddressByUser(Register user) {
		List<Address> listOfAddress =new ArrayList<>();
		String query="FROM Address where user=:user";
		Query q=sessionfactory.getCurrentSession().createQuery(query);
		q.setParameter("user", user);
		listOfAddress =q.getResultList();
		return listOfAddress;
	}

}
