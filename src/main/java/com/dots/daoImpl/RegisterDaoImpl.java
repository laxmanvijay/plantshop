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

@Repository("registerdao")
@Transactional
public class RegisterDaoImpl implements RegisterDao {

	
	@Autowired
	SessionFactory sessionfactory;
	
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

	@Override
	public List<Register> getSingleUserWithEmail(String email) {

		String hql="FROM Register WHERE email=:email";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		query.setParameter("email", email);
		
		return query.getResultList();
	}

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

	@Override
	public Register getSingleUserWithId(int id) {
		
		return sessionfactory.getCurrentSession().get(Register.class, Integer.valueOf(id));
	}

	@Override
	public boolean checkUserAlreadyRegistered(String email) {
		
		String hql="FROM Register";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		List<Register> checkList=new ArrayList<>();
		checkList=query.getResultList();
		System.out.println(checkList);
		for(Register r:checkList) {
			if(r.getEmail()==email) return true;
		}
		return false;
	}

	@Override
	public boolean checkUserPassword(String email, String password) {
		if(checkUserAlreadyRegistered(email)==true) {
			List<Register> r=new ArrayList<>();
			r=getSingleUserWithEmail(email);
			/*if(r.getPassword()==password) return true;
			else return false;
		}
		return false;*/
			return false;
	}
		return false;	
	
}
}
