package com.org.tradeplatform.base.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.tradeplatform.dao.BaseDao;
import com.org.tradeplatform.model.User;

@RestController
public class UserService {

@Autowired BaseDao<User> baseDao;
	
@RequestMapping("/save")
	public String saveUser(@RequestParam String userName) {
		User user=new User();
		user.setUserName(userName);
		baseDao.createEntity(user);
		return "success";
	}
	
}
