package com.E_Commerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ECommercePlatForm {
	private List<Product> product=new ArrayList<>();
	private List<User> user=new ArrayList<>();
	private Map<String,Cart> cart=new HashMap<>();
	public void addProd(Product p) {
		for (Product prod : product) {
	        if (prod.getId().equals(p.getId())) {
	            System.out.println("❌ Product ID already exists! Use a different ID.");
	            return;
	        }
	    }
		product.add(p);
		System.out.println("✅ Product added successfully!");
	}
	public void view() {
		if(product.isEmpty()) System.out.print("No Product Aailable");
		for(Product i:product) {
			System.out.print(i);
		}
	}
	public void registerUser(User u) {
		 for (User existing : user) {
		        if (existing.getEmail().equals(u.getEmail()) || existing.getId().equals(u.getId())) {
		            System.out.println("❌ Already exists!");
		            return;
		        }
		    }
        user.add(u);
        if (u instanceof Customer) cart.put(u.getEmail(), ((Customer)u).getCart());
        System.out.println("✅ Customer Registered.");
    }
	public User login(String email, String password) {
	    for (User u : user) {
	        if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
	            return u; 
	        }
	    }
	    return null; 
    }

	 public Product findProduct(String id) {
	        for (Product p : product) {
	            if (p.getId().equals(id)) return p;
	        }
	        return null;
	    }
	 public void checkout(Customer c, String method) {
	        Cart cart = c.getCart();
	        double total = cart.getTotal();
	        Payment payment = method.equalsIgnoreCase("upi")
	                ? new Upi(total)
	                : new Card(total);
	        payment.pay();
	        System.out.println("Order placed successfully!");
	    }
}