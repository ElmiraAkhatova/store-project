package com.techelevator;

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

public class LoginController {

	private ProductDao productDao;
	private UserDao userDao;

	@Autowired
	public LoginController(ProductDao productDao, UserDao userDao) {
		this.productDao = productDao;
		this.userDao = userDao;
	}

	@RequestMapping(path = { "/login" }, method = RequestMethod.GET)
	public String showLoginPage(ModelMap map) {
		return "login";
	}

	@RequestMapping(path = { "/logout" }, method = RequestMethod.GET)
	public String logUserOut(ModelMap model, HttpSession session) {

		session.removeAttribute("user");
		session.removeAttribute("shoppingCart");
		model.remove("user");

		List<Product> products = productDao.getAllProducts();
		model.put("products", products);

		return "ProductList";
	}

	@RequestMapping(path = { "/login" }, method = RequestMethod.POST)
	public String processLogin(User logInAttemptUser, ModelMap model, HttpSession session) {
		
		session.removeAttribute("user");
		session.removeAttribute("shoppingCart");
		model.remove("user");
		
		List<User> users = userDao.getAllUsers();

		boolean areValidCredentials = AreCredentialsValid(logInAttemptUser.getUserName(),
				logInAttemptUser.getPassword(), users);

		if (areValidCredentials) {
			User loggedInUser = GetUserFromListByNameAndPassword(logInAttemptUser.getUserName(),
					logInAttemptUser.getPassword(), users);
			model.put("user", loggedInUser);
			session.setAttribute("user", loggedInUser);

			List<Product> products = productDao.getAllProducts();
			model.put("products", products);

			return "ProductList";
		} else {
			model.put("error", "Invalid username/password combination");
			return "login";
		}
	}

	private boolean AreCredentialsValid(String enteredUserName, String enteredPassword, List<User> users) {
		boolean areCredentialsValid = false;
		for (User user : users) {
			if (user.getFirstName().equals(enteredUserName) && user.getPassword().equals(enteredPassword)) {
				areCredentialsValid = true;
			}
		}

		return areCredentialsValid;
	}

	private User GetUserFromListByNameAndPassword(String enteredUserName, String enteredPassword,
			List<User> usersFromDb) {
		User user = new User();
		for (User dbUser : usersFromDb) {
			if (dbUser.getFirstName().equals(enteredUserName) && dbUser.getPassword().equals(enteredPassword)) {
				user = dbUser;
			}
		}

		return user;

	}
}
