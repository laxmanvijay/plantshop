package com.dots.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dots.dao.RegisterDao;
import com.dots.dto.Register;

         /*******class for implementing registration*******/
@Repository("registerdao")
@Transactional
public class RegisterDaoImpl implements RegisterDao {

	
	@Autowired
	SessionFactory sessionfactory;
	
	
	//creating new user using sessionfactory persist() method
	@Override
	public boolean createUser(Register r) {
		
		try {
			sessionfactory.getCurrentSession().persist(r);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	
	}

	
	//deleting a user using the sessionfactory delete() method
	//and refreshing the database using the flush method
	@Override
	public boolean deleteUser(Register r) {
		
		try {
			sessionfactory.getCurrentSession().delete(r);
			sessionfactory.getCurrentSession().flush();
			
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	
	//getting the data of a single user using email
	//using hibernate query language(hql)
	@Override
	public Register getSingleUserWithEmail(String email) {

		String hql="FROM Register WHERE email=:email";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		query.setParameter("email", email);
		
		return (Register) query.uniqueResult();
	}

	
	
	//updating the details of a particular user using sessionfactory update() method
	@Override
	public boolean updateUser(Register r) {
		
		try {
			sessionfactory.getCurrentSession().update(r);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	
	//getting the details of single user with id using sessionfactory update() method
	@Override
	public Register getSingleUserWithId(int id) {
		
		return sessionfactory.getCurrentSession().get(Register.class, Integer.valueOf(id));
	}

	
	
	//checking if the user is already registered using the presence of email in database
	//using hibernate query language
	@Override
	public boolean checkUserAlreadyRegistered(String email) {
		List<Register> checkList=new ArrayList<>();
		String hql="FROM Register";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);	
		checkList=query.getResultList();
		
		//System.out.println(checkList);
		 
		//checking if email matches
		for(Register r:checkList) {
			if(r.getEmail().equals(email)) return true;
		}
		
		return false;
	}

	
	//matching the password of the user with email
	@Override
	public String checkUserPassword(String email, String password) {
		
		if(checkUserAlreadyRegistered(email)==true) {
			Register user=getSingleUserWithEmail(email);
			if(user.getPassword().equals(password))
			 {
			 return "logged in";
			}
			else return "password error";
		}
		else {
			return "not registered";
		}
	
	}

		
}
