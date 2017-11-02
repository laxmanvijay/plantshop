package com.dots.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dots.dao.ProductDao;
import com.dots.dto.Product;
import com.dots.dto.Register;


@Repository("productdao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean createProduct(Product p) {
		
		try {
			sessionfactory.getCurrentSession().persist(p);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	@Override
	public List<Product> allProducts() {
		String hql="FROM Product";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
		
	}

	@Override
	public boolean updateProduct(Product p) {
		try {
			sessionfactory.getCurrentSession().update(p);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	@Override
	public boolean deleteProduct(Product p) {
		try {
			sessionfactory.getCurrentSession().delete(p);
			sessionfactory.getCurrentSession().flush();
			
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		String hql="FROM Product WHERE category=:category";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		query.setParameter("category", category);
		return query.getResultList();
		
	}

	@Override
	public Product getProductById(int id) {
		
		return sessionfactory.getCurrentSession().get(Product.class,Integer.valueOf(id));
	}

	@Override
	public Product getProductByName(String name) {
		String hql="FROM Product WHERE category=:category";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		query.setParameter("category", name);
		return (Product) query.uniqueResult();
	}

}
