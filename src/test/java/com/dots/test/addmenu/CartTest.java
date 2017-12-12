package com.dots.test.addmenu;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dots.dao.CartDao;
import com.dots.dto.Cart;

public class CartTest {
	
	
private static AnnotationConfigApplicationContext annotate;
	
	private static CartDao cd;
	
	private Cart c;
	
	@BeforeClass
	public static void init() {
		
		annotate=new AnnotationConfigApplicationContext();
		annotate.scan("com.dots");
		annotate.refresh();
		
		cd=(CartDao)annotate.getBean("cartdao");
	}
/*	
	@Test
	public void testCRUDCart() {
		c=new Cart();
		c.setPname("hii");
		c.setUseremail("hii");
		assertEquals("success",true,cd.addToCart(c));
}
*/}