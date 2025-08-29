package com.E_Commerce;

class Customer extends User{
	private Cart cart;
	public Customer(String id,String name,String email,String password) {
		super(id,name,email,password);
		this.cart=new Cart();
	}
	public Cart getCart() {
		return cart;
	}
}