package com.dots;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dots.dao.CartDao;
import com.dots.dao.MenuDao;
import com.dots.dao.ProductDao;
import com.dots.dao.RegisterDao;
import com.dots.dto.Cart;
import com.dots.dto.FileUpload;
import com.dots.dto.Product;
import com.dots.dto.Register;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**** controller class ***/
@org.springframework.stereotype.Controller
public class Controller {

	/** dao objects for accessing database **/
	@Autowired
	public MenuDao menudao;

	@Autowired
	public RegisterDao registerdao;

	@Autowired
	public ProductDao productdao;
	
	@Autowired
	public CartDao cartdao;
	
	@Autowired
	HttpServletRequest request;
	

	
	private Product product;
	private Register register;
	private FileUpload file;
	
	/************** json data returning endpoints ***************/

	// returning json of all products
	@ResponseBody
	@RequestMapping(value = "product/json", method = RequestMethod.GET)
	public String productjson() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

		String arrayToJson = objectMapper.writeValueAsString(productdao.allProducts());

		return arrayToJson;
		// return "{\"data\":" + arrayToJson + "}";
	}

	// returning json data of particular product
	@ResponseBody
	@RequestMapping(value = "/category/json")
	public String categoryjson(@RequestParam("name") String name) throws JsonProcessingException {
		String categoryjson;
		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

		categoryjson = objectMapper.writeValueAsString(productdao.getProductByCategory(name));

		return categoryjson;
	}

	/********************* view returning endpoints *****************/

	// returning index view
	@RequestMapping(value = { "/", "home" })
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("menus", menudao.list());
		mv.addObject("products", productdao.allProducts());
		mv.addObject("loginStatus", 2);
		return mv;

	}
	
	// returning register view
		@RequestMapping(value = { "registerpage"})
		public ModelAndView registerPage() {
			ModelAndView mv = new ModelAndView("register");
			return mv;
		}
		
		// returning admin view
				@RequestMapping(value = { "adminpage"})
				public ModelAndView adminPage() {
					ModelAndView mv = new ModelAndView("admin");
					return mv;
				}
		
		// returning login view
		@RequestMapping(value =  "loginpage")
		public ModelAndView loginPage() {
			ModelAndView mv = new ModelAndView("login");
			//if(err=="true") {
				mv.addObject("login_failure","true");
			//}
			
			return mv;
		}

	// returning a particular category view
	@RequestMapping(value = "/category")
	public ModelAndView showProductsInCategory(@RequestParam("name") String name) {
		ModelAndView mv = new ModelAndView("products");
		mv.addObject("products", productdao.getProductByCategory(name));
		mv.addObject("menuName", name);
		return mv;
	}
	
	//returning a particular product
	@RequestMapping(value="/singleProduct")
	public ModelAndView showProduct(@RequestParam("name") String pname)
	{
		ModelAndView mv= new ModelAndView("singleProduct");
		mv.addObject("product",productdao.getProductByName(pname));
		return mv;
	}
	
	//buy product page
	@RequestMapping(value="/buy")
	public ModelAndView buyProduct(@RequestParam("name") String name) {
		ModelAndView mv=new ModelAndView("buy");
		mv.addObject("product",productdao.getProductByName(name));
		return mv;
	}
	
	
	
	
	/**** authentication endpoints ***/
	

	// log in request
	@RequestMapping(value = "loginCustom", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("email-login") String email,
			@ModelAttribute("password-login") String password) {
		String loginStatement = registerdao.checkUserPassword(email, password);

		ModelAndView success, fail;
		success = new ModelAndView("cart");// send this if login success
		fail = new ModelAndView("index");// else send this

		if (loginStatement == "logged in") {
			// successful login
			success.addObject("loginStatus", 1);
			success.addObject("user", registerdao.getSingleUserWithEmail(email));
			success.addObject("menus", menudao.list());
			success.addObject("products", productdao.allProducts());
			return success;
		} else if (loginStatement == "password error") {
			// password error
			fail.addObject("loginStatus", 0);
			return fail;
		} else {
			// no email in database
			fail.addObject("loginStatus", -1);
			return fail;
		}
	}

	// register request
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("email") String email, @ModelAttribute("mobile") String mobile,
			@ModelAttribute("password") String password, @ModelAttribute("name") String name) {
		ModelAndView model = new ModelAndView("index");
		register = new Register();
		register.setEmail(email);
		register.setName(name);
		register.setPhone(mobile);
		register.setPassword(password);

		if (registerdao.createUser(register)) {
			model.addObject("registerStatus", true);
		} else {
			model.addObject("registerStatus", false);
		}

		return model;
	}

			                             /*Creating products*/
	@ResponseBody
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String createProduct( HttpSession session,@ModelAttribute("pimg") MultipartFile  pimg,@ModelAttribute("pname") String pname,@ModelAttribute("pdesc") String pdesc,@ModelAttribute("pprice") String pprice,@ModelAttribute("prating") String prating,@ModelAttribute("category") String category) throws IOException{
		product = new Product();
		product.setCategory(category);
		product.setPdesc(pdesc);
		product.setPname(pname);
		product.setPprice(pprice);
		product.setPrating(prating);
	
         //creating new FileUpload object for storing the file.
		 FileUpload file=new FileUpload();
		 file.setMultipartfile(pimg);
	   
		 //creating empty image file using the file class
	   	File f= new File(request.getServletContext().getContextPath()+file.getMultipartfile().getOriginalFilename());
	   	f.createNewFile();
	   	
	   	//copying the uploaded file to the created location
	   FileCopyUtils.copy(file.getMultipartfile().getBytes(), f);
	    System.out.println(f.getPath().toString());
		
		 product.setPimg(pname); 
		
		if(productdao.createProduct(product)) return "success";
		else return "failure";
	}	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage (HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView("index");
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return mv;//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	
	
						                          /*cart controller*/
	
	
	//show cart
	@RequestMapping(value="/cart")
	public ModelAndView showCart() {
		ModelAndView mv=new ModelAndView("cart");
		
		return mv;
	}
	
	//add to cart controller
	@ResponseBody
	@RequestMapping(value="/addToCart")
	public String addToCart(@RequestParam("pname") String pname,@RequestParam("useremail") String useremail)
	{
		Cart cart=new Cart();
		cart.setPname(pname);
		cart.setUseremail(useremail);
		int flag = 0;
		List<Cart> cartItems=new ArrayList<Cart>();
		cartItems=cartdao.getProducts(useremail);
		Iterator<Cart> i=cartItems.iterator();
		while(i.hasNext()) {
			Cart c=(Cart)i.next();
			if((c.getPname()==cart.getPname())) {
				flag=1;
			}
			else {
				flag=2;
			}
		}
		
		if(flag==2) {
		cartdao.addToCart(cart);
		}
		return "success";
	}
	
	
	//remove product
	@ResponseBody
	@RequestMapping(value="/removeFromCart",method=RequestMethod.POST)
	public String removeFromCart(@ModelAttribute("pname") String pname,@ModelAttribute("useremail") String useremail)
	{
		Cart cart=new Cart();
		cart.setPname(pname);
		cart.setUseremail(useremail);
		
		
		
		cartdao.removeProduct(cart);
		return "success";
	}
	
	//get all cart items
	@ResponseBody
	@RequestMapping(value="/getCartItems")
	public  String getCartItems(@RequestParam("useremail") String useremail) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

		List<Cart> cartItems=new ArrayList<Cart>();
		cartItems=cartdao.getProducts(useremail);
		
		List<Product> productItems = new ArrayList<Product>();
		Iterator i=cartItems.iterator();
		
		while(i.hasNext()) {
			Cart c=(Cart)i.next();
			productItems.add(productdao.getProductByName(c.getPname()));
		}
		
		String arrayToJson = objectMapper.writeValueAsString(productItems);

		return arrayToJson;
	}
	
	
}
