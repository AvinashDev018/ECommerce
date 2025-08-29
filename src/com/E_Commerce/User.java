package com.E_Commerce;

abstract class User {
	protected String id,name,email,password;
	public User(String id,String name,String email,String password) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.password=password;
	}
	public String getId() {
		return id;
	}
	public String getEmail() { 
		return email; 
	}
    public String getPassword() { 
    	return password;
    }
}

