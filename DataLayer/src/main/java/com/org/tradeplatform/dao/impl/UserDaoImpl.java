package com.org.tradeplatform.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.org.tradeplatform.dao.UserDao;
import com.org.tradeplatform.model.Product;
import com.org.tradeplatform.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public Product getUser(Map<String, Object> properties) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		Session session=sessionFactory.openSession();
		return session.createQuery("From User").list();
	}

	@Override
	public User getUserByName(String userName) {
		Session session=sessionFactory.openSession();
		List<User> objects=(List<User>) session.createQuery("from User where userName='"+userName+"'").list();
		session.close();
		if(objects.size() > 1) {
			System.out.println("exception occured multiple product found for single Id");
			new RuntimeException("exception occured multiple product found for single Id");
		} else if(objects.size() < 1) {
			return null;
		}
		return objects.get(0);
	}

	@Override
	public List<User> getUserByNames(String userNames) {
		// Check your Input 
		Session session=sessionFactory.openSession();
		List<User> objects=(List<User>) session.createQuery("from User where userName in ("+userNames+")").list();
		session.close();
		return objects;
	}

	
}
