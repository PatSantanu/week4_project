package com.app.dao;

import java.util.List;

import com.app.customer.service.CustomerService;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Product;

public interface CustomerDAO {
	public int createCustomer(Customer customer) throws BusinessException;
	public Customer login(Customer customer) throws BusinessException;
	public List<Product>getProductsByProductName(String productName) throws BusinessException;
	public List<Product>getProductsByProductCatagory(String productCatagory) throws BusinessException;
}
