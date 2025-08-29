package com.E_Commerce;

class Card extends Payment{
	public Card(double amount) { super(amount); }
    
    public void pay() {
        System.out.println("Paid ₹" + amount + " via CARD.");
    }
}