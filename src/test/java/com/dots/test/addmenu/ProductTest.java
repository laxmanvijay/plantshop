package com.dots.test.addmenu;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dots.dao.ProductDao;
import com.dots.dto.Product;

public class ProductTest {
	
	
private static AnnotationConfigApplicationContext annotate;
	
	private static ProductDao pd;
	
	private Product p;
	
	@BeforeClass
	public static void init() {
		
		annotate=new AnnotationConfigApplicationContext();
		annotate.scan("com.dots");
		annotate.refresh();
		
		pd=(ProductDao)annotate.getBean("productdao");
	}
	
	@Test
	public void testCRUDProduct() {
		
		p=new Product();
		p.setPname("flower pot");
		p.setPdesc("beautiful home pot");
		p.setCategory("ornamental");
		p.setPimg("flower_pot.png");
		p.setPprice("200");
		p.setPrating("4");
		assertEquals("successfully created a product",true,pd.createProduct(p));
		
		p=new Product();
		p.setPname("urea");
		p.setPdesc("agricultural manure");
		p.setCategory("agricultural");
		p.setPimg("urea.png");
		p.setPprice("800");
		p.setPrating("3.5");
		assertEquals("successfully created a product",true,pd.createProduct(p));
		
		
		p=new Product();
		p.setPname("neem seeds");
		p.setPdesc("grow neem at ease");
		p.setCategory("plantation");
		p.setPimg("neem_seeds.png");
		p.setPprice("100");
		p.setPrating("4");
		assertEquals("successfully created a product",true,pd.createProduct(p));
		
		assertEquals("successfully read all products",3,pd.allProducts().size());
		
		p=pd.getProductById(1);
		p.setPname("red flower pot");
		assertEquals("successfully updated a product",true,pd.updateProduct(p));
		
		p=pd.getProductById(2);
		assertEquals("successfully deleted a product",true,pd.deleteProduct(p));
		
		assertEquals("successfully read product by category",1,pd.getProductByCategory("ornamental").size());
		
	}

}
