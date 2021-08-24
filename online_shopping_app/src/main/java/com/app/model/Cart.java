package com.app.model;

public class Cart {
	private int cartid;
	private int quantity;
	private int cartcustid;
	private int cartprodid;
	private double price;
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCartcustid() {
		return cartcustid;
	}
	public void setCartcustid(int cartcustid) {
		this.cartcustid = cartcustid;
	}
	public int getCartprodid() {
		return cartprodid;
	}
	public void setCartprodid(int cartprodid) {
		this.cartprodid = cartprodid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", quantity=" + quantity + ", cartcustid=" + cartcustid + ", cartprodid="
				+ cartprodid + ", price=" + price + "]";
	}
	public Cart() {
		
	}
	
	
	
}
