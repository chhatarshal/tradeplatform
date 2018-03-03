package com.org.tradeplatform.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {	
	public void save(T object);
	public List<T> findByProperties(Map<String,String> properties,String objectName);
	public List<T> getAllOjects();
	public void update(T object);
}
