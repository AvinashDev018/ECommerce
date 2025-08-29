package com.E_Commerce;

abstract class Payment {
	protected double amount;
	public Payment(double amount) {
		this.amount=amount;
	}
	public abstract void pay();
}
