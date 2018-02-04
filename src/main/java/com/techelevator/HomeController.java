package com.techelevator;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.Product;
import com.techelevator.model.ProductDao;
import com.techelevator.model.User;
import com.techelevator.model.UserDao;

@Controller
@SessionAttributes("user")
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
	
}
