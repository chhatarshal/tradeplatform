package com.org.tradeplatform.conf;

import java.util.HashMap;
import java.util.Map;

public class Context {
	
	private static Map<Object,Object> contextObjects=new HashMap<Object,Object>();	
	
	public static void putObject(Object key,Object object) {
		contextObjects.put(key, object);
	}
	
	public Object getObject(String key) {
		for(Map.Entry<Object, Object> entry:contextObjects.entrySet()) {
			if(entry.getKey().equals(key)) {
				return contextObjects.get(key);
			}
		}
		return null;
	}
	
}
