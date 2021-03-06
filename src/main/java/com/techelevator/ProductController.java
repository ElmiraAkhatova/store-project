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
import com.techelevator.model.ShoppingCart;
import com.techelevator.model.ShoppingCartItem;
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
		
		//System.out.println("quantity:" +quantity);
	   //created new cart or selected from session if user had cart
	   
		//List<Product> cart = new ArrayList<Product>();
		ShoppingCart shoppingCart = new ShoppingCart();
		
	   if(session.getAttribute("shoppingCart") != null) { 
		shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");  
	   }
	   
	   Product item = productDao.getProductById(Long.parseLong(id));
	   
	   shoppingCart.addToCart(item, Integer.parseInt(quantity));
	   
	   session.setAttribute("shoppingCart", shoppingCart);
	   
//	   double totalPrice = 0;
//	   
//	   for(Product currentItem : cart) {
//		   totalPrice = currentItem.getPrice() + totalPrice;
//	   }
//	   	model.put("totalPrice", totalPrice);
	   
		model.put("shoppingCart", shoppingCart);
		
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
	
	@RequestMapping(path = { "/editItem" }, method = RequestMethod.POST)
	public String showItemPage(ModelMap model, HttpSession session, @RequestParam(required = false) String id) {
		
		
		ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
		ShoppingCartItem itemToEditInCart = cart.getItemByProductId(Long.parseLong(id));
		model.put("itemToEditInCart", itemToEditInCart);
		
		return "editItem";
	}
	
	@RequestMapping(path= {"/updateItem"}, method=RequestMethod.POST)
	public String updateCart(ModelMap model, HttpSession session, @RequestParam(required = false) String id, @RequestParam int quantity) {

		ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");

		cart.updateItemQuantity(Long.parseLong(id), quantity);
		session.setAttribute("shoppingCart", cart);
		
		model.put("shoppingCart", cart);		  
		return "shoppingCart";
	 }
	
	
	@RequestMapping(path = {"/removeItem"}, method=RequestMethod.POST)
	public String updateCart(ModelMap model, HttpSession session, @RequestParam String id) {
		
		ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
		
		cart.removeItem(Long.parseLong(id));
		
		session.setAttribute("shoppingCart", cart);
		model.put("shoppingCart", cart);
		
		return "shoppingCart";
	}
	
}
	
	
	
	
	
	
	
	
