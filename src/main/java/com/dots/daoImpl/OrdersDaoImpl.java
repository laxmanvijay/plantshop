package com.dots.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dots.dao.OrdersDao;
import com.dots.dto.Orders;

@Repository("ordersdao")
@Transactional
public class OrdersDaoImpl implements OrdersDao {

	@Autowired
		SessionFactory sessionfactory;
	
	
	@Override
	public boolean createOrder(Orders o) {
		sessionfactory.getCurrentSession().persist(o);
		return true;
	}

	@Override
	public boolean removeOrder(Orders o) {
		sessionfactory.getCurrentSession().delete(o);
		sessionfactory.getCurrentSession().flush();
		return false;
	}

	@Override
	public List<Orders> getAllOrders() {
		return sessionfactory.getCurrentSession().createQuery("FROM Orders").getResultList();
	}

	@Override
	public List<Orders> getOrdersByEmail(String Email) {
		Query q=sessionfactory.getCurrentSession().createQuery("FROM Orders where user=:user");
		q.setParameter("user", Email);
		return q.getResultList();
	}

}
