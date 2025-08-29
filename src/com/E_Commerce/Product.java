package com.E_Commerce;

class Product {
	private  String id;
	private String name,catagory;
	private double price;
	private int Quantity;
	public Product(String id,String name,double price,String catagory,int Quantity) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.catagory=catagory;
		this.Quantity=Quantity;
	
	}
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public double getPrice(){
		return price;
	}
	public int getQun(){
		return Quantity;
	}
	public void setQun(int qun){
		this.Quantity=qun;
	}
	public String toString() {
		return " "+id+" | "+name+" | "+catagory+" | ₹"+price+" |  Stock: "+Quantity+"\n";
	}
}


