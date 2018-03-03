package com.org.tradeplatform.dao;

import java.util.List;
import java.util.Map;

import com.org.tradeplatform.model.Product;
import com.org.tradeplatform.model.User;

public interface UserDao {
	public Product getUser(Map<String,Object> properties);
	public List<User> getAllUsers();
	public void save(User object);
	public User getUserByName(String userName);
	public List<User> getUserByNames(String userNames);
	public void update(User object);
}
