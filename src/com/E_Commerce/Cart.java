package com.E_Commerce;

import java.util.ArrayList;
import java.util.List;

class Cart {
	private List<CartItem> items=new ArrayList<>();
	public void addItems(Product product,int qun) {
		if(qun<=product.getQun()) {
			items.add(new CartItem(product,qun));
		}
		else {
			System.out.println("Available Stock is :"+product.getQun());
		}
	}
	public void removeItem(String ProdId) {
		for(CartItem i:items) {
			if(i.product.getId()==ProdId) {
				items.remove(i);
			}
		}
	}
	public void viewCart() {
		if(items.isEmpty()) System.out.println("No Cart Available");
		for(CartItem i:items) {
			System.out.print(i);
		}
	}
	public double getTotal() {
		double sum=0.0;
		for(CartItem i:items) {
			sum+=i.getTotal();
		}
		return sum;
	}
}

