package com.org.tradeplatform.dao;

import java.util.List;
import java.util.Map;

import com.org.tradeplatform.model.Product;

public interface ProductDao {
	
	public Product getProduct(Map<String,Object> properties);
	public List<Product> getAllProducts();
	public void save(Product object);
	public Product getProductById(String productById);
	public List<Product> getProductByIds(String productByIds);
}
