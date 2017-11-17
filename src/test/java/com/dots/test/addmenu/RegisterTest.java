package com.dots.test.addmenu;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dots.dao.RegisterDao;
import com.dots.dto.Register;

public class RegisterTest {
	
	
private static AnnotationConfigApplicationContext annotate;
	
	private static RegisterDao rd;
	
	private Register r;
	
	
	@BeforeClass
	public static void init() {
		
		annotate=new AnnotationConfigApplicationContext();
		annotate.scan("com.dots");
		annotate.refresh();
		
		rd=(RegisterDao)annotate.getBean("registerdao");
	}
	
	/*
	@Test
	public void testSignIn() {
		assertEquals("user verified",true,rd.checkUserPassword("durai4@gmail.com","durraj4"));
		
	}
	
	
	/*
	@Test
	public void testUserAlreadyRegistered() {
		assertEquals("success",true,rd.checkUserAlreadyRegistered("laxmanvijay24@gmail.com"));
	}
	*/
	
	@Test
	public void testCRUDRegister() {
		
		r=new Register();
		r.setName("laxman");
		r.setEmail("laxmanvijay24@gmail.com");
		r.setPhone("8903040410");
		r.setPassword("laxmvij24");
		r.setRole("ADMIN");
		
		assertEquals("successfully created a user",true,rd.createUser(r));
		
		r=new Register();
		r.setName("durai");
		r.setEmail("durai4@gmail.com");
		r.setPhone("8654722789");
		r.setPassword("durraj4");
		r.setRole("USER");
		assertEquals("successfully created a user",true,rd.createUser(r));
		
		/*
		assertEquals("got single user",r,rd.getSingleUserWithEmail("laxmanvijay24@gmail.com").);
		
		r=rd.getSingleUserWithId(1);
		r.setName("laxman vijay");
		assertEquals("got single user",true,rd.updateUser(r));
		
		
		r=rd.getSingleUserWithId(1);
		assertEquals("got single user",true,rd.deleteUser(r));
		*/
	}
}

