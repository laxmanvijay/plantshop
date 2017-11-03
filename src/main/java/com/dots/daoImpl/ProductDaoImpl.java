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

          /*********implementing methods for a particular product*********/
@Repository("productdao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionfactory;
	
	
	
	//creating product using the sessionfacctory persist() method
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

	
	
	
	//retreiving all the products from the database using hql
	@Override
	public List<Product> allProducts() {
		String hql="FROM Product";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
		
	}

	
	
	
	//updating  a particular product using the update method of sessionfactory
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

	
	
	
	//deleting a particular product using the delete method of sessionfactory and then refreshing
	//the database using flush method of sessionfactory
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

	
	
	//retrieving all the products of a particular category
	@Override
	public List<Product> getProductByCategory(String category) {
		String hql="FROM Product WHERE category=:category";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		query.setParameter("category", category);
		return query.getResultList();
		
	}

	
	
	
	//retrieving a product by it's id
	@Override
	public Product getProductById(int id) {
		
		return sessionfactory.getCurrentSession().get(Product.class,Integer.valueOf(id));
	}

	
	//retrieving a product by it's name
	@Override
	public Product getProductByName(String name) {
		String hql="FROM Product WHERE category=:category";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		query.setParameter("category", name);
		return (Product) query.uniqueResult();
	}

}
