package com.dots;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.dots.dao.MenuDao;
import com.dots.dao.ProductDao;
import com.dots.dao.RegisterDao;
import com.dots.dto.Register;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


        /****controller class***/
@org.springframework.stereotype.Controller
public class Controller {
	
	
	/**dao objects for accessing database**/
	@Autowired
	 public MenuDao menudao;
	
	@Autowired
	public RegisterDao registerdao;
	
	@Autowired
	public ProductDao productdao;
	
	private Register register;
	
	
	
	            /**************json data returning endpoints***************/
	
	//returning json of all products
	@ResponseBody
	@RequestMapping(value="product/json",method=RequestMethod.GET)
	public String productjson() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
    	
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
    	String arrayToJson = objectMapper.writeValueAsString(productdao.allProducts());
    	
    	return arrayToJson;
		//return "{\"data\":" + arrayToJson + "}";
	}
	
	//returning json data of particular product
	@ResponseBody
	@RequestMapping(value="/category/json")
	public String categoryjson(@RequestParam("name") String name) throws JsonProcessingException {
		String categoryjson;
	ObjectMapper objectMapper = new ObjectMapper();
    	
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
    	categoryjson = objectMapper.writeValueAsString(productdao.getProductByCategory(name));
		
		return categoryjson;
	}
	

	
	
	              /*********************view returning endpoints*****************/
	
	//returning index view
	@RequestMapping(value= {"/","home"})
	public ModelAndView home() {
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("menus",menudao.list());
		mv.addObject("products", productdao.allProducts());
		mv.addObject("loginStatus", 2);
		return mv;
		
	}
	

	//returning a particular category view
	@RequestMapping(value="/category")
	public ModelAndView showProductsInCategory(@RequestParam("name") String name) {
		ModelAndView mv= new ModelAndView("products");
		mv.addObject("products",productdao.getProductByCategory(name));
		mv.addObject("menuName", name);
		return mv;
	}

	
	
	
	
	                              /**** authentication endpoints***/
	//failure
	//login using json
	/*@RequestMapping(value="login",method=RequestMethod.POST)
	public int loginJson(@ModelAttribute("email") String email,@ModelAttribute("password") String password ) {
		String loginStatement=registerdao.checkUserPassword(email, password);
		if(loginStatement=="logged in") {
			login(email,password);
		}
		else if(loginStatement=="password error"){
			return 0;
		}
		else {
			return -1;
		}
		return 0;
	}
	*/
	
	//log in request
	@RequestMapping(value="login",method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("email-login") String email,@ModelAttribute("password-login") String password) {
		String loginStatement=registerdao.checkUserPassword(email, password);
		
		ModelAndView success,fail;
		  success=new ModelAndView("cart");//send this if login success
		 fail=new ModelAndView("index");//else send this
		
		 
		 if(loginStatement=="logged in") {
			//successful login
			success.addObject("loginStatus", 1);
			success.addObject("user", registerdao.getSingleUserWithEmail(email));
			success.addObject("menus",menudao.list());
			success.addObject("products", productdao.allProducts());
			return success;
		}
		else if(loginStatement=="password error") {
			//password error
			fail.addObject("loginStatus", 0);
			return fail;
		}
		else {
			//no email in database
			fail.addObject("loginStatus", -1);
			return fail;
		}
	}
	
	//register request
	@RequestMapping(value="register",method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("email") String email,@ModelAttribute("mobile") String mobile,@ModelAttribute("password") String password,@ModelAttribute("name") String name) {
		ModelAndView model=new ModelAndView("index");
		register = new Register();
		register.setEmail(email);
		register.setName(name);
		register.setPhone(mobile);
		register.setPassword(password);
		
		if(registerdao.createUser(register))
		{
			model.addObject("registerStatus", true);
		}
		else {
			model.addObject("registerStatus", false);
		}
		
		return model;
	}
}
