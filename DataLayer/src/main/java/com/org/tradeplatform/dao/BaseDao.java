package com.org.tradeplatform.dao;

import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.tradeplatform.model.Entry;

@Repository
public class BaseDao<T> {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void createEntity(T object) {
			Session session=sessionFactory.openSession();
			session.save(object);
			session.flush();
			session.close();
	}
	
	public List findByProperties(Map<String,Object> properties,Class className) {
		String query="from "+className.getSimpleName();
		if(properties != null && properties.size()>0) {
			query=query+" where ";
			for(Map.Entry<String, Object> entry:properties.entrySet()) {
				query=query+" "+entry.getKey()+"=";
					if(entry.getValue() instanceof String) {
						query=query+"'"+entry.getValue()+"'";
					} else if(entry.getValue() instanceof Integer) {
						query=query+entry.getValue();
					}
			}
			System.out.println("Query:=>   "+query);
			Session session=sessionFactory.openSession();
			return session.createQuery(query).list();
		}
		return null;
	}
	
	public List<Object> loadAllEntities(T object) {
		if(object instanceof Object) {
			Session session=sessionFactory.openSession();
			List<Object> users=(List<Object>) session.createQuery("from User").list();
			return users;
		}
		return null;
	}
	
	public List<Object> loadAllRecord() {
		Session session=sessionFactory.openSession();
		List<Object> records=(List<Object>) session.createQuery("from Entry").list();
		session.close();
		return records;
	}
	

}
