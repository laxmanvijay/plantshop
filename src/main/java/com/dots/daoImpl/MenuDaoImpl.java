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

@Repository("menudao")
@Transactional
public class MenuDaoImpl implements MenuDao {

	@Autowired 
	SessionFactory sessionFactory;
	
	static List<Menu> menus=new ArrayList<Menu>();
	
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

	@Override
	public List<Menu> list() {
		String hql = "from Menu";
		
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println(query.getResultList());
		return query.getResultList();
	}

	
	//returning a single row
	@Override
	public Menu getSingleMenu(int id) {
		
		return sessionFactory.getCurrentSession().get(Menu.class,Integer.valueOf(id));
	
	}

	@Override
	public Menu getAllMenu() {
		// TODO Auto-generated method stub
		return null;
	}


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
