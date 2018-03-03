package org.com.tradplatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.tradeplatform.dao.impl.BaseDaoImpl;
import com.org.tradeplatform.model.User;

@RestController
public class UserService {

@Autowired BaseDaoImpl<User> baseDao;
	
@RequestMapping("/save2")
	public String saveUser(@RequestParam String name) {
		User user=new User();
		user.setUserName(name);
		baseDao.save(user);
		return "success";
	}
	
}
