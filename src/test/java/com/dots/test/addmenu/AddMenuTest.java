package com.dots.test.addmenu;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dots.dao.MenuDao;
import com.dots.dto.Menu;

public class AddMenuTest {
	
	private static AnnotationConfigApplicationContext annotate;
	
	private static MenuDao md;
	
	private Menu m;
	
	@BeforeClass
	public static void init() {
		
		annotate=new AnnotationConfigApplicationContext();
		annotate.scan("com.dots");
		annotate.refresh();
		
		md=(MenuDao)annotate.getBean("menudao");
	}
	/*
	@Test
	public void testAddMenu() {
		m=new Menu();
		m.setName("plants");
		m.setDesc("domestic");
	
		assertEquals("success",true,md.addMenu(m));
	}
	*/
	/*
	@Test
	public void testSingleMenu() {
		m=md.getSingleMenu(3);
		assertEquals("success","flower", m.getName());
	}
	*/
	
	/*
	@Test
	public void testUpdateMenu() {
		m=md.getSingleMenu(3);
		m.setName("home flowers");
		assertEquals("success",true,md.updateMenu(m));
	}
	*/
	
	/*
	@Test
	public void deleteSingleMenu() {
		m=md.getSingleMenu(3);
		assertEquals("deleted",true,md.trueDelete(m));
		}
	*/
	/*
	@Test
	public void readAll() {
		assertEquals("fetched all",1,md.list().size());
	}
	*/
	
	@Test
	public void testCRUDMenu() {
		m=new Menu();
		m.setName("plants");
		m.setDesc("domestic");
	
		assertEquals("success",true,md.addMenu(m));
		
		m=new Menu();
		m.setName("flowers");
		m.setDesc("domestic");
	
		assertEquals("success",true,md.addMenu(m));
		
		m=md.getSingleMenu(2);
		assertEquals("success","flowers", m.getName());
		
		m=md.getSingleMenu(2);
		m.setName("home flowers");
		assertEquals("success",true,md.updateMenu(m));
		
		m=md.getSingleMenu(1);
		assertEquals("deleted",true,md.trueDelete(m));
		
		assertEquals("fetched all",1,md.list().size());
	}
	
}
