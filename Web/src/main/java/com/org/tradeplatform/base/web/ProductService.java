package com.org.tradeplatform.base.web;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.tradeplatform.conf.Context;
import com.org.tradeplatform.dao.ProductDao;
import com.org.tradeplatform.dao.UserDao;
import com.org.tradeplatform.model.Cart;
import com.org.tradeplatform.model.Product;
import com.org.tradeplatform.model.User;

@RestController
public class ProductService {
	
	@Autowired ProductDao productDao;
	@Autowired UserDao userDao;
	
	final static Logger logger = Logger.getLogger(ProductService.class);

	
	@RequestMapping("/addProductInRepo")
	public String addNewProductInRepository(@RequestParam String productName) {
		System.out.println(productName);
		Product product=new Product(productName);
		productDao.save(product);
		return product.getProductId()+"";
	}
	
	@RequestMapping("/addProductInCart")
	public String buyProduct(@RequestParam String productIds) {
		String []allProductIds=productIds.split(",");
		Context context=new Context();
		Object object=context.getObject("loggedInUser");
		if(object == null) { 
			logger.info("User Not Logged In ...........");
			return "User Not Logged In"; 
		}
		if( !(object instanceof User))  { return "User Not Logged In"; }
		User user=(User)object;
		Cart cart=user.getCart();
		cart.addProducts(productDao.getProductByIds(productIds));
		userDao.update(user);
		logger.info("user: "+user.getUserName()+" has  "+user.getProducts().size()+"  product in to buy");
		return "success";
	}

}
