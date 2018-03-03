package com.org.tradeplatform.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.engine.spi.CascadeStyle;
import org.hibernate.engine.spi.CascadeStyles;

@Table(name="user_trade")
@Entity
public class User {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer userId;
	private String userName;
	
	@OneToMany(mappedBy="user")
	private List<Product> products=new ArrayList<Product>();
	 @OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	private Cart cart;
	
	public User() {
		cart=new Cart(this);
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public User(String userName) {
		cart=new Cart(this);
		this.userName=userName;
	}
	
	public void addProduct(Product product) {
		this.getProducts().add(product);
	}
	
	public void removeProduct(Product product) {
		this.getProducts().remove(product);
	}
	
	public void addProducts(List<Product> product) {
		this.getProducts().addAll(product);
	}
	
	public void removeProducts(List<Product> product) {
		this.getProducts().removeAll(product);
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		if(products == null || products.size()<1) {return;}
		this.products = products;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		if(userId == null) { return ;}
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		if(userName == null) { return ;}
		this.userName = userName;
	}
	
	
}
