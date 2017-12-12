package com.dots.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dots.dao.CartDao;
import com.dots.dto.Cart;
import com.dots.dto.Register;

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
	public List<Cart> getProducts(Register user) {
		String hql="from Cart where user=:user";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		query.setParameter( "user",user);
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
