package com.app.customer.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customer;
import com.app.model.Product;

public interface CustomerService {
	public int createCustomer(Customer customer) throws BusinessException;
	public int login(Customer customer) throws BusinessException;
	public List<Product>getProductsByProductName(String productName) throws BusinessException;
	public int addProduct(Product product)throws BusinessException;
	public List<Product>getProductsByProductCatagory(String productCatagory) throws BusinessException;
	public Customer getCustomerByCustomerId( int c_id) throws BusinessException;
	public Product getProductByProductId(int productId) throws BusinessException;
	public int addProductToCart(Cart cart) throws BusinessException;
	public Customer getCustomerByEmailId(String email) throws BusinessException;
	public Cart viewCart(int customerId) throws BusinessException;
	public boolean isValidCustomerEmailId(String customerUsername) throws BusinessException; 
	public boolean isValidCustomerPassword(String customerPassword) throws BusinessException;
}
