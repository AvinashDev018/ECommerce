package com.E_Commerce;

class CartItem {
	Product product;
	int Quantity;
	public CartItem(Product prod,int qun) {
		this.product=prod;
		this.Quantity=qun;
	}
	public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }
	public double getTotal() {
		return product.getPrice()*Quantity;
	}
	public String toString() {
		return product.getName() + " x " + Quantity + " = ₹" + getTotal()+"\n";
	}
}

