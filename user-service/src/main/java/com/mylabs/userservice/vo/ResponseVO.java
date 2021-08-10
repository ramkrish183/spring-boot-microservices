package com.mylabs.userservice.vo;

import com.mylabs.userservice.entity.User;

public class ResponseVO {

	private User user;
	private Product product;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
