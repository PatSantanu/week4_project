package com.app.model;

public class Order {
	private int orderId;
	private int ordcustid;
	private int ordprodid;
	private double orderTotal;
	private String orderStatus;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrdcustid() {
		return ordcustid;
	}

	public void setOrdcustid(int ordcustid) {
		this.ordcustid = ordcustid;
	}

	public int getOrdprodid() {
		return ordprodid;
	}

	public void setOrdprodid(int ordprodid) {
		this.ordprodid = ordprodid;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", ordcustid=" + ordcustid + ", ordprodid=" + ordprodid + ", orderTotal="
				+ orderTotal + ", orderStatus=" + orderStatus + "]";
	}
	public Order(int orderId, int ordcustid, int ordprodid, double orderTotal, String orderStatus) {
		super();
		this.orderId = orderId;
		this.ordcustid = ordcustid;
		this.ordprodid = ordprodid;
		this.orderTotal = orderTotal;
		this.orderStatus = orderStatus;
	}
	
	
	
	
}
