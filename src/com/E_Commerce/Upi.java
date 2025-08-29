package com.E_Commerce;

class Upi extends Payment{
	public Upi(double amount) { super(amount); }
    
    public void pay() {
        System.out.println("Paid ₹" + amount + " via UPI.");
    }
}
