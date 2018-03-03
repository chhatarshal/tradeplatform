package com.org.tradeplatform.base.web;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.org.tradeplatform.conf.Context;
import com.org.tradeplatform.dao.impl.BaseDaoImpl;
import com.org.tradeplatform.model.Product;
import com.org.tradeplatform.model.User;

@RestController
public class UserService {

@Autowired BaseDaoImpl<User> baseDao;
	
	@RequestMapping("/save")
	public String saveUser(@RequestParam String userName) {
		User user=new User();
		user.setUserName(userName);
		baseDao.save(user);
		return "success";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam String username) {
		if(username != null && username.length()<1) { return "fail";}
		User user=null;
		Context context=new Context();
		Object object=context.getObject("loggedInUser");
		if(object != null && object instanceof User) { return "Already Logged In"; }
		Map<String,String> myMap = new HashMap<String,String>();
        myMap.put("userName", username);
		List<User> users=baseDao.findByProperties(myMap,"User");
		if(users.size() < 1) {
			user=new User(username);
			baseDao.save(user);
		} else {
			user=users.get(0);
		}		
		context.putObject("loggedInUser", user);
		return "success";
	}
	
	@RequestMapping(value ="/getAllCartItems",produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Product>  getItemsInCart() {
		Context context=new Context();
		Object object=context.getObject("loggedInUser");
		List<Product> allProducts=null;
		if(object != null && object instanceof User) {
			User user=(User)object;
			allProducts=user.getCart().getProducts();
		}
		return allProducts;
	}
	
}
