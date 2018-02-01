package com.techelevator;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(path = { "/login" }, method = RequestMethod.GET)
	public String showLoginPage(ModelMap map) {
		return "login";
	}
	
	@RequestMapping(path = { "/logout" }, method = RequestMethod.GET)
	public String logUserOut(ModelMap model,  HttpSession session) {
		
		session.removeAttribute("user");	
		model.remove("user");
		
		List<Product> products = productDao.getAllProducts();
		model.put("products", products);
		
		return "ProductList";
	}
	
	@RequestMapping(path = { "/login" }, method = RequestMethod.POST)
	public String processLogin(User logInAttemptUser, ModelMap model,  HttpSession session) {
		
		List<User> users = userDao.getAllUsers();
		
		boolean areValidCredentials = AreCredentialsValid(logInAttemptUser.getUserName(), logInAttemptUser.getPassword(), users);
		
		if(areValidCredentials) {
			User loggedInUser = GetUserFromListByNameAndPassword(logInAttemptUser.getUserName(), 
																 logInAttemptUser.getPassword(), 
																 users);
			model.put("user", loggedInUser);
			session.setAttribute("user", loggedInUser);
		} else {
			model.put("error", "Invalid username/password combination");
		}
		
		
		List<Product> products = productDao.getAllProducts();
		model.put("products", products);
		
		return "ProductList";
	}
	
	@RequestMapping(path = "/addProduct", method = RequestMethod.GET)
	public String showProductPage(ModelMap map, HttpSession session) {
		User currentUser = (User) session.getAttribute("user");
		if (currentUser != null) {
			return "AddProduct";
		} else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping(path = "/addProduct", method = RequestMethod.POST)
	public String processAddProduct(Product product, ModelMap model) {
		
		productDao.save(product);

		List<Product> products = productDao.getAllProducts();
		model.put("products", products);

		return "/ProductList";
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
	
	private boolean AreCredentialsValid(String enteredUserName, 
									  	String enteredPassword, 
									    List<User> users) {
		boolean areCredentialsValid = false;
		for(User user : users) {
			if(user.getFirstName().equals(enteredUserName) 
					&& user.getPassword().equals(enteredPassword)) {
				areCredentialsValid = true;
			}
		}
		
		return areCredentialsValid;
	}
	
	private User GetUserFromListByNameAndPassword(String enteredUserName, 
										  		  String enteredPassword, 
										  		  List<User> usersFromDb) {
	User user = new User();
	for(User dbUser : usersFromDb) {
		if(dbUser.getFirstName().equals(enteredUserName) 
		&& dbUser.getPassword().equals(enteredPassword)) {
			user = dbUser;
		}
	}

	return user;
	
	}
}
