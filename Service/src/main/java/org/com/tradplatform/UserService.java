package org.com.tradplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.tradeplatform.dao.BaseDao;
import com.org.tradeplatform.model.User;

@RestController
public class UserService {

@Autowired BaseDao<User> baseDao;
	
@RequestMapping("/save2")
	public String saveUser(@RequestParam String name) {
		User user=new User();
		user.setUserName(name);
		baseDao.createEntity(user);
		return "success";
	}
	
}
