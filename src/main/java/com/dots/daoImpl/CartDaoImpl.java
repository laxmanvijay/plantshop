package com.dots.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dots.dao.CartDao;
import com.dots.dto.Cart;

@Repository("cartdao")
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addToCart(Cart c) {
		try {
			sessionfactory.getCurrentSession().persist(c);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Cart> getProducts(String useremail) {
		String hql="from Cart where useremail=:useremail";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		query.setParameter( "useremail",useremail);
		return query.getResultList();
	
	}

	@Override
	public boolean removeProduct(Cart c) {
		try {
			sessionfactory.getCurrentSession().delete(c);
			sessionfactory.getCurrentSession().flush();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
