package com.app.customer.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Product;

public interface CustomerService {
	public int createCustomer(Customer customer) throws BusinessException;
	public Customer login(Customer customer) throws BusinessException;
	public List<Product>getProductsByProductName(String productName) throws BusinessException;
	public int addProduct(Product product)throws BusinessException;
	public List<Product>getProductsByProductCatagory(String productCatagory) throws BusinessException;
	

}
