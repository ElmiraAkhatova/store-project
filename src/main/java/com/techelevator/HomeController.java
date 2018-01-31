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

@Controller
@SessionAttributes("producsApp")
public class HomeController {

	private ProductDao productDao;

	@Autowired
	public HomeController(ProductDao productDao) {
		this.productDao = productDao;
	}

	@RequestMapping(path = { "/" }, method = RequestMethod.GET)
	public String displayHomePageProductList(ModelMap map) {
		List<Product> products = productDao.getAllProducts();
		map.put("products", products);
		return "ProductList";
	}
	
	@RequestMapping(path = { "/addProduct" }, method = RequestMethod.GET)
	public String showProductPage(ModelMap map) {
		return "AddProduct";
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