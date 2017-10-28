package com.dots;

import javax.json.Json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	 public MenuDao menudao;
	
	@Autowired
	public RegisterDao registerdao;
	
	@Autowired
	public ProductDao productdao;
	
	private Register register;
	
	
	@RequestMapping(value= {"/","home"})
	public ModelAndView home() {
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("menus",menudao.list());
		return mv;
		
	}
	
	@ResponseBody
	@RequestMapping(value="product/json",method=RequestMethod.GET)
	public String productjson() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
    	
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
    	String arrayToJson = objectMapper.writeValueAsString(productdao.allProducts());
    
		return "{\"data\":" + arrayToJson + "}";
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("email-login") String email,@ModelAttribute("password-login") String password) {
		
	   
	    return new ModelAndView("index");
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("email") String email,@ModelAttribute("mobile") String mobile,@ModelAttribute("password") String password,@ModelAttribute("name") String name) {
		register.setEmail(email);
		register.setName(name);
		register.setPhone(mobile);
		register.setPassword(password);
		
		
		
	  return new ModelAndView("index");
	}
}
