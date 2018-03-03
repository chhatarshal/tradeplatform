package com.org.tradeplatform.dao.impl;

import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.org.tradeplatform.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	public void save(T object) {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(object);
			session.getTransaction().commit();
			session.flush();
			session.close();
	}
	
	@Override
	public List<T> findByProperties(Map<String,String> properties,String objectName) {
		String query="from "+objectName;
		if(properties != null && properties.size()>0) {
			query=query+" where ";
			for(Map.Entry<String, String> entry:properties.entrySet()) {
				query=query+" "+entry.getKey()+"=";
					if(entry.getValue() instanceof String) {
						query=query+"'"+entry.getValue()+"'";
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

	@Override
	public List<T> getAllOjects() {
		Session session=sessionFactory.openSession();
		List<T> objects=(List<T>) session.createQuery("from Entry").list();
		session.close();
		return objects;
	}

	@Override
	public void update(T object) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.merge(object);
		session.getTransaction().commit();
		session.flush();
		session.close();
		
	}
	

}
