package com.org.tradeplatform.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.tradeplatform.dao.ProductDao;
import com.org.tradeplatform.model.Product;
@Repository
public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {
	
	
	@Override
	public Product getProduct(Map<String, Object> properties) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		Session session=sessionFactory.openSession();
		List<Product> objects=(List<Product>) session.createQuery("from Product").list();
		session.close();
		return objects;
	}

	@Override
	public void save(Product product) {
		Session session=sessionFactory.openSession();
		session.save(product);
		session.flush();
		session.close();
	}

	@Override
	public Product getProductById(String productById) {
		Session session=sessionFactory.openSession();
		List<Product> objects=(List<Product>) session.createQuery("from Product where productId="+productById).list();
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
	public List<Product> getProductByIds(String productByIds) {
		// Check your Input 
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Product> objects=(List<Product>) session.createQuery("from Product where productId in ("+productByIds+")").list();
		session.getTransaction().commit();
		session.close();
		return objects;
	}

}
