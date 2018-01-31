package com.techelevator;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.Product;
import com.techelevator.model.ProductDao;
import com.techelevator.model.User;
import com.techelevator.model.UserDao;

@Controller
@SessionAttributes("producsApp")
public class HomeController {

	private ProductDao productDao;
	private UserDao userDao;

	@Autowired
	public HomeController(ProductDao productDao, UserDao userDao) {
		this.productDao = productDao;
		this.userDao = userDao;
	}

	@RequestMapping(path = { "/" }, method = RequestMethod.GET)
	public String displayHomePageProductList(ModelMap map) {
		List<Product> products = productDao.getAllProducts();
		map.put("products", products);
		return "ProductList";
	}
	
	@RequestMapping(path = { "/login" }, method = RequestMethod.GET)
	public String showLoginPage(ModelMap map) {
		return "login";
	}
	
	@RequestMapping(path = { "/login" }, method = RequestMethod.POST)
	public String processLogin(User user, ModelMap map) {
		System.out.println("On user method...");
		System.out.println(user.getUserName());
		return "login";
	}
	
	
	@RequestMapping(path = { "/addProduct" }, method = RequestMethod.GET)
	public String showProductPage(ModelMap map) {
		return "AddProduct";
	}
	
	@RequestMapping(path = { "/register" }, method = RequestMethod.GET)
	public String showRegisterPage(ModelMap map) {
		return "register";
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String processAddUser(User user, ModelMap map) {
		
		userDao.save(user);

		List<Product> products = productDao.getAllProducts();
		map.put("products", products);
		
		return "ProductList";
	}

	@RequestMapping(path = "/addProduct", method = RequestMethod.POST)
	public String processAddProduct(Product product, ModelMap map) {
		
		productDao.save(product);

		List<Product> products = productDao.getAllProducts();
		map.put("products", products);

		return "/ProductList";
	}
	
	@RequestMapping(path = "/productList", method = RequestMethod.GET)
	public String displayProductList(ModelMap map) {
		List<Product> products = productDao.getAllProducts();
		map.put("products", products);
		
		return "ProductList";
	}
	
	@RequestMapping(path = { "/buyPage" }, method = RequestMethod.GET)
	public String showBuyPage(ModelMap map) {
		return "BuyPage";
	}
	
	//unrelated practice, delete later
	private int getLargestNum(int[] nums){
		int largestnum = nums[0];
		for(int n : nums){
			if(n > largestnum && n % 2 == 0){
				largestnum = n;
			};
		}
		return largestnum;
	}
}