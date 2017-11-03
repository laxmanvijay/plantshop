package com.dots;

import javax.json.Json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dots.dao.MenuDao;
import com.dots.dao.ProductDao;
import com.dots.dao.RegisterDao;
import com.dots.dto.Register;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
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
	//log in request
	@ResponseBody
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@ModelAttribute("email-login") String email,@ModelAttribute("password-login") String password) {
		String loginStatement=registerdao.checkUserPassword(email, password);
		if(loginStatement=="logged in") {
			return "login success";
		}
		else if(loginStatement=="password error") {
			return "you have entered an incorrect password";
		}
		else {
			return "you have not registered your account yet!";
		}
		
	}
	
	//register request
	@ResponseBody
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(@ModelAttribute("email") String email,@ModelAttribute("mobile") String mobile,@ModelAttribute("password") String password,@ModelAttribute("name") String name) {
		
		register = new Register();
		register.setEmail(email);
		register.setName(name);
		register.setPhone(mobile);
		register.setPassword(password);
		
		if(registerdao.createUser(register))
		{
			return "success";
		}
		else {
			return "failure";
		}
		
	}
}
