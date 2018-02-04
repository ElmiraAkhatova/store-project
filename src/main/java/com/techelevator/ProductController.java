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
public class ProductController {

	private ProductDao productDao;

	@Autowired
	public ProductController(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@RequestMapping(path = "/addProduct", method = RequestMethod.GET)
	public String showProductPage(ModelMap map, HttpSession session) {
		User currentUser = (User) session.getAttribute("user");
		if (currentUser != null) {
			return "AddProduct";
		} else {
			return "login";
		}
	}
	
	@RequestMapping(path = "/addProduct", method = RequestMethod.POST)
	public String processAddProduct(Product product, ModelMap model) {
		
		productDao.save(product);

		List<Product> products = productDao.getAllProducts();
		model.put("products", products);

		return "/ProductList";
	}
	
	@RequestMapping(path = "/buy", method = RequestMethod.POST)
	public String buy(ModelMap model, HttpSession session, @RequestParam(required = false) String quantity,
								    @RequestParam(required = false) String id) {
		
	   //created new cart or selected from session if user had cart
	   List<Product> cart = new ArrayList<Product>();
		
	   if(session.getAttribute("cart" ) != null) { 
		cart = (List<Product>)session.getAttribute("cart");  
	   }
	   
	   Product item = productDao.getProductById(Long.parseLong(id));
	   
	   cart.add(item);
	   session.setAttribute("cart", cart);
	   
	   double totalPrice = 0;
	   
	   for(Product currentItem : cart) {
		   totalPrice = currentItem.getPrice() + totalPrice;
	   }
	   	model.put("totalPrice", totalPrice);
		model.put("cart", cart);
		
		return "shoppingCart";
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
	
	
}
