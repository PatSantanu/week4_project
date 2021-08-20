package com.app.model;

public class Product {
	private int prod_id;
	private String productName;
	private String productCatagory;
	private double productPrice;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCatagory() {
		return productCatagory;
	}
	public void setProductCatagory(String productCatagory) {
		this.productCatagory = productCatagory;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [prod_id=" + prod_id + ", productName=" + productName + ", productCatagory=" + productCatagory
				+ ", productPrice=" + productPrice + "]";
	}
	public Product(String productName,String productCatagory,double productPrice) {
		super();
		this.productName=productName;
		this.productCatagory=productCatagory;
		this.productPrice=productPrice;
	}
//	public Product( String productName, String productCatagory, double productPrice) {
//		
//		this(prouctName,productCatagory,productPrice);
//		this.prod_id = prod_id;
//		this.productName = productName;
//		this.productCatagory = productCatagory;
//		this.productPrice = productPrice;
//	}
	

}
