package com.dots;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

import com.dots.dao.AddressDao;
import com.dots.dao.CartDao;
import com.dots.dao.MenuDao;
import com.dots.dao.OrdersDao;
import com.dots.dao.ProductDao;
import com.dots.dao.RegisterDao;
import com.dots.dto.Address;
import com.dots.dto.Cart;
import com.dots.dto.FileUpload;
import com.dots.dto.Orders;
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
	public OrdersDao ordersdao;
	
	@Autowired
	public AddressDao addressdao;
	
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
	
	@ResponseBody
	@RequestMapping(value = "checkProduct")
	public String checkProduct(@RequestParam("name") String name) throws JsonProcessingException {
		String flag = "no";
		List<Product> productList=productdao.allProducts();
		Iterator p=productList.iterator();
		while(p.hasNext()) {
			Product product=(Product)p.next();
			if(name.equals(product.getPname())) {
				flag="yes";
			}
		}
		return flag;
	}
	
	@ResponseBody
	@RequestMapping(value = "checkRegister")
	public String checkRegister(@RequestParam("name") String name) throws JsonProcessingException {
		String flag="no";
			boolean b=registerdao.checkUserAlreadyRegistered(name);
			if(b==true) {
				flag="yes";
			}
		return flag;
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
				
				// returning payment view
				@RequestMapping(value = { "payment"})
				public ModelAndView paymentPage() {
					ModelAndView mv = new ModelAndView("payment");
					return mv;
				}
				
				// returning payment view
				@RequestMapping(value = { "orders"})
				public ModelAndView ordersPage() {
					ModelAndView mv = new ModelAndView("orders");
					return mv;
				}
				
				// returning orders data for users
				@ResponseBody
				@RequestMapping(value = { "ordersItems"})
				public String ordersPage(@RequestParam("name") String Email) throws JsonProcessingException {
					List<Orders> lo=new ArrayList<>();
					ObjectMapper objectMapper = new ObjectMapper();
					List<Product> productItems=new ArrayList<>();
					objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
					

					if(!Email.equals("laxman@gmail.com")) {
					lo=ordersdao.getOrdersByEmail(Email);
					}
					else {
						lo=ordersdao.getAllOrders();
					}
					
					Iterator<Orders> i=lo.iterator();
					
					while(i.hasNext()) {
						Orders c=(Orders)i.next();
						productItems.add(productdao.getProductByName(c.getProductName()));
					}
					return objectMapper.writeValueAsString(productItems);
				}
				
				// placing orders
				@RequestMapping(value ="placeOrder")
				public String orderPage(@RequestParam("name") String name) {
					Register user=registerdao.getSingleUserWithEmail(name);
					List<Cart> cartItem=cartdao.getProducts(user);
					Orders orders;
					Iterator<Cart> i=cartItem.iterator();
					while(i.hasNext()) {
						Cart cart=(Cart)i.next();
						orders=new Orders();
						orders.setProductName(cart.getPname());
						orders.setUser(name);
						ordersdao.createOrder(orders);
						cartdao.removeProduct(cart);
					}
					return "success";
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
		ModelAndView mv=new ModelAndView("payment");
		mv.addObject("product",productdao.getProductByName(name));
		return mv;
	}
	
	@RequestMapping(value="/delete")
	public ModelAndView deleteProduct(@RequestParam("name") String name) {
		ModelAndView mv=new ModelAndView("index");
		Product p=productdao.getProductByName(name);
		mv.addObject("product",productdao.deleteProduct(p));
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
	public ModelAndView register(@ModelAttribute("address") String a,@ModelAttribute("email") String email,@ModelAttribute("address") String address, @ModelAttribute("mobile") String mobile,
			@ModelAttribute("password") String password, @ModelAttribute("name") String name) {
		ModelAndView model = new ModelAndView("index");
		register = new Register();
		register.setEmail(email);
		register.setName(name);
		register.setPhone(mobile);
		register.setPassword(password);
		register.setEnabled(true);
		register.setRole("ROLE_USER");

		if (registerdao.createUser(register)) {
			model.addObject("registerStatus", true);
		} else {
			model.addObject("registerStatus", false);
		}
		Address address1=new Address();
		address1.setAddress(a);
		address1.setUser(register);
		addressdao.createAddress(address1);

		return model;
	}

			                             /*Creating products*/
	@ResponseBody
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public ModelAndView createProduct( HttpSession session,@ModelAttribute("pimg") MultipartFile  pimg,@ModelAttribute("pname") String pname,@ModelAttribute("pdesc") String pdesc,@ModelAttribute("pprice") String pprice,@ModelAttribute("prating") String prating,@ModelAttribute("category") String category) throws IOException{
		ModelAndView mv=new ModelAndView("index");
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
	   	File f= new File("F:/jee-oxygen/projects/plantshop/src/main/webapp/resources/static/"+file.getMultipartfile().getOriginalFilename());
	   	f.createNewFile();
	   	
	   	//copying the uploaded file to the created location
	   FileCopyUtils.copy(file.getMultipartfile().getBytes(), f);
	    System.out.println(f.getPath().toString());
		
		 product.setPimg(file.getMultipartfile().getOriginalFilename()); 
		
		if(productdao.createProduct(product)) return mv;
		else return mv;
	}	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage (HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView("index");
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return mv;
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
		Register user=registerdao.getSingleUserWithEmail(useremail);
		Cart cart=new Cart();
		cart.setPname(pname);
		cart.setUser(user);
		int flag = 2;
		List<Cart> cartItems=new ArrayList<Cart>();
		cartItems=cartdao.getProducts(user);
		Iterator<Cart> i=cartItems.iterator();
		while(i.hasNext()) {
			Cart c=(Cart)i.next();
			if((c.getPname().equals(cart.getPname()))) {
				flag=1;
			}
			else {
				flag=2;
			}
		}
		
		if(flag==2) {
		cartdao.addToCart(cart);
		return "success";
		}
		else {
			return "already";
		}
	}
	
	
	//remove product
	@ResponseBody
	@RequestMapping(value="/removeFromCart")
	public String removeFromCart(@RequestParam("pname") String pname,@RequestParam("useremail") String useremail)
	{
		Register user=registerdao.getSingleUserWithEmail(useremail);
		Cart cart=new Cart();
		cart.setPname(pname);
		cart.setUser(user);
		boolean b=cartdao.removeProduct(cart);
		if(b==true) {
			System.out.println("success");
		return "success";
		}
		else {
			System.out.println("failure");
			return "failure";
		}				
	}
	
	//get all cart items
	@ResponseBody
	@RequestMapping(value="/getCartItems")
	public  String getCartItems(@RequestParam("useremail") String useremail) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

		List<Cart> cartItems=new ArrayList<Cart>();
		Register user=registerdao.getSingleUserWithEmail(useremail);
		cartItems=cartdao.getProducts(user);
		
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
