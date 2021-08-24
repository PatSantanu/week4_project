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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + prod_id;
		result = prime * result + ((productCatagory == null) ? 0 : productCatagory.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(productPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (prod_id != other.prod_id)
			return false;
		if (productCatagory == null) {
			if (other.productCatagory != null)
				return false;
		} else if (!productCatagory.equals(other.productCatagory))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
			return false;
		return true;
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
