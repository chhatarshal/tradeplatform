package com.org.tradeplatform.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Cart {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer cartId;
	
	@OneToMany
	@JoinTable(name = "product_id")
	private List<Product> products=new ArrayList<Product>();
	
	@OneToOne 
	@JoinColumn(name="user_id") 
	private User user;
	
	public Cart() {
		
	}
	
	public Cart(User user) {
		this.user=user;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
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
	
	public void clear() {
		this.getProducts().clear();
	}
	
	public int getSize() {
		return this.getProducts().size();
	}

}
