package com.app.model;

public class Customer {
	private int c_id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public Customer() {
		
		
	}

	public Customer(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}

	public Customer(String firstName, String lastName, String email, String password) {
		this(email,password);
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
 	

}
