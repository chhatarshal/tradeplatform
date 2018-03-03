package com.org.tradeplatform.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer productId;
	
	private String productName;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;	
	
	public Product() {
		
	}
	
	public Product(String productName) {
		this.productName=productName;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
		
}
