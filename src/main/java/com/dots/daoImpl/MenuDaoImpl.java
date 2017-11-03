package com.dots.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dots.dao.MenuDao;
import com.dots.dto.Menu;

					/****implementation of menu*****/
@Repository("menudao")
@Transactional
public class MenuDaoImpl implements MenuDao {

	@Autowired 
	SessionFactory sessionFactory;
	
	
	//list for storing all products
	static List<Menu> menus=new ArrayList<Menu>();
	
	
	//add a menu using sessionfactory persist() method
	public boolean addMenu(Menu m) {
		
		try {
			sessionFactory.getCurrentSession().persist(m);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	//updating a particular menu using sessionfactory update() method
    public boolean updateMenu(Menu m) {
		
		try {
			sessionFactory.getCurrentSession().update(m);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

    //getting all the products stored in the database
	@Override
	public List<Menu> list() {
		String hql = "from Menu";
		
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println(query.getResultList());
		return query.getResultList();
	}

	
	//returning a single row using id via sessionfactory get() meethod
	@Override
	public Menu getSingleMenu(int id) {
		
		return sessionFactory.getCurrentSession().get(Menu.class,Integer.valueOf(id));
	
	}


	//complete deletion of a particular entry from the database using sessionfactory delete() method
	//and refreshing the database using sessionfactory flush() method
	@Override
	public boolean trueDelete(Menu m) {
		try {
			sessionFactory.getCurrentSession().delete(m);
			sessionFactory.getCurrentSession().flush();
			
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
